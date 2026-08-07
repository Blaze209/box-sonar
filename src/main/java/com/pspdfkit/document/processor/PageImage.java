package com.pspdfkit.document.processor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.util.Pair;
import com.facebook.react.uimanager.ViewProps;
import com.pspdfkit.internal.jni.NativeImage;
import com.pspdfkit.internal.jni.NativeImageFactory;
import com.pspdfkit.internal.jni.NativeItemConfiguration;
import com.pspdfkit.internal.jni.NativeItemRelativePosition;
import com.pspdfkit.internal.jni.NativeItemZPosition;
import com.pspdfkit.internal.uw;
import com.pspdfkit.utils.Size;
import java.io.IOException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public class PageImage {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Bitmap bitmap;
    private final Context context;
    private final Uri fileUri;
    private final PagePosition position;
    private final RectF positionRect;
    private int quality = 98;
    private int rotation = 0;
    private PageZOrder zOrder = PageZOrder.FOREGROUND;

    public PageImage(Context context, Uri uri, PagePosition pagePosition) {
        uw.a(context, "context", null);
        uw.a(uri, "fileUri", null);
        uw.a(pagePosition, ViewProps.POSITION, null);
        this.context = context;
        this.fileUri = uri;
        this.position = pagePosition;
        this.positionRect = null;
        this.bitmap = null;
    }

    public Pair<NativeImage, Size> getImage() throws IOException {
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            return NativeImageFactory.fromBitmap(bitmap, this.quality);
        }
        Uri uri = this.fileUri;
        if (uri != null) {
            return NativeImageFactory.fromUri(this.context, uri);
        }
        return null;
    }

    public NativeItemConfiguration getItemConfiguration() throws IOException {
        NativeItemRelativePosition nativeItemRelativePosition;
        Matrix matrix = new Matrix();
        Pair<NativeImage, Size> image = getImage();
        if (image == null) {
            throw new IOException("Couldn't open passed image.");
        }
        if (this.positionRect != null) {
            Size size = (Size) image.second;
            RectF rectF = new RectF(0.0f, 0.0f, size.width, size.height);
            RectF rectF2 = this.positionRect;
            RectF rectF3 = new RectF(rectF2.left, rectF2.bottom, rectF2.right, rectF2.top);
            if (this.rotation != 0) {
                Matrix matrix2 = new Matrix();
                matrix2.setRotate(-this.rotation, this.positionRect.centerX(), this.positionRect.centerY());
                matrix2.mapRect(rectF3);
            }
            matrix.setRectToRect(rectF, rectF3, Matrix.ScaleToFit.FILL);
            nativeItemRelativePosition = null;
        } else {
            nativeItemRelativePosition = NativeItemRelativePosition.values()[this.position.ordinal()];
        }
        NativeItemRelativePosition nativeItemRelativePosition2 = nativeItemRelativePosition;
        int i = this.rotation;
        if (i != 0) {
            RectF rectF4 = this.positionRect;
            if (rectF4 != null) {
                matrix.postRotate(i, rectF4.centerX(), this.positionRect.centerY());
            } else {
                matrix.postRotate(i);
            }
        }
        return new NativeItemConfiguration((NativeImage) image.first, null, null, nativeItemRelativePosition2, NativeItemZPosition.values()[this.zOrder.ordinal()], matrix);
    }

    public PagePosition getPosition() {
        return this.position;
    }

    public RectF getPositionRect() {
        return this.positionRect;
    }

    public int getRotation() {
        return this.rotation;
    }

    public PageZOrder getZOrder() {
        return this.zOrder;
    }

    public void setJpegQuality(int i) {
        this.quality = i;
    }

    public void setRotation(int i) {
        this.rotation = i;
    }

    public void setZOrder(PageZOrder pageZOrder) {
        uw.a(pageZOrder, "zOrder", null);
        this.zOrder = pageZOrder;
    }

    public String toString() {
        return "PageImage{" + (this.fileUri != null ? ", fileUri=" + this.fileUri : "") + (this.bitmap != null ? ", bitmap=" + this.bitmap : "") + ", position=" + this.position + ", positionRect=" + this.positionRect + ", quality=" + this.quality + ", zOrder=" + this.zOrder + AbstractJsonLexerKt.END_OBJ;
    }

    public PageImage(Bitmap bitmap, PagePosition pagePosition) {
        if (bitmap != null) {
            uw.a(pagePosition, ViewProps.POSITION, null);
            this.bitmap = bitmap;
            this.position = pagePosition;
            this.context = null;
            this.fileUri = null;
            this.positionRect = null;
            return;
        }
        throw new IllegalArgumentException("The passed Bitmap object may not be null.");
    }

    public PageImage(Context context, Uri uri, RectF rectF) {
        uw.a(context, "context", null);
        uw.a(uri, "fileUri", null);
        if (rectF.bottom > rectF.top) {
            throw new IllegalArgumentException("Rect height() is less than 0. Note that PDF coordinates start with 0,0 in BOTTOM LEFT corner and thus rects in PDF have bottom > top.");
        }
        if (rectF.width() >= 0.0f) {
            this.context = context;
            this.fileUri = uri;
            this.positionRect = rectF;
            this.position = PagePosition.BOTTOM_LEFT;
            this.bitmap = null;
            return;
        }
        throw new IllegalArgumentException("Rect width() is less than 0.");
    }

    public PageImage(Bitmap bitmap, RectF rectF) {
        if (bitmap == null) {
            throw new IllegalArgumentException("The passed Bitmap object may not be null.");
        }
        if (rectF.bottom > rectF.top) {
            throw new IllegalArgumentException("Rect height() is less than 0. Note that PDF coordinates start with 0,0 in BOTTOM LEFT corner and thus rects in PDF have bottom > top.");
        }
        if (rectF.width() >= 0.0f) {
            this.bitmap = bitmap;
            this.positionRect = rectF;
            this.context = null;
            this.position = PagePosition.BOTTOM_LEFT;
            this.fileUri = null;
            return;
        }
        throw new IllegalArgumentException("Rect width() is less than 0.");
    }
}
