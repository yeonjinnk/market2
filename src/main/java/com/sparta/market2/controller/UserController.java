package com.sparta.market2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/registBoard")
    public String post() {
        return "registBoard";
    }
}
