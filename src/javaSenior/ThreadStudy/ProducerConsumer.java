package javaSenior.ThreadStudy;

import java.awt.image.renderable.RenderableImage;

class Producer implements Runnable{
    private Message msg;
    public Producer(Message msg){
        this.msg = msg;
    }

    @Override
    public void run() {
        for(int x=0;x<100;x++){
            if(x%2==0){
                /**
                this.msg.setContent("宇宙大帅哥");
                try {
                    Thread.sleep(100);  //模拟延
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.msg.setTitle("胡志超");
            }else {
                this.msg.setTitle("侯志刚");
                try {
                    Thread.sleep(100);  //模拟延
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.msg.setContent("猥琐第一人");*/
                this.msg.set("胡志超","宇宙大帅哥");

            }else {
                this.msg.set("侯志刚","猥琐第一人");
            }
        }
    }
}


class Consumer implements Runnable{
    private Message msg;
    public Consumer(Message msg){
        this.msg = msg;
    }

    @Override
    public void run() {
        for(int x=0;x<100;x++){
            /**
            try {
                Thread.sleep(10);  //模拟延
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.msg.getTitle()+"是一个"+this.msg.getContent());*/
            System.out.println(this.msg.get());
        }
    }
}

/**
class Message{
    private String title;
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }
}
 */

class Message{
    private String title;
    private String content;
    private boolean flag;

    /**
     * 利用等待唤醒解决重复操作问题.使得达到生产一个取走一个的效果
     * @param title
     * @param content
     */


    public synchronized void set(String title,String content){

        if(!this.flag){
            try {
                super.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.content=content;
        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        this.title=title;
        this.flag = false;
        super.notify();
    }
    public synchronized String get(){
        if(this.flag){
            try {
                super.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        try {
            return this.title + "---" + this.content;
        }finally {
            this.flag = true;
            super.notify();
        }

    }
}

public class ProducerConsumer {
    public static void main(String args[]) throws Exception{
        Message msg = new Message();
        new Thread((new Producer(msg))).start();
        new Thread((new Consumer(msg))).start();
    }
}


