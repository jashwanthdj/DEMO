package com.example.springsession.dto;

public class SearchRequestDTO {
    private String searchTerm;
    private String request;


    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }
}