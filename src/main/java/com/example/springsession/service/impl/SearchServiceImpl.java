package com.example.springsession.service.impl;
import com.example.springsession.client.SearchClient;
import com.example.springsession.dto.ProductDTO;
import com.example.springsession.dto.SearchRequestDTO;
import com.example.springsession.dto.SearchResponseDTO;
import com.example.springsession.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

import static java.util.Arrays.*;
@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private SearchClient searchClient;

    @Override
    public SearchResponseDTO getProducts(SearchRequestDTO request) {
        Map<String,Object> productResponce = searchClient.getProducts(request.getSearchTerm());
        List<HashMap<String, Object>> products = ((List<HashMap<String,Object>>)((HashMap<String,Object>)productResponce.get("response")).get("docs"));;
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Map<String, Object> product: products) {
            // parse product into ProductDTO and add into productDTOS list
            String title= (String) product.get("name");
            ProductDTO p=new ProductDTO();
            p.setTitle(title);
            productDTOS.add(p);
        }
        SearchResponseDTO responseDTO =new SearchResponseDTO();
        responseDTO.setProducts((productDTOS));
        return responseDTO;

    }
}