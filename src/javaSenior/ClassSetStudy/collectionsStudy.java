package javaSenior.ClassSetStudy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName collectionsStudy
 * @Description TODO
 * @Author hzc
 * @Date 2020/4/19 22:57
 * @Version 1.0
 */


/**
 * collection 和 collections区别
 * collection 是集合接口，允许保存单值对象
 * collectons 是集合操作的工具类。
 */
public class collectionsStudy {
    public static void main(String[] args) throws Exception{
        List<String> all = new ArrayList<>();
        Collections.addAll(all,"hello","hzc","glz");
        Collections.sort(all);  //先排序
        System.out.println(Collections.binarySearch(all,"hzc"));

        Collections.reverse(all);
        System.out.println(all);


    }
}
