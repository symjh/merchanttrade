/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.mybank.bkmerchant.constant;

/**
 * 
 * @author simon.xxm
 * @version $Id: PrincipalCertType.java, v 0.1 2017年8月3日 下午2:54:38 simon.xxm Exp $
 */
public class PrincipalCertType {
    public static final String IDENTITY_CARD = "01";

    public static boolean contains(String value) {
        return value.equals(IDENTITY_CARD);
    }

}
