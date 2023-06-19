package io.github.wangdingfu.response.externalcontact;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.dto.externalcontact.GroupChatDetail;
import io.github.wangdingfu.response.AbstractBaseResponse;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-01-05 21:06
 **/
public class GroupChatDetailResponse extends AbstractBaseResponse {

    @JsonProperty("group_chat")
    private GroupChatDetail detail;

    public GroupChatDetail getDetail() {
        return detail;
    }

    public void setDetail(GroupChatDetail detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("detail", detail)
                .toString();
    }
}
