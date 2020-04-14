package javaSenior.ThreadStudy.Demo;

public class ProduceComputer {
    public static void main(String[] args){
        Resource1 resource1 = new Resource1();
        Producer pro = new Producer(resource1);
        Consumer con = new Consumer(resource1);

        Thread thread1 = new Thread(pro,"第一个生产者");
        Thread thread2 = new Thread(con,"第一个消费者");
        Thread thread3 = new Thread(pro,"第二个生产者");
        Thread thread4 = new Thread(con,"第二个消费者");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();



    }
}

class Computer{
    private int count=0;
    private String name;
    private double price;
    public Computer(String name,double price){
        this.name = name;
        this.price = price;
        this.count++;
    }
    public String toString(){
        return "第"+count+"几台电脑，电脑名字"+this.name+"、价值:"+this.price;
    }

}

class Resource1{
    private Computer computer;
    public synchronized void product() throws Exception{
        if(this.computer!=null){
            super.wait();
        }
        Thread.sleep(100);
        this.computer = new Computer("胡志超电脑",500.00);
        System.out.println("当前线程"+Thread.currentThread().getName()+"生产电脑"+this.computer);
        super.notifyAll();

    }
    public synchronized void get() throws Exception{
        if(this.computer==null){
            super.wait();
        }
        Thread.sleep(10);
        System.out.println("当前线程"+Thread.currentThread().getName()+"购买电脑"+this.computer);
        this.computer = null;
        super.notifyAll();
    }
}

class Producer implements Runnable{
    private Resource1 resource;
    public Producer(Resource1 resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int x=0;x<50;x++){
            try {
                this.resource.product();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{
    private Resource1 resource;
    public Consumer(Resource1 resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int x=0;x<50;x++){
            try {
                this.resource.get();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}


