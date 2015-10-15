package com.blog.mappers.blog;

import com.blog.common.entity.blog.Label;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * user: lishicao
 * date 15/10/16
 * time 上午12:27
 */
@Repository
@Transactional
public interface LabelMapper {
    public List<Label> getLabels( @Param("blogId")Integer blogId ) throws Exception;
}
