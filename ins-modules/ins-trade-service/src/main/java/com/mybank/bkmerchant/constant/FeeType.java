/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.mybank.bkmerchant.constant;

/**
 * 
 * @author simon.xxm
 * @version $Id: FeeType.java, v 0.1 2017年8月3日 下午2:57:57 simon.xxm Exp $
 */
public class FeeType {
    public static final String T0 = "01";
    public static final String T1 = "02";

    public static boolean contains(String value) {
        return value.equals(T0) || value.equals(T1);
    }

}
