package io.github.wangdingfu.response.corp;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.response.AbstractBaseResponse;

import java.util.List;

public class AppShareInfoResponse  extends AbstractBaseResponse {

    @JsonProperty("ending")
    private Integer ending;

    @JsonProperty("corp_list")
    private List<CorpListDTO> corpList;

    public Integer getEnding() {
        return ending;
    }

    public void setEnding(Integer ending) {
        this.ending = ending;
    }

    public List<CorpListDTO> getCorpList() {
        return corpList;
    }

    public void setCorpList(List<CorpListDTO> corpList) {
        this.corpList = corpList;
    }

    public static class CorpListDTO {

        @JsonProperty("corpid")
        private String corpId;

        @JsonProperty("corp_name")
        private String corpName;

        @JsonProperty("agentid")
        private Integer agentId;

        public String getCorpId() {
            return corpId;
        }

        public void setCorpId(String corpId) {
            this.corpId = corpId;
        }

        public String getCorpName() {
            return corpName;
        }

        public void setCorpName(String corpName) {
            this.corpName = corpName;
        }

        public Integer getAgentId() {
            return agentId;
        }

        public void setAgentId(Integer agentId) {
            this.agentId = agentId;
        }
    }
}
