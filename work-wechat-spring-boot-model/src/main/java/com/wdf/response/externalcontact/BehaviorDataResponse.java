package com.wdf.response.externalcontact;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wdf.dto.externalcontact.BehaviorData;
import com.wdf.response.AbstractBaseResponse;

import java.util.List;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-01-06 22:47
 **/
public class BehaviorDataResponse extends AbstractBaseResponse {

    @JsonProperty("behavior_data")
    private List<BehaviorData> behaviorData;

    public List<BehaviorData> getBehaviorData() {
        return behaviorData;
    }

    public void setBehaviorData(List<BehaviorData> behaviorData) {
        this.behaviorData = behaviorData;
    }
}
