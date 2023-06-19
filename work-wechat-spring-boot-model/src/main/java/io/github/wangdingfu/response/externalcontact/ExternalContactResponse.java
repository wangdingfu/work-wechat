package io.github.wangdingfu.response.externalcontact;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.dto.externalcontact.ExternalContactDetail;
import io.github.wangdingfu.dto.externalcontact.FollowUserDetail;
import io.github.wangdingfu.response.AbstractBaseResponse;

import java.util.List;

/**
 * 描述 客户详情
 *
 * @author ddshuai
 * date 2021-01-02 16:32
 **/
public class ExternalContactResponse extends AbstractBaseResponse {

    @JsonProperty("external_contact")
    private ExternalContactDetail externalContact;

    @JsonProperty("follow_user")
    private List<FollowUserDetail> followUsers;

    public ExternalContactDetail getExternalContact() {
        return externalContact;
    }

    public void setExternalContact(ExternalContactDetail externalContact) {
        this.externalContact = externalContact;
    }

    public List<FollowUserDetail> getFollowUsers() {
        return followUsers;
    }

    public void setFollowUsers(List<FollowUserDetail> followUsers) {
        this.followUsers = followUsers;
    }
}
