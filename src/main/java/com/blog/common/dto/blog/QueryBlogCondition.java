package com.blog.common.dto.blog;

import java.util.Date;

/**
 * Created by lishi on 2015/10/6.
 */
public class QueryBlogCondition {
    Integer classificationId;
    Integer page;
    String keyWord;


    public Integer getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Integer classificationId) {
        this.classificationId = classificationId;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
