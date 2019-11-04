package com.autodesk.www.controller;


import com.autodesk.www.utils.JsonWrapResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("error")
public class ErrorController {

    @RequestMapping("/index")
    public String error() {
       return "in customize error.";
    }

}
