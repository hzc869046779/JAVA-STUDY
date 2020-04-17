package javaSenior.IOStudy;

import java.io.*;

/**
 * @ClassName printStreamStudy
 * @Description TODO
 * @Author hzc
 * @Date 2020/4/15 12:52
 * @Version 1.0
 */
public class printStreamStudy {
    public static void main(String[] args) throws Exception{
        File file = new File("d:/JavaFileTest/hzc2.txt");

        /**
            PrintUtil pu = new PrintUtil(new FileOutputStream(file));
            pu.println("姓名：胡志超");
            pu.print("年龄:");
            pu.println(78);
            pu.close();
         */

        /**
         * printWriter
         */
        double sal = 131321.65315615;
        PrintWriter pu = new PrintWriter(new FileOutputStream(file));
        pu.println("姓名：胡志超");

        
        pu.print("年龄:");
        pu.println(78);
        pu.printf("收入:%.2f",sal);
        pu.close();




    }
}


/** 需要很多的包装设计，对不同类型的输入进行不同的处理。所以需要打印流
    class PrintUtil implements AutoCloseable{
        private OutputStream output;   // 不管如何进行输出操作，核心就是使用OutputStream类

        public PrintUtil(OutputStream output) {
            this.output = output;
        }

        @Override
        public void close() throws Exception{
            this.output.close();
        }

        public void println(int num){
            this.println(""+num);
        }
        public void print(int num){
            this.print(""+num);
        }

        public void print(String str){
            try {
                this.output.write(str.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void println(String str){
            this.print(str+"\r\n");
        }
    }
 */

