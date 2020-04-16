package javaSenior.reflectStudy;

import com.sun.corba.se.spi.ior.ObjectKey;
import com.sun.deploy.perf.PerfRollup;

import javax.xml.crypto.Data;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;
import java.io.File;

/**
 * @ClassName reflectBase
 * @Description 认识反射机制
 * @Author hzc
 * @Date 2020/4/15 18:46
 * @Version 1.0
 */

/**
 * class类对象三中实例化模式
 */
public class reflectBase {
    public static void main(String[] args) throws Exception{
        Date data = new Date();

        // object类支持 getclass
        System.out.println(data.getClass());


        // JVM支持   必须导入开发包，不需要实例化对象
        Class cls = FileReader.class;
        System.out.println(cls.getName());
        // 反射获取包信息
        System.out.println("\nDate类的包信息"+cls.getPackage().getName());

        // 反射获取父类信息
        System.out.println("\n获取父类信息");
        System.out.println(cls.getSuperclass().getName());

        // 反射获取父接口信息
        Class clzz[] = cls.getInterfaces();
        for(Class temp:clzz){
            System.out.println(temp.getName());
        }

        // 反射获取构造方法
        System.out.println("\n获取所有构造方法");
        Constructor<?>[] cst = cls.getDeclaredConstructors();
        for(Constructor cc:cst){
            System.out.println(cc);
        }
        System.out.println("\n获取单个构造方法");
        System.out.println(cls.getConstructor(File.class).getName());

        // 反射获取类方法
        System.out.println("\n获取类中的方法");
        Method methods[] = cls.getMethods(); //获取所有方法
//        Method methods[] = cls.getDeclaredMethods();

        for(Method method:methods){
            int mod = method.getModifiers(); //修饰符
            System.out.print(method.getReturnType().getName() + " ");
            System.out.print(Modifier.toString(mod)+" ");
            System.out.println(method.getName());
        }

        //反射获取调用成员
        System.out.println("\n获取调用成员");
        Field []fields = cls.getDeclaredFields();
        for(Field field:fields){
            System.out.println(field.getName());
        }

        // 直接采用字符串的形式定义要使用的类型，并且程序中不需要import导入相应的包，但是这个类必须存在
        System.out.println("\n通过Class.forname获取类名称");
        Class cls1 = Class.forName("java.io.InputStreamReader");
        System.out.println(cls1.getName());

        /**
         * 反射实例化对象
         */
        Class ps = Class.forName("javaSenior.reflectStudy.Person");

//        Object mm = ps.newInstance();   JDK1.9之前
        Object mm = ps.getDeclaredConstructor().newInstance();
        System.out.println(mm);

    }
}

class Person{
    public Person() {
        System.out.println("构造方法");
    }

    @Override
    public String toString() {
        return "我是一个人";
    }
}
