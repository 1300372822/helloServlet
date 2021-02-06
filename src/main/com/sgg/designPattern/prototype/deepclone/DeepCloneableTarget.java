package com.sgg.designPattern.prototype.deepclone;

import java.io.Serializable;

public class DeepCloneableTarget implements Serializable,Cloneable {
    private static final long serialVersionUID = 1L;

    private String cloneName;
    private String cloneClass;

    public DeepCloneableTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    /**因为该类的属性都是String，因此使用默认的clone方法完成即可
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
