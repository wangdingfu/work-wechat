package com.wdf.response.externalcontact;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wdf.response.AbstractBaseResponse;

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
