/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.mybank.bkmerchant.constant;

/**
 * 
 * @author simon.xxm
 * @version $Id: SettleMode.java, v 0.1 2017年8月3日 下午2:53:44 simon.xxm Exp $
 */
public class SettleMode {
    public static final String BANK_CARD       = "01";
    public static final String YULIBAO         = "02";
    public static final String CURRENT_ACCOUNT = "03";

    public static boolean contains(String value) {
        return value.equals(BANK_CARD) || value.equals(YULIBAO)
               || value.equals(CURRENT_ACCOUNT);
    }

}
