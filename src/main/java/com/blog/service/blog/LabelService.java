package com.blog.service.blog;

import com.blog.common.entity.blog.Label;
import com.blog.mappers.blog.LabelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * user: lishicao
 * date 15/10/16
 * time 上午12:26
 */
@Service
public class LabelService {
    @Autowired
    LabelMapper labelMapper;
    public List<Label> getLabels( int blogId) throws Exception{
        return labelMapper.getLabels( blogId );
    }
}
