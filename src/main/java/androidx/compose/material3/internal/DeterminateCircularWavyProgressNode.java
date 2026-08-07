package androidx.compose.material3.internal;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.ui.draw.CacheDrawModifierNode;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: CircularWavyProgressModifiers.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001Bp\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020%H\u0016J\b\u0010'\u001a\u00020%H\u0014J\b\u0010(\u001a\u00020%H\u0014J\b\u0010)\u001a\u00020*H\u0014R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R5\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u00040\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010+\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u0006/"}, d2 = {"Landroidx/compose/material3/internal/DeterminateCircularWavyProgressNode;", "Landroidx/compose/material3/internal/BaseCircularWavyProgressNode;", "progress", "Lkotlin/Function0;", "", "amplitude", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "colorParameter", "Landroidx/compose/ui/graphics/Color;", "trackColorParameter", "strokeParameter", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "trackStrokeParameter", "gapSizeParameter", "Landroidx/compose/ui/unit/Dp;", "wavelengthParameter", "waveSpeedParameter", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;JJLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;FFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getProgress", "()Lkotlin/jvm/functions/Function0;", "setProgress", "(Lkotlin/jvm/functions/Function0;)V", "getAmplitude", "()Lkotlin/jvm/functions/Function1;", "setAmplitude", "(Lkotlin/jvm/functions/Function1;)V", "amplitudeState", "Landroidx/compose/runtime/MutableFloatState;", "amplitudeAnimatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "amplitudeAnimationJob", "Lkotlinx/coroutines/Job;", "onAttach", "", "onDetach", "invalidateDraw", "invalidateDrawCache", "isDrawingWave", "", "cacheDrawNode", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "getCacheDrawNode", "()Landroidx/compose/ui/draw/CacheDrawModifierNode;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DeterminateCircularWavyProgressNode extends BaseCircularWavyProgressNode {
    private Function1<? super Float, Float> amplitude;
    private Animatable<Float, AnimationVector1D> amplitudeAnimatable;
    private Job amplitudeAnimationJob;
    private final MutableFloatState amplitudeState;
    private final CacheDrawModifierNode cacheDrawNode;
    private Function0<Float> progress;

    public /* synthetic */ DeterminateCircularWavyProgressNode(Function0 function0, Function1 function1, long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, float f3, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, function1, j, j2, stroke, stroke2, f, f2, f3);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
    }

    private DeterminateCircularWavyProgressNode(Function0<Float> function0, Function1<? super Float, Float> function1, long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, float f3) {
        super(j, j2, stroke, stroke2, f, f2, f3, null);
        this.progress = function0;
        this.amplitude = function1;
        this.amplitudeState = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.cacheDrawNode = (CacheDrawModifierNode) delegate(DrawModifierKt.CacheDrawModifierNode(new Function1() { // from class: androidx.compose.material3.internal.DeterminateCircularWavyProgressNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DeterminateCircularWavyProgressNode.cacheDrawNode$lambda$0(this.f$0, (CacheDrawScope) obj);
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

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        super.onDetach();
        this.amplitudeAnimatable = null;
        setVertexCountForCurrentAnimation(-1);
    }

    @Override // androidx.compose.material3.internal.BaseCircularWavyProgressNode
    protected void invalidateDraw() {
        DrawModifierNodeKt.invalidateDraw(this.cacheDrawNode);
    }

    @Override // androidx.compose.material3.internal.BaseCircularWavyProgressNode
    protected void invalidateDrawCache() {
        this.cacheDrawNode.invalidateDrawCache();
    }

    @Override // androidx.compose.material3.internal.BaseCircularWavyProgressNode
    protected boolean isDrawingWave() {
        return this.amplitudeState.getFloatValue() > 0.0f;
    }

    public final CacheDrawModifierNode getCacheDrawNode() {
        return this.cacheDrawNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult cacheDrawNode$lambda$0(final DeterminateCircularWavyProgressNode determinateCircularWavyProgressNode, CacheDrawScope cacheDrawScope) {
        Job offsetAnimationJob;
        Job job;
        float fFloatValue = determinateCircularWavyProgressNode.progress.invoke().floatValue();
        if (fFloatValue < 0.0f) {
            fFloatValue = 0.0f;
        }
        if (fFloatValue > 1.0f) {
            fFloatValue = 1.0f;
        }
        final float f = cacheDrawScope.mo754toPx0680j_4(determinateCircularWavyProgressNode.getGapSize());
        final float f2 = cacheDrawScope.mo754toPx0680j_4(determinateCircularWavyProgressNode.getWavelength());
        boolean z = Dp.m9686compareTo0680j_4(determinateCircularWavyProgressNode.getWaveSpeed(), Dp.m9687constructorimpl((float) 0)) > 0;
        float fFloatValue2 = determinateCircularWavyProgressNode.amplitude.invoke(Float.valueOf(fFloatValue)).floatValue();
        if (fFloatValue2 < 0.0f) {
            fFloatValue2 = 0.0f;
        }
        float f3 = fFloatValue2 <= 1.0f ? fFloatValue2 : 1.0f;
        if (determinateCircularWavyProgressNode.amplitudeAnimatable == null) {
            determinateCircularWavyProgressNode.amplitudeAnimatable = AnimatableKt.Animatable$default(f3, 0.0f, 2, null);
            determinateCircularWavyProgressNode.amplitudeState.setFloatValue(f3);
        }
        if (determinateCircularWavyProgressNode.getIsAttached()) {
            Animatable<Float, AnimationVector1D> animatable = determinateCircularWavyProgressNode.amplitudeAnimatable;
            Intrinsics.checkNotNull(animatable);
            if (animatable.getTargetValue().floatValue() != f3 && ((job = determinateCircularWavyProgressNode.amplitudeAnimationJob) == null || (job != null && job.isCompleted()))) {
                determinateCircularWavyProgressNode.amplitudeAnimationJob = BuildersKt__Builders_commonKt.launch$default(determinateCircularWavyProgressNode.getCoroutineScope(), null, null, new DeterminateCircularWavyProgressNode$cacheDrawNode$1$2(determinateCircularWavyProgressNode, f3, null), 3, null);
            }
        }
        determinateCircularWavyProgressNode.getCircularShapes().m4959updateCqks5Fs(cacheDrawScope.m6349getSizeNHjbRc(), f2, determinateCircularWavyProgressNode.getStroke().getWidth(), determinateCircularWavyProgressNode.amplitudeAnimationJob != null);
        if (determinateCircularWavyProgressNode.getVertexCountForCurrentAnimation() != determinateCircularWavyProgressNode.getCircularShapes().getCurrentVertexCount().getIntValue()) {
            determinateCircularWavyProgressNode.setVertexCountForCurrentAnimation(RangesKt.coerceAtLeast(determinateCircularWavyProgressNode.getCircularShapes().getCurrentVertexCount().getIntValue(), 5));
        }
        if (f3 > 0.0f && (determinateCircularWavyProgressNode.getOffsetAnimationJob() == null || ((offsetAnimationJob = determinateCircularWavyProgressNode.getOffsetAnimationJob()) != null && offsetAnimationJob.isCompleted()))) {
            determinateCircularWavyProgressNode.startOffsetAnimation();
        }
        final float f4 = fFloatValue;
        final boolean z2 = z;
        return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.material3.internal.DeterminateCircularWavyProgressNode$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DeterminateCircularWavyProgressNode.cacheDrawNode$lambda$0$1(this.f$0, z2, f4, f2, f, (ContentDrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cacheDrawNode$lambda$0$1(DeterminateCircularWavyProgressNode determinateCircularWavyProgressNode, boolean z, float f, float f2, float f3, ContentDrawScope contentDrawScope) {
        float floatValue = determinateCircularWavyProgressNode.amplitudeState.getFloatValue();
        CircularProgressDrawingCache progressDrawingCache = determinateCircularWavyProgressNode.getProgressDrawingCache();
        long j = contentDrawScope.mo7395getSizeNHjbRc();
        DeterminateCircularWavyProgressNode$cacheDrawNode$1$3$1 determinateCircularWavyProgressNode$cacheDrawNode$1$3$1 = new DeterminateCircularWavyProgressNode$cacheDrawNode$1$3$1(determinateCircularWavyProgressNode);
        DeterminateCircularWavyProgressNode$cacheDrawNode$1$3$2 determinateCircularWavyProgressNode$cacheDrawNode$1$3$2 = new DeterminateCircularWavyProgressNode$cacheDrawNode$1$3$2(determinateCircularWavyProgressNode);
        float floatValue2 = 0.0f;
        if (floatValue > 0.0f && z) {
            floatValue2 = determinateCircularWavyProgressNode.getWaveOffsetState().getFloatValue();
        }
        progressDrawingCache.m4958updatePathsbLEYqPY(j, determinateCircularWavyProgressNode$cacheDrawNode$1$3$1, determinateCircularWavyProgressNode$cacheDrawNode$1$3$2, z, 0.0f, f, floatValue, floatValue2, f2, f3, determinateCircularWavyProgressNode.getStroke(), determinateCircularWavyProgressNode.getTrackStroke());
        CircularWavyProgressModifiersKt.m4963drawCircularIndicatorRIQooxk(contentDrawScope, determinateCircularWavyProgressNode.getColor(), determinateCircularWavyProgressNode.getTrackColor(), determinateCircularWavyProgressNode.getStroke(), determinateCircularWavyProgressNode.getTrackStroke(), determinateCircularWavyProgressNode.getProgressDrawingCache());
        return Unit.INSTANCE;
    }
}
