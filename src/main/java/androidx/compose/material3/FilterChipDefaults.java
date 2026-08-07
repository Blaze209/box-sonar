package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.FilterChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* JADX INFO: compiled from: Chip.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0013J\u0087\u0001\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010\u001d\u001a\u00020\u00152\b\b\u0002\u0010\u001e\u001a\u00020\u00152\b\b\u0002\u0010\u001f\u001a\u00020\u00152\b\b\u0002\u0010 \u001a\u00020\u0015H\u0007¢\u0006\u0004\b!\u0010\"JK\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u00052\b\b\u0002\u0010*\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020\u00052\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020\u00052\b\b\u0002\u0010.\u001a\u00020\u0005H\u0007¢\u0006\u0004\b/\u00100J[\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002042\b\b\u0002\u00106\u001a\u00020\u00152\b\b\u0002\u00107\u001a\u00020\u00152\b\b\u0002\u00108\u001a\u00020\u00152\b\b\u0002\u00109\u001a\u00020\u00152\b\b\u0002\u0010:\u001a\u00020\u00052\b\b\u0002\u0010;\u001a\u00020\u0005H\u0007¢\u0006\u0004\b<\u0010=J\r\u0010>\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0013J\u0087\u0001\u0010>\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010\u001d\u001a\u00020\u00152\b\b\u0002\u0010\u001e\u001a\u00020\u00152\b\b\u0002\u0010\u001f\u001a\u00020\u00152\b\b\u0002\u0010 \u001a\u00020\u0015H\u0007¢\u0006\u0004\b?\u0010\"JK\u0010B\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u00052\b\b\u0002\u0010*\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020\u00052\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020\u00052\b\b\u0002\u0010.\u001a\u00020\u0005H\u0007¢\u0006\u0004\bC\u00100R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010#\u001a\u00020\u0012*\u00020$8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0018\u0010@\u001a\u00020\u0012*\u00020$8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bA\u0010&R\u0011\u0010D\u001a\u00020E8G¢\u0006\u0006\u001a\u0004\bF\u0010G¨\u0006H"}, d2 = {"Landroidx/compose/material3/FilterChipDefaults;", "", "<init>", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", "F", "IconSize", "getIconSize-D9Ej5fM", "HorizontalSpacing", "getHorizontalSpacing-D9Ej5fM", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "filterChipColors", "Landroidx/compose/material3/SelectableChipColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SelectableChipColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "iconColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "selectedContainerColor", "disabledSelectedContainerColor", "selectedLabelColor", "selectedLeadingIconColor", "selectedTrailingIconColor", "filterChipColors-XqyqHi0", "(JJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SelectableChipColors;", "defaultFilterChipColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultFilterChipColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SelectableChipColors;", "filterChipElevation", "Landroidx/compose/material3/SelectableChipElevation;", "elevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "filterChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SelectableChipElevation;", "filterChipBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "selected", ViewProps.BORDER_COLOR, "selectedBorderColor", "disabledBorderColor", "disabledSelectedBorderColor", ViewProps.BORDER_WIDTH, "selectedBorderWidth", "filterChipBorder-_7El2pE", "(ZZJJJJFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "elevatedFilterChipColors", "elevatedFilterChipColors-XqyqHi0", "defaultElevatedFilterChipColors", "getDefaultElevatedFilterChipColors$material3", "elevatedFilterChipElevation", "elevatedFilterChipElevation-aqJV_2Y", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FilterChipDefaults {
    public static final int $stable = 0;
    private static final PaddingValues ContentPadding;
    private static final float HorizontalSpacing;
    public static final FilterChipDefaults INSTANCE = new FilterChipDefaults();
    private static final float Height = FilterChipTokens.INSTANCE.m5458getContainerHeightD9Ej5fM();
    private static final float IconSize = FilterChipTokens.INSTANCE.m5474getIconSizeD9Ej5fM();

    private FilterChipDefaults() {
    }

    static {
        float f = 8;
        HorizontalSpacing = Dp.m9687constructorimpl(f);
        ContentPadding = PaddingKt.m1213PaddingValuesYgX7TsA$default(Dp.m9687constructorimpl(f), 0.0f, 2, null);
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public final float m3368getHeightD9Ej5fM() {
        return Height;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3370getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* JADX INFO: renamed from: getHorizontalSpacing-D9Ej5fM, reason: not valid java name */
    public final float m3369getHorizontalSpacingD9Ej5fM() {
        return HorizontalSpacing;
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    public final SelectableChipColors filterChipColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1743772077, "C(filterChipColors)1644@80494L11:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1743772077, i, -1, "androidx.compose.material3.FilterChipDefaults.filterChipColors (Chip.kt:1644)");
        }
        SelectableChipColors defaultFilterChipColors$material3 = getDefaultFilterChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultFilterChipColors$material3;
    }

    /* JADX INFO: renamed from: filterChipColors-XqyqHi0, reason: not valid java name */
    public final SelectableChipColors m3366filterChipColorsXqyqHi0(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, Composer composer, int i, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, -1831479801, "C(filterChipColors)N(containerColor:c#ui.graphics.Color,labelColor:c#ui.graphics.Color,iconColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,selectedContainerColor:c#ui.graphics.Color,disabledSelectedContainerColor:c#ui.graphics.Color,selectedLabelColor:c#ui.graphics.Color,selectedLeadingIconColor:c#ui.graphics.Color,selectedTrailingIconColor:c#ui.graphics.Color)1679@82493L11:Chip.kt#uh7d8r");
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
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1831479801, i, i2, "androidx.compose.material3.FilterChipDefaults.filterChipColors (Chip.kt:1679)");
        }
        SelectableChipColors selectableChipColorsM4147copydaRQuJA = getDefaultFilterChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m4147copydaRQuJA(jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU3, jM6850getUnspecified0d7_KjU3, jM6850getUnspecified0d7_KjU4, jM6850getUnspecified0d7_KjU5, jM6850getUnspecified0d7_KjU6, jM6850getUnspecified0d7_KjU7, jM6850getUnspecified0d7_KjU8, jM6850getUnspecified0d7_KjU9, jM6850getUnspecified0d7_KjU10, jM6850getUnspecified0d7_KjU11, jM6850getUnspecified0d7_KjU12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return selectableChipColorsM4147copydaRQuJA;
    }

    public final SelectableChipColors getDefaultFilterChipColors$material3(ColorScheme colorScheme) {
        SelectableChipColors defaultFilterChipColorsCached = colorScheme.getDefaultFilterChipColorsCached();
        if (defaultFilterChipColorsCached != null) {
            return defaultFilterChipColorsCached;
        }
        SelectableChipColors selectableChipColors = new SelectableChipColors(Color.INSTANCE.m6849getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getUnselectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getUnselectedLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getUnselectedTrailingIconColor()), Color.INSTANCE.m6849getTransparent0d7_KjU(), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getDisabledLabelTextColor()), FilterChipTokens.INSTANCE.getDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getDisabledLeadingIconColor()), FilterChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getDisabledTrailingIconColor()), FilterChipTokens.INSTANCE.getDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getFlatSelectedContainerColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getFlatDisabledSelectedContainerColor()), FilterChipTokens.INSTANCE.getFlatDisabledSelectedContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getSelectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getSelectedLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getSelectedTrailingIconColor()), null);
        colorScheme.setDefaultFilterChipColorsCached$material3(selectableChipColors);
        return selectableChipColors;
    }

    /* JADX INFO: renamed from: filterChipElevation-aqJV_2Y, reason: not valid java name */
    public final SelectableChipElevation m3367filterChipElevationaqJV_2Y(float f, float f2, float f3, float f4, float f5, float f6, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -757972185, "C(filterChipElevation)N(elevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,draggedElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Chip.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f = FilterChipTokens.INSTANCE.m5465getFlatContainerElevationD9Ej5fM();
        }
        float f7 = f;
        if ((i2 & 2) != 0) {
            f2 = FilterChipTokens.INSTANCE.m5469getFlatSelectedPressedContainerElevationD9Ej5fM();
        }
        float f8 = f2;
        if ((i2 & 4) != 0) {
            f3 = FilterChipTokens.INSTANCE.m5466getFlatSelectedFocusContainerElevationD9Ej5fM();
        }
        float f9 = f3;
        if ((i2 & 8) != 0) {
            f4 = FilterChipTokens.INSTANCE.m5467getFlatSelectedHoverContainerElevationD9Ej5fM();
        }
        float f10 = f4;
        float fM5459getDraggedContainerElevationD9Ej5fM = (i2 & 16) != 0 ? FilterChipTokens.INSTANCE.m5459getDraggedContainerElevationD9Ej5fM() : f5;
        float f11 = (i2 & 32) != 0 ? f7 : f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-757972185, i, -1, "androidx.compose.material3.FilterChipDefaults.filterChipElevation (Chip.kt:1749)");
        }
        SelectableChipElevation selectableChipElevation = new SelectableChipElevation(f7, f8, f9, f10, fM5459getDraggedContainerElevationD9Ej5fM, f11, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return selectableChipElevation;
    }

    /* JADX INFO: renamed from: filterChipBorder-_7El2pE, reason: not valid java name */
    public final BorderStroke m3365filterChipBorder_7El2pE(boolean z, boolean z2, long j, long j2, long j3, long j4, float f, float f2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1138342447, "C(filterChipBorder)N(enabled,selected,borderColor:c#ui.graphics.Color,selectedBorderColor:c#ui.graphics.Color,disabledBorderColor:c#ui.graphics.Color,disabledSelectedBorderColor:c#ui.graphics.Color,borderWidth:c#ui.unit.Dp,selectedBorderWidth:c#ui.unit.Dp)1777@88084L5,1780@88248L5:Chip.kt#uh7d8r");
        long value = (i2 & 4) != 0 ? ColorSchemeKt.getValue(FilterChipTokens.INSTANCE.getFlatUnselectedOutlineColor(), composer, 6) : j;
        long jM6849getTransparent0d7_KjU = (i2 & 8) != 0 ? Color.INSTANCE.m6849getTransparent0d7_KjU() : j2;
        long jM6813copywmQWz5c$default = (i2 & 16) != 0 ? Color.m6813copywmQWz5c$default(ColorSchemeKt.getValue(FilterChipTokens.INSTANCE.getFlatDisabledUnselectedOutlineColor(), composer, 6), FilterChipTokens.INSTANCE.getFlatDisabledUnselectedOutlineOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long jM6849getTransparent0d7_KjU2 = (i2 & 32) != 0 ? Color.INSTANCE.m6849getTransparent0d7_KjU() : j4;
        float fM5472getFlatUnselectedOutlineWidthD9Ej5fM = (i2 & 64) != 0 ? FilterChipTokens.INSTANCE.m5472getFlatUnselectedOutlineWidthD9Ej5fM() : f;
        float fM5468getFlatSelectedOutlineWidthD9Ej5fM = (i2 & 128) != 0 ? FilterChipTokens.INSTANCE.m5468getFlatSelectedOutlineWidthD9Ej5fM() : f2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1138342447, i, -1, "androidx.compose.material3.FilterChipDefaults.filterChipBorder (Chip.kt:1786)");
        }
        if (!z) {
            value = z2 ? jM6849getTransparent0d7_KjU2 : jM6813copywmQWz5c$default;
        } else if (z2) {
            value = jM6849getTransparent0d7_KjU;
        }
        if (z2) {
            fM5472getFlatUnselectedOutlineWidthD9Ej5fM = fM5468getFlatSelectedOutlineWidthD9Ej5fM;
        }
        BorderStroke borderStrokeM622BorderStrokecXLIe8U = BorderStrokeKt.m622BorderStrokecXLIe8U(fM5472getFlatUnselectedOutlineWidthD9Ej5fM, value);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return borderStrokeM622BorderStrokecXLIe8U;
    }

    public final SelectableChipColors elevatedFilterChipColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1082953289, "C(elevatedFilterChipColors)1801@89134L11:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1082953289, i, -1, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipColors (Chip.kt:1801)");
        }
        SelectableChipColors defaultElevatedFilterChipColors$material3 = getDefaultElevatedFilterChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultElevatedFilterChipColors$material3;
    }

    /* JADX INFO: renamed from: elevatedFilterChipColors-XqyqHi0, reason: not valid java name */
    public final SelectableChipColors m3363elevatedFilterChipColorsXqyqHi0(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, Composer composer, int i, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, -915841711, "C(elevatedFilterChipColors)N(containerColor:c#ui.graphics.Color,labelColor:c#ui.graphics.Color,iconColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,selectedContainerColor:c#ui.graphics.Color,disabledSelectedContainerColor:c#ui.graphics.Color,selectedLabelColor:c#ui.graphics.Color,selectedLeadingIconColor:c#ui.graphics.Color,selectedTrailingIconColor:c#ui.graphics.Color)1836@91154L11:Chip.kt#uh7d8r");
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
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-915841711, i, i2, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipColors (Chip.kt:1836)");
        }
        SelectableChipColors selectableChipColorsM4147copydaRQuJA = getDefaultElevatedFilterChipColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m4147copydaRQuJA(jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU3, jM6850getUnspecified0d7_KjU3, jM6850getUnspecified0d7_KjU4, jM6850getUnspecified0d7_KjU5, jM6850getUnspecified0d7_KjU6, jM6850getUnspecified0d7_KjU7, jM6850getUnspecified0d7_KjU8, jM6850getUnspecified0d7_KjU9, jM6850getUnspecified0d7_KjU10, jM6850getUnspecified0d7_KjU11, jM6850getUnspecified0d7_KjU12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return selectableChipColorsM4147copydaRQuJA;
    }

    public final SelectableChipColors getDefaultElevatedFilterChipColors$material3(ColorScheme colorScheme) {
        SelectableChipColors defaultElevatedFilterChipColorsCached = colorScheme.getDefaultElevatedFilterChipColorsCached();
        if (defaultElevatedFilterChipColorsCached != null) {
            return defaultElevatedFilterChipColorsCached;
        }
        SelectableChipColors selectableChipColors = new SelectableChipColors(ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getElevatedUnselectedContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getUnselectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getUnselectedLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getUnselectedTrailingIconColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getElevatedDisabledContainerColor()), FilterChipTokens.INSTANCE.getElevatedDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getDisabledLabelTextColor()), FilterChipTokens.INSTANCE.getDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getDisabledLeadingIconColor()), FilterChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getDisabledTrailingIconColor()), FilterChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getElevatedSelectedContainerColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getElevatedDisabledContainerColor()), FilterChipTokens.INSTANCE.getElevatedDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getSelectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getSelectedLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, FilterChipTokens.INSTANCE.getSelectedTrailingIconColor()), null);
        colorScheme.setDefaultElevatedFilterChipColorsCached$material3(selectableChipColors);
        return selectableChipColors;
    }

    /* JADX INFO: renamed from: elevatedFilterChipElevation-aqJV_2Y, reason: not valid java name */
    public final SelectableChipElevation m3364elevatedFilterChipElevationaqJV_2Y(float f, float f2, float f3, float f4, float f5, float f6, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 684803697, "C(elevatedFilterChipElevation)N(elevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,draggedElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Chip.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f = FilterChipTokens.INSTANCE.m5460getElevatedContainerElevationD9Ej5fM();
        }
        float f7 = f;
        if ((i2 & 2) != 0) {
            f2 = FilterChipTokens.INSTANCE.m5464getElevatedPressedContainerElevationD9Ej5fM();
        }
        float f8 = f2;
        if ((i2 & 4) != 0) {
            f3 = FilterChipTokens.INSTANCE.m5462getElevatedFocusContainerElevationD9Ej5fM();
        }
        float f9 = f3;
        if ((i2 & 8) != 0) {
            f4 = FilterChipTokens.INSTANCE.m5463getElevatedHoverContainerElevationD9Ej5fM();
        }
        float f10 = f4;
        float fM5459getDraggedContainerElevationD9Ej5fM = (i2 & 16) != 0 ? FilterChipTokens.INSTANCE.m5459getDraggedContainerElevationD9Ej5fM() : f5;
        float fM5461getElevatedDisabledContainerElevationD9Ej5fM = (i2 & 32) != 0 ? FilterChipTokens.INSTANCE.m5461getElevatedDisabledContainerElevationD9Ej5fM() : f6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(684803697, i, -1, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipElevation (Chip.kt:1907)");
        }
        SelectableChipElevation selectableChipElevation = new SelectableChipElevation(f7, f8, f9, f10, fM5459getDraggedContainerElevationD9Ej5fM, fM5461getElevatedDisabledContainerElevationD9Ej5fM, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return selectableChipElevation;
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1598643637, "C(<get-shape>)1918@95985L5:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1598643637, i, -1, "androidx.compose.material3.FilterChipDefaults.<get-shape> (Chip.kt:1918)");
        }
        Shape value = ShapesKt.getValue(FilterChipTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }
}
