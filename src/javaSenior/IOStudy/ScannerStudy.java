package javaSenior.IOStudy;

import java.util.Scanner;

/**
 * @ClassName ScannerStudy
 * @Description TODO
 * @Author hzc
 * @Date 2020/4/15 16:05
 * @Version 1.0
 */
public class ScannerStudy {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.print("输入年龄");
        while(sc.hasNext("[1,2,5]")){  //输入必须是1，2，5其中之一，负责跳出程序
            int age = sc.nextInt();
            System.out.println("年龄"+age);
        }
        sc.close();


    }
}
