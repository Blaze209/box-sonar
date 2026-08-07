package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* JADX INFO: compiled from: FloatingActionButton.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ7\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/material/FloatingActionButtonDefaults;", "", "<init>", "()V", "elevation", "Landroidx/compose/material/FloatingActionButtonElevation;", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "elevation-ixp7dh8", "(FFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/FloatingActionButtonElevation;", "hoveredElevation", "focusedElevation", "elevation-xZ9-QkE", "(FFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/FloatingActionButtonElevation;", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FloatingActionButtonDefaults {
    public static final int $stable = 0;
    public static final FloatingActionButtonDefaults INSTANCE = new FloatingActionButtonDefaults();

    private FloatingActionButtonDefaults() {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another overload of elevation")
    /* JADX INFO: renamed from: elevation-ixp7dh8, reason: not valid java name */
    public final /* synthetic */ FloatingActionButtonElevation m2426elevationixp7dh8(float f, float f2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -654132828, "C(elevation)N(defaultElevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp)215@9540L154:FloatingActionButton.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            f = Dp.m9687constructorimpl(6);
        }
        float f3 = f;
        if ((i2 & 2) != 0) {
            f2 = Dp.m9687constructorimpl(12);
        }
        float f4 = f2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-654132828, i, -1, "androidx.compose.material.FloatingActionButtonDefaults.elevation (FloatingActionButton.kt:215)");
        }
        float f5 = 8;
        FloatingActionButtonElevation floatingActionButtonElevationM2427elevationxZ9QkE = m2427elevationxZ9QkE(f3, f4, Dp.m9687constructorimpl(f5), Dp.m9687constructorimpl(f5), composer, (i & 14) | 3456 | (i & 112) | (57344 & (i << 6)), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return floatingActionButtonElevationM2427elevationxZ9QkE;
    }

    /* JADX INFO: renamed from: elevation-xZ9-QkE, reason: not valid java name */
    public final FloatingActionButtonElevation m2427elevationxZ9QkE(float f, float f2, float f3, float f4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 380403812, "C(elevation)N(defaultElevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp)239@10503L368:FloatingActionButton.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            f = Dp.m9687constructorimpl(6);
        }
        float f5 = f;
        if ((i2 & 2) != 0) {
            f2 = Dp.m9687constructorimpl(12);
        }
        float f6 = f2;
        if ((i2 & 4) != 0) {
            f3 = Dp.m9687constructorimpl(8);
        }
        float f7 = f3;
        if ((i2 & 8) != 0) {
            f4 = Dp.m9687constructorimpl(8);
        }
        float f8 = f4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(380403812, i, -1, "androidx.compose.material.FloatingActionButtonDefaults.elevation (FloatingActionButton.kt:238)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 495850516, "CC(remember):FloatingActionButton.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(f5)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(f6)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(f7)) || (i & 384) == 256) | ((((i & 7168) ^ 3072) > 2048 && composer.changed(f8)) || (i & 3072) == 2048);
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            DefaultFloatingActionButtonElevation defaultFloatingActionButtonElevation = new DefaultFloatingActionButtonElevation(f5, f6, f7, f8, null);
            composer.updateRememberedValue(defaultFloatingActionButtonElevation);
            objRememberedValue = defaultFloatingActionButtonElevation;
        }
        DefaultFloatingActionButtonElevation defaultFloatingActionButtonElevation2 = (DefaultFloatingActionButtonElevation) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultFloatingActionButtonElevation2;
    }
}
