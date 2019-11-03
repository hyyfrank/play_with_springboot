package com.autodesk.www.controller;

import com.autodesk.www.model.User;
import com.autodesk.www.services.UserService;
import com.autodesk.www.utils.JsonWrapResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public String Test(){
        return "test correct.";
    }
    @RequestMapping("/query")
    public JsonWrapResult testQuery() {
        return JsonWrapResult.ok(userService.selectUserByName("frank"));

    }

    @RequestMapping("/insert")
    public List<User> testInsert() {
        userService.insertService();
        return userService.selectAllUser();
    }


    @RequestMapping("/changemoney")
    public List<User> testchangemoney() {
        userService.changemoney();
        return userService.selectAllUser();
    }

    @RequestMapping("/delete")
    public String testDelete() {
        userService.deleteService(3);
        return "OK";
    }

}