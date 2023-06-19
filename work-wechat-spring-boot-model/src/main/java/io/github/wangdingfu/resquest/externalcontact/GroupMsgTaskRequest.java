package io.github.wangdingfu.resquest.externalcontact;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.resquest.CursorPageRequest;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-01-06 22:07
 **/
public class GroupMsgTaskRequest extends CursorPageRequest {

    @JsonProperty("msgid")
    private String msgId;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

}
