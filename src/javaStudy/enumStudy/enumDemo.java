package javaStudy.enumStudy;

public class enumDemo {
    public static void main(String args[]){
        Person p1 = new Person("胡志超",25,Sex.Male);
        System.out.println(p1.toString());
    }
}

enum Sex{
    Male("男"), Female("女");
    private String title;
    private Sex(String title){
        this.title = title;
    }
    public String toString(){
        return this.title;
    }
}

class Person{
    private String name;
    private int age;
    private Sex sex;

    public Person(String name, int age, Sex sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String toString(){
        return "姓名"+this.name+"年龄"+this.age+"性别"+this.sex.toString();
    }
}
