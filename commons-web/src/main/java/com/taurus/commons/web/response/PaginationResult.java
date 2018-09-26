package com.taurus.commons.web.response;

import java.util.List;

/**
 * @author: Kelvin Yeung
 * @createdAt: 2018/9/26
 * @description:
 */
public class PaginationResult extends ResponseResult {

    /**总记录数*/
    private Long totalSize;
    /**页面大小*/
    private Integer pageSize;
    /**当前页实际有多少条记录*/
    private Integer size;

    /**页码，从1开始*/
    private Integer pageNum;
    /**总页数**/
    private Integer pages;


    public PaginationResult() {

    }



    public <T> PaginationResult(T list, String message) {
        //按需具体实现
        //以下是PageHelper的实现
        //com.github.pagehelper.Page
//        if (list instanceof Page) {
//            Page<Object> page = (Page<Object>) list;
//            this.pageNum = page.getPageNum();
//            this.pageSize = page.getPageSize();
//            this.totalSize = page.getTotal();
//            this.pages = page.getPages();
//            this.size = page.size();
//        }
        this.setData(list);
        this.setMessage(message);

    }


    //-------------------------------------------------------------
    //static method

    private PaginationResult build(Long totalSize, Integer pageSize, Integer pageNum, List list, String message){
        this.totalSize = totalSize;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        if(null !=totalSize && null!=pageSize){
            this.pages=  Double.valueOf(Math.ceil(totalSize*1.0/pageSize)).intValue();
        }
        if(null!=list){
            this.size = list.size();
        }
        this.setData(list);
        this.setMessage(message);
        return this;
    }


    public static PaginationResult page(Long totalSize, Integer pageSize, Integer pageNum, List list){
       return page(totalSize,pageSize,pageNum,list,null);
    }

    public static PaginationResult page(Long totalSize, Integer pageSize, Integer pageNum, List list, String message){
        return new PaginationResult().build(totalSize,pageSize,pageNum,list,message);
    }


    //-------------------------------------------------------------
    //Getter and Setter

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }


    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }



}
