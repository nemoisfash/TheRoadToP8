package org.study.ThreadStudy;

public class DaemonThread {

    public static void main(String[] args) throws InterruptedException {
        Thread demon = new Thread(){

            @Override
            public void run() {
                    while (true){
                        if(Thread.currentThread().isInterrupted()){
                           break;
                        }
                        try {
                            Thread.sleep(1000);
                            System.out.println("运行demon");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                System.out.println("结束:demon");
            }
        };
        demon.setDaemon(true);
        demon.start();
        Thread.sleep(5000);
        System.out.println("结束:main");
    }
}
