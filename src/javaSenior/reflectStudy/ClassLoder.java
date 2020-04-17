package javaSenior.reflectStudy;
import java.io.*;
import java.io.InputStreamReader;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.Method;


/**
 * @ClassName ClassLoder
 * @Description 根据一个指定的类的全限定名,找到对应的Class字节码文件,然后加载它转化成一个java.lang.Class类的一个实例
 * @Author hzc
 * @Date 2020/4/17 9:42
 * @Version 1.0
 */
public class ClassLoder {
    public static void main(String[] args)throws Exception {

        /**
        Class clazz = Msg.class;
        System.out.println(clazz.getClassLoader());  //应用程序加载器
        System.out.println(clazz.getClassLoader().getParent());    //扩展类加载器   1.8以后是platformClassLoder
        System.out.println(clazz.getClassLoader().getParent().getParent());
         */
        hzcClassLoader classLoader = new hzcClassLoader();
        Class cls = classLoader.loadData("javaSenior.reflectStudy.Message");
        Object obj = cls.getDeclaredConstructor().newInstance();
        Method method = cls.getDeclaredMethod("sebd");
        method.invoke(obj);




    }
}

class hzcClassLoader extends ClassLoader{
    private static final String MESSAGE_CLASS_PATH="E:/Message.class";
    /**
     * \
     * @param className  类的完整名称“包.类”
     * @return 返回一个Class对象
     * @throws Exception  如果文件不存在无法加载
     */
    public Class loadData(String className) throws Exception{
        byte []data = this.loadClassData();
        if(data !=null){
            return super.defineClass(className,data,0,data.length);
        }
        return null;

    }
    private byte[] loadClassData() throws Exception{
        InputStream input = null;
        ByteArrayOutputStream bos = null;
        byte data[]=null;
        try {
            bos=new ByteArrayOutputStream();
            input = new FileInputStream(new File(MESSAGE_CLASS_PATH));
//            input.transferTo(bos);
            data = bos.toByteArray();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
           if(input!=null){
               input.close();
           }
           if(bos!=null){
               bos.close();
           }
        }
        return data;
    }
}

class Msg{}

/**
 * 自定义类加载器
 */


