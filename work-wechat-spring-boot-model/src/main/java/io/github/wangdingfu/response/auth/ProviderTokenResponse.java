package io.github.wangdingfu.response.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.response.AbstractBaseResponse;

/**
 * @author ddshuai
 * date 2022-09-05 21:50
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProviderTokenResponse extends AbstractBaseResponse {

    @JsonProperty("provider_access_token")
    private String providerAccessToken;

    @JsonProperty("expires_in")
    private int expiresIn;

    public String getProviderAccessToken() {
        return providerAccessToken;
    }

    public void setProviderAccessToken(String providerAccessToken) {
        this.providerAccessToken = providerAccessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}
