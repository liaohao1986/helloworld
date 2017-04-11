/**
 * 
 */
package com.huoli.checkin.design.pattern.iterator;

import java.util.Arrays;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 自定义集合SimpleList<br>
 * 版权：Copyright (c) 2011-2017<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年4月11日<br>
 */
public class SimpleList<T> implements Iterable<T>, Iterator<T> {
    private static final Logger logger = LoggerFactory.getLogger(SimpleList.class);

    private Object[] elementData;

    public int size = 0;

    private static final int DEFAULT_CAPACITY = 10;

    private int cursor; // index of next element to return

    //    private static final Object[] EMPTY_ELEMENTDATA = {};

    public SimpleList() {
        this(DEFAULT_CAPACITY);
    }

    public SimpleList(int initialCapacity) {
        super();
        this.elementData = new Object[initialCapacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(T t) {
        ensureCapacityInternal(size + 1);
        elementData[size++] = t;
        return true;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) elementData[index];
    }

    private void ensureCapacityInternal(int minCapacity) {
        if (minCapacity - elementData.length > 0) {
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        logger.debug("扩容结果,oldCapacity:{},newCapacity:{}", oldCapacity, newCapacity);
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public boolean remove(T t) {
        for (int index = 0; index < size; index++)
            if (t.equals(elementData[index])) {
                remove(index);
                return true;
            }
        return false;
    }

    @SuppressWarnings("unchecked")
    public T remove(int index) {
        T oldValue = (T) elementData[index];
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        elementData[--size] = null; // clear to let GC do its work
        return oldValue;
    }

    public static void main(String[] args) {

        SimpleList<String> simpleList = new SimpleList<String>();
        for (int i = 0; i < 30; i++) {
            simpleList.add("liaohao" + i);
        }
        for (int i = 0; i < 20; i++) {
            simpleList.remove(0);
        }
        for (String str : simpleList) {
            logger.debug(str);
        }

    }

    @Override
    public boolean hasNext() {
        return cursor < size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T next() {
        return (T) elementData[cursor++];
    }

    @Override
    public void remove() {
    }

    @Override
    public Iterator<T> iterator() {
        return this;
    }
}
