package com.codegym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CaculatorController {
    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/caculator")
    public String caculator(@RequestParam("tinhtoan") String tinhtoan, @RequestParam("nhap") double nhap, @RequestParam("nhap1") double nhap1, Model model) {
        double result = 0;
        switch (tinhtoan) {
            case "Addition":
                result = nhap + nhap1;
                break;
            case "Subtraction":
                result = nhap - nhap1;
                break;
            case "Multiplication":
                result = nhap * nhap1;
                break;
            case "Division":
                result = nhap / nhap1;
                break;
            default:
                break;
        }
        model.addAttribute("nhap", nhap);
        model.addAttribute("nhap1", nhap1);
        model.addAttribute("operator", tinhtoan);
        model.addAttribute("result", result);
        return "index";
    }
}
