/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.mybank.bkmerchant.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.IOUtils;
import org.apache.xml.security.signature.XMLSignature;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.mybank.bkmerchant.util.SignatureUtils;
import com.mybank.bkmerchant.util.XmlSignatureAppendMode;

/**
 * 进行签名验签的测试
 * 
 * @author jin.xie
 * @version $Id: XmlSignTest.java, v 0.1 2016年2月1日 上午10:51:39 jin.xie Exp $
 */
public class XmlSignTest {
    /** 公钥 RSA */
    private final static String PRIVATE_KEY = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBANKaZf8dXuV+PKlBDsES5xuElAEmtsqEL6oNLtQvqkuzt13ujv3KMQIBMSj+HEwIB2fj8MAHJAW+eUTSpYBNMF/0MOKuvCBzxchazz1vC1vW5xvV4reA+mrrOHse/yfuhurGLwMlBG3LWpGDsASXomfcFBRkaVBCsUJrrtRKOhpzAgMBAAECgYA1/xY1oa8qAgLFloOU5ybP/F8CKI3nQJsD65tdFdeAz1QtRjPtSADmta2ICBbzO3/CmEOqyGno+xwWlDeQvLmw+QfSpwadrkQ7r/5D+Pwin4AYx3G0PJJtNpsacoemDLvK2q3fSz7lj+pAd5WIGCs5GI++XlRUPqfhy8yIUmnWQQJBAPmJGRtV4gcFhVVcQmFHrMm9uPXH72zGh+mX9r5nG4wx8h8cBGIhw8dQWOWkS7PxbJ4S0bKPPpBJ0tpkw3zOc2ECQQDYDxpyjD7Otz4/yT5vnptbjUup56/dnpVV/uZBRL9spg9sHhJaJ4+47q9dR71AVTMRYglktFpS+6N+mxH92fJTAkEAipB+yJcgNBX0vDnHAo3yfPRFSPYFFboIrsYb1g8bVPZHJM9B/9wQAxWyx5I8F2fwkLaSizzP2P+lfnCFvUBHAQJBAMEWVlNyhJrm5mnI5tSIEV1zW+Be3yuXEuzEnXBNCSoHChdclJgfbPEf1nbtqvM4cSgizjRCfcpVetqlqSGNSmMCQQCKDRhLJjlYDFHNknh3kOKo1lrefnBNukUOSR1HpLhikUNSL8f+m44TZPb+x7twkC/zbYaAt2j1+6HnsSPx11VQ";

    /** 私钥 RSA */
    private final static String PUBLIC_KEY  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDSmmX/HV7lfjypQQ7BEucbhJQBJrbKhC+qDS7UL6pLs7dd7o79yjECATEo/hxMCAdn4/DAByQFvnlE0qWATTBf9DDirrwgc8XIWs89bwtb1ucb1eK3gPpq6zh7Hv8n7obqxi8DJQRty1qRg7AEl6Jn3BQUZGlQQrFCa67USjoacwIDAQAB";

    public static void main(String[] args) throws Exception {
        new XmlSignTest().testVerify();
    }

    /**
     * 签名测试 - XML
     * 
     * @throws Exception
     */
    @Test
    public void testSign() throws Exception {
        Document doc = parseDocument("/xml/origin.xml");

        PrivateKey privateKey = SignatureUtils.getPrivateKey(PRIVATE_KEY);
        String result = SignatureUtils.signXmlElement(privateKey, doc, "request",
            XMLSignature.ALGO_ID_SIGNATURE_RSA_SHA256, XmlSignatureAppendMode.AS_BROTHER);
        System.out.println(result);
    }

    /**
     * 验签测试 - XML
     * 
     * @throws Exception
     */
    public void testVerify() throws Exception {
        Document doc = parseDocument("/xml/signed.xml");
        PublicKey publicKey = SignatureUtils.getPublicKey(PUBLIC_KEY);

        boolean result = SignatureUtils.verifyXmlElement(publicKey, doc);

        System.out.println(result);
    }

    /**
     * 自签自验 -XML
     */
    @Test
    public void signAndVerify() throws Exception {
        // 自己签名
        Document doc = parseDocument("/xml/origin.xml");

        PrivateKey privateKey = SignatureUtils.getPrivateKey(PRIVATE_KEY);
        String result = SignatureUtils.signXmlElement(privateKey, doc, "request",
            XMLSignature.ALGO_ID_SIGNATURE_RSA_SHA256, XmlSignatureAppendMode.AS_BROTHER);
        System.out.println(result);

        // 自己验签
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document signDoc = builder.parse(new InputSource(new ByteArrayInputStream(result
            .getBytes("UTF-8"))));

        PublicKey publicKey = SignatureUtils.getPublicKey(PUBLIC_KEY);

        Assert.assertTrue(SignatureUtils.verifyXmlElement(publicKey, signDoc));
    }

    /**
     * 解析XML
     * 
     * @param resourceName
     * @return
     * @throws SAXException
     * @throws IOException
     * @throws ParserConfigurationException
     */
    private Document parseDocument(String resourceName) throws SAXException, IOException, Exception {
        URL resource = SignatureUtils.class.getResource(resourceName);

        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(resource.openStream(), "UTF-8");
            InputSource inputSource = new InputSource(reader);
            inputSource.setEncoding("UTF-8");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);// 否则无法识别namespace
            Document doc = factory.newDocumentBuilder().parse(inputSource);
            return doc;
        } finally {
            IOUtils.closeQuietly(reader);
        }
    }

}