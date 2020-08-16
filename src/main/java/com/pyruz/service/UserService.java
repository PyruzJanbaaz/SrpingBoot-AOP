package com.pyruz.service;

import com.pyruz.model.domain.User;
import com.pyruz.model.dto.ResultDTO;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public ResultDTO addUser(User user) {
        //Write your own code to create a new user and insert it to your database
        return ResultDTO.builder()
                .code(0)
                .message("User created successfully!")
                .build();
    }

}
