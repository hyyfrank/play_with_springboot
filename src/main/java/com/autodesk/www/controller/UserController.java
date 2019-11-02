package com.autodesk.www.controller;

import com.autodesk.www.model.CustomizeConfigPojo;
import com.autodesk.www.model.User;
import com.autodesk.www.utils.JsonWrapResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
//@RestController=@Controller+@ResponseBody
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private CustomizeConfigPojo customizeResources;

    @RequestMapping("/getUser")
    public User hello(){
        User user = new User();
        user.setName("frank1");
        user.setAge(19);
        user.setBirthday(new Date());
        user.setPassword("12345");
        user.setDesc("description of user frank");
        return user;
    }
    @RequestMapping("/getUserJson")
    public JsonWrapResult hallos(){
        CustomizeConfigPojo bean = new CustomizeConfigPojo();
        BeanUtils.copyProperties(customizeResources,bean);
        User user = new User();
        user.setName(bean.getCustomize_key1());
        user.setAge(19);
        user.setBirthday(new Date());
        user.setPassword("12345");
        user.setDesc("description of user frank");
        return JsonWrapResult.ok(user);
    }
}
