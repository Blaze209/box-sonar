package androidx.compose.material3.internal;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.ui.draw.CacheDrawModifierNode;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: LinearWavyProgressModifiers.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001Bx\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010'\u001a\u00020&H\u0014J\b\u0010(\u001a\u00020)H\u0014J\b\u0010*\u001a\u00020)H\u0014R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R5\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u00040\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR&\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010+\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u0006/"}, d2 = {"Landroidx/compose/material3/internal/DeterminateLinearWavyProgressNode;", "Landroidx/compose/material3/internal/BaseLinearWavyProgressNode;", "progress", "Lkotlin/Function0;", "", "amplitude", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "stopSizeParameter", "Landroidx/compose/ui/unit/Dp;", "colorParameter", "Landroidx/compose/ui/graphics/Color;", "trackColorParameter", "strokeParameter", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "trackStrokeParameter", "gapSizeParameter", "wavelengthParameter", "waveSpeedParameter", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;FJJLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;FFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getProgress", "()Lkotlin/jvm/functions/Function0;", "setProgress", "(Lkotlin/jvm/functions/Function0;)V", "getAmplitude", "()Lkotlin/jvm/functions/Function1;", "setAmplitude", "(Lkotlin/jvm/functions/Function1;)V", "value", "stopSize", "getStopSize-D9Ej5fM", "()F", "setStopSize-0680j_4", "(F)V", "F", "progressFractionsArray", "", "getProgressFractions", "invalidateDraw", "", "invalidateDrawCache", "cacheDrawNodeDelegate", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "getCacheDrawNodeDelegate", "()Landroidx/compose/ui/draw/CacheDrawModifierNode;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DeterminateLinearWavyProgressNode extends BaseLinearWavyProgressNode {
    private Function1<? super Float, Float> amplitude;
    private final CacheDrawModifierNode cacheDrawNodeDelegate;
    private Function0<Float> progress;
    private final float[] progressFractionsArray;
    private float stopSize;

    public /* synthetic */ DeterminateLinearWavyProgressNode(Function0 function0, Function1 function1, float f, long j, long j2, Stroke stroke, Stroke stroke2, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, function1, f, j, j2, stroke, stroke2, f2, f3, f4);
    }

    private DeterminateLinearWavyProgressNode(Function0<Float> function0, Function1<? super Float, Float> function1, float f, long j, long j2, Stroke stroke, Stroke stroke2, float f2, float f3, float f4) {
        super(j, j2, stroke, stroke2, f2, f3, f4, null);
        this.progress = function0;
        this.amplitude = function1;
        this.stopSize = f;
        this.progressFractionsArray = new float[]{0.0f, 0.0f};
        this.cacheDrawNodeDelegate = (CacheDrawModifierNode) delegate(DrawModifierKt.CacheDrawModifierNode(new Function1() { // from class: androidx.compose.material3.internal.DeterminateLinearWavyProgressNode$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DeterminateLinearWavyProgressNode.cacheDrawNodeDelegate$lambda$0(this.f$0, (CacheDrawScope) obj);
            }
        }));
    }

    public final Function0<Float> getProgress() {
        return this.progress;
    }

    public final void setProgress(Function0<Float> function0) {
        this.progress = function0;
    }

    public final Function1<Float, Float> getAmplitude() {
        return this.amplitude;
    }

    public final void setAmplitude(Function1<? super Float, Float> function1) {
        this.amplitude = function1;
    }

    /* JADX INFO: renamed from: getStopSize-D9Ej5fM, reason: not valid java name and from getter */
    public final float getStopSize() {
        return this.stopSize;
    }

    /* JADX INFO: renamed from: setStopSize-0680j_4, reason: not valid java name */
    public final void m4971setStopSize0680j_4(float f) {
        if (Dp.m9692equalsimpl0(this.stopSize, f)) {
            return;
        }
        this.stopSize = f;
        DrawModifierNodeKt.invalidateDraw(this.cacheDrawNodeDelegate);
    }

    @Override // androidx.compose.material3.internal.BaseLinearWavyProgressNode
    protected float[] getProgressFractions() {
        float[] fArr = this.progressFractionsArray;
        fArr[0] = 0.0f;
        float fFloatValue = this.progress.invoke().floatValue();
        float f = fFloatValue >= 0.0f ? fFloatValue : 0.0f;
        if (f > 1.0f) {
            f = 1.0f;
        }
        fArr[1] = f;
        return this.progressFractionsArray;
    }

    @Override // androidx.compose.material3.internal.BaseLinearWavyProgressNode
    protected void invalidateDraw() {
        DrawModifierNodeKt.invalidateDraw(this.cacheDrawNodeDelegate);
    }

    @Override // androidx.compose.material3.internal.BaseLinearWavyProgressNode
    protected void invalidateDrawCache() {
        this.cacheDrawNodeDelegate.invalidateDrawCache();
    }

    public final CacheDrawModifierNode getCacheDrawNodeDelegate() {
        return this.cacheDrawNodeDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult cacheDrawNodeDelegate$lambda$0(final DeterminateLinearWavyProgressNode determinateLinearWavyProgressNode, CacheDrawScope cacheDrawScope) {
        float fFloatValue = determinateLinearWavyProgressNode.progress.invoke().floatValue();
        if (fFloatValue < 0.0f) {
            fFloatValue = 0.0f;
        }
        if (fFloatValue > 1.0f) {
            fFloatValue = 1.0f;
        }
        float fFloatValue2 = determinateLinearWavyProgressNode.amplitude.invoke(Float.valueOf(fFloatValue)).floatValue();
        float f = fFloatValue2 >= 0.0f ? fFloatValue2 : 0.0f;
        determinateLinearWavyProgressNode.updateAmplitudeAnimation(f <= 1.0f ? f : 1.0f);
        return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.material3.internal.DeterminateLinearWavyProgressNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DeterminateLinearWavyProgressNode.cacheDrawNodeDelegate$lambda$0$0(this.f$0, (ContentDrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cacheDrawNodeDelegate$lambda$0$0(DeterminateLinearWavyProgressNode determinateLinearWavyProgressNode, ContentDrawScope contentDrawScope) {
        Animatable<Float, AnimationVector1D> amplitudeAnimatable = determinateLinearWavyProgressNode.getAmplitudeAnimatable();
        float fFloatValue = amplitudeAnimatable != null ? amplitudeAnimatable.getValue().floatValue() : 0.0f;
        determinateLinearWavyProgressNode.getProgressDrawingCache().m4992updatePathsVygBpHg(contentDrawScope.mo7395getSizeNHjbRc(), contentDrawScope.mo754toPx0680j_4(determinateLinearWavyProgressNode.getWavelength()), determinateLinearWavyProgressNode.getProgressFractions(), fFloatValue, fFloatValue > 0.0f ? determinateLinearWavyProgressNode.getWaveOffset().getFloatValue() : 0.0f, contentDrawScope.mo754toPx0680j_4(determinateLinearWavyProgressNode.getGapSize()), determinateLinearWavyProgressNode.getStroke(), determinateLinearWavyProgressNode.getTrackStroke());
        LinearProgressDrawingCache progressDrawingCache = determinateLinearWavyProgressNode.getProgressDrawingCache();
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        float f = contentDrawScope.getLayoutDirection() != LayoutDirection.Ltr ? 180.0f : 0.0f;
        long jMo7394getCenterF1C5BW0 = contentDrawScope2.mo7394getCenterF1C5BW0();
        DrawContext drawContext = contentDrawScope2.getDrawContext();
        long jMo7316getSizeNHjbRc = drawContext.mo7316getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo7322rotateUv8p0NA(f, jMo7394getCenterF1C5BW0);
            DrawScope.m7385drawPathLG529CI$default(contentDrawScope2, progressDrawingCache.getTrackPathToDraw(), determinateLinearWavyProgressNode.getTrackColor(), 0.0f, determinateLinearWavyProgressNode.getTrackStroke(), null, 0, 52, null);
            Path[] progressPathsToDraw = progressDrawingCache.getProgressPathsToDraw();
            if (progressPathsToDraw != null) {
                int length = progressPathsToDraw.length;
                int i = 0;
                while (i < length) {
                    int i2 = i;
                    DrawScope.m7385drawPathLG529CI$default(contentDrawScope2, progressPathsToDraw[i2], determinateLinearWavyProgressNode.getColor(), 0.0f, determinateLinearWavyProgressNode.getStroke(), null, 0, 52, null);
                    i = i2 + 1;
                }
            }
            LinearWavyProgressModifiersKt.m4994drawStopIndicatorVnkRyUA(contentDrawScope2, determinateLinearWavyProgressNode.getProgressFractions()[1], contentDrawScope2.mo7395getSizeNHjbRc(), determinateLinearWavyProgressNode.stopSize, progressDrawingCache.getCurrentStrokeCapWidth(), determinateLinearWavyProgressNode.getTrackStroke(), determinateLinearWavyProgressNode.getColor());
            return Unit.INSTANCE;
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo7317setSizeuvyYCjk(jMo7316getSizeNHjbRc);
        }
    }
}
