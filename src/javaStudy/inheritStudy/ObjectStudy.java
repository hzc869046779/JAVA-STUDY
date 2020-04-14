package javaStudy.inheritStudy;

public class ObjectStudy {
    public static void main(String args[]){
        FPerson perA = new FPerson("张三", 20);
        FPerson perB = new FPerson("张三", 20);
        System.out.println(perA.equals(perB));
        }
}

class FPerson{
    private String name;
    private int age;
    public FPerson(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String toString(){
        return "姓名： "+ this.name + "、年龄： "+this.age;
    }
//    public boolean equals(Object obj){
//        if (! (obj instanceof Person)){return false;}
//        if (obj == null){return false;}
//        if (this==obj){return true;}
////        Person per = (Person) obj; //获取类中属性
////        return (this.name == per.name && this.age == per.age);
//    }
}
