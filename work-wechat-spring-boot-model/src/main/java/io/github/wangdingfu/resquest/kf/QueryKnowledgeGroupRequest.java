package io.github.wangdingfu.resquest.kf;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.resquest.CursorPageRequest;

/**
 * @author ddshuai
 * date 2022-09-01 16:05
 **/
public class QueryKnowledgeGroupRequest extends CursorPageRequest {

    @JsonProperty(value = "group_id")
    private String groupId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
