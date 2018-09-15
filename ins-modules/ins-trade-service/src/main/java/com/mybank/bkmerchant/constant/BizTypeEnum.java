/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.mybank.bkmerchant.constant;

import org.apache.commons.lang.StringUtils;

/**
 * 业务类型枚举
 * @author simon.xxm
 * @version $Id: TradeStatusEnum.java, v 0.1 2017年7月26日 下午5:00:00 simon.xxm Exp $
 */
public enum BizTypeEnum {

    OpenBankAccount("01", "开通银行账户"), 
    ChangeBindBankCard("02", "换绑银行卡"), 
    ChangePhoneNo("03", "更换银行预留手机号"), 
    MerchantdApply("04", "商户入驻申请"), 
    RansomYuliBao("05","余利宝提现"),
    ;

    /**
     * 业务类型
     */
    private String bizCode;

    /**
     * 业务类型描述
     */
    private String bizDesc;

    /**
     * @param bizCode
     * @param bizDesc
     */
    private BizTypeEnum(String bizCode, String bizDesc) {
        this.bizCode = bizCode;
        this.bizDesc = bizDesc;
    }


    /**
     * Getter method for property <tt>bizCode</tt>.
     * 
     * @return property value of bizCode
     */
    public String getBizCode() {
        return bizCode;
    }


    /**
     * Setter method for property <tt>bizCode</tt>.
     * 
     * @param bizCode value to be assigned to property bizCode
     */
    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }


    /**
     * Getter method for property <tt>bizDesc</tt>.
     * 
     * @return property value of bizDesc
     */
    public String getBizDesc() {
        return bizDesc;
    }


    /**
     * Setter method for property <tt>bizDesc</tt>.
     * 
     * @param bizDesc value to be assigned to property bizDesc
     */
    public void setBizDesc(String bizDesc) {
        this.bizDesc = bizDesc;
    }


    /**
     * 根据业务类型码获取业务类型枚举
     * 
     * @param statusCode
     * @return
     */
    public static BizTypeEnum getBizTypeByCode(String bizTypeCode) {
        if (StringUtils.isEmpty(bizTypeCode)) {
            return null;
        }
        for (BizTypeEnum bizType : values()) {
            if (StringUtils.equals(bizTypeCode, bizType.getBizCode())) {
                return bizType;
            }
        }
        return null;
    }


}
