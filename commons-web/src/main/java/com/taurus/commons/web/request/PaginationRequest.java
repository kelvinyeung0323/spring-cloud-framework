package com.taurus.commons.web.request;


import java.util.HashMap;

/**
 * @author: Kelvin Yeung
 * @createdAt: 2018/9/26
 * @description:
 */
public class PaginationRequest<T> extends HashMap<String,Object>{
    /**每页记录数**/
    private Integer pageSize;
    /**页码*/
    private Integer pageNum;
    /**排序*/
    private String sort;

    private T object;


    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
