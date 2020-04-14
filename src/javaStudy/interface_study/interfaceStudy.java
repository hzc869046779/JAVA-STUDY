package javaStudy.interface_study;

public class interfaceStudy {
    public static void  main(String args[]){
        IMessage msg = new MessageImpl();
        System.out.println(msg.getInfo());
        Object obj = msg;  //向上转型
        IChannel chan = (IChannel) obj;
        System.out.println(msg.getInfo());
        System.out.println(chan.connect());

        IService ser = new MessageService();
        if(ser.connect11()){
            System.out.println(ser.getInfo());
        }

    }
}


/*
    接口需要被子类实现（implements）,一个子类可以显现多个父接口；
    子类（如果不是抽象类）那么一定要复写接口职中的全部抽象方法；
    接口对象可以利用子类对象的向上转型进行实例化
*/

interface IMessage{  // 定义了一个借口
    public static final String INFO = "www.mldn.cn"; // 全局常亮
    public abstract String getInfo();  // 抽象方法

}

interface IChannel{
    public abstract boolean connect();
}


interface IService extends IMessage,IChannel{
    //接口多继承
    public String service();
    public default boolean connect11(){
        System.out.println("这是个公共方法，都具备");
        return true;
    }
}

abstract class DatabaseAbstract{
    // 接口中的abstract可以省略，抽象类中不允许
    public abstract boolean getDatabaseConnection();
}

class MessageService implements IService{
    public String getInfo(){
        return "";
    }
    public boolean connect(){
        return true;
    }
    public String service(){
        return "获取消息服务";
    }

}

class MessageImpl extends DatabaseAbstract implements IMessage, IChannel{  // 实现了一个借口
    public String getInfo(){
        if(this.connect()) {
            if(this.getDatabaseConnection()) {
                return "得到一个消息";
            }
            else  {
                return "数据库消息无法访问。";
            }
        }
        return "通道创建失败";
    }
    public boolean connect(){
        System.out.println("消息发送通道已经成功建立");
        return true;
    }

    public boolean getDatabaseConnection(){
        return true;
    }
}

