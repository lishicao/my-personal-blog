package com.blog.service.blog;

import com.blog.common.dto.blog.QueryBlogCondition;
import com.blog.common.entity.blog.Blog;
import com.blog.mappers.blog.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * user: lishicao
 * date 15/10/16
 * time 上午12:26
 * 博客服务
 */
@Service
public class BlogService {
    @Autowired
    BlogMapper blogMapper;

    private String sendPost(String url, String param) throws Exception{
        URL realUrl = new URL(url);

        URLConnection connection = realUrl.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection)connection;

        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(param.length()));

        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;

        try {
            outputStream = httpURLConnection.getOutputStream();
            outputStreamWriter = new OutputStreamWriter(outputStream);

            outputStreamWriter.write(param.toString());
            outputStreamWriter.flush();

            if (httpURLConnection.getResponseCode() >= 300) {
                throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
            }

            inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);

            while ((tempLine = reader.readLine()) != null) {
                resultBuffer.append(tempLine);
            }
        } finally {
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            if (reader != null) {
                reader.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }

        }
        return resultBuffer.toString();

    }

    /**
     * 通过github的markdown的API把markdown格式转化成html
     * @param content
     * @return
     */
    public String getHtmlContent( String content) throws Exception{
        return sendPost("http://gfm-kyanny.sqale.jp/markdown/raw",content);
    }


    /**
     * 取得符合查询条件的博客数量
     * @param queryBlogCondition
     * @return
     * @throws Exception
     */
    public int getBlogCount( QueryBlogCondition queryBlogCondition ) throws Exception {
        return blogMapper.getBlogCount( queryBlogCondition.getClassificationId() ,queryBlogCondition.getKeyWord() );
    }

    /**
     * 博客分页
     * @param queryBlogCondition
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<Blog> getBlogs( QueryBlogCondition queryBlogCondition , Integer pageSize ) throws Exception {
        Integer classficationId = queryBlogCondition.getClassificationId();
        Integer start = (queryBlogCondition.getPage() -1) * pageSize;
        List<Blog> blogs = blogMapper.getBlogs( start, pageSize, classficationId,queryBlogCondition.getKeyWord());
        return blogs;
    }

    /**
     * 用ID查询某一个博客
     * @param id
     * @return
     * @throws Exception
     */
    public Blog getBlogById( Integer id ) throws Exception{
        Blog blog = blogMapper.getBlogById(id);
        return blog;
    }

    /**
     * 增加博客
     * @param blog
     */
    public void addBlog( Blog blog ) throws Exception{
        blog.setHtmlContent( getHtmlContent(blog.getContent()) );
        blogMapper.addBlog(blog);
    }

    /**
     * 删除博客
     * @param blogId
     * @throws Exception
     */
    public void deleteBlog( Integer blogId ) throws Exception{
        blogMapper.deleteBlog( blogId );
    }

    /**
     * 更新博客
     * @param blog
     * @throws Exception
     */
    public void updateBlog( Blog blog ) throws Exception{
        blog.setHtmlContent( getHtmlContent(blog.getContent()) );

        blogMapper.updateBlog( blog );
    }
}
