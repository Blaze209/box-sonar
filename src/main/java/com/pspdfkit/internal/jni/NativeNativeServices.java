package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeNativeServices {
    public static final String KEY_MEMORY_NOTIFICATION_LEVEL = "MemoryNotificationLevel";
    public static final String LOW_MEMORY_NOTIFICATION = "LowMemoryNotification";

    public static final class CppProxy extends NativeNativeServices {
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native void deinit();

        public static native NativeApplicationService getApplicationServices();

        public static native NativeLocalizationService getLocalizationService();

        public static native NativePlatformThreads getThreadService();

        public static native NativeUnicodeService getUnicodeService();

        public static native void init(NativeApplicationService nativeApplicationService, NativeUnicodeService nativeUnicodeService, NativePlatformThreads nativePlatformThreads, NativeLocalizationService nativeLocalizationService);

        public static native void memoryNotification(NativeMemoryNotificationLevel nativeMemoryNotificationLevel);

        private native void nativeDestroy(long j);

        public static native void setSystemShapingLanguage(String str);

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

    public static void deinit() {
        CppProxy.deinit();
    }

    public static NativeApplicationService getApplicationServices() {
        return CppProxy.getApplicationServices();
    }

    public static NativeLocalizationService getLocalizationService() {
        return CppProxy.getLocalizationService();
    }

    public static NativePlatformThreads getThreadService() {
        return CppProxy.getThreadService();
    }

    public static NativeUnicodeService getUnicodeService() {
        return CppProxy.getUnicodeService();
    }

    public static void init(NativeApplicationService nativeApplicationService, NativeUnicodeService nativeUnicodeService, NativePlatformThreads nativePlatformThreads, NativeLocalizationService nativeLocalizationService) {
        CppProxy.init(nativeApplicationService, nativeUnicodeService, nativePlatformThreads, nativeLocalizationService);
    }

    public static void memoryNotification(NativeMemoryNotificationLevel nativeMemoryNotificationLevel) {
        CppProxy.memoryNotification(nativeMemoryNotificationLevel);
    }

    public static void setSystemShapingLanguage(String str) {
        CppProxy.setSystemShapingLanguage(str);
    }
}
