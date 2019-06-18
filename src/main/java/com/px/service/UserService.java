package com.px.service;/* *
 * @ Author: LJH
 * @ Date: 2019/6/12 8:59
 */

import com.px.entity.User;

public interface UserService {
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

    /**
     * 上传图片
     * @param user
     */
    void upload(User user);

    /**
     * 通过session中的用户名去查找用户信息
     * @param user
     * @return
     */
    User findByName(User user);
}
