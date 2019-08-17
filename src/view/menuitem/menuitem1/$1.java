package view.menuitem.menuitem1;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/* 一个内容面板  */
public class $1{


    public JPanel getJPanel() {
        JPanel jPanel = new JPanel();
        /* 创建选项卡面板  */
        JTabbedPane jTabbedPane = new JTabbedPane();

        /* 创建  选项卡（选项卡包含 标题、图标 和 tip提示）  */
        jTabbedPane.addTab("选项卡a", null, temporaryCreateJPanel(""), "提示");
        jTabbedPane.addTab("选项卡b", null, temporaryCreateJPanel(""), "提示");
        jTabbedPane.addTab("选项卡c", null, temporaryCreateJPanel(""), "提示");
        jTabbedPane.addTab("选项卡d", null, temporaryCreateJPanel(""), "提示");


        /* 添加选项卡选中状态改变的监听器  */
        jTabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                switch (jTabbedPane.getSelectedIndex()){
                    case 0:
                        jTabbedPane.setComponentAt(jTabbedPane.getSelectedIndex(), new Menu_1_Panel_1().getJPanel(null));
                        break;
                    case 1:
                        jTabbedPane.setComponentAt(jTabbedPane.getSelectedIndex(), new Menu_1_Panel_2().getJPanel("666"));
                        break;
                    case 2:
                        jTabbedPane.setComponentAt(jTabbedPane.getSelectedIndex(), new Menu_1_Panel_3().getJPanel("666"));
                        break;
                    case 3:
                        jTabbedPane.setComponentAt(jTabbedPane.getSelectedIndex(), new Menu_1_Panel_4().getJPanel("666"));
                        break;
                    case 4:
                        break;
                }
            }
        });


        /* 设置默认选中的选项卡  */
//        选项卡.setSelectedIndex(0);
        /*如果选项卡太多，可以选择他们的显示方式，隐藏或者滚动*/
//        选项卡.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);/*换行选项卡布局*/
        jTabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);/*滚动选项卡布局*/
        jPanel.add(jTabbedPane);
        jPanel.setLayout(new GridLayout(1, 1));/*一行一列的面板布局，面板全部都是选项卡*/
        jPanel.setVisible(true);/*可见*/
        return jPanel;
    }



    private static JComponent temporaryCreateJPanel(String text) {
        JPanel panel = new JPanel(new GridLayout(1, 1));
        JLabel label = new JLabel(text);
        label.setFont(new Font(null, Font.PLAIN, 50));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);
        return panel;
    }
}
