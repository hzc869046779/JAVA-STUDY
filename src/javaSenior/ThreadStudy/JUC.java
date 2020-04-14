package javaSenior.ThreadStudy;

public class JUC {
    public static void main(String[] args){
        MyticketThread mt = new MyticketThread();
        Thread threadA = new Thread(mt,"票贩A");
        Thread threadB = new Thread(mt,"票贩子B");
        Thread threadC = new Thread(mt,"票贩子C");
        threadB.setPriority(Thread.MAX_PRIORITY);
        threadA.start();
        threadB.start();
        threadC.start();
    }
}

/**
 * 如果想实现锁的功能，可以使用synchronized关键字来实现，设置*同步代码块*    以解决多个线程操作同一资源时候发生的冲突
 * 在同步代码块操作里面的代码只允许一个线程执行
 *
 * 但是会造成性能下降,
 *
 * 并且过多的同步处理会造成死锁
 */

/**
class MyticketThread implements Runnable{    //同步代码块方法
    private int ticket = 10000;
    @Override
    public void run() {
        while (true){
            synchronized (this){
                if(this.ticket>0) {
                    try {
                        Thread.sleep(10);  //模拟延
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "卖票,ticket=" + this.ticket--);
                }
            else {
                    System.out.println("卖光了");
                    break;
                }
            }
        }
    }
}
 */


/**
 * synchronized定义同步方法
 */
class MyticketThread implements Runnable{
    private int ticket = 1000;
    public synchronized void sale(){
        if(this.ticket>0) {
            try {
                Thread.sleep(10);  //模拟延
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "卖票,ticket=" + this.ticket--);
        }
        else {
            System.out.println("卖光了");
        }
    }
    @Override
    public void run() {
        while (true){
            this.sale();
        }
    }
}

