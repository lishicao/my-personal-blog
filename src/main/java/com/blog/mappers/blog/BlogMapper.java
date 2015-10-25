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
    public int getBlogCount( @Param("classificationId") Integer classificationId , @Param("keyword") String keyword ) throws Exception;
    public List<Blog> getBlogs( @Param("start")Integer start ,@Param("pageSize") Integer pageSize,@Param("classificationId") Integer classificationId ,@Param("keyword") String keyword) throws Exception;
    public Blog getBlogById( Integer id ) throws Exception;
    public Blog getBlogByTitleAndContent( @Param("title") String title , @Param("content") String content ) throws Exception;
    public void addBlog( Blog blog ) throws Exception;
    public void deleteBlog( Integer blogId) throws Exception;
    public void updateBlog( Blog blog ) throws Exception;
}
