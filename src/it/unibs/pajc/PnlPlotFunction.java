package it.unibs.pajc;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleUnaryOperator;

import javax.swing.JPanel;

public class PnlPlotFunction extends JPanel {

    private static final long serialVersionUID = 1L;

    /**
     * Create the panel.
     */
    public PnlPlotFunction() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();
        int s = Math.min(w, h);

        g2.translate(w/2., h/2.);
        g2.scale(w/20., -h/4.);

        setStrokeSize(g2, 2);

        g2.drawLine(-10, 0, 10, 0);
        g2.drawLine(0,-2,0,2);

        g2.setColor(Color.blue);
        Path2D path = new Path2D.Double();
        path.moveTo(-10., Math.sin(-10.));

        drawFunction(g2, -10, 10, 0.05, Math::sin);

    }

    protected void drawFunction(Graphics2D g2, double xmin, double xmax, double dx, DoubleUnaryOperator function){
        Path2D path = new Path2D.Double();
        path.moveTo(xmin+dx, function.applyAsDouble(xmin+dx));
        for (double x = xmin + dx; x <= xmax; x+=dx) {
            path.lineTo(x, function.applyAsDouble(x));
        }
        g2.draw(path);
    }

    protected void setStrokeSize(Graphics2D g2, int sizeInPixel){
        AffineTransform t = g2.getTransform();

        float pixelSize = (float)(1./Math.sqrt(Math.abs(t.getScaleX() * t.getScaleY())));
        g2.setStroke(new BasicStroke(sizeInPixel * pixelSize));
    }

}
