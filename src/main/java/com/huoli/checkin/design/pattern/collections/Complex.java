/**
 * 
 */
package com.huoli.checkin.design.pattern.collections;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年3月3日<br>
 */
public class Complex {
    private final double re;

    private final double im;

    private int hash;

    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
    }

    @Override
    public int hashCode() {
        int result = hash;
        if (result == 0) {
            final int prime = 31;
            result = 1;
            result = prime * result + hash;
            long temp;
            temp = Double.doubleToLongBits(im);
            result = prime * result + (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(re);
            result = prime * result + (int) (temp ^ (temp >>> 32));
            hash = result;
        }
        return result;
    }

}
