package com.wdf.resquest.tool;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wdf.resquest.CursorPageRequest;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-01-12 13:22
 **/
public class GetUserLivingRequest extends CursorPageRequest {
    @JsonProperty("userid")
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
