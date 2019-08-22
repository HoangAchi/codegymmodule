package com.achihoang.controller;

import com.achihoang.model.Category;
import com.achihoang.model.Post;
import com.achihoang.model.PostFileUpload;
import com.achihoang.service.ICategoryService;
import com.achihoang.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
public class PostController {
    private static String UPLOAD_LOCATION = "E:\\achihoang\\codegym\\Module2\\casestudy1\\blog02\\src\\main\\webapp\\image\\";

    @Autowired
    private IPostService postServices;

    @Autowired
    private ICategoryService ICategoryService;

    @ModelAttribute("category")
    public Page<Category> categories(Pageable pageable) {
        return ICategoryService.findAll(pageable);
    }

    @GetMapping("/listTop6Post")
    public ModelAndView list(){
        Iterable<Post> postIterable = postServices.queryTop6ByOrderByCreateDateDesc();
        ModelAndView modelAndView = new ModelAndView("/test/index");
        modelAndView.addObject("listTop",postIterable);
        return modelAndView;
    }

    @GetMapping("/listPost")
    public ModelAndView list(@RequestParam("p") Optional<String> p, Pageable pageable) {
        if (p.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/error/404");
            return modelAndView;
        } else {
            Page<Post> listPost = postServices.findAll(pageable);
            ModelAndView modelAndView = new ModelAndView("/post/list");
            modelAndView.addObject("list", listPost);
            return modelAndView;
        }
    }

    @GetMapping("/createPost")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/post/create");
        modelAndView.addObject("create", new PostFileUpload());
        return modelAndView;
    }

    @PostMapping("/createPost")
    public ModelAndView save(@Validated @ModelAttribute("create") PostFileUpload postFileUpload, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("/post/create");
            return modelAndView;
        }
        MultipartFile file = postFileUpload.getFile();
        String path = UPLOAD_LOCATION + file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(), new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String pathFile = file.getOriginalFilename();
        Post postDb = new Post();
        postDb.setId(postFileUpload.getId());
        postDb.setIntroduce(postFileUpload.getIntroduce());
        postDb.setTitle(postFileUpload.getTitle());
        postDb.setContext(postFileUpload.getContext());
        postDb.setImage(pathFile);
        postDb.setCreator(postFileUpload.getCreator());
        postDb.setLastEditor(postFileUpload.getLastEditor());
        postDb.setCategory(postFileUpload.getCategory());
        postServices.save(postDb);
        ModelAndView modelAndView = new ModelAndView("/post/create");
        modelAndView.addObject("create", new PostFileUpload());
        modelAndView.addObject("message", "New post created successfully");
        return modelAndView;
    }

    @GetMapping("/editPost/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Post post = postServices.findById(id);
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
    public ModelAndView updatePost(@Validated @ModelAttribute("edit") Post post , BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("/post/edit");
            return modelAndView;
        }
        postServices.save(post);
        ModelAndView modelAndView = new ModelAndView("/post/edit");
        modelAndView.addObject("edit", post);
        modelAndView.addObject("message", "Post updated successfully");
        return modelAndView;
    }

    @GetMapping("/deletePost/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Post post = postServices.findById(id);
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
        postServices.remove(post.getId());
        return "redirect:listPost";
    }

    @GetMapping("/viewPost/{id}")
    public ModelAndView showView(@PathVariable Long id) {
        Post post = postServices.findById(id);
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
