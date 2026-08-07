package com.box.android.base.compose;

import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.material3.RippleDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.box.android.common.utilities.CommonBoxUtil;
import kotlin.Metadata;

/* JADX INFO: compiled from: BoxTheme.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/box/android/base/compose/BoxTheme;", "", "<init>", "()V", "typography", "Lcom/box/android/base/compose/BoxTypography;", "getTypography", "()Lcom/box/android/base/compose/BoxTypography;", "sizes", "Lcom/box/android/base/compose/BoxSizes;", "getSizes", "()Lcom/box/android/base/compose/BoxSizes;", "colors", "Lcom/box/android/base/compose/BoxColors;", "getColors", "(Landroidx/compose/runtime/Composer;I)Lcom/box/android/base/compose/BoxColors;", "isDarkTheme", "", "(Landroidx/compose/runtime/Composer;I)Z", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "getRippleAlpha", "()Landroidx/compose/material/ripple/RippleAlpha;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxTheme {
    public static final int $stable = 0;
    public static final BoxTheme INSTANCE = new BoxTheme();
    private static final BoxTypography typography = BoxTypography.INSTANCE;
    private static final BoxSizes sizes = BoxSizes.INSTANCE;

    private BoxTheme() {
    }

    public final BoxTypography getTypography() {
        return typography;
    }

    public final BoxSizes getSizes() {
        return sizes;
    }

    public final BoxColors getColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -87860396, "C(<get-colors>)213@6696L21:BoxTheme.kt#vejmn0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-87860396, i, -1, "com.box.android.base.compose.BoxTheme.<get-colors> (BoxTheme.kt:213)");
        }
        BoxColors darkBoxColors = DarkThemeKt.isSystemInDarkTheme(composer, 0) ? BoxColorsKt.getDarkBoxColors() : BoxColorsKt.getLightBoxColors();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return darkBoxColors;
    }

    public final boolean isDarkTheme(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1688679185, "C(<get-isDarkTheme>)216@6838L21:BoxTheme.kt#vejmn0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1688679185, i, -1, "com.box.android.base.compose.BoxTheme.<get-isDarkTheme> (BoxTheme.kt:216)");
        }
        boolean zIsSystemInDarkTheme = DarkThemeKt.isSystemInDarkTheme(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return zIsSystemInDarkTheme;
    }

    public final RippleAlpha getRippleAlpha() {
        if (CommonBoxUtil.isRunningAutomatedTest()) {
            return new RippleAlpha(RippleDefaults.INSTANCE.getRippleAlpha().getDraggedAlpha(), 0.0f, RippleDefaults.INSTANCE.getRippleAlpha().getHoveredAlpha(), RippleDefaults.INSTANCE.getRippleAlpha().getPressedAlpha());
        }
        return RippleDefaults.INSTANCE.getRippleAlpha();
    }
}
