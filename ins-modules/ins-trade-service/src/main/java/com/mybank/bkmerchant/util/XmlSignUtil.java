/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.mybank.bkmerchant.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.xml.security.signature.XMLSignature;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * 进行签名验签的测试
 * 
 * @author jin.xie
 * @version $Id: XmlSignTest.java, v 0.1 2016年2月1日 上午10:51:39 jin.xie Exp $
 */
public class XmlSignUtil {
    /** 公钥 RSA */
    public static final String RSA_publicKey  = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAldybu63yHoQo4prcyHjG/Ja2bM79sNEA3W7YzZinL5d8rs0zMynXUrO1/hEj8snZyiEy6YRMaZYj/7Jqj9J3yRYO6hWjSU0MV8at5S02VvNgYfKRDdmXLC1IJLLS4kw7/jaEI5A8OysPTXEXIDpWbHnjtc5XpiBOruMzPECBzUGF3Kw6tbmjnMlNyxtNqatf3btl5Y3UCDfJhI+3XhZ37OFxS5QfxmxvuB24kBnw/54e+alr6nThxrvVGVMMYKZGgTCG6CmV1z1Ujreh0dCrxEHCp5m3/js2r229NOWPJkd6q4bUlguU8yLf8LX0lTtlauSNttwoH8hTDcv3z8TvBQIDAQAB";
    /** 私钥 RSA */
    public static final String RSA_privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCV3Ju7rfIehCjimtzIeMb8lrZszv2w0QDdbtjNmKcvl3yuzTMzKddSs7X+ESPyydnKITLphExpliP/smqP0nfJFg7qFaNJTQxXxq3lLTZW82Bh8pEN2ZcsLUgkstLiTDv+NoQjkDw7Kw9NcRcgOlZseeO1zlemIE6u4zM8QIHNQYXcrDq1uaOcyU3LG02pq1/du2XljdQIN8mEj7deFnfs4XFLlB/GbG+4HbiQGfD/nh75qWvqdOHGu9UZUwxgpkaBMIboKZXXPVSOt6HR0KvEQcKnmbf+Ozavbb005Y8mR3qrhtSWC5TzIt/wtfSVO2Vq5I223CgfyFMNy/fPxO8FAgMBAAECggEAfqUolrqxWkilpJrq6h/nSZ60G8/xZHO8H2WFonnXD8kdfTu8gQhjB2kH6+XgU1Vxz/euZtl/GdvgID5O/6wFvtH9WKVgkJmkTKmCW6KRwXl7gkrTerjfoF3EEf9taAC00miP0t4ZiIcjL3ba7Elgr9tyLDpsp9+1nuYybkC1cRcXNKz63euk+zhyBrYwMoROBzchFfyaTOHlGy1GXe2cLLz78t0PywWglHu/lHGTDHIBBZKHTrXM0AM3LVaigUVX82m9Cjo9+IW/uV+ckJzM/Vo0qpLUlgi90wQbGW8DcGljfK/efPQWuzohOgG7QMUQtwwd0fR+JbspFXRcBsEHAQKBgQDlTI+XOVY+5sR6y2B9pul3DyWacRSLmNkVqSm0POq9ziuW9A21ABg7Tj3I83A6mjCyVSwtGL7k0wtAs9okf+nhw/jo45EN/yQlOCqcVa+2ZwszUsMt8MOV2UFc67fvwguEKkQxeIJptJx7uX59v7OkaKMu4LzOoTs+uELGpi7OeQKBgQCnUAJi3yB8h7vqe+bI3uef6Bz8UQW5i2FIJzFZIEPTvCh7a2onSgUqa3Hev7/5x5TH6BsepHaEacLQTGlDxORcfU+mpwtY1QMSIR7WAPwtHgVoE1ClJ1PQx6tBykvZJ3Tto5j3cLmObENUVTqxp6ON/zNoPN/ImoAkfaHQCxfR7QKBgQCxWlBNxTliGZeq6pdNWMaHIh4RoJkliCmQSXFKSTu/ZzHr5gScFOCpLlE3lqMdkJlNtfcfQl6UGnA/sVxukslRqARkDW/qhYdtik3a8aOgz36oScFRTUHaK1oVBvUT6uCBbzejk/Q60kmeoNCnbpkB9zUQUx92KtrqHhb4Ex1s8QKBgC61b3UaxX7+hb+Yh31cfV1u92iZVffOqYHzLxuqnkTmKocKHcCKMZb+F/QPpBCfXzHP4oJTd6LPw8tTCbAZr4cClNH5oHlUPl85T9p+u+f8kZXUjpcMu6F1nKHpT/N3yHTvTy0FE0hngQRyJsih/E8QB9H57J+cQlntmNbzwdqhAoGANo/a54HZNsig31Qu6Ngls6eLMFxPB6Y61XxOb8+y2uoB4QYbnL+6as2NDEzZOmvlOlgPDF+eXsFMltWZnXvFQeNCvfu5a9/Gy8CbHGywXP4wyajV8IiXLVFqjCNwd62Mo6szxS1JkRUcstFdpfRhyupVzke/Yu9s/i9SBvV2liE=";

