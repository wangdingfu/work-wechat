package com.wdf.resquest.wedrive;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ddshuai
 * date 2022-09-01 22:52
 **/
public class SpaceInfoRequest {

    @JsonProperty(value = "userid")
    private String userId;

    @JsonProperty(value = "spaceid")
    private String spaceId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }
}
