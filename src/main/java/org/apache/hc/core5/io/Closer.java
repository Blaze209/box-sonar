package org.apache.hc.core5.io;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public final class Closer {
    public static void close(Closeable closeable) throws IOException {
        if (closeable != null) {
            closeable.close();
        }
    }

    public static void close(ModalCloseable modalCloseable, CloseMode closeMode) {
        if (modalCloseable != null) {
            modalCloseable.close(closeMode);
        }
    }

    public static void closeQuietly(Closeable closeable) {
        try {
            close(closeable);
        } catch (IOException unused) {
        }
    }
}
