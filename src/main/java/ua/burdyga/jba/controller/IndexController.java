package ua.burdyga.jba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    // String is a location of a view template (jsp file)
    @RequestMapping("/index")
    public String index() {
        return "/WEB-INF/jsp/index.jsp";
    }
}
