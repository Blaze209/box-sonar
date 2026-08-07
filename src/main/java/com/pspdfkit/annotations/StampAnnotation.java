package com.pspdfkit.annotations;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.text.TextUtils;
import androidx.media3.common.PlaybackException;
import com.pspdfkit.annotations.appearance.AppearanceStreamGenerator;
import com.pspdfkit.annotations.stamps.StampType;
import com.pspdfkit.internal.c1;
import com.pspdfkit.internal.gl;
import com.pspdfkit.internal.hm;
import com.pspdfkit.internal.il;
import com.pspdfkit.internal.j3;
import com.pspdfkit.internal.jni.NativeAnnotation;
import com.pspdfkit.internal.k4;
import com.pspdfkit.internal.lm;
import com.pspdfkit.internal.o3;
import com.pspdfkit.internal.uk;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.wk;
import com.pspdfkit.utils.Size;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class StampAnnotation extends Annotation {
    static final StampType CUSTOM_IMAGE = new StampType("#Image");
    static final StampType CUSTOM_AP_STREAM = new StampType("#CustomAp");

    public StampAnnotation(int i, RectF rectF, byte[] bArr) {
        super(i);
        uw.a(rectF, "rect", null);
        uw.a(bArr, "compressedBitmap", null);
        j3 j3Var = this.propertyManager;
        j3Var.f.a(9, rectF, true);
        j3Var.l();
        j3 j3Var2 = this.propertyManager;
        j3Var2.f.a(4000, CUSTOM_IMAGE.getName(), true);
        j3Var2.l();
        this.propertyManager.a(new c1(this, bArr));
    }

    private c1 getAnnotationBitmapResource() {
        k4 k4Var;
        j3 j3Var = this.propertyManager;
        synchronized (j3Var) {
            k4Var = j3Var.j;
        }
        if (k4Var instanceof c1) {
            return (c1) k4Var;
        }
        return null;
    }

    private boolean isInstant() {
        return getInternalDocument() instanceof hm;
    }

    private void prepareInstantBitmapResource() {
        k4 k4Var;
        uk ukVar;
        if (hasBitmap()) {
            j3 j3Var = this.propertyManager;
            synchronized (j3Var) {
                k4Var = j3Var.j;
            }
            if ((k4Var instanceof uk) || getInternalDocument() == null) {
                return;
            }
            k4 k4VarD = this.propertyManager.d();
            if (!(k4VarD instanceof c1)) {
                throw new IllegalStateException("Instant does not support standard stamps, only image stamps are supported.");
            }
            c1 c1Var = (c1) k4VarD;
            o3 annotationProvider = getInternalDocument().getAnnotationProvider();
            if (!(annotationProvider instanceof wk)) {
                throw new IllegalStateException("Can't find the annotation provider for Instant.");
            }
            il ilVar = ((wk) annotationProvider).n;
            ilVar.getClass();
            if (c1Var instanceof uk) {
                ukVar = (uk) c1Var;
            } else {
                Annotation annotation = c1Var.c;
                String str = c1Var.e;
                if (str != null) {
                    annotation.getClass();
                    ukVar = new uk(ilVar, annotation);
                    ukVar.i = str;
                    ukVar.b = false;
                } else {
                    Bitmap bitmap = c1Var.f;
                    if (bitmap != null) {
                        annotation.getClass();
                        ukVar = new uk(ilVar, annotation);
                        ukVar.f = bitmap;
                        ukVar.k = gl.a.LOADED;
                    } else {
                        byte[] bArr = c1Var.g;
                        if (bArr != null) {
                            annotation.getClass();
                            uk ukVar2 = new uk(ilVar, annotation);
                            ukVar2.g = bArr;
                            ukVar2.k = gl.a.LOADED;
                            ukVar = ukVar2;
                        } else {
                            ukVar = null;
                        }
                        if (ukVar == null) {
                            throw new IllegalStateException("AnnotationBitmapResource was not initialized correctly!");
                        }
                    }
                }
            }
            this.propertyManager.a(ukVar);
        }
    }

    private void prepareInstantProperties(NativeAnnotation nativeAnnotation) {
        String title = getTitle();
        String strG = this.propertyManager.g(4000);
        if (title == null && strG == null) {
            return;
        }
        j3 j3Var = new j3();
        j3Var.f.a(PlaybackException.ERROR_CODE_DRM_PROVISIONING_FAILED, title, true);
        j3Var.l();
        j3Var.f.a(4000, strG, true);
        j3Var.l();
        o3 annotationProvider = ((lm) Objects.requireNonNull(getInternal().getInternalDocument())).getAnnotationProvider();
        nativeAnnotation.getClass();
        annotationProvider.getClass();
        j3Var.b = nativeAnnotation;
        j3Var.a = annotationProvider;
        j3Var.d = annotationProvider.d;
        j3Var.c = false;
        synchronized (j3Var) {
            j3Var.a(true);
        }
    }

    public void adjustBoundsForRotation() {
        getInternal().adjustBoundsForRotation(1.0f);
    }

    public synchronized Bitmap getBitmap() {
        c1 annotationBitmapResource = getAnnotationBitmapResource();
        if (annotationBitmapResource == null) {
            return null;
        }
        Bitmap bitmap = annotationBitmapResource.f;
        if (bitmap != null) {
            return bitmap;
        }
        String str = annotationBitmapResource.e;
        if (str == null) {
            return null;
        }
        return annotationBitmapResource.c.getInternal().getNativeImageResource(str);
    }

    @Override // com.pspdfkit.annotations.Annotation
    public Size getMinimumSize() {
        if (hasCustomMinimumSize()) {
            return super.getMinimumSize();
        }
        RectF contentSize = getInternal().getContentSize(null);
        if (contentSize == null) {
            return super.getMinimumSize();
        }
        contentSize.sort();
        return new Size(contentSize.width() * 0.2f, contentSize.height() * 0.2f);
    }

    public int getRotation() {
        return getInternal().getRotation();
    }

    public StampType getStampType() {
        String strG = this.propertyManager.g(4000);
        if (strG == null) {
            return null;
        }
        return new StampType(strG);
    }

    public String getSubtitle() {
        return this.propertyManager.g(PlaybackException.ERROR_CODE_DRM_SCHEME_UNSUPPORTED);
    }

    public String getTitle() {
        return this.propertyManager.g(PlaybackException.ERROR_CODE_DRM_PROVISIONING_FAILED);
    }

    @Override // com.pspdfkit.annotations.Annotation
    public AnnotationType getType() {
        return AnnotationType.STAMP;
    }

    public synchronized boolean hasBitmap() {
        c1 annotationBitmapResource = getAnnotationBitmapResource();
        return annotationBitmapResource != null && annotationBitmapResource.g();
    }

    @Override // com.pspdfkit.annotations.Annotation
    public boolean isUiRotationSupported() {
        return true;
    }

    @Override // com.pspdfkit.annotations.Annotation
    public void onBeforeAttachToDocument(NativeAnnotation nativeAnnotation) {
        if (isInstant()) {
            prepareInstantProperties(nativeAnnotation);
            prepareInstantBitmapResource();
        }
    }

    public synchronized void setBitmap(Bitmap bitmap) {
        uw.a(bitmap, "bitmap", null);
        setBitmap(new c1(this, bitmap, false));
    }

    public void setIsSignature(boolean z) {
        getInternal().setIsSignature(z);
    }

    public void setRotation(int i, Size size, boolean z) {
        uw.a(size, "contentSize", null);
        getInternal().setRotation(i);
        setContentSize(new RectF(0.0f, Math.abs(size.height), Math.abs(size.width), 0.0f), false);
        if (z) {
            adjustBoundsForRotation();
        }
    }

    public synchronized void setStampType(StampType stampType) {
        if (stampType != null) {
            try {
                this.propertyManager.a((k4) null);
            } catch (Throwable th) {
                throw th;
            }
        }
        String name = stampType != null ? stampType.getName() : null;
        j3 j3Var = this.propertyManager;
        j3Var.f.a(4000, name, true);
        j3Var.l();
    }

    public void setSubtitle(String str) {
        j3 j3Var = this.propertyManager;
        j3Var.f.a(PlaybackException.ERROR_CODE_DRM_SCHEME_UNSUPPORTED, str, true);
        j3Var.l();
    }

    public void setTitle(String str) {
        j3 j3Var = this.propertyManager;
        j3Var.f.a(PlaybackException.ERROR_CODE_DRM_PROVISIONING_FAILED, str, true);
        j3Var.l();
    }

    @Override // com.pspdfkit.annotations.Annotation
    public String toInstantJson() {
        if (TextUtils.isEmpty(getTitle()) && getStampType() == null && !hasBitmap()) {
            throw new IllegalStateException("Can't create Instant JSON for stamp annotation that has no content - title, stamp icon or an image!");
        }
        return super.toInstantJson();
    }

    @Override // com.pspdfkit.annotations.Annotation
    public void updateTransformationProperties(RectF rectF, RectF rectF2) {
    }

    @Override // com.pspdfkit.annotations.Annotation
    public synchronized StampAnnotation getCopy() {
        Bitmap nativeImageResource = null;
        StampAnnotation stampAnnotation = new StampAnnotation(this.propertyManager, true, (Bitmap) null);
        stampAnnotation.getInternal().prepareForCopy();
        AppearanceStreamGenerator appearanceStreamGenerator = get_appearanceStreamGenerator();
        if (appearanceStreamGenerator != null) {
            stampAnnotation.setAppearanceStreamGenerator(appearanceStreamGenerator);
            return stampAnnotation;
        }
        c1 annotationBitmapResource = getAnnotationBitmapResource();
        if (annotationBitmapResource != null) {
            Bitmap bitmap = annotationBitmapResource.f;
            if (bitmap != null) {
                nativeImageResource = bitmap;
            } else {
                String str = annotationBitmapResource.e;
                if (str != null) {
                    nativeImageResource = annotationBitmapResource.c.getInternal().getNativeImageResource(str);
                }
            }
            if (nativeImageResource != null) {
                stampAnnotation.setBitmap(nativeImageResource);
                return stampAnnotation;
            }
        }
        return stampAnnotation;
    }

    public synchronized void setBitmap(byte[] bArr) {
        uw.a(bArr, "compressedBitmap", null);
        setBitmap(new c1(this, bArr));
    }

    private void setBitmap(c1 c1Var) {
        if (getAnnotationBitmapResource() == null) {
            setTitle(null);
            setStampType(null);
            setSubtitle(null);
        }
        this.propertyManager.a(c1Var);
        j3 j3Var = this.propertyManager;
        j3Var.f.a(4000, CUSTOM_IMAGE.getName(), true);
        j3Var.l();
    }

    public void setRotation(int i, Size size) {
        setRotation(i, size, true);
    }

    public void setRotation(int i) {
        setRotation(i, true);
    }

    public void setRotation(int i, boolean z) {
        getInternal().setRotation(i);
        if (getInternal().getContentSize(null) == null) {
            setContentSize(getBoundingBox(), false);
        }
        if (z) {
            adjustBoundsForRotation();
        }
    }

    public StampAnnotation(int i, RectF rectF, Bitmap bitmap) {
        super(i);
        uw.a(rectF, "rect", null);
        uw.a(bitmap, "bitmap", null);
        j3 j3Var = this.propertyManager;
        j3Var.f.a(9, rectF, true);
        j3Var.l();
        j3 j3Var2 = this.propertyManager;
        j3Var2.f.a(4000, CUSTOM_IMAGE.getName(), true);
        j3Var2.l();
        this.propertyManager.a(new c1(this, bitmap, false));
    }

    public StampAnnotation(int i, RectF rectF, StampType stampType) {
        super(i);
        uw.a(rectF, "rect", null);
        j3 j3Var = this.propertyManager;
        j3Var.f.a(9, rectF, true);
        j3Var.l();
        setStampType(stampType);
    }

    public StampAnnotation(int i, RectF rectF, String str) {
        super(i);
        uw.a(rectF, "rect", null);
        uw.a(str, "title", null);
        j3 j3Var = this.propertyManager;
        j3Var.f.a(9, rectF, true);
        j3Var.l();
        j3 j3Var2 = this.propertyManager;
        j3Var2.f.a(PlaybackException.ERROR_CODE_DRM_PROVISIONING_FAILED, str, true);
        j3Var2.l();
    }

    public StampAnnotation(j3 j3Var, boolean z, String str) {
        super(j3Var, z);
        if (str != null) {
            j3 j3Var2 = this.propertyManager;
            c1 c1Var = new c1(this);
            c1Var.e = str;
            j3Var2.a(c1Var);
        }
    }

    public StampAnnotation(j3 j3Var, boolean z, Bitmap bitmap) {
        super(j3Var, z);
        if (bitmap != null) {
            this.propertyManager.a(new c1(this, bitmap, false));
        }
    }
}
