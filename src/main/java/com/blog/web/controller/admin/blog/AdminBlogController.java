package com.blog.web.controller.admin.blog;

import com.blog.common.dto.blog.QueryBlogCondition;
import com.blog.common.entity.blog.Blog;
import com.blog.common.entity.blog.BlogClassification;
import com.blog.common.util.PagiNation;
import com.blog.service.blog.BlogService;
import com.blog.service.blog.ClassificationService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by lishi on 2015/10/5.
 */
@Controller
@RequestMapping( value = "admin")
public class AdminBlogController {

    @Autowired
    BlogService blogService;
    @Autowired
    ClassificationService classificationService;

    Integer pageSize = 8 ;

    @RequestMapping( value = "/listBlog")
    public @ResponseBody JSONObject getBlogsWithPage( QueryBlogCondition queryBlogCondition ){
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
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date date=blog.getCreateTime();
                String createTime=sdf.format(date);

                JSONObject jsonObject = new JSONObject();
                jsonObject.put( "id" , blog.getId() );
                jsonObject.put( "title" , blog.getTitle() );
                jsonObject.put( "createTime" , createTime );
                jsonObject.put( "clickCount" , blog.getClickCount() );
                jsonArray.add( jsonObject) ;
            }

            json.put("list",jsonArray);

            return json;
        }
        catch (Exception ee ){
            System.out.println( ee.getMessage() );
            return null;
        }
    }

    @RequestMapping( value = "/detailBlog")
    public String detailBlog( Model model ,int blogId ){
        try {
            Blog blog = blogService.getBlogById(blogId);
            BlogClassification blogClassification = classificationService.getBlogClassificationById(blog.getClassificationId());
            String classification = "";
            if( blogClassification != null ) classification = blogClassification.getClassificationName();
            model.addAttribute("id",blog.getId());
            model.addAttribute("title",blog.getTitle());
            model.addAttribute("content",blog.getHtmlContent());
            model.addAttribute("createTime",blog.getCreateTime());
            model.addAttribute("clickCount",blog.getClickCount());
            model.addAttribute("labels",blog.getLabels());
            model.addAttribute("classification",classification);
            return "admin/blog/detail";
        }
        catch (Exception ee ){
            model.addAttribute("errorMessage",ee.getMessage());
            return "error";
        }
    }
}
