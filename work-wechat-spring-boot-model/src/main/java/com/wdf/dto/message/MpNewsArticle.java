package com.wdf.dto.message;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.StringJoiner;

/**
 * 描述
 *
 * @author ddshuai
 * date 2019-04-08 17:54
 **/
public class MpNewsArticle {

    private String title;
    @JsonProperty("thumb_media_id")
    private String thumbMediaId;
    private String author;
    @JsonProperty("content_source_url")
    private String contentSourceUrl;
    private String content;
    private String digest;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContentSourceUrl() {
        return contentSourceUrl;
    }

    public void setContentSourceUrl(String contentSourceUrl) {
        this.contentSourceUrl = contentSourceUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MpNewsArticle.class.getSimpleName() + "[", "]")
                .add("title='" + title + "'")
                .add("thumbMediaId='" + thumbMediaId + "'")
                .add("author='" + author + "'")
                .add("contentSourceUrl='" + contentSourceUrl + "'")
                .add("content='" + content + "'")
                .add("digest='" + digest + "'")
                .toString();
    }
}
