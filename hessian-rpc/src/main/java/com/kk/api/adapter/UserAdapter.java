package com.kk.api.adapter;

import com.caucho.services.server.Service;
import com.kk.api.model.User;
import com.kk.api.param.UserParam;
import com.kk.api.service.IUserAdapter;
import com.kk.service.UserService;
import com.kk.transform.UserTransform;
import com.kk.util.ApplicationContextHelper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.util.List;

/**
 * 实现 Service接口会执行 初始化方法
 */
public class UserAdapter implements IUserAdapter, Service {
    UserService userService = ApplicationContextHelper.getBean(UserService.class);

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public void destroy() {
    }

    @Override
    public User getUser(int id) {
        com.kk.model.User user = userService.getUser(id);
        return UserTransform.tran(user);
    }

    @Override
    public List<User> getUserList(UserParam param, int start, int limit) {
        List<com.kk.model.User> list = userService.getUserList(param,start,limit);
        return UserTransform.tranList(list);
    }
}
