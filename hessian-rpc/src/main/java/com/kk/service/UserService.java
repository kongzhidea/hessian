package com.kk.service;

import com.kk.api.param.UserParam;
import com.kk.dao.UserDao;
import com.kk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User getUser(int id) {
        return userDao.getUser(id);
    }

    public List<User> getUserList(UserParam param, int start, int limit) {
        return userDao.getUserList(param, start, limit);
    }
}
