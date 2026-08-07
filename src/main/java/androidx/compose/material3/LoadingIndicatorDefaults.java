package androidx.compose.material3;

import androidx.compose.material3.internal.ShapeUtilKt;
import androidx.compose.material3.tokens.LoadingIndicatorTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Shape;
import androidx.graphics.shapes.RoundedPolygon;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: LoadingIndicator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0011\u0010\r\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00128G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u00128G¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0014\u0010 \u001a\u00020!X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0007¨\u0006#"}, d2 = {"Landroidx/compose/material3/LoadingIndicatorDefaults;", "", "<init>", "()V", "ContainerWidth", "Landroidx/compose/ui/unit/Dp;", "getContainerWidth-D9Ej5fM", "()F", "F", "ContainerHeight", "getContainerHeight-D9Ej5fM", "IndicatorSize", "getIndicatorSize-D9Ej5fM", "containerShape", "Landroidx/compose/ui/graphics/Shape;", "getContainerShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "indicatorColor", "Landroidx/compose/ui/graphics/Color;", "getIndicatorColor", "(Landroidx/compose/runtime/Composer;I)J", "containedIndicatorColor", "getContainedIndicatorColor", "containedContainerColor", "getContainedContainerColor", "IndeterminateIndicatorPolygons", "", "Landroidx/graphics/shapes/RoundedPolygon;", "getIndeterminateIndicatorPolygons", "()Ljava/util/List;", "DeterminateIndicatorPolygons", "getDeterminateIndicatorPolygons", "ActiveIndicatorScale", "", "getActiveIndicatorScale$material3", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LoadingIndicatorDefaults {
    public static final int $stable;
    private static final float ActiveIndicatorScale;
    private static final float ContainerHeight;
    private static final float ContainerWidth;
    private static final List<RoundedPolygon> DeterminateIndicatorPolygons;
    public static final LoadingIndicatorDefaults INSTANCE = new LoadingIndicatorDefaults();
    private static final List<RoundedPolygon> IndeterminateIndicatorPolygons;
    private static final float IndicatorSize;

    private LoadingIndicatorDefaults() {
    }

    static {
        float fM5536getContainerWidthD9Ej5fM = LoadingIndicatorTokens.INSTANCE.m5536getContainerWidthD9Ej5fM();
        ContainerWidth = fM5536getContainerWidthD9Ej5fM;
        float fM5535getContainerHeightD9Ej5fM = LoadingIndicatorTokens.INSTANCE.m5535getContainerHeightD9Ej5fM();
        ContainerHeight = fM5535getContainerHeightD9Ej5fM;
        float fM5534getActiveSizeD9Ej5fM = LoadingIndicatorTokens.INSTANCE.m5534getActiveSizeD9Ej5fM();
        IndicatorSize = fM5534getActiveSizeD9Ej5fM;
        IndeterminateIndicatorPolygons = CollectionsKt.listOf((Object[]) new RoundedPolygon[]{MaterialShapes.INSTANCE.getSoftBurst(), MaterialShapes.INSTANCE.getCookie9Sided(), MaterialShapes.INSTANCE.getPentagon(), MaterialShapes.INSTANCE.getPill(), MaterialShapes.INSTANCE.getSunny(), MaterialShapes.INSTANCE.getCookie4Sided(), MaterialShapes.INSTANCE.getOval()});
        RoundedPolygon circle = MaterialShapes.INSTANCE.getCircle();
        float[] fArrM7060constructorimpl$default = Matrix.m7060constructorimpl$default(null, 1, null);
        Matrix.m7074rotateZimpl(fArrM7060constructorimpl$default, 18.0f);
        Unit unit = Unit.INSTANCE;
        DeterminateIndicatorPolygons = CollectionsKt.listOf((Object[]) new RoundedPolygon[]{ShapeUtilKt.m4999transformedEL8BTi8(circle, fArrM7060constructorimpl$default), MaterialShapes.INSTANCE.getSoftBurst()});
        ActiveIndicatorScale = fM5534getActiveSizeD9Ej5fM / Math.min(fM5536getContainerWidthD9Ej5fM, fM5535getContainerHeightD9Ej5fM);
        $stable = 8;
    }

    /* JADX INFO: renamed from: getContainerWidth-D9Ej5fM, reason: not valid java name */
    public final float m3723getContainerWidthD9Ej5fM() {
        return ContainerWidth;
    }

    /* JADX INFO: renamed from: getContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m3722getContainerHeightD9Ej5fM() {
        return ContainerHeight;
    }

    /* JADX INFO: renamed from: getIndicatorSize-D9Ej5fM, reason: not valid java name */
    public final float m3724getIndicatorSizeD9Ej5fM() {
        return IndicatorSize;
    }

    public final Shape getContainerShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -177211483, "C(<get-containerShape>)504@22796L5:LoadingIndicator.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-177211483, i, -1, "androidx.compose.material3.LoadingIndicatorDefaults.<get-containerShape> (LoadingIndicator.kt:504)");
        }
        Shape value = ShapesKt.getValue(LoadingIndicatorTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getIndicatorColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2068204953, "C(<get-indicatorColor>)511@23035L5:LoadingIndicator.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2068204953, i, -1, "androidx.compose.material3.LoadingIndicatorDefaults.<get-indicatorColor> (LoadingIndicator.kt:511)");
        }
        long value = ColorSchemeKt.getValue(LoadingIndicatorTokens.INSTANCE.getActiveIndicatorColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getContainedIndicatorColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 507506629, "C(<get-containedIndicatorColor>)518@23279L5:LoadingIndicator.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(507506629, i, -1, "androidx.compose.material3.LoadingIndicatorDefaults.<get-containedIndicatorColor> (LoadingIndicator.kt:518)");
        }
        long value = ColorSchemeKt.getValue(LoadingIndicatorTokens.INSTANCE.getContainedActiveColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getContainedContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1228434263, "C(<get-containedContainerColor>)522@23500L5:LoadingIndicator.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1228434263, i, -1, "androidx.compose.material3.LoadingIndicatorDefaults.<get-containedContainerColor> (LoadingIndicator.kt:522)");
        }
        long value = ColorSchemeKt.getValue(LoadingIndicatorTokens.INSTANCE.getContainedContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final List<RoundedPolygon> getIndeterminateIndicatorPolygons() {
        return IndeterminateIndicatorPolygons;
    }

    public final List<RoundedPolygon> getDeterminateIndicatorPolygons() {
        return DeterminateIndicatorPolygons;
    }

    public final float getActiveIndicatorScale$material3() {
        return ActiveIndicatorScale;
    }
}
