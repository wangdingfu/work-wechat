package io.github.wangdingfu.response.oa;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.dto.checkin.CheckInSchedule;
import io.github.wangdingfu.response.AbstractBaseResponse;

import java.util.List;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-07-15 14:33
 **/
public class CheckInScheduleResponse extends AbstractBaseResponse {

    @JsonProperty("schedule_list")
    private List<CheckInSchedule> checkInSchedules;

    public List<CheckInSchedule> getCheckInSchedules() {
        return checkInSchedules;
    }

    public void setCheckInSchedules(List<CheckInSchedule> checkInSchedules) {
        this.checkInSchedules = checkInSchedules;
    }
}
