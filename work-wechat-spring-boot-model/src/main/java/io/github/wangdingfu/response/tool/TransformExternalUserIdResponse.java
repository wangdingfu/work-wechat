package io.github.wangdingfu.response.tool;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.response.AbstractBaseResponse;

/**
 * @author ddshuai
 * date 2022-09-04 21:17
 **/
public class TransformExternalUserIdResponse extends AbstractBaseResponse {

    @JsonProperty("external_userid")
    private String externalUserId;

    public String getExternalUserId() {
        return externalUserId;
    }

    public void setExternalUserId(String externalUserId) {
        this.externalUserId = externalUserId;
    }
}
