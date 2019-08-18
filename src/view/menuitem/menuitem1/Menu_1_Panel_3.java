package view.menuitem.menuitem1;

import view.common.zs_JPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu_1_Panel_3  extends zs_JPanel implements ActionListener {

    CanvasJPanel canvas;
    JButton jButton;

    /* 创建一个面板，面板中心显示一个标签，用于表示某个选项卡需要显示的内容 */
    public JComponent getJPanel(JFrame jf) {
        /* 创建面板, 使用一个 1 行 1 列的网格布局（为了让标签的宽高自动撑满面板）  */
        this.setLayout(null);
        /* 创建标签  */
        JLabel label = new JLabel("画板");
        label.setFont(new Font(null, Font.PLAIN, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(30,20,300,40);/* 设置位置 */
        label.setBorder(BorderFactory.createLineBorder(Color.red));/* 边框 */

        /*  */
        canvas = new CanvasJPanel();
        canvas.setBounds(10,70,700,500);/* 设置位置 */
        canvas.setBorder(BorderFactory.createLineBorder(Color.red));/* 边框 */
        canvas.setBackground(Color.BLACK);
        canvas.addMouseMotionListener(canvas);


        jButton = new JButton("清空画布");
        jButton.setFont(new Font(null, Font.PLAIN, 20));
        jButton.setHorizontalAlignment(SwingConstants.CENTER);
        jButton.setBounds(430,20,200,40);/* 设置位置 */
        jButton.addActionListener(this);

        /* 添加标签到面板  */
        this.add(label);
        this.add(canvas);
        this.add(jButton);
        return this;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(jButton)) {
            Graphics2D g2 = (Graphics2D)canvas.getGraphics();
            g2.setBackground(Color.WHITE);//设置背景色
            g2.clearRect(0, 0, 1000, 600);//通过使用当前绘图表面的背景色进行填充来清除指定的矩形。
        }
    }


}
class CanvasJPanel extends JPanel implements MouseMotionListener{

    int x,y;

    boolean b = true;

    @Override
    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        if(b){
            g2.setBackground(Color.WHITE);//设置背景色
            g2.clearRect(0, 0, 1000, 600);//通过使用当前绘图表面的背景色进行填充来清除指定的矩形。
            b = false;

        }
        g2.setColor(Color.red);
        g2.drawOval(x,y,10,10);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println(x+"---"+y);
        //获取鼠标的当前坐标
        x = e.getX();
        y = e.getY();
        //重画、repaint()触发paint()
        this.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}