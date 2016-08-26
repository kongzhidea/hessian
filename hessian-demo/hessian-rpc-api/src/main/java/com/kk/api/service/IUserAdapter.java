package com.kk.api.service;

import com.kk.api.model.User;
import com.kk.api.param.UserParam;

import java.util.List;

public interface IUserAdapter {
    User getUser(int id);

    List<User> getUserList(UserParam param, int start, int limit);
}
