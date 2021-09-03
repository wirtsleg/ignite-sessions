package com.github.wirtsleg.ignitesessions.web;

import com.github.wirtsleg.ignitesessions.dto.User;
import com.github.wirtsleg.ignitesessions.dto.UserResponse;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/")
    public UserResponse getUser(@AuthenticationPrincipal User user) {
        return new UserResponse(user.getId(), user.getEmail());
    }
}
