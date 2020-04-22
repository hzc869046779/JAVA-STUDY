package javaSenior;

import java.util.ArrayList;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * @ClassName MapReduceStudy
 * @Description TODO
 * @Author hzc
 * @Date 2020/4/19 23:20
 * @Version 1.0
 */
public class MapReduceStudy {
    public static void main(String[] args)throws Exception {
        List<Order> all = new ArrayList<>();
        Collections.addAll(all,new Order("小强娃娃",9.9,10),
                new Order("笔记本电脑",8985.6,8), new Order("茶杯",60.5,50));
        DoubleSummaryStatistics stat = all.stream().filter((ele)->{
            return ele.getName().contains("强");
        }).mapToDouble((orderObject)->orderObject.getPrice()*orderObject.getAmount()).summaryStatistics();
        System.out.println("购买数量："+stat.getCount());
        System.out.println("平均花费"+stat.getAverage());
        System.out.println("购买数量"+stat.getCount());
    }
}

class Order{
    private String name;
    private double price;
    private int amount;

    public Order(String name, double price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
}
