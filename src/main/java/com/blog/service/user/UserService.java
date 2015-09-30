package com.blog.service.user;

import com.blog.mappers.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * user: lishicao
 * date 15/9/28
 * time 下午9:03
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
}
