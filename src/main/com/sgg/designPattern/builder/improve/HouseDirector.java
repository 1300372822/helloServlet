package com.sgg.designPattern.builder.improve;


/**
 * 指挥者，这里去动态指定制作流程
 */
public class HouseDirector {

    HouseBuilder houseBuilder = null;
    //构造器传入 houseBuilder
    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }
    //通过setter传入 houseBUilder
    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }
    //如何处理建造房子的流程，交给指挥者
    public House constructHouse(){
        houseBuilder.buildBasic();
        houseBuilder.buildWalls();
        houseBuilder.roofed();
        return houseBuilder.buildHouse();
    }


}
