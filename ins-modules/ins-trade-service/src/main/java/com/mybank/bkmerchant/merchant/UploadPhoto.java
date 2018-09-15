package com.mybank.bkmerchant.merchant;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.joda.time.DateTime;
import com.mybank.bkmerchant.base.HttpsMain;
import com.mybank.bkmerchant.constant.PhotoType;
import com.mybank.bkmerchant.util.HttpsUtil;
import com.mybank.bkmerchant.util.RSA;
import com.mybank.bkmerchant.util.XmlSignUtil;
import com.mybank.bkmerchant.util.XmlUtil;

/**
 * Created by jingzhu.zr on 2017/7/27.
 */
public class UploadPhoto {
    private static final String CHARSET          = "UTF-8";
    private static final String SIGN_ALGORITHM   = "SHA256withRSA";

    /** 测试私钥 */
    private static final String TEST_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCV3Ju7rfIehCjimtzIeMb8lrZszv2w0QDdbtjNmKcvl3yuzTMzKddSs7X+ESPyydnKITLphExpliP/smqP0nfJFg7qFaNJTQxXxq3lLTZW82Bh8pEN2ZcsLUgkstLiTDv+NoQjkDw7Kw9NcRcgOlZseeO1zlemIE6u4zM8QIHNQYXcrDq1uaOcyU3LG02pq1/du2XljdQIN8mEj7deFnfs4XFLlB/GbG+4HbiQGfD/nh75qWvqdOHGu9UZUwxgpkaBMIboKZXXPVSOt6HR0KvEQcKnmbf+Ozavbb005Y8mR3qrhtSWC5TzIt/wtfSVO2Vq5I223CgfyFMNy/fPxO8FAgMBAAECggEAfqUolrqxWkilpJrq6h/nSZ60G8/xZHO8H2WFonnXD8kdfTu8gQhjB2kH6+XgU1Vxz/euZtl/GdvgID5O/6wFvtH9WKVgkJmkTKmCW6KRwXl7gkrTerjfoF3EEf9taAC00miP0t4ZiIcjL3ba7Elgr9tyLDpsp9+1nuYybkC1cRcXNKz63euk+zhyBrYwMoROBzchFfyaTOHlGy1GXe2cLLz78t0PywWglHu/lHGTDHIBBZKHTrXM0AM3LVaigUVX82m9Cjo9+IW/uV+ckJzM/Vo0qpLUlgi90wQbGW8DcGljfK/efPQWuzohOgG7QMUQtwwd0fR+JbspFXRcBsEHAQKBgQDlTI+XOVY+5sR6y2B9pul3DyWacRSLmNkVqSm0POq9ziuW9A21ABg7Tj3I83A6mjCyVSwtGL7k0wtAs9okf+nhw/jo45EN/yQlOCqcVa+2ZwszUsMt8MOV2UFc67fvwguEKkQxeIJptJx7uX59v7OkaKMu4LzOoTs+uELGpi7OeQKBgQCnUAJi3yB8h7vqe+bI3uef6Bz8UQW5i2FIJzFZIEPTvCh7a2onSgUqa3Hev7/5x5TH6BsepHaEacLQTGlDxORcfU+mpwtY1QMSIR7WAPwtHgVoE1ClJ1PQx6tBykvZJ3Tto5j3cLmObENUVTqxp6ON/zNoPN/ImoAkfaHQCxfR7QKBgQCxWlBNxTliGZeq6pdNWMaHIh4RoJkliCmQSXFKSTu/ZzHr5gScFOCpLlE3lqMdkJlNtfcfQl6UGnA/sVxukslRqARkDW/qhYdtik3a8aOgz36oScFRTUHaK1oVBvUT6uCBbzejk/Q60kmeoNCnbpkB9zUQUx92KtrqHhb4Ex1s8QKBgC61b3UaxX7+hb+Yh31cfV1u92iZVffOqYHzLxuqnkTmKocKHcCKMZb+F/QPpBCfXzHP4oJTd6LPw8tTCbAZr4cClNH5oHlUPl85T9p+u+f8kZXUjpcMu6F1nKHpT/N3yHTvTy0FE0hngQRyJsih/E8QB9H57J+cQlntmNbzwdqhAoGANo/a54HZNsig31Qu6Ngls6eLMFxPB6Y61XxOb8+y2uoB4QYbnL+6as2NDEzZOmvlOlgPDF+eXsFMltWZnXvFQeNCvfu5a9/Gy8CbHGywXP4wyajV8IiXLVFqjCNwd62Mo6szxS1JkRUcstFdpfRhyupVzke/Yu9s/i9SBvV2liE=";

