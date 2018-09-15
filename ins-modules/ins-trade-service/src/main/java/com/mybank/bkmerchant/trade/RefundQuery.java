/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.mybank.bkmerchant.trade;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.MapUtils;

import com.mybank.bkmerchant.base.HttpsMain;
import com.mybank.bkmerchant.constant.TradeStatusEnum;
import com.mybank.bkmerchant.util.XmlSignUtil;
import com.mybank.bkmerchant.util.XmlUtil;

/**
 * 4.2.14   退款查询<ant.mybank.bkmerchanttrade.refundQuery>
 * 
 * @author simon.xxm
 * @version $Id: RefundQuery.java, v 0.1 2017年7月26日 下午4:04:57 simon.xxm Exp $
 */
public class RefundQuery {

    /**
     * @author simon.xxm
     * @version $Id: BalanceQuery.java, v 0.1 2016年3月3日 下午6:33:49 simon.xxm Exp $
     * @param args      
     */
    public static void main(String[] args) throws Exception {
        refundQuery(HttpsMain.merchantId, "0034d296-1b3b-453f-a2c7-1fd453167d70");

    }

    public static Map<String, Object> refundQuery(String merchantId, String outRefundNo)
                                                                                        throws Exception {
        //账户余额查询
        String function = "ant.mybank.bkmerchanttrade.refundQuery";

        XmlUtil xmlUtil = new XmlUtil();
        Map<String, String> form = new HashMap<String, String>();
        form.put("Function", function);
        form.put("ReqTime", new Timestamp(System.currentTimeMillis()).toString());
        //reqMsgId每次报文必须都不一样
        form.put("ReqMsgId", UUID.randomUUID().toString());
        form.put("MerchantId", merchantId);
        form.put("OutRefundNo", outRefundNo);
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
        //退款交易号
        outRefundNo = (String) resMap.get("OutRefundNo");
        System.out.println(outRefundNo);
        /**TradeStatus 退款交易状态。
        1、  成功：succ
        2、  失败：fail
        3、  退款中:refunding。*/

        return resMap;
    }

    public static TradeStatusEnum refundStatusQuery(String merchantId, String outRefundNo)
                                                                                          throws Exception {
        Map<String, Object> resMap = refundQuery(merchantId, outRefundNo);
        if (MapUtils.isEmpty(resMap)) {
            return null;
        }
        return TradeStatusEnum.getTradeStatusByCode((String) resMap.get("TradeStatus"));
    }

}
