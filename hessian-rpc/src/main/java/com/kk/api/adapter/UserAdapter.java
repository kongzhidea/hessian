package com.kk.api.adapter;

import com.caucho.services.server.Service;
import com.kk.api.model.User;
import com.kk.api.service.IUserAdapter;
import com.kk.service.UserService;
import com.kk.transform.UserTransform;
import com.kk.util.ApplicationContextHelper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

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
}
