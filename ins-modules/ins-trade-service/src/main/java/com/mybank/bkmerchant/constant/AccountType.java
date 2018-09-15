/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.mybank.bkmerchant.constant;

/**
 * 
 * @author simon.xxm
 * @version $Id: AccountType.java, v 0.1 2017年8月3日 下午2:58:22 simon.xxm Exp $
 */
public class AccountType {
    public static final String ORIENTED_PRIVATE = "01";
    public static final String ORIENTED_PUBLIC  = "02";

    public static boolean contains(String value) {
        return value.equals(ORIENTED_PRIVATE) || value.equals(ORIENTED_PUBLIC);
    }

}
