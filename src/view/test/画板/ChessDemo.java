package view.test.画板;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 * @author Hardneedl
 */
final class ChessDemo extends JFrame {
    public String getTitle() {return "ChessDemo";}
    static private final Dimension size = new Dimension(600,400);
    public Dimension getPreferredSize() {return size;}
    public Dimension getMaximumSize() {return size;}
    public Dimension getMinimumSize() {return size;}
    public Dimension getSize(){return size;}

    /**
     * 画笔
     */
    private abstract class Brush implements java.util.Observer {
        abstract void paint(Graphics g);
    }

    /**
     * 画布
     */
    private abstract class MyCanvas extends JComponent{
        abstract Brush getBrush();

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Brush brush = getBrush();
            if (brush!=null)
                brush.paint(g);
        }
    }

    private class ChessBrush extends Brush{
        private Color frontColor = Color.MAGENTA;
        private int lineWeight = 1;
        public void update(Observable o, Object arg) {
            //通知更改前景色
            if (arg instanceof Color) {
                frontColor = (Color)arg;
            }

            //通知更改线粗
            if (arg instanceof Integer) {
                lineWeight += (Integer)arg;

                //防止线粗参数非法
                lineWeight = lineWeight <= 0 ? 1 : lineWeight;
            }
        }

        void paint(Graphics g) {
            //创建绘图环境的副本
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setStroke(new BasicStroke(lineWeight <= 0? 1 : lineWeight));
            g2.setColor(frontColor);
            //画水平线
            for (int i = 0; i < 550; i+= 20) g2.drawLine(i, 0, i, 300);

            //画垂直线
            for (int i = 0; i < 550; i+= 20) g2.drawLine(0, i, 300, i);

            //释放绘图环境的副本
            g2.dispose();
        }
    }

    ChessDemo() throws HeadlessException {
        init();
        attachListeners();
        doLay();
    }

    private MyCanvas canvas;

    final private Observable observable = new Observable(){
        public void notifyObservers(Object arg) {
            setChanged();
            super.notifyObservers(arg);
        }
    };

    private void init(){
        final Brush brush = new ChessBrush();

        //画笔被加进到观察者
        observable.addObserver(brush);

        canvas = new MyCanvas() {
            Brush getBrush() {
                return brush;
            }
        };

        //画板被加进到观察者用来重绘
        observable.addObserver(new Observer() {
            public void update(Observable o, Object arg) {
                canvas.repaint();
            }
        });
    }

    private void attachListeners(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void doLay(){
        Container container = getContentPane();
        container.add(canvas,BorderLayout.CENTER);

        final JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JButton(new ChangeColorAction("CYAN",Color.CYAN)));
        buttonPanel.add(new JButton(new ChangeColorAction("ORANGE",Color.ORANGE)));
        buttonPanel.add(new JButton(new ChangeColorAction("RED",Color.RED)));
        buttonPanel.add(new JButton(new ChangeLineAction(1)));
        buttonPanel.add(new JButton(new ChangeLineAction(-1)));

        container.add(buttonPanel,BorderLayout.NORTH);

        pack();
        setVisible(true);
    }

    private class ChangeLineAction extends AbstractAction{
        private int delta=0;
        private ChangeLineAction(int delta) {
            super("线粗" +  ( (delta < 0) ? "减少 ":"增大 " ) + Math.abs(delta) );
            this.delta = delta;
        }

        public void actionPerformed(ActionEvent e) {
            observable.notifyObservers(delta);
            //canvas.repaint();
        }
    }

    private class ChangeColorAction extends AbstractAction{
        private Color c;
        private ChangeColorAction(String t,Color c) {
            super(t);
            this.c=c;
        }

        public void actionPerformed(ActionEvent e) {
            observable.notifyObservers(c);
            //canvas.repaint();
        }
    }


    public static void main(String... args) {
        System.setProperty("swing.defaultlaf","com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        SwingUtilities.invokeLater(
                new Runnable(){
                    public void run() {
                        new ChessDemo();
                    }
                }
        );
    }
}