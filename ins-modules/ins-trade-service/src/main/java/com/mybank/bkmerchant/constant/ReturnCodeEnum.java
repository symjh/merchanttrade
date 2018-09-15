/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.mybank.bkmerchant.constant;

/**
 * 返回码枚举
 * @author simon.xxm
 * @version $Id: TradeStatusEnum.java, v 0.1 2017年7月26日 下午5:00:00 simon.xxm Exp $
 */
public enum ReturnCodeEnum {
    
    SUCCESS("0000","成功"),
    ORDER_CLOSED("MT_PAY_ORDER_CLOSED","支付单已经被关闭"),
    ;
    
    /**
     * 返回码
     */
    private String returnCode;
    
    /**
     * 返回码描述
     */
    private String returnDesc;
    /**
     * @param returnCode
     * @param returnDesc
     */
    private ReturnCodeEnum(String returnCode, String returnDesc) {
        this.returnCode = returnCode;
        this.returnDesc = returnDesc;
    }
    /**
     * Getter method for property <tt>returnCode</tt>.
     * 
     * @return property value of returnCode
     */
    public String getReturnCode() {
        return returnCode;
    }
    /**
     * Setter method for property <tt>returnCode</tt>.
     * 
     * @param returnCode value to be assigned to property returnCode
     */
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }
    /**
     * Getter method for property <tt>returnDesc</tt>.
     * 
     * @return property value of returnDesc
     */
    public String getReturnDesc() {
        return returnDesc;
    }
    /**
     * Setter method for property <tt>returnDesc</tt>.
     * 
     * @param returnDesc value to be assigned to property returnDesc
     */
    public void setReturnDesc(String returnDesc) {
        this.returnDesc = returnDesc;
    }

}
