package com.hasan.thymeleaf.example.controller;

import com.hasan.thymeleaf.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class UserController {

    public static final int DEFAULT_PAGE = 1;
    public static final int DEFAULT_PAGE_SIZE = 20;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String overview(@RequestParam(name = "displayName", required = false) String displayName,
                           @RequestParam(name = "page", required = false) Integer page,
                           @RequestParam(name = "size", required = false) Integer size,
                           Model model) {
        if (displayName == null) {
            model.addAttribute("users", userService.listAllUsers(toPageRequest(page, size)));
        } else {
            model.addAttribute("users", userService.listUsersWithDisplayName(displayName, toPageRequest(page, size)));
        }
        return "user-overview";
    }

    private PageRequest toPageRequest(Integer page, Integer size) {
        if (page == null) {
            page = DEFAULT_PAGE;
        }
        if (size == null) {
            size = DEFAULT_PAGE_SIZE;
        }
        return PageRequest.of(page, size);
    }

}
