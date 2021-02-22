package com.example.springsession.controller;

import com.example.springsession.dto.MyRequestDTO;
import com.example.springsession.dto.MyResponseDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {

    @GetMapping(path="/hello")
    public String helloWorld(){
        return "sucess!!!";
    }
   @PostMapping("/hello-world")
public String newHelloWorld(){
    return "sucess!!!";
}
 @GetMapping(path="/hello-query")
    public String helloQuery(@RequestParam String query){
        return "query "+ query;
 }
 @PostMapping(value="/register")
    public String registerUser(@RequestBody MyRequestDTO request){
        return request.toString();
 }@GetMapping(path="/employee/{employeeId}")
    public MyResponseDTO getEmployeeDetails(@PathVariable String employeeId ){
        MyResponseDTO response=new MyResponseDTO();

        response.setId(employeeId);
        return response;

    }

}

