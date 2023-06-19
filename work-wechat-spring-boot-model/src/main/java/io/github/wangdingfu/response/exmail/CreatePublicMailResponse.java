package io.github.wangdingfu.response.exmail;

import io.github.wangdingfu.response.AbstractBaseResponse;

public class CreatePublicMailResponse extends AbstractBaseResponse {
   private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
