package com.mybank.bkmerchant.models;

import org.json.JSONException;
import org.json.JSONObject;
import sun.misc.BASE64Encoder;

/**
 * Created by jingzhu.zr on 2017/8/15.
 */
public class BankCardParam{
  String bankCardNo;
  String bankCertName;
  String accountType;
  String contactLine;
  String branchName;
  String branchProvince;
  String branchCity;
  String certType;
  String certNo;
  String cardHolderAddress;

  public BankCardParam(String bankCardNo, String bankCertName, String accountType, String contactLine, String branchName, String branchProvince, String branchCity, String certType, String certNo, String cardHolderAddress) {
    this.bankCardNo = bankCardNo;
    this.bankCertName = bankCertName;
    this.accountType = accountType;
    this.contactLine = contactLine;
    this.branchName = branchName;
    this.branchProvince = branchProvince;
    this.branchCity = branchCity;
    this.certType = certType;
    this.certNo = certNo;
    this.cardHolderAddress = cardHolderAddress;
  }

  public String genJsonBase64() throws JSONException {
    JSONObject obj = new JSONObject();

    obj.put("BankCardNo", bankCardNo);
    obj.put("BankCertName", bankCertName);
    obj.put("AccountType", accountType);
    obj.put("ContactLine", contactLine);
    obj.put("BranchName", branchName);
    obj.put("BranchProvince", branchProvince);
    obj.put("BranchCity", branchCity);
    obj.put("CertType", certType);
    obj.put("CertNo", certNo);
    obj.put("CardHolderAddress", cardHolderAddress);

    System.out.println(obj.toString());

    return new BASE64Encoder().encode(obj.toString().getBytes());
  }
}

