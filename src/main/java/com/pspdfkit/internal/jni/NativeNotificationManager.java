package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeNotificationManager {

    public static final class CppProxy extends NativeNotificationManager {
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        private native void nativeDestroy(long j);

        public static native void registerCoreNotificationHandler(NativeDocument nativeDocument, NativeCoreNotificationHandler nativeCoreNotificationHandler);

        public static native void sendTestNotification(NativeDocument nativeDocument, String str);

        public static native void unregisterCoreNotificationHandler(NativeCoreNotificationHandler nativeCoreNotificationHandler);

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

    public static void registerCoreNotificationHandler(NativeDocument nativeDocument, NativeCoreNotificationHandler nativeCoreNotificationHandler) {
        CppProxy.registerCoreNotificationHandler(nativeDocument, nativeCoreNotificationHandler);
    }

    public static void sendTestNotification(NativeDocument nativeDocument, String str) {
        CppProxy.sendTestNotification(nativeDocument, str);
    }

    public static void unregisterCoreNotificationHandler(NativeCoreNotificationHandler nativeCoreNotificationHandler) {
        CppProxy.unregisterCoreNotificationHandler(nativeCoreNotificationHandler);
    }
}
