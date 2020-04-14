package javaStudy.interface_study;

import javafx.scene.shape.Shape;

public class ShapeDemo {
    public static void main(String args[]){
        Abstractshape asa = Myfactory.getInstance("Circular", 1.5);
        Abstractshape asb = Myfactory.getInstance("Rectangle",4.0,7.2);
        System.out.println(asa.area());
        System.out.println(asb.area());
    }
}

abstract class Abstractshape{
    public abstract double area();
    public abstract double perimeter();
}

class Circular extends Abstractshape{
    private double radius;
    public Circular(double radius){
        this.radius = radius;
    }
    public double area(){
        return 3.1415926 * this.radius * this.radius;
    }
    public double perimeter(){
        return 2 * 3.1415926 * this.radius;
    }
}

class Rectangle extends Abstractshape{
    private double length;
    private double width;
    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }
    public double area(){
        return this.width * this.length;
    }
    public double perimeter(){
        return 2 * (this.width + this.length);
    }
}

class Myfactory{
    public static Abstractshape getInstance(String classsName, double... args){
        if("Circular".equalsIgnoreCase(classsName)){
            return new Circular(args[0]);
        }else if("Rectangle".equalsIgnoreCase(classsName)){
            return new Rectangle(args[0],args[1]);
        }else {
            return null;
        }
    }
}