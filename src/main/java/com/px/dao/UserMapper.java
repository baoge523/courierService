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

    /**
     * 上传图片
     * @param user
     */
    void upload(User user);

    /**
     * 通过session域中
     * @param user
     * @return
     */
     User findByName(User user);
    /**
     * user用户修改信息
     * @param user
     * @return
     */
    void changeByName(User user);

    /**
     * 通过session域中的username去查找用户的图片
     * @param username
     * @return
     */
    User findImg(String username);
}
