package com.example.BBVA2.Rest;

import com.example.BBVA2.DoMain.User;
import com.example.BBVA2.Exceptions.InvalidCredentialsException;
import com.example.BBVA2.Service.UserService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public User login(@RequestBody User user) throws InvalidCredentialsException {
        return userService.login(user.name(), user.pass());
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }


}