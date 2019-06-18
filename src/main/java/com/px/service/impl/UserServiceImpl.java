package com.px.service.impl;/* *
 * @ Author: LJH
 * @ Date: 2019/6/12 9:01
 */

import com.px.dao.UserMapper;
import com.px.entity.User;
import com.px.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper mapper;

    @Override
    public User login(User user) {
        return mapper.login(user);
    }

    @Override
    public void register(User user) {
       mapper.register(user);
    }

    @Override
    public void upload(User user) {
        mapper.upload(user);
    }
    @Override
    public User findByName(User user) {
        return mapper.findByName(user);
    }
}
