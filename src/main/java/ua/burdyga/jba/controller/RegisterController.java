package ua.burdyga.jba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.burdyga.jba.entity.User;
import ua.burdyga.jba.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;


    // creates the form
    @ModelAttribute("user")     // that's a way how the object is bound from spring controller to jsp file
    public User constructUser() {
        return new User();
    }

    // shows the register's page
    @RequestMapping
    public String showRegister() {
        return "user-register";
    }

    // receives the form from user
    @RequestMapping(method = RequestMethod.POST)
    public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user-register";
        }
        userService.save(user);
        return "redirect:/register.html?success=true";
    }

    @RequestMapping("/available")
    @ResponseBody
    public String available(@RequestParam String username) {
        Boolean available = userService.findOne(username) == null;
        return available.toString();
    }

}
