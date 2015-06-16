package ua.burdyga.jba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.burdyga.jba.service.ItemService;

@Controller
public class IndexController {

    @Autowired
    private ItemService itemService;


    // String is a location of a view template (jsp file)
    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("items", itemService.getItems());
        return "index";
    }
}
