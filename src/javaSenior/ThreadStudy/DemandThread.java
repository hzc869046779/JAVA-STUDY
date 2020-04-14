package javaSenior.ThreadStudy;

public class DemandThread {
    public static void main(String[] args){
        Thread userthread = new Thread(()->{
            for(int x=0; x<10;x++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"正在运行、x="+x);
            }
        },"用户线程");
        Thread demandthread = new Thread(()->{
            for(int x=0; x<Integer.MAX_VALUE;x++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"正在运行、x="+x);
            }
        },"守护线程");

        /**
         * 通过setDeamon设置守护线程
         * 主线程结束后跟着就结束了
         */
        demandthread.setDaemon(true);
        userthread.start();
        demandthread.start();
    }
}
