package io.github.wangdingfu.dto.externalcontact;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.dto.message.MiniProgram;
import io.github.wangdingfu.dto.message.MsgImage;
import io.github.wangdingfu.dto.message.MsgLink;
import io.github.wangdingfu.dto.message.MsgText;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-01-02 15:14
 **/
public class ConclusionData {
    private MsgText text;
    private MsgImage image;
    private MsgLink link;
    @JsonProperty("miniprogram")
    private MiniProgram miniProgram;

    public MsgText getText() {
        return text;
    }

    public void setText(MsgText text) {
        this.text = text;
    }

    public MsgImage getImage() {
        return image;
    }

    public void setImage(MsgImage image) {
        this.image = image;
    }

    public MsgLink getLink() {
        return link;
    }

    public void setLink(MsgLink link) {
        this.link = link;
    }

    public MiniProgram getMiniProgram() {
        return miniProgram;
    }

    public void setMiniProgram(MiniProgram miniProgram) {
        this.miniProgram = miniProgram;
    }
}
