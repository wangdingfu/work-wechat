package io.github.wangdingfu.response.oa;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.dto.checkin.CheckInRule;
import io.github.wangdingfu.response.AbstractBaseResponse;

import java.util.List;
import java.util.StringJoiner;

/**
 * 描述
 *
 * @author ddshuai
 * date 2019-04-11 12:46
 **/
public class CheckInRuleResponse extends AbstractBaseResponse {

    @JsonProperty("info")
    private List<CheckInRule> checkInRules;

    public List<CheckInRule> getCheckInRules() {
        return checkInRules;
    }

    public void setCheckInRules(List<CheckInRule> checkInRules) {
        this.checkInRules = checkInRules;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CheckInRuleResponse.class.getSimpleName() + "[", "]")
                .add("checkInRules=" + checkInRules)
                .toString();
    }
}
