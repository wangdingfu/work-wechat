package io.github.wangdingfu.resquest.externalcontact;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DelProductAlbumRequest {

    /**
     * 商品ID
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
