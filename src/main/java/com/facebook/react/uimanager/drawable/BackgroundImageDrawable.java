package com.facebook.react.uimanager.drawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.react.uimanager.FloatUtil;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.style.BackgroundImageLayer;
import com.facebook.react.uimanager.style.BackgroundPosition;
import com.facebook.react.uimanager.style.BackgroundRepeat;
import com.facebook.react.uimanager.style.BackgroundRepeatKeyword;
import com.facebook.react.uimanager.style.BackgroundSize;
import com.facebook.react.uimanager.style.BorderInsets;
import com.facebook.react.uimanager.style.BorderRadiusStyle;
import com.facebook.react.uimanager.style.ComputedBorderRadius;
import com.facebook.react.uimanager.style.CornerRadii;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BackgroundImageDrawable.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u0002002\u0006\u00102\u001a\u000203H\u0014J\u0010\u00104\u001a\u0002002\u0006\u00105\u001a\u000206H\u0016J\u0012\u00107\u001a\u0002002\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010:\u001a\u000206H\u0017J\u0010\u0010;\u001a\u0002002\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020\u0017H\u0002J\u0018\u0010?\u001a\u00020\u00132\u0006\u0010@\u001a\u00020\u00172\u0006\u0010A\u001a\u00020\u0017H\u0002J\b\u0010B\u001a\u000200H\u0002J\u0018\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020DH\u0002JH\u0010H\u001a\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020D0I2\u0006\u0010J\u001a\u00020D2\u0006\u0010K\u001a\u00020D2\u0006\u0010L\u001a\u00020D2\u0006\u0010M\u001a\u00020D2\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010N\u001a\u0004\u0018\u00010)H\u0002J.\u0010O\u001a\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020D0I2\u0006\u0010P\u001a\u00020D2\u0006\u0010Q\u001a\u00020D2\b\u0010R\u001a\u0004\u0018\u00010%H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R4\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R4\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u001a2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u001a@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R4\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u001a2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u001a@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R4\u0010*\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\u001a2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\u001a@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010 R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/facebook/react/uimanager/drawable/BackgroundImageDrawable;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", ViewProps.BORDER_RADIUS, "Lcom/facebook/react/uimanager/style/BorderRadiusStyle;", "borderInsets", "Lcom/facebook/react/uimanager/style/BorderInsets;", "<init>", "(Landroid/content/Context;Lcom/facebook/react/uimanager/style/BorderRadiusStyle;Lcom/facebook/react/uimanager/style/BorderInsets;)V", "getBorderRadius", "()Lcom/facebook/react/uimanager/style/BorderRadiusStyle;", "setBorderRadius", "(Lcom/facebook/react/uimanager/style/BorderRadiusStyle;)V", "getBorderInsets", "()Lcom/facebook/react/uimanager/style/BorderInsets;", "setBorderInsets", "(Lcom/facebook/react/uimanager/style/BorderInsets;)V", "needUpdatePath", "", "backgroundImageClipPath", "Landroid/graphics/Path;", "backgroundPositioningArea", "Landroid/graphics/RectF;", "backgroundPaintingArea", "value", "", "Lcom/facebook/react/uimanager/style/BackgroundImageLayer;", "backgroundImageLayers", "getBackgroundImageLayers", "()Ljava/util/List;", "setBackgroundImageLayers", "(Ljava/util/List;)V", "Lcom/facebook/react/uimanager/style/BackgroundSize;", "backgroundSize", "getBackgroundSize", "setBackgroundSize", "Lcom/facebook/react/uimanager/style/BackgroundPosition;", "backgroundPosition", "getBackgroundPosition", "setBackgroundPosition", "Lcom/facebook/react/uimanager/style/BackgroundRepeat;", "backgroundRepeat", "getBackgroundRepeat", "setBackgroundRepeat", "backgroundPaint", "Landroid/graphics/Paint;", "invalidateSelf", "", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "setAlpha", "alpha", "", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "getOpacity", "draw", "canvas", "Landroid/graphics/Canvas;", "computeBorderInsets", "hasInvalidDimensions", "positioningArea", "paintingArea", "updatePath", "positionToPixels", "", "lengthPercentage", "Lcom/facebook/react/uimanager/LengthPercentage;", "availableSpace", "calculateBackgroundImageSize", "Lkotlin/Pair;", "containerWidth", "containerHeight", "imageWidth", "imageHeight", "repeat", "calculateBackgroundPosition", "tileWidth", "tileHeight", ViewProps.POSITION, "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BackgroundImageDrawable extends Drawable {
    private Path backgroundImageClipPath;
    private List<BackgroundImageLayer> backgroundImageLayers;
    private final Paint backgroundPaint;
    private RectF backgroundPaintingArea;
    private List<BackgroundPosition> backgroundPosition;
    private RectF backgroundPositioningArea;
    private List<BackgroundRepeat> backgroundRepeat;
    private List<? extends BackgroundSize> backgroundSize;
    private BorderInsets borderInsets;
    private BorderRadiusStyle borderRadius;
    private final Context context;
    private boolean needUpdatePath;

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public /* synthetic */ BackgroundImageDrawable(Context context, BorderRadiusStyle borderRadiusStyle, BorderInsets borderInsets, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : borderRadiusStyle, (i & 4) != 0 ? null : borderInsets);
    }

    public final BorderRadiusStyle getBorderRadius() {
        return this.borderRadius;
    }

    public final void setBorderRadius(BorderRadiusStyle borderRadiusStyle) {
        this.borderRadius = borderRadiusStyle;
    }

    public final BorderInsets getBorderInsets() {
        return this.borderInsets;
    }

    public final void setBorderInsets(BorderInsets borderInsets) {
        this.borderInsets = borderInsets;
    }

    public BackgroundImageDrawable(Context context, BorderRadiusStyle borderRadiusStyle, BorderInsets borderInsets) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.borderRadius = borderRadiusStyle;
        this.borderInsets = borderInsets;
        this.needUpdatePath = true;
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        this.backgroundPaint = paint;
    }

    public final List<BackgroundImageLayer> getBackgroundImageLayers() {
        return this.backgroundImageLayers;
    }

    public final void setBackgroundImageLayers(List<BackgroundImageLayer> list) {
        if (Intrinsics.areEqual(this.backgroundImageLayers, list)) {
            return;
        }
        this.backgroundImageLayers = list;
        invalidateSelf();
    }

    public final List<BackgroundSize> getBackgroundSize() {
        return this.backgroundSize;
    }

    public final void setBackgroundSize(List<? extends BackgroundSize> list) {
        if (Intrinsics.areEqual(this.backgroundSize, list)) {
            return;
        }
        this.backgroundSize = list;
        invalidateSelf();
    }

    public final List<BackgroundPosition> getBackgroundPosition() {
        return this.backgroundPosition;
    }

    public final void setBackgroundPosition(List<BackgroundPosition> list) {
        if (Intrinsics.areEqual(this.backgroundPosition, list)) {
            return;
        }
        this.backgroundPosition = list;
        invalidateSelf();
    }

    public final List<BackgroundRepeat> getBackgroundRepeat() {
        return this.backgroundRepeat;
    }

    public final void setBackgroundRepeat(List<BackgroundRepeat> list) {
        if (Intrinsics.areEqual(this.backgroundRepeat, list)) {
            return;
        }
        this.backgroundRepeat = list;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.needUpdatePath = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        super.onBoundsChange(bounds);
        this.needUpdatePath = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.backgroundPaint.setAlpha(alpha);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public int getOpacity() {
        int alpha = this.backgroundPaint.getAlpha();
        if (alpha == 255) {
            return -1;
        }
        return (1 > alpha || alpha >= 255) ? -2 : -3;
    }

    /* JADX WARN: Code duplicated, block: B:94:0x0220  */
    /* JADX WARN: Code duplicated, block: B:96:0x0226 A[LOOP:2: B:95:0x0224->B:96:0x0226, LOOP_END] */
    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        RectF rectF;
        int size;
        int i;
        RectF rectF2;
        RectF rectF3;
        BackgroundRepeatKeyword x;
        float f;
        float f2;
        int i2;
        int i3;
        float f3;
        BackgroundRepeatKeyword y;
        float f4;
        int i4;
        int i5;
        float f5;
        float f6;
        int i6;
        float f7;
        int i7;
        BackgroundImageDrawable backgroundImageDrawable = this;
        Canvas canvas2 = canvas;
        Intrinsics.checkNotNullParameter(canvas2, "canvas");
        List<BackgroundImageLayer> list = backgroundImageDrawable.backgroundImageLayers;
        if (list != null) {
            int i8 = 1;
            if (list == null || !list.isEmpty()) {
                backgroundImageDrawable.updatePath();
                RectF rectF4 = backgroundImageDrawable.backgroundPaintingArea;
                if (rectF4 == null || (rectF = backgroundImageDrawable.backgroundPositioningArea) == null || backgroundImageDrawable.hasInvalidDimensions(rectF, rectF4)) {
                    return;
                }
                canvas2.save();
                Path path = backgroundImageDrawable.backgroundImageClipPath;
                if (path != null) {
                    canvas2.clipPath(path);
                }
                List<BackgroundImageLayer> list2 = backgroundImageDrawable.backgroundImageLayers;
                if (list2 != null && (size = list2.size() - 1) >= 0) {
                    while (true) {
                        int i9 = size - 1;
                        BackgroundImageLayer backgroundImageLayer = list2.get(size);
                        List<? extends BackgroundSize> list3 = backgroundImageDrawable.backgroundSize;
                        BackgroundSize backgroundSize = list3 != null ? (BackgroundSize) CollectionsKt.getOrNull(list3, size % list3.size()) : null;
                        List<BackgroundRepeat> list4 = backgroundImageDrawable.backgroundRepeat;
                        BackgroundRepeat backgroundRepeat = list4 != null ? (BackgroundRepeat) CollectionsKt.getOrNull(list4, size % list4.size()) : null;
                        List<BackgroundPosition> list5 = backgroundImageDrawable.backgroundPosition;
                        BackgroundPosition backgroundPosition = list5 != null ? (BackgroundPosition) CollectionsKt.getOrNull(list5, size % list5.size()) : null;
                        Pair<Float, Float> pairCalculateBackgroundImageSize = backgroundImageDrawable.calculateBackgroundImageSize(rectF.width(), rectF.height(), rectF.width(), rectF.height(), backgroundSize, backgroundRepeat);
                        BackgroundRepeat backgroundRepeat2 = backgroundRepeat;
                        BackgroundImageDrawable backgroundImageDrawable2 = backgroundImageDrawable;
                        float fFloatValue = pairCalculateBackgroundImageSize.component1().floatValue();
                        float fFloatValue2 = pairCalculateBackgroundImageSize.component2().floatValue();
                        if (fFloatValue <= 0.0f || fFloatValue2 <= 0.0f) {
                            i = i8;
                            rectF2 = rectF4;
                            rectF3 = rectF;
                        } else {
                            backgroundImageDrawable2.backgroundPaint.setShader(backgroundImageLayer.getShader(fFloatValue, fFloatValue2));
                            Pair<Float, Float> pairCalculateBackgroundPosition = backgroundImageDrawable2.calculateBackgroundPosition(fFloatValue, fFloatValue2, backgroundPosition);
                            float fFloatValue3 = pairCalculateBackgroundPosition.component1().floatValue();
                            float fFloatValue4 = pairCalculateBackgroundPosition.component2().floatValue();
                            if (backgroundRepeat2 == null || (x = backgroundRepeat2.getX()) == null) {
                                x = BackgroundRepeatKeyword.Repeat;
                            }
                            if (x == BackgroundRepeatKeyword.Space) {
                                float fWidth = rectF4.width() - (2 * fFloatValue);
                                i = i8;
                                RectF rectF5 = rectF4;
                                float fRint = (float) Math.rint(fFloatValue);
                                if (fRint <= 0.0f || (fWidth <= 0.0f && !FloatUtil.floatsEqual(fWidth, 0.0f))) {
                                    f2 = 0.0f;
                                    f = fFloatValue4;
                                    rectF2 = rectF5;
                                    f3 = f2;
                                    i3 = i;
                                } else {
                                    f2 = 0.0f;
                                    f = fFloatValue4;
                                    int iFloor = (int) Math.floor(((float) Math.rint(fWidth)) / fRint);
                                    rectF2 = rectF5;
                                    fFloatValue3 = rectF2.left;
                                    f3 = (fWidth - (iFloor * fFloatValue)) / (iFloor + 1);
                                    i3 = iFloor + 2;
                                }
                            } else {
                                f = fFloatValue4;
                                i = i8;
                                rectF2 = rectF4;
                                f2 = 0.0f;
                                if (x == BackgroundRepeatKeyword.Round || x == BackgroundRepeatKeyword.Repeat) {
                                    float fRint2 = (float) Math.rint(fFloatValue);
                                    if (fRint2 > 0.0f) {
                                        int iCeil = (int) Math.ceil(((float) Math.rint(fFloatValue3)) / fRint2);
                                        int iCeil2 = ((int) Math.ceil(((float) Math.rint(rectF2.width() - fFloatValue3)) / fRint2)) + iCeil;
                                        fFloatValue3 -= iCeil * fFloatValue;
                                        i2 = iCeil2;
                                    } else {
                                        i2 = i;
                                    }
                                    i3 = i2;
                                    f3 = 0.0f;
                                } else {
                                    f3 = f2;
                                    i3 = i;
                                }
                            }
                            if (backgroundRepeat2 == null || (y = backgroundRepeat2.getY()) == null) {
                                y = BackgroundRepeatKeyword.Repeat;
                            }
                            if (y == BackgroundRepeatKeyword.Space) {
                                float fHeight = rectF2.height() - (2 * fFloatValue2);
                                float f8 = f2;
                                rectF3 = rectF;
                                float fRint3 = (float) Math.rint(fFloatValue2);
                                if (fRint3 > f8 && (fHeight > f8 || FloatUtil.floatsEqual(fHeight, f8))) {
                                    int iFloor2 = (int) Math.floor(((float) Math.rint(fHeight)) / fRint3);
                                    f5 = (fHeight - (iFloor2 * fFloatValue2)) / (iFloor2 + 1);
                                    f = rectF2.top;
                                    i5 = iFloor2 + 2;
                                    fFloatValue = fFloatValue;
                                }
                                f6 = fFloatValue3;
                                i6 = 0;
                                while (i6 < i3) {
                                    f7 = f;
                                    i7 = 0;
                                    while (i7 < i5) {
                                        canvas2.save();
                                        canvas2.translate(f6, f7);
                                        float f9 = fFloatValue;
                                        canvas2.drawRect(0.0f, 0.0f, f9, fFloatValue2, backgroundImageDrawable2.backgroundPaint);
                                        canvas.restore();
                                        i7++;
                                        f7 = fFloatValue2 + f5 + f7;
                                        f6 = f6;
                                        fFloatValue = f9;
                                        canvas2 = canvas;
                                        i6 = i6;
                                    }
                                    float f10 = fFloatValue;
                                    f6 += f10 + f3;
                                    i6++;
                                    canvas2 = canvas;
                                    fFloatValue = f10;
                                }
                            } else {
                                rectF3 = rectF;
                                if (y == BackgroundRepeatKeyword.Round || y == BackgroundRepeatKeyword.Repeat) {
                                    float fRint4 = (float) Math.rint(fFloatValue2);
                                    if (fRint4 > 0.0f) {
                                        float f11 = f;
                                        int iCeil3 = (int) Math.ceil(((float) Math.rint(f11)) / fRint4);
                                        int iCeil4 = ((int) Math.ceil(((float) Math.rint(rectF2.height() - f11)) / fRint4)) + iCeil3;
                                        f4 = f11 - (iCeil3 * fFloatValue2);
                                        i4 = iCeil4;
                                    } else {
                                        f4 = f;
                                        i4 = i;
                                    }
                                    f = f4;
                                    i5 = i4;
                                }
                                f5 = 0.0f;
                                f6 = fFloatValue3;
                                i6 = 0;
                                while (i6 < i3) {
                                    f7 = f;
                                    i7 = 0;
                                    while (i7 < i5) {
                                        canvas2.save();
                                        canvas2.translate(f6, f7);
                                        float f12 = fFloatValue;
                                        canvas2.drawRect(0.0f, 0.0f, f12, fFloatValue2, backgroundImageDrawable2.backgroundPaint);
                                        canvas.restore();
                                        i7++;
                                        f7 = fFloatValue2 + f5 + f7;
                                        f6 = f6;
                                        fFloatValue = f12;
                                        canvas2 = canvas;
                                        i6 = i6;
                                    }
                                    float f13 = fFloatValue;
                                    f6 += f13 + f3;
                                    i6++;
                                    canvas2 = canvas;
                                    fFloatValue = f13;
                                }
                            }
                            fFloatValue = fFloatValue;
                            i5 = i;
                            f5 = 0.0f;
                            f6 = fFloatValue3;
                            i6 = 0;
                            while (i6 < i3) {
                                f7 = f;
                                i7 = 0;
                                while (i7 < i5) {
                                    canvas2.save();
                                    canvas2.translate(f6, f7);
                                    float f14 = fFloatValue;
                                    canvas2.drawRect(0.0f, 0.0f, f14, fFloatValue2, backgroundImageDrawable2.backgroundPaint);
                                    canvas.restore();
                                    i7++;
                                    f7 = fFloatValue2 + f5 + f7;
                                    f6 = f6;
                                    fFloatValue = f14;
                                    canvas2 = canvas;
                                    i6 = i6;
                                }
                                float f15 = fFloatValue;
                                f6 += f15 + f3;
                                i6++;
                                canvas2 = canvas;
                                fFloatValue = f15;
                            }
                        }
                        if (i9 < 0) {
                            break;
                        }
                        canvas2 = canvas;
                        backgroundImageDrawable = backgroundImageDrawable2;
                        rectF4 = rectF2;
                        size = i9;
                        rectF = rectF3;
                        i8 = i;
                    }
                }
                canvas.restore();
            }
        }
    }

    private final RectF computeBorderInsets() {
        float fDpToPx;
        float fDpToPx2;
        float fDpToPx3;
        BorderInsets borderInsets = this.borderInsets;
        RectF rectFResolve = borderInsets != null ? borderInsets.resolve(getLayoutDirection(), this.context) : null;
        float fDpToPx4 = 0.0f;
        if (rectFResolve != null) {
            fDpToPx = PixelUtil.INSTANCE.dpToPx(rectFResolve.left);
        } else {
            fDpToPx = 0.0f;
        }
        if (rectFResolve != null) {
            fDpToPx2 = PixelUtil.INSTANCE.dpToPx(rectFResolve.top);
        } else {
            fDpToPx2 = 0.0f;
        }
        if (rectFResolve != null) {
            fDpToPx3 = PixelUtil.INSTANCE.dpToPx(rectFResolve.right);
        } else {
            fDpToPx3 = 0.0f;
        }
        if (rectFResolve != null) {
            fDpToPx4 = PixelUtil.INSTANCE.dpToPx(rectFResolve.bottom);
        }
        return new RectF(fDpToPx, fDpToPx2, fDpToPx3, fDpToPx4);
    }

    private final boolean hasInvalidDimensions(RectF positioningArea, RectF paintingArea) {
        return FloatUtil.floatsEqual(positioningArea.width(), 0.0f) || positioningArea.width() < 0.0f || FloatUtil.floatsEqual(positioningArea.height(), 0.0f) || positioningArea.height() < 0.0f || FloatUtil.floatsEqual(paintingArea.width(), 0.0f) || paintingArea.width() < 0.0f || FloatUtil.floatsEqual(paintingArea.height(), 0.0f) || paintingArea.height() < 0.0f;
    }

    private final void updatePath() {
        CornerRadii bottomLeft;
        CornerRadii bottomLeft2;
        CornerRadii bottomRight;
        CornerRadii bottomRight2;
        CornerRadii topRight;
        CornerRadii topRight2;
        CornerRadii topLeft;
        CornerRadii topLeft2;
        if (this.needUpdatePath) {
            this.needUpdatePath = false;
            RectF rectFComputeBorderInsets = computeBorderInsets();
            this.backgroundPositioningArea = new RectF(getBounds().left + rectFComputeBorderInsets.left, getBounds().top + rectFComputeBorderInsets.top, getBounds().right - rectFComputeBorderInsets.right, getBounds().bottom - rectFComputeBorderInsets.bottom);
            this.backgroundPaintingArea = new RectF(getBounds());
            BorderRadiusStyle borderRadiusStyle = this.borderRadius;
            ComputedBorderRadius computedBorderRadiusResolve = borderRadiusStyle != null ? borderRadiusStyle.resolve(getLayoutDirection(), this.context, PixelUtil.INSTANCE.pxToDp(getBounds().width()), PixelUtil.INSTANCE.pxToDp(getBounds().height())) : null;
            BorderRadiusStyle borderRadiusStyle2 = this.borderRadius;
            if (borderRadiusStyle2 != null && borderRadiusStyle2.hasRoundedBorders()) {
                RectF rectF = this.backgroundPaintingArea;
                if (rectF == null) {
                    return;
                }
                Path path = new Path();
                this.backgroundImageClipPath = path;
                float fDpToPx = 0.0f;
                float fDpToPx2 = (computedBorderRadiusResolve == null || (topLeft2 = computedBorderRadiusResolve.getTopLeft()) == null) ? 0.0f : PixelUtil.INSTANCE.dpToPx(topLeft2.getHorizontal());
                float fDpToPx3 = (computedBorderRadiusResolve == null || (topLeft = computedBorderRadiusResolve.getTopLeft()) == null) ? 0.0f : PixelUtil.INSTANCE.dpToPx(topLeft.getVertical());
                float fDpToPx4 = (computedBorderRadiusResolve == null || (topRight2 = computedBorderRadiusResolve.getTopRight()) == null) ? 0.0f : PixelUtil.INSTANCE.dpToPx(topRight2.getHorizontal());
                float fDpToPx5 = (computedBorderRadiusResolve == null || (topRight = computedBorderRadiusResolve.getTopRight()) == null) ? 0.0f : PixelUtil.INSTANCE.dpToPx(topRight.getVertical());
                float fDpToPx6 = (computedBorderRadiusResolve == null || (bottomRight2 = computedBorderRadiusResolve.getBottomRight()) == null) ? 0.0f : PixelUtil.INSTANCE.dpToPx(bottomRight2.getHorizontal());
                float fDpToPx7 = (computedBorderRadiusResolve == null || (bottomRight = computedBorderRadiusResolve.getBottomRight()) == null) ? 0.0f : PixelUtil.INSTANCE.dpToPx(bottomRight.getVertical());
                float fDpToPx8 = (computedBorderRadiusResolve == null || (bottomLeft2 = computedBorderRadiusResolve.getBottomLeft()) == null) ? 0.0f : PixelUtil.INSTANCE.dpToPx(bottomLeft2.getHorizontal());
                if (computedBorderRadiusResolve != null && (bottomLeft = computedBorderRadiusResolve.getBottomLeft()) != null) {
                    fDpToPx = PixelUtil.INSTANCE.dpToPx(bottomLeft.getVertical());
                }
                path.addRoundRect(rectF, new float[]{fDpToPx2, fDpToPx3, fDpToPx4, fDpToPx5, fDpToPx6, fDpToPx7, fDpToPx8, fDpToPx}, Path.Direction.CW);
                return;
            }
            RectF rectF2 = this.backgroundPaintingArea;
            if (rectF2 == null) {
                return;
            }
            Path path2 = new Path();
            this.backgroundImageClipPath = path2;
            path2.addRect(rectF2, Path.Direction.CW);
        }
    }

    private final float positionToPixels(LengthPercentage lengthPercentage, float availableSpace) {
        if (lengthPercentage.getType() == LengthPercentageType.PERCENT) {
            return lengthPercentage.resolve(availableSpace);
        }
        return PixelUtil.INSTANCE.dpToPx(lengthPercentage.resolve(availableSpace));
    }

    private final Pair<Float, Float> calculateBackgroundImageSize(float containerWidth, float containerHeight, float imageWidth, float imageHeight, BackgroundSize backgroundSize, BackgroundRepeat repeat) {
        if (backgroundSize instanceof BackgroundSize.LengthPercentageAuto) {
            BackgroundSize.LengthPercentageAuto lengthPercentageAuto = (BackgroundSize.LengthPercentageAuto) backgroundSize;
            LengthPercentage x = lengthPercentageAuto.getLengthPercentage().getX();
            LengthPercentage y = lengthPercentageAuto.getLengthPercentage().getY();
            if (x != null && y != null) {
                imageWidth = positionToPixels(x, containerWidth);
                imageHeight = positionToPixels(y, containerHeight);
            }
        }
        if ((repeat != null ? repeat.getX() : null) == BackgroundRepeatKeyword.Round && imageWidth > 0.0f && !FloatUtil.floatsEqual(containerWidth % imageWidth, 0.0f)) {
            float fRint = (float) Math.rint(containerWidth / imageWidth);
            if (fRint > 0.0f) {
                imageWidth = containerWidth / fRint;
            }
        }
        if ((repeat != null ? repeat.getY() : null) == BackgroundRepeatKeyword.Round && imageHeight > 0.0f && !FloatUtil.floatsEqual(containerHeight % imageHeight, 0.0f)) {
            float fRint2 = (float) Math.rint(containerHeight / imageHeight);
            if (fRint2 > 0.0f) {
                imageHeight = containerHeight / fRint2;
            }
        }
        return TuplesKt.to(Float.valueOf(imageWidth), Float.valueOf(imageHeight));
    }

    private final Pair<Float, Float> calculateBackgroundPosition(float tileWidth, float tileHeight, BackgroundPosition position) {
        float fPositionToPixels;
        RectF rectF = this.backgroundPositioningArea;
        float fPositionToPixels2 = 0.0f;
        Float fValueOf = Float.valueOf(0.0f);
        if (rectF == null) {
            return TuplesKt.to(fValueOf, fValueOf);
        }
        float fWidth = rectF.width() - tileWidth;
        float fHeight = rectF.height() - tileHeight;
        if ((position != null ? position.getLeft() : null) != null) {
            fPositionToPixels = positionToPixels(position.getLeft(), fWidth);
        } else {
            fPositionToPixels = (position != null ? position.getRight() : null) != null ? fWidth - positionToPixels(position.getRight(), fWidth) : 0.0f;
        }
        float f = fPositionToPixels + rectF.left;
        if ((position != null ? position.getTop() : null) != null) {
            fPositionToPixels2 = positionToPixels(position.getTop(), fHeight);
        } else {
            if ((position != null ? position.getBottom() : null) != null) {
                fPositionToPixels2 = fHeight - positionToPixels(position.getBottom(), fHeight);
            }
        }
        return TuplesKt.to(Float.valueOf(f), Float.valueOf(fPositionToPixels2 + rectF.top));
    }
}
