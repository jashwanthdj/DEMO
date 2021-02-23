package com.example.springsession.client;
import  java.util.Map;
import java.util.Objects;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "search-client",url="http://10.177.68.77:8983")
public interface SearchClient {
    @RequestMapping(method= RequestMethod.GET,path="/solr/productCollection/select")
     Map<String, Object>getProducts(@RequestParam("q") String query);
    @RequestMapping(method= RequestMethod.GET,path="/solr/productCollection/select")
    Map<String, Object>getProductLocation(@RequestParam("q") String query);




}
