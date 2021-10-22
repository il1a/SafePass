package de.htw.webtech.SafePass.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

    @GetMapping(path = "/secret")
    public ModelAndView showHome() {
        return new ModelAndView("HelloWorld");
    }

}
