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
        Map<String,Object> pLocation = searchClient.getProductLocation("stockLocation:\""+request.getLocation() + "\"");





        List<HashMap<String, Object>> products = ((List<HashMap<String,Object>>)((HashMap<String,Object>)productResponce.get("response")).get("docs"));;
        List<HashMap<String, Object>> productsLocation = ((List<HashMap<String,Object>>)((HashMap<String,Object>)productResponce.get("response")).get("docs"));;

        List<ProductDTO> productDTOS = new ArrayList<>();
        List<ProductDTO> list2 = new ArrayList<>();
        SearchResponseDTO responseDTO =new SearchResponseDTO();
        for (Map<String, Object> product: productsLocation) {
            // parse product into ProductDTO and add into productDTOS list
            ProductDTO p=new ProductDTO();
            String title= (String) product.get("name");
            String descript=(String) product.get("description");


            p.setTitle(title);
            p.setDescription(descript);
            productDTOS.add(p);
        }
         responseDTO.setProductLocation((productDTOS));



        for (Map<String, Object> product: products) {
            ProductDTO p=new ProductDTO();
            String title= (String) product.get("name");

            p.setTitle(title);
            productDTOS.add(p);
        }

        responseDTO.setProducts((productDTOS));
        return responseDTO;

    }
}