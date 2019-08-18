package view.menuitem.menuitem1;

import org.fusesource.jansi.Ansi;
import view.common.zs_JPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.fusesource.jansi.Ansi.ansi;

public class Menu_1_Panel_1  extends zs_JPanel implements ActionListener {


    /* 创建一个面板，面板中心显示一个标签，用于表示某个选项卡需要显示的内容 */
    public static JComponent getJPanel(JFrame jf) {
        /* 创建面板, 使用一个 1 行 1 列的网格布局（为了让标签的宽高自动撑满面板）  */
        JPanel panel = new JPanel(new GridLayout(1, 1));
        JLabel label = new JLabel("1111111111111");
        label.setFont(new Font(null, Font.PLAIN, 50));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        /* 添加标签到面板  */
        panel.add(label);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


}
