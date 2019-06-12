package com.px.serivce;/* *
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

    void upload(String path);
}
