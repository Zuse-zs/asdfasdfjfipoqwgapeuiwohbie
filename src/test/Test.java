package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;


public class Test extends JFrame {


    private static final long serialVersionUID = 9195701874098282860L;

    private String[] str=new String[10];
    String bin = new String();
    JTextField jf;
    JTextArea  ja;
    JScrollPane jp;
    JButton jButton1;
    private static short coin=0;
    JButton jButton2;

    Calendar now;

    int hour;

    int hourEnd;

    int minute;

    int minutend;

    int second;

    int secondend;

    int hourend;

    int minutePlus;

    int secondPlus;

    Thread t;

    boolean right = true;

    public Test() {
        setSize(300, 200);
        jf = new JTextField(25);
        ja = new JTextArea(20,30);
        //ja.append("hello\n"+"world");
        jp =new JScrollPane(ja);
        jp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        for(int i=0;i<10;i++)
            str[i] = new String();

        jf.setText("单击按纽进行相应的操作");

        jButton1 = new JButton("显示时间剩余时间");
        jButton2 = new JButton("暂停");
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        container.add(jf );
        container.add(jButton1);
        container.add(jButton2);
        container.add(jp);
        //获取系统刚开始运行的初始值
        now = Calendar.getInstance();
        hourEnd = now.get(Calendar.HOUR_OF_DAY) + 1 ;
        minutePlus = now.get(Calendar.MINUTE);
        secondPlus = now.get(Calendar.SECOND);
        t = new Thread(new Runnable() {

            public void run() {
                while (true) {
                    try {
                        System.out.println(right);
                        Thread.sleep(60);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    while (right) {
                        jf.setText(CalTime());
                    }
                }
            }
        });

        t.start();

        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                right = true;
            }
        });

        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent g) {
                right = false;
            }
        });
        setVisible(true);
    }

    public String CalTime() {
        now = Calendar.getInstance();
        hour = now.get(Calendar.HOUR_OF_DAY);
        minute = now.get(Calendar.MINUTE);
        second = now.get(Calendar.SECOND);
        if (hourEnd >= hour) {
            hourend =  hourEnd - hour;
            secondend = 59 - second+secondPlus;

            minutend = 59 - minute+minutePlus;
        }
        return "2小时倒计时hour:  " + hourend + "  minute:  " + minutend
                + "  second:  " + secondend;
    }
    public String[] work(){  //多线程关键代码

        ExecutorService  exec= Executors.newCachedThreadPool();
        ArrayList<Future<String>> results= new ArrayList<Future<String>>();
        for(int i=0;i<10;i++)
            results.add(exec.submit(new TaskT(i)));
        for(Future<String> fuck : results)
            try{
                bin =  fuck.get() ;
                str[coin] = bin;
                coin++;
            } catch(InterruptedException e){
                System.exit(1);
            } catch(ExecutionException e){
            }
        exec.shutdown();
        return str;
    }
    public void setStr(String[] alph){
        for(int i=0;i<alph.length;i++)
            ja.append(alph[i]+"\n");
    }
    public static void main(String args[]) {

        Test sleep = new Test();
        sleep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sleep.setStr(sleep.work());

        System.out.println("About to schedule task.");
        new Reminder(3);
        System.out.println("Task scheduled.");
    }


    
    //    https://www.cnblogs.com/lingiu/p/3782813.html
    public static class Reminder{
        Timer timer;

        public Reminder(int sec){
            timer = new Timer();

            timer.schedule(new TimerTask(){
                public void run(){
                    System.out.println("Time's up!");
                    timer.cancel();
                }
            }, sec*1000);
        }
    }
}

class TaskT implements Callable<String>{
    private int id=0;
    public TaskT(int id){
        this.id=id;
    }
    public String  call(){
        return "TaskT "+id;

    }
}