package com.achihoang.controller;

import com.achihoang.model.Category;
import com.achihoang.model.Post;
import com.achihoang.service.ICategoryService;
import com.achihoang.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    private IPostService postServices;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping(value = "/home",produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public ModelAndView list(@RequestParam("search") Optional<String> title,@RequestParam("p") Optional<String> p, Pageable pageable) {
        if (p.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/error/404");
            return modelAndView;
        } else {
            Page<Post> listPost;
            if(title.isPresent()){
                listPost= postServices.findAllByTitleContaining(title.get(),pageable);
            } else {
                listPost = postServices.findAll(pageable);
            }
            ModelAndView modelAndView = new ModelAndView("/home/index");
            modelAndView.addObject("list", listPost);
            Iterable<Post> postIterable = postServices.queryTop6ByOrderByCreateDateDesc();
            modelAndView.addObject("listTop6",postIterable);
            Iterable<Post> postIterable1 = postServices.queryTop3ByOrderByCreateDateDesc();
            modelAndView.addObject("listTop3",postIterable1);
            Iterable<Category> categoryIterable = categoryService.findAll();
            modelAndView.addObject("listCategory",categoryIterable);
            return modelAndView;
        }
    }
    @GetMapping("/category/{id}")
    public ModelAndView home(@PathVariable("id") Long id,Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("/home/WebDesign");
        Category category = categoryService.findById(id);
        if (category == null) {
            return new ModelAndView("/error/404");
        }
        // find all by category
        Iterable<Post> posts = postServices.findAllByCategory(category);
        modelAndView.addObject("views", category);
        modelAndView.addObject("posts", posts);

        Page<Post> postPage = postServices.findAllByCategory(category, pageable);
        modelAndView.addObject("postListPage",postPage);

        //find top 2 category
        Iterable<Category> categoryIterable = categoryService.findAll();
        modelAndView.addObject("listCategory",categoryIterable);
        Iterable<Post> posts1 = postServices.findTop2ByCategory(category);
        modelAndView.addObject("listTop2Cate",posts1);
        //find top 1 name
//        Iterable<Category> categories = categoryService.findFirstByName(category);
//        modelAndView.addObject("nameCate",categories);
        return  modelAndView;
    }
}
