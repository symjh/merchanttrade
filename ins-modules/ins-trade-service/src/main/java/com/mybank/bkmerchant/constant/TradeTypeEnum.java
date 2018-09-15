package com.mybank.bkmerchant.constant;

import java.util.List;

/**
 * Created by jingzhu.zr on 2017/8/15.
 */
public enum TradeTypeEnum {

  Forward("01", "正扫交易"),
  Backward("02", "反扫交易"),
  Refund("06", "退款交易"),
  // ysp新增
  Dynamic("08", "动态订单扫描")
  ;

  private String tradeCode;
  private String tradeDesc;

  TradeTypeEnum(String tradeCode, String tradeDesc) {
    this.tradeCode = tradeCode;
    this.tradeDesc = tradeDesc;
  }

  public String getTradeCode() {
    return tradeCode;
  }

  public void setTradeCode(String tradeCode) {
    this.tradeCode = tradeCode;
  }

  public String getTradeDesc() {
    return tradeDesc;
  }

  public void setTradeDesc(String tradeDesc) {
    this.tradeDesc = tradeDesc;
  }

  public static String genTradeTypeList(List<TradeTypeEnum> list){
    StringBuilder sb = new StringBuilder();

    for(TradeTypeEnum e: list){
      sb.append(e.getTradeCode());
      sb.append(",");
    }

    String rst = sb.toString();
    return rst.length() > 0 ? rst.substring(0, rst.length()): rst;
  }
}
