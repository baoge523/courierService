package com.px.service;/* *
 * @ Author: LJH
 * @ Date: 2019/6/16 13:40
 */

import com.px.entity.Detail;

public interface DetailService {
    /**
     * 骑手接单
     * @param detail
     */
    void receiver(Detail detail);
}
