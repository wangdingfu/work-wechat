package io.github.wangdingfu.resquest.tool;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-01-11 14:38
 **/
public class GetMeetingDetailRequest {
    @JsonProperty("meetingid")
    private String meetingId;

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }
}
