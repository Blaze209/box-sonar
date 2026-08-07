package com.pspdfkit.internal.jni;

import android.graphics.Bitmap;
import android.graphics.RectF;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativePage {

    public static final class CppProxy extends NativePage {
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

        private native RectF native_getBox(long j, NativePDFBoxType nativePDFBoxType);

        private native NativePageInfo native_getPageInfo(long j);

        private native NativeTextParserResult native_getTextParser(long j);

        private native NativeRenderResult native_renderPage(long j, Bitmap bitmap, int i, int i2, int i3, int i4, NativePageRenderingConfig nativePageRenderingConfig, Integer num);

        private native NativeRenderResult native_renderPageWithCache(long j, Bitmap bitmap, NativePageCache nativePageCache, String str, NativePageRenderingConfig nativePageRenderingConfig, Integer num);

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

        @Override // com.pspdfkit.internal.jni.NativePage
        public RectF getBox(NativePDFBoxType nativePDFBoxType) {
            return native_getBox(this.nativeRef, nativePDFBoxType);
        }

        @Override // com.pspdfkit.internal.jni.NativePage
        public NativePageInfo getPageInfo() {
            return native_getPageInfo(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativePage
        public NativeTextParserResult getTextParser() {
            return native_getTextParser(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativePage
        public NativeRenderResult renderPage(Bitmap bitmap, int i, int i2, int i3, int i4, NativePageRenderingConfig nativePageRenderingConfig, Integer num) {
            return native_renderPage(this.nativeRef, bitmap, i, i2, i3, i4, nativePageRenderingConfig, num);
        }

        @Override // com.pspdfkit.internal.jni.NativePage
        public NativeRenderResult renderPageWithCache(Bitmap bitmap, NativePageCache nativePageCache, String str, NativePageRenderingConfig nativePageRenderingConfig, Integer num) {
            return native_renderPageWithCache(this.nativeRef, bitmap, nativePageCache, str, nativePageRenderingConfig, num);
        }
    }

    public abstract RectF getBox(NativePDFBoxType nativePDFBoxType);

    public abstract NativePageInfo getPageInfo();

    public abstract NativeTextParserResult getTextParser();

    public abstract NativeRenderResult renderPage(Bitmap bitmap, int i, int i2, int i3, int i4, NativePageRenderingConfig nativePageRenderingConfig, Integer num);

    public abstract NativeRenderResult renderPageWithCache(Bitmap bitmap, NativePageCache nativePageCache, String str, NativePageRenderingConfig nativePageRenderingConfig, Integer num);
}
