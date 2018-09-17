package com.mybank.bkmerchant.merchant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import com.mybank.bkmerchant.base.AbstractReq;
import com.mybank.bkmerchant.base.HttpsMain;
import com.mybank.bkmerchant.constant.DealTypeEnum;
import com.mybank.bkmerchant.constant.DeniedPayToolEnum;
import com.mybank.bkmerchant.constant.FeeTypeEnum;
import com.mybank.bkmerchant.constant.MccEnum;
import com.mybank.bkmerchant.constant.MerchantTypeEnum;
import com.mybank.bkmerchant.constant.PayChannelEnum;
import com.mybank.bkmerchant.constant.PrincipalCertTypeEnum;
import com.mybank.bkmerchant.constant.SettleModeEnum;
import com.mybank.bkmerchant.constant.SupportPrepaymentEnum;
import com.mybank.bkmerchant.constant.TradeTypeEnum;
import com.mybank.bkmerchant.models.FeeParam;
import com.mybank.bkmerchant.models.MerchantDetail;

/**
 *  注意：此接口废弃-2018-09-17
 *  商户入驻申请接口，同时开网商银行账户
 *
 *  <p/>
 *  该接口提供同时完成商户入驻和网商银行二类账户开立的能力，省去合作方调两个接口完成开户和进驻的麻烦。
 *  <li>
 *    针对收单并清算到余利宝或银行账户活期户的情况，可以直接调用本接口。
 *    若商户仅进驻并清算到他行卡，那么可以使用商户入驻申请（不开银行账户）的接口。
 *  </li>
 *  <p/>
 *  本接口只支持开通个人银行账户，不支持开通企业银行账户。
 *  <li>
 *    同一个合作方机构号（网商银行分配）下，同一个外部商户号只能开立一个二类户。
 *    同一个合作方机构号（网商银行分配）下、同一个证件号下开设的二类户最多不能超过4个。
 *  </li>
 *  注意：客户未满16岁不能开户，未满18岁不能进行基金交易。建议商户进驻时统一控制年龄为16岁。
 *
 *
 *  @author jingzhu.zr
 */
public class RegisterWithAccount extends AbstractReq {

  /**
   * 合作方机构号（网商银行分配）
   */
  private String isvOrgId = HttpsMain.IsvOrgId;

  /**
   * 外部商户号。合作商对商户的自定义编码，要求同一个合作商下保持唯一
   */
  private String outMerchantId;

  /**
   * 商户名称。有营业执照的，要求与营业执照上的名称一致
   */
  private String merchantName;

  /**
   * 商户类型
   */
  private MerchantTypeEnum merchantType;

  /**
   * 商户经营类型
   */
  private DealTypeEnum dealtype;

  /**
   * 商户清算资金是否支持T+0到账
   */
  private SupportPrepaymentEnum supportPrepayment;

  /**
   * 结算方式
   */
  private SettleModeEnum settleMode;

  /**
   * 经营类目
   */
  private MccEnum mcc;

  /**
   * 商户详情
   */
  private MerchantDetail merchantDetail;

  /**
   * 支持交易类型列表
   */
  private List<TradeTypeEnum> tradeTypeList;

  /**
   * 支持支付渠道列表
   */
  private List<PayChannelEnum> payChannelList;

  /**
   * 禁用支付方式
   */
  private List<DeniedPayToolEnum> deniedPayToolList;

  /**
   * 手续费列表
   */
  private List<FeeParam> feeParamList;

  /**
   * 手机验证码。
   * 备注：合作方系统须先调网商短信验证码发送接口，BizType=6，商户获取验证码后在申请页面回填验证码，合作方系统通过本接口统一上送
   */
  private String authCode;

  /**
   * 外部交易号。
   * 合作方系统生成的外部交易号，同一交易号被视为同一笔交易
   */
  private String outTradeNo;

  /**************2018-09-12 新增**************/
  /**
   * 商户是否可自主选择让其买家使用花呗分期，包括商户承担手续费和用户承担手续费两种模式。目前仅支持用户承担手续费模式。
   * 可选值：
   * Y：支持
   * N：不支持(默认值)
   */
  private String supportStage;
  /**
   * 商户在进行微信支付H5支付时所使用的公众号相关信息的类型
   * 01：商户自有公众号。适合商户本身有公众号的情况。
   * 03：合作机构对接网商时留存的公众号。适合商户本身没有公众号，关注合作机构的公众号的情况。
   * 备注：
   * 1、	由于微信支付要求商户名称和公众号的认证主体要严格一致，商户需要根据自身情况选择一种方式去报送公众号支付相关的信息。
   */
  private String partnerType;
  /**
   * 记录商户由哪一个渠道接入支付宝的，该字段用于营销激励、风控等方面。是谁带来的商户就填写谁的PID。
   * （重要：通过签约支付宝返佣协议且配合该字段，商户的推荐方可获得支付宝的返佣资金，请千万不要填错该字段！）
   */
  private String alipaySource;
  /**
   * ISV可线下联系网商运营申请支持指定微信渠道号入驻，该字段用于指定在哪个微信渠道号下进件
   */
  private String wechatChannel;
  /**
   * 支付宝费率版本。可选值：
   *  RS：标准费率
   *  R0：0费率
   *  R1：千一费率
   *  RBLUE：蓝海行动餐饮0费率
   *  说明：参数为非必填项。不传或传RS，都是走支付宝默认费率；选择R0、R1时需要按照支付宝低费率进件要求，
   *       联系网商银行先完成线下审核，才能进件；传递RBLUE时，为参加蓝海行动餐饮0费率报备
   */
  private String rateVersion;


