package com.blog.web.controller.admin.blog;

import com.blog.common.dto.blog.QueryBlogCondition;
import com.blog.common.entity.blog.Blog;
import com.blog.common.util.PagiNation;
import com.blog.service.blog.BlogService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
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
    public @ResponseBody JSONObject getBlogWithPage( QueryBlogCondition queryBlogCondition ){
        try {
            JSONArray jsonArray = new JSONArray();
            PagiNation pagiNation = new PagiNation();

            int dataCount = blogService.getBlogCount( queryBlogCondition ) ;
            int PageCount = pagiNation.getPageCount( dataCount, pageSize);
            int CurrentPage = queryBlogCondition.getPage();

            JSONObject json = new JSONObject();
            json.put("pageCount",PageCount);
            JSONObject currentPage = new JSONObject();
            json.put("currentPage",CurrentPage);

            List<Blog> blogs = blogService.getBlogs( queryBlogCondition , pageSize );

            for( Blog blog : blogs ) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put( "id" , blog.getId() );
                jsonObject.put( "title" , blog.getTitle() );
                jsonObject.put( "createTime" , blog.getCreateTime() );
                jsonObject.put( "clickCount" , blog.getClickCount() );
                jsonArray.add( jsonObject) ;
            }

            json.put("data",jsonArray);

            return json;
        }
        catch (Exception ee ){
            System.out.println( ee.getMessage() );
            return null;
        }
    }
}
