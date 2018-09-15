package com.mybank.bkmerchant.models;

import sun.misc.BASE64Encoder;

import org.json.JSONException;
import org.json.JSONObject;
import com.mybank.bkmerchant.constant.PrincipalCertTypeEnum;

/**
 * Created by jingzhu.zr on 2017/8/15.
 */
public class MerchantDetailWithoutBankCard {
  /**
   * 商户简称
   */
  private String alias;

  /**
   * 联系人手机号。为商户常用联系人联系手机号
   */
  private String contactMobile;

  /**
   * 联系人姓名。为商户常用联系人姓名
   */
  private String contactName;

  /**
   * 省份（按照附录5.6国标省市区号录入）。
   * 备注：Province、City、District、Address须同时出现。
   * 可选填，一旦填写会做正确性校验
   */
  private String province;

  private String city;

  private String district;

  private String address;

  /**
   * 商户客服电话
   */
  private String servicePhoneNo;

  /**
   * 邮箱
   */
  private String email;

  /**
   * 企业法人名称（注意：是法人名称，非法人代表名称）
   * 自然人或个人工商户无须上送
   */
  private String legalPerson;

  /**
   * 负责人手机号。自然人或个体工商户上送，企业可不上送。
   * 备注：若商户后续开通二类户及余利宝功能，该手机号作为客户在网商的预留手机号，企业可不填)。
   * 开户发送的短信验证码的手机号需要和负责人手机号一致。
   */
  private String principalMobile;

  /**
   * 负责人证件类型
   */
  private PrincipalCertTypeEnum principalCertType;

  /**
   * 负责人证件号码
   * 备注：若自然人送自然人证件号码、若个体工商户送经营者证件号码、若企业送法人代表证件号码
   */
  private String principalCertNo;

  /**
   * 负责人名称或企业法人代表姓名。
   * 备注：若商户类型为“自然人”填写责任人本人，若为“个体工商户”填写经营者本人，若为“企业”填写企业法人代表名称
   */
  private String principalPerson;

  /**
   * 营业执照工商注册号。若商户类型为“自然人”无需上送
   */
  private String bussAuthNum;

  /**
   * 组织机构代码证号
   */
  private String certOrgCode;

  /**
   * 负责人或企业法人代表的身份证图片正面。
   * 备注：需要先调商户图片上传接口上传图片获取链接，并将该链接填到本字段。涉及图片上传的接口处理逻辑一致。
   * 对应PhotoType字段（图片类型）：01
   */
  private String certPhotoA;

  /**
   * 负责人或企业法人代表的身份证图片反面
   * 对应PhotoType字段（图片类型）：02
   */
  private String certPhotoB;

  /**
   * 营业执照图片(若商户类型为“自然人”无需上送)
   * 对应PhotoType字段（图片类型）：03
   */
  private String licensePhoto;

  /**
   * 组织机构代码证图片(若商户类型为“自然人”无需上送、“个体工商户”可选)
   * 对应PhotoType字段（图片类型）：04
   */
  private String prgPhoto;

  /**
   * 开户许可证照片(若商户类型为“自然人”无需上送、“个体工商户”可选、企业必送)
   * 对应PhotoType字段（图片类型）：05
   */
  private String industryLicensePhoto;

  /**
   * 门头照(店铺门头照，可选)
   * 对应PhotoType字段（图片类型）：06
   */
  private String shopPhoto;

  /**
   * 其他图片
   * 对应PhotoType字段（图片类型）：07
   */
  private String otherPhoto;
  /**
   * 需关注的公众号APPID
   * 用于买家完成公众号支付后自动关注的公众号。
   * 本字段不填写默认使用合作方在网商预留的公众号。
   * 当PartnerType=01时，必填。
   */
  private String subscribeAppId;

  public MerchantDetailWithoutBankCard() {
  }

  public MerchantDetailWithoutBankCard(String alias, String contactMobile, String contactName, String province, String city, String district, String address, String servicePhoneNo, String email, String legalPerson, String principalMobile, PrincipalCertTypeEnum principalCertType, String principalCertNo, String principalPerson, String bussAuthNum, String certOrgCode, String certPhotoA, String certPhotoB, String licensePhoto, String prgPhoto, String industryLicensePhoto, String shopPhoto, String otherPhoto, String subscribeAppId) {
    this.alias = alias;
    this.contactMobile = contactMobile;
    this.contactName = contactName;
    this.province = province;
    this.city = city;
    this.district = district;
    this.address = address;
    this.servicePhoneNo = servicePhoneNo;
    this.email = email;
    this.legalPerson = legalPerson;
    this.principalMobile = principalMobile;
    this.principalCertType = principalCertType;
    this.principalCertNo = principalCertNo;
    this.principalPerson = principalPerson;
    this.bussAuthNum = bussAuthNum;
    this.certOrgCode = certOrgCode;
    this.certPhotoA = certPhotoA;
    this.certPhotoB = certPhotoB;
    this.licensePhoto = licensePhoto;
    this.prgPhoto = prgPhoto;
    this.industryLicensePhoto = industryLicensePhoto;
    this.shopPhoto = shopPhoto;
    this.otherPhoto = otherPhoto;
    this.subscribeAppId = subscribeAppId;
  }

  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public String getContactMobile() {
    return contactMobile;
  }

