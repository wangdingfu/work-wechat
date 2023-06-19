package com.wdf;

import com.wdf.dto.externalcontact.CustomTag;
import com.wdf.dto.externalcontact.GroupMsgTask;
import com.wdf.dto.externalcontact.OwnerFilter;
import com.wdf.dto.externalcontact.V2GroupMsg;
import com.wdf.dto.message.MsgLink;
import com.wdf.dto.message.MsgText;
import com.wdf.response.addressbook.MobileHashCodeResponse;
import com.wdf.response.externalcontact.*;
import com.wdf.resquest.CursorPageRequest;
import com.wdf.resquest.PageRequest;
import com.wdf.resquest.addressbook.MobileHashCodeRequest;
import com.wdf.resquest.addressbook.TagGroupRequest;
import com.wdf.resquest.externalcontact.*;
import com.wdf.service.CustomContactService;
import com.wdf.service.MediaService;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-01-13 13:43
 **/
public class CustomContactTest extends AbstractTest {

    private CustomContactService customContactService;
    private MediaService mediaService;

    @BeforeEach
    public void init() {
        this.customContactService = weChatManager.customContactService();
        this.mediaService = weChatManager.mediaService();
    }

    /**
     * 客户联系功能编码 与配置文件内定义的别名【application-name】一致
     */
    public static final String appName = "customer-contact";

    /**
     * externalUserId = wmCRbQBwAA2XZEynsl_hDoWnL_Ptb04Q
     */
    @Test
    public void unassignedList() {
        PageRequest request = new PageRequest();
        UnassignedListResponse response = customContactService.unassignedList(request, appName);
        logger.info("{}", response);
    }

    @Test
    public void getFollowUserList() {
        FollowUserResponse followUserResponse = customContactService.getFollowUserList(appName);
        logger.info("{}", followUserResponse);
    }

    /**
     * configId=8378a992fb470b9d6a4654e50a66580e
     * qrCode=https://wework.qpic.cn/wwpic/426899_56J5rK9OTiOMuSN_1610518083/0
     */
    @Test
    public void addContactWay() {
        AddContactWayRequest request = new AddContactWayRequest();
        request.setType(2);
        request.setScene(2);
        request.setRemark("渠道客户");
        request.setState("channel-code");
        request.setUsers(Arrays.asList("CaoMuJiangDeXiaoLu", "20170410022717"));
        AddContactWayResponse response = customContactService.addContactWay(request, appName);
        logger.info("{}", response);
    }

    @Test
    public void getContactWay() {
        GetContactWayRequest request = new GetContactWayRequest();
        request.setConfigId("8378a992fb470b9d6a4654e50a66580e");
        ContactWayResponse response = customContactService.getContactWay(request, appName);
        logger.info("{}", response);
    }

    @Test
    public void updateContactWay() {
        UpdateContactWayRequest request = new UpdateContactWayRequest();
        request.setConfigId("8378a992fb470b9d6a4654e50a66580e");
        request.setRemark("更新一下备注信息");
        customContactService.updateContactWay(request, appName);
    }

    @Test
    public void deleteContactWay() {
        GetContactWayRequest request = new GetContactWayRequest();
        request.setConfigId("8378a992fb470b9d6a4654e50a66580e");
        customContactService.deleteContactWay(request, appName);
    }

    @Test
    public void closeTempChat() {
        CloseTempChatRequest request = new CloseTempChatRequest();
        request.setExternalUserId("wmCRbQBwAAkqZa5eZQdUNFXgVIFr_DmA");
        request.setUserId("20170410022717");
        customContactService.closeTempChat(request, appName);
    }

    /**
     * groupId=etCRbQBwAAii_NXtxqQBMOnEuWV-_aEw
     */
    @Test
    public void addCorpTag() {
        AddCorpTagRequest request = new AddCorpTagRequest();
        request.setGroupName("渠道客户");

        CustomTag customTag = new CustomTag();
        customTag.setName("奇威客户");
        request.setTags(Collections.singletonList(customTag));
        AddCorpTagResponse response = customContactService.addCorpTag(request, appName);
        logger.info("{}", response);
    }

