/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.mybank.bkmerchant.account;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.mybank.bkmerchant.base.HttpsMain;
import com.mybank.bkmerchant.util.XmlSignUtil;
import com.mybank.bkmerchant.util.XmlUtil;

/**
 * 4.3.1    商户银行账户开通<ant.mybank.merchantprod.account.open>
 * @author simon.xxm
 * @version $Id: Refund.java, v 0.1 2016年3月3日 下午6:33:49 simon.xxm Exp $
 */
public class OpenBankAccount {

    /**
     * @author simon.xxm
     * @version $Id: BalanceQuery.java, v 0.1 2016年3月3日 下午6:33:49 simon.xxm Exp $
     * @param args      
     */
    public static void main(String[] args) throws Exception {
        openBankAccount(UUID.randomUUID().toString(), "888888", "6228480402564890018",
            "13345670987", "440901197709194316", "卫阳");

    }

    public static Map<String, Object> openBankAccount(String outTradeNo, String authCode,
                                                      String bankCardNo, String mobile,
                                                      String certNo, String certName)
                                                                                     throws Exception {
        //商户银行账户开通
        String function = "ant.mybank.merchantprod.account.open";

        XmlUtil xmlUtil = new XmlUtil();
        Map<String, String> form = new HashMap<String, String>();
        form.put("Function", function);
        form.put("ReqTime", new Timestamp(System.currentTimeMillis()).toString());
        //reqMsgId每次报文必须都不一样
        form.put("ReqMsgId", UUID.randomUUID().toString());
        form.put("OutMerchantId", UUID.randomUUID().toString());
        form.put("OutTradeNo", UUID.randomUUID().toString());
        form.put("CertName", certName);
        form.put("IsvOrgId", HttpsMain.IsvOrgId);
        form.put("CertNo", certNo);
        form.put("Mobile", mobile);
        form.put("BankCardNo", bankCardNo);
        form.put("AuthCode", authCode);
        form.put("IsvOrgId", HttpsMain.IsvOrgId);

        //封装报文
        String param = xmlUtil.format(form, function);
        if (HttpsMain.isSign) {//生产环境需进行rsa签名
            param = XmlSignUtil.sign(param);
        }
        System.out.println(param);
        //发送请求
        String response = HttpsMain.httpsReq(HttpsMain.reqUrl, param);
        System.out.println(response);
        if (HttpsMain.isSign) {//生产环境需进行rsa验签
            if (!XmlSignUtil.verify(response)) {
                throw new Exception("验签失败");
            }
        }
        //解析报文
        Map<String, Object> resMap = xmlUtil.parse(response, function);
        //商户号
        String merchantId = (String) resMap.get("MerchantId");
        System.out.println(merchantId);
        return resMap;
    }

}
