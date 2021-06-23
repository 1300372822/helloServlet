package com.sgg.adapter.classadapter;

public class VoltageAdapter extends Voltage220V implements IVoltage5V{

    @Override
    public int output5V() {
        //获取到220电压
        int srcV = output220V();
        int dstV = srcV/44;     //转成5V
        return dstV;
    }
}
