/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.mybank.bkmerchant.constant;

/**
 * 
 * @author simon.xxm
 * @version $Id: SupportPrepayment.java, v 0.1 2017年8月3日 下午2:53:22 simon.xxm Exp $
 */
public class SupportPrepayment {
    public static final String SUPPORT     = "Y";
    public static final String NOT_SUPPORT = "N";

    public static boolean contains(String value) {
        return value.equals(SUPPORT) || value.equals(NOT_SUPPORT);
    }

}
