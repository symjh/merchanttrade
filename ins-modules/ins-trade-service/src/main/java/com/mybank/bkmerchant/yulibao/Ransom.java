package com.mybank.bkmerchant.yulibao;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.mybank.bkmerchant.base.AbstractReq;
import com.mybank.bkmerchant.base.HttpsMain;

/**
 * 4.4.6	余利宝赎回到绑定卡接口
 *
 * 合作机构代客户发起余利宝赎回功能，赎回基金直接转出到银行账户绑定的银行卡。
 * 注意：超过5万元（不含）需要先触发并上送短信验证码。
 *
 * 请求报文
 IsvOrgId	ISV机构编号
 MerchantId	商户号。网商为商户分配的商户号，通过商户入驻结果查询接口获取。
 FundCode	基金代码
 Amount	赎回金额，消费币种的最小货币单位（分）
 Currency	消费金额的币种。目前仅支人民币：CNY
 OutTradeNo	外部交易流水号。流水号做了幂等性，注意不同交易须传不同流水号。
 AuthCode	手机验证码。用于客户身份核实，利用短信验证码发送接口可获取。


 * 应答报文
 RespInfo	返回码组件
 OrderNo	网商银行业务流水号
 OutTradeNo	外部交易流水号

 *
 *  @author jingzhu.zr
 */
public class Ransom extends AbstractReq{
  private String isvOrgId = HttpsMain.IsvOrgId;
  private String merchantId = HttpsMain.merchantId;
  private String fundCode = "001529";
  private long amount;
  private String currency = "CNY";
  private String outTradeNo;
  private String authCode;
  private Map<String, String> body;

  /**
   *
   * @param amount 赎回金额，消费币种的最小货币单位（分）
   * @param outTradeNo 赎回金额，消费币种的最小货币单位（分）
   * @param authCode 手机验证码。用于客户身份核实，利用短信验证码发送接口可获取
   */
  public Ransom(long amount, String outTradeNo, String authCode) {
    super("ant.mybank.yulibao.ransom");
    this.amount = amount;
    this.outTradeNo = outTradeNo;
    this.authCode = authCode;

    this.body = new HashMap<String, String>();
    this.body.put("IsvOrgId", this.isvOrgId);
    this.body.put("MerchantId", this.merchantId);
    this.body.put("FundCode", this.fundCode);
    this.body.put("Amount", this.amount + "");
    this.body.put("Currency", this.currency);
    this.body.put("OutTradeNo", this.outTradeNo);
    this.body.put("AuthCode", this.authCode);
  }

  @Override
  public Map<String, String> getBody() {
    return this.body;
  }

  public static void main(String[] args) throws Exception {
    Ransom ransom = new Ransom(1500, UUID.randomUUID().toString(), "");
    ransom.call();
  }
}
