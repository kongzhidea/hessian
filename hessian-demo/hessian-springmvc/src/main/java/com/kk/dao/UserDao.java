package com.kk.dao;

import com.kk.api.param.UserParam;
import com.kk.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatisRepository
public interface UserDao {

    public User getUser(int id);

    List<User> getUserList(@Param("param") UserParam param,
                           @Param("start") int start,
                           @Param("limit") int limit);
}
