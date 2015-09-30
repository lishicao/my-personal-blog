package com.blog.web.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * user: lishicao
 * date 15/9/28
 * time 下午6:21
 */
@Controller
public class IndexController {
    @RequestMapping(value = "" , method = RequestMethod.GET)
    public String index( Model model ){
        return "index";
    }
}
