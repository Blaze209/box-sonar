package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: Snackbar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Landroidx/compose/material/SnackbarDefaults;", "", "<init>", "()V", "SnackbarOverlayAlpha", "", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "getBackgroundColor", "(Landroidx/compose/runtime/Composer;I)J", "primaryActionColor", "getPrimaryActionColor", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SnackbarDefaults {
    public static final int $stable = 0;
    public static final SnackbarDefaults INSTANCE = new SnackbarDefaults();
    private static final float SnackbarOverlayAlpha = 0.8f;

    private SnackbarDefaults() {
    }

    public final long getBackgroundColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1630911716, "C(<get-backgroundColor>)201@8577L6,203@8691L6:Snackbar.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1630911716, i, -1, "androidx.compose.material.SnackbarDefaults.<get-backgroundColor> (Snackbar.kt:201)");
        }
        long jM6859compositeOverOWjLjI = ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m2341getOnSurface0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m2346getSurface0d7_KjU());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jM6859compositeOverOWjLjI;
    }

    public final long getPrimaryActionColor(Composer composer, int i) {
        long jM2343getPrimaryVariant0d7_KjU;
        ComposerKt.sourceInformationMarkerStart(composer, -810329402, "C(<get-primaryActionColor>)222@9639L6:Snackbar.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-810329402, i, -1, "androidx.compose.material.SnackbarDefaults.<get-primaryActionColor> (Snackbar.kt:221)");
        }
        Colors colors = MaterialTheme.INSTANCE.getColors(composer, 6);
        if (colors.isLight()) {
            jM2343getPrimaryVariant0d7_KjU = ColorKt.m6859compositeOverOWjLjI(Color.m6813copywmQWz5c$default(colors.m2346getSurface0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), colors.m2342getPrimary0d7_KjU());
        } else {
            jM2343getPrimaryVariant0d7_KjU = colors.m2343getPrimaryVariant0d7_KjU();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jM2343getPrimaryVariant0d7_KjU;
    }
}
