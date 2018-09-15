/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.mybank.bkmerchant.constant;

/**
 * 
 * @author simon.xxm
 * @version $Id: DealType.java, v 0.1 2017年8月3日 下午2:53:00 simon.xxm Exp $
 */
public class DealType {
    public static final String ENTITY              = "01";
    public static final String INTERNET            = "02";
    public static final String ENTITY_AND_INTERNET = "03";

    public static boolean contains(String value) {
        return value.equals(ENTITY) || value.equals(INTERNET)
               || value.equals(ENTITY_AND_INTERNET);
    }

}
