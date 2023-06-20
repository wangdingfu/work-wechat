package io.github.wangdingfu;

import io.github.wangdingfu.callback.AesException;
import io.github.wangdingfu.callback.WXBizJsonMsgCrypt;
import io.github.wangdingfu.event.BaseEventData;
import io.github.wangdingfu.support.CallBackManager;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * 描述 企业微信回调
 * token 4pd5Q2GAVKAapyTD0IGLMD7Lngiyx
 * aeskey QJqvdlS4M4FTPUNqSQrMg3VwNRyBCqTqtNStREy3Ahd
 *
 * @author ddshuai
 * date 2021-07-13 13:33
 **/
@RestController
@RequestMapping("/")
public class CallbackController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 统一回调处理
     *
     * @param msgSignature
     * @param nonce
     * @param echoStr
     * @param timestamp
     * @param xml
     * @return
     * @throws AesException
     */
    @RequestMapping("/callback/{app}")
    public String callback(@RequestParam(value = "msg_signature", required = false) String msgSignature,
                           @RequestParam(value = "nonce", required = false) String nonce,
                           @RequestParam(value = "echostr", required = false) String echoStr,
                           @RequestParam(value = "timestamp", required = false) String timestamp,
                           @RequestBody(required = false) String xml,
                           @PathVariable String app

    ) throws AesException {
        logger.info("密文--{}--timestamp--{}--nonce---{},echostr--{}", msgSignature, timestamp, nonce, echoStr);
        if (StringUtils.isNotEmpty(echoStr)) {
            return CallBackManager.verifyUrl(app, msgSignature, timestamp, nonce, echoStr);
        }

        if (StringUtils.isNotEmpty(xml)) {
            BaseEventData eventData = CallBackManager.handle(app, xml, msgSignature, timestamp, nonce);
            logger.info("明文信息为：{}",eventData.getDecryptMsg());
            logger.info("获取到的数据---{}", eventData);
            if ("taskcard_click".equals(eventData.getEvent())) {
                logger.info("任务卡片回调---回调带返回值的情况");
                String returnData = "<xml>\n" +
                        "   <ToUserName><![CDATA[20170410022717]]></ToUserName>\n" +
                        "   <FromUserName><![CDATA[ww36e0a51aab349a7d]]></FromUserName>\n" +
                        "   <CreateTime>1626852240</CreateTime>\n" +
                        "   <MsgType><![CDATA[update_taskcard]]></MsgType>\n" +
                        "   <TaskCard>\n" +
                        "       <ReplaceName><![CDATA[已批准]]></ReplaceName>\n" +
                        "   </TaskCard>\n" +
                        "</xml>";

                return CallBackManager.msgEncrypt(app, returnData);
            }
            return "";
        }

        return null;
    }

    @RequestMapping("/json/callback")
    public String callbackJson(@RequestParam(value = "msg_signature", required = false) String msgSignature,
                               @RequestParam(value = "nonce", required = false) String nonce,
                               @RequestParam(value = "echostr", required = false) String echoStr,
                               @RequestParam(value = "timestamp", required = false) String timestamp,
                               @RequestBody(required = false) String json
    ) throws AesException {
        logger.info("密文--{}--timestamp--{}--nonce---{},echostr--{}", msgSignature, timestamp, nonce, echoStr);
        WXBizJsonMsgCrypt crypt = new WXBizJsonMsgCrypt("4pd5Q2GAVKAapyTD0IGLMD7Lngiyx", "QJqvdlS4M4FTPUNqSQrMg3VwNRyBCqTqtNStREy3Ahd", "ww36e0a51aab349a7d");
        if (StringUtils.isNotEmpty(echoStr)) {
            String msg = crypt.VerifyURL(msgSignature, timestamp, nonce, echoStr);
            logger.info(msg);
            return msg;
        }

        if (StringUtils.isNotEmpty(json)) {
            logger.info("接收到的postData--{}", json);
            String data = crypt.DecryptMsg(msgSignature, timestamp, nonce, json);
            logger.info("拿到的明文信息---{}", data);
            return data;
        }

        return null;
    }
}
