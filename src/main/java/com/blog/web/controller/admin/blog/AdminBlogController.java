package com.blog.web.controller.admin.blog;

import com.blog.common.dto.blog.QueryBlogCondition;
import com.blog.common.entity.blog.Blog;
import com.blog.service.blog.BlogService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lishi on 2015/10/5.
 */
@Controller
@RequestMapping( value = "admin")
public class AdminBlogController {

    @Autowired
    BlogService blogService;

    Integer pageSize = 10 ;

    @RequestMapping( value = "listBlog")
    public @ResponseBody JSONArray getBlogWithPage( QueryBlogCondition queryBlogCondition ){
        try {
            JSONArray jsonArray = new JSONArray();

            int dataCount = blogService.getBlogCount( queryBlogCondition ) ;
            List<Blog> blogs = blogService.getBlogs( queryBlogCondition , pageSize );

            for( int i = 0 ; i < blogs.size() ; i ++ ) {

            }

            return jsonArray;
        }
        catch (Exception ee ){
            System.out.println( ee.getMessage() );
            return null;
        }
    }
}
