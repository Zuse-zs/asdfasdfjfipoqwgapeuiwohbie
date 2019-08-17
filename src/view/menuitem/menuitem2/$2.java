package view.menuitem.menuitem2;

import view.common.zs_JPanel;
import view.reSizeEvent;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* 一个内容面板  */
public class $2  extends zs_JPanel implements ActionListener {

    public JPanel getJPanel(JFrame jf) {
        JPanel jPanel = new JPanel();
        /* 创建选项卡面板  */
        JTabbedPane tabbedPane = new JTabbedPane();

        /* 创建  选项卡（选项卡包含 标题、图标 和 tip提示）  */
        tabbedPane.addTab("选项卡", null, temporaryCreateJPanel("选项卡1"), "提示");
        tabbedPane.addTab("选项卡", null, temporaryCreateJPanel("选项卡2"), "提示");
        tabbedPane.addTab("选项卡", null, temporaryCreateJPanel("选项卡3"), "提示");
        tabbedPane.addTab("选项卡", null, temporaryCreateJPanel("选项卡"), "提示");
        tabbedPane.addTab("选项卡", null, temporaryCreateJPanel("选项卡"), "提示");
        tabbedPane.addTab("选项卡", null, temporaryCreateJPanel("选项卡"), "提示");
        tabbedPane.addTab("选项卡", null, temporaryCreateJPanel("选项卡"), "提示");


        /* 添加选项卡选中状态改变的监听器  */
        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("当前选中的选项卡: " + tabbedPane.getSelectedIndex());
            }
        });


        reSizeEvent dg = new reSizeEvent(jf);
        /* 添加两个监听器，都是鼠标的不能缺少不然影响拖动移动 */
        this.addMouseListener(dg);
        this.addMouseMotionListener(dg);
        /* 设置默认选中的选项卡  */
        tabbedPane.setSelectedIndex(0);
        jPanel.add(tabbedPane);
        jPanel.setLayout(new GridLayout(1, 1));
        jPanel.setVisible(true);
        return jPanel;
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


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
