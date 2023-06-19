package io.github.wangdingfu.dto.addressbook;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.dto.externalcontact.ExternalMiniProgramAttr;
import io.github.wangdingfu.dto.externalcontact.ExternalTextAttr;
import io.github.wangdingfu.dto.externalcontact.ExternalWebAttr;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 描述
 *
 * @author ddshuai
 * date 2019-04-04 15:31
 **/
public class ExtAttr {

    private Integer type;
    private String name;
    private ExternalTextAttr text;
    private ExternalWebAttr web;

    @JsonProperty("miniprogram")
    private ExternalMiniProgramAttr miniProgram;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExternalTextAttr getText() {
        return text;
    }

    public void setText(ExternalTextAttr text) {
        this.text = text;
    }

    public ExternalWebAttr getWeb() {
        return web;
    }

    public void setWeb(ExternalWebAttr web) {
        this.web = web;
    }

    public ExternalMiniProgramAttr getMiniProgram() {
        return miniProgram;
    }

    public void setMiniProgram(ExternalMiniProgramAttr miniProgram) {
        this.miniProgram = miniProgram;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("type", type)
                .append("name", name)
                .append("text", text)
                .append("web", web)
                .append("miniProgram", miniProgram)
                .toString();
    }
}
