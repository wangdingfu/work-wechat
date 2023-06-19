package io.github.wangdingfu.response.oa;

import io.github.wangdingfu.dto.checkin.DayReportItem;
import io.github.wangdingfu.response.AbstractBaseResponse;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * 描述 日报
 *
 * @author ddshuai
 * date 2021-07-15 11:22
 **/
public class CheckInDayReportResponse extends AbstractBaseResponse {
    private List<DayReportItem> datas;

    public List<DayReportItem> getDatas() {
        return datas;
    }

    public void setDatas(List<DayReportItem> datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("datas", datas)
                .toString();
    }
}
