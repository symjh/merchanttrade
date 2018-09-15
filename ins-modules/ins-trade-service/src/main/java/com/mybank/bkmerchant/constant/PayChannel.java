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
 * @version $Id: PayChannel.java, v 0.1 2017年8月3日 下午2:55:30 simon.xxm Exp $
 */
public class PayChannel {
    public static final String ALI = "01";
    public static final String WX  = "02";
    public static final String QQ  = "03";
    public static final String JD  = "04";

    public static boolean contains(String value) {
        return value.equals(ALI) || value.equals(WX) || value.equals(QQ) || value.equals(JD);
    }

    public static String genPayChannelList(Set<String> args) {
        for (String v : args) {
            assert contains(v) : "PayChannel不在给定范围内，请参考【01：支付宝  02：微信支付  03：手机QQ（暂未开放）  04：京东钱包（暂未开放）】";
        }
        ;

        return StringUtils.join(args, ",");
    }

}
