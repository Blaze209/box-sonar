package com.box.android.common.extensions;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.ProgressBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProgressBarExtensions.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004\u001a\u001a\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¨\u0006\b"}, d2 = {"setBackgroundRingColor", "", "Landroid/widget/ProgressBar;", "bgColor", "", "setProgressRingColor", "progressColor", "setRingsColor", "common_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ProgressBarExtensionsKt {
    public static final void setBackgroundRingColor(ProgressBar progressBar, int i) {
        Intrinsics.checkNotNullParameter(progressBar, "<this>");
        if (progressBar.getProgressDrawable() instanceof LayerDrawable) {
            Drawable progressDrawable = progressBar.getProgressDrawable();
            Intrinsics.checkNotNull(progressDrawable, "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
            if (((LayerDrawable) progressDrawable).getNumberOfLayers() == 2) {
                Drawable progressDrawable2 = progressBar.getProgressDrawable();
                Intrinsics.checkNotNull(progressDrawable2, "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
                ((LayerDrawable) progressDrawable2).getDrawable(0).setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
                return;
            }
        }
        throw new IllegalArgumentException("A correct layer drawable must be provided. job_progress_drawable_can be used");
    }

    public static final void setProgressRingColor(ProgressBar progressBar, int i) {
        Intrinsics.checkNotNullParameter(progressBar, "<this>");
        if (progressBar.getProgressDrawable() instanceof LayerDrawable) {
            Drawable progressDrawable = progressBar.getProgressDrawable();
            Intrinsics.checkNotNull(progressDrawable, "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
            if (((LayerDrawable) progressDrawable).getNumberOfLayers() == 2) {
                Drawable progressDrawable2 = progressBar.getProgressDrawable();
                Intrinsics.checkNotNull(progressDrawable2, "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
                ((LayerDrawable) progressDrawable2).getDrawable(1).setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
                return;
            }
        }
        throw new IllegalArgumentException("A correct layer drawable must be provided. job_progress_drawable_can be used");
    }

    public static final void setRingsColor(ProgressBar progressBar, int i, int i2) {
        Intrinsics.checkNotNullParameter(progressBar, "<this>");
        setBackgroundRingColor(progressBar, i);
        setProgressRingColor(progressBar, i2);
    }
}
