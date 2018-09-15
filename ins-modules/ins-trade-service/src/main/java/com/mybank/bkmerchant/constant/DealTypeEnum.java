package com.mybank.bkmerchant.constant;

/**
 * Created by jingzhu.zr on 2017/8/15.
 */
public enum DealTypeEnum {
  Entity("01", "实体特约商户"),
  Internet("02", "网络特约商户"),
  EntityAndInternet("03", "实体兼网络特约商户")
  ;

  private String dealCode;
  private String dealDesc;

  DealTypeEnum(String dealCode, String dealDesc) {
    this.dealCode = dealCode;
    this.dealDesc = dealDesc;
  }

  public String getDealCode() {
    return dealCode;
  }

  public void setDealCode(String dealCode) {
    this.dealCode = dealCode;
  }

  public String getDealDesc() {
    return dealDesc;
  }

  public void setDealDesc(String dealDesc) {
    this.dealDesc = dealDesc;
  }
}
