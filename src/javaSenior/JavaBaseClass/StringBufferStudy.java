package javaSenior.JavaBaseClass;

/**
 * String StringBuffer
 * String 不可改变。  StringBuffer 可以改变
 *
 * StringBuffer 线程安全  StringBuilder线程不安全
 */

public class StringBufferStudy {
    public static void main(String args[]){
        String str="hello";
        str.replace("e","s");
        System.out.println(str);

        StringBuffer str1 = new StringBuffer("hello");
        str1.append("world");
        System.out.println(str1);

        /**
         * String中没有的
         */

        str1.insert(0,"hzc ");
        System.out.println(str1);

        str1.delete(9,18);
        System.out.println(str1.reverse());


    }
}
