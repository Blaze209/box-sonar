package com.pspdfkit.instant.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeAssetManager {

    public static final class CppProxy extends NativeAssetManager {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        private native void nativeDestroy(long j);

        private native NativeAssetResult native_assetForIdentifier(long j, String str);

        private native NativeAssetResult native_importData(long j, byte[] bArr, String str);

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

        @Override // com.pspdfkit.instant.internal.jni.NativeAssetManager
        public NativeAssetResult assetForIdentifier(String str) {
            return native_assetForIdentifier(this.nativeRef, str);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeAssetManager
        public NativeAssetResult importData(byte[] bArr, String str) {
            return native_importData(this.nativeRef, bArr, str);
        }
    }

    public abstract NativeAssetResult assetForIdentifier(String str);

    public abstract NativeAssetResult importData(byte[] bArr, String str);
}
