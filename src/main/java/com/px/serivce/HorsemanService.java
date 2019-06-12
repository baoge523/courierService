package com.px.serivce;/* *
 * @ Author: LJH
 * @ Date: 2019/6/12 9:00
 */

import com.px.entity.Horseman;

public interface HorsemanService {
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
}
