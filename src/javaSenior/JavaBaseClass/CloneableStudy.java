package javaSenior.JavaBaseClass;


public class CloneableStudy {
    public static void main(String[] args)throws Exception {
        MyMember memberA = new MyMember("hzc",15);
        MyMember memberB = (MyMember) memberA.clone();

        System.out.println(memberA.name);
        System.out.println(memberB.name);

        memberA.name = "ddd";
        System.out.println(memberA.name);
        System.out.println(memberB.name);
    }



}


class MyMember implements Cloneable{
    public String name;
    public int age;
    public MyMember(String name,int age){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "name"+this.name+"age"+this.age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}