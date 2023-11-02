package it.unibs.pajc;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.EventQueue;

public class PlotApp extends JFrame {

    private PnlPlotFunction MainPanel = new PnlPlotFunction();

    public PlotApp() {
        setTitle("Title");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        add(MainPanel);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PlotApp frame = new PlotApp();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
