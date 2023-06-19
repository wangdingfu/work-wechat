package io.github.wangdingfu.response.tool;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.response.AbstractBaseResponse;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-01-11 22:16
 **/
public class CreateLivingResponse extends AbstractBaseResponse {

    @JsonProperty("livingid")
    private String livingId;

    public String getLivingId() {
        return livingId;
    }

    public void setLivingId(String livingId) {
        this.livingId = livingId;
    }
}
