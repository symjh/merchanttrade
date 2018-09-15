package com.mybank.bkmerchant.yulibao;

import java.util.HashMap;
import java.util.Map;

import com.mybank.bkmerchant.base.AbstractReq;
import com.mybank.bkmerchant.base.HttpsMain;

/**
 * 4.4.3	余利宝申购预算接口
 *
 * 为防止余利宝申购失败，在申购前可调用本接口进行可申购金额的查询
 *
 * 请求报文
 IsvOrgId	ISV机构编号
 MerchantId	商户号。网商为商户分配的商户号，通过商户入驻结果查询接口获取。
 FundCode	基金代码，目前默认填001529，代表余利宝。
 Amount	申购金额，消费币种的最小货币单位（分）
 Currency	币种代码，CNY表示人民币，目前只支持人民币

 * 应答报文
 RespInfo	返回码组件
 ProdMaxAmount	消费币种的最小货币单位（分）
 MaxAmount	指距离产品上限的差额，实际使用过程中需要和DmdAmount取小。消费币种的最小货币单位（分）
 DmdAmount	活期余额。银行账户的活期余额。
 Currency	币种
 ExpectedProfitCalDate	收益计算开始时间，必须是格式为yyyyMMdd
 ExpectedProfitConfirmDate	预计收益到账时间，必须是格式为yyyyMMdd

 *
 * @author jingzhu.zr
 */
public class PurchaseBudget extends AbstractReq {
  private String isvOrgId = HttpsMain.IsvOrgId;
  private String merchantId = HttpsMain.merchantId;
  private String fundCode = "001529";
  private long amount;
  private String currency = "CNY";
  private Map<String, String> body;

  /**
   *
   * @param amount 申购金额，消费币种的最小货币单位（分）
   */
  public PurchaseBudget(long amount) {
    super("ant.mybank.yulibao.purchase.budget");
    this.amount = amount;

    this.body = new HashMap<String, String>();
    this.body.put("IsvOrgId", this.isvOrgId);
    this.body.put("MerchantId", this.merchantId);
    this.body.put("FundCode", this.fundCode);
    this.body.put("Amount", this.amount + "");
    this.body.put("Currency", this.currency);
  }

  @Override
  public Map<String, String> getBody() {
    return this.body;
  }

  public static void main(String[] args) throws Exception {
    PurchaseBudget purchaseBudget = new PurchaseBudget(1500);
    purchaseBudget.call();
  }
}
