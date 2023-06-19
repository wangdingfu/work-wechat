package com.wdf.response.externalcontact;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wdf.dto.externalcontact.ContactWayDetail;
import com.wdf.response.AbstractBaseResponse;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author shuaidongdong
 */
public class ContactWayResponse extends AbstractBaseResponse {
    @JsonProperty("contact_way")
    private ContactWayDetail contactWayDetail;

    public ContactWayDetail getContactWayDetail() {
        return contactWayDetail;
    }

    public void setContactWayDetail(ContactWayDetail contactWayDetail) {
        this.contactWayDetail = contactWayDetail;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("contactWayDetail", contactWayDetail)
                .toString();
    }
}
