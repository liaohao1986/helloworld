package com.huoli.checkin.serializer;

import java.io.IOException;
import java.io.InputStream;

public interface DeSerializer<T> {
    T deserialize(InputStream inputStream) throws IOException;
}
