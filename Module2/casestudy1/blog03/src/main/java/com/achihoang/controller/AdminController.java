package com.achihoang.controller;

import com.achihoang.model.Category;
import com.achihoang.model.Post;
import com.achihoang.model.PostUpload;
import com.achihoang.service.ICategory;
import com.achihoang.service.IPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Optional;

@Controller
public class AdminController {

    @Autowired
    private ICategory iCategory;

    @Autowired
    private IPost iPost;

    //begin category
    @GetMapping(value = "/listCategory",produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public ModelAndView listCate(Pageable pageable) {
        Locale locale = LocaleContextHolder.getLocale();
        ModelAndView modelAndView = new ModelAndView("/admin/category/list");
        Page<Category> categoryPage = iCategory.findAllByLocale(locale.getLanguage(), pageable);
        modelAndView.addObject("listCate", categoryPage);
        return modelAndView;
    }

    @GetMapping(value = "/createCategory",produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public ModelAndView showCreateCateForm() {
        ModelAndView modelAndView = new ModelAndView("/admin/category/create");
        modelAndView.addObject("createCate", new Category());
        return modelAndView;
    }

    @PostMapping(value = "/createCategory",produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public ModelAndView saveCreateCate(@Valid @ModelAttribute("createCate") Category category, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("/admin/category/create");
            return modelAndView;
        } else {
            iCategory.save(category);
            ModelAndView modelAndView = new ModelAndView("/admin/category/create");
            modelAndView.addObject("createCate", new Category());
            modelAndView.addObject("message", "New category created successfully");
            return modelAndView;
        }
    }

    @GetMapping(value = "/editCategory/{id}",produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public ModelAndView showEditCateForm(@PathVariable Long id) {
        Category category = iCategory.findById(id);
        if (category != null) {
            ModelAndView modelAndView = new ModelAndView("/admin/category/edit");
            modelAndView.addObject("editCate", category);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error/404");
            return modelAndView;
        }
    }

    @PostMapping(value = "/editCategory",produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public ModelAndView EditCate(@Valid @ModelAttribute("editCate") Category category, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("/admin/category/edit");
            return modelAndView;
        }
        iCategory.save(category);
        ModelAndView modelAndView = new ModelAndView("/admin/category/edit");
        modelAndView.addObject("editCate", category);
        modelAndView.addObject("message", "category updated successfully");
        return modelAndView;
    }

    @GetMapping(value = "/deleteCategory/{id}",produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public ModelAndView showDeleteCateForm(@PathVariable Long id) {
        Category category = iCategory.findById(id);
        if (category != null) {
            ModelAndView modelAndView = new ModelAndView("/admin/category/delete");
            modelAndView.addObject("deleteCate", category);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error/404");
            return modelAndView;
        }
    }

    @PostMapping(value = "/deleteCategory",produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String deleteCate(@ModelAttribute("deleteCate") Category category) {
        iCategory.remove(category.getId());
        return "redirect:listCategory";
    }

    @GetMapping(value = "/viewCategory/{id}",produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public ModelAndView view(@PathVariable("id") Long id) {
        Category category = iCategory.findById(id);
        if (category == null) {
            return new ModelAndView("/error/404");
        }
        Iterable<Post> posts = iPost.findAllByCategory(category);
        ModelAndView modelAndView = new ModelAndView("/admin/category/view");
        modelAndView.addObject("viewCate", category);
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }

    //end Category

    //begin Post
    private static String UPLOAD_LOCATION = "E:\\achihoang\\codegym\\Module2\\casestudy1\\blog03\\src\\main\\webapp\\WEB-INF\\views\\admin\\theme\\image\\";
    @ModelAttribute("category")
    public Page<Category> categories(Pageable pageable) {
        return iCategory.findAll(pageable);
    }


    @GetMapping(value = "/listPost",produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public ModelAndView list(@RequestParam("p") Optional<String> p, Pageable pageable) {
        if (p.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/error/404");
            return modelAndView;
        } else {
            Locale locale = LocaleContextHolder.getLocale();
            ModelAndView modelAndView = new ModelAndView("/admin/post/list");
            Page<Post> listPost = iPost.findAllByLocale(locale.getLanguage(),pageable);
            modelAndView.addObject("listPo", listPost);
            return modelAndView;
        }
    }

    @GetMapping(value = "/createPost",produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/admin/post/create");
        modelAndView.addObject("createPo", new PostUpload());
        return modelAndView;
    }

    @PostMapping(value = "/createPost",produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public ModelAndView save(@Validated @ModelAttribute("createPo") PostUpload postUpload, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("/admin/post/create");
            return modelAndView;
        }
        MultipartFile file = postUpload.getMultipartFile();
        String path = UPLOAD_LOCATION + file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(), new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String pathFile = file.getOriginalFilename();
        Post postDb = new Post();
        postDb.setId(postUpload.getId());
        postDb.setIntroduce(postUpload.getIntroduce());
        postDb.setTitle(postUpload.getTitle());
        postDb.setContext(postUpload.getContext());
        postDb.setImage(pathFile);
        postDb.setLocale(postUpload.getLocale());
        postDb.setCreator(postUpload.getCreator());
        postDb.setLastEditor(postUpload.getLastEditor());
        postDb.setCategory(postUpload.getCategory());
        iPost.save(postDb);
        ModelAndView modelAndView = new ModelAndView("/admin/post/create");
        modelAndView.addObject("createPo", new PostUpload());
        modelAndView.addObject("message", "New post created successfully");
        return modelAndView;
    }

    @GetMapping(value = "/editPost/{id}",produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Post post = iPost.findById(id);
        if (post != null) {
            ModelAndView modelAndView = new ModelAndView("/admin/post/edit");
            modelAndView.addObject("editPo", post);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error/404");
            return modelAndView;
        }
    }

    @PostMapping(value = "/editPost",produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public ModelAndView updatePost(@Validated @ModelAttribute("edit") Post post , BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("/admin/post/edit");
            return modelAndView;
        }
        iPost.save(post);
        ModelAndView modelAndView = new ModelAndView("/admin/post/edit");
        modelAndView.addObject("editPo", post);
        modelAndView.addObject("message", "Post updated successfully");
        return modelAndView;
    }

    @GetMapping(value = "/deletePost/{id}",produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Post post = iPost.findById(id);
        if (post != null) {
            ModelAndView modelAndView = new ModelAndView("/admin/post/delete");
            modelAndView.addObject("deletePo", post);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error/404");
            return modelAndView;
        }
    }

    @PostMapping(value = "/deletePost",produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String deletePost(@ModelAttribute("deletePo") Post post) {
        iPost.remove(post.getId());
        return "redirect:listPost";
    }

    @GetMapping(value = "/viewPost/{id}",produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public ModelAndView showView(@PathVariable Long id) {
        Post post = iPost.findById(id);
        if (post != null) {
            ModelAndView modelAndView = new ModelAndView("/admin/post/view");
            modelAndView.addObject("viewPo", post);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error/404");
            return modelAndView;
        }
    }

    //end Post
}
