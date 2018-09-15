/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.mybank.bkmerchant.constant;

/**
 * 
 * @author simon.xxm
 * @version $Id: MerchantType.java, v 0.1 2017年8月3日 下午3:03:51 simon.xxm Exp $
 */
public class MerchantType {
    public static final String NATURAL      = "01";
    public static final String INDIVIDUAL   = "02";
    public static final String ENTERPRISING = "03";



    public static boolean contains(String value) {
        return value.equals(NATURAL) || value.equals(INDIVIDUAL) || value.equals(ENTERPRISING);
    }

}
