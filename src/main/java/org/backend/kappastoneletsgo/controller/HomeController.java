package org.backend.kappastoneletsgo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Forums Home");
        return "index"; }
}
