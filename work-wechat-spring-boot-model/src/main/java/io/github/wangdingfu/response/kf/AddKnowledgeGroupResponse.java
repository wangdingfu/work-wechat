package io.github.wangdingfu.response.kf;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.response.BaseResponse;

/**
 * @author ddshuai
 * date 2022-09-01 10:15
 **/
public class AddKnowledgeGroupResponse extends BaseResponse {

    @JsonProperty(value = "group_id")
    private String groupId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
