package io.github.wangdingfu.response.kf;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.response.AbstractBaseResponse;

/**
 * @author ddshuai
 * date 2022-09-01 17:15
 **/
public class AddIntentResponse extends AbstractBaseResponse {

    @JsonProperty(value = "intent_id")
    private String intentId;

    public String getIntentId() {
        return intentId;
    }

    public void setIntentId(String intentId) {
        this.intentId = intentId;
    }
}
