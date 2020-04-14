package javaSenior.JavaBaseClass;


/**
 * 描述的就是字符串
 * 是String StringBuffer StringBuilder的父接口
 */
public class CharSequenceStudy {
    public static void main(String[] args){
        CharSequence str = "www.hzc.cn"; //String匿名子类对象向父接口转型
        str.subSequence(0,8);
        System.out.println(str);
    }
}
