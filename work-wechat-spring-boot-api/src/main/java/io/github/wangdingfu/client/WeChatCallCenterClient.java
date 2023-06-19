package io.github.wangdingfu.client;

import io.github.wangdingfu.client.config.WeChatConfiguration;
import io.github.wangdingfu.response.BaseResponse;
import io.github.wangdingfu.response.kf.*;
import io.github.wangdingfu.resquest.kf.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 微信客服中心
 *
 * @author ddshuai
 * date 2022-08-31 22:34
 **/
@FeignClient(name = "WeChatCallCenterClient", url = "${work-wechat.url:https://qyapi.weixin.qq.com}", path = "${work-wechat.public-path:cgi-bin}", configuration = WeChatConfiguration.class)
public interface WeChatCallCenterClient extends CommonClient {
    /**
     * 添加客服帐号
     *
     * @param request 请求
     * @param app     应用
     * @return 新创建的客服帐号ID
     */
    @PostMapping(value = "kf/account/add", headers = HEAD)
    AddKfAccountResponse addKfAccount(KfAccountRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 删除客服帐号
     *
     * @param request 请求
     * @param app     应用
     * @return 无
     */
    @PostMapping(value = "kf/account/del", headers = HEAD)
    BaseResponse delKfAccount(DelKfAccountRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 修改客服帐号
     *
     * @param request 请求
     * @param app     应用
     * @return 无
     */
    @PostMapping(value = "kf/account/update", headers = HEAD)
    BaseResponse updateKfAccount(KfAccountRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 获取客服帐号列表
     *
     * @param app 应用名称
     * @return 账户列表
     */
    @GetMapping(value = "kf/account/list", headers = HEAD)
    KfAccountListResponse kfAccountLIst(@RequestParam(HEAD_KEY) String app);

    /**
     * 获取客服帐号链接
     *
     * @param request 请求
     * @param app     应用名称
     * @return 客服帐号链接
     */
    @PostMapping(value = "kf/add_contact_way", headers = HEAD)
    KfAddContactWayResponse kfContactWay(KfAddContactWayRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 添加接待人员
     *
     * @param request 请求
     * @param app     应用
     * @return 添加结果
     */
    @PostMapping(value = "kf/servicer/add", headers = HEAD)
    ServicerResponse addServicer(ServicerRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 删除接待人员
     *
     * @param request 请求
     * @param app     应用
     * @return 删除结果
     */
    @PostMapping(value = "kf/servicer/del", headers = HEAD)
    ServicerResponse delServicer(ServicerRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 获取接待人员列表
     *
     * @param openKfId 客服编号
     * @param app      应用
     * @return 接待人员列表
     */
    @GetMapping(value = "kf/servicer/list", headers = HEAD)
    ServicerListResponse getServicerList(@RequestParam("open_kfid") String openKfId, @RequestParam(HEAD_KEY) String app);

    /**
     * 获取会话状态
     *
     * @param request 请求
     * @param app     应用
     * @return 会话状态
     */
    @PostMapping(value = "kf/service_state/get", headers = HEAD)
    ServiceStateResponse getServiceState(ServiceStateRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 变更会话状态
     *
     * @param request 请求
     * @param app     应用
     * @return msgCode
     */
    @PostMapping(value = "kf/service_state/trans", headers = HEAD)
    ChangeServiceStateResponse changeServiceState(ChangeServiceStateRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 读取消息
     *
     * @param request 请求
     * @param app     应用
     * @return 消息
     */
    @PostMapping(value = "kf/sync_msg", headers = HEAD)
    SyncMsgResponse syncMsg(SyncMsgRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 发送消息
     *
     * @param msg 消息
     * @param app 应用
     * @return msgID
     */
    @PostMapping(value = "kf/send_msg", headers = HEAD)
    SendMsgResponse sendMsg(SendMsgRequest msg, @RequestParam(HEAD_KEY) String app);

    /**
     * 发送事件响应消息
     *
     * @param request 消息
     * @param app     应用
     * @return msgID
     */
    @PostMapping(value = "kf/send_msg_on_event", headers = HEAD)
    SendMsgResponse sendMsgOnEvent(SendMsgOnEventRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 获取客户基础信息
     *
     * @param request 请求
     * @param app     应用
     * @return 客户信息
     */
    @PostMapping(value = "kf/customer/batchget", headers = HEAD)
    GetCustomerResponse getCustomer(GetCustomerRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 获取配置的专员与客户群
     *
     * @param app 应用
     * @return 配置信息
     */
    @GetMapping(value = "kf/customer/get_upgrade_service_config", headers = HEAD)
    UpgradeServiceConfigResponse getUpgradeServiceConfig(@RequestParam(HEAD_KEY) String app);

    /**
     * 为客户升级为专员或客户群服务
     *
     * @param request 请求
     * @param app     应用
     * @return 操作结果
     */
    @PostMapping(value = "kf/customer/upgrade_service", headers = HEAD)
    BaseResponse upgradeService(UpgradeServiceRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 为客户取消推荐
     *
     * @param request 请求
     * @param app     应用
     * @return 操作结果
     */
    @PostMapping(value = "kf/customer/cancel_upgrade_service", headers = HEAD)
    BaseResponse cancelUpgradeService(CancelUpgradeServiceRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 可通过此接口创建新的知识库分组
     *
     * @param request 请求
     * @param app     应用
     * @return 分组编号
     */
    @PostMapping(value = "kf/knowledge/add_group", headers = HEAD)
    AddKnowledgeGroupResponse addKnowledgeGroup(KnowledgeGroupRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 修改分组
     *
     * @param request 请求
     * @param app     应用
     * @return 操作结果
     */
    @PostMapping(value = "kf/knowledge/mod_group", headers = HEAD)
    BaseResponse modKnowledgeGroup(KnowledgeGroupRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 可通过此接口删除已有的知识库分组，但不能删除系统创建的默认分组
     *
     * @param request 请求
     * @param app     应用
     * @return 分组编号
     */
    @PostMapping(value = "kf/knowledge/del_group", headers = HEAD)
    BaseResponse delKnowledgeGroup(DelKnowledgeGroupRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 获取分组列表
     *
     * @param request 请求
     * @param app     应用
     * @return 结果列表
     */
    @PostMapping(value = "kf/knowledge/list_group", headers = HEAD)
    KnowledgeGroupResponse queryKnowledgeGroup(QueryKnowledgeGroupRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 添加问答
     *
     * @param request 请求
     * @param app     应用
     * @return 问答编号
     */
    @PostMapping(value = "kf/knowledge/add_intent", headers = HEAD)
    AddIntentResponse addKnowledgeIntent(KnowledgeIntentRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 修改问答
     *
     * @param request 请求
     * @param app     应用
     * @return 操作结果
     */
    @PostMapping(value = "kf/knowledge/mod_intent", headers = HEAD)
    BaseResponse modKnowledgeIntent(KnowledgeIntentRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 删除问答
     *
     * @param request 请求
     * @param app     应用
     * @return 操作结果
     */
    @PostMapping(value = "kf/knowledge/del_intent", headers = HEAD)
    BaseResponse delKnowledgeIntent(DelKnowledgeIntentRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 获取问答列表
     *
     * @param request 请求
     * @param app     应用
     * @return 问答列表
     */
    @PostMapping(value = "kf/knowledge/list_intent", headers = HEAD)
    KnowledgeIntentResponse queryKnowledgeIntent(QueryKnowledgeIntentRequest request, @RequestParam(HEAD_KEY) String app);
}
