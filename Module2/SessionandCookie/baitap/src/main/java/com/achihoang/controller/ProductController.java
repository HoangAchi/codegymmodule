package com.achihoang.controller;

import com.achihoang.model.Cart;
import com.achihoang.model.Product;
import com.achihoang.model.ProductView;
import com.achihoang.model.ProductWithFileUpload;
import com.achihoang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    private static String UPLOAD_LOCATION="E:\\achihoang\\codegym\\Module2\\SessionandCookie\\baitap\\src\\main\\webapp\\image\\";

    @ModelAttribute("cart")
    public Cart setCart(){
        return new Cart();
    }

    @ModelAttribute("price")
    public long setPrice(){
        return 0;
    }

    @Autowired
    private ProductService productService;

    @GetMapping("/home")
    public String getHomePage(Pageable pageable, Model model){
        Page<Product> listProducts = productService.findAll(pageable);
        model.addAttribute("products", listProducts);
        return "/home";
    }

    @GetMapping("/product")
    public String getProductPage(Model model){
        model.addAttribute("product", new ProductWithFileUpload());
        return "/product";
    }

    @PostMapping("/product")
    public String createProduct(@ModelAttribute ProductWithFileUpload product, Model model){
        MultipartFile file = product.getFile();
        String path = UPLOAD_LOCATION + file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(), new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String pathFile = "/assets/image/" + file.getOriginalFilename();
        Product productDb = new Product();
        productDb.setId(product.getId());
        productDb.setProductImage(pathFile);
        productDb.setProductName(product.getProductName());
        productDb.setProductPrice(product.getProductPrice());
        productService.save(productDb);
        model.addAttribute("product", new ProductWithFileUpload());
        model.addAttribute("message", "Product've just created");
        return "/product";
    }

    @GetMapping("/product/{id}")
    public String getProductDetail(Model model, @PathVariable int id, @RequestParam("amount") Optional<Integer> amount, @ModelAttribute("cart") Cart cart){
        Product product = productService.findById(id);
        if(amount.isPresent()){
            if(amount.get()>0) {
                if(cart.getMap().containsKey(product.getId())){
                    int amountBefore = cart.getMap().get(product.getId());
                    int amountAfter = amount.get() + amountBefore;
                    cart.getMap().put(product.getId(), amountAfter);
                }else {
                    cart.getMap().put(product.getId(), amount.get());
                }
                model.addAttribute("message", "added successfully");
            }
        }
        model.addAttribute("product", product);
        return "/view";
    }

    @GetMapping("/cart")
    public String getCartInfo(Model model, @ModelAttribute("cart") Cart cart, @ModelAttribute("price") long price){
        HashMap<Integer, Integer> map = cart.getMap();
        List<ProductView> list = new ArrayList<>();
        for(int id : map.keySet()){
            Product product = productService.findById(id);
            ProductView productView = new ProductView(product);
            productView.setAmount(map.get(id));
            price = price + (productView.getProductPrice()*productView.getAmount());
            list.add(productView);
        }
        model.addAttribute("products", list);
        model.addAttribute("price", price);
        return "/cart";
    }

    @GetMapping("/cart/{id}")
    public String deleteProductFromCart(Model model, @ModelAttribute("cart") Cart cart, @PathVariable int id){
        cart.getMap().remove(id);
        model.addAttribute("message", "Removed successfully");
        return "/cart";
    }
}
