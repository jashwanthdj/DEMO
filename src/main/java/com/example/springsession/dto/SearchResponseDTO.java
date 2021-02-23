package com.example.springsession.dto;

import java.util.List;

public class SearchResponseDTO {
    private List<ProductDTO> products;
    private List<ProductDTO> productlocation;

    public List<ProductDTO> getProductLocation() {
        return productlocation;
    }

    public void setProductLocation(List<ProductDTO> productlocation) {
        this.productlocation = productlocation;
    }

    public List<ProductDTO>getProducts(){
        return products;
    }
    public  void setProducts(List<ProductDTO> products){
        this.products=products;
    }


}
