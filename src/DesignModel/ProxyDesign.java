package DesignModel;

/**
 * @ClassName ProxyDesign
 * @Description TODO
 * @Author hzc
 * @Date 2020/4/17 12:19
 * @Version 1.0
 */
public class ProxyDesign {
    public static void main(String[] args) throws Exception{
        IMessage1 msg = new MessageProxy(new MessageReal());
        msg.send();
    }
}

interface IMessage1{
    public void send();
}

class MessageReal implements IMessage1{
    @Override
    public void send() {
        System.out.println("发送消息: www.hzc.cn");
    }
}
class MessageProxy implements IMessage1{
    private IMessage1 message1;
    public MessageProxy(IMessage1 message1){
        this.message1 = message1;
    }

    public boolean connect(){
        System.out.println("进行消息发送通道连接");
        return true;
    }

    public void close(){
        System.out.println("消息通道关闭");
    }

    @Override
    public void send() {
        if(this.connect()){
            this.message1.send();
            this.close();
        }
    }
}



