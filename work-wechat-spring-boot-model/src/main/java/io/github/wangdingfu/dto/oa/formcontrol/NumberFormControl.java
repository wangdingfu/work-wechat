package io.github.wangdingfu.dto.oa.formcontrol;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * 描述 数字控件
 *
 * @author ddshuai
 * date 2021-07-16 14:25
 **/
public class NumberFormControl implements ApplyFormControl {

    @JsonProperty("new_number")
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public NumberFormControl(Object value) {
        this.number = Objects.isNull(value) ? StringUtils.EMPTY : value.toString();
    }

    public NumberFormControl(String number) {
        this.number = number;
    }

    public NumberFormControl() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", NumberFormControl.class.getSimpleName() + "[", "]")
                .add("number='" + number + "'")
                .toString();
    }

    @Override
    public String formControlName() {
        return "Number";
    }
}
