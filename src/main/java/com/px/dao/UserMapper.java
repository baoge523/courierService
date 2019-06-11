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
     * @param username
     * @return
     */
    User login(String username);

}
