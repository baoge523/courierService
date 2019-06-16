package com.px.dao;/* *
 * @ Author: LJH
 * @ Date: 2019/6/16 13:39
 */

import com.px.entity.Detail;

public interface DetailMapper {
    /**
     * 骑手接单
     * @param detail
     */
    void receiver(Detail detail);
}
