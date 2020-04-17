package javaSenior.IOStudy;
import java.io.*;
import java.io.Serializable;

/**
 * @ClassName SerializableStudy
 * @Description TODO
 * @Author hzc
 * @Date 2020/4/15 16:21
 * @Version 1.0
 */


/**
 * transient
 * 定义哪些属性不需要序列化
 */
public class SerializableStudy {
    public static final File SAVE_FILE = new File("d:/JavaFileTest/hzc.person");
    public static void main(String[] args) throws Exception{
//        saveObject(new Person("hzc",55));
        System.out.println(loadObject());

    }
    public static void saveObject(Object obj)throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_FILE));
        oos.writeObject(obj);
        oos.close();

    }
    public static Object loadObject()throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_FILE));
        Object oj = ois.readObject();
        ois.close();
        return oj;

    }

}

@SuppressWarnings("serial")
class Person implements Serializable{
    private transient String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "姓名："+this.name+"年龄:"+this.age;
    }
}
