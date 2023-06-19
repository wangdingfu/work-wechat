package io.github.wangdingfu.resquest.oa;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.dto.tool.CalendarData;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-01-07 21:35
 **/
public class CalendarRequest {
    private CalendarData calendar;
    @JsonProperty("agentid")
    private String agentId;

    public CalendarData getCalendar() {
        return calendar;
    }

    public void setCalendar(CalendarData calendar) {
        this.calendar = calendar;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }
}
