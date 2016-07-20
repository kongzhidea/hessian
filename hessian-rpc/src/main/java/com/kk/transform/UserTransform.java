package com.kk.transform;

import com.kk.api.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserTransform {
    public static User tran(com.kk.model.User user) {
        User ret = new User();
        ret.setId(user.getId());
        ret.setRealname(user.getRealname());
        ret.setMobile(user.getMobile());
        ret.setPassword(user.getPassword());
        ret.setSex(user.getSex());
        ret.setUptime(user.getUptime());
        ret.setUsername(user.getUsername());
        return ret;
    }

    public static List<User> tranList(List<com.kk.model.User> list) {
        List<User> ret = new ArrayList<User>();
        for (com.kk.model.User user : list) {
            ret.add(tran(user));
        }
        return ret;
    }
}
