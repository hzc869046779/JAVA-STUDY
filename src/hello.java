public class hello {
    public static void main(String[] args)
    {
        Person p = new Person("胡志超",18,0);
        p.tell();

//        <setter getter>
//        p.setName("胡志超");
//        p.setAge(18);
//        p.tell();
//        int m = p.getAge();
//        System.out.println("getAge:"+m);


    }
}

class Person{
    private String name;
    private int age;
    private int sex;
    public void tell(){
        System.out.println("姓名:"+name + "  "+ "年龄:" + age);
    }

    public void setName(String n){ this.name=n; }
    public void setAge(int age) { this.age = age; }
    public String getName(){return this.name;}
    public int getAge(){return this.age;}

//    构造方法定义
    public Person(){ System.out.println("一个新的Person类对象实例化了");}
    public Person(String n, int a){
        this.name = n;
        this.age = a;
        System.out.println("构造方法调用成功");
    }
    public Person(String n, int a, int c){
        this();   //构造函数内部调用
        this.name = n;
        this.age = a;
        this.sex = c;
        System.out.println("构造方法2调用成功");
    }
}

