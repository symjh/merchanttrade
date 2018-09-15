package com.mybank.bkmerchant.yulibao;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.mybank.bkmerchant.base.AbstractReq;
import com.mybank.bkmerchant.base.HttpsMain;

/**
 * 4.4.1	余利宝签约接口
 *
 * 资金账户购买余利宝前需要进行余利宝签约。合作方通过本接口可为客户签约开通余利宝。余利宝签约前，须先开通银行账户（具体参考银行账户开通接口）
 *
 * 请求报文
 IsvOrgId	合作方机构号（网商银行分配）
 MerchantId	商户号。网商为商户分配的商户号，通过商户入驻结果查询接口获取。
 FundCode	基金代码。目前默认填001529，代表余利宝。
 OutTradeNo	外部交易流水号。做幂等性控制，另外申请和确认同一笔业务操作时必须传相同流水号

 * 应答报文
 RespInfo	返回码组件
 OrderNo	网商银行业务流水号
 OutTradeNo	商户业务流水号

 *
 * @author jingzhu.zr
 */
public class FundAccountOpen extends AbstractReq {
  private String isvOrgId = HttpsMain.IsvOrgId;
  private String merchantId = HttpsMain.merchantId;
  private String fundCode = "001529";
  private String outTradeNo;
  private Map<String, String> body;

  /**
   *
   * @param outTradeNo 外部交易流水号
   */
  public FundAccountOpen(String outTradeNo) {
    super("ant.mybank.yulibao.accountopen");
    this.outTradeNo = outTradeNo;

    this.body = new HashMap<String, String>();
    this.body.put("IsvOrgId", this.isvOrgId);
    this.body.put("MerchantId", this.merchantId);
    this.body.put("FundCode", this.fundCode);
    this.body.put("OutTradeNo", this.outTradeNo);

  }

  @Override
  public Map<String, String> getBody() {
    return this.body;
  }

  public static void main(String[] args) throws Exception {
    FundAccountOpen fundAccountOpen = new FundAccountOpen(UUID.randomUUID().toString());

    fundAccountOpen.call();
  }
}
