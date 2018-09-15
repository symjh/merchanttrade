package com.mybank.bkmerchant.yulibao;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.mybank.bkmerchant.base.AbstractReq;
import com.mybank.bkmerchant.base.HttpsMain;

/**
 * 4.4.4	余利宝申购接口
 *
 * 合作方通过本接口发起余利宝申购。余利宝申购完成后，网商将扣减客户银行账户余额。为保证余利宝申购成功，在交易发起前，建议先进行余利宝购买预算及银行账户余额检查
 *
 * 请求报文
 IsvOrgId	ISV机构编号
 MerchantId	商户号。网商为商户分配的商户号，通过商户入驻结果查询接口获取。
 FundCode	基金代码
 Amount	申购金额。消费币种的最小货币单位（分）
 Currency	消费金额的币种。只支持人民币：CNY。
 OutTradeNo	外部交易流水号。流水号做了幂等性，注意不同交易须传不同流水号。

 * 应答报文
 RespInfo	返回码组件
 OrderNo	网商银行业务流水号
 OutTradeNo	外部交易流水号

 *
 *  @author jingzhu.zr
 */
public class Purchase extends AbstractReq{
  private String isvOrgId = HttpsMain.IsvOrgId;
  private String merchantId = HttpsMain.merchantId;
  private String fundCode = "001529";
  private long amount;
  private String currency = "CNY";
  private String outTradeNo;
  private Map<String, String> body;

  /**
   *
   * @param amount 申购金额。消费币种的最小货币单位（分）
   * @param outTradeNo 外部交易流水号。流水号做了幂等性，注意不同交易须传不同流水号
   */
  public Purchase(long amount, String outTradeNo) {
    super("ant.mybank.yulibao.purchase");
    this.amount = amount;
    this.outTradeNo = outTradeNo;

    this.body = new HashMap<String, String>();
    this.body.put("IsvOrgId", this.isvOrgId);
    this.body.put("MerchantId", this.merchantId);
    this.body.put("FundCode", this.fundCode);
    this.body.put("Amount", this.amount + "");
    this.body.put("Currency", this.currency);
    this.body.put("OutTradeNo", this.outTradeNo);
  }

  @Override
  public Map<String, String> getBody() {
    return this.body;
  }

  public static void main(String[] args) throws Exception {
    Purchase purchase = new Purchase(1500, UUID.randomUUID().toString());
    purchase.call();
  }
}
