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

public class Menu_1_Panel_2  extends zs_JPanel implements ActionListener {


    /* 创建一个面板，面板中心显示一个标签，用于表示某个选项卡需要显示的内容 */
    public static JComponent getJPanel(JFrame jf) {
        /* 创建面板, 使用一个 1 行 1 列的网格布局（为了让标签的宽高自动撑满面板）  */
        JPanel panel = new JPanel();
        panel.setLayout(null);/* 设置布局为空 */


        /* 控制台简易输出图片 */
        BufferedImage bimg = null;
        try {
            bimg = ImageIO.read(new File("img/zs.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("宽:["+bimg.getWidth()+"]高:["+bimg.getHeight()+"]");
        int [][] data = new int[bimg.getWidth()][bimg.getHeight()];
        //方式一：通过getRGB()方式获得像素矩阵
        //此方式为沿Height方向扫描
        for(int j=0;j<bimg.getWidth();j++){
            for(int i=0;i<bimg.getHeight();i++){
                data[i][j]=bimg.getRGB(i,j);
                //输出一列数据比对
                System.out.print(" "+ansi().eraseScreen().fg(putColor(Integer.toHexString(data[i][j]))).a("■").reset());
            }
            System.out.println();
        }


        /* 读取生成图片 */
        BufferedImage image = new BufferedImage(data.length, 50, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < data.length; x++) {
            for (int y = 0; y < data[x].length; y++) {
                image.setRGB(x, y, data[x][y]);
            }
        }
        ImageIcon icon = new ImageIcon(image);
        /* 创建标签  */
        JLabel label = new JLabel(icon);
        label.setBounds(350,200,100,100);/* 设置位置 */
        label.setBorder(BorderFactory.createLineBorder(Color.red));/* 边框 */
        label.setFont(new Font(null, Font.PLAIN, 50));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        /* 添加标签到面板  */
        panel.add(label);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    /* 我手写的针对控制台输出使用的颜色阈值 */
    public static Ansi.Color putColor(String RGB){
        long rgb1 = Long.parseLong(RGB.substring(0,2), 16);
        long rgb2 = Long.parseLong(RGB.substring(2,4), 16);
        long rgb3 = Long.parseLong(RGB.substring(4,6), 16);
        if(rgb1<85 && rgb2<85 &&rgb3<85){
            return Ansi.Color.BLACK;
        }else if(rgb1>170 && rgb2<85 && rgb3<85){
            return Ansi.Color.RED;
        }else if(rgb1<85 && rgb2>100 && rgb3<85){
            return Ansi.Color.GREEN;
        }else if(rgb1>170 && rgb2>170 && rgb3<100){
            return Ansi.Color.YELLOW;
        }else if(rgb1<85 && rgb2<85 && rgb3<100){
            return Ansi.Color.BLUE;
        }else if(rgb1>120 && rgb2<120 && rgb3>120){
            return Ansi.Color.MAGENTA;
        }else{
            return Ansi.Color.CYAN;
        }
    }
}
