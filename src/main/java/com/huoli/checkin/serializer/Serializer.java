package com.huoli.checkin.serializer;

import java.io.IOException;
import java.io.OutputStream;

public interface Serializer<T> {

    void serialize(T object, OutputStream outputStream) throws IOException;

}
