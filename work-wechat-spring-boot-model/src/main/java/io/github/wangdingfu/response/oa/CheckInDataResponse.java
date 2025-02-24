package io.github.wangdingfu.response.oa;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.dto.checkin.CheckInData;
import io.github.wangdingfu.response.AbstractBaseResponse;

import java.util.List;
import java.util.StringJoiner;

/**
 * 描述
 *
 * @author ddshuai
 * date 2019-04-11 10:22
 **/
public class CheckInDataResponse extends AbstractBaseResponse {

    @JsonProperty("checkindata")
    private List<CheckInData> checkInDataList;

    public List<CheckInData> getCheckInDataList() {
        return checkInDataList;
    }

    public void setCheckInDataList(List<CheckInData> checkInDataList) {
        this.checkInDataList = checkInDataList;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CheckInDataResponse.class.getSimpleName() + "[", "]")
                .add("checkInDataList=" + checkInDataList)
                .toString();
    }
}
