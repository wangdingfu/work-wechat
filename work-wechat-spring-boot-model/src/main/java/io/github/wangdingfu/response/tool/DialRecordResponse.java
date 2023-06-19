package io.github.wangdingfu.response.tool;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.dto.tool.DialRecord;
import io.github.wangdingfu.response.AbstractBaseResponse;

import java.util.List;

/**
 * 描述
 *
 * @author ddshuai
 * date 2019-04-11 13:40
 **/
public class DialRecordResponse extends AbstractBaseResponse {
    @JsonProperty("record")
    private List<DialRecord> records;

    public List<DialRecord> getRecords() {
        return records;
    }

    public void setRecords(List<DialRecord> records) {
        this.records = records;
    }
}
