package view;

import view.menuitem.menuitem1.$1;
import view.menuitem.menuitem2.$2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Index extends JFrame implements ActionListener{


    /* 放在顶级容器的面板 */
    JPanel p = new JPanel(new GridLayout(1, 1));
    /* 创建一个菜单栏组件 */
    JMenuBar menuBar = new JMenuBar();
    /* 创建一级菜单组件 */
    JMenu fileMenu = new JMenu("菜单");
    /* 创建 菜单项组件 */
    JMenuItem newMenuItem = new JMenuItem("菜单项1");
    JMenuItem openMenuItem = new JMenuItem("菜单项2");



    public Index() {
        /* 窗口标题  */
        super("首页");
        /* 容器布局  1行1列  */
        this.setLayout(new GridLayout(1, 1));


        /* 一级菜单添加到菜单栏 */
        menuBar.add(fileMenu);
        /* 子级菜单添加监听事件 */
        newMenuItem.addActionListener(this);
        openMenuItem.addActionListener(this);
        /* 子菜单添加到一级菜单 */
        fileMenu.add(newMenuItem);
        /* 添加一条分割线 */
        fileMenu.addSeparator();
        /* 子菜单添加到一级菜单 */
        fileMenu.add(openMenuItem);



        /* 组件 */
        JLabel label = new JLabel("武器库");
        label.setFont(new Font(null, Font.PLAIN, 50));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        p.add(label);



        /* 将 面板 加入顶级容器 */
        this.add(p);
        /* 将 菜单 加入顶级容器 */
        this.setJMenuBar(menuBar);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/* 关闭方式  */
        this.setSize(1000, 650);/* 窗口大小  */
        this.setLocationRelativeTo(null);/* 窗口居中  */
        this.setResizable(false);/* 固定窗口  */
        this.setVisible(true);/* 窗口可见性  */
    }

    /* 监听菜单点击  移除覆盖刷新 面板   */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(newMenuItem)) {
            p.removeAll();
            p.add(new $1().getJPanel());
            p.validate();
            p.repaint();
            setVisible(true);
        }
        if (e.getSource().equals(openMenuItem)) {
            p.removeAll();
            p.add(new $2().getJPanel());
            p.validate();
            p.repaint();
            setVisible(true);
        }
    }
}
