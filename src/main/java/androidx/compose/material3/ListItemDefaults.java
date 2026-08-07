package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.material3.tokens.ReorderListTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* JADX INFO: compiled from: ListItemDefaults.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019Jÿ\u0001\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010 \u001a\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\u00122\b\b\u0002\u0010\"\u001a\u00020\u00122\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020\u00122\b\b\u0002\u0010%\u001a\u00020\u00122\b\b\u0002\u0010&\u001a\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u00122\b\b\u0002\u0010(\u001a\u00020\u00122\b\b\u0002\u0010)\u001a\u00020\u00122\b\b\u0002\u0010*\u001a\u00020\u00122\b\b\u0002\u0010+\u001a\u00020\u00122\b\b\u0002\u0010,\u001a\u00020\u00122\b\b\u0002\u0010-\u001a\u00020\u00122\b\b\u0002\u0010.\u001a\u00020\u00122\b\b\u0002\u0010/\u001a\u00020\u0012H\u0007¢\u0006\u0004\b0\u00101J\r\u00106\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019Jÿ\u0001\u00106\u001a\u00020\u00182\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010 \u001a\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\u00122\b\b\u0002\u0010\"\u001a\u00020\u00122\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020\u00122\b\b\u0002\u0010%\u001a\u00020\u00122\b\b\u0002\u0010&\u001a\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u00122\b\b\u0002\u0010(\u001a\u00020\u00122\b\b\u0002\u0010)\u001a\u00020\u00122\b\b\u0002\u0010*\u001a\u00020\u00122\b\b\u0002\u0010+\u001a\u00020\u00122\b\b\u0002\u0010,\u001a\u00020\u00122\b\b\u0002\u0010-\u001a\u00020\u00122\b\b\u0002\u0010.\u001a\u00020\u00122\b\b\u0002\u0010/\u001a\u00020\u0012H\u0007¢\u0006\u0004\b7\u00101J\r\u0010:\u001a\u00020;H\u0007¢\u0006\u0002\u0010<JU\u0010:\u001a\u00020;2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0002\u0010BJ'\u0010C\u001a\u00020;2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020E2\b\b\u0002\u0010G\u001a\u00020;H\u0007¢\u0006\u0002\u0010HJ#\u0010O\u001a\u00020P2\b\b\u0002\u0010O\u001a\u00020\t2\b\b\u0002\u0010Q\u001a\u00020\tH\u0007¢\u0006\u0004\bR\u0010SJ\r\u0010W\u001a\u00020XH\u0007¢\u0006\u0002\u0010YJi\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010Z\u001a\u00020\u00122\b\b\u0002\u0010[\u001a\u00020\u00122\b\b\u0002\u0010\\\u001a\u00020\u00122\b\b\u0002\u0010]\u001a\u00020\u00122\b\b\u0002\u0010^\u001a\u00020\u00122\b\b\u0002\u0010_\u001a\u00020\u00122\b\b\u0002\u0010`\u001a\u00020\u00122\b\b\u0002\u0010a\u001a\u00020\u0012H\u0007¢\u0006\u0004\bb\u0010cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\r\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00128G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0018\u00102\u001a\u00020\u0018*\u0002038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0018\u00108\u001a\u00020\u0018*\u0002038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b9\u00105R\u001e\u0010I\u001a\u00020;*\u00020J8@X\u0080\u0004¢\u0006\f\u0012\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u001e\u0010T\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\f\u0012\u0004\bU\u0010\u0003\u001a\u0004\bV\u0010\u000b¨\u0006d"}, d2 = {"Landroidx/compose/material3/ListItemDefaults;", "", "<init>", "()V", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM", "()F", "F", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "contentColor", "getContentColor", "colors", "Landroidx/compose/material3/ListItemColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ListItemColors;", "leadingContentColor", "trailingContentColor", "overlineContentColor", "supportingContentColor", "disabledContainerColor", "disabledContentColor", "disabledLeadingContentColor", "disabledTrailingContentColor", "disabledOverlineContentColor", "disabledSupportingContentColor", "selectedContainerColor", "selectedContentColor", "selectedLeadingContentColor", "selectedTrailingContentColor", "selectedOverlineContentColor", "selectedSupportingContentColor", "draggedContainerColor", "draggedContentColor", "draggedLeadingContentColor", "draggedTrailingContentColor", "draggedOverlineContentColor", "draggedSupportingContentColor", "colors-LIdIuno", "(JJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material3/ListItemColors;", "defaultListItemColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultListItemColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ListItemColors;", "segmentedColors", "segmentedColors-LIdIuno", "defaultSegmentedListItemColors", "getDefaultSegmentedListItemColors$material3", "shapes", "Landroidx/compose/material3/ListItemShapes;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ListItemShapes;", "selectedShape", "pressedShape", "focusedShape", "hoveredShape", "draggedShape", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ListItemShapes;", "segmentedShapes", FirebaseAnalytics.Param.INDEX, "", "count", "defaultShapes", "(IILandroidx/compose/material3/ListItemShapes;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ListItemShapes;", "defaultListItemShapes", "Landroidx/compose/material3/Shapes;", "getDefaultListItemShapes$material3$annotations", "(Landroidx/compose/material3/Shapes;)V", "getDefaultListItemShapes$material3", "(Landroidx/compose/material3/Shapes;)Landroidx/compose/material3/ListItemShapes;", "elevation", "Landroidx/compose/material3/ListItemElevation;", "draggedElevation", "elevation-YgX7TsA", "(FF)Landroidx/compose/material3/ListItemElevation;", "SegmentedGap", "getSegmentedGap-D9Ej5fM$annotations", "getSegmentedGap-D9Ej5fM", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Alignment$Vertical;", "headlineColor", "leadingIconColor", "overlineColor", "supportingColor", "trailingIconColor", "disabledHeadlineColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "colors-J08w3-E", "(JJJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ListItemColors;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ListItemDefaults {
    public static final int $stable = 0;
    public static final ListItemDefaults INSTANCE = new ListItemDefaults();
    private static final PaddingValues ContentPadding = PaddingKt.m1214PaddingValuesa9UjIt4(ListItemKt.getInteractiveListStartPadding(), ListItemKt.getInteractiveListTopPadding(), ListItemKt.getInteractiveListEndPadding(), ListItemKt.getInteractiveListBottomPadding());
    private static final float Elevation = ListTokens.INSTANCE.m5513getItemContainerElevationD9Ej5fM();
    private static final float SegmentedGap = ListTokens.INSTANCE.m5533getSegmentedGapD9Ej5fM();

    public static /* synthetic */ void getDefaultListItemShapes$material3$annotations(Shapes shapes) {
    }

    /* JADX INFO: renamed from: getSegmentedGap-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m3667getSegmentedGapD9Ej5fM$annotations() {
    }

    private ListItemDefaults() {
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    /* JADX INFO: renamed from: getElevation-D9Ej5fM, reason: not valid java name */
    public final float m3671getElevationD9Ej5fM() {
        return Elevation;
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -219539551, "C(<get-shape>)53@2197L5:ListItemDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-219539551, i, -1, "androidx.compose.material3.ListItemDefaults.<get-shape> (ListItemDefaults.kt:53)");
        }
        Shape value = ShapesKt.getValue(ListTokens.INSTANCE.getItemContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 316428213, "C(<get-containerColor>)57@2358L5:ListItemDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(316428213, i, -1, "androidx.compose.material3.ListItemDefaults.<get-containerColor> (ListItemDefaults.kt:57)");
        }
        long value = ColorSchemeKt.getValue(ListTokens.INSTANCE.getItemContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getContentColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1754491957, "C(<get-contentColor>)61@2515L5:ListItemDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1754491957, i, -1, "androidx.compose.material3.ListItemDefaults.<get-contentColor> (ListItemDefaults.kt:61)");
        }
        long value = ColorSchemeKt.getValue(ListTokens.INSTANCE.getItemLabelTextColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final ListItemColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -138071106, "C(colors)67@2697L11:ListItemDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-138071106, i, -1, "androidx.compose.material3.ListItemDefaults.colors (ListItemDefaults.kt:67)");
        }
        ListItemColors defaultListItemColors$material3 = getDefaultListItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultListItemColors$material3;
    }

    /* JADX INFO: renamed from: colors-LIdIuno, reason: not valid java name */
    public final ListItemColors m3669colorsLIdIuno(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, Composer composer, int i, int i2, int i3, int i4) {
        ComposerKt.sourceInformationMarkerStart(composer, 1918472318, "C(colors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,leadingContentColor:c#ui.graphics.Color,trailingContentColor:c#ui.graphics.Color,overlineContentColor:c#ui.graphics.Color,supportingContentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,disabledLeadingContentColor:c#ui.graphics.Color,disabledTrailingContentColor:c#ui.graphics.Color,disabledOverlineContentColor:c#ui.graphics.Color,disabledSupportingContentColor:c#ui.graphics.Color,selectedContainerColor:c#ui.graphics.Color,selectedContentColor:c#ui.graphics.Color,selectedLeadingContentColor:c#ui.graphics.Color,selectedTrailingContentColor:c#ui.graphics.Color,selectedOverlineContentColor:c#ui.graphics.Color,selectedSupportingContentColor:c#ui.graphics.Color,draggedContainerColor:c#ui.graphics.Color,draggedContentColor:c#ui.graphics.Color,draggedLeadingContentColor:c#ui.graphics.Color,draggedTrailingContentColor:c#ui.graphics.Color,draggedOverlineContentColor:c#ui.graphics.Color,draggedSupportingContentColor:c#ui.graphics.Color)136@6741L11:ListItemDefaults.kt#uh7d8r");
        long jM6850getUnspecified0d7_KjU = (i4 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j;
        long jM6850getUnspecified0d7_KjU2 = (i4 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU3 = (i4 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        long jM6850getUnspecified0d7_KjU4 = (i4 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4;
        long jM6850getUnspecified0d7_KjU5 = (i4 & 16) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j5;
        long jM6850getUnspecified0d7_KjU6 = (i4 & 32) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j6;
        long jM6850getUnspecified0d7_KjU7 = (i4 & 64) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j7;
        long jM6850getUnspecified0d7_KjU8 = (i4 & 128) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j8;
        long jM6850getUnspecified0d7_KjU9 = (i4 & 256) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j9;
        long jM6850getUnspecified0d7_KjU10 = (i4 & 512) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j10;
        long jM6850getUnspecified0d7_KjU11 = (i4 & 1024) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j11;
        long jM6850getUnspecified0d7_KjU12 = (i4 & 2048) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j12;
        long jM6850getUnspecified0d7_KjU13 = (i4 & 4096) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j13;
        long jM6850getUnspecified0d7_KjU14 = (i4 & 8192) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j14;
        long jM6850getUnspecified0d7_KjU15 = (i4 & 16384) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j15;
        long jM6850getUnspecified0d7_KjU16 = (32768 & i4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j16;
        long jM6850getUnspecified0d7_KjU17 = (65536 & i4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j17;
        long jM6850getUnspecified0d7_KjU18 = (131072 & i4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j18;
        long jM6850getUnspecified0d7_KjU19 = (262144 & i4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j19;
        long jM6850getUnspecified0d7_KjU20 = (524288 & i4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j20;
        long jM6850getUnspecified0d7_KjU21 = (1048576 & i4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j21;
        long jM6850getUnspecified0d7_KjU22 = (2097152 & i4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j22;
        long jM6850getUnspecified0d7_KjU23 = (4194304 & i4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j23;
        long jM6850getUnspecified0d7_KjU24 = (i4 & 8388608) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j24;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1918472318, i, i2, "androidx.compose.material3.ListItemDefaults.colors (ListItemDefaults.kt:135)");
        }
        ListItemColors listItemColorsM3629copyKKJ9vVU = getDefaultListItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m3629copyKKJ9vVU(jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU3, jM6850getUnspecified0d7_KjU4, jM6850getUnspecified0d7_KjU5, jM6850getUnspecified0d7_KjU6, jM6850getUnspecified0d7_KjU7, jM6850getUnspecified0d7_KjU8, jM6850getUnspecified0d7_KjU9, jM6850getUnspecified0d7_KjU10, jM6850getUnspecified0d7_KjU11, jM6850getUnspecified0d7_KjU12, jM6850getUnspecified0d7_KjU13, jM6850getUnspecified0d7_KjU14, jM6850getUnspecified0d7_KjU15, jM6850getUnspecified0d7_KjU16, jM6850getUnspecified0d7_KjU17, jM6850getUnspecified0d7_KjU18, jM6850getUnspecified0d7_KjU19, jM6850getUnspecified0d7_KjU20, jM6850getUnspecified0d7_KjU21, jM6850getUnspecified0d7_KjU22, jM6850getUnspecified0d7_KjU23, jM6850getUnspecified0d7_KjU24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return listItemColorsM3629copyKKJ9vVU;
    }

    public final ListItemColors getDefaultListItemColors$material3(ColorScheme colorScheme) {
        ListItemColors defaultListItemColorsCached = colorScheme.getDefaultListItemColorsCached();
        if (defaultListItemColorsCached != null) {
            return defaultListItemColorsCached;
        }
        ListItemColors listItemColors = new ListItemColors(ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemContainerColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemOverlineColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemSupportingTextColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemContainerColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemDisabledLabelTextColor()), ListTokens.INSTANCE.getItemDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemDisabledLeadingIconColor()), ListTokens.INSTANCE.getItemDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemDisabledTrailingIconColor()), ListTokens.INSTANCE.getItemDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemDisabledOverlineColor()), ListTokens.INSTANCE.getItemDisabledOverlineOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemDisabledSupportingTextColor()), ListTokens.INSTANCE.getItemDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemSelectedContainerColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemSelectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemSelectedLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemSelectedTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemSelectedOverlineColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemSelectedSupportingTextColor()), ColorSchemeKt.fromToken(colorScheme, ReorderListTokens.INSTANCE.getItemContainerColor()), ColorSchemeKt.fromToken(colorScheme, ReorderListTokens.INSTANCE.getItemLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, ReorderListTokens.INSTANCE.getItemLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, ReorderListTokens.INSTANCE.getItemTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, ReorderListTokens.INSTANCE.getItemOverlineColor()), ColorSchemeKt.fromToken(colorScheme, ReorderListTokens.INSTANCE.getItemSupportingTextColor()), null);
        colorScheme.setDefaultListItemColorsCached$material3(listItemColors);
        return listItemColors;
    }

    public final ListItemColors segmentedColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1088456616, "C(segmentedColors)224@12190L11:ListItemDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1088456616, i, -1, "androidx.compose.material3.ListItemDefaults.segmentedColors (ListItemDefaults.kt:224)");
        }
        ListItemColors defaultSegmentedListItemColors$material3 = getDefaultSegmentedListItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultSegmentedListItemColors$material3;
    }

    /* JADX INFO: renamed from: segmentedColors-LIdIuno, reason: not valid java name */
    public final ListItemColors m3673segmentedColorsLIdIuno(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, Composer composer, int i, int i2, int i3, int i4) {
        ComposerKt.sourceInformationMarkerStart(composer, 538921812, "C(segmentedColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,leadingContentColor:c#ui.graphics.Color,trailingContentColor:c#ui.graphics.Color,overlineContentColor:c#ui.graphics.Color,supportingContentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,disabledLeadingContentColor:c#ui.graphics.Color,disabledTrailingContentColor:c#ui.graphics.Color,disabledOverlineContentColor:c#ui.graphics.Color,disabledSupportingContentColor:c#ui.graphics.Color,selectedContainerColor:c#ui.graphics.Color,selectedContentColor:c#ui.graphics.Color,selectedLeadingContentColor:c#ui.graphics.Color,selectedTrailingContentColor:c#ui.graphics.Color,selectedOverlineContentColor:c#ui.graphics.Color,selectedSupportingContentColor:c#ui.graphics.Color,draggedContainerColor:c#ui.graphics.Color,draggedContentColor:c#ui.graphics.Color,draggedLeadingContentColor:c#ui.graphics.Color,draggedTrailingContentColor:c#ui.graphics.Color,draggedOverlineContentColor:c#ui.graphics.Color,draggedSupportingContentColor:c#ui.graphics.Color)294@16301L11:ListItemDefaults.kt#uh7d8r");
        long jM6850getUnspecified0d7_KjU = (i4 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j;
        long jM6850getUnspecified0d7_KjU2 = (i4 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU3 = (i4 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        long jM6850getUnspecified0d7_KjU4 = (i4 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4;
        long jM6850getUnspecified0d7_KjU5 = (i4 & 16) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j5;
        long jM6850getUnspecified0d7_KjU6 = (i4 & 32) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j6;
        long jM6850getUnspecified0d7_KjU7 = (i4 & 64) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j7;
        long jM6850getUnspecified0d7_KjU8 = (i4 & 128) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j8;
        long jM6850getUnspecified0d7_KjU9 = (i4 & 256) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j9;
        long jM6850getUnspecified0d7_KjU10 = (i4 & 512) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j10;
        long jM6850getUnspecified0d7_KjU11 = (i4 & 1024) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j11;
        long jM6850getUnspecified0d7_KjU12 = (i4 & 2048) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j12;
        long jM6850getUnspecified0d7_KjU13 = (i4 & 4096) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j13;
        long jM6850getUnspecified0d7_KjU14 = (i4 & 8192) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j14;
        long jM6850getUnspecified0d7_KjU15 = (i4 & 16384) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j15;
        long jM6850getUnspecified0d7_KjU16 = (32768 & i4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j16;
        long jM6850getUnspecified0d7_KjU17 = (65536 & i4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j17;
        long jM6850getUnspecified0d7_KjU18 = (131072 & i4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j18;
        long jM6850getUnspecified0d7_KjU19 = (262144 & i4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j19;
        long jM6850getUnspecified0d7_KjU20 = (524288 & i4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j20;
        long jM6850getUnspecified0d7_KjU21 = (1048576 & i4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j21;
        long jM6850getUnspecified0d7_KjU22 = (2097152 & i4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j22;
        long jM6850getUnspecified0d7_KjU23 = (4194304 & i4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j23;
        long jM6850getUnspecified0d7_KjU24 = (i4 & 8388608) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j24;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(538921812, i, i2, "androidx.compose.material3.ListItemDefaults.segmentedColors (ListItemDefaults.kt:293)");
        }
        ListItemColors listItemColorsM3629copyKKJ9vVU = getDefaultSegmentedListItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m3629copyKKJ9vVU(jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU3, jM6850getUnspecified0d7_KjU4, jM6850getUnspecified0d7_KjU5, jM6850getUnspecified0d7_KjU6, jM6850getUnspecified0d7_KjU7, jM6850getUnspecified0d7_KjU8, jM6850getUnspecified0d7_KjU9, jM6850getUnspecified0d7_KjU10, jM6850getUnspecified0d7_KjU11, jM6850getUnspecified0d7_KjU12, jM6850getUnspecified0d7_KjU13, jM6850getUnspecified0d7_KjU14, jM6850getUnspecified0d7_KjU15, jM6850getUnspecified0d7_KjU16, jM6850getUnspecified0d7_KjU17, jM6850getUnspecified0d7_KjU18, jM6850getUnspecified0d7_KjU19, jM6850getUnspecified0d7_KjU20, jM6850getUnspecified0d7_KjU21, jM6850getUnspecified0d7_KjU22, jM6850getUnspecified0d7_KjU23, jM6850getUnspecified0d7_KjU24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return listItemColorsM3629copyKKJ9vVU;
    }

    public final ListItemColors getDefaultSegmentedListItemColors$material3(ColorScheme colorScheme) {
        ListItemColors defaultSegmentedListItemColorsCached = colorScheme.getDefaultSegmentedListItemColorsCached();
        if (defaultSegmentedListItemColorsCached != null) {
            return defaultSegmentedListItemColorsCached;
        }
        ListItemColors listItemColors = new ListItemColors(ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemSegmentedContainerColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemOverlineColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemSupportingTextColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemSegmentedContainerColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemDisabledLabelTextColor()), ListTokens.INSTANCE.getItemDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemDisabledLeadingIconColor()), ListTokens.INSTANCE.getItemDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemDisabledTrailingIconColor()), ListTokens.INSTANCE.getItemDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemDisabledOverlineColor()), ListTokens.INSTANCE.getItemDisabledOverlineOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemDisabledSupportingTextColor()), ListTokens.INSTANCE.getItemDisabledSupportingTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemSelectedContainerColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemSelectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemSelectedLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemSelectedTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemSelectedOverlineColor()), ColorSchemeKt.fromToken(colorScheme, ListTokens.INSTANCE.getItemSelectedSupportingTextColor()), ColorSchemeKt.fromToken(colorScheme, ReorderListTokens.INSTANCE.getItemContainerColor()), ColorSchemeKt.fromToken(colorScheme, ReorderListTokens.INSTANCE.getItemLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, ReorderListTokens.INSTANCE.getItemLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, ReorderListTokens.INSTANCE.getItemTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, ReorderListTokens.INSTANCE.getItemOverlineColor()), ColorSchemeKt.fromToken(colorScheme, ReorderListTokens.INSTANCE.getItemSupportingTextColor()), null);
        colorScheme.setDefaultSegmentedListItemColorsCached$material3(listItemColors);
        return listItemColors;
    }

    public final ListItemShapes shapes(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1568481222, "C(shapes)382@21786L6:ListItemDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1568481222, i, -1, "androidx.compose.material3.ListItemDefaults.shapes (ListItemDefaults.kt:382)");
        }
        ListItemShapes defaultListItemShapes$material3 = getDefaultListItemShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultListItemShapes$material3;
    }

    public final ListItemShapes shapes(Shape shape, Shape shape2, Shape shape3, Shape shape4, Shape shape5, Shape shape6, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 867485652, "C(shapes)N(shape,selectedShape,pressedShape,focusedShape,hoveredShape,draggedShape)405@22685L6:ListItemDefaults.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            shape = null;
        }
        if ((i2 & 2) != 0) {
            shape2 = null;
        }
        if ((i2 & 4) != 0) {
            shape3 = null;
        }
        if ((i2 & 8) != 0) {
            shape4 = null;
        }
        if ((i2 & 16) != 0) {
            shape5 = null;
        }
        if ((i2 & 32) != 0) {
            shape6 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(867485652, i, -1, "androidx.compose.material3.ListItemDefaults.shapes (ListItemDefaults.kt:405)");
        }
        ListItemShapes listItemShapesCopy = getDefaultListItemShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6)).copy(shape, shape2, shape3, shape4, shape5, shape6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return listItemShapesCopy;
    }

    public final ListItemShapes segmentedShapes(int i, int i2, ListItemShapes listItemShapes, Composer composer, int i3, int i4) {
        ComposerKt.sourceInformationMarkerStart(composer, 1855526817, "C(segmentedShapes)N(index,count,defaultShapes)428@23582L8,430@23670L5,431@23691L1474:ListItemDefaults.kt#uh7d8r");
        ListItemShapes listItemShapesShapes = (i4 & 4) != 0 ? shapes(composer, (i3 >> 9) & 14) : listItemShapes;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1855526817, i3, -1, "androidx.compose.material3.ListItemDefaults.segmentedShapes (ListItemDefaults.kt:429)");
        }
        Shape value = ShapesKt.getValue(ListTokens.INSTANCE.getContainerShape(), composer, 6);
        ComposerKt.sourceInformationMarkerStart(composer, 749851491, "CC(remember):ListItemDefaults.kt#9igjgp");
        boolean zChanged = (((6 ^ (i3 & 14)) > 4 && composer.changed(i)) || (i3 & 6) == 4) | ((((i3 & 112) ^ 48) > 32 && composer.changed(i2)) || (i3 & 48) == 32) | ((((i3 & 896) ^ 384) > 256 && composer.changed(listItemShapesShapes)) || (i3 & 384) == 256) | composer.changed(value);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            if (i2 != 1) {
                if (i == 0) {
                    Shape shape = listItemShapesShapes.getShape();
                    if ((shape instanceof CornerBasedShape) && (value instanceof CornerBasedShape)) {
                        CornerBasedShape cornerBasedShape = (CornerBasedShape) value;
                        listItemShapesShapes = ListItemShapes.copy$default(listItemShapesShapes, CornerBasedShape.copy$default((CornerBasedShape) shape, cornerBasedShape.getTopStart(), cornerBasedShape.getTopEnd(), null, null, 12, null), null, null, null, null, null, 62, null);
                    }
                } else if (i == i2 - 1) {
                    Shape shape2 = listItemShapesShapes.getShape();
                    if ((shape2 instanceof CornerBasedShape) && (value instanceof CornerBasedShape)) {
                        CornerBasedShape cornerBasedShape2 = (CornerBasedShape) value;
                        listItemShapesShapes = ListItemShapes.copy$default(listItemShapesShapes, CornerBasedShape.copy$default((CornerBasedShape) shape2, null, null, cornerBasedShape2.getBottomEnd(), cornerBasedShape2.getBottomStart(), 3, null), null, null, null, null, null, 62, null);
                    }
                }
            }
            composer.updateRememberedValue(listItemShapesShapes);
            objRememberedValue = listItemShapesShapes;
        }
        ListItemShapes listItemShapes2 = (ListItemShapes) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return listItemShapes2;
    }

    public final ListItemShapes getDefaultListItemShapes$material3(Shapes shapes) {
        ListItemShapes defaultListItemShapesCached = shapes.getDefaultListItemShapesCached();
        if (defaultListItemShapesCached != null) {
            return defaultListItemShapesCached;
        }
        ListItemShapes listItemShapes = new ListItemShapes(ShapesKt.fromToken(shapes, ListTokens.INSTANCE.getItemContainerExpressiveShape()), ShapesKt.fromToken(shapes, ListTokens.INSTANCE.getItemSelectedContainerExpressiveShape()), ShapesKt.fromToken(shapes, ListTokens.INSTANCE.getItemPressedContainerExpressiveShape()), ShapesKt.fromToken(shapes, ListTokens.INSTANCE.getItemFocusedContainerExpressiveShape()), ShapesKt.fromToken(shapes, ListTokens.INSTANCE.getItemHoveredContainerExpressiveShape()), ShapesKt.fromToken(shapes, ReorderListTokens.INSTANCE.getItemShape()));
        shapes.setDefaultListItemShapesCached$material3(listItemShapes);
        return listItemShapes;
    }

    /* JADX INFO: renamed from: elevation-YgX7TsA$default, reason: not valid java name */
    public static /* synthetic */ ListItemElevation m3666elevationYgX7TsA$default(ListItemDefaults listItemDefaults, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = ListTokens.INSTANCE.m5513getItemContainerElevationD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = ListTokens.INSTANCE.m5514getItemDraggedContainerElevationD9Ej5fM();
        }
        return listItemDefaults.m3670elevationYgX7TsA(f, f2);
    }

    /* JADX INFO: renamed from: elevation-YgX7TsA, reason: not valid java name */
    public final ListItemElevation m3670elevationYgX7TsA(float elevation, float draggedElevation) {
        return new ListItemElevation(elevation, draggedElevation, null);
    }

    /* JADX INFO: renamed from: getSegmentedGap-D9Ej5fM, reason: not valid java name */
    public final float m3672getSegmentedGapD9Ej5fM() {
        return SegmentedGap;
    }

    public final Alignment.Vertical verticalAlignment(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1840604264, "C(verticalAlignment)510@27143L7,511@27166L488:ListItemDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1840604264, i, -1, "androidx.compose.material3.ListItemDefaults.verticalAlignment (ListItemDefaults.kt:509)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Density density = (Density) objConsume;
        ComposerKt.sourceInformationMarkerStart(composer, -705824432, "CC(remember):ListItemDefaults.kt#9igjgp");
        boolean zChanged = composer.changed(density);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Alignment.Vertical() { // from class: androidx.compose.material3.ListItemDefaults$$ExternalSyntheticLambda0
                @Override // androidx.compose.ui.Alignment.Vertical
                public final int align(int i2, int i3) {
                    return ListItemDefaults.verticalAlignment$lambda$0$0(density, i2, i3);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Alignment.Vertical vertical = (Alignment.Vertical) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return vertical;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int verticalAlignment$lambda$0$0(Density density, int i, int i2) {
        Alignment.Vertical top;
        if (i2 < density.mo748roundToPx0680j_4(ListItemKt.getInteractiveListVerticalAlignmentBreakpoint())) {
            top = Alignment.INSTANCE.getCenterVertically();
        } else {
            top = Alignment.INSTANCE.getTop();
        }
        return top.align(i, i2);
    }

    /* JADX INFO: renamed from: colors-J08w3-E, reason: not valid java name */
    public final ListItemColors m3668colorsJ08w3E(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1193261595, "C(colors)N(containerColor:c#ui.graphics.Color,headlineColor:c#ui.graphics.Color,leadingIconColor:c#ui.graphics.Color,overlineColor:c#ui.graphics.Color,supportingColor:c#ui.graphics.Color,trailingIconColor:c#ui.graphics.Color,disabledHeadlineColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color)554@29191L11:ListItemDefaults.kt#uh7d8r");
        long jM6850getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j;
        long jM6850getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        long jM6850getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4;
        long jM6850getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j5;
        long jM6850getUnspecified0d7_KjU6 = (i2 & 32) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j6;
        long jM6850getUnspecified0d7_KjU7 = (i2 & 64) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j7;
        long jM6850getUnspecified0d7_KjU8 = (i2 & 128) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j8;
        long jM6850getUnspecified0d7_KjU9 = (i2 & 256) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j9;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1193261595, i, -1, "androidx.compose.material3.ListItemDefaults.colors (ListItemDefaults.kt:554)");
        }
        ListItemColors listItemColorsM3617copyKKJ9vVU$default = ListItemColors.m3617copyKKJ9vVU$default(getDefaultListItemColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)), jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU3, jM6850getUnspecified0d7_KjU6, jM6850getUnspecified0d7_KjU4, jM6850getUnspecified0d7_KjU5, 0L, jM6850getUnspecified0d7_KjU7, jM6850getUnspecified0d7_KjU8, jM6850getUnspecified0d7_KjU9, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 16776256, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return listItemColorsM3617copyKKJ9vVU$default;
    }
}
