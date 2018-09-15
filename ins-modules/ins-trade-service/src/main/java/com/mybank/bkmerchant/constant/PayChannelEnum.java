package com.mybank.bkmerchant.constant;

import java.util.List;

/**
 * Created by jingzhu.zr on 2017/8/15.
 */
public enum PayChannelEnum {
  Ali("01", "支付宝"),
  WX("02", "微信支付"),
  QQ("03", "手机QQ"),
  JD("04", "京东钱包")
  ;

  private String chnCode;
  private String chnDesc;

  PayChannelEnum(String chnCode, String chnDesc) {
    this.chnCode = chnCode;
    this.chnDesc = chnDesc;
  }

  public String getChnCode() {
    return chnCode;
  }

  public void setChnCode(String chnCode) {
    this.chnCode = chnCode;
  }

  public String getChnDesc() {
    return chnDesc;
  }

  public void setChnDesc(String chnDesc) {
    this.chnDesc = chnDesc;
  }

  public static String genPayChannelList(List<PayChannelEnum> list){
    StringBuilder sb = new StringBuilder();

    for(PayChannelEnum e: list){
      sb.append(e.getChnCode());
      sb.append(",");
    }

    String rst = sb.toString();
    return rst.length() > 0 ? rst.substring(0, rst.length()): rst;
  }
}
