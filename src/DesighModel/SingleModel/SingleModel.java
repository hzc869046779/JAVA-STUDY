package DesighModel.SingleModel;

public class SingleModel {
    public static void main(String args[]){
        Single sig = Single.getInstance();
        sig.print();
        Single sig1 = Single.getInstance();
        sig1.print();
        System.out.println(sig==sig1);


    }
}

// 标准单例模式
class Single{
    private static final Single instance = new Single();
    private Single(){}
    public static Single getInstance(){
        return instance;
    }
    public void print(){
        System.out.println("单例模式");
    }
}


// 非单例模式，每次都会new一个实例化对象返回
/*class Single{
    private Single(){}
    public static Single getInstance(){
        Single sig = new Single();
        return sig;
    }
    public void print(){
        System.out.println("单例模式");
    }
}*/
