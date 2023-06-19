package io.github.wangdingfu.resquest.addressbook;


import io.github.wangdingfu.dto.addressbook.Department;

import java.util.StringJoiner;

/**
 * 描述
 *
 * @author ddshuai
 * date 2019-04-06 06:55
 **/
public class DepartmentRequest extends Department {
    @Override
    public String toString() {
        return new StringJoiner(", ", DepartmentRequest.class.getSimpleName() + "[", "]")
                .add(super.toString())
                .toString();
    }
}
