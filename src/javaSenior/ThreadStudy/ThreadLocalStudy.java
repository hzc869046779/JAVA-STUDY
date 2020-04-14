package javaSenior.ThreadStudy;

public class ThreadLocalStudy {
    public static void main(String[] args) {
        new Thread(()->{
           myMessage msg = new myMessage();
           msg.setInfo("第一个线程消息");
           myChannel.setMessage(msg);
           myChannel.send();
        },"消息发送者A").start();
        new Thread(()->{
            myMessage msg = new myMessage();
            msg.setInfo("第二个线程消息");
            myChannel.setMessage(msg);
            myChannel.send();
        },"消息发送者B").start();
        new Thread(()->{
            myMessage msg = new myMessage();
            msg.setInfo("第三个线程消息");
            myChannel.setMessage(msg);
            myChannel.send();
        },"消息发送者C").start();

    }
}

class myChannel{
    private static final ThreadLocal<myMessage> THREAD_LOCAL = new ThreadLocal<myMessage>();
    private myChannel(){}
    public static void setMessage(myMessage msg){
        THREAD_LOCAL.set(msg);
    }
    public static void send(){
        System.out.println(Thread.currentThread().getName()+"消息发送"+THREAD_LOCAL.get().getinfo());
    }

}

class myMessage{
    private String info;
    public void setInfo(String info){
        this.info = info;
    }
    public String getinfo(){
        return info;
    }
}


