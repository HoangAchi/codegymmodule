package com.achihoang.controller;

import com.achihoang.model.Category;
import com.achihoang.model.Post;
import com.achihoang.service.ICategory;
import com.achihoang.service.IPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private ICategory iCategory;
    @Autowired
    private IPost iPost;

    @GetMapping("/home")
    public ModelAndView home(@RequestParam("search") Optional<String> title, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/home/index");
        Locale locale = LocaleContextHolder.getLocale();

        Iterable<Category> categoryIterable = iCategory.findAllByLocale(locale.getLanguage());
        modelAndView.addObject("cateList", categoryIterable);

        Iterable<Post> postIterable = iPost.queryTop2ByLocaleOrderByCreateDateDesc(locale.getLanguage());
        modelAndView.addObject("postTop2", postIterable);

        Iterable<Post> postIterable1 = iPost.queryTop6ByLocaleOrderByCreateDateDesc(locale.getLanguage());
        modelAndView.addObject("postTop6", postIterable1);

        Iterable<Post> postIterable2 = iPost.queryTop3ByLocaleOrderByCreateDateDesc(locale.getLanguage());
        modelAndView.addObject("postTop3", postIterable2);

        if (title.isPresent()) {
            Page<Post> postPage = iPost.findAllByLocaleAndTitleContaining(locale.getLanguage(), title.get(), pageable);
            modelAndView.addObject("allPost", postPage);
        } else {
            Page<Post> postPage = iPost.findAllByLocale(locale.getLanguage(), pageable);
            modelAndView.addObject("allPost", postPage);
        }
        return modelAndView;
    }

    @GetMapping("/category/{id}")
    public ModelAndView category(@PathVariable("id") Long id, @RequestParam("search") Optional<String> title, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/home/category");
        Category category = iCategory.findById(id);
        if (category == null) {
            return new ModelAndView("/error/404");
        }
        Locale locale = LocaleContextHolder.getLocale();
        Iterable<Category> categoryIterable = iCategory.findAllByLocale(locale.getLanguage());
        modelAndView.addObject("cateList1", categoryIterable);
        Iterable<Category> categoryIterable1 = iCategory.findFirstByLocaleAndId(locale.getLanguage(), id);
        modelAndView.addObject("cateName", categoryIterable1);
        if(title.isPresent()){
            Page<Post> postPage = iPost.findAllByCategoryAndLocaleAndTitle(category,pageable,title.get(),locale.getLanguage());
            modelAndView.addObject("cateSearch",postPage);
        }
        Page<Post> postPage = iPost.findAllByCategoryAndLocale(category,pageable,locale.getLanguage());
        modelAndView.addObject("cateSearch",postPage);
        Iterable<Post> postIterable = iPost.queryTop2ByLocaleAndCategoryOrderByCreateDateDesc(locale.getLanguage(),category);
        modelAndView.addObject("top2Cate",postIterable);
        return modelAndView;
    }
    @GetMapping("/blog-post/{id}")
    public ModelAndView blogPost(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("/home/blog-post");
        Post post = iPost.findById(id);
        if(post==null){
            return new ModelAndView("/error/404");
        }
        Locale locale = LocaleContextHolder.getLocale();
        Iterable<Category> categoryIterable = iCategory.findAllByLocale(locale.getLanguage());
        modelAndView.addObject("cateList2", categoryIterable);
        Iterable<Post> postIterable= iPost.findPostByLocaleAndId(locale.getLanguage(),id);
        modelAndView.addObject("postId",postIterable);
        Iterable<Post> postIterable1 = iPost.queryTop2ByLocaleOrderByCreateDateDesc(locale.getLanguage());
        modelAndView.addObject("postTop2", postIterable1);
        return modelAndView;
    }
}
