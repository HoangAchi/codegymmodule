package com.achihoang.controller;

import com.achihoang.model.Category;
import com.achihoang.model.Post;
import com.achihoang.service.CategoryService;
import com.achihoang.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PostService postService;

    @GetMapping("/listCategory")
    public ModelAndView listCategory(Pageable pageable) {
        Page<Category> categoryPage = categoryService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("list", categoryPage);
        return modelAndView;
    }

    @GetMapping("/createCategory")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("create", new Category());
        return modelAndView;
    }

    @PostMapping("/createCategory")
    public ModelAndView saveCreate(@Validated @ModelAttribute Category category, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("/category/create");
            return modelAndView;
        } else {
            categoryService.save(category);
            ModelAndView modelAndView = new ModelAndView("/category/create");
            modelAndView.addObject("create", new Category());
            modelAndView.addObject("message", "New category created successfully");
            return modelAndView;
        }
    }

    @GetMapping("/editCategory/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        if (category != null) {
            ModelAndView modelAndView = new ModelAndView("/category/edit");
            modelAndView.addObject("edit", category);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error/404");
            return modelAndView;
        }
    }

    @PostMapping("/editCategory")
    public ModelAndView Edit(@ModelAttribute Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("edit", category);
        modelAndView.addObject("message", "category updated successfully");
        return modelAndView;
    }

    @GetMapping("/deleteCategory/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        if (category != null) {
            ModelAndView modelAndView = new ModelAndView("/category/delete");
            modelAndView.addObject("delete", category);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error/404");
            return modelAndView;
        }
    }

    @PostMapping("/deleteCategory")
    public String delete(@ModelAttribute("category") Category category) {
        categoryService.remove(category.getId());
        return "redirect:listCategory";
    }

    @GetMapping("/viewCategory/{id}")
    public ModelAndView view(@PathVariable("id") Long id) {
        Category category = categoryService.findById(id);
        if (category == null) {
            return new ModelAndView("/error/404");
        }
        Iterable<Post> posts = postService.findAllByCategory(category);
        ModelAndView modelAndView = new ModelAndView("/category/view");
        modelAndView.addObject("view", category);
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }
}
