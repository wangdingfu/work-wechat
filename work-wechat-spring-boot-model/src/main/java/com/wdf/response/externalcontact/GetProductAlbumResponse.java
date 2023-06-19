package com.wdf.response.externalcontact;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wdf.dto.externalcontact.ProductDTO;
import com.wdf.response.AbstractBaseResponse;

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
