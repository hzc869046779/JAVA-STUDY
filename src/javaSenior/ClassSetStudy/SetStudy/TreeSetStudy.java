package javaSenior.ClassSetStudy.SetStudy;

/**
 * @ClassName TreeSetStudy
 * @Description TODO
 * @Author hzc
 * @Date 2020/4/17 22:43
 * @Version 1.0
 */

import java.lang.reflect.Array;
import java.util.*;

/**
 * TreeSet相对于hashSet是有序的
 * TreeSet 自定义类职中保存的数据是允许排序的，但是这个类必须实现Comparable接口，这样才能确认大小关系
 * TreeSet 本质是利用TreeMap子类实现的集合数据的存储，利用comparable确定重复数据的,而hashset是利用
 * Object中的hashCode方法
 */
public class TreeSetStudy {
    public static void main(String[] args) {

        /**
        String[] arr = new String[]{"a","c","b"};
        List<String> arrlist = Arrays.asList(arr);
        TreeSet<String> treearrlist = new TreeSet<>(arrlist);
        HashSet<String> hasharrlist = new HashSet<>(arrlist);
        System.out.println("hashset:"+hasharrlist);
        System.out.println("treeset:"+treearrlist);
         **/

        TreeSet<Person> pts = new TreeSet<>();
        pts.add(new Person("胡志超",16));
        pts.add(new Person("胡志超",16));
        pts.add(new Person("关连正",22));
        pts.add(new Person("胡强",17));
        pts.add(new Person("白佳豪",22));
        System.out.println(pts);


        /**
         * 会发现hashset没有排序，也没有去处重复元素.这就说明
         * hashset判断重复并不是通过comparable来判断的
         * 而是通过hashcode equal
         *
         * 当我们在Person类中fuxie  hashcode和equals方法时候发现不在重复
         */
        HashSet<Person> hts = new HashSet<>();
        hts.add(new Person("胡志超",16));
        hts.add(new Person("胡志超",16));
        hts.add(new Person("关连正",22));
        hts.add(new Person("胡强",17));
        hts.add(new Person("白佳豪",22));
        System.out.println(hts);

    }
}

class Person implements Comparable<Person> { //比较器
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "姓名："+this.name+"年龄:"+this.age;
    }

    @Override
    public int compareTo(Person p1) {
        if(this.age<p1.age){
            return -1;
        }else if(this.age>p1.age){
            return 1;
        }else {
            return this.name.compareTo(p1.name);
        }
    }
}
