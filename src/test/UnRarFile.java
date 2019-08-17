package test;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UnRarFile {

    /*  压缩 解压  可以 试着 爆破，基于rar32自带的cli命令爆破  */
    public static void main(String[] args) {
        compressRAR("D:\\rar\\1.txt", "D:\\rar\\6.rar","666");

        decompressionRAR("D:\\rar\\6.rar", "D:\\rar\\","6666");

    }



































    public static void compressRAR(String imPort, String exPort, String pwd) {
        try {
            String cmd = "C:\\Program Files (x86)\\WinRAR\\WinRAR.exe";
            String unrarCmd = cmd +" a "+" -p"+pwd+" "+exPort+" "+imPort;
            Runtime rt = Runtime.getRuntime();
            Process pre = rt.exec(unrarCmd);
            InputStreamReader isr = new InputStreamReader(pre.getInputStream());
            BufferedReader bf = new BufferedReader(isr);
            String line = null;
            while ((line = bf.readLine()) != null) {
                line = line.trim();
                if ("".equals(line)) {
                    continue;
                }
                System.out.println(line);
            }
            bf.close();
        } catch (Exception e) {
        }
    }

    public static void decompressionRAR(String imPort, String exPort,String pwd) {
        try {
            String cmd = "C:\\Program Files (x86)\\WinRAR\\WinRAR.exe";
            String unrarCmd = cmd +" x "+" -p"+pwd+" "+imPort+" "+exPort;
            Runtime rt = Runtime.getRuntime();
            Process pre = rt.exec(unrarCmd);
            InputStreamReader isr = new InputStreamReader(pre.getInputStream());
            BufferedReader bf = new BufferedReader(isr);
            String line = null;
            while ((line = bf.readLine()) != null) {
                line = line.trim();
                if ("".equals(line)) {
                    continue;
                }
                System.out.println(line);
            }
            bf.close();
        } catch (Exception e) {
        }
    }
}