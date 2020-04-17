package javaSenior.ClassSetStudy.ListSet;

/**
 * @ClassName VectorStudy
 * @Description TODO
 * @Author hzc
 * @Date 2020/4/17 21:59
 * @Version 1.0
 */

import java.util.Vector;

/**
 * 继承结构和ArrayList相同
 * Vector之中的操作方法都是synchronized的。 所以线程安全，但是效率不如arraylist高。
 */
public class VectorStudy {
    public static void main(String[] args) {
        Vector<String> s = new Vector<>();
        s.add("h");
        s.add("z");
        s.add("c");
    }
}
