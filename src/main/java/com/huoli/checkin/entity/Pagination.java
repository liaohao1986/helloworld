/**
 * 
 */
package com.huoli.checkin.entity;

import java.util.List;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年3月17日<br>
 */

public class Pagination<T> {

    /** 列表每页显示条数 */
    private Integer pageSize = 8;

    /** 列表当前页 */
    private Integer currentPage = 1;

    /** 列表总页数 */
    private Integer totalPage = 1;

    /** 列表总数据量 */
    private Integer totalNumber = 0;

    /** 数据集 */
    private List items;

    public Integer getPageSize() {

        return pageSize;
    }
}
