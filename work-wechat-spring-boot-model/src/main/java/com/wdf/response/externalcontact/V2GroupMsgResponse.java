package com.wdf.response.externalcontact;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wdf.dto.externalcontact.V2GroupMsg;
import com.wdf.dto.message.MsgText;
import com.wdf.json.Long2DateDeserializer;
import com.wdf.response.AbstractBaseResponse;

import java.util.Date;
import java.util.List;

/**
 * @author ddshuai
 * date 2022-08-31 15:16
 **/
public class V2GroupMsgResponse extends AbstractBaseResponse {

    @JsonProperty("msgid")
    private String msgId;

    private String creator;

    @JsonProperty("create_time")
    @JsonDeserialize(using = Long2DateDeserializer.class)
    private Date createTime;

    @JsonProperty("create_type")
    private Integer createType;

    private MsgText text;

    private List<V2GroupMsg> attachments;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateType() {
        return createType;
    }

    public void setCreateType(Integer createType) {
        this.createType = createType;
    }

    public MsgText getText() {
        return text;
    }

    public void setText(MsgText text) {
        this.text = text;
    }

    public List<V2GroupMsg> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<V2GroupMsg> attachments) {
        this.attachments = attachments;
    }
}
