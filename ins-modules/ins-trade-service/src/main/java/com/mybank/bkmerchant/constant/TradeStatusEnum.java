/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.mybank.bkmerchant.constant;

import org.apache.commons.lang.StringUtils;

/**
 * 订单状态枚举
 * @author simon.xxm
 * @version $Id: TradeStatusEnum.java, v 0.1 2017年7月26日 下午5:00:00 simon.xxm Exp $
 */
public enum TradeStatusEnum {

    succ("succ", "支付成功"), 
    fail("fail", "失败"), 
    paying("paying", "支付中"), 
    closed("closed", "已关单"), 
    cancel("cancel","已撤消"),
    refunding("refunding","退款中"), 
    ;

    /**
     * 订单状态码
     */
    private String statusCode;

    /**
     * 订单状态描述
     */
    private String statusDesc;

    /**
     * @param statusCode
     * @param statusDesc
     */
    private TradeStatusEnum(String statusCode, String statusDesc) {
        this.statusCode = statusCode;
        this.statusDesc = statusDesc;
    }

    /**
     * 根据状态码获取交易状态枚举
     * 
     * @param statusCode
     * @return
     */
    public static TradeStatusEnum getTradeStatusByCode(String statusCode) {
        if (StringUtils.isEmpty(statusCode)) {
            return null;
        }
        for (TradeStatusEnum tradeStatus : values()) {
            if (StringUtils.equals(statusCode, tradeStatus.getStatusCode())) {
                return tradeStatus;
            }
        }
        return null;
    }

    /**
     * Getter method for property <tt>statusCode</tt>.
     * 
     * @return property value of statusCode
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * Setter method for property <tt>statusCode</tt>.
     * 
     * @param statusCode value to be assigned to property statusCode
     */
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * Getter method for property <tt>statusDesc</tt>.
     * 
     * @return property value of statusDesc
     */
    public String getStatusDesc() {
        return statusDesc;
    }

    /**
     * Setter method for property <tt>statusDesc</tt>.
     * 
     * @param statusDesc value to be assigned to property statusDesc
     */
    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

}
