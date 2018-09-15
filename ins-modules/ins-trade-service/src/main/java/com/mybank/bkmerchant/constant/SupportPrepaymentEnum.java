package com.mybank.bkmerchant.constant;

/**
 * Created by jingzhu.zr on 2017/8/15.
 */
public enum SupportPrepaymentEnum {
  Support("Y", "支持T+0结算"),
  NotSupport("N", "不支持T+0结算")
  ;

  private String supCode;
  private String supDesc;

  SupportPrepaymentEnum(String supCode, String supDesc) {
    this.supCode = supCode;
    this.supDesc = supDesc;
  }

  public String getSupCode() {
    return supCode;
  }

  public void setSupCode(String supCode) {
    this.supCode = supCode;
  }

  public String getSupDesc() {
    return supDesc;
  }

  public void setSupDesc(String supDesc) {
    this.supDesc = supDesc;
  }
}
