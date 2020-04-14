package javaStudy.StringStudy;

import javax.annotation.processing.SupportedSourceVersion;

public class stringStudy {



//    String args[]  设置启动参数
    public static void main(String[] args){
        String strA = "mldn";
        String strA1 = "Mldn";
        String strF = "mldn";
//        手工入池操作
        System.out.println("手工入池操作");
        String strB = new String("mldn").intern();
        System.out.println(strA==strB);
        System.out.println(strA==strF);

//        判断两个字符串是否相等  str.equals  大小写区分的
        System.out.println("判断两个字符串是否相等   大小写区分的 str.equals");
        System.out.println(strA.equals(strA1));
        System.out.println(strA.equalsIgnoreCase(strA1));
//        字符串ascall码比较
        System.out.println(strA.compareTo(strA1));
//        字符串ascall码比较  忽略大小写
        System.out.println(strA.compareToIgnoreCase(strA1));


//        匿名对象String   字符串常量放在前因为不会为空
        System.out.println("匿名对象String   字符串常量放在前因为不会为空");
        System.out.println("mldn".equals(strB));

//        静态常量池， 然后变量strD在动态常量池
        String strC = "ld";
        String strD = "m" + strC + "n";
        System.out.println("静态常量池， 然后变量strD在动态常量池");
        System.out.println(strA==strD);
        System.out.println(strA.equals(strD));

//        转字符数组
        char m = strA.charAt(0);
        char[] c = strA.toCharArray();
        System.out.println(m);

//        将字符串变为字节数组
        byte data[] = strA.getBytes();
        System.out.println("将字符串变为字节数组");
        for(int x: data){
            System.out.println(x);
        }

//        字符串查找
        System.out.println(strA.contains("g"));
        System.out.println(strA.indexOf("dn"));
        System.out.println(strA.lastIndexOf("m"));
        System.out.println(strA.startsWith("ld",1));
        System.out.println(strA.endsWith("n"));

//        字符串替换
        String strE = "hello world my ha";
        System.out.println(strE.replaceAll("l", "_"));
        System.out.println(strE.replaceFirst("l", "_"));

//        字符串打印
        for(char x : strE.toCharArray()){
            System.out.print(x);
        }
        System.out.println(strE);


        System.out.println(strE);

//        字符串拆分  如果拆不开需要 \\转义
        String result [] = strE.split(" ", 3);
        System.out.println();
        for (String x : result){
            System.out.println(x);

        }

//        字符串截取
        System.out.println(strE.substring(0,4));

//        字符串是否为空  去除空格 等
        System.out.println("".isEmpty());
        System.out.println(" ".isEmpty());

        String trims= "   hello".trim();
        System.out.println(trims);

        String stre = strE.toUpperCase();
        System.out.println(stre);
        System.out.println(stre.toLowerCase());



//        字符串格式化

        String name  = "胡志超";
        int age = 25;
        double score = 98.765313135 ;
        String str = String.format(" 姓名： %s、 年龄: %d、 成绩: %5.2f.", name,age,score);
        System.out.println(str);


    }
}
