package org.study.ThreadStudy;


public class ThreadStudy {
    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination tht = new TwoPhaseTermination();
        tht.start();
        Thread.sleep(5000);
        tht.stop();

     }
}


class  TwoPhaseTermination{
    private Thread monitor;

    public void start(){
        monitor = new Thread(){
            @Override
            public void run() {
                while (true){
                    Thread currentThead = Thread.currentThread();
                    if(currentThead.isInterrupted()){
                        System.out.println("被打断");
                        break;
                    }else{
                        try {
                            Thread.sleep(1000);
                            System.out.println("执行监控");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            currentThead.interrupt();
                        }

                    }

                }
            }
        };
        monitor.start();

    }

    public void stop(){
        monitor.interrupt();
    }

}