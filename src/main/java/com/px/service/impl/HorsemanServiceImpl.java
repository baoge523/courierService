package com.px.service.impl;/* *
 * @ Author: LJH
 * @ Date: 2019/6/12 9:01
 */

import com.px.dao.HorsemanMapper;
import com.px.entity.Horseman;
import com.px.service.HorsemanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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

    @Override
    public Horseman findByName(String hrsemanname) {
        return mapper.findByName(hrsemanname);
    }

    @Override
    public void upload(Horseman horseman) {
        mapper.upload(horseman);
    }

    @Override
    public List<Horseman> echo() {
        return mapper.echo();
    }


}
