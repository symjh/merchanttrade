/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.mybank.bkmerchant.trade;

import java.util.Map;

import com.mybank.bkmerchant.base.HttpsMain;
import com.mybank.bkmerchant.util.XmlSignUtil;
import com.mybank.bkmerchant.util.XmlUtil;

/**
 * 4.2.9    创建订单结果通知<ant.mybank.bkmerchanttrade.prePayNotice>
 * @author simon.xxm
 * @version $Id: ReceiveOrderResultNotify.java, v 0.1 2017年7月26日 下午3:25:23 simon.xxm Exp $
 */
public class ReceiveOrderResultNotify {

    /**
     * @author simon.xxm
     * @version $Id: BalanceQuery.java, v 0.1 2016年3月3日 下午6:33:49 simon.xxm Exp $
     * @param args      
     */
    public static void main(String[] args) throws Exception {
        String response = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><document><request id=\"request\"><head><Version>1.0.0</Version><Appid>2017060700000025</Appid><Function>ant.mybank.bkmerchanttrade.prePayNotice</Function><ReqTime>20170726152805</ReqTime><ReqTimeZone>UTC+8</ReqTimeZone><ReqMsgId>2017072615280553060311</ReqMsgId><Reserve></Reserve><SignType>RSA</SignType><InputCharset>UTF-8</InputCharset></head><body><IsvOrgId>202210000000000001055</IsvOrgId><OutTradeNo>2017072629DAA73BDA2ACF0997F87A1A34E881B2</OutTradeNo><OrderNo>2017072610152010020001880000043201</OrderNo><ChannelType>ALI</ChannelType><TotalAmount>5400</TotalAmount><Currency>CNY</Currency><MerchantId>226801000000009423880</MerchantId><Attach></Attach><GmtPayment>2017-07-26 12:23:34</GmtPayment><BankType></BankType><IsSubscribe>N</IsSubscribe><PayChannelOrderNo>2017072621001004650243771082</PayChannelOrderNo></body></request></document>";
        String function = "ant.mybank.bkmerchanttrade.prePayNotice";
        XmlUtil xmlUtil = new XmlUtil();
        //解析报文
        Map<String, Object> resMap = xmlUtil.parseReceive(response, function);
        //支付订单号
        String orderNo = (String) resMap.get("OrderNo");
        System.out.println(orderNo);
    }

    public static Map<String, Object> orderResultNotify(String response) throws Exception {
        System.out.println(response);
        if (HttpsMain.isSign) {//生产环境需进行rsa验签
            if (!XmlSignUtil.verify(response)) {
                throw new Exception("验签失败");
            }
        }
        String function = "ant.mybank.bkmerchanttrade.prePayNotice";
        XmlUtil xmlUtil = new XmlUtil();
        //解析报文
        Map<String, Object> resMap = xmlUtil.parseReceive(response, function);
        //支付订单号
        String orderNo = (String) resMap.get("OrderNo");
        System.out.println(orderNo);
        return resMap;
    }

}
