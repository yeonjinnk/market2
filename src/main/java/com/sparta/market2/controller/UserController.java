package com.sparta.market2.controller;

import com.sparta.market2.entity.Product;
import com.sparta.market2.service.SellService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class UserController {
    private final SellService sellService;

    @GetMapping("/registBoard")
    public String post() {
        return "registBoard";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/view/{id}")
    public String viewPost(@PathVariable int id, Model model) {
        Product product = sellService.findProduct(id);
        System.out.println(product);
        model.addAttribute("product", product);
        model.addAttribute("id", product.getId());
        return "viewBoard";
    }
}
