package com.helloLoiNguyen.springJwt.controller;

import com.helloLoiNguyen.springJwt.model.AuthenticationResponse;
import com.helloLoiNguyen.springJwt.model.User;
import com.helloLoiNguyen.springJwt.service.AuthenticationService;
import com.helloLoiNguyen.springJwt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private final AuthenticationService authService;
    private final UserService userService;

    public HomeController(AuthenticationService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/perform_login")
    public String login(@RequestBody User request, Model model) {

        AuthenticationResponse response = authService.authenticate(request);
        if (response.getAccessToken() != null) {
            // Nếu đăng nhập thành công, chuyển hướng đến trang home
            System.out.println("token: " + response.getAccessToken());
            return "redirect:/home";
        } else {
            // Nếu thất bại, hiển thị thông báo lỗi
            model.addAttribute("errorMessage", response.getMessage());
            return "logon"; // Quay lại trang đăng nhập
        }
    }

    @GetMapping("/home")
    public String homePage() {
        return "home"; // Trả về tên file home.html
    }

    @GetMapping("/logon")
    public String logon(){
        return "logon";
    }

}
