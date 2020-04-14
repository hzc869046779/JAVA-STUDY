package javaSenior.ThreadStudy;
import java.lang.*;

public class ThreadDemo {
    public static void main(String[] args)throws Exception{
        ticketThread mt = new ticketThread();
        new Thread(mt).start();
        new Thread(mt).start();
        new Thread(mt).start();

        Thread mainthread = Thread.currentThread();

        System.out.println("线程休眠");
        //多线程休眠
        Runnable md = ()->{
            for(int i=0;i<100;i++){
                if(i==3){
                    try {
                        //线程强制执行
                        mainthread.join();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                    //线程礼让
                    Thread.yield();

                }
                System.out.println(Thread.currentThread().getName()+"线程第"+i+"执行");
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    System.out.println("我被谁打断了？");
                }

            }
        };
        for (int num=0;num<5;num++){
            new Thread(md,"线程对象-"+num).start();
        }

        for(int y=0;y<10000;y++){
            System.out.println("我是第"+y+"个霸道");
        }


    }
}

class ticketThread implements Runnable{

    private int ticket = 5;
//    @Override
//    public void run() {
//        for(int x=0;x<100;x++){
//            if(this.ticket>0) {
//                System.out.println("卖票,tickect=" + this.ticket--);
//            }
//        }
//    }

    @Override
    public void run() {
        for(int x=0;x<5;x++){
            System.out.println("线程执行,x="+x);
        }
    }
}