package com.mybank.bkmerchant.yulibao;

import java.util.HashMap;
import java.util.Map;

import com.mybank.bkmerchant.base.AbstractReq;
import com.mybank.bkmerchant.base.HttpsMain;

/**
 * 4.4.2	余利宝签约查询接口
 *
 * 合作方通过本接口可查询用户是否已经签约余利宝
 *
 * 请求报文
 IsvOrgId	合作方机构号（网商银行分配）
 MerchantId	商户号。网商为商户分配的商户号，通过商户入驻结果查询接口获取。
 FundCode	基金代码，目前默认填001529，代表余利宝。

 * 应答报文
 respInfo	返回码组件
 openState	开户状态。可选值：
 1：true，表示已签署
 2：false，表示未签署。
 remark	查询结果备注信息

 *
 * @author jingzhu.zr
 */
public class FundAccountOpenQuery extends AbstractReq{
  private String isvOrgId = HttpsMain.IsvOrgId;
  private String merchantId = HttpsMain.merchantId;
  private String fundCode = "001529";
  private Map<String, String> body;

  public FundAccountOpenQuery() {
    super("ant.mybank.yulibao.accountopen.query");

    this.body = new HashMap<String, String>();
    this.body.put("IsvOrgId", this.isvOrgId);
    this.body.put("MerchantId", this.merchantId);
    this.body.put("FundCode", this.fundCode);
  }

  @Override
  public Map<String, String> getBody() {
    return this.body;
  }

  public static void main(String[] args) throws Exception {
    FundAccountOpenQuery fundAccountOpenQuery = new FundAccountOpenQuery();
    fundAccountOpenQuery.call();
  }
}
