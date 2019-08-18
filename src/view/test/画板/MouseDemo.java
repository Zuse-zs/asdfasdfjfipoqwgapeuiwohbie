package view.test.画板;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseDemo extends JFrame implements MouseMotionListener
{
    public static void main(String[] args)
    {
        MouseDemo mouseDemo = new MouseDemo();
        mouseDemo.setVisible(true);
    }
    //
    private JPanel p;
    int x, y;
    public MouseDemo()
    {
        super("画板");
        p = new JPanel();
        //注册鼠标监听
        p.addMouseMotionListener(this);
//    p.add(new JButton("画图"));
        this.add(p);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);

        this.setLocation(0, 0);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    //重写JFrame的paint()方法、此方法用于在窗体中画图
    public void paint(Graphics g)
    {
        g.setColor(Color.BLUE);

        //画一个实心圆

        g.fillOval(x, y, 5, 5);

    }



    //鼠标拖动的处理方法

    public void mouseDragged(MouseEvent e)

    {

        //获取鼠标的当前坐标

        x = e.getX();

        y = e.getY();

        //重画、repaint()触发paint()

        this.repaint();

    }

    //鼠标移动的处理方法

    public void mouseMoved(MouseEvent e)

    {



    }



}