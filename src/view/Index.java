package view;

import com.sun.awt.AWTUtilities;
import view.menuitem.menuitem1.$1;
import view.menuitem.menuitem2.$2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

public class Index extends JFrame implements ActionListener{


    /* 放在顶级容器的面板 */
    JPanel p = new JPanel(new GridLayout(1, 1));
    /* 创建一个菜单栏组件 */
    JMenuBar menuBar = new JMenuBar();
    /* 创建一级菜单组件 */
    JMenu fileMenu = new JMenu("菜单");
    JMenu exitMenu = new JMenu("✕");
    /* 创建 菜单项组件 */
    JMenuItem newMenuItem = new JMenuItem("菜单项1");
    JMenuItem openMenuItem = new JMenuItem("菜单项2");
    /* 恶搞 */
    boolean b = true;

    public Index() {
        /* 窗口标题  */
        super("武器库");
        /* 容器布局  1行1列  */
        this.setLayout(new GridLayout(1, 1));
        ImageIcon ico=new ImageIcon("img/ico.png");/* 图标 */
        this.setIconImage(ico.getImage());


        fileMenu.setPreferredSize(new Dimension(100,30));
        menuBar.setBorder(BorderFactory.createLineBorder(Color.black));/* 边框 */

        /* 一级菜单添加到菜单栏 */
        menuBar.add(fileMenu);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(exitMenu);
        /* 监听事件 */
        exitMenu.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);/* 隐藏窗口 */
                if(b){
                    try {
                        Thread.sleep(3000);/* 3秒吧~ */
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    setVisible(true);/* 显示窗口 */
                    JOptionPane.showMessageDialog(null, "我又出来了！3秒过后我又是一条好汉~", "哈哈", JOptionPane.ERROR_MESSAGE);
                    b = false;

                    try {
                        Thread.sleep(3000);/* 3秒吧~ */
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    System.exit(0);/* 结束程序 */

                }else {
                    System.exit(0);/* 结束程序 */
                }
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });

        /* 子级菜单添加监听事件 */
        newMenuItem.addActionListener(this);
        openMenuItem.addActionListener(this);
        newMenuItem.setPreferredSize(new Dimension(100,30));
        openMenuItem.setPreferredSize(new Dimension(100,30));
        /* 子菜单添加到一级菜单 */
        fileMenu.add(newMenuItem);
        /* 添加一条分割线 */
        fileMenu.addSeparator();
        /* 子菜单添加到一级菜单 */
        fileMenu.add(openMenuItem);


        ImageIcon img = new ImageIcon("img/thanos.jpg");//这是背景图片
        img.setImage(img.getImage().getScaledInstance(1000, 650,
                Image.SCALE_DEFAULT));
        /* 组件 */
        JLabel label = new JLabel(img);
        label.setFont(new Font(null, Font.PLAIN, 50));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createLineBorder(Color.black));/* 边框 */
        p.add(label);


        /* 将 面板 加入顶级容器 */
        this.add(p);
        /* 将 菜单 加入顶级容器 */
        this.setJMenuBar(menuBar);

        JOptionPane.showMessageDialog(null, "三击 灭霸/菜单栏  关闭程序奥。", "提示", JOptionPane.WARNING_MESSAGE);

        /* 透明度 */
        this.setUndecorated(true);
        AWTUtilities.setWindowOpacity(this, 80 / 100f);/* 透明值 1~100 */

        reSizeEvent dg = new reSizeEvent(this);
        /* 添加两个监听器，都是鼠标的不能缺少不然影响拖动移动 */
        this.addMouseListener(dg);
        this.addMouseMotionListener(dg);
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
            p.add(new $1().getJPanel(this));
            p.validate();
            p.repaint();
            setVisible(true);
        }
        if (e.getSource().equals(openMenuItem)) {
            p.removeAll();
            p.add(new $2().getJPanel(this));
            p.validate();
            p.repaint();
            setVisible(true);
        }
    }

}
