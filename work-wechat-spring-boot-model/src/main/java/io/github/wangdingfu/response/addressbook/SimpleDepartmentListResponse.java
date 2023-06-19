package io.github.wangdingfu.response.addressbook;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.dto.addressbook.Department;
import io.github.wangdingfu.response.AbstractBaseResponse;

import java.util.List;

/**
 * 部门简要信息[无部门名称]
 *
 * @author ddshuai
 * date 2019-04-06 07:18
 **/
public class SimpleDepartmentListResponse extends AbstractBaseResponse {

    @JsonProperty("department_id")
    private List<Department> departments;

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

}
