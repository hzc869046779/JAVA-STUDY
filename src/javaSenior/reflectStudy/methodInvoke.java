package javaSenior.reflectStudy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import sun.misc.*;

/**
 * @ClassName methodInvoke
 * @Description TODO
 * @Author hzc
 * @Date 2020/4/16 18:24
 * @Version 1.0
 */
public class methodInvoke {
    public static void main(String[] args) throws Exception{
        Class cls = Class.forName("cn.hzc.Person"); //获取指定Class对象
        String value = "胡志超"; // 要设置属性内容
        // 反射实例化
        Object obj = cls.getDeclaredConstructor(String.class).newInstance("胡志超");
//        Method method = cls.getDeclaredMethod("setName", String.class);
        Method method1 = cls.getDeclaredMethod("getName");
//        method.invoke(obj,value);
        System.out.println(method1.invoke(obj));


        System.out.println("---------分割线-----------");

        Field nameField = cls.getDeclaredField("name");
        nameField.setAccessible(true); //接触封装
        nameField.set(obj,"关连正"); // Person对象.name = ""
        System.out.println(nameField.get(obj));
        System.out.println(nameField.getType().getSimpleName());

        System.out.println("---------unsafe-----------");
        /**
         * 绕过JVM实例化对象管理
         */
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafeObject = (Unsafe) field.get(null); //static属性不需要传参
        Singleton1 instance = (Singleton1) unsafeObject.allocateInstance(Singleton1.class);
        instance.print();

    }
}

class Singleton1{
    private Singleton1(){
        System.out.println("singletion构造");
    }
    public void print(){
        System.out.println("www.hzc.cn");
    }

}