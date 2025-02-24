package io.github.wangdingfu.response.externalcontact;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.dto.externalcontact.MomentDetail;
import io.github.wangdingfu.response.AbstractBaseResponse;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-01-05 21:35
 **/
public class MomentListResponse extends AbstractBaseResponse {

    @JsonProperty("moment_list")
    private List<MomentDetail> momentDetails;

    public List<MomentDetail> getMomentDetails() {
        return momentDetails;
    }

    public void setMomentDetails(List<MomentDetail> momentDetails) {
        this.momentDetails = momentDetails;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("momentDetails", momentDetails)
                .toString();
    }
}
