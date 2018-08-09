package com.xwenyuan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * root url and others
 * @author xwenyuan
 *
 */
@Controller
public class IndexController {
    
    /**
     * website root request
     * @return
     */
    @RequestMapping("/")
    public ModelAndView root() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "首页");
        mav.setViewName("index");
        return mav;
    }
    
    /**
     * login request
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "/login";
    }
    
    /**
     * enter background management request
     * @return
     */
    @RequestMapping("/admin")
    public String toAdmin() {
        return "/admin/main";
    }

}
