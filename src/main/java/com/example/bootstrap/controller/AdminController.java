package com.example.bootstrap.controller;

import com.example.bootstrap.entity.User;
import com.example.bootstrap.repository.UserRepository;
import com.example.bootstrap.service.RoleService;
import com.example.bootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;


    private RoleService roleService;

    public AdminController() {
    }

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }


    @GetMapping("/findOne")
    @ResponseBody
    public User findOne(Long id, Model model) {
        model.addAttribute("roles", roleService.findAllRoles());
        return userService.findUserByID(id).get();
    }

    @PostMapping("/save")
    public String save(@Valid User user, BindingResult bindingResult, @RequestParam(value = "roleNames") String[] roleNames) {
        if (bindingResult.hasErrors())
            return "redirect:/admin";
        user.setRoles(roleService.findRolesByNames(roleNames));
        userService.update(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/delete")
    public String delete(Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }


}