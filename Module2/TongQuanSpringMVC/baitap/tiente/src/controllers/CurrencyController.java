package controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }


    @RequestMapping(value = "/current", method = RequestMethod.POST)
    public String greeting(@RequestParam("usd") double usd, Model model) {
        double currency = usd * 23400;
        model.addAttribute("usd", usd);
        model.addAttribute("result", currency);
        return "index";
    }
}
