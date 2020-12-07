package com.study.controller;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class Hello {
    
    @RequestMapping("/now")
    @ResponseBody
    public String now() {
        return "now : " + new Date();
    }
    
    @RequestMapping("/now_page")
    public String nowPage() {
        return "now_page"; // 執行 now_page.jsp
    }
    
    
}
