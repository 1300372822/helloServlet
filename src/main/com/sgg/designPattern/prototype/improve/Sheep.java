package com.sgg.designPattern.prototype.improve;

/**
 *
 */
public class Sheep  implements Cloneable{

    private String name;
    private int age;
    private String color;
    public Sheep friend;  //是对象,克隆时会如何处理

    public Sheep(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", friend=" + friend.hashCode() +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**克隆该实例，使用默认的clone方法完成
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {

        Sheep sheep = null;
        try {
            sheep = (Sheep) super.clone();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return sheep;
    }
}
