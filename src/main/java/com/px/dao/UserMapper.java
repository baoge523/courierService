package com.px.dao;

import com.px.entity.User;

/**
 * @author 宝哥
 * @date 2019/6/11
 * TODO
 */
public interface UserMapper {

    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     *用户注册
     * @param user
     */
    void register(User user);


    void upload(String path);
}
