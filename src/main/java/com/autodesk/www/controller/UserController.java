package com.autodesk.www.controller;

import com.autodesk.www.model.CustomizeConfigPojo;
import com.autodesk.www.model.User;
import com.autodesk.www.services.UserService;
import com.autodesk.www.utils.JsonWrapResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

//@RestController=@Controller+@ResponseBody
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomizeConfigPojo customizeResources;

    @RequestMapping("/getAllUser")
    public User hello(){
        List<User> users= userService.selectAll();
        return users.get(0);
    }
    @RequestMapping("/getUserJson")
    public JsonWrapResult hallos(){
        CustomizeConfigPojo bean = new CustomizeConfigPojo();
        BeanUtils.copyProperties(customizeResources,bean);
        User user = new User();
        user.setName(bean.getCustomize_key1());
        user.setAge(19);
        return JsonWrapResult.ok(user);
    }
}
