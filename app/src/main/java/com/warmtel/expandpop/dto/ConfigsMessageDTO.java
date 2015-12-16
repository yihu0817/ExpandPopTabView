/**
 * Copyright 2012 viktor.zhou
 */
package com.warmtel.expandpop.dto;

/**
 * @Description: TODO
 * @author: viktor.zhou(zhous028@gmail.com)
 * @date:2012-6-18
 * @version: v1.0.0  
 */
public class ConfigsMessageDTO {
    private String resultCode;
    private String resultInfo;
    private ConfigsDTO info;
    public String getResultCode() {
        return resultCode;
    }
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }
    public String getResultInfo() {
        return resultInfo;
    }
    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }
    public ConfigsDTO getInfo() {
        return info;
    }
    public void setInfo(ConfigsDTO info) {
        this.info = info;
    }
    
}
