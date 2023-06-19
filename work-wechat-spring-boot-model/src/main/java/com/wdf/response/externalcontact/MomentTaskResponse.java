package com.wdf.response.externalcontact;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wdf.dto.externalcontact.MomentTask;
import com.wdf.response.AbstractBaseResponse;

import java.util.List;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-01-05 21:43
 **/
public class MomentTaskResponse extends AbstractBaseResponse {

    @JsonProperty("task_list")
    private List<MomentTask> momentTasks;

    public List<MomentTask> getMomentTasks() {
        return momentTasks;
    }

    public void setMomentTasks(List<MomentTask> momentTasks) {
        this.momentTasks = momentTasks;
    }
}
