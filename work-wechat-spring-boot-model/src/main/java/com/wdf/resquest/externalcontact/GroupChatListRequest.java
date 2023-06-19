package com.wdf.resquest.externalcontact;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wdf.dto.externalcontact.OwnerFilter;
import com.wdf.resquest.CursorPageRequest;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-01-05 20:52
 **/
public class GroupChatListRequest extends CursorPageRequest {

    @JsonProperty("status_filter")
    private Integer statusFilter;

    @JsonProperty("owner_filter")
    private OwnerFilter ownerFilter;

    public Integer getStatusFilter() {
        return statusFilter;
    }

    public void setStatusFilter(Integer statusFilter) {
        this.statusFilter = statusFilter;
    }

    public OwnerFilter getOwnerFilter() {
        return ownerFilter;
    }

    public void setOwnerFilter(OwnerFilter ownerFilter) {
        this.ownerFilter = ownerFilter;
    }
}
