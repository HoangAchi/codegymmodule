package com.achihoang.controller;

import com.achihoang.model.Product;
import com.achihoang.model.ProductUploadFile;
import com.achihoang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class ProductController {

    private static String UPLOAD="E:\\achihoang\\codegym\\Module2\\SessionandCookie\\baitap1\\src\\main\\";

    @Autowired
    private ProductService productService;

    @GetMapping("/home")
    public ModelAndView homePage(Pageable pageable){
        Page<Product> listProduct = productService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("listProduct",listProduct);
        return modelAndView;
    }

    @GetMapping("/createProduct")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("createProducts", new ProductUploadFile());
        return modelAndView;
    }

    @PostMapping("/createProduct")
    public ModelAndView saveProvince(@ModelAttribute("product") ProductUploadFile productUploadFile){
        MultipartFile file = productUploadFile.getFile();
        String path = UPLOAD+ file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(),new File(path));
        } catch (IOException e){
            e.printStackTrace();
        }
        Product product1 = new Product();
        product1.setId(productUploadFile.getId());
        product1.setName(productUploadFile.getName());
        product1.setPrice(productUploadFile.getPrice());
        product1.setImage(path);
        productService.save(product1);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("createProducts", new ProductUploadFile());
        modelAndView.addObject("message", "New product created successfully");
        return modelAndView;
    }
}
