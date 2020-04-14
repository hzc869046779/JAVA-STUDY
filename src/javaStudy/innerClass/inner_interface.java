package javaStudy.innerClass;

import javax.annotation.processing.SupportedSourceVersion;

public class inner_interface {
    public static void main(String args[]){
        IChannel channel = new ChannelImpl();
//        channel.send(((ChannelImpl)channel).new MessageImpl());

        System.out.println("staic 定义内部类");
        ChannelImpl.MessageImpl in = new ChannelImpl.MessageImpl();
        System.out.println(in.getContent());

        System.out.println("static 定义内部接口");
        IMessageWarp.send(new DefaultMessage(),new NetChannel());


    }
}



interface IChannel{
    public void send(IMessage msg);
    interface IMessage{
        public String getContent();
    }
}

class ChannelImpl implements IChannel{
    public void send(IMessage msg){
        System.out.println("发送消息："+msg.getContent());
    }

    //static 只能访问static成员
    static class MessageImpl implements IMessage{
        public String getContent(){
            return "www.hzc.cn";
        }
    }
}


/*
    使用static定义内部接口，主要是因为这些操作是属于一组相关定义，可以明确这些接口的功能
*/
interface IMessageWarp{ //消息包装
    static interface IWMessage{
        public String getContent();
    }
    static interface IWChannnel{
        public boolean connect();  // 消息发送通道
    }
    public static void send(IWMessage msg, IWChannnel channnel){
        if(channnel.connect()){
            System.out.println(msg.getContent());
        }else{
            System.out.println("消息通道无法简历，发送失败");
        }
    }
}

class DefaultMessage implements IMessageWarp.IWMessage{
    public String getContent(){
        return "www.hzc.cn";
    }
}

class NetChannel implements IMessageWarp.IWChannnel{
    public boolean connect(){
        return true;
    }
}