package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.internal.SystemBarsDefaultInsets_androidKt;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.NavigationDrawerTokens;
import androidx.compose.material3.tokens.ScrimTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: compiled from: NavigationDrawer.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0011\u0010\r\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00128GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0019\u001a\u00020\u00128G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\u001b\u001a\u00020\u00128G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0014R\u0013\u0010\u001d\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001e\u0010\u0007R\u0011\u0010\u001f\u001a\u00020 8G¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Landroidx/compose/material3/DrawerDefaults;", "", "<init>", "()V", "ModalDrawerElevation", "Landroidx/compose/ui/unit/Dp;", "getModalDrawerElevation-D9Ej5fM", "()F", "F", "PermanentDrawerElevation", "getPermanentDrawerElevation-D9Ej5fM", "DismissibleDrawerElevation", "getDismissibleDrawerElevation-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "scrimColor", "Landroidx/compose/ui/graphics/Color;", "getScrimColor", "(Landroidx/compose/runtime/Composer;I)J", "containerColor", "getContainerColor$annotations", "(Landroidx/compose/runtime/Composer;I)V", "getContainerColor", "standardContainerColor", "getStandardContainerColor", "modalContainerColor", "getModalContainerColor", "MaximumDrawerWidth", "getMaximumDrawerWidth-D9Ej5fM", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DrawerDefaults {
    public static final int $stable = 0;
    public static final DrawerDefaults INSTANCE = new DrawerDefaults();
    private static final float ModalDrawerElevation = ElevationTokens.INSTANCE.m5363getLevel0D9Ej5fM();
    private static final float PermanentDrawerElevation = NavigationDrawerTokens.INSTANCE.m5565getStandardContainerElevationD9Ej5fM();
    private static final float DismissibleDrawerElevation = NavigationDrawerTokens.INSTANCE.m5565getStandardContainerElevationD9Ej5fM();
    private static final float MaximumDrawerWidth = NavigationDrawerTokens.INSTANCE.m5562getContainerWidthD9Ej5fM();

    @Deprecated(level = DeprecationLevel.WARNING, message = "Please use standardContainerColor or modalContainerColor instead.", replaceWith = @ReplaceWith(expression = "standardContainerColor", imports = {}))
    public static /* synthetic */ void getContainerColor$annotations(Composer composer, int i) {
    }

    private DrawerDefaults() {
    }

    /* JADX INFO: renamed from: getModalDrawerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3297getModalDrawerElevationD9Ej5fM() {
        return ModalDrawerElevation;
    }

    /* JADX INFO: renamed from: getPermanentDrawerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3298getPermanentDrawerElevationD9Ej5fM() {
        return PermanentDrawerElevation;
    }

    /* JADX INFO: renamed from: getDismissibleDrawerElevation-D9Ej5fM, reason: not valid java name */
    public final float m3295getDismissibleDrawerElevationD9Ej5fM() {
        return DismissibleDrawerElevation;
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 928378975, "C(<get-shape>)1066@45729L5:NavigationDrawer.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(928378975, i, -1, "androidx.compose.material3.DrawerDefaults.<get-shape> (NavigationDrawer.kt:1066)");
        }
        Shape value = ShapesKt.getValue(NavigationDrawerTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getScrimColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1055074989, "C(<get-scrimColor>)1070@45901L5:NavigationDrawer.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1055074989, i, -1, "androidx.compose.material3.DrawerDefaults.<get-scrimColor> (NavigationDrawer.kt:1070)");
        }
        long jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(ColorSchemeKt.getValue(ScrimTokens.INSTANCE.getContainerColor(), composer, 6), 0.32f, 0.0f, 0.0f, 0.0f, 14, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jM6813copywmQWz5c$default;
    }

    public final long getContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1797317261, "C(<get-containerColor>)1079@46319L5:NavigationDrawer.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1797317261, i, -1, "androidx.compose.material3.DrawerDefaults.<get-containerColor> (NavigationDrawer.kt:1079)");
        }
        long value = ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getStandardContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getStandardContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -125949421, "C(<get-standardContainerColor>)1085@46553L5:NavigationDrawer.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-125949421, i, -1, "androidx.compose.material3.DrawerDefaults.<get-standardContainerColor> (NavigationDrawer.kt:1085)");
        }
        long value = ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getStandardContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getModalContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 706424321, "C(<get-modalContainerColor>)1089@46731L5:NavigationDrawer.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(706424321, i, -1, "androidx.compose.material3.DrawerDefaults.<get-modalContainerColor> (NavigationDrawer.kt:1089)");
        }
        long value = ColorSchemeKt.getValue(NavigationDrawerTokens.INSTANCE.getModalContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* JADX INFO: renamed from: getMaximumDrawerWidth-D9Ej5fM, reason: not valid java name */
    public final float m3296getMaximumDrawerWidthD9Ej5fM() {
        return MaximumDrawerWidth;
    }

    public final WindowInsets getWindowInsets(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -909973510, "C(<get-windowInsets>)1098@47013L29:NavigationDrawer.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-909973510, i, -1, "androidx.compose.material3.DrawerDefaults.<get-windowInsets> (NavigationDrawer.kt:1098)");
        }
        WindowInsets windowInsetsM1294onlybOOhFvg = WindowInsetsKt.m1294onlybOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.INSTANCE, composer, 6), WindowInsetsSides.m1311plusgK_yJZ4(WindowInsetsSides.INSTANCE.m1326getVerticalJoeWqyM(), WindowInsetsSides.INSTANCE.m1324getStartJoeWqyM()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return windowInsetsM1294onlybOOhFvg;
    }
}
