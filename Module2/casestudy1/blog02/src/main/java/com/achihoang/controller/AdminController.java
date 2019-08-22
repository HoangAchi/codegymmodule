package com.achihoang.controller;

import com.achihoang.model.User;
import com.achihoang.model.UserFileUpload;
import com.achihoang.service.IUserService;
import com.achihoang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class AdminController {
    private static String UPLOAD_LOCATION = "E:\\achihoang\\codegym\\Module2\\casestudy1\\blog02\\src\\main\\webapp\\image\\";

    @Autowired
    private IUserService userService;

    @GetMapping("/listUser")
    public ModelAndView listUser(Pageable pageable) {
        Page<User> userPage = userService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/admins/list");
        modelAndView.addObject("list", userPage);
        return modelAndView;
    }

    @GetMapping("/createUser")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/admins/create");
        modelAndView.addObject("create", new UserFileUpload());
        return modelAndView;
    }

    @PostMapping("/createUser")
    public ModelAndView save(@Validated @ModelAttribute("create") UserFileUpload userFileUpload, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("/admins/create");
            return modelAndView;
        }
        MultipartFile file = userFileUpload.getFileUser();
        String path = UPLOAD_LOCATION + file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(), new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String pathFile = file.getOriginalFilename();
        User userDb = new User();
        userDb.setId(userFileUpload.getId());
        userDb.setEmail(userFileUpload.getEmail());
        userDb.setPassword(userFileUpload.getPassword());
        userDb.setRole(userFileUpload.getRole());
        userDb.setSalt(userFileUpload.getSalt());
        userDb.setImageUser(pathFile);
        userDb.setCreator(userFileUpload.getCreator());
        userDb.setLastEditor(userFileUpload.getLastEditor());
        userService.save(userDb);
        ModelAndView modelAndView = new ModelAndView("/admins/create");
        modelAndView.addObject("create", new UserFileUpload());
        modelAndView.addObject("message", "New User created successfully");
        return modelAndView;
    }

    @GetMapping("/editUser/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        User user = userService.findById(id);
        if (user != null) {
            ModelAndView modelAndView = new ModelAndView("/admins/edit");
            modelAndView.addObject("edit", user);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error/404");
            return modelAndView;
        }
    }

    @PostMapping("/editUser")
    public ModelAndView updatePost(@Validated @ModelAttribute("edit") User user, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("/admins/edit");
            return modelAndView;
        }
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("/admins/edit");
        modelAndView.addObject("edit", user);
        modelAndView.addObject("message", "User updated successfully");
        return modelAndView;
    }

    @GetMapping("/deleteUser/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        User user = userService.findById(id);
        if (user != null) {
            ModelAndView modelAndView = new ModelAndView("/admins/delete");
            modelAndView.addObject("delete", user);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error/404");
            return modelAndView;
        }
    }

    @PostMapping("/deleteUser")
    public String deletePost(@ModelAttribute User user) {
        userService.remove(user.getId());
        return "redirect:listUser";
    }

    @GetMapping("/viewUser/{id}")
    public ModelAndView showView(@PathVariable Long id) {
        User user = userService.findById(id);
        if (user != null) {
            ModelAndView modelAndView = new ModelAndView("/admins/view");
            modelAndView.addObject("view", user);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error/404");
            return modelAndView;
        }
    }
}
