package com.bookstore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.model.Users;


@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
    	System.out.println("im in homecontroller");
        return "home";
    }
   
    @RequestMapping("/about")
    public String about(){
        return "about";
    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession session){
    	session.removeAttribute("user");
        return "home";
    }
    
    @RequestMapping("/login")
    public String login(Model model)
    {
        
       Users user = new Users();
       model.addAttribute("user",user);
        return "login";
    }

}