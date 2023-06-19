package com.wdf.client;

import com.wdf.client.config.WeChatConfiguration;
import com.wdf.response.BaseResponse;
import com.wdf.response.exmail.*;
import com.wdf.resquest.exmail.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 企业邮箱管理
 */
@FeignClient(name = "EnterpriseEmailClient", url = "${work-wechat.url:https://qyapi.weixin.qq.com}", path = "${work-wechat.public-path:cgi-bin}", configuration = WeChatConfiguration.class)
public interface EnterpriseEmailClient extends CommonClient {

    /**
     * 创建邮件群组
     * 该接口用于创建新邮件群组，可以指定群组成员，定义群组使用权限范围
     *
     * @param request 请求
     * @param app     应用
     * @return 操作结果
     */
    @PostMapping(value = "exmail/group/create", headers = HEAD)
    BaseResponse createMailGroup(MailGroupRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 更新邮件群组
     * 该接口用于更新邮件群组，可以修改群组名称、群组成员、群组使用权限等。需要注意的是Json数组类型传空值将会清空其内容，不传则保持不变
     *
     * @param request 请求
     * @param app     应用
     * @return 操作结果
     */
    @PostMapping(value = "exmail/group/update", headers = HEAD)
    BaseResponse updateMailGroup(MailGroupRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 删除邮件群组
     *
     * @param request 请求
     * @param app     应用
     * @return 操作结果
     */
    @PostMapping(value = "exmail/group/delete", headers = HEAD)
    BaseResponse deleteMailGroup(DeleteMailGroupRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 获取邮件群组详情
     *
     * @param groupId 群组编号
     * @param app     应用
     * @return 详情信息
     */
    @GetMapping(value = "exmail/group/get", headers = HEAD)
    MailGroupDetailResponse getMailGroupDetail(@RequestParam("groupid") String groupId, @RequestParam(HEAD_KEY) String app);

    /**
     * @param groupId 群组编号
     * @param fuzzy   1开启模糊搜索，0获取全部邮件群组
     * @param app     邮件群组ID，邮箱格式
     * @return 查询结果
     */
    @GetMapping(value = "exmail/group/search", headers = HEAD)
    SearchMailGroupResponse searchGroup(@RequestParam("groupid") String groupId, @RequestParam("fuzzy") int fuzzy, @RequestParam(HEAD_KEY) String app);

    /**
     * 创建业务邮箱
     *
     * @param request 请求
     * @param app     应用
     * @return 业务邮箱ID
     */
    @PostMapping(value = "exmail/publicmail/create", headers = HEAD)
    CreatePublicMailResponse createPublicMail(CreatePublicMailRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 更新业务邮箱
     *
     * @param request 请求
     * @param app     应用
     * @return 业务邮箱ID
     */
    @PostMapping(value = "exmail/publicmail/update", headers = HEAD)
    BaseResponse updatePublicMail(UpdatePublicMailRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 删除业务邮箱
     *
     * @param request 请求
     * @param app     应用
     * @return 操作结果
     */
    @PostMapping(value = "exmail/publicmail/delete", headers = HEAD)
    BaseResponse deletePublicMail(DeletePublicMailRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 获取业务邮箱详情
     *
     * @param request 请求
     * @param app     应用
     * @return 详情信息
     */
    @PostMapping(value = "/exmail/publicmail/get", headers = HEAD)
    MailDetailResponse mailDetail(GetMailDetailRequest request, @RequestParam(HEAD_KEY) String app);

    /**
     * 模糊搜索业务邮箱
     *
     * @param email 邮箱
     * @param fuzzy 1开启模糊搜索，0获取全部业务邮箱
     * @param app   应用
     * @return 搜索结果
     */
    @GetMapping(value = "/exmail/publicmail/search", headers = HEAD)
    SearchMailResponse searchEmail(@RequestParam("email") String email, @RequestParam("fuzzy") int fuzzy, @RequestParam(HEAD_KEY) String app);
}