    @Test
    public void getCorpTagList() {
        TagGroupRequest request = new TagGroupRequest();
        TagGroupResponse response = customContactService.getCorpTagList(request, appName);
        logger.info("{}", response);
    }

    @Test
    public void editCorpTag() {
        EditCorpTagRequest request = new EditCorpTagRequest();
        request.setId("etCRbQBwAAl2--7nYobBfKpM9UxPSNeg");
        request.setName("奇威客户-edit");
        customContactService.editCorpTag(request, appName);
    }

    @Test
    public void delCorpTag() {
        DelCorpTagRequest request = new DelCorpTagRequest();
        request.setTagIds(Collections.singletonList("etCRbQBwAAl2--7nYobBfKpM9UxPSNeg"));
        customContactService.delCorpTag(request, appName);
    }

    @Test
    public void markTag() {
        MarkTagRequest request = new MarkTagRequest();
        request.setUserId("20170410022717");
        request.setAddTags(Collections.singletonList("etCRbQBwAAoLAm885Ob1ODeCPwi0Mtug"));
        request.setExternalUserId("wmCRbQBwAAkqZa5eZQdUNFXgVIFr_DmA");
        customContactService.markTag(request, appName);
    }

    @Test
    public void getCustomList() {
        CustomListRequest request = new CustomListRequest();
        request.setUserId("20170410022717");
        CustomListResponse response = customContactService.getCustomList(request, appName);
        logger.info("{}", response);
    }

    @Test
    public void transfer() {
        TransferRequest request = new TransferRequest();
        request.setHandoverUserId("20170410022717");
        request.setTakeoverUserId("SiGuangMeng");
        request.setExternalUserId("wmCRbQBwAAkqZa5eZQdUNFXgVIFr_DmA");
        request.setTransferSuccessMsg("您好，您的服务已升级，后续将由我的同事李四@腾讯接替我的工作，继续为您服务。");
        customContactService.transfer(request, appName);
    }

    @Test
    public void getTransferResult() {
        TransferResultRequest request = new TransferResultRequest();
        request.setHandoverUserId("20170410022717");
        request.setTakeoverUserId("SiGuangMeng");
        request.setExternalUserId("wmCRbQBwAAkqZa5eZQdUNFXgVIFr_DmA");
        TransferResultResponse response = customContactService.getTransferResult(request, appName);
        logger.info("{}", response);
    }

    /**
     * woCRbQBwAAqNfflCX9uvtAnmQ9YpNJZQ, wmCRbQBwAA2XZEynsl_hDoWnL_Ptb04Q, wmCRbQBwAAB_NAGsw3oltcZdRvcWyRbg
     */
    @Test
    public void getExternalContact() {
        ExternalContactResponse response = customContactService.getExternalContact("wmCRbQBwAAkqZa5eZQdUNFXgVIFr_DmA", appName);
        logger.info("{}", response);

        response = customContactService.getExternalContact("woCRbQBwAAqNfflCX9uvtAnmQ9YpNJZQ", appName);
        logger.info("{}", response);

        response = customContactService.getExternalContact("wmCRbQBwAA2XZEynsl_hDoWnL_Ptb04Q", appName);
        logger.info("{}", response);


        /*
         * logan
         * */
        response = customContactService.getExternalContact("wmCRbQBwAAB_NAGsw3oltcZdRvcWyRbg", appName);
        logger.info("{}", response);
    }

    @Test
    public void getBatchExternalContact() {
        BatchExternalContactRequest request = new BatchExternalContactRequest();
        request.setUserId("20170410022717");
        BatchExternalContactResponse response = customContactService.getBatchExternalContact(request, appName);
        logger.info("{}", response);
    }

