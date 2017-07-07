package com.fmyl.demo.model;

import com.fmyl.demo.base.BaseModel;

import java.util.List;

/**
 * Created by fuzq on 17/7/6.
 */
public class Page<T> extends BaseModel {

    /**
     * 目标对象
     */
    private T model;
    /**
     * 当前页 默认为0
     */
    private int pn = 0;
    /**
     * 每页条数 默认为3
     */
    private int limit = 3;
    /**
     * 返回结果
     */
    private List<T> list;
    /**
     * 总条数
     */
    private int total;
    /**
     * 起始条数 {pn * limit}
     */
    private int offset;
    /**
     * 当页条数 {list.size()}
     */
    private int size;
    /**
     * 总页数 {total / limit}
     */
    private int maxPn;

    private Page() {
    }

    public Page(int pn, T model) {
        this.pn = pn;
        this.model = model;
    }

    public Page(int pn, T model, int limit) {
        this.pn = pn;
        this.model = model;
        this.limit = limit;
    }

    public int getOffset() {
        return pn * limit;
    }

    public int getSize() {
        return list != null ? list.size() : 0;
    }

    public int getMaxPn() {
        return total / limit;
    }

    public Page result(List<T> list, int total) {
        this.list = list;
        this.total = total;
        return this;
    }

    @Override
    public String toString() {
        return "Page{" +
                "model=" + model +
                ", pn=" + pn +
                ", limit=" + limit +
                ", offset=" + offset +
                ", list=" + list +
                ", total=" + total +
                ", size=" + size +
                '}';
    }
}
