package io.github.wangdingfu.response.externalcontact;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.wangdingfu.dto.externalcontact.ProductDTO;
import io.github.wangdingfu.response.AbstractBaseResponse;

import java.util.List;

public class ProductAlbumListResponse extends AbstractBaseResponse {

    @JsonProperty("product_list")
    private List<ProductDTO> productAlbumList;

    public List<ProductDTO> getProductAlbumList() {
        return productAlbumList;
    }

    public void setProductAlbumList(List<ProductDTO> productAlbumList) {
        this.productAlbumList = productAlbumList;
    }
}
