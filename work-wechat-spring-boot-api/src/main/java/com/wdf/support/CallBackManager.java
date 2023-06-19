package com.wdf.support;

import com.wdf.callback.AbstractCallBackChain;
import com.wdf.callback.AesException;
import com.wdf.callback.WXBizMsgXmlCrypt;
import com.wdf.client.config.CallbackProperties;
import com.wdf.event.BaseEventData;
import com.wdf.exception.WeChatException;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-07-20 15:57
 **/
public final class CallBackManager {

    private static final Logger logger = LoggerFactory.getLogger(CallBackManager.class);
    /**
     * 头结点
     */
    private static AbstractCallBackChain first;

    /**
     * 尾结点
     */
    private static AbstractCallBackChain last;

    private static List<CallbackProperties> CALLBACK_LIST;

    public static void properties(List<CallbackProperties> callbackList) {
        CALLBACK_LIST = callbackList;
    }

    /**
     * 注册处理逻辑
     *
     * @param callBackChain 处理链节点
     */
    public synchronized static void registerCallBack(AbstractCallBackChain callBackChain) {
        if (Objects.nonNull(callBackChain)) {
            if (canRegister(callBackChain)) {
                if (Objects.isNull(first)) {
                    first = callBackChain;
                    last = callBackChain;
                } else {
                    last.setNext(callBackChain);
                    last = callBackChain;
                }
            }
        }
    }

    private static boolean canRegister(AbstractCallBackChain callBackChain) {
        if (Objects.isNull(first)) {
            return true;
        }

        AbstractCallBackChain next = first;
        while (next != null) {
            if (next == callBackChain) {
                throw new RuntimeException("一个处理类只能注册一次");
            }
            next = next.getNext();
        }

        return true;
    }

    /**
     * 处理回调的数据
     *
     * @param applicationName 应用名
     * @param xml             回调的数据
     * @param msgSignature    签名信息
     * @param timestamp       时间戳
     * @param nonce           随机数
     * @return 消息内容
     * @throws AesException 解密异常
     */
    public static BaseEventData handle(String applicationName, String xml, String msgSignature, String timestamp, String nonce) throws AesException {

        CallbackProperties properties = getCallbackProperty(applicationName);
        if (Objects.isNull(properties)) {
            logger.error("应用-{}-未配置密钥信息，无法处理", applicationName);
            throw new WeChatException("应用-" + applicationName + "-未配置密钥信息，无法处理");
        }

        WXBizMsgXmlCrypt crypt = new WXBizMsgXmlCrypt(properties.getToken(), properties.getEncodingAesKey(), properties.getReceiveId());
        if (StringUtils.isNotEmpty(xml)) {
            if (logger.isInfoEnabled()) {
                logger.info("接收到的postData--{}", xml);
            }
            String data = crypt.DecryptMsg(msgSignature, timestamp, nonce, xml);
            if (logger.isInfoEnabled()) {
                logger.info("拿到的明文信息---{}", data);
            }
            BaseEventData eventData = EventDataManager.getXmlData(data);

            if (logger.isInfoEnabled()) {
                logger.info("BaseEventData -- {}", eventData);
            }

            if (Objects.nonNull(first)) {
                first.handleData(applicationName, eventData);
            }

            return eventData;
        }

        throw new WeChatException("消息体信息为空");
    }

    /**
     * 首次配置接收时间服务器时回应企业微信的校验请求
     *
     * @param msgSignature    签名信息
     * @param timestamp       时间戳
     * @param nonce           随机数
     * @param echoStr         echo字符串
     * @param applicationName 应用名
     * @return echo的明文
     * @throws AesException 解密异常
     */
    public static String verifyUrl(String applicationName, String msgSignature, String timestamp, String nonce, String echoStr) throws AesException {
        CallbackProperties properties = getCallbackProperty(applicationName);
        if (Objects.isNull(properties)) {
            logger.error("应用-{}-未配置密钥信息，无法处理", applicationName);
            return "";
        }
        WXBizMsgXmlCrypt crypt = new WXBizMsgXmlCrypt(properties.getToken(), properties.getEncodingAesKey(), properties.getReceiveId());
        return crypt.VerifyURL(msgSignature, timestamp, nonce, echoStr);
    }

    private static CallbackProperties getCallbackProperty(String applicationName) {
        if (Objects.nonNull(CALLBACK_LIST) && CALLBACK_LIST.size() > 0) {
            for (CallbackProperties callbackProperties : CALLBACK_LIST) {
                if (callbackProperties.getApplicationName() != null && callbackProperties.getApplicationName().equals(applicationName)) {
                    return callbackProperties;
                }
            }
        }

        return null;
    }

    public static String msgEncrypt(String applicationName, String text) throws AesException {
        CallbackProperties properties = getCallbackProperty(applicationName);
        if (Objects.isNull(properties)) {
            logger.error("应用-{}-未配置密钥信息，无法处理", applicationName);
            throw new RuntimeException("未配置密钥信息");
        }

        WXBizMsgXmlCrypt crypt = new WXBizMsgXmlCrypt(properties.getToken(), properties.getEncodingAesKey(), properties.getReceiveId());

        return crypt.EncryptMsg(text, System.currentTimeMillis() + "", RandomStringUtils.random(10, true, true));
    }
}
