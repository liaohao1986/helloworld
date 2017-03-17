/**
 * 
 */
package com.huoli.checkin.design.pattern.collections;

import java.util.Collection;
import java.util.HashSet;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年3月3日<br>
 */
public class InstrumentHashSet<E> extends HashSet<E> {

    private int addCount = 0;

    public InstrumentHashSet() {
        super();
    }

    public InstrumentHashSet(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
//        addCount += c.size();
        for (E e : c) {
            add(e);
        }
        return true;
//        return super.addAll(c);
    }

    public int getAddAcount() {
        return addCount;
    }

}
