package io.github.wangdingfu.dto.checkin;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.StringJoiner;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-07-15 13:28
 **/
public class SpItem {

    private Integer count;

    private Integer duration;

    @JsonProperty("time_type")
    private Integer timeType;

    private Integer type;

    @JsonProperty("vacation_id")
    private Integer vacationId;

    private String name;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getTimeType() {
        return timeType;
    }

    public void setTimeType(Integer timeType) {
        this.timeType = timeType;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getVacationId() {
        return vacationId;
    }

    public void setVacationId(Integer vacationId) {
        this.vacationId = vacationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SpItem.class.getSimpleName() + "[", "]")
                .add("count=" + count)
                .add("duration=" + duration)
                .add("timeType=" + timeType)
                .add("type=" + type)
                .add("vacationId=" + vacationId)
                .add("name='" + name + "'")
                .toString();
    }
}
