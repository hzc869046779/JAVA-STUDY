package javaStudy.Functional;

/**
 * jdk8函数式接口，SAM类型的接口（Single Abstract Method）
 * 定义了这种类型的接口，使得以其为参数的方法，可以在调用时，使用一个lambda表达式作为参数
 * 从SAM原则上讲，这个接口中，只能有一个函数需要被实现，但是也可以有如下例外:
 *     1. 默认方法与静态方法并不影响函数式接口的契约，可以任意使用，即函数式接口中可以有静态方法，
 *     一个或者多个静态方法不会影响SAM接口成为函数式接口，并且静态方法可以提供方法实现可以由 default 修饰的默认方法方法，
 *     这个关键字是Java8中新增的，为的目的就是使得某一些接口，原则上只有一个方法被实现，但是由于历史原因，
 *     不得不加入一些方法来兼容整个JDK中的API，所以就需要使用default关键字来定义这样的方法
 *  2. 可以有 Object 中覆盖的方法，也就是 equals，toString，hashcode等方法。
 * @author hzc、
 *
 */

public class FunctionalInterface {
    public static void main(String args[]){
        IMessage msg = (str)->{
            System.out.println("发送消息:"+str);
        };
        msg.send("www.hzc.cn");

        IMath math = (t1,t2)->{
             return t1+t2;
        };
//        IMath math = (t1,t2)-> t1+t2;
        System.out.println(math.add(3,6));

        //方法引用
        IFunction<Integer,String> fun = String :: valueOf;
        String str = fun.转换(100);
        System.out.println(str.length());

        //引用了一个实例化对象的方法
        IFunction1<String> fun1 = "www.hzc.cn" :: toUpperCase;
        System.out.println(fun1.upper());

        //方法引用2
        IFunction2<String> fun3 = String::compareTo;
        System.out.println(fun3.compare("A","a"));

        //构造方法引用
        IFunction4<Person> fun4 = Person::new;
        System.out.println(fun4.create("胡志超",18).toString());
    }
}

@java.lang.FunctionalInterface  // 函数式接口
interface IMessage{
    public void send(String str);
}

@java.lang.FunctionalInterface
interface IMath{
    public int add(int x, int y);
}

@java.lang.FunctionalInterface
interface IFunction<P,R>{
    public R 转换(P p);
}

@java.lang.FunctionalInterface
interface IFunction1<R>{
    public R upper();
}

@java.lang.FunctionalInterface
interface IFunction2<P>{
    public int compare(P p1, P p2);
}

@java.lang.FunctionalInterface
interface IFunction4<R>{
    public R create(String s, int a);
}

class Person{
    private String name;
    private int age;
    public Person(String name, int age){
        this.age = age;
        this.name = name;
    }
    public String toString(){
        return "姓名："+this.name+"年龄："+this.age;
    }
}


/*
    lamda表达式格式
    1. 方法没有参数 ()->{};
    2. 方法有参数  (参数，参数)->{};
    3. 如果只有一行返回语句： (参数，参数)->语句;
*/