    private String              function         = "ant.mybank.merchantprod.merchant.uploadphoto";
    private String              isvOrgId         = HttpsMain.IsvOrgId;
    private String              photoType;
    private String              outTradeNo;
    private String              picture;
    private String              version          = HttpsMain.version;
    private String              appId            = "2018090700000286";
    private String              reqTime;
    private String              signature;

    public UploadPhoto(String photoType, String outTradeNo, String picture) {
        this.photoType = photoType;
        this.outTradeNo = outTradeNo;
        this.picture = picture;

        this.reqTime = new DateTime(System.currentTimeMillis()).toString("yyyyMMddHHmmss");
        try {
            this.signature = sign();
        } catch (Exception e) {
            System.out.println("签名生成失败.");
            e.printStackTrace();
        }

        System.out.println("【isvOrgId: " + isvOrgId + ", photoType: " + photoType
                           + ", outTradeNo: " + outTradeNo + ", picture: " + picture
                           + ", version: " + version + ", appId: " + appId + ", reqTime: "
                           + reqTime + ", signature: " + signature + "】");
    }

    public String sign() throws Exception {
        Map<String, String> params = new TreeMap<String, String>();
        params.put("AppId", appId);
        params.put("Function", function);
        params.put("IsvOrgId", isvOrgId);
        params.put("OutTradeNo", outTradeNo);
        params.put("PhotoType", photoType);
        params.put("ReqTime", reqTime);
        params.put("Version", version);

        StringBuilder sb = new StringBuilder();
        PrivateKey privateKey = RSA.getPrivateKey(TEST_PRIVATE_KEY);

        for (Map.Entry<String, String> entry : params.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append("&");
        }
        String source = URLEncoder.encode(sb.toString().substring(0, sb.toString().length() - 1),
            CHARSET);

        System.out.println("参与加密的明文：");
        System.out.println(source);

        final Signature signatureChecker = Signature.getInstance(SIGN_ALGORITHM);
        signatureChecker.initSign(privateKey);
        signatureChecker.update(source.getBytes(CHARSET));
        String signature = Base64.encodeBase64String(signatureChecker.sign());
        System.out.println("生成的最终签名：");
        System.out.println(signature);

        return signature;
    }

    private String genSig() {
        Map<String, String> params = new TreeMap<String, String>();
        params.put("IsvOrgId", isvOrgId);
        params.put("PhotoType", photoType);
        params.put("OutTradeNo", outTradeNo);
        params.put("Function", function);
        params.put("Version", version);
        params.put("AppId", appId);
        params.put("ReqTime", reqTime);

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append("&");
        }

        String source = URLEncoder.encode(sb.toString().substring(0, sb.toString().length() - 1));
        System.out.println(source);
        return RSA.sign(source, RSA.RSA_privateKey);
    }

    private HttpEntity buildReqEntity() throws UnsupportedEncodingException, FileNotFoundException {
        HttpEntity reqEntity = MultipartEntityBuilder.create()
            .addPart("IsvOrgId", new StringBody(isvOrgId))
            .addPart("PhotoType", new StringBody(photoType))
            .addPart("OutTradeNo", new StringBody(outTradeNo))
            .addBinaryBody("Picture", new File(picture), ContentType.DEFAULT_BINARY, picture)
            .addPart("Function", new StringBody(function))
            .addPart("Version", new StringBody(version)).addPart("AppId", new StringBody(appId))
            .addPart("ReqTime", new StringBody(reqTime))
            .addPart("Signature", new StringBody(signature)).build();

        return reqEntity;
    }

    public Map<String, Object> call() throws Exception {
        HttpEntity reqEntity = buildReqEntity();

        //发送请求
        String response = HttpsUtil.httpPost(HttpsMain.uploadUrl, reqEntity);

        System.out.println("-------------------------");
        System.out.println("---------RESPONSE-START--------");
        System.out.println("-------------------------");
        System.out.println(response);
        System.out.println("-------------------------");
        System.out.println("---------RESPONSE-END--------");
        System.out.println("-------------------------");
        if (HttpsMain.isSign) {//生产环境需进行rsa验签
            if (!XmlSignUtil.verify(response)) {
                throw new Exception("验签失败");
            }
        }
        //解析报文
        XmlUtil xmlUtil = new XmlUtil();
        return xmlUtil.parse(response, function);
    }

    public static void main(String[] args) throws Exception {
        UploadPhoto uploadPhoto = new UploadPhoto(
        /**
         * 图片类型。可选值：
         01 身份证正面
         02 身份证反面
         03 营业执照
         04 组织机构代码证
         05 开户许可证
         06 门头照
         07 其他
         */
        PhotoType.PRG_PHOTO,
        /**
         * 外部交易号
         */
        UUID.randomUUID().toString(),
        /**
         * 本地图片地址
         */
        "/Users/yanshuiping/Downloads/a.png");

        Map<String, Object> call = uploadPhoto.call();
        System.out.println("#####"+call.toString());
    }
}
