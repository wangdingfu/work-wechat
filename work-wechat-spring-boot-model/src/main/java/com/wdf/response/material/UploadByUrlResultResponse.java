package com.wdf.response.material;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wdf.json.Long2DateDeserializer;
import com.wdf.response.AbstractBaseResponse;

import java.io.Serializable;
import java.util.Date;

public class UploadByUrlResultResponse extends AbstractBaseResponse {

    /**
     * status
     */
    @JsonProperty("status")
    private Integer status;
    /**
     * detail
     */
    @JsonProperty("detail")
    private DetailDTO detail;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public DetailDTO getDetail() {
        return detail;
    }

    public void setDetail(DetailDTO detail) {
        this.detail = detail;
    }

    public static class DetailDTO extends AbstractBaseResponse implements Serializable {

        /**
         * mediaId
         */
        @JsonProperty("media_id")
        private String mediaId;
        /**
         * createdAt
         */
        @JsonProperty("created_at")
        @JsonDeserialize(using = Long2DateDeserializer.class)
        private Date createdAt;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

        public Date getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
        }
    }
}
