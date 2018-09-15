/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.mybank.bkmerchant.constant;

/**
 * 
 * @author simon.xxm
 * @version $Id: ChannelType.java, v 0.1 2017年8月3日 下午2:57:35 simon.xxm Exp $
 */
public class ChannelType {
    public static final String ALI = "01";
    public static final String WX  = "02";

    public static boolean contains(String value) {
        return value.equals(ALI) || value.equals(WX);
    }
}
