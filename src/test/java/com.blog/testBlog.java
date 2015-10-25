package com.blog;

import com.blog.service.blog.BlogService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * user: lishicao
 * date 15/10/21
 * time 上午12:21
 */

public class testBlog {
    @Autowired
    BlogService blogService;

    @Test
    public void testMarkDown(){
//        String result = blogService.getHtmlContent("##cool");
//        System.out.println( result);
    }

}
