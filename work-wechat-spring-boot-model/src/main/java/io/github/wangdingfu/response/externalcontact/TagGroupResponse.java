package io.github.wangdingfu.response.externalcontact;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.dto.addressbook.TagGroup;
import io.github.wangdingfu.response.AbstractBaseResponse;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-01-04 21:12
 **/
public class TagGroupResponse extends AbstractBaseResponse {
    @JsonProperty("tag_group")
    private List<TagGroup> tagGroups;

    public List<TagGroup> getTagGroups() {
        return tagGroups;
    }

    public void setTagGroups(List<TagGroup> tagGroups) {
        this.tagGroups = tagGroups;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("tagGroups", tagGroups)
                .toString();
    }
}
