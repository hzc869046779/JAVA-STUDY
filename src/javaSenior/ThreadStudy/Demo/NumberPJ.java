package javaSenior.ThreadStudy.Demo;

public class NumberPJ {
    public static void main(String[] args){
        Resource res = new Resource();
        SubThread st = new SubThread(res);
        AddThread at = new AddThread(res);
        Thread threadA = new Thread(st,"减法线程");
        Thread threadB = new Thread(at,"加法线程");
        Thread threadC = new Thread(st,"减法线程1");
        Thread threadD = new Thread(at,"加法线程1");
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

    }
}

class Resource{
    private int num=0;
    private boolean flag=true;

    public synchronized void add() throws Exception{
        if(!flag){
            super.wait();
        }
        Thread.sleep(100);
        this.num++;
        System.out.println("加法操作-"+Thread.currentThread().getName()+"num="+this.num);
        flag=false;
        super.notifyAll();

    }
    public synchronized void sub() throws Exception{
        if(flag){
            super.wait();
        }
        Thread.sleep(200);
        this.num--;
        System.out.println("减法操作-"+Thread.currentThread().getName()+"num="+this.num);
        flag=true;
        super.notifyAll();

    }
}

class AddThread implements Runnable{
    private Resource resource;
    public AddThread(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int x=0;x<50;x++){
            try {
                this.resource.add();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}

class SubThread implements Runnable{
    private Resource resource;
    public SubThread(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int x=0;x<50;x++){
            try {
                this.resource.sub();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}