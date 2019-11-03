package com.autodesk.www.controller;

import com.autodesk.www.services.PostService;
import com.autodesk.www.utils.JsonWrapResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class PostController2 {
    @Autowired
    private PostService postService;

    @RequestMapping("/test")
    public String Test(){
        return "test correct.";
    }
    @RequestMapping("/query")
    public JsonWrapResult testQuery() {
        return JsonWrapResult.ok(postService.findPost(1L));

    }


}