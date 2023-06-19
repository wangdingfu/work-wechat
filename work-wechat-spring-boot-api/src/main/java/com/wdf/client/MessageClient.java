package com.wdf.client;

import com.wdf.client.config.WeChatConfiguration;
import com.wdf.response.BaseResponse;
import com.wdf.response.message.CreateAppChatResponse;
import com.wdf.response.message.SearchAppChatResponse;
import com.wdf.response.message.SendMessageResponse;
import com.wdf.resquest.message.CreateAppChatRequest;
import com.wdf.resquest.message.SendAppChatRequest;
import com.wdf.resquest.message.SendMessageRequest;
import com.wdf.resquest.message.UpdateAppChatRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 企业微信消息相关接口
 *
 * @author ddshuai
 * date 2022-09-01 09:27
 **/
@FeignClient(name = "MessageClient", url = "${work-wechat.url:https://qyapi.weixin.qq.com}", path = "${work-wechat.public-path:cgi-bin}", configuration = WeChatConfiguration.class)
public interface MessageClient extends CommonClient {

    /**
     * 发送消息
     *
     * @param request 请求体
     * @param app     应用名
     * @return SendMessageResponse
     */
    @PostMapping(value = "message/send", headers = HEAD)
    SendMessageResponse sendMessage(SendMessageRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 创建群聊会话
     *
     * @param request 请求体
     * @param app     应用名
     * @return CreateAppChatResponse
     */
    @PostMapping(value = "appchat/create", headers = HEAD)
    CreateAppChatResponse createAppChat(CreateAppChatRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 修改群聊会话
     *
     * @param request 请求体
     * @param app     应用名
     * @return BaseResponse
     */
    @PostMapping(value = "appchat/update", headers = HEAD)
    BaseResponse updateAppChat(UpdateAppChatRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 获取群聊会话
     *
     * @param chatId 群聊编号
     * @param app    应用名
     * @return SearchAppChatResponse
     */
    @GetMapping(value = "appchat/get", headers = HEAD)
    SearchAppChatResponse searchAppChat(@RequestParam("chatid") String chatId, @RequestParam(HEAD_KEY) String app);

    /**
     * 发送群消息
     *
     * @param request 请求体
     * @param app     应用名
     * @return BaseResponse
     */
    @PostMapping(value = "appchat/send", headers = HEAD)
    BaseResponse sendAppChatMessage(SendAppChatRequest request, @RequestParam(HEAD_KEY) String app);
}
