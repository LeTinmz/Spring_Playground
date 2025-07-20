package org.example.playground.Controller;

import org.example.playground.Model.Department;
import org.example.playground.Model.User;
import org.example.playground.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*") //
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

        @RequestMapping("/first")
        @ResponseBody
        public Optional<User> getFirst(){
            return userService.getFirst();
        }
    @RequestMapping("/users")
    @ResponseBody
    public List<User> displayUserName() {
        return userService.getUsers();
    }

    @RequestMapping("/save")
    @ResponseBody
    public String saveUser(@RequestParam("name") String name, @RequestParam(value = "department", required = false) String department) {
        userService.saveUser(User.builder().name(name).build());
        return "User " + name + " créé";
    }

    @RequestMapping("/department/{department}")
    @ResponseBody
    public List<User> filterByDepartment(@PathVariable String department) {
        return userService.getUsersFromGivenDepartment(department);
    }
}