    @Test
    public void updateCustomRemark() {
        UpdateRemarkRequest remarkRequest = new UpdateRemarkRequest();
        remarkRequest.setRemark("修改客户备注信息");
        remarkRequest.setExternalUserId("wmCRbQBwAAkqZa5eZQdUNFXgVIFr_DmA");
        remarkRequest.setUserId("20170410022717");
        customContactService.updateCustomRemark(remarkRequest, appName);
    }

    @Test
    public void getMobileHashcode() {
        MobileHashCodeRequest request = new MobileHashCodeRequest();
        request.setMobile("152xxxxxxxx");
        MobileHashCodeResponse response = customContactService.getMobileHashcode(request, appName);
        logger.info("{}", response);
    }


    /**
     * chatId = wrCRbQBwAAoFDTwM9TY8_tZpG8SJvS1Q
     */
    @Test
    public void groupChatList() {
        GroupChatListRequest request = new GroupChatListRequest();
        request.setLimit(100);
        GroupChatListResponse response = customContactService.groupChatList(request, appName);
        logger.info("{}", response);
    }

    @Test
    public void groupChatDetail() {
        GroupChatDetailRequest request = new GroupChatDetailRequest();
        request.setChatId("wrCRbQBwAAoFDTwM9TY8_tZpG8SJvS1Q");
        GroupChatDetailResponse response = customContactService.groupChatDetail(request, appName);
        logger.info("{}", response);
    }

    @Test
    public void getMomentList() throws ParseException {
        MomentListRequest request = new MomentListRequest();
        request.setStartTime(DateUtils.parseDate("2021-01-13", "yyyy-MM-dd"));
        request.setEndTime(DateUtils.parseDate("2021-01-15", "yyyy-MM-dd"));
        MomentListResponse response = customContactService.getMomentList(request, appName);
        logger.info("{}", response);
    }

    /**
     * msgId = msgCRbQBwAAUfGe9nf4saYGTPgAobR8jA
     */
    @Test
    public void addMsgTemplate() {
        MsgTemplateRequest request = new MsgTemplateRequest();
        request.setChatType("single");
        request.setExternalUserId(Collections.singletonList("wmCRbQBwAAB_NAGsw3oltcZdRvcWyRbg"));
        request.setSender("20170410022717");
        MsgText text = new MsgText("测试消息发送");
        request.setText(text);
        V2GroupMsg groupMsg = new V2GroupMsg();
        groupMsg.setMsgType("link");

        MsgLink link = new MsgLink();
        link.setTitle("您好");
        link.setDesc("明天会更好");
        link.setPicUrl("https://wwcdn.weixin.qq.com/node/wework/images/kf_head_image_url_4.png");
        link.setUrl("https://shuaidd.github.io/");
        groupMsg.setLink(link);
        request.setAttachments(Lists.newArrayList(groupMsg));

        MsgTemplateResponse response = customContactService.addMsgTemplate(request, appName);
        logger.info("{}", response);
    }

    @Test
    public void getGroupMsgList() throws ParseException {
        GroupMsgRequest request = new GroupMsgRequest();
        request.setStartTime(DateUtils.parseDate("2021-01-13", "yyyy-MM-dd"));
        request.setEndTime(DateUtils.parseDate("2021-01-14", "yyyy-MM-dd"));
        request.setChatType("single");
        GroupMsgResponse response = customContactService.getGroupMsgList(request, appName);
        V2GroupMsgResponse v2GroupMsgResponse = customContactService.getGroupMsgListV2(request, appName);
        logger.info("{}", response);
        logger.info("{}", v2GroupMsgResponse);
    }

    @Test
    public void getGroupMsgTask() {
        GroupMsgTaskRequest request = new GroupMsgTaskRequest();
        request.setMsgId("msgCRbQBwAAEozan6cBGz_NZ0WSfoAANQ");
        GroupMsgTaskResponse response = customContactService.getGroupMsgTask(request, appName);
        logger.info("{}", response);
        for (GroupMsgTask groupMsgTask : response.getGroupMsgTasks()) {
            logger.info("{}", DateFormatUtils.format(groupMsgTask.getSendTime(), "yyyy-MM-dd HH:mm:ss"));
        }
    }

