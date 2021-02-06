package com.sgg.designPattern.prototype.deepclone;

import java.io.*;

public class DeepProtoType implements Serializable,Cloneable {

    public String name;    //String 属性
    public DeepCloneableTarget deepCloneableTarget;  //引用类型

    public DeepProtoType() {
    }

    //深拷贝-方式1 使用clone方法 引用类型单独处理

    @Override
    protected Object clone() throws CloneNotSupportedException {

        Object deep = null;
        //这里完成对基本数据类型（属性）和String的克隆
        deep =super.clone();
        //对引用类单独处理
        DeepProtoType deepProtoType = (DeepProtoType) deep;
        deepProtoType.deepCloneableTarget = (DeepCloneableTarget) deepCloneableTarget.clone();
        return deepProtoType;
    }

    //深拷贝-方式2 通过对象的序列化实现（推荐）
    public Object deepClone(){
        //创建流对象
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream  ois = null;

        try{
            //1.序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);  //当前对象以对象流的方式输出
            //2.反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            DeepProtoType copyObj = (DeepProtoType)ois.readObject();
            return copyObj;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
