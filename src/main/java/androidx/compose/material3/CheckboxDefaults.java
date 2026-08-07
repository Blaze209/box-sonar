package androidx.compose.material3;

import androidx.compose.material3.tokens.CheckboxTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: compiled from: Checkbox.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JK\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0091\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u00020\u0005*\u00020 8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0013\u0010#\u001a\u00020$¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"Landroidx/compose/material3/CheckboxDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/CheckboxColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/CheckboxColors;", "checkedColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedColor", "checkmarkColor", "disabledCheckedColor", "disabledUncheckedColor", "disabledIndeterminateColor", "colors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/CheckboxColors;", "checkedCheckmarkColor", "uncheckedCheckmarkColor", "disabledCheckmarkColor", "checkedBoxColor", "uncheckedBoxColor", "disabledCheckedBoxColor", "disabledUncheckedBoxColor", "disabledIndeterminateBoxColor", "checkedBorderColor", "uncheckedBorderColor", "disabledBorderColor", "disabledUncheckedBorderColor", "disabledIndeterminateBorderColor", "colors-kwJvTHA", "(JJJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/CheckboxColors;", "defaultCheckboxColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultCheckboxColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/CheckboxColors;", "StrokeWidth", "Landroidx/compose/ui/unit/Dp;", "getStrokeWidth-D9Ej5fM", "()F", "F", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CheckboxDefaults {
    public static final int $stable = 0;
    public static final CheckboxDefaults INSTANCE = new CheckboxDefaults();
    private static final float StrokeWidth = Dp.m9687constructorimpl(2);

    private CheckboxDefaults() {
    }

    public final CheckboxColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -9530498, "C(colors)333@14925L11:Checkbox.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-9530498, i, -1, "androidx.compose.material3.CheckboxDefaults.colors (Checkbox.kt:333)");
        }
        CheckboxColors defaultCheckboxColors$material3 = getDefaultCheckboxColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultCheckboxColors$material3;
    }

    /* JADX INFO: renamed from: colors-5tl4gsc, reason: not valid java name */
    public final CheckboxColors m2930colors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -89536160, "C(colors)N(checkedColor:c#ui.graphics.Color,uncheckedColor:c#ui.graphics.Color,checkmarkColor:c#ui.graphics.Color,disabledCheckedColor:c#ui.graphics.Color,disabledUncheckedColor:c#ui.graphics.Color,disabledIndeterminateColor:c#ui.graphics.Color)359@16315L11:Checkbox.kt#uh7d8r");
        long jM6850getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j;
        long jM6850getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        long jM6850getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4;
        long jM6850getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j5;
        long jM6850getUnspecified0d7_KjU6 = (i2 & 32) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-89536160, i, -1, "androidx.compose.material3.CheckboxDefaults.colors (Checkbox.kt:359)");
        }
        CheckboxColors checkboxColorsM2915copydaRQuJA = getDefaultCheckboxColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m2915copydaRQuJA(jM6850getUnspecified0d7_KjU3, Color.INSTANCE.m6849getTransparent0d7_KjU(), jM6850getUnspecified0d7_KjU, Color.INSTANCE.m6849getTransparent0d7_KjU(), jM6850getUnspecified0d7_KjU4, Color.INSTANCE.m6849getTransparent0d7_KjU(), jM6850getUnspecified0d7_KjU6, jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU4, jM6850getUnspecified0d7_KjU5, jM6850getUnspecified0d7_KjU6, jM6850getUnspecified0d7_KjU3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return checkboxColorsM2915copydaRQuJA;
    }

    /* JADX INFO: renamed from: colors-kwJvTHA, reason: not valid java name */
    public final CheckboxColors m2931colorskwJvTHA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, Composer composer, int i, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, 1465157505, "C(colors)N(checkedCheckmarkColor:c#ui.graphics.Color,uncheckedCheckmarkColor:c#ui.graphics.Color,disabledCheckmarkColor:c#ui.graphics.Color,checkedBoxColor:c#ui.graphics.Color,uncheckedBoxColor:c#ui.graphics.Color,disabledCheckedBoxColor:c#ui.graphics.Color,disabledUncheckedBoxColor:c#ui.graphics.Color,disabledIndeterminateBoxColor:c#ui.graphics.Color,checkedBorderColor:c#ui.graphics.Color,uncheckedBorderColor:c#ui.graphics.Color,disabledBorderColor:c#ui.graphics.Color,disabledUncheckedBorderColor:c#ui.graphics.Color,disabledIndeterminateBorderColor:c#ui.graphics.Color)413@19507L11:Checkbox.kt#uh7d8r");
        long jM6850getUnspecified0d7_KjU = (i3 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j;
        long jM6850getUnspecified0d7_KjU2 = (i3 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU3 = (i3 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        long jM6850getUnspecified0d7_KjU4 = (i3 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4;
        long jM6850getUnspecified0d7_KjU5 = (i3 & 16) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j5;
        long jM6850getUnspecified0d7_KjU6 = (i3 & 32) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j6;
        long jM6850getUnspecified0d7_KjU7 = (i3 & 64) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j7;
        long jM6850getUnspecified0d7_KjU8 = (i3 & 128) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j8;
        long jM6850getUnspecified0d7_KjU9 = (i3 & 256) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j9;
        long jM6850getUnspecified0d7_KjU10 = (i3 & 512) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j10;
        long jM6850getUnspecified0d7_KjU11 = (i3 & 1024) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j11;
        long jM6850getUnspecified0d7_KjU12 = (i3 & 2048) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j12;
        long jM6850getUnspecified0d7_KjU13 = (i3 & 4096) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j13;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1465157505, i, i2, "androidx.compose.material3.CheckboxDefaults.colors (Checkbox.kt:413)");
        }
        CheckboxColors checkboxColorsM2915copydaRQuJA = getDefaultCheckboxColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m2915copydaRQuJA(jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU4, jM6850getUnspecified0d7_KjU5, jM6850getUnspecified0d7_KjU6, jM6850getUnspecified0d7_KjU7, jM6850getUnspecified0d7_KjU8, jM6850getUnspecified0d7_KjU9, jM6850getUnspecified0d7_KjU10, jM6850getUnspecified0d7_KjU11, jM6850getUnspecified0d7_KjU12, jM6850getUnspecified0d7_KjU13, jM6850getUnspecified0d7_KjU3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return checkboxColorsM2915copydaRQuJA;
    }

    public final CheckboxColors getDefaultCheckboxColors$material3(ColorScheme colorScheme) {
        CheckboxColors defaultCheckboxColorsCached = colorScheme.getDefaultCheckboxColorsCached();
        if (defaultCheckboxColorsCached != null) {
            return defaultCheckboxColorsCached;
        }
        CheckboxColors checkboxColors = new CheckboxColors(ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.INSTANCE.getSelectedIconColor()), Color.INSTANCE.m6849getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.INSTANCE.getSelectedContainerColor()), Color.INSTANCE.m6849getTransparent0d7_KjU(), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.INSTANCE.getSelectedDisabledContainerColor()), CheckboxTokens.INSTANCE.getSelectedDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.INSTANCE.m6849getTransparent0d7_KjU(), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.INSTANCE.getSelectedDisabledContainerColor()), CheckboxTokens.INSTANCE.getSelectedDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.INSTANCE.getUnselectedOutlineColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.INSTANCE.getSelectedDisabledContainerColor()), CheckboxTokens.INSTANCE.getSelectedDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.INSTANCE.getUnselectedDisabledOutlineColor()), CheckboxTokens.INSTANCE.getUnselectedDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.INSTANCE.getSelectedDisabledContainerColor()), CheckboxTokens.INSTANCE.getSelectedDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.INSTANCE.getSelectedDisabledIconColor()), null);
        colorScheme.setDefaultCheckboxColorsCached$material3(checkboxColors);
        return checkboxColors;
    }

    /* JADX INFO: renamed from: getStrokeWidth-D9Ej5fM, reason: not valid java name */
    public final float m2932getStrokeWidthD9Ej5fM() {
        return StrokeWidth;
    }
}
