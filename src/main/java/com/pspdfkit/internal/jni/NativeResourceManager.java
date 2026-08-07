package com.pspdfkit.internal.jni;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeResourceManager {

    public static final class CppProxy extends NativeResourceManager {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeResourceManager create();

        private native void nativeDestroy(long j);

        private native void native_clearFormIcon(long j, NativeAnnotation nativeAnnotation);

        private native String native_createFileResource(long j, NativeAnnotation nativeAnnotation, NativeDataProvider nativeDataProvider, NativeFileResourceInformation nativeFileResourceInformation);

        private native String native_createPDFResource(long j, NativeAnnotation nativeAnnotation, Matrix matrix, NativeDataProvider nativeDataProvider, int i);

        private native String native_createSoundResource(long j, NativeAnnotation nativeAnnotation, NativeDataProvider nativeDataProvider);

        private native ArrayList<String> native_findEmbeddedFiles(long j, NativeDocument nativeDocument);

        private native String native_findImageResource(long j, NativeAnnotation nativeAnnotation);

        private native String native_findResource(long j, NativeAnnotation nativeAnnotation);

        private native NativeFileResourceInformation native_getFileInformation(long j, NativeDocument nativeDocument, NativeAnnotation nativeAnnotation, String str);

        private native NativeImageResourceInformation native_getImageInformation(long j, NativeAnnotation nativeAnnotation, String str);

        private native NativeResult native_getImageResource(long j, NativeAnnotation nativeAnnotation, String str, Bitmap bitmap);

        private native NativeResult native_getResource(long j, NativeDocument nativeDocument, NativeAnnotation nativeAnnotation, String str, NativeDataSink nativeDataSink);

        private native String native_setImageResource(long j, NativeAnnotation nativeAnnotation, RectF rectF, Matrix matrix, NativeImageScaleMode nativeImageScaleMode, NativeDataProvider nativeDataProvider);

        private native NativeResult native_setResource(long j, NativeAnnotation nativeAnnotation, String str, NativeDataProvider nativeDataProvider);

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

        @Override // com.pspdfkit.internal.jni.NativeResourceManager
        public void clearFormIcon(NativeAnnotation nativeAnnotation) {
            native_clearFormIcon(this.nativeRef, nativeAnnotation);
        }

        @Override // com.pspdfkit.internal.jni.NativeResourceManager
        public String createFileResource(NativeAnnotation nativeAnnotation, NativeDataProvider nativeDataProvider, NativeFileResourceInformation nativeFileResourceInformation) {
            return native_createFileResource(this.nativeRef, nativeAnnotation, nativeDataProvider, nativeFileResourceInformation);
        }

        @Override // com.pspdfkit.internal.jni.NativeResourceManager
        public String createPDFResource(NativeAnnotation nativeAnnotation, Matrix matrix, NativeDataProvider nativeDataProvider, int i) {
            return native_createPDFResource(this.nativeRef, nativeAnnotation, matrix, nativeDataProvider, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeResourceManager
        public String createSoundResource(NativeAnnotation nativeAnnotation, NativeDataProvider nativeDataProvider) {
            return native_createSoundResource(this.nativeRef, nativeAnnotation, nativeDataProvider);
        }

        @Override // com.pspdfkit.internal.jni.NativeResourceManager
        public ArrayList<String> findEmbeddedFiles(NativeDocument nativeDocument) {
            return native_findEmbeddedFiles(this.nativeRef, nativeDocument);
        }

        @Override // com.pspdfkit.internal.jni.NativeResourceManager
        public String findImageResource(NativeAnnotation nativeAnnotation) {
            return native_findImageResource(this.nativeRef, nativeAnnotation);
        }

        @Override // com.pspdfkit.internal.jni.NativeResourceManager
        public String findResource(NativeAnnotation nativeAnnotation) {
            return native_findResource(this.nativeRef, nativeAnnotation);
        }

        @Override // com.pspdfkit.internal.jni.NativeResourceManager
        public NativeFileResourceInformation getFileInformation(NativeDocument nativeDocument, NativeAnnotation nativeAnnotation, String str) {
            return native_getFileInformation(this.nativeRef, nativeDocument, nativeAnnotation, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeResourceManager
        public NativeImageResourceInformation getImageInformation(NativeAnnotation nativeAnnotation, String str) {
            return native_getImageInformation(this.nativeRef, nativeAnnotation, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeResourceManager
        public NativeResult getImageResource(NativeAnnotation nativeAnnotation, String str, Bitmap bitmap) {
            return native_getImageResource(this.nativeRef, nativeAnnotation, str, bitmap);
        }

        @Override // com.pspdfkit.internal.jni.NativeResourceManager
        public NativeResult getResource(NativeDocument nativeDocument, NativeAnnotation nativeAnnotation, String str, NativeDataSink nativeDataSink) {
            return native_getResource(this.nativeRef, nativeDocument, nativeAnnotation, str, nativeDataSink);
        }

        @Override // com.pspdfkit.internal.jni.NativeResourceManager
        public String setImageResource(NativeAnnotation nativeAnnotation, RectF rectF, Matrix matrix, NativeImageScaleMode nativeImageScaleMode, NativeDataProvider nativeDataProvider) {
            return native_setImageResource(this.nativeRef, nativeAnnotation, rectF, matrix, nativeImageScaleMode, nativeDataProvider);
        }

        @Override // com.pspdfkit.internal.jni.NativeResourceManager
        public NativeResult setResource(NativeAnnotation nativeAnnotation, String str, NativeDataProvider nativeDataProvider) {
            return native_setResource(this.nativeRef, nativeAnnotation, str, nativeDataProvider);
        }
    }

    public static NativeResourceManager create() {
        return CppProxy.create();
    }

    public abstract void clearFormIcon(NativeAnnotation nativeAnnotation);

    public abstract String createFileResource(NativeAnnotation nativeAnnotation, NativeDataProvider nativeDataProvider, NativeFileResourceInformation nativeFileResourceInformation);

    public abstract String createPDFResource(NativeAnnotation nativeAnnotation, Matrix matrix, NativeDataProvider nativeDataProvider, int i);

    public abstract String createSoundResource(NativeAnnotation nativeAnnotation, NativeDataProvider nativeDataProvider);

    public abstract ArrayList<String> findEmbeddedFiles(NativeDocument nativeDocument);

    public abstract String findImageResource(NativeAnnotation nativeAnnotation);

    public abstract String findResource(NativeAnnotation nativeAnnotation);

    public abstract NativeFileResourceInformation getFileInformation(NativeDocument nativeDocument, NativeAnnotation nativeAnnotation, String str);

    public abstract NativeImageResourceInformation getImageInformation(NativeAnnotation nativeAnnotation, String str);

    public abstract NativeResult getImageResource(NativeAnnotation nativeAnnotation, String str, Bitmap bitmap);

    public abstract NativeResult getResource(NativeDocument nativeDocument, NativeAnnotation nativeAnnotation, String str, NativeDataSink nativeDataSink);

    public abstract String setImageResource(NativeAnnotation nativeAnnotation, RectF rectF, Matrix matrix, NativeImageScaleMode nativeImageScaleMode, NativeDataProvider nativeDataProvider);

    public abstract NativeResult setResource(NativeAnnotation nativeAnnotation, String str, NativeDataProvider nativeDataProvider);
}