    @Test
    public void getGroupMsgSendResult() {
        GroupMsgSendRequest request = new GroupMsgSendRequest();
        request.setMsgId("msgCRbQBwAAEozan6cBGz_NZ0WSfoAANQ");
        request.setUserId("20170410022717");
        GroupMsgSendResultResponse response = customContactService.getGroupMsgSendResult(request, appName);
        logger.info("{}", response);
    }

    @Test
    public void sendWelcomeMsg() {
        WelcomeMsgRequest request = new WelcomeMsgRequest();
        request.setText(new MsgText("hello world"));
        request.setWelcomeCode("CALLBACK_CODE");
        customContactService.sendWelcomeMsg(request, appName);
    }

    @Test
    public void addGroupWelcomeTemplate() {
        WelcomeTemplateRequest request = new WelcomeTemplateRequest();
        request.setText(new MsgText("亲爱的%NICKNAME%用户，你好"));
        AddWelcomeTemplateResponse response = customContactService.addGroupWelcomeTemplate(request, appName);
        logger.info("{}", response);
    }

    @Test
    public void editGroupWelcomeTemplate() {
        WelcomeTemplateRequest request = new WelcomeTemplateRequest();
        request.setText(new MsgText("亲爱的%NICKNAME%用户，你好呀"));
        request.setTemplateId("msgCRbQBwAAgPq5FoC5GjIJAJsvW_GPJA");
        customContactService.editGroupWelcomeTemplate(request, appName);
    }

    @Test
    public void getGroupWelcomeTemplate() {
        GetWelcomeTemplateRequest request = new GetWelcomeTemplateRequest();
        request.setTemplateId("msgCRbQBwAAgPq5FoC5GjIJAJsvW_GPJA");
        GetWelcomeTemplateResponse response = customContactService.getGroupWelcomeTemplate(request, appName);
        logger.info("{}", response);
    }

    @Test
    public void deleteGroupWelcomeTemplate() {
        DeleteWelcomeTemplateRequest request = new DeleteWelcomeTemplateRequest();
        request.setTemplateId("msgCRbQBwAAgPq5FoC5GjIJAJsvW_GPJA");
        customContactService.deleteGroupWelcomeTemplate(request, appName);
    }

    @Test
    public void getUserBehaviorData() throws ParseException {
        UserBehaviorRequest request = new UserBehaviorRequest();
        request.setUserIds(Lists.newArrayList("20170410022717"));
        request.setStartTime(DateUtils.parseDate("2022-08-31", "yyyy-MM-dd"));
        request.setEndTime(DateUtils.parseDate("2022-08-31", "yyyy-MM-dd"));
        BehaviorDataResponse response = customContactService.getUserBehaviorData(request, appName);
        logger.info("{}", response);
    }

    @Test
    public void getGroupChatStatistic() throws ParseException {
        GroupChatStatisticRequest request = new GroupChatStatisticRequest();
        request.setDayBeginTime(DateUtils.parseDate("2022-08-22", "yyyy-MM-dd"));
        request.setDayBeginTime(DateUtils.parseDate("2022-08-23", "yyyy-MM-dd"));

        OwnerFilter filter = new OwnerFilter();
        filter.setUserIdList(Lists.newArrayList("20170410022717"));
        request.setOwnerFilter(filter);

        GroupChatStatisticResponse response = customContactService.getGroupChatStatistic(request, appName);
        logger.info("{}", response);
    }

    @Test
    public void getGroupChatStatisticByDay() throws ParseException {
        GroupChatStatisticRequest request = new GroupChatStatisticRequest();
        request.setDayBeginTime(DateUtils.parseDate("2022-08-22", "yyyy-MM-dd"));
        request.setDayBeginTime(DateUtils.parseDate("2022-08-23", "yyyy-MM-dd"));

        OwnerFilter filter = new OwnerFilter();
        filter.setUserIdList(Lists.newArrayList("20170410022717"));
        request.setOwnerFilter(filter);
        GroupChatStatisticResponse response = customContactService.getGroupChatStatisticByDay(request, appName);
        logger.info("{}", response);
    }

