package com.px.serivce.Impl;/* *
 * @ Author: LJH
 * @ Date: 2019/6/12 9:01
 */

import com.px.dao.HorsemanMapper;
import com.px.entity.Horseman;
import com.px.serivce.HorsemanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HorsemanServiceImpl implements HorsemanService {
    @Autowired
    private HorsemanMapper mapper;

    @Override
    public Horseman login(Horseman horseman) {
        return mapper.login(horseman);
    }

    @Override
    public void register(Horseman horseman) {
       mapper.register(horseman);
    }
}
