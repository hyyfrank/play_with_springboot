package com.autodesk.www.services;

import com.autodesk.www.mapper.UserMapper;
import com.autodesk.www.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> selectAll(){
        return userMapper.findall();
    }
}
