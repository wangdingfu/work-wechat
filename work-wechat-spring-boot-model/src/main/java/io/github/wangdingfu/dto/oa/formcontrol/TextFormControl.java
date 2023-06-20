package io.github.wangdingfu.dto.oa.formcontrol;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * 描述 文本/多行文本控件
 *
 * @author ddshuai
 * date 2021-07-16 14:25
 **/
public class TextFormControl implements ApplyFormControl {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TextFormControl(String text) {
        this.text = text;
    }

    public TextFormControl(Object value) {
        this.text = Objects.isNull(value) ? StringUtils.EMPTY : value.toString();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TextFormControl.class.getSimpleName() + "[", "]")
                .add("text='" + text + "'")
                .toString();
    }

    @Override
    public String formControlName() {
        return "Text";
    }
}
