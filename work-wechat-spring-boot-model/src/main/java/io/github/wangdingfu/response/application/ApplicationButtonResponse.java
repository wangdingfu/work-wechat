package io.github.wangdingfu.response.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.dto.tool.ApplicationButton;
import io.github.wangdingfu.response.AbstractBaseResponse;

import java.util.List;
import java.util.StringJoiner;

/**
 * 描述
 *
 * @author ddshuai
 * date 2019-04-08 16:27
 **/
public class ApplicationButtonResponse extends AbstractBaseResponse {

    @JsonProperty("button")
    private List<ApplicationButton> buttonList;

    public List<ApplicationButton> getButtonList() {
        return buttonList;
    }

    public void setButtonList(List<ApplicationButton> buttonList) {
        this.buttonList = buttonList;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ApplicationButtonResponse.class.getSimpleName() + "[", "]")
                .add("buttonList=" + buttonList)
                .toString();
    }
}
