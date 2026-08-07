package androidx.compose.material3.internal;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CircularWavyProgressModifiers.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u001a|\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u00040\u000e2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001aU\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a;\u0010\u0017\u001a\u00020\u0018*\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001d\"\u000e\u0010\u001e\u001a\u00020\u001fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u001fX\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"circularWavyProgressIndicator", "Landroidx/compose/ui/Modifier;", "progress", "Lkotlin/Function0;", "", "color", "Landroidx/compose/ui/graphics/Color;", "trackColor", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "trackStroke", "gapSize", "Landroidx/compose/ui/unit/Dp;", "amplitude", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "wavelength", "waveSpeed", "circularWavyProgressIndicator-4ohQjRg", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;JJLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;FLkotlin/jvm/functions/Function1;FF)Landroidx/compose/ui/Modifier;", "circularWavyProgressIndicator-4JQtiWo", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;FFFF)Landroidx/compose/ui/Modifier;", "drawCircularIndicator", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawingCache", "Landroidx/compose/material3/internal/CircularProgressDrawingCache;", "drawCircularIndicator-RIQooxk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/material3/internal/CircularProgressDrawingCache;)V", "MinCircularVertexCount", "", "MinAnimationDuration", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CircularWavyProgressModifiersKt {
    private static final int MinAnimationDuration = 50;
    private static final int MinCircularVertexCount = 5;

    /* JADX INFO: renamed from: circularWavyProgressIndicator-4ohQjRg, reason: not valid java name */
    public static final Modifier m4962circularWavyProgressIndicator4ohQjRg(Modifier modifier, Function0<Float> function0, long j, long j2, Stroke stroke, Stroke stroke2, float f, Function1<? super Float, Float> function1, float f2, float f3) {
        return modifier.then(new DeterminateCircularWavyProgressElement(function0, j, j2, stroke, stroke2, f, function1, f2, f3, null));
    }

    /* JADX INFO: renamed from: circularWavyProgressIndicator-4JQtiWo, reason: not valid java name */
    public static final Modifier m4961circularWavyProgressIndicator4JQtiWo(Modifier modifier, long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, float f3, float f4) {
        return modifier.then(new IndeterminateCircularWavyProgressElement(j, j2, stroke, stroke2, f, f2, f3, f4, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawCircularIndicator-RIQooxk, reason: not valid java name */
    public static final void m4963drawCircularIndicatorRIQooxk(DrawScope drawScope, long j, long j2, Stroke stroke, Stroke stroke2, CircularProgressDrawingCache circularProgressDrawingCache) {
        if (!Color.m6815equalsimpl0(j2, Color.INSTANCE.m6849getTransparent0d7_KjU()) && !Color.m6815equalsimpl0(j2, Color.INSTANCE.m6850getUnspecified0d7_KjU())) {
            DrawScope.m7385drawPathLG529CI$default(drawScope, circularProgressDrawingCache.getTrackPathToDraw(), j2, 0.0f, stroke2, null, 0, 52, null);
        }
        if (Color.m6815equalsimpl0(j, Color.INSTANCE.m6849getTransparent0d7_KjU()) || Color.m6815equalsimpl0(j, Color.INSTANCE.m6850getUnspecified0d7_KjU())) {
            return;
        }
        DrawScope.m7385drawPathLG529CI$default(drawScope, circularProgressDrawingCache.getProgressPathToDraw(), j, 0.0f, stroke, null, 0, 52, null);
    }
}
