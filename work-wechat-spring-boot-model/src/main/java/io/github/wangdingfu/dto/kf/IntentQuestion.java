package io.github.wangdingfu.dto.kf;

import io.github.wangdingfu.dto.message.MsgText;

import java.util.StringJoiner;

/**
 * @author ddshuai
 * date 2022-09-01 16:58
 **/
public class IntentQuestion {

    private MsgText text;

    public MsgText getText() {
        return text;
    }

    public void setText(MsgText text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", IntentQuestion.class.getSimpleName() + "[", "]")
                .add("text=" + text)
                .toString();
    }
}
