package io.github.wangdingfu.response.externalcontact;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.response.AbstractBaseResponse;

public class AddProductAlbumResponse extends AbstractBaseResponse {

    /**
     * 商品id
     */
    @JsonProperty("product_id")
    private String productId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
