package com.mybank.bkmerchant.constant;

/**
 * Created by jingzhu.zr on 2017/8/15.
 */
public enum FeeTypeEnum {
  T0("01", "t0收单手续费"),
  T1("02", "t1收单手续费")
  ;

  private String feeCode;
  private String feeDesc;

  FeeTypeEnum(String feeCode, String feeDesc) {
    this.feeCode = feeCode;
    this.feeDesc = feeDesc;
  }

  public String getFeeCode() {
    return feeCode;
  }

  public void setFeeCode(String feeCode) {
    this.feeCode = feeCode;
  }

  public String getFeeDesc() {
    return feeDesc;
  }

  public void setFeeDesc(String feeDesc) {
    this.feeDesc = feeDesc;
  }
}
