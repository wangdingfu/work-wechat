package io.github.wangdingfu.response.tool;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.dto.tool.LivingInfoData;
import io.github.wangdingfu.response.AbstractBaseResponse;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-01-12 13:31
 **/
public class LivingInfoResponse extends AbstractBaseResponse {

    @JsonProperty("living_info")
    private LivingInfoData livingInfo;

    public LivingInfoData getLivingInfo() {
        return livingInfo;
    }

    public void setLivingInfo(LivingInfoData livingInfo) {
        this.livingInfo = livingInfo;
    }
}
