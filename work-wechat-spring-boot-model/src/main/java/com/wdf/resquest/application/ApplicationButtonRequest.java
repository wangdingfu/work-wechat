package com.wdf.resquest.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wdf.dto.tool.ApplicationButton;


import java.util.List;

/**
 * 描述
 *
 * @author ddshuai
 * date 2019-04-08 16:17
 **/
public class ApplicationButtonRequest {

    @JsonProperty("button")
    private List<ApplicationButton> buttonList;

    public List<ApplicationButton> getButtonList() {
        return buttonList;
    }

    public void setButtonList(List<ApplicationButton> buttonList) {
        this.buttonList = buttonList;
    }
}
