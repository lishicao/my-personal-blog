package com.blog.common.dto.blog;

import java.util.Date;

/**
 * Created by lishi on 2015/10/6.
 */
public class QueryBlogCondition {
    Integer classificationId;
    Integer labelId;
    Integer page;

    public Integer getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Integer classificationId) {
        this.classificationId = classificationId;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
