package io.github.wangdingfu.response.externalcontact;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.response.AbstractBaseResponse;

public class AddInterceptRuleResponse extends AbstractBaseResponse {

    /**
     * ruleId
     */
    @JsonProperty("rule_id")
    private String ruleId;

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }
}
