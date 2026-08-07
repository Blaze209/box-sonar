package com.microsoft.identity.common.internal.util;

import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.exception.TerminalException;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes14.dex */
public class CommonMoshiJsonAdapter {
    private final Moshi mMoshi = new Moshi.Builder().build();

    public <T> String toJson(T t) {
        if (t == null) {
            throw new NullPointerException("obj is marked non-null but is null");
        }
        return this.mMoshi.adapter((Type) t.getClass()).toJson(t);
    }

    public <T> T fromJson(String str, Class<T> cls) throws TerminalException {
        if (str == null) {
            throw new NullPointerException("json is marked non-null but is null");
        }
        if (cls == null) {
            throw new NullPointerException("classOfT is marked non-null but is null");
        }
        try {
            return this.mMoshi.adapter((Class) cls).fromJson(str);
        } catch (IOException e) {
            throw new TerminalException(e.getMessage(), e, ErrorStrings.JSON_DESERIALIZATION_FAILURE);
        }
    }
}
