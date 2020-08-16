
package com.pyruz.controller;

import com.pyruz.model.domain.User;
import com.pyruz.model.dto.ResultDTO;
import com.pyruz.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "This is home Controller!";
    }

    @ResponseBody
    @PostMapping("/api/user")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultDTO addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

}
