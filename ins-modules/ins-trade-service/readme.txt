一、简介

1、本demo为Java版本基于jdk1.6开发，用于接入网商银行聚合收单业务；
2、demo还在持续优化中，有任何问题或者建议请在钉钉群里反馈@虚生；
3、本demo可以直接运行；
4、配置改动：
网商银行联调人员提供的appid请在head.xml中替换，IsvOrgId 在com.mybank.bkmerchant.base.HttpsMain 中替换；
ISV测试公私钥和网商测试环境公钥在com.mybank.bkmerchant.util.XmlSignUtil中，根据需要替换

二、接入顺序

isv入驻申请，联调人员提供appid、IsvOrgId；

商户入驻：

1、图片上传com.mybank.bkmerchant.merchant.UploadPhoto
2、短信验证码接口com.mybank.bkmerchant.trade.SendSmsCode
3、商户入驻且开户申请接口com.mybank.bkmerchant.merchant.RegisterWithAccount
4、商户入驻结果查询com.mybank.bkmerchant.merchant.RegisterQuery
5、商户信息修改ant.mybank.merchantprod.merchant.updateMerchant

若开通余利宝则调用以下两个接口
6、余利宝签约接口com.mybank.bkmerchant.yulibao.FundAccountOpen
7、余利宝签约查询接口com.mybank.bkmerchant.yulibao.FundAccountOpenQuery
8、余利宝赎回预算接口com.mybank.bkmerchant.yulibao.RansomBudget
9、余利宝赎回到绑定卡接口com.mybank.bkmerchant.yulibao.Ransom

联机交易接口：

10、移动刷卡支付（被扫）接口com.mybank.bkmerchant.trade.ScanPay
11、H5支付（主扫）创建订单接口com.mybank.bkmerchant.trade.PrePay
12、订单查询接口com.mybank.bkmerchant.trade.PayQuery
13、订单撤销接口com.mybank.bkmerchant.trade.PayCancel 用于被扫模式
14、订单关闭接口com.mybank.bkmerchant.trade.PayClose该接口针对主扫模式，当订单创建后，消费者长时间未付款，合作方可通过本接口关闭订单
15、退款接口com.mybank.bkmerchant.trade.Refund
16、退款查询com.mybank.bkmerchant.trade.RefundQuery

三、其他

更多接口请详细看demo