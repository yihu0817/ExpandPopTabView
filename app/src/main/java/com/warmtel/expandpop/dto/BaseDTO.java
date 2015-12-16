package com.warmtel.expandpop.dto;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA. User: LanJian Date: 12-6-5 Time: 下午5:21 To change
 * this template use File | Settings | File Templates.
 */
@SuppressWarnings("serial")
public class BaseDTO implements Serializable {
    private String id;
    private String name;

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

}
