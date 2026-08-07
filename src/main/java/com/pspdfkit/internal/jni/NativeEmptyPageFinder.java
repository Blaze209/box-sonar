package com.pspdfkit.internal.jni;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeEmptyPageFinder {

    public static final class CppProxy extends NativeEmptyPageFinder {
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native HashSet<Integer> findEmptyPages(NativeDocument nativeDocument, EnumSet<NativeEmptyPageFinderOptions> enumSet);

        private native void nativeDestroy(long j);

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

    public static HashSet<Integer> findEmptyPages(NativeDocument nativeDocument, EnumSet<NativeEmptyPageFinderOptions> enumSet) {
        return CppProxy.findEmptyPages(nativeDocument, enumSet);
    }
}
