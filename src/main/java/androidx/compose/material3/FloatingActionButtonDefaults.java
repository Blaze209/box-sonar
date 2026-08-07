package androidx.compose.material3;

import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.ExtendedFabLargeTokens;
import androidx.compose.material3.tokens.ExtendedFabPrimaryTokens;
import androidx.compose.material3.tokens.ExtendedFabSmallTokens;
import androidx.compose.material3.tokens.FabBaselineTokens;
import androidx.compose.material3.tokens.FabLargeTokens;
import androidx.compose.material3.tokens.FabMediumTokens;
import androidx.compose.material3.tokens.FabPrimaryContainerTokens;
import androidx.compose.material3.tokens.FabSmallTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: compiled from: FloatingActionButton.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\t2\b\b\u0002\u0010-\u001a\u00020\t2\b\b\u0002\u0010.\u001a\u00020\t2\b\b\u0002\u0010/\u001a\u00020\tH\u0007¢\u0006\u0004\b0\u00101J7\u00102\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\t2\b\b\u0002\u0010-\u001a\u00020\t2\b\b\u0002\u0010.\u001a\u00020\t2\b\b\u0002\u0010/\u001a\u00020\tH\u0007¢\u0006\u0004\b3\u00101J5\u00104\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\t2\b\b\u0002\u0010-\u001a\u00020\t2\b\b\u0002\u0010.\u001a\u00020\t2\b\b\u0002\u0010/\u001a\u00020\t¢\u0006\u0004\b5\u00106R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\f\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\u0007R\u0013\u0010\r\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u0007R\u0011\u0010\u000f\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u00108GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u0019\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u001b\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0012R\u001a\u0010\u001d\u001a\u00020\u00108GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0012R\u001a\u0010 \u001a\u00020\u00108GX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010\u0012R\u001a\u0010#\u001a\u00020\u00108GX\u0087\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0017\u001a\u0004\b%\u0010\u0012R\u0011\u0010&\u001a\u00020'8G¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u00067"}, d2 = {"Landroidx/compose/material3/FloatingActionButtonDefaults;", "", "<init>", "()V", "ShowHideTargetScale", "", "getShowHideTargetScale$material3", "()F", "MediumIconSize", "Landroidx/compose/ui/unit/Dp;", "getMediumIconSize-D9Ej5fM$annotations", "getMediumIconSize-D9Ej5fM", "F", "LargeIconSize", "getLargeIconSize-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "smallShape", "getSmallShape", "mediumShape", "getMediumShape$annotations", "(Landroidx/compose/runtime/Composer;I)V", "getMediumShape", "largeShape", "getLargeShape", "extendedFabShape", "getExtendedFabShape", "smallExtendedFabShape", "getSmallExtendedFabShape$annotations", "getSmallExtendedFabShape", "mediumExtendedFabShape", "getMediumExtendedFabShape$annotations", "getMediumExtendedFabShape", "largeExtendedFabShape", "getLargeExtendedFabShape$annotations", "getLargeExtendedFabShape", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "elevation", "Landroidx/compose/material3/FloatingActionButtonElevation;", "defaultElevation", "pressedElevation", "focusedElevation", "hoveredElevation", "elevation-xZ9-QkE", "(FFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/FloatingActionButtonElevation;", "loweredElevation", "loweredElevation-xZ9-QkE", "bottomAppBarFabElevation", "bottomAppBarFabElevation-a9UjIt4", "(FFFF)Landroidx/compose/material3/FloatingActionButtonElevation;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FloatingActionButtonDefaults {
    public static final int $stable = 0;
    public static final FloatingActionButtonDefaults INSTANCE = new FloatingActionButtonDefaults();
    private static final float ShowHideTargetScale = 0.2f;
    private static final float MediumIconSize = FabMediumTokens.INSTANCE.m5402getIconSizeD9Ej5fM();
    private static final float LargeIconSize = Dp.m9687constructorimpl(36);

    public static /* synthetic */ void getLargeExtendedFabShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getMediumExtendedFabShape$annotations(Composer composer, int i) {
    }

    /* JADX INFO: renamed from: getMediumIconSize-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m3372getMediumIconSizeD9Ej5fM$annotations() {
    }

    public static /* synthetic */ void getMediumShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getSmallExtendedFabShape$annotations(Composer composer, int i) {
    }

    private FloatingActionButtonDefaults() {
    }

    public final float getShowHideTargetScale$material3() {
        return ShowHideTargetScale;
    }

    /* JADX INFO: renamed from: getMediumIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3376getMediumIconSizeD9Ej5fM() {
        return MediumIconSize;
    }

    /* JADX INFO: renamed from: getLargeIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3375getLargeIconSizeD9Ej5fM() {
        return LargeIconSize;
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -53247565, "C(<get-shape>)1006@47412L5:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-53247565, i, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-shape> (FloatingActionButton.kt:1006)");
        }
        Shape value = ShapesKt.getValue(FabBaselineTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getSmallShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 394933381, "C(<get-smallShape>)1010@47564L5:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(394933381, i, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-smallShape> (FloatingActionButton.kt:1010)");
        }
        Shape value = ShapesKt.getValue(FabSmallTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getMediumShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 356809117, "C(<get-mediumShape>):FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(356809117, i, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-mediumShape> (FloatingActionButton.kt:1015)");
        }
        CornerBasedShape largeIncreased = ShapeDefaults.INSTANCE.getLargeIncreased();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return largeIncreased;
    }

    public final Shape getLargeShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1835912187, "C(<get-largeShape>)1019@47932L5:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1835912187, i, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-largeShape> (FloatingActionButton.kt:1019)");
        }
        Shape value = ShapesKt.getValue(FabLargeTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExtendedFabShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -536021915, "C(<get-extendedFabShape>)1023@48104L5:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-536021915, i, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-extendedFabShape> (FloatingActionButton.kt:1023)");
        }
        Shape value = ShapesKt.getValue(ExtendedFabPrimaryTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getSmallExtendedFabShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -301808959, "C(<get-smallExtendedFabShape>)1028@48324L5:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-301808959, i, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-smallExtendedFabShape> (FloatingActionButton.kt:1028)");
        }
        Shape value = ShapesKt.getValue(ExtendedFabSmallTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getMediumExtendedFabShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -996203963, "C(<get-mediumExtendedFabShape>):FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-996203963, i, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-mediumExtendedFabShape> (FloatingActionButton.kt:1033)");
        }
        CornerBasedShape largeIncreased = ShapeDefaults.INSTANCE.getLargeIncreased();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return largeIncreased;
    }

    public final Shape getLargeExtendedFabShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 854532185, "C(<get-largeExtendedFabShape>)1038@48780L5:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(854532185, i, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-largeExtendedFabShape> (FloatingActionButton.kt:1038)");
        }
        Shape value = ShapesKt.getValue(ExtendedFabLargeTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1855656391, "C(<get-containerColor>)1042@48951L5:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1855656391, i, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-containerColor> (FloatingActionButton.kt:1042)");
        }
        long value = ColorSchemeKt.getValue(FabPrimaryContainerTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* JADX INFO: renamed from: elevation-xZ9-QkE, reason: not valid java name */
    public final FloatingActionButtonElevation m3374elevationxZ9QkE(float f, float f2, float f3, float f4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -241106249, "C(elevation)N(defaultElevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp):FloatingActionButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f = FabPrimaryContainerTokens.INSTANCE.m5415getContainerElevationD9Ej5fM();
        }
        float f5 = f;
        if ((i2 & 2) != 0) {
            f2 = FabPrimaryContainerTokens.INSTANCE.m5418getPressedContainerElevationD9Ej5fM();
        }
        float f6 = f2;
        if ((i2 & 4) != 0) {
            f3 = FabPrimaryContainerTokens.INSTANCE.m5416getFocusedContainerElevationD9Ej5fM();
        }
        float f7 = f3;
        if ((i2 & 8) != 0) {
            f4 = FabPrimaryContainerTokens.INSTANCE.m5417getHoveredContainerElevationD9Ej5fM();
        }
        float f8 = f4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-241106249, i, -1, "androidx.compose.material3.FloatingActionButtonDefaults.elevation (FloatingActionButton.kt:1062)");
        }
        FloatingActionButtonElevation floatingActionButtonElevation = new FloatingActionButtonElevation(f5, f6, f7, f8, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return floatingActionButtonElevation;
    }

    /* JADX INFO: renamed from: loweredElevation-xZ9-QkE, reason: not valid java name */
    public final FloatingActionButtonElevation m3377loweredElevationxZ9QkE(float f, float f2, float f3, float f4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -285065125, "C(loweredElevation)N(defaultElevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp):FloatingActionButton.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f = ElevationTokens.INSTANCE.m5364getLevel1D9Ej5fM();
        }
        float f5 = f;
        if ((i2 & 2) != 0) {
            f2 = ElevationTokens.INSTANCE.m5364getLevel1D9Ej5fM();
        }
        float f6 = f2;
        if ((i2 & 4) != 0) {
            f3 = ElevationTokens.INSTANCE.m5364getLevel1D9Ej5fM();
        }
        float f7 = f3;
        if ((i2 & 8) != 0) {
            f4 = ElevationTokens.INSTANCE.m5365getLevel2D9Ej5fM();
        }
        float f8 = f4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-285065125, i, -1, "androidx.compose.material3.FloatingActionButtonDefaults.loweredElevation (FloatingActionButton.kt:1086)");
        }
        FloatingActionButtonElevation floatingActionButtonElevation = new FloatingActionButtonElevation(f5, f6, f7, f8, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return floatingActionButtonElevation;
    }

    /* JADX INFO: renamed from: bottomAppBarFabElevation-a9UjIt4, reason: not valid java name */
    public final FloatingActionButtonElevation m3373bottomAppBarFabElevationa9UjIt4(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation) {
        return new FloatingActionButtonElevation(defaultElevation, pressedElevation, focusedElevation, hoveredElevation, null);
    }

    /* JADX INFO: renamed from: bottomAppBarFabElevation-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ FloatingActionButtonElevation m3371bottomAppBarFabElevationa9UjIt4$default(FloatingActionButtonDefaults floatingActionButtonDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m9687constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m9687constructorimpl(0);
        }
        if ((i & 4) != 0) {
            f3 = Dp.m9687constructorimpl(0);
        }
        if ((i & 8) != 0) {
            f4 = Dp.m9687constructorimpl(0);
        }
        return floatingActionButtonDefaults.m3373bottomAppBarFabElevationa9UjIt4(f, f2, f3, f4);
    }
}
