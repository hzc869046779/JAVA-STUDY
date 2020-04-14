package javaStudy;

public class staticStudy {
    public static void main(String[] args){
        Person perA = new Person("张三",10);
        Person perB = new Person("李四",10);
        Person perC = new Person("王五",10);
        Person perD = new Person();
//        Person.country = "中华人民共和国";
//        System.out.println(perA.getInfo());
//        System.out.println(perB.getInfo());
//        System.out.println(perC.getInfo());

//        Person.setCountry("美国");
        System.out.println(Person.getCount());    //static属性可以在不实例化就使用
    }
}

class Person{  //创建所有同一个国家的类
    private String name;
    private int age;
    static String country = "中国";
    private static int count = 0;

    static {  // 静态代码块，由下级最高
        System.out.println("this is a static block");
    }
    {   // 构造代码块
        System.out.println("this is a 构造 block");

    }
    public static int getCount() {   // 声明静态方法
        return count;
    }
    public Person(){   // 无参构造方法
        this("noname",16);
    }
    public Person(String name, int age){  // 有参构造方法
        this.name = name;
        this.age = age;
        count++;
        System.out.println("第"+count+"个人创建出来");
    }
    public  String getInfo(){
        return "姓名:"+ this.name + "年龄:"+this.age + "国家:" + this.country;
    }

    public static void setCountry(String c){
        country=c;
    }

}