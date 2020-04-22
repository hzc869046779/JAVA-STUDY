package javaSenior.ClassSetStudy;

import java.util.Stack;

/**
 * @ClassName StackStudy
 * @Description JAVA栈
 * @Author hzc
 * @Date 2020/4/19 19:49
 * @Version 1.0
 */

/**
 *
 */
public class StackStudy {
    public static void main(String[] args) {
        Stack<String> all = new Stack<>();
        all.push("A");
        all.push("B");
        all.push("C");
        System.out.println(all.pop());
        System.out.println(all.pop());
        System.out.println(all.pop());
    }
}
