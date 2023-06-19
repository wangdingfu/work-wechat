package com.wdf.response.externalcontact;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wdf.dto.externalcontact.GroupMsgSendResult;
import com.wdf.response.AbstractBaseResponse;

import java.util.List;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-01-06 22:19
 **/
public class GroupMsgSendResultResponse extends AbstractBaseResponse {

    @JsonProperty("send_list")
    private List<GroupMsgSendResult> sendList;

    public List<GroupMsgSendResult> getSendList() {
        return sendList;
    }

    public void setSendList(List<GroupMsgSendResult> sendList) {
        this.sendList = sendList;
    }
}
