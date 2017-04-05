package com.neil.pojo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by nhu on 4/4/2017.
 */

public class Medical {
    @JSONField
    private String id = "";

    @JSONField
    private String name;

    @JSONField
    private Double num;

    public Medical(String name, Double num) {
        this.name = name;
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }
}
