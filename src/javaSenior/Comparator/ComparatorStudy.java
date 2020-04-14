package javaSenior.Comparator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @ClassName ComparatorStudy
 * @Description Comparator
 * @Author hzc
 * @Date 2020/4/13 9:14
 * @Version 1.0
 *
 * 区别: java.lang.comparable 是在类定义的时候实现的父接口，主要用于定义排序规则，里面只有一个compareTo方法
 *      java.util.comparator 是挽救的比较器操作，需要设置单独的比较器规则类实现排序，里面有compare方法
 */
public class ComparatorStudy {
    public static void main(String[] args) {
//        Integer data[] = new Integer[]{10,9,5,2,20};
//        String data[] = new String[]{"A","B","D","C"};
        Persoon data[] = new Persoon[]{
            new Persoon("hzc",25),
            new Persoon("zx",24),
            new Persoon("wl",22)
        };
        Arrays.sort(data,new PersoonComparator());
        System.out.println(Arrays.toString(data));


    }
}


/**
 * Comparable
class Persoon implements Comparable<Persoon> {
    private String name;
    private int age;

    public Persoon(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name+"年龄"+this.age;
    }

    @Override
    public int compareTo(Persoon per) {
        return  this.age - per.age;
    }
}
 */

class Persoon{
    private String name;
    private int age;

    public Persoon(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name+"年龄"+this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class PersoonComparator implements Comparator<Persoon>{
    @Override
    public int compare(Persoon o1, Persoon o2) {
        return o1.getAge()-o2.getAge();
    }
}
