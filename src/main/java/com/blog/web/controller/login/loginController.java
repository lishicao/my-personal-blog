package com.blog.web.controller.login;


import com.blog.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * user: lishicao
 * date 15/9/28
 * time 上午12:52
 */
@Controller
@RequestMapping( "" )
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/toLogin" , method = RequestMethod.GET)
    public String toLogin( Model model){
        return "/login/login";
    }

    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public String login( String username , String password , Model model , HttpSession session ){
        try {
            if (loginService.varifyUser(username, password) == true) {
                session.setAttribute("username",username);
                return "/admin/index";
            }
            else return "/login/login";

        }catch (Exception ee ){
            return "/error";
        }
    }
}
