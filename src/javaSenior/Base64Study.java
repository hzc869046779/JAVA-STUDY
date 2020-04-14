package javaSenior;

import java.util.Base64;

public class Base64Study {

    public static void main(String[] args) {
        String msg = "www.hzc.cn";
        String encMsg = new String(Base64.getEncoder().encode(msg.getBytes()));
        System.out.println(encMsg);

        String oldmsg = new String(Base64.getDecoder().decode(encMsg));
        System.out.println(oldmsg);


        /**
         * 建议使用多次操作，提高安全性
         */


        /**
         * 为什么不能实例化对象？
         */
        String str = StringUtil.encode("www.hzc.cn");
        System.out.println(str);
        System.out.println(StringUtil.decode(str));

    }
}

class StringUtil{
    private static final String SALT = "hzc";
    private static final int REPEAT =  5;

    /**
     * 加密处理
     * @param str 需要加密的字符串
     * @return
     */
    public static String encode(String str){
        String temp = str + "{" + SALT + "}";
        byte data[] = temp.getBytes();
        for(int x=0;x<REPEAT;x++){
            data = Base64.getEncoder().encode(data);
        }
        return new String(data);

    }

    /**
     * 解密处理
     * @param str
     * @return
     */
    public static String decode(String str){
        byte data[] = str.getBytes();
        for (int x=0;x<REPEAT;x++){
            data = Base64.getDecoder().decode(data);
        }
        return new String(data).replaceAll("\\{\\w+\\}","");
    }
}
