package javaStudy;

public class package_class {
    public static void main(String args[]){
        Int temp = new Int(10);   //装箱
        int x = temp.intValue();   //拆箱
        System.out.println(x*2);

//        Integer实例
        Integer obj = new Integer(10);
        int sum = obj.intValue();
        System.out.println(sum);

//        Boolean实例
        Boolean obj1 = new Boolean(false);
        System.out.println(obj1);

//        自动装箱拆箱
        Integer obj2 = 10;   //自动装
        int num = obj2;    // 自动拆
        obj2++;  // 对象可以直接数学运算
        System.out.println(num*obj2);


        Object obj3 = 19.2;  //double自动装箱为Double，向上转型为Object
        double num1 = (Double) obj3;  //向下转型为包装类，再自动拆箱
        System.out.println(num1*2);


    }

}

/*
包装类:    1.5以后不需要手动装拆了
Number<abstract> {"int":Integer,"byte":Byte,"long":Long,"short":Short,"float":Float,"double":Double}
Boolean   boolean
Character    char
*/

class Int {
    private int data;  //包装了一个基本数据类型
    public Int(int data){
        this.data = data;
    }
    public int intValue(){
        return this.data;
    }
}
