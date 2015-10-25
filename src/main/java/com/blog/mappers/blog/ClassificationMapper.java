package com.blog.mappers.blog;

import com.blog.common.entity.blog.BlogClassification;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * user: lishicao
 * date 15/10/16
 * time 上午12:28
 */
@Repository
public interface ClassificationMapper {
    public void deleteBlogClassification( Integer id ) throws Exception;
    public void updateBlogClassification( BlogClassification blogClassification) throws Exception;
    public void addBlogClassification( BlogClassification blogClassification) throws Exception;
    public BlogClassification getBlogClassificationById( Integer id ) throws Exception;
    public BlogClassification getBlogClassificationByName( String name ) throws Exception;
    public List<BlogClassification> getBlogClassifications() throws Exception;
}
