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
 * @version $Id: DeniedPayTool.java, v 0.1 2017年8月3日 下午2:57:10 simon.xxm Exp $
 */
public class DeniedPayTool {
    public static final String CREDIT_CARD = "02";
    public static final String HUABEI      = "03";

    public static boolean contains(String value) {
        return value.equals(CREDIT_CARD) || value.equals(HUABEI);
    }

    public static String genDeniedPayToolList(Set<String> args) {
        for (String v : args) {
            assert contains(v) : "DeniedPayTool不在给定范围内，请参考【02：信用卡  03：花呗（仅支付宝）】";
        }

        return StringUtils.join(args, ",");
    }
}
