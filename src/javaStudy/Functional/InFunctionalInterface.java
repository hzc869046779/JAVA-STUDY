package javaStudy.Functional;
import java.util.function.*;

/**
 * 函数内建接口
 *
 *
 * author: hzc
 */

public class InFunctionalInterface {
    public static void main(String args[]){
        //功能型
        Function<String,Boolean> fun = "**hello" :: startsWith;
        System.out.println(fun.apply("word"));

        Function<String,Integer> fun8 = "hello" :: compareToIgnoreCase;
        System.out.println(fun8.apply("world"));

        Function<String,Integer> fun7 = Integer::parseInt;
        System.out.println(fun7.apply("123"));

        Function<Double,Integer> fun10 = (t1)->{
            return t1.intValue();
        };
        System.out.println(fun10.apply(12.07));


        //消费型
        Consumer<String> con = System.out :: println;
        con.accept("www.hzc.cn");

        //供给型
        Supplier<String> sup = "WWW.HZC.CN" :: toLowerCase;
        System.out.println(sup.get());

        DoubleSupplier sup1 = ()->{
            return 12.0;
        };
        System.out.println(sup1.getAsDouble());


        //断言型
        Predicate<String> p ="##hello"::startsWith;
        System.out.println(p.test("##"));

    }

}