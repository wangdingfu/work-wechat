package io.github.wangdingfu.response.externalcontact;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.dto.addressbook.TagGroup;
import io.github.wangdingfu.response.AbstractBaseResponse;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-01-04 21:23
 **/
public class AddCorpTagResponse extends AbstractBaseResponse {
    @JsonProperty("tag_group")
    private TagGroup tagGroup;

    public TagGroup getTagGroup() {
        return tagGroup;
    }

    public void setTagGroup(TagGroup tagGroup) {
        this.tagGroup = tagGroup;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("tagGroup", tagGroup)
                .toString();
    }
}
