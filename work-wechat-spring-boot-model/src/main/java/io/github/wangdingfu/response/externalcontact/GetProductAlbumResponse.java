package io.github.wangdingfu.response.externalcontact;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.dto.externalcontact.ProductDTO;
import io.github.wangdingfu.response.AbstractBaseResponse;

public class GetProductAlbumResponse extends AbstractBaseResponse {

    /**
     * product
     */
    @JsonProperty("product")
    private ProductDTO product;

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

}
