package com.example.springsession.service.impl;

import com.example.springsession.dto.SearchResponseDTO;

public interface SearchService {


    SearchResponseDTO getProducts(SearchResponseDTO request);
}
