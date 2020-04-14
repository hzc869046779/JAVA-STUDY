package javaStudy.packageTest;

public class MyMath {
    public static int sum(int... args){
        int sum = 0;
        for(int temp :args){
            sum+=temp;
        }
        return sum;
    }

    public static int jianfa(int a,int b){
        return a-b;
    }
}
