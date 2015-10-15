package com.blog.mappers.blog;

import com.blog.common.entity.blog.BlogClassification;
import org.springframework.stereotype.Repository;

/**
 * user: lishicao
 * date 15/10/16
 * time 上午12:28
 */
@Repository
public interface ClassificationMapper {
    public BlogClassification getBlogClassificationById( Integer id ) throws Exception;
}
