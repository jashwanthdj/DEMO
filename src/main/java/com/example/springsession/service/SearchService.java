package com.example.springsession.service;

import com.example.springsession.dto.SearchRequestDTO;
import com.example.springsession.dto.SearchResponseDTO;

public interface SearchService {


    SearchResponseDTO getProducts(SearchRequestDTO request);
}
