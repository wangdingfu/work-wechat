package com.wdf.dto.message;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.StringJoiner;

/**
 * 描述
 *
 * @author ddshuai
 * date 2019-04-08 17:58
 **/
public class MsgMiniprogramNotice {

    @JsonProperty("appid")
    private String appId;
    private String page;
    private String title;
    private String description;
    @JsonProperty("emphasis_first_item")
    private Boolean emphasisFirstItem;
    @JsonProperty("content_item")
    private List<ContentItem> contentItems;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getEmphasisFirstItem() {
        return emphasisFirstItem;
    }

    public void setEmphasisFirstItem(Boolean emphasisFirstItem) {
        this.emphasisFirstItem = emphasisFirstItem;
    }

    public List<ContentItem> getContentItems() {
        return contentItems;
    }

    public void setContentItems(List<ContentItem> contentItems) {
        this.contentItems = contentItems;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MsgMiniprogramNotice.class.getSimpleName() + "[", "]")
                .add("appId='" + appId + "'")
                .add("page='" + page + "'")
                .add("title='" + title + "'")
                .add("description='" + description + "'")
                .add("emphasisFirstItem=" + emphasisFirstItem)
                .add("contentItems=" + contentItems)
                .toString();
    }
}
