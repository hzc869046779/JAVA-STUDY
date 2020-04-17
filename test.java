package DesignModel;

public class test {
    public static void main(String[] args){
        ss("abc",1.5,1.7);
    }

      private static void ss(String s, double... args){
        int length = args.length;
        for(int m=0;m<length;m++){
            System.out.println(args[m]);
        }

    }
}
