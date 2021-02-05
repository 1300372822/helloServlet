package com.sgg.designPattern.principle.ocp.improve;



public class Ocp {

    public static void main(String[] args) {
        //存在问题
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
    }
}

//这是一个用于绘图的类[使用方]
class GraphicEditor{
    //接收Shaped对象
    public void drawShape(Shape s){
        s.draw();
        }

    }

//改为抽象类
abstract  class Shape{
    int m_type;
    public abstract void draw(); //抽象方法
}

class Rectangle extends Shape{
    Rectangle(){
        super.m_type = 1;
    }

    @Override
    public void draw() {
        System.out.println("绘制矩形");
    }
}

class Circle extends    Shape{
    Circle(){
        super.m_type = 2;
    }

    @Override
    public void draw() {
        System.out.println("绘制圆形");
    }
}

class Triangle extends Shape{
    Triangle(){
        super.m_type = 3;
    }

    @Override
    public void draw() {
        System.out.println("绘制三角形");
    }
}