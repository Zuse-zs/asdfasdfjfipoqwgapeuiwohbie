package view.menuitem.menuitem1;

import javax.swing.*;
import java.awt.*;

public class 菜单1面板4 {


    /* 创建一个面板，面板中心显示一个标签，用于表示某个选项卡需要显示的内容 */
    public static JComponent getJPanel(String text) {
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
