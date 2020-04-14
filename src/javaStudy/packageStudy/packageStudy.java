package javaStudy.packageStudy;
import javaStudy.packageTest.*;
import static javaStudy.packageTest.MyMath.*;

// * 也不表示进行全部的加载，他会根据需要加载所需程序类。 <有可能不同的包中存在相同类名称>。

public class packageStudy {
    public static void main(String args[]){
        Message msg = new Message();
        Message msg1 = new javaStudy.packageTest.Message();
        System.out.println(msg.getContent());
        System.out.println(msg1.getContent());

        //静态包
        System.out.println(sum(1,3,4));
        System.out.println(jianfa(3,2));

        //protected 测试访问  不同包的子类进行访问
        NetMessage nmsg = new NetMessage();
        nmsg.print();

        //直接访问protected属性
//        System.out.println(new Message().info);
    }
}

class NetMessage extends Message{
    public void print(){
        System.out.println(super.info);
    }
}


