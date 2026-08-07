package com.pspdfkit.internal;

import java.io.Closeable;

/* JADX INFO: loaded from: classes3.dex */
public final class xg {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
