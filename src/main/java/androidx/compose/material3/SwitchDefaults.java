package androidx.compose.material3;

import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: compiled from: Switch.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J¯\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u00020\u0005*\u00020\u001b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001e\u001a\u00020\u001f¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Landroidx/compose/material3/SwitchDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/SwitchColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SwitchColors;", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "checkedBorderColor", "checkedIconColor", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedBorderColor", "uncheckedIconColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledCheckedBorderColor", "disabledCheckedIconColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "disabledUncheckedBorderColor", "disabledUncheckedIconColor", "colors-V1nXRL4", "(JJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SwitchColors;", "defaultSwitchColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultSwitchColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SwitchColors;", "IconSize", "Landroidx/compose/ui/unit/Dp;", "getIconSize-D9Ej5fM", "()F", "F", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SwitchDefaults {
    public static final int $stable = 0;
    public static final SwitchDefaults INSTANCE = new SwitchDefaults();
    private static final float IconSize = Dp.m9687constructorimpl(16);

    private SwitchDefaults() {
    }

    public final SwitchColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 435552781, "C(colors)314@12032L11:Switch.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(435552781, i, -1, "androidx.compose.material3.SwitchDefaults.colors (Switch.kt:314)");
        }
        SwitchColors defaultSwitchColors$material3 = getDefaultSwitchColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultSwitchColors$material3;
    }

    /* JADX INFO: renamed from: colors-V1nXRL4, reason: not valid java name */
    public final SwitchColors m4356colorsV1nXRL4(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, Composer composer, int i, int i2, int i3) {
        int i4;
        long jM6859compositeOverOWjLjI;
        ComposerKt.sourceInformationMarkerStart(composer, 1937926421, "C(colors)N(checkedThumbColor:c#ui.graphics.Color,checkedTrackColor:c#ui.graphics.Color,checkedBorderColor:c#ui.graphics.Color,checkedIconColor:c#ui.graphics.Color,uncheckedThumbColor:c#ui.graphics.Color,uncheckedTrackColor:c#ui.graphics.Color,uncheckedBorderColor:c#ui.graphics.Color,uncheckedIconColor:c#ui.graphics.Color,disabledCheckedThumbColor:c#ui.graphics.Color,disabledCheckedTrackColor:c#ui.graphics.Color,disabledCheckedBorderColor:c#ui.graphics.Color,disabledCheckedIconColor:c#ui.graphics.Color,disabledUncheckedThumbColor:c#ui.graphics.Color,disabledUncheckedTrackColor:c#ui.graphics.Color,disabledUncheckedBorderColor:c#ui.graphics.Color,disabledUncheckedIconColor:c#ui.graphics.Color)339@13784L5,340@13858L5,342@13985L5,343@14064L5,344@14142L5,345@14233L5,346@14309L5,348@14412L5,350@14537L11,352@14654L5,354@14770L11,357@14948L5,359@15071L11,361@15193L5,363@15320L11,365@15441L5,367@15557L11,369@15686L5,371@15802L11,373@15921L5,375@16046L11:Switch.kt#uh7d8r");
        long value = (i3 & 1) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getSelectedHandleColor(), composer, 6) : j;
        long value2 = (i3 & 2) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getSelectedTrackColor(), composer, 6) : j2;
        long jM6849getTransparent0d7_KjU = (i3 & 4) != 0 ? Color.INSTANCE.m6849getTransparent0d7_KjU() : j3;
        long value3 = (i3 & 8) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getSelectedIconColor(), composer, 6) : j4;
        long value4 = (i3 & 16) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedHandleColor(), composer, 6) : j5;
        long value5 = (i3 & 32) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedTrackColor(), composer, 6) : j6;
        long value6 = (i3 & 64) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedFocusTrackOutlineColor(), composer, 6) : j7;
        long value7 = (i3 & 128) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedIconColor(), composer, 6) : j8;
        long jM6859compositeOverOWjLjI2 = (i3 & 256) != 0 ? ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledSelectedHandleColor(), composer, 6), SwitchTokens.INSTANCE.getDisabledSelectedHandleOpacity(), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurface()) : j9;
        long jM6859compositeOverOWjLjI3 = (i3 & 512) != 0 ? ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledSelectedTrackColor(), composer, 6), SwitchTokens.INSTANCE.getDisabledTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurface()) : j10;
        long jM6849getTransparent0d7_KjU2 = (i3 & 1024) != 0 ? Color.INSTANCE.m6849getTransparent0d7_KjU() : j11;
        if ((i3 & 2048) != 0) {
            i4 = 6;
            jM6859compositeOverOWjLjI = ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledSelectedIconColor(), composer, 6), SwitchTokens.INSTANCE.getDisabledSelectedIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurface());
        } else {
            i4 = 6;
            jM6859compositeOverOWjLjI = j12;
        }
        long jM6859compositeOverOWjLjI4 = (i3 & 4096) != 0 ? ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedHandleColor(), composer, i4), SwitchTokens.INSTANCE.getDisabledUnselectedHandleOpacity(), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, i4).getSurface()) : j13;
        long jM6859compositeOverOWjLjI5 = (i3 & 8192) != 0 ? ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedTrackColor(), composer, i4), SwitchTokens.INSTANCE.getDisabledTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, i4).getSurface()) : j14;
        long jM6859compositeOverOWjLjI6 = (i3 & 16384) != 0 ? ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedTrackOutlineColor(), composer, i4), SwitchTokens.INSTANCE.getDisabledTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, i4).getSurface()) : j15;
        long jM6859compositeOverOWjLjI7 = (i3 & 32768) != 0 ? ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedIconColor(), composer, i4), SwitchTokens.INSTANCE.getDisabledUnselectedIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, i4).getSurface()) : j16;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1937926421, i, i2, "androidx.compose.material3.SwitchDefaults.colors (Switch.kt:377)");
        }
        SwitchColors switchColors = new SwitchColors(value, value2, jM6849getTransparent0d7_KjU, value3, value4, value5, value6, value7, jM6859compositeOverOWjLjI2, jM6859compositeOverOWjLjI3, jM6849getTransparent0d7_KjU2, jM6859compositeOverOWjLjI, jM6859compositeOverOWjLjI4, jM6859compositeOverOWjLjI5, jM6859compositeOverOWjLjI6, jM6859compositeOverOWjLjI7, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return switchColors;
    }

    public final SwitchColors getDefaultSwitchColors$material3(ColorScheme colorScheme) {
        SwitchColors defaultSwitchColorsCached = colorScheme.getDefaultSwitchColorsCached();
        if (defaultSwitchColorsCached != null) {
            return defaultSwitchColorsCached;
        }
        SwitchColors switchColors = new SwitchColors(ColorSchemeKt.fromToken(colorScheme, SwitchTokens.INSTANCE.getSelectedHandleColor()), ColorSchemeKt.fromToken(colorScheme, SwitchTokens.INSTANCE.getSelectedTrackColor()), Color.INSTANCE.m6849getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, SwitchTokens.INSTANCE.getSelectedIconColor()), ColorSchemeKt.fromToken(colorScheme, SwitchTokens.INSTANCE.getUnselectedHandleColor()), ColorSchemeKt.fromToken(colorScheme, SwitchTokens.INSTANCE.getUnselectedTrackColor()), ColorSchemeKt.fromToken(colorScheme, SwitchTokens.INSTANCE.getUnselectedFocusTrackOutlineColor()), ColorSchemeKt.fromToken(colorScheme, SwitchTokens.INSTANCE.getUnselectedIconColor()), ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SwitchTokens.INSTANCE.getDisabledSelectedHandleColor()), SwitchTokens.INSTANCE.getDisabledSelectedHandleOpacity(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.getSurface()), ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SwitchTokens.INSTANCE.getDisabledSelectedTrackColor()), SwitchTokens.INSTANCE.getDisabledTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.getSurface()), Color.INSTANCE.m6849getTransparent0d7_KjU(), ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SwitchTokens.INSTANCE.getDisabledSelectedIconColor()), SwitchTokens.INSTANCE.getDisabledSelectedIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.getSurface()), ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SwitchTokens.INSTANCE.getDisabledUnselectedHandleColor()), SwitchTokens.INSTANCE.getDisabledUnselectedHandleOpacity(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.getSurface()), ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SwitchTokens.INSTANCE.getDisabledUnselectedTrackColor()), SwitchTokens.INSTANCE.getDisabledTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.getSurface()), ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SwitchTokens.INSTANCE.getDisabledUnselectedTrackOutlineColor()), SwitchTokens.INSTANCE.getDisabledTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.getSurface()), ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SwitchTokens.INSTANCE.getDisabledUnselectedIconColor()), SwitchTokens.INSTANCE.getDisabledUnselectedIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.getSurface()), null);
        colorScheme.setDefaultSwitchColorsCached$material3(switchColors);
        return switchColors;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m4357getIconSizeD9Ej5fM() {
        return IconSize;
    }
}
