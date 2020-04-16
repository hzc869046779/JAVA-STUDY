package javaSenior.reflectStudy;

/**
 * @ClassName reflectSingle
 * @Description 反射单例模式
 * @Author hzc
 * @Date 2020/4/16 17:06
 * @Version 1.0
 */
public class reflectSingle {
    public static void main(String[] args) {
        for(int x=0;x<3;x++){
            new Thread(()->{
                Singleton.getInstance().print();
            },"单例消费端"+x).start();
        }
    }
}

class Singleton{
    private static volatile Singleton instance = null;
    private Singleton(){
        System.out.println("["+Thread.currentThread().getName()+"]实例化对象中");
    };


    /**
     * 加同步可以处理但是效率变低很多
     * @return
     */
    public static  Singleton getInstance(){
        synchronized (Singleton.class){ //由于是静态方法，所以参数不能为this
            if (instance==null) { // 外部判断，使得之后的线程不用进行同步操作
                if(instance==null){  //内部判断，第一时间都通过外部判断的若干线程，进行同步操作
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }
    public void print(){
        System.out.println("hzc.cn");
    }
}
