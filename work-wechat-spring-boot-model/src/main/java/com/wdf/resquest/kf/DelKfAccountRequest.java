package com.wdf.resquest.kf;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wdf.response.kf.AddKfAccountResponse;

import java.util.StringJoiner;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-11-24 17:09
 **/
public class DelKfAccountRequest {

    @JsonProperty("open_kfid")
    private String openKfId;

    public String getOpenKfId() {
        return openKfId;
    }

    public void setOpenKfId(String openKfId) {
        this.openKfId = openKfId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AddKfAccountResponse.class.getSimpleName() + "[", "]")
                .add("openKfId='" + openKfId + "'")
                .toString();
    }
}
