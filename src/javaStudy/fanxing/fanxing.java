package javaStudy.fanxing;

public class fanxing {
    public static void main(String[] args){
        Point<String> point = new Point<String>("横坐标10","纵坐标30");
        Point<Integer> point1 = new Point<>(10,30);
        fun(point1);
        fun(point);

        System.out.println("泛型接口");
        IMessage<Integer> msg = new MessageImpl<Integer>();
        System.out.println(msg.echo(5));

        IMessage<String> msg1 = new MessageImpl<String>();
        System.out.println(msg1.echo("哈哈"));

        System.out.println("泛型方法");
        Integer num[] = fun(1,2,3);  // 传入整数，泛型类型就是整数
        for(int temp:num){
            System.out.println(temp);
        }

        System.out.println(fun("我是"));



    }

    public static <T> T[] fun(T... args){
        return args;
    }

    public static <T> T fun(T t){
        return  t;
    }

    // Point point引用传递虽然可以实现，方法中就有可能对你的数据修改   所以可以使用通配符 ？
    // ?extends Number 表示之允许Number或者Number子类   上限
    // ?super String 只能够使用String或者其父类
    public static void fun(Point<?> point){
        point.getinfo();
    }
}

class Point<T>{ //是type简写
    private T x;
    private T y;
    public Point(T x, T y){
        this.x = x;
        this.y = y;
    }
    public void getinfo(){
        System.out.println("X是"+this.x+"Y是"+this.y);
    }
}

interface IMessage<T>{
    public String echo(T t);
}
class MessageImpl<S> implements IMessage<S>{
    public String echo(S t){
        return "echo" + t;
    }
}

