package com.px.service.impl;/* *
 * @ Author: LJH
 * @ Date: 2019/6/16 13:40
 */

import com.px.dao.DetailMapper;
import com.px.entity.Detail;
import com.px.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailServiceImpl implements DetailService {
    @Autowired
    private DetailMapper mapper;
    @Override
    public void receiver(Detail detail) {
     mapper.receiver(detail);
    }
}
