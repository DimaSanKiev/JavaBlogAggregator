package ua.burdyga.jba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.burdyga.jba.entity.User;
import ua.burdyga.jba.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // creates object of type User
    @ModelAttribute("user")     // that's a way how the object is bound from spring controller to jsp file
    public User construct() {
        return new User();
    }

    // load data from DB using userService
    @RequestMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @RequestMapping("/users/{id}")
    public String detail(Model model, @PathVariable int id) {
        model.addAttribute("user", userService.findOneWithBlogs(id));
        return "user-detail";
    }

    @RequestMapping("/register")
    public String showRegister() {
        return "user-register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(@ModelAttribute("user") User user) {
        userService.save(user);
        return "user-register";
    }

}
