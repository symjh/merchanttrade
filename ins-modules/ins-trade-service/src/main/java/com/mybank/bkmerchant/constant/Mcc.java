/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.mybank.bkmerchant.constant;

/**
 * 
 * @author simon.xxm
 * @version $Id: Mcc.java, v 0.1 2017年8月3日 下午2:54:05 simon.xxm Exp $
 */
public class Mcc {
    public static final String CATE          = "2015050700000000";
    public static final String SUPERMARKET   = "2015091000052157";
    public static final String ENTERTAINMENT = "2015062600004525";
    public static final String SHOPPING      = "2015062600002758";
    public static final String LOVING_CAR    = "2016062900190124";
    public static final String LIFE_SERVICE  = "2015063000020189";
    public static final String EDUCATION     = "2016042200000148";
    public static final String HEALTHCARE    = "2016062900190296";
    public static final String AIR_TRAVEL    = "2015080600000001";
    public static final String WHOLESALE     = "2016062900190337";
    public static final String GOVERNMENT    = "2016062900190371";

    public static boolean contains(String value) {
        return value.equals(CATE) || value.equals(SUPERMARKET) || value.equals(ENTERTAINMENT)
               || value.equals(SHOPPING) || value.equals(LOVING_CAR) || value.equals(LIFE_SERVICE)
               || value.equals(EDUCATION) || value.equals(HEALTHCARE) || value.equals(AIR_TRAVEL)
               || value.equals(WHOLESALE) || value.equals(GOVERNMENT);
    }

}
