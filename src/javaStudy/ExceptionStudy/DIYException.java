package javaStudy.ExceptionStudy;

public class DIYException {
    public static void main(String args[]) throws Exception{
        Food.eat(11);
    }
}

class BombException extends RuntimeException{
    public BombException(String msg){
        super(msg);
    }
}

class Food{
    public static void eat(int num) throws BombException{
        if(num>10){
            throw new BombException("吃太多了，肚子爆炸");
        }else{
            System.out.println("正常吃不怕");
        }
    }
}