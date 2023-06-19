package com.wdf.response.addressbook;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wdf.dto.addressbook.Department;
import com.wdf.response.AbstractBaseResponse;

import java.util.List;

/**
 * 描述 部门详细信息[含部门名称]
 *
 * @author ddshuai
 * date 2019-04-06 07:18
 **/
public class DepartmentListResponse extends AbstractBaseResponse {

    @JsonProperty("department")
    private List<Department> departments;

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

}
