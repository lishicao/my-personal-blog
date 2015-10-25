package com.blog.web.controller.admin.index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lishi on 2015/10/5.
 */
@Controller
@RequestMapping( value = "admin")
public class AdminIndexController {
    @RequestMapping(value = "/index" )
    public String index( Model model){
        return "redirect:/admin/toListBlog";
    }
}
