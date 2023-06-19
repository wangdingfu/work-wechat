package io.github.wangdingfu.response.oa;

import io.github.wangdingfu.dto.oa.JournalReportDetail;
import io.github.wangdingfu.response.AbstractBaseResponse;

import java.util.StringJoiner;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-07-20 09:47
 **/
public class JournalReportDetailResponse extends AbstractBaseResponse {

    private JournalReportDetail info;

    public JournalReportDetail getInfo() {
        return info;
    }

    public void setInfo(JournalReportDetail info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JournalReportDetailResponse.class.getSimpleName() + "[", "]")
                .add("info=" + info)
                .toString();
    }
}
