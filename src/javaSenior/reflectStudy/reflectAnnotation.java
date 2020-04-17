package javaSenior.reflectStudy;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/**
 * @ClassName reflectAnnotation
 * @Description TODO
 * @Author hzc
 * @Date 2020/4/17 16:02
 * @Version 1.0
 */
public class reflectAnnotation {
    public static void main(String[] args) throws Exception{
        { // 获取接口上的Annotation信息
            Annotation annotations[] = myMessage.class.getAnnotations();
            for(Annotation temp:annotations){
                System.out.println(temp);
            }

        }

        System.out.println("\n");
        { // 获取myMessageImpl子类上的Annotation
            Annotation annotations[] = myMessageImpl.class.getAnnotations();
            for(Annotation temp:annotations){
                System.out.println(temp);
            }
        }

        System.out.println("\n");
        { // 获取myMessageImpl.send方法上的Annotation
            Method method = myMessageImpl.class.getDeclaredMethod("send",String.class);
            Annotation annotations[] = method.getDeclaredAnnotations();
            for(Annotation temp:annotations){
                System.out.println(temp);
            }
        }

        Method method1 = test.class.getMethod("send", String.class); //获取指定方法
        myAnnotation anno = method1.getAnnotation(myAnnotation.class); //获取指定annotation
        System.out.println(anno.title());
        System.out.println(anno.url());
    }
}

@FunctionalInterface
@Deprecated
interface myMessage{
    public void send(String msg);
}

@SuppressWarnings("serial")
class myMessageImpl implements myMessage, Serializable {
    @Override
    public void send(String msg) {
        System.out.println("消息发送:"+msg);
    }
}

/**
 * 自动以annotation
 */
@Retention(RetentionPolicy.RUNTIME)  //定义annotation运行策略   运行时，编码时，
@interface myAnnotation{
    public String title();   //获取数据
    public String url() default "www.hzc.cn";   //获取数据，默认值
}

class test{
    @myAnnotation(title = "hzc")
    public void send(String msg){
        System.out.println("消息发送："+msg);
    }
}
