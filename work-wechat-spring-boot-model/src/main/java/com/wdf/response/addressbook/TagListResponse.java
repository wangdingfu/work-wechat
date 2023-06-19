package com.wdf.response.addressbook;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wdf.dto.addressbook.Tag;
import com.wdf.response.AbstractBaseResponse;

import java.util.List;

/**
 * 描述
 *
 * @author ddshuai
 * date 2019-04-06 08:17
 **/
public class TagListResponse extends AbstractBaseResponse {

    @JsonProperty("taglist")
    private List<Tag> tagList;

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }
}
