package view.menuitem.menuitem2;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/* 一个内容面板  */
public class $2 {


    public JPanel getJPanel() {
        JPanel jPanel = new JPanel();
        /* 创建选项卡面板  */
        JTabbedPane tabbedPane = new JTabbedPane();

        /* 创建  选项卡（选项卡包含 标题、图标 和 tip提示）  */
        tabbedPane.addTab("选项卡", null, createTextPanel("选项卡1"), "提示");
        tabbedPane.addTab("选项卡", null, createTextPanel("选项卡2"), "提示");
        tabbedPane.addTab("选项卡", null, createTextPanel("选项卡3"), "提示");
        tabbedPane.addTab("选项卡", null, createTextPanel("选项卡"), "提示");
        tabbedPane.addTab("选项卡", null, createTextPanel("选项卡"), "提示");
        tabbedPane.addTab("选项卡", null, createTextPanel("选项卡"), "提示");
        tabbedPane.addTab("选项卡", null, createTextPanel("选项卡"), "提示");


        /* 添加选项卡选中状态改变的监听器  */
        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("当前选中的选项卡: " + tabbedPane.getSelectedIndex());
            }
        });


        /* 设置默认选中的选项卡  */
        tabbedPane.setSelectedIndex(0);
        jPanel.add(tabbedPane);
        jPanel.setLayout(new GridLayout(1, 1));
        jPanel.setVisible(true);
        return jPanel;
    }


    /* 创建一个面板，面板中心显示一个标签，用于表示某个选项卡需要显示的内容 */
    private static JComponent createTextPanel(String text) {
        /* 创建面板, 使用一个 1 行 1 列的网格布局（为了让标签的宽高自动撑满面板）  */
        JPanel panel = new JPanel(new GridLayout(1, 1));
        /* 创建标签  */
        JLabel label = new JLabel(text);
        label.setFont(new Font(null, Font.PLAIN, 50));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        /* 添加标签到面板  */
        panel.add(label);
        return panel;
    }
}
