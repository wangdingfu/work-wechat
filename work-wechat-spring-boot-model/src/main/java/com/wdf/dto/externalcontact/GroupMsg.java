package com.wdf.dto.externalcontact;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wdf.dto.message.*;
import com.wdf.json.Long2DateDeserializer;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-01-06 21:59
 **/
public class GroupMsg {
    @JsonProperty("msgid")
    private String msgId;
    private String creator;
    @JsonProperty("create_time")
    @JsonDeserialize(using = Long2DateDeserializer.class)
    private Date createTime;
    @JsonProperty("create_type")
    private Integer createType;
    private MsgText text;
    private MsgImage image;
    private MsgLink link;
    private MiniProgram miniprogram;
    private MsgVideo video;

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

    public MsgImage getImage() {
        return image;
    }

    public void setImage(MsgImage image) {
        this.image = image;
    }

    public MsgLink getLink() {
        return link;
    }

    public void setLink(MsgLink link) {
        this.link = link;
    }

    public MiniProgram getMiniprogram() {
        return miniprogram;
    }

    public void setMiniprogram(MiniProgram miniprogram) {
        this.miniprogram = miniprogram;
    }

    public MsgVideo getVideo() {
        return video;
    }

    public void setVideo(MsgVideo video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("msgId", msgId)
                .append("creator", creator)
                .append("createTime", createTime)
                .append("createType", createType)
                .append("text", text)
                .append("image", image)
                .append("link", link)
                .append("miniprogram", miniprogram)
                .append("video", video)
                .toString();
    }
}
