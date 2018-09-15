/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.mybank.bkmerchant.constant;

import java.util.Set;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author simon.xxm
 * @version $Id: TradeType.java, v 0.1 2017年8月3日 下午2:55:06 simon.xxm Exp $
 */
public class TradeType {
    public static final String FORWARD  = "01";
    public static final String BACKWARD = "02";
    public static final String REFUND   = "06";

    public static boolean contains(String value) {
        return value.equals(FORWARD) || value.equals(BACKWARD) || value.equals(REFUND);
    }

    public static String genTradeTypeList(Set<String> args) {
        for (String v : args) {
            assert contains(v) : "TradeType不在给定范围内，请参考【01：正扫交易  02：反扫交易  06：退款交易】";
        }

        return StringUtils.join(args, ",");
    }

}
