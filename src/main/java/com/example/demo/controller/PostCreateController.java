package com.example.demo.controller;

import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PostCreateController {

    @Autowired
    PostService postsService;

    @RequestMapping(path = "/new",method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("appName", "Создание поста");
        return "create";
    }
    @RequestMapping(path = "/new",method = RequestMethod.POST)
    public String doCreate(@ModelAttribute("text") String text){
        //System.out.println(text);
        postsService.create(text);
        return"redirect:/main";
    }

}
