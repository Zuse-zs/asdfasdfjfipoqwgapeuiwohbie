package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Index extends JFrame implements ActionListener{


    JPanel panel = new JPanel(new GridLayout(1, 1));
    JPanel p = new JPanel(new GridLayout(1, 1));
    /* 创建一个菜单栏 */
    JMenuBar menuBar = new JMenuBar();
    /* 创建一级菜单 */
    JMenu fileMenu = new JMenu("文件");
    /* 创建 "文件" 一级菜单的子菜单 */
    JMenuItem newMenuItem = new JMenuItem("菜单项1");
    JMenuItem openMenuItem = new JMenuItem("菜单项2");



    public Index() {
        super("登录入口");/* 窗口标题  */
        this.setLayout(new GridLayout(1, 1));


        /* 一级菜单添加到菜单栏 */
        menuBar.add(fileMenu);
        /* 子菜单添加到一级菜单 */
        newMenuItem.addActionListener(this);
        openMenuItem.addActionListener(this);
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.addSeparator();/* 添加一条分割线 */



        JLabel label = new JLabel("666666666666666666");
        label.setFont(new Font(null, Font.PLAIN, 50));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        p.add(label);


        p.setBorder(BorderFactory.createLineBorder(Color.cyan, 3));
        panel.setBorder(BorderFactory.createLineBorder(Color.red, 3));
        panel.add(p);
        this.add(panel);
        this.setJMenuBar(menuBar);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/* 关闭方式  */
        this.setSize(1000, 650);/* 窗口大小  */
        this.setLocationRelativeTo(null);/* 窗口居中  */
        this.setResizable(false);/* 固定窗口  */
        this.setVisible(true);/* 窗口可见性  */
    }


    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(newMenuItem)) {
                p.removeAll();
                panel.removeAll();
                p = new $1();
                panel.add(p);
                panel.validate();
                panel.repaint();
                panel.revalidate();
                panel.setVisible(true);
            }
    }
}
