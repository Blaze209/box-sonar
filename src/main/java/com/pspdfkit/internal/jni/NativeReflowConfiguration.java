package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeReflowConfiguration {

    public static final class CppProxy extends NativeReflowConfiguration {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeReflowConfiguration create(NativeDocument nativeDocument);

        private native void nativeDestroy(long j);

        private native void native_disableRemoveHeadersFooters(long j);

        private native void native_enableRemoveHeadersFooters(long j, int i);

        private native NativeDocument native_getDocument(long j);

        private native String native_getImagesPath(long j);

        private native boolean native_getIncludeImages(long j);

        private native Integer native_getNumberNeighboringPagesHeadersFooters(long j);

        private native void native_setIncludeImages(long j, boolean z, String str);

        private native boolean native_shouldRemoveHeadersFooters(long j);

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

        @Override // com.pspdfkit.internal.jni.NativeReflowConfiguration
        public void disableRemoveHeadersFooters() {
            native_disableRemoveHeadersFooters(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeReflowConfiguration
        public void enableRemoveHeadersFooters(int i) {
            native_enableRemoveHeadersFooters(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeReflowConfiguration
        public NativeDocument getDocument() {
            return native_getDocument(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeReflowConfiguration
        public String getImagesPath() {
            return native_getImagesPath(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeReflowConfiguration
        public boolean getIncludeImages() {
            return native_getIncludeImages(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeReflowConfiguration
        public Integer getNumberNeighboringPagesHeadersFooters() {
            return native_getNumberNeighboringPagesHeadersFooters(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeReflowConfiguration
        public void setIncludeImages(boolean z, String str) {
            native_setIncludeImages(this.nativeRef, z, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeReflowConfiguration
        public boolean shouldRemoveHeadersFooters() {
            return native_shouldRemoveHeadersFooters(this.nativeRef);
        }
    }

    public static NativeReflowConfiguration create(NativeDocument nativeDocument) {
        return CppProxy.create(nativeDocument);
    }

    public abstract void disableRemoveHeadersFooters();

    public abstract void enableRemoveHeadersFooters(int i);

    public abstract NativeDocument getDocument();

    public abstract String getImagesPath();

    public abstract boolean getIncludeImages();

    public abstract Integer getNumberNeighboringPagesHeadersFooters();

    public abstract void setIncludeImages(boolean z, String str);

    public abstract boolean shouldRemoveHeadersFooters();
}
