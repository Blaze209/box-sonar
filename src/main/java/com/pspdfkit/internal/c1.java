package com.pspdfkit.internal;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.StampAnnotation;
import com.pspdfkit.internal.document.DataProviderShim;
import com.pspdfkit.internal.jni.NativeAnnotation;
import com.pspdfkit.internal.jni.NativeImageScaleMode;
import com.pspdfkit.utils.PdfLog;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class c1 extends k4 {
    public final Annotation c;
    public final boolean d;
    public String e;
    public Bitmap f;
    public byte[] g;

    public c1(Annotation annotation) {
        annotation.getClass();
        this.c = annotation;
        this.d = false;
    }

    @Override // com.pspdfkit.internal.k4
    public boolean d() {
        if (this.c.isAttached() && this.a) {
            NativeAnnotation nativeAnnotationRequireNativeAnnotation = this.c.getInternal().requireNativeAnnotation();
            byte[] bArrF = f();
            if (bArrF == null) {
                return false;
            }
            DataProviderShim dataProviderShim = new DataProviderShim(new rq(bArrF));
            Bitmap bitmap = this.f;
            if (bitmap == null || !this.d) {
                this.c.getInternal().getNativeResourceManager().setImageResource(nativeAnnotationRequireNativeAnnotation, null, null, NativeImageScaleMode.SCALE_TO_FILL, dataProviderShim);
            } else {
                RectF boundingBox = this.c.getBoundingBox();
                boundingBox.sort();
                Matrix matrix = new Matrix();
                matrix.setRectToRect(new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight()), new RectF(0.0f, 0.0f, boundingBox.width(), boundingBox.height()), Matrix.ScaleToFit.CENTER);
                this.c.getInternal().getNativeResourceManager().setImageResource(nativeAnnotationRequireNativeAnnotation, new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight()), matrix, null, dataProviderShim);
            }
            String strFindImageResource = this.c.getInternal().getNativeResourceManager().findImageResource(nativeAnnotationRequireNativeAnnotation);
            this.e = strFindImageResource;
            if (strFindImageResource != null && strFindImageResource.length() != 0) {
                this.a = false;
                this.f = null;
                this.g = null;
                return true;
            }
            PdfLog.e("Nutri.AnnotBitmapRes", "Couldn't set annotation bitmap", new Object[0]);
        }
        return false;
    }

    public final byte[] f() {
        Bitmap bitmap = this.f;
        if (bitmap == null && this.g == null) {
            return null;
        }
        if (this.g == null) {
            if (bitmap == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (bitmap.hasAlpha()) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            } else {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 99, byteArrayOutputStream);
            }
            this.g = byteArrayOutputStream.toByteArray();
        }
        return this.g;
    }

    public boolean g() {
        NativeAnnotation nativeAnnotation;
        if (this.f != null || this.g != null) {
            return true;
        }
        String str = this.e;
        return (str == null || (nativeAnnotation = this.c.getInternal().getNativeAnnotation()) == null || !this.c.isAttached() || this.c.getInternal().getNativeResourceManager().getImageInformation(nativeAnnotation, str) == null) ? false : true;
    }

    public c1(Annotation annotation, Bitmap bitmap, boolean z) {
        annotation.getClass();
        this.c = annotation;
        this.d = z;
        this.f = bitmap;
        this.a = true;
        this.b = true;
    }

    public c1(StampAnnotation stampAnnotation, byte[] bArr) {
        this.c = stampAnnotation;
        this.d = false;
        this.g = bArr;
        this.a = true;
        this.b = true;
    }
}
