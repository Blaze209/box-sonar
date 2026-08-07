package dev.chrisbanes.haze;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: HazeSourceNode.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"boostForFallback", "Ldev/chrisbanes/haze/HazeTint;", "blurRadius", "Landroidx/compose/ui/unit/Dp;", "boostForFallback-3ABfNKs", "(Ldev/chrisbanes/haze/HazeTint;F)Ldev/chrisbanes/haze/HazeTint;", "boostAlphaForBlurRadius", "Landroidx/compose/ui/graphics/Color;", "boostAlphaForBlurRadius-l07J4OM", "(JF)J", "haze_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class HazeSourceNodeKt {
    /* JADX INFO: renamed from: boostAlphaForBlurRadius-l07J4OM, reason: not valid java name */
    private static final long m14491boostAlphaForBlurRadiusl07J4OM(long j, float f) {
        return Color.m6813copywmQWz5c$default(j, RangesKt.coerceAtMost(Color.m6816getAlphaimpl(j) * (1 + (f / 72)), 1.0f), 0.0f, 0.0f, 0.0f, 14, null);
    }

    /* JADX INFO: renamed from: boostForFallback-3ABfNKs, reason: not valid java name */
    public static final HazeTint m14492boostForFallback3ABfNKs(HazeTint boostForFallback, float f) {
        Intrinsics.checkNotNullParameter(boostForFallback, "$this$boostForFallback");
        if (Float.isNaN(f)) {
            f = HazeDefaults.INSTANCE.m14452getBlurRadiusD9Ej5fM();
        }
        return HazeTint.m14503copyxETnrds$default(boostForFallback, m14491boostAlphaForBlurRadiusl07J4OM(boostForFallback.m14508getColor0d7_KjU(), f), 0, 2, null);
    }
}
