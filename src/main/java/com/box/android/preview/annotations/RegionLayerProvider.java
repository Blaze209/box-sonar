package com.box.android.preview.annotations;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.box.android.preview.R;
import com.box.android.preview.annotations.model.AnnotationSelectedState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: RegionLayerProvider.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\"\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/box/android/preview/annotations/RegionLayerProvider;", "Lcom/box/android/preview/annotations/LayerProvider;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "primaryBorderColor", "", "secondaryBorderColor", "selectedBorderColor", "primaryStrokeWidth", "secondaryStrokeWidth", "widthScalingFactor", "", "getWidthScalingFactor", "()F", "setWidthScalingFactor", "(F)V", "getLayersDefault", "Landroid/graphics/drawable/LayerDrawable;", "rect", "Landroid/graphics/Rect;", "intersection", "Landroid/graphics/RectF;", "getLayersSelected", "getLayers", "selectedState", "Lcom/box/android/preview/annotations/model/AnnotationSelectedState;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RegionLayerProvider extends LayerProvider {
    public static final int $stable = 8;
    private final int primaryBorderColor;
    private final int primaryStrokeWidth;
    private final int secondaryBorderColor;
    private final int secondaryStrokeWidth;
    private final int selectedBorderColor;
    private float widthScalingFactor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RegionLayerProvider(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.primaryBorderColor = context.getResources().getColor(R.color.box_green_1_50pc);
        this.secondaryBorderColor = context.getResources().getColor(android.R.color.white);
        this.selectedBorderColor = context.getResources().getColor(R.color.box_green_1);
        this.primaryStrokeWidth = MathKt.roundToInt(context.getResources().getDimension(R.dimen.box_annotation_bounding_box_stroke_width));
        this.secondaryStrokeWidth = MathKt.roundToInt(context.getResources().getDimension(R.dimen.box_annotation_bounding_box_stroke_width_secondary));
        this.widthScalingFactor = 1.0f;
    }

    public final float getWidthScalingFactor() {
        return this.widthScalingFactor;
    }

    public final void setWidthScalingFactor(float f) {
        this.widthScalingFactor = f;
    }

    private final LayerDrawable getLayersDefault(Rect rect, RectF intersection) {
        LayerDrawable layerDrawable = new LayerDrawable(new RectDrawable[]{new RectDrawable(this.primaryBorderColor, this.primaryStrokeWidth * this.widthScalingFactor, intersection, null, 8, null), new RectDrawable(this.secondaryBorderColor, this.secondaryStrokeWidth * this.widthScalingFactor, intersection, null, 8, null)});
        int i = (int) ((this.primaryStrokeWidth * this.widthScalingFactor) / 2);
        Drawable drawable = layerDrawable.getDrawable(0);
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = layerDrawable.getDrawable(1);
        if (drawable2 != null) {
            drawable2.setBounds(new Rect(rect.left + i, rect.top + i, rect.right - i, rect.bottom - i));
        }
        return layerDrawable;
    }

    private final LayerDrawable getLayersSelected(Rect rect) {
        int color;
        Resources resources;
        int i = this.selectedBorderColor;
        float f = this.primaryStrokeWidth * this.widthScalingFactor;
        Context context = getContext().get();
        if (context != null && (resources = context.getResources()) != null) {
            color = resources.getColor(R.color.box_black);
        } else {
            color = Color.parseColor("#ff000000");
        }
        LayerDrawable layerDrawable = new LayerDrawable(new SelectedDrawable[]{new SelectedDrawable(i, f, color)});
        Drawable drawable = layerDrawable.getDrawable(0);
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        return layerDrawable;
    }

    @Override // com.box.android.preview.annotations.LayerProvider
    public LayerDrawable getLayers(Rect rect, AnnotationSelectedState selectedState, RectF intersection) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(selectedState, "selectedState");
        if (Intrinsics.areEqual(selectedState, AnnotationSelectedState.SELECTED.INSTANCE)) {
            return getLayersSelected(rect);
        }
        if (!Intrinsics.areEqual(selectedState, AnnotationSelectedState.UNSELECTED.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        return getLayersDefault(rect, intersection);
    }
}
