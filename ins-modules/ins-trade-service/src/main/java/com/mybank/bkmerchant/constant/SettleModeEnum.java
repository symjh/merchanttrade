package com.mybank.bkmerchant.constant;

/**
 * Created by jingzhu.zr on 2017/8/15.
 */
public enum SettleModeEnum {

  BankCard("01", "结算到他行卡"),
  Yulibao("02", "结算到余利宝"),
  CurrentAccount("03", "结算到活期户")
  ;

  private String settleCode;
  private String settleDesc;

  SettleModeEnum(String settleCode, String settleDesc) {
    this.settleCode = settleCode;
    this.settleDesc = settleDesc;
  }

  public String getSettleCode() {
    return settleCode;
  }

  public void setSettleCode(String settleCode) {
    this.settleCode = settleCode;
  }

  public String getSettleDesc() {
    return settleDesc;
  }

  public void setSettleDesc(String settleDesc) {
    this.settleDesc = settleDesc;
  }
}
