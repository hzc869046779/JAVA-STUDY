package javaSenior.ClassSetStudy.SetStudy;

/**
 * @ClassName HashSetStudy
 * @Description TODO
 * @Author hzc
 * @Date 2020/4/17 22:07
 * @Version 1.0
 */

import java.lang.reflect.Array;
import java.util.*;

/**
 * Set 不像List扩充了许多新的方法，所以无法使用get方法实现制定索引数据的获取
 */
public class HashSetStudy {
    public static void main(String[] args) {
        ArrayList<String> s = new ArrayList<>();
        s.add("h");
        s.add("z");
        s.add("c");
        s.add("h");

        /**
         * array -> List -> ArrayList
         */
        String [] str = new String[]{"hello","world"};
        List<String> strlist = Arrays.asList(str);
        ArrayList<String> sf = new ArrayList<>(strlist);
        sf.add("ssf");
        System.out.println(sf);

        /**
         * set 和 list的互相转换
         */
        HashSet<String> hs = new HashSet<>(s);
        ArrayList<String> s1 = new ArrayList<>(hs);
        s1.add("h");

        System.out.println(hs);
        System.out.println(s1);



    }
}
