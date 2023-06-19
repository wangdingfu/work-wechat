package com.wdf.response.externalcontact;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wdf.dto.externalcontact.FailedChatData;
import com.wdf.response.AbstractBaseResponse;

import java.util.List;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-01-04 22:37
 **/
public class FailedChatResponse extends AbstractBaseResponse {

    @JsonProperty("failed_chat_list")
    private List<FailedChatData> failedChatList;

    public List<FailedChatData> getFailedChatList() {
        return failedChatList;
    }

    public void setFailedChatList(List<FailedChatData> failedChatList) {
        this.failedChatList = failedChatList;
    }
}
