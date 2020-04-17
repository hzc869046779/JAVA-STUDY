package javaSenior.IOStudy;
import java.io.*;
import java.lang.reflect.Field;

/**
 * @ClassName StreamStudy
 * @Description IO stream study
 *              OutputStream
 *              InputStream
 *              Writer
 *              Reader
 *
 *              字节流和字符流的区别:
 *              在不进行close()时候，字节流仍然可以输出，但是字符流不可以，因为writer用到了缓冲区。
 *              close方法其实会强制刷新缓冲区的作用,更适合中文字符
 * @Author hzc
 * @Date 2020/4/14 15:37
 * @Version 1.0
 */
public class StreamStudy  {
    public static void main(String[] args) throws  Exception {
        System.out.println("OutputStream 学习");
        File file= new File("D:/filetest/mytest.txt");
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        try (OutputStream output = new FileOutputStream(file,true)){  // append=true 则非覆盖
            String str = "www.hzc.cn\r\n";
            output.write(str.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("\nInputStream 学习");
        InputStream input = new FileInputStream(file);
        byte data [] = new byte[1024]; //开辟一个缓冲区读取数据
        int len = input.read(data);  //读取数据，保存在字节数组中，返回读取个数
        System.out.println(new String(data,0,len));
        input.close();

        System.out.println("\nWriter 学习");
        Writer writer = new FileWriter(file,true);
        String str1 = "www.glz.cn";
        writer.write(str1);
        writer.close();

        System.out.println("\nReader 学习");
        Reader reader = new FileReader(file);
        char data1[] = new char[1024];
        int len1 = reader.read(data1);
        System.out.println("读取内容: "+ new String(data1,0,len1));
        reader.close();

    }
}
