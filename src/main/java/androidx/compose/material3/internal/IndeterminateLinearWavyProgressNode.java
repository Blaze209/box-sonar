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
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: LinearWavyProgressModifiers.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u007f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010'\u001a\u00020&H\u0014J\b\u0010(\u001a\u00020)H\u0014J\b\u0010*\u001a\u00020)H\u0014R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R$\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Landroidx/compose/material3/internal/IndeterminateLinearWavyProgressNode;", "Landroidx/compose/material3/internal/BaseLinearWavyProgressNode;", "firstLineHeadProgress", "Lkotlin/Function0;", "", "firstLineTailProgress", "secondLineHeadProgress", "secondLineTailProgress", "amplitudeParameter", "colorParameter", "Landroidx/compose/ui/graphics/Color;", "trackColorParameter", "strokeParameter", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "trackStrokeParameter", "gapSizeParameter", "Landroidx/compose/ui/unit/Dp;", "wavelengthParameter", "waveSpeedParameter", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;FJJLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;FFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFirstLineHeadProgress", "()Lkotlin/jvm/functions/Function0;", "setFirstLineHeadProgress", "(Lkotlin/jvm/functions/Function0;)V", "getFirstLineTailProgress", "setFirstLineTailProgress", "getSecondLineHeadProgress", "setSecondLineHeadProgress", "getSecondLineTailProgress", "setSecondLineTailProgress", "value", "amplitude", "getAmplitude", "()F", "setAmplitude", "(F)V", "progressFractionsArray", "", "getProgressFractions", "invalidateDraw", "", "invalidateDrawCache", "cacheDrawNodeDelegate", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class IndeterminateLinearWavyProgressNode extends BaseLinearWavyProgressNode {
    private float amplitude;
    private final CacheDrawModifierNode cacheDrawNodeDelegate;
    private Function0<Float> firstLineHeadProgress;
    private Function0<Float> firstLineTailProgress;
    private final float[] progressFractionsArray;
    private Function0<Float> secondLineHeadProgress;
    private Function0<Float> secondLineTailProgress;

    public /* synthetic */ IndeterminateLinearWavyProgressNode(Function0 function0, Function0 function1, Function0 function2, Function0 function3, float f, long j, long j2, Stroke stroke, Stroke stroke2, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, function1, function2, function3, f, j, j2, stroke, stroke2, f2, f3, f4);
    }

    private IndeterminateLinearWavyProgressNode(Function0<Float> function0, Function0<Float> function1, Function0<Float> function2, Function0<Float> function3, float f, long j, long j2, Stroke stroke, Stroke stroke2, float f2, float f3, float f4) {
        super(j, j2, stroke, stroke2, f2, f3, f4, null);
        this.firstLineHeadProgress = function0;
        this.firstLineTailProgress = function1;
        this.secondLineHeadProgress = function2;
        this.secondLineTailProgress = function3;
        float f5 = f >= 0.0f ? f : 0.0f;
        this.amplitude = f5 > 1.0f ? 1.0f : f5;
        this.progressFractionsArray = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.cacheDrawNodeDelegate = (CacheDrawModifierNode) delegate(DrawModifierKt.CacheDrawModifierNode(new Function1() { // from class: androidx.compose.material3.internal.IndeterminateLinearWavyProgressNode$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IndeterminateLinearWavyProgressNode.cacheDrawNodeDelegate$lambda$0(this.f$0, (CacheDrawScope) obj);
            }
        }));
    }

    public final Function0<Float> getFirstLineHeadProgress() {
        return this.firstLineHeadProgress;
    }

    public final void setFirstLineHeadProgress(Function0<Float> function0) {
        this.firstLineHeadProgress = function0;
    }

    public final Function0<Float> getFirstLineTailProgress() {
        return this.firstLineTailProgress;
    }

    public final void setFirstLineTailProgress(Function0<Float> function0) {
        this.firstLineTailProgress = function0;
    }

    public final Function0<Float> getSecondLineHeadProgress() {
        return this.secondLineHeadProgress;
    }

    public final void setSecondLineHeadProgress(Function0<Float> function0) {
        this.secondLineHeadProgress = function0;
    }

    public final Function0<Float> getSecondLineTailProgress() {
        return this.secondLineTailProgress;
    }

    public final void setSecondLineTailProgress(Function0<Float> function0) {
        this.secondLineTailProgress = function0;
    }

    public final float getAmplitude() {
        return this.amplitude;
    }

    public final void setAmplitude(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        if (this.amplitude == f) {
            return;
        }
        this.amplitude = f;
        invalidateDrawCache();
    }

    @Override // androidx.compose.material3.internal.BaseLinearWavyProgressNode
    protected float[] getProgressFractions() {
        this.progressFractionsArray[0] = this.firstLineTailProgress.invoke().floatValue();
        this.progressFractionsArray[1] = this.firstLineHeadProgress.invoke().floatValue();
        this.progressFractionsArray[2] = this.secondLineTailProgress.invoke().floatValue();
        this.progressFractionsArray[3] = this.secondLineHeadProgress.invoke().floatValue();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult cacheDrawNodeDelegate$lambda$0(final IndeterminateLinearWavyProgressNode indeterminateLinearWavyProgressNode, CacheDrawScope cacheDrawScope) {
        indeterminateLinearWavyProgressNode.updateAmplitudeAnimation(indeterminateLinearWavyProgressNode.amplitude);
        return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.material3.internal.IndeterminateLinearWavyProgressNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IndeterminateLinearWavyProgressNode.cacheDrawNodeDelegate$lambda$0$0(this.f$0, (ContentDrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cacheDrawNodeDelegate$lambda$0$0(IndeterminateLinearWavyProgressNode indeterminateLinearWavyProgressNode, ContentDrawScope contentDrawScope) {
        Animatable<Float, AnimationVector1D> amplitudeAnimatable = indeterminateLinearWavyProgressNode.getAmplitudeAnimatable();
        float fFloatValue = amplitudeAnimatable != null ? amplitudeAnimatable.getValue().floatValue() : 0.0f;
        indeterminateLinearWavyProgressNode.getProgressDrawingCache().m4992updatePathsVygBpHg(contentDrawScope.mo7395getSizeNHjbRc(), contentDrawScope.mo754toPx0680j_4(indeterminateLinearWavyProgressNode.getWavelength()), indeterminateLinearWavyProgressNode.getProgressFractions(), fFloatValue, fFloatValue > 0.0f ? indeterminateLinearWavyProgressNode.getWaveOffset().getFloatValue() : 0.0f, contentDrawScope.mo754toPx0680j_4(indeterminateLinearWavyProgressNode.getGapSize()), indeterminateLinearWavyProgressNode.getStroke(), indeterminateLinearWavyProgressNode.getTrackStroke());
        LinearProgressDrawingCache progressDrawingCache = indeterminateLinearWavyProgressNode.getProgressDrawingCache();
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        float f = contentDrawScope.getLayoutDirection() != LayoutDirection.Ltr ? 180.0f : 0.0f;
        long jMo7394getCenterF1C5BW0 = contentDrawScope2.mo7394getCenterF1C5BW0();
        DrawContext drawContext = contentDrawScope2.getDrawContext();
        long jMo7316getSizeNHjbRc = drawContext.mo7316getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo7322rotateUv8p0NA(f, jMo7394getCenterF1C5BW0);
            DrawScope.m7385drawPathLG529CI$default(contentDrawScope2, progressDrawingCache.getTrackPathToDraw(), indeterminateLinearWavyProgressNode.getTrackColor(), 0.0f, indeterminateLinearWavyProgressNode.getTrackStroke(), null, 0, 52, null);
            Path[] progressPathsToDraw = progressDrawingCache.getProgressPathsToDraw();
            if (progressPathsToDraw != null) {
                for (Path path : progressPathsToDraw) {
                    DrawScope.m7385drawPathLG529CI$default(contentDrawScope2, path, indeterminateLinearWavyProgressNode.getColor(), 0.0f, indeterminateLinearWavyProgressNode.getStroke(), null, 0, 52, null);
                }
            }
            return Unit.INSTANCE;
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo7317setSizeuvyYCjk(jMo7316getSizeNHjbRc);
        }
    }
}
