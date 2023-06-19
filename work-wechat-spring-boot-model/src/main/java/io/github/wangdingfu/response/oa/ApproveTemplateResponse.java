package io.github.wangdingfu.response.oa;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.dto.template.TemplateContent;
import io.github.wangdingfu.dto.template.TemplateText;
import io.github.wangdingfu.dto.template.TemplateVacation;
import io.github.wangdingfu.response.AbstractBaseResponse;

import java.util.List;
import java.util.StringJoiner;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-07-15 15:37
 **/
public class ApproveTemplateResponse extends AbstractBaseResponse {

    @JsonProperty("template_names")
    private List<TemplateText> templateNames;

    @JsonProperty("template_content")
    private TemplateContent content;

    @JsonProperty("vacation_list")
    private TemplateVacation vacation;

    public List<TemplateText> getTemplateNames() {
        return templateNames;
    }

    public void setTemplateNames(List<TemplateText> templateNames) {
        this.templateNames = templateNames;
    }

    public TemplateContent getContent() {
        return content;
    }

    public void setContent(TemplateContent content) {
        this.content = content;
    }

    public TemplateVacation getVacation() {
        return vacation;
    }

    public void setVacation(TemplateVacation vacation) {
        this.vacation = vacation;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ApproveTemplateResponse.class.getSimpleName() + "[", "]")
                .add("templateNames=" + templateNames)
                .add("content=" + content)
                .toString();
    }
}
