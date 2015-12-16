/**
 * Copyright 2012 viktor.zhou
 */
package com.warmtel.expandpop.dto;

import com.warmtel.expandtab.KeyValueBean;

import java.util.List;

/**
 * @Description: TODO
 * @author: viktor.zhou(zhous028@gmail.com)
 * @date:2012-6-18
 * @version: v1.0.0
 */
public class ConfigsDTO extends BaseDTO {
    List<ConfigAreaDTO> cantonAndCircle;
    List<KeyValueBean> decorType;
    List<KeyValueBean> managerType;
    List<KeyValueBean> openDateType;
    List<KeyValueBean> priceType;
    List<KeyValueBean> sortType;

    public List<ConfigAreaDTO> getCantonAndCircle() {
        return cantonAndCircle;
    }

    public void setCantonAndCircle(List<ConfigAreaDTO> cantonAndCircle) {
        this.cantonAndCircle = cantonAndCircle;
    }

    public List<KeyValueBean> getDecorType() {
        return decorType;
    }

    public void setDecorType(List<KeyValueBean> decorType) {
        this.decorType = decorType;
    }

    public List<KeyValueBean> getManagerType() {
        return managerType;
    }

    public void setManagerType(List<KeyValueBean> managerType) {
        this.managerType = managerType;
    }

    public List<KeyValueBean> getOpenDateType() {
        return openDateType;
    }

    public void setOpenDateType(List<KeyValueBean> openDateType) {
        this.openDateType = openDateType;
    }

    public List<KeyValueBean> getPriceType() {
        return priceType;
    }

    public void setPriceType(List<KeyValueBean> priceType) {
        this.priceType = priceType;
    }

    public List<KeyValueBean> getSortType() {
        return sortType;
    }

    public void setSortType(List<KeyValueBean> sortType) {
        this.sortType = sortType;
    }

}
