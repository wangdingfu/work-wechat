package io.github.wangdingfu.service;

import io.github.wangdingfu.response.exmail.CreatePublicMailResponse;
import io.github.wangdingfu.response.exmail.MailDetailResponse;
import io.github.wangdingfu.response.exmail.MailGroupDetailResponse;
import io.github.wangdingfu.response.exmail.SearchMailGroupResponse;
import io.github.wangdingfu.resquest.exmail.*;
import org.springframework.stereotype.Service;

/**
 * 邮箱及群组管理
 */
@Service
public class EnterpriseEmailService extends AbstractBaseService {

    /**
     * 创建邮件群组
     *
     * @param request         请求
     * @param applicationName 应用
     */
    public void createMailGroup(MailGroupRequest request, String applicationName) {
        emailClient.createMailGroup(request, applicationName);
    }

    /**
     * 更新邮件群组
     *
     * @param request         请求
     * @param applicationName 应用
     */
    public void updateMailGroup(MailGroupRequest request, String applicationName) {
        emailClient.updateMailGroup(request, applicationName);
    }

    /**
     * 删除邮件群组
     *
     * @param request         请求
     * @param applicationName 应用
     */
    public void deleteMailGroup(DeleteMailGroupRequest request, String applicationName) {
        emailClient.deleteMailGroup(request, applicationName);
    }

    /**
     * 获取邮件群组详情
     *
     * @param groupId         群组编号
     * @param applicationName 应用
     * @return 群组详情
     */
    public MailGroupDetailResponse getMailGroupDetail(String groupId, String applicationName) {
        return emailClient.getMailGroupDetail(groupId, applicationName);
    }

    /**
     * @param groupId         群组编号
     * @param fuzzy           1开启模糊搜索，0获取全部邮件群组
     * @param applicationName 应用
     * @return 查询结果
     */
    public SearchMailGroupResponse searchGroup(String groupId, int fuzzy, String applicationName) {
        return emailClient.searchGroup(groupId, fuzzy, applicationName);
    }

    /**
     * 创建业务邮箱
     *
     * @param request         请求
     * @param applicationName 应用
     * @return 业务邮箱ID
     */
    public CreatePublicMailResponse createPublicMail(CreatePublicMailRequest request, String applicationName) {
        return emailClient.createPublicMail(request, applicationName);
    }

    /**
     * 更新业务邮箱
     *
     * @param request         请求
     * @param applicationName 应用
     */
    public void updatePublicMail(UpdatePublicMailRequest request, String applicationName) {
        emailClient.updatePublicMail(request, applicationName);
    }

    /**
     * 删除业务邮箱
     *
     * @param request         请求
     * @param applicationName 应用
     */
    public void deletePublicMail(DeletePublicMailRequest request, String applicationName) {
        emailClient.deletePublicMail(request, applicationName);
    }

    /**
     * 获取业务邮箱详情
     *
     * @param request         请求
     * @param applicationName 应用
     * @return 详情信息
     */
    public MailDetailResponse getMailDetail(GetMailDetailRequest request, String applicationName) {
        return emailClient.mailDetail(request, applicationName);
    }
}
