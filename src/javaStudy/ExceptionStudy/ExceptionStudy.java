package javaStudy.ExceptionStudy;

public class ExceptionStudy {
    public static void main(String args[]){
        System.out.println("程序开始执行");
        try {
            System.out.println("数学计算"+(10/2));
        }
        catch (ArithmeticException e){
            e.printStackTrace();
        }
        finally {
            System.out.println("不管出现异常我都出现");
        }
        System.out.println("程序执行完毕");

        System.out.println(add(3.0,0));

    }


    // throw:   是在代码块中使用，主要是手工进行异常对象的抛出
    // throws:  是在方法定义上使用的，表示将此方法中可能产生的异常明确的告诉调用处
    private static double add(double a,double b)throws ArithmeticException{
        return a/b;
    }
}

