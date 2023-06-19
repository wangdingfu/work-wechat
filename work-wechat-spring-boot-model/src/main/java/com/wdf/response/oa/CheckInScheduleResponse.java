package com.wdf.response.oa;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wdf.dto.checkin.CheckInSchedule;
import com.wdf.response.AbstractBaseResponse;

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
