package ru.infinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.infinic.service.UserService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Oleg Kadochnikov
 */

@Controller
@RequestMapping()
public class CommonController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String mainPage(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin";
        } else {
            return "redirect:/user";
        }
    }

    @GetMapping("/admin")
    public String adminMainPage() {
        return "redirect:/admin/users";
    }

    @GetMapping("/user")
    public String showProfile(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("user", userService.getUserByUsername(auth.getName()));
        return "users/info";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "common/login";
    }

}
