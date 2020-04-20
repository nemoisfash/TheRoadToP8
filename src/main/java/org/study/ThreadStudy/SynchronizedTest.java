package org.study.ThreadStudy;

public class SynchronizedTest {

    public static  int count=0;

    public final Object room = new Object();

    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                for(int i=0;i<5000;i++){
                    count ++;
                }
                System.out.println(count);
            }
        };

        Thread thread1 = new Thread(){
            @Override
            public void run() {
                for(int i=0;i<5000;i++){
                    count --;
                }
                System.out.println(count);
            }
        };
        thread.start();
        thread1.start();

    }
}