    @Test
    public void addProductAlbum() throws Exception {
        File file = ResourceUtils.getFile("classpath:image/WechatIMG16.png");
        String mediaId = mediaService.uploadAttachment(file, "image", 2, appName);
        AddProductAlbumRequest request = new AddProductAlbumRequest();
        request.setDescription("小件瓷器");
        request.setPrice(1);

        AddProductAlbumRequest.AttachmentsDTO attachments = new AddProductAlbumRequest.AttachmentsDTO();
        attachments.setType("image");

        AddProductAlbumRequest.AttachmentsDTO.ImageDTO imageDTO = new AddProductAlbumRequest.AttachmentsDTO.ImageDTO();
        imageDTO.setMediaId(mediaId);
        attachments.setImage(imageDTO);
        request.setAttachments(Lists.newArrayList(attachments));
        AddProductAlbumResponse response = customContactService.addProductAlbum(request, appName);
    }

    @Test
    public void productAlbumList() {
        ProductAlbumListResponse response = customContactService.productAlbumList(new CursorPageRequest(), appName);
    }

    @Test
    public void getProductAlbum() {
        GetProductAlbumRequest request = new GetProductAlbumRequest();
        request.setProductId("PACRbQBwAAgPq5FoC5GjIJAJsvW_GPJA");
        GetProductAlbumResponse response = customContactService.getProductAlbum(request, appName);
        logger.info("Product--{}", response);
    }

    @Test
    public void updateProductAlbum() {
        UpdateProductAlbumRequest request = new UpdateProductAlbumRequest();
        request.setProductId("PACRbQBwAAgPq5FoC5GjIJAJsvW_GPJA");
        request.setProductSn("SW0100021");
        customContactService.updateProductAlbum(request, appName);
    }

    @Test
    public void deleteProductAlbum() {
        DelProductAlbumRequest request = new DelProductAlbumRequest();
        request.setProductId("PACRbQBwAAgPq5FoC5GjIJAJsvW_GPJA");
        customContactService.deleteProductAlbum(request, appName);
    }

    @Test
    public void addInterceptRule() {
        AddInterceptRuleRequest request = new AddInterceptRuleRequest();
        request.setInterceptType(2);
        request.setRuleName("禁止娱乐");
        request.setSemanticsList(Lists.newArrayList(1, 2, 3));
        request.setWordList(Lists.newArrayList("甄嬛传", "大考", "盗墓笔记"));

        AddInterceptRuleRequest.ApplicableRangeDTO applicableRange = new AddInterceptRuleRequest.ApplicableRangeDTO();
        applicableRange.setUserList(Lists.newArrayList("20170410022717"));
        request.setApplicableRange(applicableRange);

        AddInterceptRuleResponse response = customContactService.addInterceptRule(request, appName);
    }

    @Test
    public void updateInterceptRule() {
        UpdateInterceptRuleRequest request = new UpdateInterceptRuleRequest();
        request.setRuleId("irCRbQBwAAgPq5FoC5GjIJAJsvW_GPJA");
        request.setRuleName("禁止娱乐和看视频");
        customContactService.updateInterceptRule(request, appName);
    }

    @Test
    public void interceptRuleList() {
        customContactService.interceptRuleList(appName);
    }

    @Test
    public void getInterceptRuleDetail() {
        InterceptRuleIdRequest request = new InterceptRuleIdRequest();
        request.setRuleId("irCRbQBwAAgPq5FoC5GjIJAJsvW_GPJA");
        GetInterceptRuleResponse response = customContactService.getInterceptRuleDetail(request, appName);
    }

    @Test
    public void delInterceptRule() {
        InterceptRuleIdRequest request = new InterceptRuleIdRequest();
        request.setRuleId("irCRbQBwAAgPq5FoC5GjIJAJsvW_GPJA");
        customContactService.delInterceptRule(request, appName);
        interceptRuleList();
    }

}
