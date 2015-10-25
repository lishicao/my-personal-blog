package com.blog.service.blog;

import com.blog.common.entity.blog.BlogClassification;
import com.blog.mappers.blog.ClassificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * user: lishicao
 * date 15/10/16
 * time 上午12:26
 * 博客分类
 */
@Service
public class ClassificationService {
    @Autowired
    ClassificationMapper classificationMapper;

    /**
     * 删除一个分类
     * @param id
     * @throws Exception
     */
    public void deleteBlogClassification( Integer id ) throws Exception{
        if( classificationMapper.getBlogClassificationById(id)!=null){
            classificationMapper.deleteBlogClassification(id);
        }
    }

    /**
     * 更新分类
     * @param blogClassification
     * @throws Exception
     */
    public void updateBlogClassification( BlogClassification blogClassification ) throws Exception{
        if( classificationMapper.getBlogClassificationById(blogClassification.getId())!=null){
            classificationMapper.updateBlogClassification(blogClassification);
        }
    }

    /**
     * 增加分类
     * @param blogClassification
     * @throws Exception
     */
    public void addBlogClassification( BlogClassification blogClassification ) throws Exception{
        if( classificationMapper.getBlogClassificationByName(blogClassification.getClassificationName()) == null){
            classificationMapper.addBlogClassification(blogClassification);
        }
    }

    /**
     * list分类
     * @return
     * @throws Exception
     */
    public List<BlogClassification> getBlogClassifications() throws Exception{
        return classificationMapper.getBlogClassifications();
    }

    /**
     * 根据某个id查找分类
     * @param id
     * @return
     * @throws Exception
     */
    public BlogClassification getBlogClassificationById( Integer id ) throws Exception{
        return classificationMapper.getBlogClassificationById(id);
    }
}
