package io.github.wangdingfu.response.externalcontact;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.response.AbstractBaseResponse;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-01-06 22:29
 **/
public class AddWelcomeTemplateResponse extends AbstractBaseResponse {

    @JsonProperty("template_id")
    private String templateId;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }
}
