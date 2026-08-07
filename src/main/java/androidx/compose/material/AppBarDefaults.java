package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: compiled from: AppBar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0015"}, d2 = {"Landroidx/compose/material/AppBarDefaults;", "", "<init>", "()V", "TopAppBarElevation", "Landroidx/compose/ui/unit/Dp;", "getTopAppBarElevation-D9Ej5fM", "()F", "F", "BottomAppBarElevation", "getBottomAppBarElevation-D9Ej5fM", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "topAppBarWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getTopAppBarWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "bottomAppBarWindowInsets", "getBottomAppBarWindowInsets", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AppBarDefaults {
    public static final int $stable = 0;
    public static final AppBarDefaults INSTANCE = new AppBarDefaults();
    private static final float TopAppBarElevation = Dp.m9687constructorimpl(4);
    private static final float BottomAppBarElevation = Dp.m9687constructorimpl(8);
    private static final PaddingValues ContentPadding = PaddingKt.m1215PaddingValuesa9UjIt4$default(AppBarKt.AppBarHorizontalPadding, 0.0f, AppBarKt.AppBarHorizontalPadding, 0.0f, 10, null);

    private AppBarDefaults() {
    }

    /* JADX INFO: renamed from: getTopAppBarElevation-D9Ej5fM, reason: not valid java name */
    public final float m2246getTopAppBarElevationD9Ej5fM() {
        return TopAppBarElevation;
    }

    /* JADX INFO: renamed from: getBottomAppBarElevation-D9Ej5fM, reason: not valid java name */
    public final float m2245getBottomAppBarElevationD9Ej5fM() {
        return BottomAppBarElevation;
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    public final WindowInsets getTopAppBarWindowInsets(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -427176825, "C(<get-topAppBarWindowInsets>)443@19751L29:AppBar.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-427176825, i, -1, "androidx.compose.material.AppBarDefaults.<get-topAppBarWindowInsets> (AppBar.kt:443)");
        }
        WindowInsets windowInsetsM1294onlybOOhFvg = WindowInsetsKt.m1294onlybOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.INSTANCE, composer, 6), WindowInsetsSides.m1311plusgK_yJZ4(WindowInsetsSides.INSTANCE.m1321getHorizontalJoeWqyM(), WindowInsetsSides.INSTANCE.m1325getTopJoeWqyM()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return windowInsetsM1294onlybOOhFvg;
    }

    public final WindowInsets getBottomAppBarWindowInsets(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1469837023, "C(<get-bottomAppBarWindowInsets>)451@20063L29:AppBar.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1469837023, i, -1, "androidx.compose.material.AppBarDefaults.<get-bottomAppBarWindowInsets> (AppBar.kt:450)");
        }
        WindowInsets windowInsetsM1294onlybOOhFvg = WindowInsetsKt.m1294onlybOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.INSTANCE, composer, 6), WindowInsetsSides.m1311plusgK_yJZ4(WindowInsetsSides.INSTANCE.m1321getHorizontalJoeWqyM(), WindowInsetsSides.INSTANCE.m1319getBottomJoeWqyM()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return windowInsetsM1294onlybOOhFvg;
    }
}