    /** 网商银行测试环境公钥 RSA */
    public static String bank_RSA_publicKey  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDOb4B1dnwONcW0RoJMa0IOq3O6jiqnTGLUpxEw2xJg+c7wsb6DBy5CAoR0w2ZjZ/BjKxGIQ+DoDg3NsHJeyuEjNF0/Ro/R5xVpFC5z4cBVSC2/gddz4a1EoGDJewML/Iv0yIw7ylB86++h23nRd079c5S9RZXurBfnLW2Srhqk2QIDAQAB";

    /**
     * 签名- XML
     *
     * @throws Exception
     */
    public static String sign(String xmlContent) throws Exception {
        Document doc = parseDocumentByString(xmlContent);
        PrivateKey privateKey = SignatureUtils.getPrivateKey(RSA_privateKey);
        String result = SignatureUtils.signXmlElement(privateKey, doc, "request", XMLSignature.ALGO_ID_SIGNATURE_RSA_SHA256, 2);
        return result;
    }

    /**
     * 验签 - XML
     *
     * @throws Exception
     */
    public static boolean verify(String xmlContent) throws Exception {
        Document doc = parseDocumentByString(xmlContent);
        PublicKey publicKey = SignatureUtils.getPublicKey(bank_RSA_publicKey);

        return SignatureUtils.verifyXmlElement(publicKey, doc);
    }

    /**
     * 解析XML
     *
     * @param xmlContent
     * @return
     * @throws SAXException
     * @throws IOException
     * @throws ParserConfigurationException
     */
    private static Document parseDocumentByString(String xmlContent) throws SAXException, IOException, Exception {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);// 否则无法识别namespace
        return factory.newDocumentBuilder().parse(new InputSource(new StringReader(xmlContent)));
    }

    public static void main(String[] args) throws Exception {
        bank_RSA_publicKey  = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAg0HDiStmHDTHOAptH5Jlp4sg03Czir/My4vvFK/7Un/zyuyTa3aHqav4+GqPhGJcIGIiLVuP/tCCEU4Edl3LC0bNxUBdnPv7k3HDoonWmqD/EhBXKe/GD/Dwrn90VfP1s314ykj8Z2T06l3LYb5F44L8JOgVrqJOe2FMXvsEt6sik2jnMdq2rJLeda1QLQMKnla4t2wVK1DoC0eu+ry3Oc2BWhYwU1bwWaX71mROH0Q3jXj3FFLdGp2trrnkKnQzNfGHjRChxTWl3CgiWbFd/Ejgp0/cpovq3cAJtxD7HdtwOibiI9u6owyWFM6C2pMjsuI23WofRyD9UQoU0UToiwIDAQAB";
        File file = new File("d:/sign.txt");
        InputStream in = new FileInputStream(file);
        byte[] b = new byte[in.available()];
        in.read(b);
        String xml = new String(b);
        in.close();
        boolean result = verify(xml);
        System.out.println(result);
    }

}