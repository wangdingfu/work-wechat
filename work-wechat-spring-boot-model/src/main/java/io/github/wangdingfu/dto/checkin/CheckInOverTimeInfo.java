package io.github.wangdingfu.dto.checkin;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.StringJoiner;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-07-15 13:24
 **/
public class CheckInOverTimeInfo {

    @JsonProperty("ot_status")
    private Integer otStatus;

    @JsonProperty("ot_duration")
    private Integer otDuration;

    @JsonProperty("exception_duration")
    private List<Integer> exceptionDuration;

    public Integer getOtStatus() {
        return otStatus;
    }

    public void setOtStatus(Integer otStatus) {
        this.otStatus = otStatus;
    }

    public Integer getOtDuration() {
        return otDuration;
    }

    public void setOtDuration(Integer otDuration) {
        this.otDuration = otDuration;
    }

    public List<Integer> getExceptionDuration() {
        return exceptionDuration;
    }

    public void setExceptionDuration(List<Integer> exceptionDuration) {
        this.exceptionDuration = exceptionDuration;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CheckInOverTimeInfo.class.getSimpleName() + "[", "]")
                .add("otStatus=" + otStatus)
                .add("otDuration=" + otDuration)
                .add("exceptionDuration=" + exceptionDuration)
                .toString();
    }
}
