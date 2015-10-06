package com.blog.mappers.blog;

import com.blog.common.dto.blog.QueryBlogCondition;
import com.blog.common.entity.blog.Blog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * user: lishicao
 * date 15/9/28
 * time 上午10:39
 */
@Repository
@Transactional
public interface BlogMapper {

    public int getBlogCount( @Param("classificationId") Integer classificationId ,@Param("labelId") Integer labelId ) throws Exception;
    public List<Blog> getBlogs( @Param("start")Integer start ,@Param("pageSize") Integer pageSize,@Param("classificationId") Integer classificationId ,@Param("labelId") Integer labelId ) throws Exception;
}
