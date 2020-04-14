package javaStudy.interface_study;

public class interface_demo {
    public static void main(String args[]){
//        Computer mycom = new Computer();
//        IUSB mykey = new Keyboard();
//        IUSB myprint = new Print();
//        mycom.plugin(mykey);
//        mycom.plugin(myprint);

        IUSB usb = Factory.getInstance("Keyboard");
        usb.work();
    }
}

interface IUSB{
    public boolean check();
    public void work();
}

class Computer{
    public void plugin(IUSB usb){
        if (usb.check()){
            usb.work();
        }
    }
}

class Keyboard implements IUSB{
    public boolean check(){
        return true;
    }
    public void work(){
        System.out.println("开始进行码字任务。");
    }
}

class Print implements IUSB{
    public boolean check(){
        return false;
    }
    public void work(){
        System.out.println("开始进行照片打印");
    }
}

class Factory{
    public static IUSB getInstance(String className){
        if("Keyboard".equals(className)){
            return new Keyboard();
        }else if("Print".equals(className)){
            return new Print();
        }else {
            return null;
        }
    }
}
