package com.achihoang.controller;

import com.achihoang.model.Category;
import com.achihoang.model.CategoryVi;
import com.achihoang.model.Post;
import com.achihoang.service.ICategoryService;
import com.achihoang.service.ICategoryVi;
import com.achihoang.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Locale;


@Controller
public class CategoryController {

    @Autowired
    private ICategoryService ICategoryService;

    @Autowired
    private ICategoryVi iCategoryVi;

    @Autowired
    private IPostService postServices;

    @GetMapping("/listCategory")
    public ModelAndView list(Pageable pageable) {
        Locale locale = LocaleContextHolder.getLocale();
        ModelAndView modelAndView = new ModelAndView("/category/list");
        if (locale.getLanguage() == "en") {
            Page<Category> categoryPage = ICategoryService.findAll(pageable);
            modelAndView.addObject("list", categoryPage);
            return modelAndView;
        } else {
            Page<CategoryVi> categoryViPage = iCategoryVi.findAll(pageable);
            modelAndView.addObject("list", categoryViPage);
            return modelAndView;
        }
    }

    @GetMapping("/createCategory")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("createVi", new CategoryVi());
        modelAndView.addObject("create", new Category());
        return modelAndView;
    }

    @PostMapping("/createCategory")
    public ModelAndView saveCreate(@Valid @ModelAttribute("create") Category category, @Valid @ModelAttribute("createVi") CategoryVi categoryVi, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("/category/create");
            return modelAndView;
        } else {
            ICategoryService.save(category);
            iCategoryVi.save(categoryVi);
            ModelAndView modelAndView = new ModelAndView("/category/create");
            modelAndView.addObject("create", new Category());
            modelAndView.addObject("createVi", new CategoryVi());
            modelAndView.addObject("message", "New category created successfully");
            return modelAndView;
        }
    }

    @GetMapping("/editCategory/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Category category = ICategoryService.findById(id);
        CategoryVi categoryVi = iCategoryVi.findById(id);
        if (category != null && categoryVi != null) {
            ModelAndView modelAndView = new ModelAndView("/category/edit");
            modelAndView.addObject("edit", category);
            modelAndView.addObject("editVi", categoryVi);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error/404");
            return modelAndView;
        }
    }

    @PostMapping("/editCategory")
    public ModelAndView Edit(@Valid @ModelAttribute("edit") Category category, @Valid @ModelAttribute("editVi") CategoryVi categoryVi, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("/category/edit");
            return modelAndView;
        }
        ICategoryService.save(category);
        iCategoryVi.save(categoryVi);
        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("edit", category);
        modelAndView.addObject("editVi", categoryVi);
        modelAndView.addObject("message", "category updated successfully");
        return modelAndView;
    }

    @GetMapping("/deleteCategory/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Category category = ICategoryService.findById(id);
        CategoryVi categoryVi = iCategoryVi.findById(id);
        if (category != null && categoryVi != null) {
            ModelAndView modelAndView = new ModelAndView("/category/delete");
            modelAndView.addObject("delete", category);
            modelAndView.addObject("deleteVi", categoryVi);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error/404");
            return modelAndView;
        }
    }

    @PostMapping("/deleteCategory")
    public String delete(@ModelAttribute("delete") Category category,@ModelAttribute("deleteVi") CategoryVi categoryVi) {
        ICategoryService.delete(category.getId());
        iCategoryVi.delete(categoryVi.getId());
        return "redirect:listCategory";
    }

    @GetMapping("/viewCategory/{id}")
    public ModelAndView view(@PathVariable("id") Long id) {
        Category category = ICategoryService.findById(id);
        if (category == null) {
            return new ModelAndView("/error/404");
        }
        Iterable<Post> posts = postServices.findAllByCategory(category);
        ModelAndView modelAndView = new ModelAndView("/category/view");
        modelAndView.addObject("view", category);
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }
}
