package javaStudy.inheritStudy;

public class inheritStudy {
    @SuppressWarnings({"deprecation"})  //让警告信息不出现
    public static void main(String args[]){
        newPerson p1 = new newPerson();
        p1.setAge(16);
        p1.setName("胡志超");
        p1.getinfo();

        System.out.println("下面是子类输出");

        student stu1 = new student();
        stu1.setAge(25);
        stu1.setName("关连正");
        stu1.setSno("S201861501");
        stu1.getinfo();

        System.out.println("----------------------");

        dog dog1 = new dog(3);
        dog1.getInfo(2);

        System.out.println("----------------------");
        animal ani1 = new dog();   //向上转型,
        ani1.test();

        System.out.println("----------向上转型------------");
        fun(new dog());
        fun(new cat());


//        向下转型  之前必须存在向上转型  《我是超人，但是假扮成普通人，现在我又要变回超人》
        animal ani2 = new dog();
        dog ani3 = (dog) ani2;
        ani3.test();


        System.out.println("----------instance------------");
//         instanceof 关键字
        System.out.println(ani2 instanceof dog);
        System.out.println(ani2 instanceof animal);

    }

    // 向上转型的优势， 统一参数
    public static void fun(animal ani){
        ani.test();
    }

}

class newPerson extends Object{
    private String name;
    private int age;

    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String  getName(){
        System.out.println("这是superclass方法");
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public void getinfo(){
        System.out.println(String.format("名字: %s , 年龄: %d",this.name,this.age ));
    }

}

//final关键词表示该类为最终类不可集成
final class student extends newPerson{
    private String sno;

    public void setSno(String num){
        this.sno = num;
    }

    @Override
    public void getinfo(){
        System.out.println(String.format("名字: %s , 年龄: %d, 学号: %s",this.getName(),super.getAge() ,this.sno));
    }
}

class animal{
    private String zoo;

    public animal(){
        this.zoo = "山西忻州动物园";
    }
    public animal(int x){
        System.out.println("这是animal类的有参构造"+x);
    }
    public void setZoo(String zoo){
        this.zoo = zoo;
    }
    public String getZoo(){
        return this.zoo;
    }
    public void getInfo(){
        System.out.println(String.format("zoo: %s",this.zoo));
    }
    public void test(){
        System.out.println("animal DesighModel.test 方法");
    }
}

class dog extends animal{

    public dog(){
        super(2);
        System.out.println("dog");
    }
    public dog(int x){
        System.out.println("这是dog类的有参构造"+x);
    }

    @Deprecated   //过期方法提醒
    public void getInfo(int x){
        String y = x+"";
        System.out.println("这是方法的重载"+y+"zoo: "+this.getZoo());
    }

    public void test(){
        System.out.println("dog DesighModel.test 方法");
    }
}

class cat extends animal{
    public void test(){
        System.out.println("cat DesighModel.test 方法");
    }
}




