package javaSenior.JavaBaseClass;

/**
 * 主要是用于以后进行资源开发的处理上，以实现资源的自动关闭（释放资源），比如在以后进行文件，网络
 * 服务器的资源有限，所以使用之后一定要关闭资源，这样才可以被更多使用者使用
 *
 * since 1.7
 */
public class AutoCloseableStudy {
    public static void main(String[] args)throws Exception{
        /**
         * 需要使用try catch捆绑使用才能自动关闭
         */
        try (NetMessage nm = new NetMessage("www.hzc.cn");){
            nm.send();
        }catch (Exception e){}

    }
}

interface IMessage extends AutoCloseable{
    public void send();
}

class NetMessage implements IMessage{
    private String msg;
    public NetMessage(String msg){
        this.msg = msg;
    }
    public boolean open(){
        System.out.println("opne获取消息发送链接资源");
        return true;
    }

    @Override
    public void send() {
        if(this.open()) {
            System.out.println("发送消息" + this.msg);
        }
    }

    @Override
    public void close() {
        System.out.println("close");
    }
}