  public void setContactMobile(String contactMobile) {
    this.contactMobile = contactMobile;
  }

  public String getContactName() {
    return contactName;
  }

  public void setContactName(String contactName) {
    this.contactName = contactName;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getServicePhoneNo() {
    return servicePhoneNo;
  }

  public void setServicePhoneNo(String servicePhoneNo) {
    this.servicePhoneNo = servicePhoneNo;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getLegalPerson() {
    return legalPerson;
  }

  public void setLegalPerson(String legalPerson) {
    this.legalPerson = legalPerson;
  }

  public String getPrincipalMobile() {
    return principalMobile;
  }

  public void setPrincipalMobile(String principalMobile) {
    this.principalMobile = principalMobile;
  }

  public PrincipalCertTypeEnum getPrincipalCertType() {
    return principalCertType;
  }

  public void setPrincipalCertType(PrincipalCertTypeEnum principalCertType) {
    this.principalCertType = principalCertType;
  }

  public String getPrincipalCertNo() {
    return principalCertNo;
  }

  public void setPrincipalCertNo(String principalCertNo) {
    this.principalCertNo = principalCertNo;
  }

  public String getPrincipalPerson() {
    return principalPerson;
  }

  public void setPrincipalPerson(String principalPerson) {
    this.principalPerson = principalPerson;
  }

  public String getBussAuthNum() {
    return bussAuthNum;
  }

  public void setBussAuthNum(String bussAuthNum) {
    this.bussAuthNum = bussAuthNum;
  }

  public String getCertOrgCode() {
    return certOrgCode;
  }

  public void setCertOrgCode(String certOrgCode) {
    this.certOrgCode = certOrgCode;
  }

  public String getCertPhotoA() {
    return certPhotoA;
  }

  public void setCertPhotoA(String certPhotoA) {
    this.certPhotoA = certPhotoA;
  }

  public String getCertPhotoB() {
    return certPhotoB;
  }

  public void setCertPhotoB(String certPhotoB) {
    this.certPhotoB = certPhotoB;
  }

  public String getLicensePhoto() {
    return licensePhoto;
  }

  public void setLicensePhoto(String licensePhoto) {
    this.licensePhoto = licensePhoto;
  }

  public String getPrgPhoto() {
    return prgPhoto;
  }

  public void setPrgPhoto(String prgPhoto) {
    this.prgPhoto = prgPhoto;
  }

  public String getIndustryLicensePhoto() {
    return industryLicensePhoto;
  }

  public void setIndustryLicensePhoto(String industryLicensePhoto) {
    this.industryLicensePhoto = industryLicensePhoto;
  }

  public String getShopPhoto() {
    return shopPhoto;
  }

  public void setShopPhoto(String shopPhoto) {
    this.shopPhoto = shopPhoto;
  }

  public String getOtherPhoto() {
    return otherPhoto;
  }

  public void setOtherPhoto(String otherPhoto) {
    this.otherPhoto = otherPhoto;
  }

  public String getSubscribeAppId() {
    return subscribeAppId;
  }

  public void setSubscribeAppId(String subscribeAppId) {
    this.subscribeAppId = subscribeAppId;
  }

  public String genJsonBase64() throws JSONException {
    JSONObject obj = new JSONObject();

    obj.put("Alias", alias);
    obj.put("ContactMobile", contactMobile);
    obj.put("ContactName", contactName);
    obj.put("Province", province);
    obj.put("City", city);
    obj.put("District", district);
    obj.put("Address", address);
    obj.put("ServicePhoneNo", servicePhoneNo);
    obj.put("Email", email);
    obj.put("LegalPerson", legalPerson);
    obj.put("PrincipalMobile", principalMobile);
    if (principalCertType != null) {
      obj.put("PrincipalCertType", principalCertType.getCertCode());
    }
    obj.put("PrincipalCertNo", principalCertNo);
    obj.put("PrincipalPerson", principalPerson);
    obj.put("BussAuthNum", bussAuthNum);
    obj.put("CertOrgCode", certOrgCode);
    obj.put("CertPhotoA", certPhotoA);
    obj.put("CertPhotoB", certPhotoB);
    obj.put("LicensePhoto", licensePhoto);
    obj.put("PrgPhoto", prgPhoto);
    obj.put("IndustryLicensePhoto", industryLicensePhoto);
    obj.put("ShopPhoto", shopPhoto);
    obj.put("OtherPhoto", otherPhoto);
    obj.put("SubscribeAppId", subscribeAppId);



    System.out.println("商户详细信息：" + obj.toString());

    return new BASE64Encoder().encode(obj.toString().getBytes());
  }
}
