package javaSenior.ThreadStudy;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 多线程 主线程负责处理整体流程，子线程负责处理耗时操作
 * 进程： 传动DOS在同一时间只允许一个程序执行。<单进程>
 *       在后来允许单进程，所以在一个时间段上会有多个程序一次执行，但是某时间点只能有一个程序。<单核>
 * 线成： 线程在进程基础上创建使用，线程启动速度比进程快很多。所以当多线程进行并发处理的时候，执行速度
 *       快很多
 *
 * thread和runnable关系:
 *       多线程的设计之中，使用了代理设计模式结构，用户自定义的线程主体只是负责核心功能的实现，而所有
 *       辅助实现全部交由thread实现.
 *
 *       在thread启动多线程是start方法，然后找到run方法。但通过thread类接受runnable接口对象的时，
 *       接口对象被thread中的target属性接受。start执行调用thread中的run方法，这个run方法去调用
 *       runnable接口子类被复写的run方法
 *
 *       thread:线程表述
 *       runnable: 资源描述
 *
 * Runnable和Callable:
 *       Runnable是在JDK1.0提出的实现接口，Callable是1.5之后
 *       Runnable接口中只提供一个run方法，没返回值
 *       Callable提供call方法，有返回值
 *

 */


public class Process_thread {
    public static void main(String args[]) throws Exception{
/*
        new Mythread("多线程A测试").start();
        new Mythread("多线程B测试").start();
        new Mythread("多线程c测试").start();
        */

        /**
         * start()负责找到start0() . 由JVM实现<JNI技术.java native interface
         * 调用操作系统底层函数，通过算法调度资源>
         */

        Thread threadA = new Thread(new Mythread1("线程对象A"));
        Thread threadB = new Thread(new Mythread1("线程对象B"));
        Thread threadC = new Thread(new Mythread1("线程对象C"));
        /**
         * 设置优先级  setPriority
         * 主线程属于中等优先级
         * 优先级高的可能先执行
         */
        threadA.setPriority(Thread.MIN_PRIORITY);
        threadB.setPriority(Thread.MIN_PRIORITY);
        threadC.setPriority(Thread.MAX_PRIORITY);
        threadA.start();
        threadB.start();
        threadC.start();

        // 函数式接口
        System.out.println("***********Runnable实现多线程*************");
        for(int x=0;x<3;x++){
            String title = "线程对象-"+x;
/*            Runnable run = ()->{
                for (int y=0;y<10;y++){
                    System.out.println(title+"运行,y="+y);
                }
            };
            new Thread(run).start();*/
            new Thread(()->{
                for (int y=0;y<10;y++) {
                    System.out.println(title + "运行,y=" + y);
                }
            }).start();
        }

        System.out.println("***********Callable实现多线程*************");
        FutureTask<String> task = new FutureTask<String>(new Mythread2());
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
        System.out.println("线程返回数据:"+task.get());

    }
}
/**
线程类: 1. 继承java.lang.Thread的程序类即为线程的主体类
 */
class Mythread extends Thread{
    private String title;
    public Mythread(String title){
        this.title = title;
    }
    @Override
    public void run() {
        for(int x=0;x<10;x++){
            System.out.println(this.title+"运行，x="+x);
        }
    }
}

/**
 线程类: 2. 继承java.lang.Runnable接口即为线程的主体类
 没有了单继承的局限
 */
class Mythread1 implements Runnable{
    private String title;
    public Mythread1(String title){
        this.title = title;
    }
    @Override
    public void run() {
        for(int x=0;x<10;x++){
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(this.title+"运行，x="+x);
        }
    }
}

/**
 *
 * 线程类: 3. 继承java.util.concurrent.Callable接口即为线程的主体类
 *
 */
class Mythread2 implements Callable<String>{
    @Override
    public String call() throws Exception{
        for (int x=0;x<10;x++){
            System.out.println("线程执行.x="+x);
        }
        return "线程执行完毕";
    }
}
