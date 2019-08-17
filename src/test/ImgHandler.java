package test;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

public final class ImgHandler {

    public static void main(String [] args){
        getData("img/3_10x10.jpg");
        getData("img/6_10x10.jpg");
        getData("img/2x2_1.jpg");

        System.out.println("Hello \u001b[31m red \u001b[0m");
        /* "BLACK", "RED", "GREEN", "YELLOW", "BLUE", "MAGENTA", "CYAN", "WHITE" */
        System.out.print( ansi().eraseScreen().fg(BLACK).a("■").reset());
        System.out.print( ansi().eraseScreen().fg(RED).a("■").reset());
        System.out.print( ansi().eraseScreen().fg(GREEN).a("■").reset());
        System.out.print( ansi().eraseScreen().fg(YELLOW).a("■").reset());
        System.out.print( ansi().eraseScreen().fg(BLUE).a("■").reset());
        System.out.print( ansi().eraseScreen().fg(MAGENTA).a("■").reset());
        System.out.print( ansi().eraseScreen().fg(CYAN).a("■").reset());
        System.out.print( ansi().eraseScreen().fg(WHITE).a("■").reset());
        System.out.println();
        System.out.println(ansi().eraseScreen().fg(RED).a("测试不加reset()"));
        System.out.println("测试不加reset()");

        getData("img/zs.jpg");
    }






    public static void getData(String path){
        try{
            BufferedImage bimg = ImageIO.read(new File(path));
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




//            //方式二：通过getPixels()方式获得像素矩阵
//            Raster raster = bimg.getData();
//            int [] temp = new int[raster.getWidth()*raster.getHeight()*raster.getNumBands()];
//            //此方式为沿Width方向扫描
//            int [] pixels  = raster.getPixels(0,0,raster.getWidth(),raster.getHeight(),temp);
//            for (int i=0;i<pixels.length;) {
//                //输出一列数据比对
//                if((i%raster.getWidth()*raster.getNumBands())==0)
//                    System.out.printf("ff%x%x%x\t",pixels[i],pixels[i+1],pixels[i+2]);
//                i+=3;
//            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }


    /* 我手写的针对控制台输出使用的颜色阈值 */
    public static Color  putColor(String RGB){
        long rgb1 = Long.parseLong(RGB.substring(0,2), 16);
        long rgb2 = Long.parseLong(RGB.substring(2,4), 16);
        long rgb3 = Long.parseLong(RGB.substring(4,6), 16);
        if(rgb1<85 && rgb2<85 &&rgb3<85){
            return Color.BLACK;
        }else if(rgb1>170 && rgb2<85 && rgb3<85){
            return Color.RED;
        }else if(rgb1<85 && rgb2>100 && rgb3<85){
            return Color.GREEN;
        }else if(rgb1>170 && rgb2>170 && rgb3<100){
            return Color.YELLOW;
        }else if(rgb1<85 && rgb2<85 && rgb3<100){
            return Color.BLUE;
        }else if(rgb1>120 && rgb2<120 && rgb3>120){
            return Color.MAGENTA;
        }else{
            return Color.CYAN;
        }
    }

}


