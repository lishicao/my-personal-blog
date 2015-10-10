package com.blog.service.blog;

import com.blog.common.dto.blog.QueryBlogCondition;
import com.blog.common.entity.blog.Blog;
import com.blog.mappers.blog.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lishi on 2015/10/7.
 */
@Service
public class BlogService {
    @Autowired
    BlogMapper blogMapper;
    public int getBlogCount( QueryBlogCondition queryBlogCondition ) throws Exception {
        return blogMapper.getBlogCount( queryBlogCondition.getClassificationId() , queryBlogCondition.getLabelId() );
    }

    public List<Blog> getBlogs( QueryBlogCondition queryBlogCondition , Integer pageSize ) throws Exception {
        Integer classficationId = queryBlogCondition.getClassificationId();
        Integer labelId = queryBlogCondition.getLabelId();
        Integer start = (queryBlogCondition.getPage() -1) * pageSize;

        List<Blog> blogs = blogMapper.getBlogs( start, pageSize, classficationId, labelId);
        for( Blog blog : blogs){
            blog.setLabels( blogMapper.getLabels(blog.getId()) );
        }

        return blogMapper.getBlogs( start, pageSize, classficationId, labelId);
    }
}
