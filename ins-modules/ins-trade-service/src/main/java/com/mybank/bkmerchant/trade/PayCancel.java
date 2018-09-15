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
import org.apache.commons.lang.StringUtils;

import com.mybank.bkmerchant.base.HttpsMain;
import com.mybank.bkmerchant.constant.ReturnCodeEnum;
import com.mybank.bkmerchant.constant.TradeStatusEnum;
import com.mybank.bkmerchant.util.XmlSignUtil;
import com.mybank.bkmerchant.util.XmlUtil;

/**
 * 4.2.12   订单撤销接口<ant.mybank.bkmerchanttrade.payCancel>
 * 
 * @author simon.xxm
 * @version $Id: PayCancle.java, v 0.1 2017年7月26日 下午4:04:57 simon.xxm Exp $
 */
public class PayCancel {

    /**
     * @author simon.xxm
     * @version $Id: BalanceQuery.java, v 0.1 2016年3月3日 下午6:33:49 simon.xxm Exp $
     * @param args      
     */
    public static void main(String[] args) throws Exception {
        Map<String, Object> map = PayQuery.payQuery(HttpsMain.merchantId,
            "eb55f3ba-8973-485d-a86d-387e9e75bb54");
        //非处理中订单不能关闭
        if (MapUtils.isEmpty(map)
            || !StringUtils.equals(TradeStatusEnum.paying.getStatusCode(), map.get("TradeStatus")
                .toString())) {
            System.out.println(map.get("TradeStatus").toString() + "订单状态不是支付中无法撤单");
            return;
        }
        payCancel(HttpsMain.merchantId, UUID.randomUUID().toString());

    }

    public static boolean payCancel(String merchantId, String outTradeNo) throws Exception {
        //账户余额查询
        String function = "ant.mybank.bkmerchanttrade.payCancel";

        XmlUtil xmlUtil = new XmlUtil();
        Map<String, String> form = new HashMap<String, String>();
        form.put("Function", function);
        form.put("ReqTime", new Timestamp(System.currentTimeMillis()).toString());
        //reqMsgId每次报文必须都不一样
        form.put("ReqMsgId", UUID.randomUUID().toString());
        form.put("MerchantId", merchantId);
        form.put("OutTradeNo", outTradeNo);
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
        //支付订单号
        String orderNo = (String) resMap.get("OrderNo");
        System.out.println(orderNo);
        @SuppressWarnings("rawtypes")
        String resultCode = (String) ((Map) resMap.get("RespInfo")).get("ResultCode");
        if (StringUtils.equals(ReturnCodeEnum.SUCCESS.getReturnCode(), resultCode)
            || StringUtils.equals(ReturnCodeEnum.ORDER_CLOSED.getReturnCode(), resultCode)) {
            return true;
        }
        return false;
    }

}
