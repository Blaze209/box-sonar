package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeCore {

    public static final class CppProxy extends NativeCore {
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native void destroyCore();

        public static native ArrayList<String> getConfiguredFontPaths();

        public static native void initCore(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3);

        public static native void initCoreWithSystemFontsControl(ArrayList<String> arrayList, boolean z, ArrayList<String> arrayList2, ArrayList<String> arrayList3);

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

    public static void destroyCore() {
        CppProxy.destroyCore();
    }

    public static ArrayList<String> getConfiguredFontPaths() {
        return CppProxy.getConfiguredFontPaths();
    }

    public static void initCore(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3) {
        CppProxy.initCore(arrayList, arrayList2, arrayList3);
    }

    public static void initCoreWithSystemFontsControl(ArrayList<String> arrayList, boolean z, ArrayList<String> arrayList2, ArrayList<String> arrayList3) {
        CppProxy.initCoreWithSystemFontsControl(arrayList, z, arrayList2, arrayList3);
    }
}
