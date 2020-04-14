package javaSenior.FileStudy;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.StreamSupport;

/**
 * @ClassName FileOP
 * @Description Base file op
 * @Author hzc
 * @Date 2020/4/14 9:57
 * @Version 1.0
 */
public class FileOP {
    public static void main(String[] args) throws Exception{

        /**
         * 分隔符 File.separator
         */
        File file = new File("d:/hello/fj/xx.txt");

        /**
         * 判断父目录是否存在，若不存在则创建
         */
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        boolean ss = file.createNewFile();
//        System.out.println(file.delete());
        System.out.println(file.exists());

        System.out.println("文件是否可读"+file.canRead());
        System.out.println("文件是否可读"+file.canWrite());
        System.out.println("文件大小"+String.format("%.2f",(double)file.length()));
        System.out.println("最后修改时间"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(
                new Date(file.lastModified())
        ));
        System.out.println("文件是否是文件"+file.isFile());
        System.out.println("是目录吗"+file.isDirectory());
        System.out.println("列出目录"+file.getParentFile().listFiles());





    }
}

