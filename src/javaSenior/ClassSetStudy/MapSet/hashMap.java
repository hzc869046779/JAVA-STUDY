package javaSenior.ClassSetStudy.MapSet;

/**
 * @ClassName hashMap
 * @Description TODO
 * @Author hzc
 * @Date 2020/4/19 10:51
 * @Version 1.0
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * collction集合保存数据的目的是为了输出 Map集合保存数据的目的是为了进行key的查找。
 *
 * 重要方法 put  get  entrySet
 *
 * key=value，里面的数据是不重复的
 *
 * 面试：hashmap中put方法是如何进行容量扩充的
 * 1. 在hashmap类里提供有一个“DEFAULT_INITIAL_CAPACITY”常亮，作为初始化大小为16个元素，即默认长度
 * 2. 当保存的内容的容量超过了某个阈值（DEFAULT_LOAD_FACTOR = 0.75F）时候就会进行容量的扩充
 * 3. 在进行扩充的时候，hashmap采用成倍扩充
 *
 * 面试：hashmap工作原理
 * 1. 在hashMap中进行数据存储仍然是利用Node类完成的，即链表0n，二叉树0logn
 * 2. 从1.8开始以后，hashmap的实现出现了改变，为了适应大数据的海量数据，在hashmap内部提供一个重要常亮
 * “static final int TREEIFY_THRESHOLD=8”在使用hashmap进行数据保存是，如果没超过8，用链表，如果
 * 超过8则会将链表转为红黑树以实现树的平衡，并且利用左旋右旋保证数据的查询性能.
 *
 * 面试：进行hashmap进行数据操作视乎出现了hash冲突，怎么解决的
 * 会在冲突的位置，改变为链表存储
 */
public class hashMap {
    public static void main(String[] args)throws Exception {
        Map<String,Integer> map = new HashMap<>();

        /**
         * key值重复时候新的key会覆盖旧的key
         * put方法返回值。 不重复的时候返回null，重复的时候返回旧的value
         *
         * hashmap.node  -> map.enry
         * map.entry主要作用就是作为一个key和calue的包装类型使用
         */
        map.put("one",1);
        map.put("two",2);
        map.put("one",101);
        map.put(null,0);
        map.put("zero",null);
        System.out.println(map);
        System.out.println(map.get("one"));


        /**
         * hashmap的存储顺序是无序的，但是如果希望他顺序为其增加顺序，可以更换为linkedHashMap
         */

        Map<String,Integer> map1 = new LinkedHashMap<>();

        map1.put("one",1);
        map1.put("two",2);
        map1.put("one",101);
        map1.put(null,0);
        map1.put("zero",null);
        System.out.println(map1);

        /**
         * hashtable key和value不允许为空
         * hashmap方法属于异步方法，非线程安全，hashtable同步方法，线程安全
         */
        Map<String,Integer> map2 = new Hashtable<>();

        try {
            map2.put("one",1);
            map2.put("two",2);
            map2.put("one",101);
            map2.put(null,0);
            map2.put("zero",null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(map2);

        /**
         * 利用entryset方法  map->set
         * 利用iterator方法获取map.entry对象
         */

        Iterator<Map.Entry<String,Integer>> iter = map.entrySet().iterator();

        System.out.println(map.entrySet());
        while (iter.hasNext()){
            Map.Entry<String,Integer> me = iter.next();
            System.out.println(me.getKey()+":"+me.getValue());
        }

        /**
         * propertiesDEMO
         * 资源文件的输入与输出处理，但是实际开发中，主要为了读取配置资源的信息
         */

        Properties prop = new Properties();
        // 设置内容只能是字符串
        prop.setProperty("hzc","www.hzc.cn");
        prop.setProperty("mldnjava","www.hava.cn");
        prop.setProperty("zckj","www.zhichaokj.cn");
//        prop.store(new FileOutputStream(new File("D:/info.properties")),"this is zhushi");
        prop.load(new FileInputStream(new File("D:/info.properties")));
        System.out.println(prop.getProperty("zckj"));








    }
}
