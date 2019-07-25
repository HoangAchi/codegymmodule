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
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("/posts")
    public ModelAndView listPosts(@RequestParam("p")Optional<String> p, Pageable pageable){
        Page<Post> posts;
        if(p.isPresent()){
            posts = postService.findAllByTitleContaining(p.get(),pageable);
        } else {
            posts = postService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/post/list");
        modelAndView.addObject("listposts",posts);
        return modelAndView;
    }
    @GetMapping("/create-post")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/post/create");
        modelAndView.addObject("createpost", new Post());
        return modelAndView;
    }

    @PostMapping("/create-post")
    public ModelAndView saveCustomer(@ModelAttribute("post") Post post){
        postService.save(post);
        ModelAndView modelAndView = new ModelAndView("/post/create");
        modelAndView.addObject("createpost", new Post());
        modelAndView.addObject("message", "New post created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-post/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Post post = postService.findById(id);
        if(post != null) {
            ModelAndView modelAndView = new ModelAndView("/post/edit");
            modelAndView.addObject("editpost", post);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-post")
    public ModelAndView updatePost(@ModelAttribute("post") Post post){
        postService.save(post);
        ModelAndView modelAndView = new ModelAndView("/post/edit");
        modelAndView.addObject("editpost", post);
        modelAndView.addObject("message", "Post updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-post/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Post post = postService.findById(id);
        if(post != null) {
            ModelAndView modelAndView = new ModelAndView("/post/delete");
            modelAndView.addObject("deletepost", post);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-post")
    public String deletePost(@ModelAttribute("post") Post post){
        postService.remove(post.getId());
        return "redirect:posts";
    }
    @GetMapping("/view-post/{id}")
    public ModelAndView showView(@PathVariable Long id){
        Post post = postService.findById(id);
        if (post != null){
            ModelAndView modelAndView = new ModelAndView("/post/view");
            modelAndView.addObject("viewpost",post);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
}
