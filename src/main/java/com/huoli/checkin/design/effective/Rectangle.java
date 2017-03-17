/**
 * 
 */
package com.huoli.checkin.design.effective;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年3月3日<br>
 */
public class Rectangle extends Figure {
    final double width;
    final double height;

    /**
     * @param width
     * @param height
     */
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /** 
     * @return
     * @see com.huoli.checkin.design.effective.Figure#area()
     */
    @Override
    double area() {
        return width * height;
    }

}
