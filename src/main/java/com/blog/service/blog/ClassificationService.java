package com.blog.service.blog;

import com.blog.common.entity.blog.BlogClassification;
import com.blog.mappers.blog.ClassificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * user: lishicao
 * date 15/10/16
 * time 上午12:26
 */
@Service
public class ClassificationService {
    @Autowired
    ClassificationMapper classificationMapper;
    public BlogClassification getBlogClassificationById( Integer id ) throws Exception{
        return classificationMapper.getBlogClassificationById(id);
    }
}
