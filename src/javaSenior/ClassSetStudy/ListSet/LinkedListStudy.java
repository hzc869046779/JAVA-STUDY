package javaSenior.ClassSetStudy.ListSet;

/**
 * @ClassName LinkedListStudy
 * @Description TODO
 * @Author hzc
 * @Date 2020/4/17 21:41
 * @Version 1.0
 */

import java.util.LinkedList;

/**
 *  ArrayList是数组实现的集合操作，而LinkedList是链表实现的集合操作
 *  在使用List集合中的get方法时，ArrayList时间复杂度是O（1）而LinkedList是O（n）
 *  ArrayList在使用时候默认初始化对象数组大小为10，空间不够则会采用2倍形式进行扩充，数据大时候会产生垃圾而LinkedList不会。
 *
 *  在方法上，LinkedList由于集成deque，所以会有addFirst,addLast,push,pop等操作
 */
public class LinkedListStudy {
    public static void main(String[] args) {
        LinkedList<String> s = new LinkedList<>();
        s.add("h");
        s.add("z");
        s.add("c");
        s.addFirst("sb");

        System.out.println(s);


        //可以发现其pop和push操作是将list开头当作栈底
        s.push("f");
        System.out.println(s);

        System.out.println(s.pop());
    }
}
