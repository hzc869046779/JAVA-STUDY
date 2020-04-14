package javaSenior.MathClass;
import java.lang.Math;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Random;

public class MathDemo {
    public static void main(String[] args) {
        System.out.println(Math.round(-15.5));
        System.out.println(Math.round(-15.51));
        System.out.println(Math.round(15.51));
        System.out.println(Math.round(15.5));
        System.out.println(Math.round(15.4));



        /**
         *
         *Random  setseed假如long值是的结果一样
         */
        Random rand = new Random();
        rand.setSeed(555L);
        for(int x=0;x<10;x++){
            System.out.println(rand.nextInt(10));
        }

        /**
         * BigInteger是整数   BigDecimal是小数
         */

        BigInteger bigA = new BigInteger("123123165165515616");
        BigInteger bigB = new BigInteger("131561563");
        System.out.println(bigA.add(bigB));
        System.out.println(bigA.subtract(bigB));
        System.out.println(bigA.multiply(bigB));
        System.out.println(bigA.divide(bigB));

        BigInteger result[] = bigA.divideAndRemainder(bigB);
        System.out.println("商"+result[0]+"、余数"+result[1]);


        BigDecimal bigC = new BigDecimal("21312315.13156");
        BigDecimal bigD = new BigDecimal("15684768.163");
        System.out.println(MathUtil.round(123.465465,2));
        System.out.println(bigC.multiply(bigD));



    }
}

class MathUtil{
    private MathUtil(){}

    public static double round(double num,int scale){
        return new BigDecimal(num).divide(new BigDecimal(1.0),scale, RoundingMode.HALF_UP).doubleValue();
    }
}


