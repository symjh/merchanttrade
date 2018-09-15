package com.mybank.bkmerchant.constant;

import java.util.List;

/**
 * Created by jingzhu.zr on 2017/8/15.
 */
public enum TradeInStatusEnum {
  InProcess("Inprocess", "处理中"),
  Success("success", "成功"),
  Failure("failure", "失败"),
  ReExchange("reexchange", "退汇")
  ;

  private String statusCode;
  private String statusDesc;

  TradeInStatusEnum(String statusCode, String statusDesc) {
    this.statusCode = statusCode;
    this.statusDesc = statusDesc;
  }

  public String getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }

  public String getStatusDesc() {
    return statusDesc;
  }

  public void setStatusDesc(String statusDesc) {
    this.statusDesc = statusDesc;
  }

  public static String genTradeInStatusList(List<TradeInStatusEnum> list){
    StringBuilder sb = new StringBuilder();

    for(TradeInStatusEnum e: list){
      sb.append(e.getStatusCode());
      sb.append(",");
    }

    String rst = sb.toString();
    return rst.length() > 0 ? rst.substring(0, rst.length()): rst;
  }
}
