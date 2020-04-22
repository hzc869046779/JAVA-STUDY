package javaSenior.ClassSetStudy;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName QueueStudy
 * @Description TODO
 * @Author hzc
 * @Date 2020/4/19 19:56
 * @Version 1.0
 */
public class QueueStudy {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        ((LinkedList<String>) queue).push("A");
        ((LinkedList<String>) queue).push("B");
        ((LinkedList<String>) queue).push("C");
        System.out.println(queue.peek());  //弹出但是不删除
        System.out.println(queue.poll());  //弹出删除


        /**
         * 使用PriorityQueue实现   实现排序
         */
        Queue<String> queue1 = new PriorityQueue<>();
        queue1.offer("X");
        queue1.offer("A");
        queue1.offer("Z");
        System.out.println(queue1.poll());
        System.out.println(queue1.poll());
        System.out.println(queue1.poll());





    }
}
