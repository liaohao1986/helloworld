package com.huoli.checkin.effective;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年3月2日<br>
 */
public class PhoneNumber {

    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    /**
     * @param areaCode
     * @param prefix
     * @param lineNumber
     */
    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        super();
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
    }

    @Override
    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + areaCode;
//        result = prime * result + lineNumber;
//        result = prime * result + prefix;
//        return result;
        return 42;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof PhoneNumber))
            return false;
        if (getClass() != obj.getClass())
            return false;
        PhoneNumber other = (PhoneNumber) obj;
        if (areaCode != other.areaCode)
            return false;
        if (lineNumber != other.lineNumber)
            return false;
        if (prefix != other.prefix)
            return false;
        return true;
    }

}
