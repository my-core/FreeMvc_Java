package com.freemvc.datacontract.request;

/**
 * Created by yangliangbin on 2016/9/12.
 */
public class BaseRequest {
    /**
     * 页索引
     */
    private int pageIndex = 1;
    /**
     * 每页大小
     */
    private int pageSize = 10;
    /**
     * 排序
     */
    private String orderBy;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
