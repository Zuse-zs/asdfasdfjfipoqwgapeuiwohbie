package view.test.图片生成;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Hashtable;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingTestImg  extends JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel label;
    private Icon icon;
    private Image image;

    public static void main(String[] args) {
        new SwingTestImg();
    }

    public SwingTestImg() {
        try {
            setTitle("测试图片简单显示");
            setSize(300, 300);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            label = new JLabel();
            add(label);
            setVisible(true);


//            //A：网路URL图片
			icon = new ImageIcon(new URL("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1244367615,2028532212&fm=26&gp=0.jpg"));


//            //B：项目目录下图片
//			InputStream is = SwingTestImg.class.getResourceAsStream("zs.jpg");
//			ByteArrayOutputStream baos = new ByteArrayOutputStream();
//			byte [] buff = new byte[100];
//			int readCount = 0;
//			while((readCount = is.read(buff,0,100)) > 0){
//				baos.write(buff,0,readCount);
//			}
//			byte [] inbyte = baos.toByteArray();
//			icon =  new ImageIcon(inbyte);



//			//C：本地磁盘图片，图片太大，会导致空白显示
//			image =  new ImageIcon("E:/zs.jpg").getImage();

        } catch (Exception e) {
            System.out.println("初始化失败" + e.getMessage());
            e.printStackTrace();
        }
        label.setIcon(icon);
//		label.setIcon(new ImageIcon(image));
    }
}