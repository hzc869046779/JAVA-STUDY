package javaSenior.FileStudy;

import java.io.InputStream;

/**
 * @ClassName SystemIO
 * @Description TODO
 * @Author hzc
 * @Date 2020/4/15 15:27
 * @Version 1.0
 */
public class SystemIO {
    public static void main(String[] args)throws Exception {
        InputStream input = System.in;
        System.out.println("请输入信息：");

        byte[] data = new byte[1024];
        int len = input.read(data);
        System.out.println("输入内容为:"+ new String(data,0,len));

    }
}

