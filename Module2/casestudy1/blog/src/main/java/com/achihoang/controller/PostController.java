package com.achihoang.controller;

import com.achihoang.model.Category;
import com.achihoang.model.Post;
import com.achihoang.service.CategoryService;
import com.achihoang.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("category")
    public Page<Category> categories(Pageable pageable) {
        return categoryService.findAll(pageable);
    }

    @GetMapping("/listPost")
    public ModelAndView list(@RequestParam("p") Optional<String> p, Pageable pageable) {
        if (p.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/error/404");
            return modelAndView;
        } else {
            Page<Post> listPost = postService.findAll(pageable);
            ModelAndView modelAndView = new ModelAndView("/post/list");
            modelAndView.addObject("list", listPost);
            return modelAndView;
        }
    }

    @GetMapping("/createPost")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/post/create");
        modelAndView.addObject("create", new Post());
        return modelAndView;
    }

    @PostMapping("/createPost")
    public ModelAndView save(@ModelAttribute("post") Post post) {
        postService.save(post);
        ModelAndView modelAndView = new ModelAndView("/post/create");
        modelAndView.addObject("create", new Post());
        modelAndView.addObject("message", "New post created successfully");
        return modelAndView;
    }

    @GetMapping("/editPost/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Post post = postService.findById(id);
        if (post != null) {
            ModelAndView modelAndView = new ModelAndView("/post/edit");
            modelAndView.addObject("edit", post);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error/404");
            return modelAndView;
        }
    }

    @PostMapping("/editPost")
    public ModelAndView updatePost(@ModelAttribute Post post) {
        postService.save(post);
        ModelAndView modelAndView = new ModelAndView("/post/edit");
        modelAndView.addObject("edit", post);
        modelAndView.addObject("message", "Post updated successfully");
        return modelAndView;
    }

    @GetMapping("/deletePost/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Post post = postService.findById(id);
        if (post != null) {
            ModelAndView modelAndView = new ModelAndView("/post/delete");
            modelAndView.addObject("delete", post);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error/404");
            return modelAndView;
        }
    }

    @PostMapping("/deletePost")
    public String deletePost(@ModelAttribute Post post) {
        postService.remove(post.getId());
        return "redirect:listPost";
    }

    @GetMapping("/viewPost/{id}")
    public ModelAndView showView(@PathVariable Long id) {
        Post post = postService.findById(id);
        if (post != null) {
            ModelAndView modelAndView = new ModelAndView("/post/view");
            modelAndView.addObject("view", post);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error/404");
            return modelAndView;
        }
    }
}
