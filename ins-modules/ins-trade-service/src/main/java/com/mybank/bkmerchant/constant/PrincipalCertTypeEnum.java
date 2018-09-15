package com.mybank.bkmerchant.constant;

/**
 * Created by jingzhu.zr on 2017/8/15.
 */
public enum PrincipalCertTypeEnum {
  IdentityCard("01", "身份证")
  ;

  private String certCode;
  private String certDesc;

  PrincipalCertTypeEnum(String certCode, String certDesc) {
    this.certCode = certCode;
    this.certDesc = certDesc;
  }

  public String getCertCode() {
    return certCode;
  }

  public void setCertCode(String certCode) {
    this.certCode = certCode;
  }

  public String getCertDesc() {
    return certDesc;
  }

  public void setCertDesc(String certDesc) {
    this.certDesc = certDesc;
  }
}
