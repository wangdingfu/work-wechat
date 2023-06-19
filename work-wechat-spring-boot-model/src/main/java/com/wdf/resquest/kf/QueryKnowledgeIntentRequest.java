package com.wdf.resquest.kf;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wdf.resquest.CursorPageRequest;

/**
 * @author ddshuai
 * date 2022-09-01 17:29
 **/
public class QueryKnowledgeIntentRequest extends CursorPageRequest {

    @JsonProperty(value = "group_id")
    private String groupId;

    @JsonProperty(value = "intent_id")
    private String intentId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getIntentId() {
        return intentId;
    }

    public void setIntentId(String intentId) {
        this.intentId = intentId;
    }
}
