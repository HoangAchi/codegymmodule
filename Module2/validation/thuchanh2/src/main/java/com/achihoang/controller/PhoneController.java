package com.achihoang.controller;

import com.achihoang.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PhoneController {
    @GetMapping("/phone")
    public String showForm(Model model){
        model.addAttribute("phoneNumber", new PhoneNumber());
        return "index";
    }
    @PostMapping("/phoneValidation")
    public String checkValidation (@Valid @ModelAttribute("phoneNumber")PhoneNumber phoneNumber,Model model,BindingResult bindingResult){
        new PhoneNumber().validate(phoneNumber, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "index";
        }
        else {
            model.addAttribute("phoneNumber", phoneNumber);
            return "result";
        }
    }
}