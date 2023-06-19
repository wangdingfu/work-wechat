package io.github.wangdingfu.response.linkedcorp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.dto.linkedcorp.SimpleUser;
import io.github.wangdingfu.response.AbstractBaseResponse;

import java.util.List;

/**
 * @author ddshuai
 * date 2022-09-04 21:37
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class LinkedCorpDeptUserResponse  extends AbstractBaseResponse {

    @JsonProperty("userlist")
    private List<SimpleUser> userList;

    public List<SimpleUser> getUserList() {
        return userList;
    }

    public void setUserList(List<SimpleUser> userList) {
        this.userList = userList;
    }
}
