package javaStudy.ExceptionStudy;

public class MyMathException {
    public static void main(String args[]){
        try {
            System.out.println(MyMath.div(10,0));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

class MyMath{
    // 异常交给被调用出处理
    public static int div(int x,int y) throws Exception{
        int temp=0;
        System.out.println("除法计算开始");
        try {
            temp = x/y;
        }catch (Exception e){
            throw e;
        }finally {
            System.out.println("除法计算结束");
        }
        return temp;
    }
}


/*
RuntimeException是Exception的子类
RuntimeException标注的异常可以不需要进行强制性处理<使用try catch处理>，而Exception相反。

Numberformate、Classcast、NullPointer、
*/
