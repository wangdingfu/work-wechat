package io.github.wangdingfu.dto.externalcontact;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.wangdingfu.json.Long2DateDeserializer;

import java.util.Date;

/**
 * 描述
 * "userid": "zhangsan",
 * "status": 1,
 * "send_time": 1552536375
 *
 * @author ddshuai
 * date 2021-01-06 22:10
 **/
public class GroupMsgTask {

    @JsonProperty("userid")
    private String userId;

    private Integer status;

    @JsonProperty("send_time")
    @JsonDeserialize(using = Long2DateDeserializer.class)
    private Date sendTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
