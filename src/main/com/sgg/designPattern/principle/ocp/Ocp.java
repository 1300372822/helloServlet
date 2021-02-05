package com.sgg.designPattern.principle.ocp;



public class Ocp {

    public static void main(String[] args) {
        //存在问题
    }
}
//这是一个用于绘图的类[使用方]
class GraphicEditor{
    //接收Shaped对象
    public void drawShape(Shape s){
        if(s.m_type == 1){
            drawCircle(s);
        }else if(s.m_type == 2){
            drawRectangle(s);
        }else if(s.m_type == 3){
            drawTriangle(s);
        }

    }
    public void drawCircle(Shape r){
        System.out.println("矩形");
    }
    public void drawRectangle(Shape r){
        System.out.println("圆形");
    }
    public void drawTriangle(Shape r){
        System.out.println("绘制三角形");
    }
}
class Shape{
    int m_type;
}
class Rectangle extends Shape{
    Rectangle(){
        super.m_type = 1;
    }
}
class Circle extends    Shape{
    Circle(){
        super.m_type = 2;
    }
}
class Triangle extends Shape{
    Triangle(){
        super.m_type = 3;
    }
}