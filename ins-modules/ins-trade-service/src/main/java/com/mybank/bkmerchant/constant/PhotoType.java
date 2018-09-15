/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.mybank.bkmerchant.constant;

/**
 * 
 * @author simon.xxm
 * @version $Id: PhotoType.java, v 0.1 2017年8月3日 下午2:52:20 simon.xxm Exp $
 */
public class PhotoType {
    public static final String CERT_PHOTO_A           = "01"; //身份证正面
    public static final String CERT_PHOTO_B           = "02"; //身份证反面
    public static final String LICENSE_PHOTO          = "03"; //营业执照图片
    public static final String PRG_PHOTO              = "04"; //组织机构代码证图片
    public static final String INDUSTRY_LICENSE_PHOTO = "05"; //开户许可证照片
    public static final String SHOP_PHOTO             = "06"; //门头照
    public static final String OTHER_PHOTO            = "07"; //其他图片

    public static boolean contains(String value) {
        return value.equals(CERT_PHOTO_A) || value.equals(CERT_PHOTO_B)
               || value.equals(LICENSE_PHOTO) || value.equals(PRG_PHOTO)
               || value.equals(INDUSTRY_LICENSE_PHOTO) || value.equals(SHOP_PHOTO)
               || value.equals(OTHER_PHOTO);
    }

}
