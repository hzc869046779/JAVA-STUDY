package javaSenior.reflectStudy;

import javax.annotation.processing.SupportedSourceVersion;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName refectFactory
 * @Description 反射工厂模式
 * @Author hzc
 * @Date 2020/4/16 16:58
 * @Version 1.0
 */
public class refectFactory {
    public static void main(String[] args) {
        IMessage msg = Factory.getInstance("javaSenior.reflectStudy.NetMessage",IMessage.class);
        msg.send();
        IService service = Factory.getInstance("javaSenior.reflectStudy.HouseService",IService.class);
        service.service();

    }
}

class  Factory{
    private Factory(){} //没有产生实例化对象的意义，所以构造方法私有化
    public static <T> T getInstance(String className,Class<T> clazz){
        T instance = null;
        try {
            instance = (T)Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }
}

interface IService{
    public void service();
}
interface IMessage{
    public void send();
}
class HouseService implements IService{
    @Override
    public void service() {
        System.out.println("为你的住宿提供服务");
    }
}
class NetMessage implements IMessage{
    @Override
    public void send() {
        System.out.println("网络消息正在发送");
    }
}
