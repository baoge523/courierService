package com.px.dao;/* *
 * @ Author: LJH
 * @ Date: 2019/6/12 9:03
 */

import com.px.entity.Horseman;

public interface HorsemanMapper {
    /**
     * 用户登录
     * @param horseman
     * @return
     */
    Horseman login(Horseman horseman);

    /**
     * 用户注册
     * @param horseman
     */
    void register(Horseman horseman);

    void upload(String path);
}
