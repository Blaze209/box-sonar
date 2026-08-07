package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import com.box.android.preview.annotations.ui.views.ColorPickerFragment;
import kotlin.Metadata;

/* JADX INFO: compiled from: RadioButton.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/material/RadioButtonDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material/RadioButtonColors;", ColorPickerFragment.EXTRA_SELECTED_COLOR, "Landroidx/compose/ui/graphics/Color;", "unselectedColor", "disabledColor", "colors-RGew2ao", "(JJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/RadioButtonColors;", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RadioButtonDefaults {
    public static final int $stable = 0;
    public static final RadioButtonDefaults INSTANCE = new RadioButtonDefaults();

    private RadioButtonDefaults() {
    }

    /* JADX INFO: renamed from: colors-RGew2ao, reason: not valid java name */
    public final RadioButtonColors m2518colorsRGew2ao(long j, long j2, long j3, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1370708026, "C(colors)N(selectedColor:c#ui.graphics.Color,unselectedColor:c#ui.graphics.Color,disabledColor:c#ui.graphics.Color)158@6429L6,159@6494L6,160@6576L6,160@6619L8,162@6672L151:RadioButton.kt#jmzs0o");
        long jM2344getSecondary0d7_KjU = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m2344getSecondary0d7_KjU() : j;
        long jM6813copywmQWz5c$default = (i2 & 2) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM6813copywmQWz5c$default2 = (i2 & 4) != 0 ? Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1370708026, i, -1, "androidx.compose.material.RadioButtonDefaults.colors (RadioButton.kt:161)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1304537135, "CC(remember):RadioButton.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(jM2344getSecondary0d7_KjU)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(jM6813copywmQWz5c$default)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(jM6813copywmQWz5c$default2)) || (i & 384) == 256);
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            DefaultRadioButtonColors defaultRadioButtonColors = new DefaultRadioButtonColors(jM2344getSecondary0d7_KjU, jM6813copywmQWz5c$default, jM6813copywmQWz5c$default2, null);
            composer.updateRememberedValue(defaultRadioButtonColors);
            objRememberedValue = defaultRadioButtonColors;
        }
        DefaultRadioButtonColors defaultRadioButtonColors2 = (DefaultRadioButtonColors) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultRadioButtonColors2;
    }
}
