package com.example.springsession.service.Impl;

import com.example.springsession.dto.MyRequestDTO;
import com.example.springsession.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserServiceImpl implements UserService {

    public UserServiceImpl(){
        System.out.println(" inside userSERVICE constructor");
    }
    @PostConstruct
    public void init(){
        System.out.println(" inside userservice post constructor");
    }


    @Override
    public boolean updateEmployee(MyRequestDTO request, String id) {
        System.out.println("inside ");
        return false;
    }
}