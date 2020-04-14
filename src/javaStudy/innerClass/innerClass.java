package javaStudy.innerClass;

public class innerClass {
    public static void main(String args[]){
        Outer out = new Outer();
        out.fun();

        System.out.println("在外部实例化内部类");
        Outer.Inner in = new Outer().new Inner();
        in.print();
    }
}

class  Outer{
    private String msg = "www.hzc.com";
    public void fun(){
        Inner in = new Inner();
        // 访问内部类的属性
        System.out.println(in.msg1);
        in.print();
    }

    // 如果添加private外部则不能使用
    class Inner {
        private String msg1 = "内部类消息";
        public void print(){
            System.out.println(msg); //Outer类中的属性
        }
    }
}


/*
    优势： 轻松访问外部类中的私有属性
*/