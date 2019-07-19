package com.codegym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/home")
    public String home() {
        return "index";
    }

    @RequestMapping("/test/{name}/{tuoi}/{gioitinh}")
    public String test(@PathVariable("name") String name, @PathVariable("tuoi") int age, @PathVariable("gioitinh") String sex, Model model){
        model.addAttribute("name" , name);
        model.addAttribute("age",age);
        model.addAttribute("sex",sex);
        return "index";
    }
}
