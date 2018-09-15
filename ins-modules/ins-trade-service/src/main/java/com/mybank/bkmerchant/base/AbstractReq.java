package com.mybank.bkmerchant.base;

import com.mybank.bkmerchant.util.XmlSignUtil;
import com.mybank.bkmerchant.util.XmlUtil;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by jingzhu.zr on 2017/7/27.
 */
public abstract class AbstractReq {
  private String function;
  private Map<String, String> form;
  private XmlUtil xmlUtil;

  public AbstractReq(String function) {
    this.function = function;
    this.form = new HashMap<String, String>();
    this.xmlUtil = new XmlUtil();
  }

  public abstract Map<String, String> getBody();

  private void writeForm() {
    form.clear();
    form.put("Function", function);
    form.put("ReqTime", new Timestamp(System.currentTimeMillis()).toString());
    //reqMsgId每次报文必须都不一样
    form.put("ReqMsgId", UUID.randomUUID().toString());
    form.putAll(getBody());
  }

  public Map<String, Object> call() throws Exception{
    writeForm();

    //封装报文
    String param = xmlUtil.format(form, function);
    if (HttpsMain.isSign) {//生产环境需进行rsa签名
      param = XmlSignUtil.sign(param);
    }
    System.out.println("-------------------------");
    System.out.println("---------REQUEST---------");
    System.out.println("-------------------------");
    System.out.println(param);
    //发送请求
    String response = HttpsMain.httpsReq(HttpsMain.reqUrl, param);

    System.out.println("-------------------------");
    System.out.println("---------RESPONSE--------");
    System.out.println("-------------------------");
    System.out.println(response);
    if (HttpsMain.isSign) {//生产环境需进行rsa验签
      if (!XmlSignUtil.verify(response)) {
        throw new Exception("验签失败");
      }
    }
    //解析报文
    return xmlUtil.parse(response, function);
  }
}
