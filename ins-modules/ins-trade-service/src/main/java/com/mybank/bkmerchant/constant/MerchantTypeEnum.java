package com.mybank.bkmerchant.constant;

/**
 * Created by jingzhu.zr on 2017/8/15.
 */
public enum MerchantTypeEnum {
  Natural("01", "自然人"),
  Individual("02", "个体工商户"),
  Enterprising("03", "企业商户")
  ;

  private String mchCode;
  private String mchDesc;

  MerchantTypeEnum(String mchCode, String mchDesc) {
    this.mchCode = mchCode;
    this.mchDesc = mchDesc;
  }

  public String getMchCode() {
    return mchCode;
  }

  public void setMchCode(String mchCode) {
    this.mchCode = mchCode;
  }

  public String getMchDesc() {
    return mchDesc;
  }

  public void setMchDesc(String mchDesc) {
    this.mchDesc = mchDesc;
  }
}
