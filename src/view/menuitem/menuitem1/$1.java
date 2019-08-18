package view.menuitem.menuitem1;

import view.common.zs_JPanel;
import view.reSizeEvent;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/* 一个内容面板  先继承一下  实现一下不用每个监听事件写一大堆代码       */
public class $1 extends zs_JPanel{


    public JPanel getJPanel(JFrame jf) {
        /* 创建选项卡面板  */
        JTabbedPane jTabbedPane = new JTabbedPane();

        /* 创建  选项卡（选项卡包含 标题、图标 和 tip提示）  */
        jTabbedPane.addTab("选项卡a", null, temporaryCreateJPanel(""), "提示");
        jTabbedPane.addTab("图片读取生成", null, temporaryCreateJPanel(""), "提示");
        jTabbedPane.addTab("选项卡c", null, temporaryCreateJPanel(""), "提示");
        jTabbedPane.addTab("选项卡d", null, temporaryCreateJPanel(""), "提示");

        /* 添加选项卡选中状态改变的监听器  */
        jTabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                switch (jTabbedPane.getSelectedIndex()){
                    case 0:
                        jTabbedPane.setComponentAt(jTabbedPane.getSelectedIndex(), new Menu_1_Panel_1().getJPanel(jf));
                        break;
                    case 1:
                        jTabbedPane.setComponentAt(jTabbedPane.getSelectedIndex(), new Menu_1_Panel_2().getJPanel(jf));
                        break;
                    case 2:
                        jTabbedPane.setComponentAt(jTabbedPane.getSelectedIndex(), new Menu_1_Panel_3().getJPanel(jf));
                        break;
                    case 3:
                        jTabbedPane.setComponentAt(jTabbedPane.getSelectedIndex(), new Menu_1_Panel_4().getJPanel(jf));
                        break;
                    case 4:
                        break;
                }
            }
        });



        reSizeEvent dg = new reSizeEvent(jf);
        /* 添加两个监听器，都是鼠标的不能缺少不然影响拖动移动 */
        this.addMouseListener(dg);
        this.addMouseMotionListener(dg);
        /* 设置默认选中的选项卡  */
//        选项卡.setSelectedIndex(0);
        /*如果选项卡太多，可以选择他们的显示方式，隐藏或者滚动*/
//        选项卡.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);/*换行选项卡布局*/
        jTabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);/*滚动选项卡布局*/
        this.add(jTabbedPane);
        this.setLayout(new GridLayout(1, 1));/*一行一列的面板布局，面板全部都是选项卡*/
        this.setVisible(true);/*可见*/
        return this;
    }



    /* 临时填充面板使用 */
    private static JComponent temporaryCreateJPanel(String text) {
        JPanel panel = new JPanel(new GridLayout(1, 1));
        JLabel label = new JLabel(text);
        label.setFont(new Font(null, Font.PLAIN, 50));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);
        return panel;
    }
}
