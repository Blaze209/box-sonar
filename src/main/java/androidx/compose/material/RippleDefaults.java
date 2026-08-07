package androidx.compose.material;

import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: Ripple.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/material/RippleDefaults;", "", "<init>", "()V", "rippleColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "lightTheme", "", "rippleColor-5vOe2sY", "(JZ)J", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "rippleAlpha-DxMtmZc", "(JZ)Landroidx/compose/material/ripple/RippleAlpha;", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RippleDefaults {
    public static final int $stable = 0;
    public static final RippleDefaults INSTANCE = new RippleDefaults();

    private RippleDefaults() {
    }

    /* JADX INFO: renamed from: rippleColor-5vOe2sY, reason: not valid java name */
    public final long m2521rippleColor5vOe2sY(long contentColor, boolean lightTheme) {
        return (lightTheme || ((double) ColorKt.m6866luminance8_81llA(contentColor)) >= 0.5d) ? contentColor : Color.INSTANCE.m6851getWhite0d7_KjU();
    }

    /* JADX INFO: renamed from: rippleAlpha-DxMtmZc, reason: not valid java name */
    public final RippleAlpha m2520rippleAlphaDxMtmZc(long contentColor, boolean lightTheme) {
        if (lightTheme) {
            return ((double) ColorKt.m6866luminance8_81llA(contentColor)) > 0.5d ? RippleKt.LightThemeHighContrastRippleAlpha : RippleKt.LightThemeLowContrastRippleAlpha;
        }
        return RippleKt.DarkThemeRippleAlpha;
    }
}
