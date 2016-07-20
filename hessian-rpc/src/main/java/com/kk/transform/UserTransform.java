package com.kk.transform;

import com.kk.api.model.User;

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
}
