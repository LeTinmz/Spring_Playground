package org.example.playground.Controller;

import org.example.playground.Model.User;
import org.example.playground.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    @ResponseBody
    public String sayHello() {
        return userService.sayHello();
    }

    @RequestMapping("/users")
    @ResponseBody
    public List<User> displayUserName() {
        return userService.getUsers();
    }

    @RequestMapping("/save")
    @ResponseBody
    public String saveUser(@RequestParam("name") String name) {
        userService.saveUser(User.builder().name(name).build());
        return "User " + name + " créé";
    }
}
