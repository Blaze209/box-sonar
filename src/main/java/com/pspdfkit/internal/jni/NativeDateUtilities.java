package com.pspdfkit.internal.jni;

import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDateUtilities {

    public static final class CppProxy extends NativeDateUtilities {
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native Date iso8601ToPdfDate(String str);

        private native void nativeDestroy(long j);

        public static native String pdfDateToIso8601(Date date);

        public static native String pdfDateToString(Date date);

        public static native Date stringToPdfDate(String str);

        public void _djinni_private_destroy() {
            if (this.destroyed.getAndSet(true)) {
                return;
            }
            nativeDestroy(this.nativeRef);
        }

        public void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }
    }

    public static Date iso8601ToPdfDate(String str) {
        return CppProxy.iso8601ToPdfDate(str);
    }

    public static String pdfDateToIso8601(Date date) {
        return CppProxy.pdfDateToIso8601(date);
    }

    public static String pdfDateToString(Date date) {
        return CppProxy.pdfDateToString(date);
    }

    public static Date stringToPdfDate(String str) {
        return CppProxy.stringToPdfDate(str);
    }
}
