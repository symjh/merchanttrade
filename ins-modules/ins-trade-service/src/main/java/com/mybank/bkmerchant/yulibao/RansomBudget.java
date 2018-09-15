package com.mybank.bkmerchant.yulibao;

import java.util.HashMap;
import java.util.Map;

import com.mybank.bkmerchant.base.AbstractReq;
import com.mybank.bkmerchant.base.HttpsMain;

/**
 * 4.4.5	余利宝赎回预算接口
 *
 * 为保证赎回成功率，合作方在赎回前可调用本接口，判断赎回模式（实时/非实时赎回）。如无特别通知，个人账户余利宝实时赎回每天每户限额100万。
 *
 * 请求报文
 IsvOrgId	ISV机构编号
 MerchantId	商户号。网商为商户分配的商户号，通过商户入驻结果查询接口获取。
 FundCode	基金代码。余利宝上送：001529。
 Amount	赎回金额。消费币种的最小货币单位（分）
 Currency	消费金额的币种。只支持人民币：CNY。

 * 应答报文
 RespInfo	返回码组件
 SyncMaxAmount	实时到账可赎回最大金额。指客户当前可实时赎回的最大金额，消费币种的最小货币单位（分）。该金额结合了客户持仓剩余份额及客户当天可实时赎回额度后返回的。
 SyncProdOverplusAmount	实时到账产品剩余额度。单指客户当天实时赎回额度的剩余，不考虑客户持仓份额。消费币种的最小货币单位（分）。一般情况下，合作方无须考虑本字段。
 AsynMaxAmount	非实时到账赎回最大金额，消费币 种的最小货币单位（分）。
 Currency	币种
 ExpectedProfitCalculateDate	非实时到账赎回预计到账时间。
 QueryDate	查询时间。返回当前时间。
 IsRedeemTurnOff	是否关闭实时赎回接口。布尔值，true关闭，false未关闭。当返回值为true时，无法进行实时赎回。

 *
 * @author jingzhu.zr
 */
public class RansomBudget extends AbstractReq {
  private String isvOrgId = HttpsMain.IsvOrgId;
  private String merchantId = HttpsMain.merchantId;
  private String fundCode = "001529";
  private long amount;
  private String currency = "CNY";
  private Map<String, String> body;

  /**
   *
   * @param amount 赎回金额。消费币种的最小货币单位（分）
   */
  public RansomBudget(long amount) {
    super("ant.mybank.yulibao.ransom.budget");
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
    RansomBudget ransomBudget = new RansomBudget(1500);
    ransomBudget.call();
  }
}
