package javaSenior.FileStudy;
import java.io.File;
import java.io.RandomAccessFile;

/**
 * @ClassName RandomAccessFileStudy
 * @Description TODO
 * @Author hzc
 * @Date 2020/4/15 9:49
 * @Version 1.0
 */
public class RandomAccessFileStudy {
    public static void main(String[] args) throws Exception{
        File file = new File("d:/hzc1.txt");
        RandomAccessFile raf = new RandomAccessFile(file,"rw");
        /**
         * 写文件
            String names[] = new String[]{"hzc","glz","bjh"};
            int ages[] = new int[]{30,20,16};
            for(int x=0;x<names.length;x++){
                raf.write(names[x].getBytes());
                raf.write(ages[x]);
            }
            raf.close();
         */

        //读取李四的数据跳过24位
        raf.skipBytes(24);
        byte[] data = new byte[8];
        int len = raf.read(data);
        System.out.println("姓名:"+new String(data,0,len)+"年龄:"+raf.readInt());
        raf.close();





    }
}
