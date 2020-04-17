package javaSenior.ClassSetStudy;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @ClassName SetOutPutStudy
 * @Description TODO
 * @Author hzc
 * @Date 2020/4/17 23:17
 * @Version 1.0
 */
public class SetOutPutStudy {
    public static void main(String[] args) {
        String [] str = new String[]{"hzc","glz","bjh"};
        HashSet<String> hs= new HashSet<>(Arrays.asList(str));
        Iterator<String> iter = hs.iterator();

        while (iter.hasNext()){
            String str1 = iter.next();
            if("hzc".equals(str1)){
                iter.remove(); //删除当前数据, 同时也会删除原始集合数据
            }else {
            System.out.println(str1);
            }
        }

        /**
         * 如果采用collecton中的remove方法，会产生并发更新错误。
         */
        System.out.println(hs);


        /**
         * ListIterator 不仅可以从前往后进行迭代输出. 只有List集合有
         */

        ArrayList<String> al = new ArrayList<>(hs);
        ListIterator<String> iter1 = al.listIterator();

        System.out.println("由前向后输出: ");
        while (iter1.hasNext()){
            System.out.println(iter1.next()+".");
        }

        /**
         * 想实现从后向前，先得从前遍历到后
         */
        System.out.println("从后先前输出: ");
        while (iter1.hasPrevious()){
            System.out.println(iter1.previous()+".");
        }

        /**
         * Enumeration  主要是为了Vector类服务
         */
        System.out.println("enumration输出");
        Vector<String> vf = new Vector<>(Arrays.asList(str));
        Enumeration<String> enum1 = vf.elements();
        while (enum1.hasMoreElements()){
            System.out.println(enum1.nextElement());
        }





    }
}
