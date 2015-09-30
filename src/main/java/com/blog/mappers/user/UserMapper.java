package com.blog.mappers.user;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * user: lishicao
 * date 15/9/28
 * time 上午10:51
 */
@Repository
@Transactional
public interface UserMapper {
    public String getPassword(@Param("username") String username ) throws Exception;
}
