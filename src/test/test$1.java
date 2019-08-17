package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;



/*  这个应该后期会用 ，写的测试方法，关于线程池和任务队列，（线程始终只有你设定的那么多，每执行一个方法，将此方法加入任务，就视为一个任务，并且排队等候前面的任务进行（相当于火车站买票一样，通道、排队））  */
public class test$1 {



    public static void main(String[] args) {
        test$1 pool = new test$1(3,0);
        MyTask t = new MyTask("test thread A");
        pool.execute(new MyTask("test thread A"));
        pool.execute(new MyTask("test thread B"));
        pool.execute(new MyTask("test thread C"));
        pool.execute(new MyTask("test thread D"));
        pool.execute(new MyTask("test thread E"));
        System.out.println(pool);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int queueCount = pool.getQueueCount();
        if(queueCount==0){
            pool.destory();
        }
        System.out.println(pool);
        pool.execute(new MyTask("test thread 1"));
        pool.execute(new MyTask("test thread 2"));
        pool.execute(new MyTask("test thread 3"));
    }



    //线程中默认线程的个数
    private static int threadCount = 5;
    //队列中默认任务的个数
    private static int queueCount = 100;
    //工作线程组
    private WorkThread[] workThreads;
    //任务队列，作为一个缓冲
    private BlockingQueue<Runnable> taskQueue;
    //用户在构建线程池的时候，希望启动的线程数
    private int work_num;

    /**
     * @param work_num  线程池中工作线程的个数
     * @param taskCount
     */
    public test$1(int work_num, int taskCount) {
        if (work_num <= 0) work_num = threadCount;
        if (taskCount <= 0) taskCount = queueCount;
        this.work_num = work_num;
        taskQueue = new ArrayBlockingQueue<>(taskCount);
        workThreads = new WorkThread[work_num];
        for (int i = 0; i <work_num ; i++) {
            workThreads[i]=new WorkThread();
            workThreads[i].start();
        }

        //Runtime.getRuntime().availableProcessors();
    }

    /**
     * 执行任务，其实只是把任务加入任务队列，什么时候执行有线程池管理器决定
     * @param task
     */
    public void execute(Runnable task){
        try {
            taskQueue.put(task);
            System.out.println("....线程队列大小................>>>>>>"+taskQueue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 销毁线程池，该方法保证在所有任务都完成的情况下才销毁所有线程，否则等待任务完成才销毁
     */
    public void destory(){
        System.out.println(".....ready close pool");
        for (int i = 0; i < work_num; i++) {
            WorkThread t = workThreads[i];
            if(t.isAlive()){
                t.stopWork();
            }
            workThreads[i]=null;
        }
        taskQueue.clear();//清空任务队列
        System.out.println("线程池销毁/////////");
    }

    // 覆盖toString方法，返回线程池信息：工作线程个数和已完成任务个数
    @Override
    public String toString() {
        return "WorkThread number:" + work_num
                + "  wait task number:" + taskQueue.size();
    }
    public int getQueueCount(){
        return taskQueue.size();
    }

    private class WorkThread extends Thread {
        @Override
        public void run() {
            Runnable r = null;
            /* 线程中断状态 */
            while (!interrupted()) {
                try {
                    if(taskQueue.size()>0){
                        r = taskQueue.take();
                        if (r != null) {
                            System.out.println("线程......" + r + "......ready exec ........");
                            r.run();
                        }
                        r = null;//heap gc
                    }
                    /* 线程 被阻塞 调用interrupt();方法抛出异常恢复线程状态 */
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
        /* 线程 被阻塞 调用interrupt();方法抛出异常恢复线程状态 */
        public void stopWork(){
            interrupt();
        }
    }

    public static class MyTask extends Thread {
        private String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }

        @Override
        public void run() {
            try {
                Thread.currentThread().setName(name);
                Thread.sleep(new Random().nextInt(1000)+2000 );
                /* 线程 被阻塞 调用interrupt();方法抛出异常恢复线程状态 */
            } catch (InterruptedException e) {
                System.out.println("任务....." + name + ".......sleep InterruptedException:" + Thread.currentThread().isInterrupted());
                //Thread.currentThread().interrupt();
            }
            System.out.println("任务....." + name + ".....完成");
        }

    }



//    public static void main(String[] args) {
//        try {
//            //设置IP地址网段
//            String ips = "192.168.1.";
//            String ip;
//            InetAddress addip;
//            //遍历IP地址
//            for (int i = 1; i < 255; i++) {
//                ip = ips + i;
//                addip = InetAddress.getByName(ip);
//
//                String finalIp = ip;
//                InetAddress finalAddip = addip;
//                new Thread(){
//                    @Override
//                    public void run() {
//                        //获取登录过的设备
//                        if (!finalIp.equals(finalAddip.getHostName())) {
//                            //检查设备是否在线，其中1000ms指定的是超时时间
//                            boolean status = false;     // 当返回值是true时，说明host是可用的，false则不可。
//                            try {
//                                status = InetAddress.getByName(finalAddip.getHostName()).isReachable(10);
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                            System.out.println("IP地址为:" + finalIp + "\t\t设备名称为: " + finalAddip.getHostName() + "\t\t是否可用: " + (status ? "可用" : "不可用"));
//                        }
//                    }
//                }.start();
//            }
//        } catch (java.io.IOException uhe) {
//            System.err.println("Unable to find: " + uhe.getLocalizedMessage());
//        }
//    }


}
