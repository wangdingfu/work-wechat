package com.wdf.dto.message;

import java.util.StringJoiner;

/**
 * 描述
 *
 * @author ddshuai
 * date 2019-04-08 17:22
 **/
public class MsgTextCard {

    private String title;

    private String description;

    private String btntxt;

    private String url;

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

    public String getBtntxt() {
        return btntxt;
    }

    public void setBtntxt(String btntxt) {
        this.btntxt = btntxt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MsgTextCard.class.getSimpleName() + "[", "]")
                .add("title='" + title + "'")
                .add("description='" + description + "'")
                .add("btntxt='" + btntxt + "'")
                .add("url='" + url + "'")
                .toString();
    }
}
