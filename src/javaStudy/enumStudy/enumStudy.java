package javaStudy.enumStudy;

public class enumStudy {
    public static void main(String args[]){
        for(Color c:Color.values()){
            System.out.println(""+c.ordinal()+"-"+c.name()+"-"+c.toString());
        }


        // 枚举类继承接口
        IMessage msg = Color.RED;
        System.out.println(msg.getMessage());
    }


}

interface IMessage{
    public String getMessage();
}

enum Color implements IMessage{  //枚举类
    RED("红色"), GREEN("绿色"), BLUE("蓝色");//枚举对象第一行
    private String title;
    private Color(String title){
        this.title = title;
    }
    public String toString(){
        return  this.title;
    }
    public String getMessage(){
        return this.title;
    }
}


