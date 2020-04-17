package javaSenior.ClassSetStudy.ListSet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName ArrayListStudy
 * @Description TODO
 * @Author hzc
 * @Date 2020/4/17 17:15
 * @Version 1.0
 */

/**
 * ArrayList里面包含的数据实际上就是一个对象数组.如果进行数据追加的时候发现AL集合里面保存的对象数组长度不够的时候
 * 会进行新的数组开辟，并且将旧数组内容拷贝到新数组。
 *
 * 默认开辟大小为10的数组
 *
 * 在arraylist使用时候一定要估算出数据量多少，超过10个，使用有参构造
 *
 * // 默认构造函数
 * ArrayList()
 *
 * // capacity是ArrayList的默认容量大小。当由于增加数据导致容量不足时，容量会添加上一次容量大小的一半。
 * ArrayList(int capacity)
 *
 * // 创建一个包含collection的ArrayList
 * ArrayList(Collection<? extends E> collection)
 */
public class ArrayListStudy {
    public static void main(String[] args) {
        ArrayList<String> s = new ArrayList<>();
        s.add("h");
        s.add("z");
        s.add("c");

        ArrayList<String> s1 = new ArrayList<>();
        s.add("g");
        s.add("l");
        s.add("z");

        System.out.println(s.addAll(s1));

        s.forEach((str)->{
            System.out.print(str+'、');
        });

        /**
         * 三中遍历方式
         */
        for(String temp:s){
            System.out.print(temp);
        }

        Iterator iter = s.iterator();
        while (iter.hasNext()){
            System.out.print((String) iter.next());
        }

        int size = s.size();
        for(int i=0;i<size; i++){
            System.out.print(s.get(i));
        }
    }
}
