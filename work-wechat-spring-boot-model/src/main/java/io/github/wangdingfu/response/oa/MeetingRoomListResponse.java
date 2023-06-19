package io.github.wangdingfu.response.oa;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.dto.oa.MeetingRoomDetail;
import io.github.wangdingfu.response.AbstractBaseResponse;

import java.util.List;
import java.util.StringJoiner;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-07-20 13:07
 **/
public class MeetingRoomListResponse extends AbstractBaseResponse {

    @JsonProperty("meetingroom_list")
    private List<MeetingRoomDetail> meetingRoomList;

    public List<MeetingRoomDetail> getMeetingRoomList() {
        return meetingRoomList;
    }

    public void setMeetingRoomList(List<MeetingRoomDetail> meetingRoomList) {
        this.meetingRoomList = meetingRoomList;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MeetingRoomListResponse.class.getSimpleName() + "[", "]")
                .add("meetingRoomList=" + meetingRoomList)
                .toString();
    }
}
