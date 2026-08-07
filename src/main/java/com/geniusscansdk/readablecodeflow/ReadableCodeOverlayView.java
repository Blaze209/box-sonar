package com.geniusscansdk.readablecodeflow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.geniusscansdk.camera.SpatialReadableCode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReadableCodeOverlayView.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007J\u0014\u0010\u0016\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\b\u0010\u0018\u001a\u00020\u0014H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001a\u001a\u00020\u000fH\u0002J\"\u0010\u001b\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\u0006\u0010\u001f\u001a\u00020\u0014J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/geniusscansdk/readablecodeflow/ReadableCodeOverlayView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "paint", "Landroid/graphics/Paint;", "textPaint", "detectedCodes", "", "Lcom/geniusscansdk/camera/SpatialReadableCode;", "cachedTransformations", "", "Landroid/graphics/Rect;", "setOverlayColor", "", "color", "updateDetectedCodes", "codes", "invalidateTransformationCache", "getCachedTransformation", "code", "transformBounds", "imageRect", "imageWidth", "imageHeight", "clearDetectedCodes", "onDraw", "canvas", "Landroid/graphics/Canvas;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReadableCodeOverlayView extends View {
    private final Map<SpatialReadableCode, Rect> cachedTransformations;
    private List<SpatialReadableCode> detectedCodes;
    private final Paint paint;
    private final Paint textPaint;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReadableCodeOverlayView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReadableCodeOverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ReadableCodeOverlayView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadableCodeOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        paint.setColor(-16711936);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(8.0f);
        paint.setAntiAlias(true);
        this.paint = paint;
        Paint paint2 = new Paint();
        paint2.setColor(-16711936);
        paint2.setTextSize(48.0f);
        paint2.setAntiAlias(true);
        this.textPaint = paint2;
        this.detectedCodes = CollectionsKt.emptyList();
        this.cachedTransformations = new LinkedHashMap();
    }

    public final void setOverlayColor(int color) {
        this.paint.setColor(color);
        this.textPaint.setColor(color);
        invalidate();
    }

    public final void updateDetectedCodes(List<SpatialReadableCode> codes) {
        Intrinsics.checkNotNullParameter(codes, "codes");
        this.detectedCodes = codes;
        invalidateTransformationCache();
        invalidate();
    }

    private final synchronized void invalidateTransformationCache() {
        this.cachedTransformations.clear();
    }

    private final synchronized Rect getCachedTransformation(SpatialReadableCode code) {
        Rect rectTransformBounds;
        rectTransformBounds = this.cachedTransformations.get(code);
        if (rectTransformBounds == null) {
            Rect bounds = code.getBounds();
            if (bounds != null) {
                rectTransformBounds = transformBounds(bounds, code.getSourceImageWidth(), code.getSourceImageHeight());
                this.cachedTransformations.put(code, rectTransformBounds);
            } else {
                rectTransformBounds = null;
            }
        }
        return rectTransformBounds;
    }

    private final Rect transformBounds(Rect imageRect, int imageWidth, int imageHeight) {
        float width;
        float height;
        if (getWidth() == 0 || getHeight() == 0 || imageWidth == 0 || imageHeight == 0) {
            return null;
        }
        float f = imageWidth;
        float f2 = imageHeight;
        float width2 = 0.0f;
        if (f / f2 > getWidth() / getHeight()) {
            width = getHeight() / f2;
            width2 = (getWidth() - (f * width)) / 2.0f;
            height = 0.0f;
        } else {
            width = getWidth() / f;
            height = (getHeight() - (f2 * width)) / 2.0f;
        }
        return new Rect((int) ((imageRect.left * width) + width2), (int) ((imageRect.top * width) + height), (int) ((imageRect.right * width) + width2), (int) ((imageRect.bottom * width) + height));
    }

    public final void clearDetectedCodes() {
        this.detectedCodes = CollectionsKt.emptyList();
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.detectedCodes.isEmpty()) {
            return;
        }
        List<SpatialReadableCode> list = this.detectedCodes;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            SpatialReadableCode spatialReadableCode = (SpatialReadableCode) obj;
            if (spatialReadableCode.getBounds() != null && spatialReadableCode.getSourceImageWidth() > 0 && spatialReadableCode.getSourceImageHeight() > 0) {
                arrayList.add(obj);
            }
        }
        ArrayList<SpatialReadableCode> arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            float width = getWidth() / 2.0f;
            float height = getHeight() / 2.0f;
            float f = height + 100.0f;
            canvas.drawRect(width - 100.0f, height - 100.0f, width + 100.0f, f, this.paint);
            String str = "Codes detected: " + this.detectedCodes.size();
            canvas.drawText(str, width - (this.textPaint.measureText(str) / 2), f + 60, this.textPaint);
            return;
        }
        for (SpatialReadableCode spatialReadableCode2 : arrayList2) {
            Rect cachedTransformation = getCachedTransformation(spatialReadableCode2);
            if (cachedTransformation != null) {
                canvas.drawRect(cachedTransformation, this.paint);
                canvas.drawText(spatialReadableCode2.getType().name() + ": " + spatialReadableCode2.getValue(), cachedTransformation.left, cachedTransformation.top - 10, this.textPaint);
            }
        }
    }
}
