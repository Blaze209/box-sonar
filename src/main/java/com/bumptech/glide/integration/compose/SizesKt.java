package com.bumptech.glide.integration.compose;

import androidx.compose.ui.unit.Constraints;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.integration.ktx.FlowsKt;
import com.bumptech.glide.integration.ktx.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: Sizes.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001b\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0016\u0010\u0005\u001a\u00020\u0006*\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007H\u0000\u001a\u0018\u0010\t\u001a\u0004\u0018\u00010\u0001*\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007H\u0000\u001a\u001b\u0010\n\u001a\u0004\u0018\u00010\u0001*\u00020\u000bH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\u0004\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\r"}, d2 = {"inferredGlideSize", "Lcom/bumptech/glide/integration/ktx/Size;", "Landroidx/compose/ui/unit/Constraints;", "inferredGlideSize-BRTryo0", "(J)Lcom/bumptech/glide/integration/ktx/Size;", "isOverrideSizeSet", "", "Lcom/bumptech/glide/RequestBuilder;", "", "overrideSize", "toGlideSize", "Landroidx/compose/ui/geometry/Size;", "toGlideSize-uvyYCjk", "compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SizesKt {
    public static final Size overrideSize(RequestBuilder<? extends Object> requestBuilder) {
        Intrinsics.checkNotNullParameter(requestBuilder, "<this>");
        if (isOverrideSizeSet(requestBuilder)) {
            return new Size(requestBuilder.getOverrideWidth(), requestBuilder.getOverrideHeight());
        }
        return null;
    }

    public static final boolean isOverrideSizeSet(RequestBuilder<? extends Object> requestBuilder) {
        Intrinsics.checkNotNullParameter(requestBuilder, "<this>");
        return FlowsKt.isValidGlideDimension(requestBuilder.getOverrideWidth()) && FlowsKt.isValidGlideDimension(requestBuilder.getOverrideHeight());
    }

    /* JADX INFO: renamed from: toGlideSize-uvyYCjk, reason: not valid java name */
    public static final Size m13173toGlideSizeuvyYCjk(long j) {
        int iRoundToInt = MathKt.roundToInt(androidx.compose.ui.geometry.Size.m6638getWidthimpl(j));
        int iRoundToInt2 = MathKt.roundToInt(androidx.compose.ui.geometry.Size.m6635getHeightimpl(j));
        if (FlowsKt.isValidGlideDimension(iRoundToInt) && FlowsKt.isValidGlideDimension(iRoundToInt2)) {
            return new Size(iRoundToInt, iRoundToInt2);
        }
        return null;
    }

    /* JADX INFO: renamed from: inferredGlideSize-BRTryo0, reason: not valid java name */
    public static final Size m13172inferredGlideSizeBRTryo0(long j) {
        int iM9640getMaxWidthimpl = Constraints.m9636getHasBoundedWidthimpl(j) ? Constraints.m9640getMaxWidthimpl(j) : Integer.MIN_VALUE;
        int iM9639getMaxHeightimpl = Constraints.m9635getHasBoundedHeightimpl(j) ? Constraints.m9639getMaxHeightimpl(j) : Integer.MIN_VALUE;
        if (FlowsKt.isValidGlideDimension(iM9640getMaxWidthimpl) && FlowsKt.isValidGlideDimension(iM9639getMaxHeightimpl)) {
            return new Size(iM9640getMaxWidthimpl, iM9639getMaxHeightimpl);
        }
        return null;
    }
}
