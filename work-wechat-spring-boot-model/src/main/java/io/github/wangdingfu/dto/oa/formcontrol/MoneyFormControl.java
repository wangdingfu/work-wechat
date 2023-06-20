package io.github.wangdingfu.dto.oa.formcontrol;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * 描述 金额控件
 *
 * @author ddshuai
 * date 2021-07-16 14:25
 **/
public class MoneyFormControl implements ApplyFormControl {

    @JsonProperty("new_money")
    private String money;

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public MoneyFormControl(String money) {
        this.money = money;
    }

    public MoneyFormControl(Object money) {
        this.money = Objects.isNull(money) ? "" : money.toString();
    }

    public MoneyFormControl() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MoneyFormControl.class.getSimpleName() + "[", "]")
                .add("money='" + money + "'")
                .toString();
    }

    @Override
    public String formControlName() {
        return "Money";
    }
}