  private Map<String, String> body;

  public RegisterWithAccount(String merchantName, MerchantTypeEnum merchantType, DealTypeEnum dealtype, SupportPrepaymentEnum supportPrepayment,
                             SettleModeEnum settleMode, MccEnum mcc, MerchantDetail merchantDetail, List<TradeTypeEnum> tradeTypeList, List<PayChannelEnum> payChannelList, List<DeniedPayToolEnum> deniedPayToolList, List<FeeParam> feeParamList, String authCode, String outTradeNo,  String supportStage,
                             String partnerType,
                             String alipaySource,
                             String wechatChannel,
                             String rateVersion) throws JSONException {
    super("ant.mybank.merchantprod.merchant.registerWithAccount");
    this.merchantName = merchantName;
    this.merchantType = merchantType;
    this.dealtype = dealtype;
    this.supportPrepayment = supportPrepayment;
    this.settleMode = settleMode;
    this.mcc = mcc;
    this.merchantDetail = merchantDetail;
    this.tradeTypeList = tradeTypeList;
    this.payChannelList = payChannelList;
    this.deniedPayToolList = deniedPayToolList;
    this.feeParamList = feeParamList;
    this.authCode = authCode;
    this.outTradeNo = outTradeNo;
    this.supportStage = supportStage;
    this.partnerType = partnerType;
    this.alipaySource = alipaySource;
    this.wechatChannel = wechatChannel;
    this.rateVersion = rateVersion;


    this.body = new HashMap<String, String>();
    this.body.put("IsvOrgId", this.isvOrgId);
    this.body.put("OutMerchantId", this.outTradeNo);
    this.body.put("MerchantName", this.merchantName);
    this.body.put("MerchantType", this.merchantType.getMchCode());
    this.body.put("DealType", this.dealtype.getDealCode());
    this.body.put("SupportPrepayment", this.supportPrepayment.getSupCode());
    this.body.put("SettleMode", this.settleMode.getSettleCode());
    this.body.put("Mcc", this.mcc.getMccId());
    this.body.put("MerchantDetail", this.merchantDetail.genJsonBase64());
    this.body.put("TradeTypeList", TradeTypeEnum.genTradeTypeList(this.tradeTypeList));
    this.body.put("PayChannelList", PayChannelEnum.genPayChannelList(this.payChannelList));
    this.body.put("DeniedPayToolList", DeniedPayToolEnum.genDenniedPayToolList(this.deniedPayToolList));
    this.body.put("FeeParamList", FeeParam.genJsonBase64(this.feeParamList));
    this.body.put("AuthCode", this.authCode);
    this.body.put("OutTradeNo", this.outTradeNo);
    this.body.put("SupportStage", this.supportStage);
    this.body.put("PartnerType", this.partnerType);
    this.body.put("AlipaySource", this.alipaySource);
    this.body.put("WechatChannel", this.wechatChannel);
    this.body.put("RateVersion", this.rateVersion);
  }

  @Override
  public Map<String, String> getBody() {
    return this.body;
  }

  public static void main(String[] args) throws Exception {
    MerchantDetail merchantDetail = new MerchantDetail(
            "中科软1号",
            "17620358925",
            "严水平",
            "", "", "", "",
            "01040304230",
            "yanshuiping925@163.com",
            "",
            "17620358925",
            PrincipalCertTypeEnum.IdentityCard,
            "430723198809102650",
            "严水平",
            "620522113350616996",
            "",
            "",
            "d9a8f406-b3ee-44f5-be5e-78cbfafd77e3",
            "5b80e0d2-728f-43a8-ba50-1e76e9796b73",
            "", "", "", "", "",""
    );

    List<TradeTypeEnum> tradeTypeEnumList = new ArrayList<TradeTypeEnum>();
    tradeTypeEnumList.add(TradeTypeEnum.Forward);
    tradeTypeEnumList.add(TradeTypeEnum.Backward);
    tradeTypeEnumList.add(TradeTypeEnum.Refund);

    List<PayChannelEnum> payChannelEnumList = new ArrayList<PayChannelEnum>();
    payChannelEnumList.add(PayChannelEnum.Ali);
    payChannelEnumList.add(PayChannelEnum.WX);

    List<DeniedPayToolEnum> deniedPayToolEnumList = new ArrayList<DeniedPayToolEnum>();
    deniedPayToolEnumList.add(DeniedPayToolEnum.Huabei);

    List<FeeParam> feeParamList = new ArrayList<FeeParam>();
    feeParamList.add(new FeeParam(PayChannelEnum.Ali, FeeTypeEnum.T1, "0.0035"));
    feeParamList.add(new FeeParam(PayChannelEnum.WX, FeeTypeEnum.T1, "0.0035"));

    RegisterWithAccount registerWithAccount = new RegisterWithAccount(
      "我是商户",
      MerchantTypeEnum.Natural,
      DealTypeEnum.Entity,
      SupportPrepaymentEnum.NotSupport,
      SettleModeEnum.Yulibao,
      MccEnum.Cate,
      merchantDetail,
      tradeTypeEnumList,
      payChannelEnumList,
      deniedPayToolEnumList,
      feeParamList,
      "888888",
      UUID.randomUUID().toString(),
            "N",
            "03",
            "2018090700000286",
            "",
            "RS"
    );

    registerWithAccount.call();

  }
}
