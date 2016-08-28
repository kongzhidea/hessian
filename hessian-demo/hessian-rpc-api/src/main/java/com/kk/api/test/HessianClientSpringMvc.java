package com.kk.api.test;

import com.caucho.hessian.client.HessianProxyFactory;
import com.kk.api.model.User;
import com.kk.api.param.UserParam;
import com.kk.api.service.IUserAdapter;

import java.net.MalformedURLException;
import java.util.List;

/**
 * 对应hessian-sringmvc 工程
 */
public class HessianClientSpringMvc {

    public static void main(String[] args) throws MalformedURLException {
        {
            //在服务器端的web.xml文件中配置的HessianServlet映射的访问URL地址
            String url = "http://127.0.0.1:8080/userAdapter";
            HessianProxyFactory factory = new HessianProxyFactory();
            // 设置 用户名和密码
            factory.setUser("kk");
            factory.setPassword("kong");

            IUserAdapter service = (IUserAdapter) factory.create(IUserAdapter.class, url);//创建IService接口的实例对象
            User user = service.getUser(195);//调用Hessian服务器端的ServiceImpl类中的getUser方法来获取一个User对象
            System.out.println(user);

            UserParam param = new UserParam();
            param.setId(195);
            param.setRealname("孔");
            List<User> userList = service.getUserList(param, 0, 10);
            System.out.println(userList);
        }
    }
}