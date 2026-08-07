package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeAnnotationAppearanceStream {
    final NativeImage mImage;
    final NativeDataDescriptor mPDFDataDescriptor;

    public NativeAnnotationAppearanceStream(NativeImage nativeImage, NativeDataDescriptor nativeDataDescriptor) {
        this.mImage = nativeImage;
        this.mPDFDataDescriptor = nativeDataDescriptor;
    }

    public NativeImage getImage() {
        return this.mImage;
    }

    public NativeDataDescriptor getPDFDataDescriptor() {
        return this.mPDFDataDescriptor;
    }

    public String toString() {
        return "NativeAnnotationAppearanceStream{mImage=" + this.mImage + ",mPDFDataDescriptor=" + this.mPDFDataDescriptor + "}";
    }
}
