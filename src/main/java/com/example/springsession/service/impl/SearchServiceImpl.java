package com.example.springsession.service.impl;

import com.example.springsession.dto.ProductDTO;
import com.example.springsession.dto.SearchRequestDTO;
import com.example.springsession.dto.SearchResponseDTO;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class SearchServiceImpl implements SearchService {

    @Override
    public SearchResponseDTO getProducts(SearchResponseDTO request) {
        SearchResponseDTO responseDTO=new SearchResponseDTO();
        ProductDTO product= new ProductDTO();
        product.setDescription("samsung ");
        product.setTitle("s5");
        product.setInStock(true);
        responseDTO.setProducts(Arrays.asList(product));
        return responseDTO;

    }
}
