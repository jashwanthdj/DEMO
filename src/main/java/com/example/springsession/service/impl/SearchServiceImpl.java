package com.example.springsession.service.impl;
import com.example.springsession.client.SearchClient;
import com.example.springsession.dto.ProductDTO;
import com.example.springsession.dto.SearchRequestDTO;
import com.example.springsession.dto.SearchResponseDTO;
import com.example.springsession.service.SearchService;
import jdk.nashorn.internal.objects.NativeError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.util.Arrays.*;
@Service
public class SearchServiceImpl implements SearchService {

    public void awaitTerminationAfterShutdown(ExecutorService threadPool) {
        threadPool.shutdown();
        try {
            if (!threadPool.awaitTermination((long)  1, TimeUnit.SECONDS)) {
                threadPool.shutdownNow();
            }
        } catch (InterruptedException ex) {
            threadPool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
    @Autowired
    private SearchClient searchClient;

    @Override
    public SearchResponseDTO getProducts(SearchRequestDTO request) {
        SearchResponseDTO responseDTO =new SearchResponseDTO();

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Runnable runnableTask = () -> {
                Map<String,Object> pLocation = searchClient.getProductLocation("stockLocation:\""+request.getLocation() + "\"");
                List<HashMap<String, Object>> productsLocation = ((List<HashMap<String,Object>>)((HashMap<String,Object>)pLocation.get("response")).get("docs"));;
                List<ProductDTO> list2 = new ArrayList<>();

                for (Map<String, Object> product: productsLocation) {
                    // parse product into ProductDTO and add into productDTOS list
                    ProductDTO p=new ProductDTO();
                    String title= (String) product.get("name");
                    String descript=(String) product.get("description");
                    p.setTitle(title);
                    p.setDescription(descript);
                    list2.add(p);
                

        } responseDTO.setProductLocation((list2));};











        Runnable runnableTask1 = () -> {
        Map<String,Object> location = searchClient.getProductLocation(request.getSearchTerm());
        List<HashMap<String, Object>> products = ((List<HashMap<String,Object>>)((HashMap<String,Object>)location.get("response")).get("docs"));;
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Map<String, Object> product: products) {
            ProductDTO q=new ProductDTO();
            String title= (String) product.get("name");
            String descript=(String) product.get("description");

            q.setTitle(title);
            q.setDescription(descript);

            productDTOS.add(q);
        } responseDTO.setProducts((productDTOS));};

        executor.execute(runnableTask);
        executor.execute(runnableTask1);
        awaitTerminationAfterShutdown(executor);

        return responseDTO;

}}