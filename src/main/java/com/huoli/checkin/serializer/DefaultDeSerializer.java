/**
 * 
 */
package com.huoli.checkin.serializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import org.springframework.core.NestedIOException;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年5月26日<br>
 */
public class DefaultDeSerializer implements DeSerializer<Object> {

    @Override
    public Object deserialize(InputStream inputStream) throws IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        try {
            return objectInputStream.readObject();
        } catch (ClassNotFoundException ex) {
            throw new NestedIOException("Failed to deserialize object type", ex);
        }
    }

}
