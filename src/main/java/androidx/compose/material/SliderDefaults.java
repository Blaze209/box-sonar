package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Js\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/compose/material/SliderDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material/SliderColors;", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "disabledThumbColor", "activeTrackColor", "inactiveTrackColor", "disabledActiveTrackColor", "disabledInactiveTrackColor", "activeTickColor", "inactiveTickColor", "disabledActiveTickColor", "disabledInactiveTickColor", "colors-q0g_0yA", "(JJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material/SliderColors;", "InactiveTrackAlpha", "", "DisabledInactiveTrackAlpha", "DisabledActiveTrackAlpha", "TickAlpha", "DisabledTickAlpha", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SliderDefaults {
    public static final int $stable = 0;
    public static final float DisabledActiveTrackAlpha = 0.32f;
    public static final float DisabledInactiveTrackAlpha = 0.12f;
    public static final float DisabledTickAlpha = 0.12f;
    public static final SliderDefaults INSTANCE = new SliderDefaults();
    public static final float InactiveTrackAlpha = 0.24f;
    public static final float TickAlpha = 0.54f;

    private SliderDefaults() {
    }

    /* JADX INFO: renamed from: colors-q0g_0yA, reason: not valid java name */
    public final SliderColors m2536colorsq0g_0yA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, Composer composer, int i, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, 436017687, "C(colors)N(thumbColor:c#ui.graphics.Color,disabledThumbColor:c#ui.graphics.Color,activeTrackColor:c#ui.graphics.Color,inactiveTrackColor:c#ui.graphics.Color,disabledActiveTrackColor:c#ui.graphics.Color,disabledInactiveTrackColor:c#ui.graphics.Color,activeTickColor:c#ui.graphics.Color,inactiveTickColor:c#ui.graphics.Color,disabledActiveTickColor:c#ui.graphics.Color,disabledInactiveTickColor:c#ui.graphics.Color)588@25750L6,590@25828L6,591@25888L8,592@25943L6,593@26008L6,596@26179L6,599@26392L33:Slider.kt#jmzs0o");
        long jM2342getPrimary0d7_KjU = (i3 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2342getPrimary0d7_KjU() : j;
        long jM6859compositeOverOWjLjI = (i3 & 2) != 0 ? ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m2346getSurface0d7_KjU()) : j2;
        long jM2342getPrimary0d7_KjU2 = (i3 & 4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2342getPrimary0d7_KjU() : j3;
        long jM6813copywmQWz5c$default = (i3 & 8) != 0 ? Color.m6813copywmQWz5c$default(jM2342getPrimary0d7_KjU2, 0.24f, 0.0f, 0.0f, 0.0f, 14, null) : j4;
        long jM6813copywmQWz5c$default2 = (i3 & 16) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), 0.32f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        long jM6813copywmQWz5c$default3 = (i3 & 32) != 0 ? Color.m6813copywmQWz5c$default(jM6813copywmQWz5c$default2, 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long jM6813copywmQWz5c$default4 = (i3 & 64) != 0 ? Color.m6813copywmQWz5c$default(ColorsKt.m2360contentColorForek8zF_U(jM2342getPrimary0d7_KjU2, composer, (i >> 6) & 14), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j7;
        long jM6813copywmQWz5c$default5 = (i3 & 128) != 0 ? Color.m6813copywmQWz5c$default(jM2342getPrimary0d7_KjU2, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j8;
        long jM6813copywmQWz5c$default6 = (i3 & 256) != 0 ? Color.m6813copywmQWz5c$default(jM6813copywmQWz5c$default4, 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j9;
        long jM6813copywmQWz5c$default7 = (i3 & 512) != 0 ? Color.m6813copywmQWz5c$default(jM6813copywmQWz5c$default3, 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j10;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(436017687, i, i2, "androidx.compose.material.SliderDefaults.colors (Slider.kt:605)");
        }
        DefaultSliderColors defaultSliderColors = new DefaultSliderColors(jM2342getPrimary0d7_KjU, jM6859compositeOverOWjLjI, jM2342getPrimary0d7_KjU2, jM6813copywmQWz5c$default, jM6813copywmQWz5c$default2, jM6813copywmQWz5c$default3, jM6813copywmQWz5c$default4, jM6813copywmQWz5c$default5, jM6813copywmQWz5c$default6, jM6813copywmQWz5c$default7, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultSliderColors;
    }
}
