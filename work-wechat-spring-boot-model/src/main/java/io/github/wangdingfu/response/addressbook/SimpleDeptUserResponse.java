package io.github.wangdingfu.response.addressbook;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.dto.addressbook.DeptUser;
import io.github.wangdingfu.response.AbstractBaseResponse;

import java.util.List;
import java.util.StringJoiner;

/**
 * @author ddshuai
 * date 2022-08-31 10:26
 **/
public class SimpleDeptUserResponse extends AbstractBaseResponse {

    @JsonProperty(value = "dept_user")
    private List<DeptUser> deptUsers;

    public List<DeptUser> getDeptUsers() {
        return deptUsers;
    }

    public void setDeptUsers(List<DeptUser> deptUsers) {
        this.deptUsers = deptUsers;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SimpleDeptUserResponse.class.getSimpleName() + "[", "]")
                .add("deptUsers=" + deptUsers)
                .toString();
    }
}
