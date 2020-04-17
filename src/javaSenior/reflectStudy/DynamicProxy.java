package javaSenior.reflectStudy;

import org.omg.CORBA.OBJ_ADAPTER;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName DynamicProxy
 * @Description TODO
 * @Author hzc
 * @Date 2020/4/17 12:49
 * @Version 1.0
 */
public class DynamicProxy {
    public static void main(String[] args) {
        IMessage1 msg = (IMessage1) new HZCProxy().bind(new MessageReal());
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

class HZCProxy implements InvocationHandler{
    private Object target;

    /**
     *
     * @param target
     * @return
     */
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    public boolean connect(){
        System.out.println("进行消息发送通道连接");
        return true;
    }

    public void close(){
        System.out.println("消息通道关闭");
    }

    @Override
    public Object invoke(Object pro, Method method, Object[] args)throws Throwable {
        System.out.println("执行方法"+method);
        Object returnData = null;
        if(this.connect()){
            returnData = method.invoke(this.target,args);
            this.close();
        }
        return returnData;
    }
}
