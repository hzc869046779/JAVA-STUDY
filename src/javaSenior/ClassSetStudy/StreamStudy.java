package javaSenior.ClassSetStudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName StreamStudy
 * @Description 主要是对于集合中的数据进行分析处理
 * @Author hzc
 * @Date 2020/4/19 23:04
 * @Version 1.0
 */
public class StreamStudy {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"java","js","JSON","python","ruby","go");

        Stream<String> stream = list.stream();

        /**
         * 输出统计个数
         */
//        System.out.println(stream.filter((ele)->{
//            return ele.toLowerCase().contains("j");
//        }).count());


        /**
         * 输出筛选内容
         */
        List<String> result = stream.filter((ele)->ele.toLowerCase().contains("j")).skip(2).limit(2).
                collect(Collectors.toList());
        System.out.println(result);

        /**
         * 数据分页
         */

    }
}
