package com.sgg.adapter.objectadapter;

public class VoltageAdapter implements IVoltage5V {
    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {

        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {

        int dst = 0;
        if(voltage220V!= null){
            int src = voltage220V.output220V();  //获取220电压
            System.out.println("使用对象适配器，进行转化");
            dst = src/44;

            System.out.println("适配完成，输出电压="+dst);
        }

        return dst;
    }
}
