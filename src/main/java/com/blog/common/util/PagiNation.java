package com.blog.common.util;

/**
 * user: lishicao
 * date 15/10/10
 * time 下午10:25
 */
public class PagiNation {
    public int getPageCount( int dataCount , int pageSize ){
        int pageCount;
        if( dataCount % pageSize == 0 ) {
            pageCount = dataCount / pageSize;
        }else {
            pageCount = dataCount / pageSize + 1 ;
        }
        return pageCount;
    }
}
