package io.github.wangdingfu.response.oa;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.dto.oa.JournalReportStat;
import io.github.wangdingfu.response.AbstractBaseResponse;

import java.util.List;
import java.util.StringJoiner;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-07-20 10:23
 **/
public class JournalReportStatResponse extends AbstractBaseResponse {

    @JsonProperty("stat_list")
    private List<JournalReportStat> statList;

    public List<JournalReportStat> getStatList() {
        return statList;
    }

    public void setStatList(List<JournalReportStat> statList) {
        this.statList = statList;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JournalReportStatResponse.class.getSimpleName() + "[", "]")
                .add("statList=" + statList)
                .toString();
    }
}
