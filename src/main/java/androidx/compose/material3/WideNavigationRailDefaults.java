package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.internal.SystemBarsDefaultInsets_androidKt;
import androidx.compose.material3.tokens.NavigationRailCollapsedTokens;
import androidx.compose.material3.tokens.NavigationRailExpandedTokens;
import androidx.compose.material3.tokens.ScrimTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: compiled from: WideNavigationRail.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010\u001aJA\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u001c2\b\b\u0002\u0010 \u001a\u00020\u001cH\u0007¢\u0006\u0004\b!\u0010\"J7\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u001cH\u0007¢\u0006\u0004\b#\u0010$R\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010%\u001a\u00020\u00058GX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0007R\u001a\u0010)\u001a\u00020\u00058GX\u0087\u0004¢\u0006\f\u0012\u0004\b*\u0010'\u001a\u0004\b+\u0010\u0007R\u0014\u0010\u001b\u001a\u00020\u001c8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010\u001e\u001a\u00020\u001c8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010-R\u0018\u0010/\u001a\u00020\u0019*\u0002008CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00063"}, d2 = {"Landroidx/compose/material3/WideNavigationRailDefaults;", "", "<init>", "()V", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "arrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "modalCollapsedShape", "getModalCollapsedShape", "modalExpandedShape", "getModalExpandedShape", "ModalExpandedProperties", "Landroidx/compose/material3/ModalWideNavigationRailProperties;", "getModalExpandedProperties", "()Landroidx/compose/material3/ModalWideNavigationRailProperties;", "colors", "Landroidx/compose/material3/WideNavigationRailColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/WideNavigationRailColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "modalContainerColor", "modalScrimColor", "modalContentColor", "colors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/WideNavigationRailColors;", "colors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/WideNavigationRailColors;", "containerShape", "getContainerShape$annotations", "(Landroidx/compose/runtime/Composer;I)V", "getContainerShape", "modalContainerShape", "getModalContainerShape$annotations", "getModalContainerShape", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "getModalContainerColor", "defaultWideWideNavigationRailColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultWideWideNavigationRailColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/WideNavigationRailColors;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WideNavigationRailDefaults {
    public static final int $stable = 0;
    public static final WideNavigationRailDefaults INSTANCE = new WideNavigationRailDefaults();
    private static final ModalWideNavigationRailProperties ModalExpandedProperties = WideNavigationRail_androidKt.createDefaultModalWideNavigationRailProperties();

    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of shape.", replaceWith = @ReplaceWith(expression = "WideNavigationRailDefaults.shape", imports = {}))
    public static /* synthetic */ void getContainerShape$annotations(Composer composer, int i) {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of modalExpandedShape.", replaceWith = @ReplaceWith(expression = "WideNavigationRailDefaults.modalExpandedShape", imports = {}))
    public static /* synthetic */ void getModalContainerShape$annotations(Composer composer, int i) {
    }

    private WideNavigationRailDefaults() {
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1756160851, "C(<get-shape>)912@43598L5:WideNavigationRail.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1756160851, i, -1, "androidx.compose.material3.WideNavigationRailDefaults.<get-shape> (WideNavigationRail.kt:912)");
        }
        Shape value = ShapesKt.getValue(NavigationRailCollapsedTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Arrangement.Vertical getArrangement() {
        return Arrangement.INSTANCE.getTop();
    }

    public final WindowInsets getWindowInsets(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1769402286, "C(<get-windowInsets>)922@43896L29:WideNavigationRail.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1769402286, i, -1, "androidx.compose.material3.WideNavigationRailDefaults.<get-windowInsets> (WideNavigationRail.kt:922)");
        }
        WindowInsets windowInsetsM1294onlybOOhFvg = WindowInsetsKt.m1294onlybOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.INSTANCE, composer, 6), WindowInsetsSides.m1311plusgK_yJZ4(WindowInsetsSides.INSTANCE.m1326getVerticalJoeWqyM(), WindowInsetsSides.INSTANCE.m1324getStartJoeWqyM()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return windowInsetsM1294onlybOOhFvg;
    }

    public final Shape getModalCollapsedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 926228775, "C(<get-modalCollapsedShape>)928@44156L5:WideNavigationRail.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(926228775, i, -1, "androidx.compose.material3.WideNavigationRailDefaults.<get-modalCollapsedShape> (WideNavigationRail.kt:928)");
        }
        Shape shape = getShape(composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return shape;
    }

    public final Shape getModalExpandedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1865689797, "C(<get-modalExpandedShape>)932@44350L5:WideNavigationRail.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1865689797, i, -1, "androidx.compose.material3.WideNavigationRailDefaults.<get-modalExpandedShape> (WideNavigationRail.kt:932)");
        }
        Shape value = ShapesKt.getValue(NavigationRailExpandedTokens.INSTANCE.getModalContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final ModalWideNavigationRailProperties getModalExpandedProperties() {
        return ModalExpandedProperties;
    }

    public final WideNavigationRailColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 255272712, "C(colors)942@44754L11,942@44766L35:WideNavigationRail.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(255272712, i, -1, "androidx.compose.material3.WideNavigationRailDefaults.colors (WideNavigationRail.kt:942)");
        }
        WideNavigationRailColors defaultWideWideNavigationRailColors = getDefaultWideWideNavigationRailColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i << 3) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultWideWideNavigationRailColors;
    }

    /* JADX INFO: renamed from: colors-zjMxDiM, reason: not valid java name */
    public final WideNavigationRailColors m4833colorszjMxDiM(long j, long j2, long j3, long j4, long j5, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 239918099, "C(colors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,modalContainerColor:c#ui.graphics.Color,modalScrimColor:c#ui.graphics.Color,modalContentColor:c#ui.graphics.Color)961@45915L14,962@45961L31,963@46080L5,965@46159L5,966@46236L36,968@46330L11,968@46342L35:WideNavigationRail.kt#uh7d8r");
        long containerColor = (i2 & 1) != 0 ? INSTANCE.getContainerColor(composer, 6) : j;
        long jM3051contentColorForek8zF_U = (i2 & 2) != 0 ? ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composer, i & 14) : j2;
        long value = (i2 & 4) != 0 ? ColorSchemeKt.getValue(NavigationRailExpandedTokens.INSTANCE.getModalContainerColor(), composer, 6) : j3;
        long jM6813copywmQWz5c$default = (i2 & 8) != 0 ? Color.m6813copywmQWz5c$default(ColorSchemeKt.getValue(ScrimTokens.INSTANCE.getContainerColor(), composer, 6), 0.32f, 0.0f, 0.0f, 0.0f, 14, null) : j4;
        long jM3051contentColorForek8zF_U2 = (i2 & 16) != 0 ? ColorSchemeKt.m3051contentColorForek8zF_U(value, composer, (i >> 6) & 14) : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(239918099, i, -1, "androidx.compose.material3.WideNavigationRailDefaults.colors (WideNavigationRail.kt:968)");
        }
        WideNavigationRailColors wideNavigationRailColorsM4826copyt635Npw = getDefaultWideWideNavigationRailColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i >> 12) & 112).m4826copyt635Npw(containerColor, jM3051contentColorForek8zF_U, value, jM6813copywmQWz5c$default, jM3051contentColorForek8zF_U2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return wideNavigationRailColorsM4826copyt635Npw;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of function with modalContentColor parameter")
    /* JADX INFO: renamed from: colors-ro_MJ88, reason: not valid java name */
    public final /* synthetic */ WideNavigationRailColors m4832colorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1139423876, "C(colors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,modalContainerColor:c#ui.graphics.Color,modalScrimColor:c#ui.graphics.Color)995@47651L14,996@47697L31,997@47816L5,998@47883L5,1000@47981L11,1000@47993L35,1005@48255L36:WideNavigationRail.kt#uh7d8r");
        long containerColor = (i2 & 1) != 0 ? INSTANCE.getContainerColor(composer, 6) : j;
        long jM3051contentColorForek8zF_U = (i2 & 2) != 0 ? ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composer, i & 14) : j2;
        long value = (i2 & 4) != 0 ? ColorSchemeKt.getValue(NavigationRailExpandedTokens.INSTANCE.getModalContainerColor(), composer, 6) : j3;
        long jM6813copywmQWz5c$default = (i2 & 8) != 0 ? Color.m6813copywmQWz5c$default(ColorSchemeKt.getValue(ScrimTokens.INSTANCE.getContainerColor(), composer, 6), 0.32f, 0.0f, 0.0f, 0.0f, 14, null) : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1139423876, i, -1, "androidx.compose.material3.WideNavigationRailDefaults.colors (WideNavigationRail.kt:1000)");
        }
        WideNavigationRailColors wideNavigationRailColorsM4826copyt635Npw = getDefaultWideWideNavigationRailColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i >> 9) & 112).m4826copyt635Npw(containerColor, jM3051contentColorForek8zF_U, value, jM6813copywmQWz5c$default, ColorSchemeKt.m3051contentColorForek8zF_U(value, composer, (i >> 6) & 14));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return wideNavigationRailColorsM4826copyt635Npw;
    }

    public final Shape getContainerShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2020122139, "C(<get-containerShape>)1016@48696L5:WideNavigationRail.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2020122139, i, -1, "androidx.compose.material3.WideNavigationRailDefaults.<get-containerShape> (WideNavigationRail.kt:1016)");
        }
        Shape value = ShapesKt.getValue(NavigationRailCollapsedTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getModalContainerShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -5121925, "C(<get-modalContainerShape>)1026@49136L5:WideNavigationRail.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-5121925, i, -1, "androidx.compose.material3.WideNavigationRailDefaults.<get-modalContainerShape> (WideNavigationRail.kt:1026)");
        }
        Shape value = ShapesKt.getValue(NavigationRailExpandedTokens.INSTANCE.getModalContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    private final long getContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 2034736487, "C(<get-containerColor>)1029@49254L5:WideNavigationRail.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2034736487, i, -1, "androidx.compose.material3.WideNavigationRailDefaults.<get-containerColor> (WideNavigationRail.kt:1029)");
        }
        long value = ColorSchemeKt.getValue(NavigationRailCollapsedTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    private final long getModalContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1008951947, "C(<get-modalContainerColor>)1032@49381L5:WideNavigationRail.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1008951947, i, -1, "androidx.compose.material3.WideNavigationRailDefaults.<get-modalContainerColor> (WideNavigationRail.kt:1032)");
        }
        long value = ColorSchemeKt.getValue(NavigationRailExpandedTokens.INSTANCE.getModalContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    private final WideNavigationRailColors getDefaultWideWideNavigationRailColors(ColorScheme colorScheme, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1969597361, "C(<get-defaultWideWideNavigationRailColors>):WideNavigationRail.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1969597361, i, -1, "androidx.compose.material3.WideNavigationRailDefaults.<get-defaultWideWideNavigationRailColors> (WideNavigationRail.kt:1036)");
        }
        WideNavigationRailColors defaultWideWideNavigationRailColorsCached = colorScheme.getDefaultWideWideNavigationRailColorsCached();
        if (defaultWideWideNavigationRailColorsCached != null) {
            composer.startReplaceGroup(1297515721);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(1297532678);
            ComposerKt.sourceInformation(composer, "1039@49661L14,1040@49732L14,1041@49795L19,1042@49876L19,1044@49995L5");
            int i2 = (i >> 3) & 14;
            defaultWideWideNavigationRailColorsCached = new WideNavigationRailColors(getContainerColor(composer, i2), ColorSchemeKt.m3050contentColorFor4WTKRHQ(colorScheme, getContainerColor(composer, i2)), getModalContainerColor(composer, i2), Color.m6813copywmQWz5c$default(ColorSchemeKt.getValue(ScrimTokens.INSTANCE.getContainerColor(), composer, 6), 0.32f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.m3050contentColorFor4WTKRHQ(colorScheme, getModalContainerColor(composer, i2)), null);
            colorScheme.setDefaultWideWideNavigationRailColorsCached$material3(defaultWideWideNavigationRailColorsCached);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultWideWideNavigationRailColorsCached;
    }
}
