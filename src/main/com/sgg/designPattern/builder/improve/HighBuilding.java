package com.sgg.designPattern.builder.improve;

public class HighBuilding extends HouseBuilder{

    @Override
    public void buildBasic() {
        System.out.println("高楼打地基5米");
    }

    @Override
    public void buildWalls() {
        System.out.println("高楼砌墙10米");
    }

    @Override
    public void roofed() {
        System.out.println("高楼屋顶10米");

    }

}
