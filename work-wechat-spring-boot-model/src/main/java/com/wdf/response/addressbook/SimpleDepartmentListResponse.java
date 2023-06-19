package com.wdf.response.addressbook;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wdf.dto.addressbook.Department;
import com.wdf.response.AbstractBaseResponse;

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
