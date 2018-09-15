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
 * @version $Id: TradeInStatus.java, v 0.1 2017年8月3日 下午2:56:41 simon.xxm Exp $
 */
public class TradeInStatus {
    final static String INPROCESS  = "Inprocess"; //处理中
    final static String SUCCESS    = "success";   //成功
    final static String FAILURE    = "failure";   //失败
    final static String REEXCHANGE = "reexchange"; //退汇（转账成功后发卡行无法入账导致退回）

    public static boolean contains(String value) {
        return value.equals(INPROCESS) || value.equals(SUCCESS) || value.equals(FAILURE)
               || value.equals(REEXCHANGE);
    }

    public static String genTradeInStatusList(Set<String> args) {
        for (String v : args) {
            assert contains(v) : "BizType不在给定范围内，请参考【nprocess： 处理中\n" + "success： 成功\n"
                                 + "failure： 失败\n" + "reexchange：退汇（转账成功后发卡行无法入账导致退回）\n】";
        }

        return StringUtils.join(args, ",");
    }
}
