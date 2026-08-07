package org.apache.hc.core5.io;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.SocketOption;

/* JADX INFO: loaded from: classes5.dex */
public class SocketSupport {
    public static final String TCP_KEEPCOUNT = "TCP_KEEPCOUNT";
    public static final String TCP_KEEPIDLE = "TCP_KEEPIDLE";
    public static final String TCP_KEEPINTERVAL = "TCP_KEEPINTERVAL";

    public static <T> SocketOption<T> getExtendedSocketOptionOrNull(String str) {
        try {
            return (SocketOption) Class.forName("jdk.net.ExtendedSocketOptions").getField(str).get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> void setOption(T t, String str, T t2) throws IOException {
        try {
            Method method = t.getClass().getMethod("setOption", SocketOption.class, Object.class);
            SocketOption extendedSocketOptionOrNull = getExtendedSocketOptionOrNull(str);
            if (extendedSocketOptionOrNull == null) {
                throw new UnsupportedOperationException("Extended socket option not supported: " + str);
            }
            method.invoke(t, extendedSocketOptionOrNull, t2);
        } catch (UnsupportedOperationException e) {
            throw e;
        } catch (Exception e2) {
            throw new IOException("Failure setting extended socket option", e2);
        }
    }
}
