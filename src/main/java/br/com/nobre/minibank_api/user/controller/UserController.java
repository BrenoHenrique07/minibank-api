package br.com.nobre.minibank_api.user.controller;

import br.com.nobre.minibank_api.user.model.User;
import br.com.nobre.minibank_api.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public void findAllUsers() {
    }

}
