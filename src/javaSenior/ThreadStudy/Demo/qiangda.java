package javaSenior.ThreadStudy.Demo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.function.Function;

public class qiangda {
    public static void main(String[] args) throws Exception{
        Mythread mt = new Mythread();
        FutureTask<String> task = new FutureTask<>(mt);
        new Thread(task,"竞赛者A").start();
        new Thread(task,"竞赛者B").start();
        new Thread(task,"竞赛者C").start();
        System.out.println(task.get());


    }
}

class Mythread implements Callable<String>{
    private boolean flag = false;

    @Override
    public String call() {
        synchronized (this){
            if(this.flag==false){
                this.flag=true;
                return Thread.currentThread().getName()+"抢答成功";
            }else {
                return Thread.currentThread().getName()+"抢答失败";
            }
        }
    }
}
