package dev.chrisbanes.haze;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Haze.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J3\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0017\u001a\u00020\u0018R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Ldev/chrisbanes/haze/HazeDefaults;", "", "<init>", "()V", "blurRadius", "Landroidx/compose/ui/unit/Dp;", "getBlurRadius-D9Ej5fM", "()F", "F", "noiseFactor", "", "tintAlpha", "tint", "Ldev/chrisbanes/haze/HazeTint;", "color", "Landroidx/compose/ui/graphics/Color;", "tint-8_81llA", "(J)Ldev/chrisbanes/haze/HazeTint;", "style", "Ldev/chrisbanes/haze/HazeStyle;", "backgroundColor", "style-hhQwkJs", "(JLdev/chrisbanes/haze/HazeTint;FF)Ldev/chrisbanes/haze/HazeStyle;", "blurEnabled", "", "haze_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HazeDefaults {
    public static final int $stable = 0;
    public static final HazeDefaults INSTANCE = new HazeDefaults();
    private static final float blurRadius = Dp.m9687constructorimpl(20);
    public static final float noiseFactor = 0.15f;
    public static final float tintAlpha = 0.7f;

    private HazeDefaults() {
    }

    /* JADX INFO: renamed from: getBlurRadius-D9Ej5fM, reason: not valid java name */
    public final float m14452getBlurRadiusD9Ej5fM() {
        return blurRadius;
    }

    /* JADX INFO: renamed from: tint-8_81llA, reason: not valid java name */
    public final HazeTint m14454tint8_81llA(long color) {
        if (color != 16) {
            color = Color.m6813copywmQWz5c$default(color, Color.m6816getAlphaimpl(color) * 0.7f, 0.0f, 0.0f, 0.0f, 14, null);
        }
        return new HazeTint(color, 0, 2, null);
    }

    /* JADX INFO: renamed from: style-hhQwkJs$default, reason: not valid java name */
    public static /* synthetic */ HazeStyle m14451stylehhQwkJs$default(HazeDefaults hazeDefaults, long j, HazeTint hazeTint, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            hazeTint = hazeDefaults.m14454tint8_81llA(j);
        }
        HazeTint hazeTint2 = hazeTint;
        if ((i & 4) != 0) {
            f = blurRadius;
        }
        float f3 = f;
        if ((i & 8) != 0) {
            f2 = 0.15f;
        }
        return hazeDefaults.m14453stylehhQwkJs(j, hazeTint2, f3, f2);
    }

    /* JADX INFO: renamed from: style-hhQwkJs, reason: not valid java name */
    public final HazeStyle m14453stylehhQwkJs(long backgroundColor, HazeTint tint, float blurRadius2, float noiseFactor2) {
        Intrinsics.checkNotNullParameter(tint, "tint");
        return new HazeStyle(backgroundColor, tint, blurRadius2, noiseFactor2, (HazeTint) null, 16, (DefaultConstructorMarker) null);
    }

    public final boolean blurEnabled() {
        return HazeNode_androidKt.isBlurEnabledByDefault();
    }
}
