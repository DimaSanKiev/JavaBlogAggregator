package ua.burdyga.jba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.burdyga.jba.entity.Blog;
import ua.burdyga.jba.entity.User;
import ua.burdyga.jba.service.BlogService;
import ua.burdyga.jba.service.UserService;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    // creates object of type User
    @ModelAttribute("user")     // that's a way how the object is bound from spring controller to jsp file
    public User constructUser() {
        return new User();
    }

    @ModelAttribute("blog")
    public Blog constructBlog() {
        return new Blog();
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
        return "redirect:/register.html?success=true";
    }

    @RequestMapping("/account")
    public String account(Model model, Principal principal) {
        String name = principal.getName();// this object is in user's session and it contains name of the user
        model.addAttribute("user", userService.findOneWithBlogs(name));
        return "user-detail";
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public String doAddBlog(@ModelAttribute("blog") Blog blog, Principal principal) {
        String name = principal.getName();
        blogService.save(blog, name);
        return "redirect:/account.html";
    }

    @RequestMapping("/blog/remove/{id}")
    public String removeBlog(@PathVariable int id) {
        Blog blog = blogService.findOne(id);
        blogService.delete(blog);
        return "redirect:/account.html";
    }

    @RequestMapping("/users/remove{id}")
    public String removeUser(@PathVariable int id) {
        userService.delete(id);
        return "redirect:/users.html";
    }
}
