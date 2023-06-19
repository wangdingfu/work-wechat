package io.github.wangdingfu.response.tool;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.response.AbstractBaseResponse;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-01-11 22:29
 **/
public class LivingCodeResponse extends AbstractBaseResponse {
    @JsonProperty("living_code")
    private String livingCode;

    public String getLivingCode() {
        return livingCode;
    }

    public void setLivingCode(String livingCode) {
        this.livingCode = livingCode;
    }
}
