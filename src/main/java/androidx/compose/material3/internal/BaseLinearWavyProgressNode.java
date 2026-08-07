package androidx.compose.material3.internal;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.material3.WavyProgressIndicatorKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.unit.Dp;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: LinearWavyProgressModifiers.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0003\b\"\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020-H\u0016J\b\u0010F\u001a\u00020-H\u0004J\u0010\u0010G\u001a\u00020-2\u0006\u0010H\u001a\u000207H\u0004J\b\u0010I\u001a\u00020JH$J\b\u0010K\u001a\u00020-H$J\b\u0010L\u001a\u00020-H$R&\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R&\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R$\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR&\u0010 \u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R&\u0010&\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R&\u0010)\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b*\u0010\"\"\u0004\b+\u0010$R\u0014\u0010/\u001a\u000200X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R(\u00105\u001a\u0010\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u000208\u0018\u000106X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010=\u001a\u0004\u0018\u000104X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0014\u0010B\u001a\u00020CX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010E¨\u0006M"}, d2 = {"Landroidx/compose/material3/internal/BaseLinearWavyProgressNode;", "Landroidx/compose/ui/node/DelegatingNode;", "colorParameter", "Landroidx/compose/ui/graphics/Color;", "trackColorParameter", "strokeParameter", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "trackStrokeParameter", "gapSizeParameter", "Landroidx/compose/ui/unit/Dp;", "wavelengthParameter", "waveSpeedParameter", "<init>", "(JJLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;FFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "value", "color", "getColor-0d7_KjU", "()J", "setColor-8_81llA", "(J)V", "J", "trackColor", "getTrackColor-0d7_KjU", "setTrackColor-8_81llA", "stroke", "getStroke", "()Landroidx/compose/ui/graphics/drawscope/Stroke;", "setStroke", "(Landroidx/compose/ui/graphics/drawscope/Stroke;)V", "trackStroke", "getTrackStroke", "setTrackStroke", "gapSize", "getGapSize-D9Ej5fM", "()F", "setGapSize-0680j_4", "(F)V", "F", "wavelength", "getWavelength-D9Ej5fM", "setWavelength-0680j_4", "waveSpeed", "getWaveSpeed-D9Ej5fM", "setWaveSpeed-0680j_4", "onAttach", "", "onDetach", "waveOffset", "Landroidx/compose/runtime/MutableFloatState;", "getWaveOffset", "()Landroidx/compose/runtime/MutableFloatState;", "offsetAnimationJob", "Lkotlinx/coroutines/Job;", "amplitudeAnimatable", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "getAmplitudeAnimatable", "()Landroidx/compose/animation/core/Animatable;", "setAmplitudeAnimatable", "(Landroidx/compose/animation/core/Animatable;)V", "amplitudeAnimationJob", "getAmplitudeAnimationJob", "()Lkotlinx/coroutines/Job;", "setAmplitudeAnimationJob", "(Lkotlinx/coroutines/Job;)V", "progressDrawingCache", "Landroidx/compose/material3/internal/LinearProgressDrawingCache;", "getProgressDrawingCache", "()Landroidx/compose/material3/internal/LinearProgressDrawingCache;", "updateOffsetAnimation", "updateAmplitudeAnimation", "targetAmplitudePx", "getProgressFractions", "", "invalidateDraw", "invalidateDrawCache", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
abstract class BaseLinearWavyProgressNode extends DelegatingNode {
    private Animatable<Float, AnimationVector1D> amplitudeAnimatable;
    private Job amplitudeAnimationJob;
    private long color;
    private float gapSize;
    private Job offsetAnimationJob;
    private final LinearProgressDrawingCache progressDrawingCache;
    private Stroke stroke;
    private long trackColor;
    private Stroke trackStroke;
    private final MutableFloatState waveOffset;
    private float waveSpeed;
    private float wavelength;

    public /* synthetic */ BaseLinearWavyProgressNode(long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, float f3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, stroke, stroke2, f, f2, f3);
    }

    protected abstract float[] getProgressFractions();

    protected abstract void invalidateDraw();

    protected abstract void invalidateDrawCache();

    private BaseLinearWavyProgressNode(long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, float f3) {
        this.color = j;
        this.trackColor = j2;
        this.stroke = stroke;
        this.trackStroke = stroke2;
        this.gapSize = f;
        this.wavelength = f2;
        this.waveSpeed = f3;
        this.waveOffset = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.progressDrawingCache = new LinearProgressDrawingCache();
    }

    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: setColor-8_81llA, reason: not valid java name */
    public final void m4936setColor8_81llA(long j) {
        if (Color.m6815equalsimpl0(this.color, j)) {
            return;
        }
        this.color = j;
        invalidateDraw();
    }

    /* JADX INFO: renamed from: getTrackColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getTrackColor() {
        return this.trackColor;
    }

    /* JADX INFO: renamed from: setTrackColor-8_81llA, reason: not valid java name */
    public final void m4938setTrackColor8_81llA(long j) {
        if (Color.m6815equalsimpl0(this.trackColor, j)) {
            return;
        }
        this.trackColor = j;
        invalidateDraw();
    }

    public final Stroke getStroke() {
        return this.stroke;
    }

    public final void setStroke(Stroke stroke) {
        if (Intrinsics.areEqual(this.stroke, stroke)) {
            return;
        }
        this.stroke = stroke;
        invalidateDrawCache();
    }

    public final Stroke getTrackStroke() {
        return this.trackStroke;
    }

    public final void setTrackStroke(Stroke stroke) {
        if (Intrinsics.areEqual(this.trackStroke, stroke)) {
            return;
        }
        this.trackStroke = stroke;
        invalidateDrawCache();
    }

    /* JADX INFO: renamed from: getGapSize-D9Ej5fM, reason: not valid java name and from getter */
    public final float getGapSize() {
        return this.gapSize;
    }

    /* JADX INFO: renamed from: setGapSize-0680j_4, reason: not valid java name */
    public final void m4937setGapSize0680j_4(float f) {
        if (Dp.m9692equalsimpl0(this.gapSize, f)) {
            return;
        }
        this.gapSize = f;
        invalidateDrawCache();
    }

    /* JADX INFO: renamed from: getWavelength-D9Ej5fM, reason: not valid java name and from getter */
    public final float getWavelength() {
        return this.wavelength;
    }

    /* JADX INFO: renamed from: setWavelength-0680j_4, reason: not valid java name */
    public final void m4940setWavelength0680j_4(float f) {
        if (Dp.m9692equalsimpl0(this.wavelength, f)) {
            return;
        }
        this.wavelength = f;
        updateOffsetAnimation();
        invalidateDrawCache();
    }

    /* JADX INFO: renamed from: getWaveSpeed-D9Ej5fM, reason: not valid java name and from getter */
    public final float getWaveSpeed() {
        return this.waveSpeed;
    }

    /* JADX INFO: renamed from: setWaveSpeed-0680j_4, reason: not valid java name */
    public final void m4939setWaveSpeed0680j_4(float f) {
        if (Dp.m9692equalsimpl0(this.waveSpeed, f)) {
            return;
        }
        this.waveSpeed = f;
        updateOffsetAnimation();
        invalidateDrawCache();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        updateOffsetAnimation();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.amplitudeAnimatable = null;
    }

    protected final MutableFloatState getWaveOffset() {
        return this.waveOffset;
    }

    protected final Animatable<Float, AnimationVector1D> getAmplitudeAnimatable() {
        return this.amplitudeAnimatable;
    }

    protected final void setAmplitudeAnimatable(Animatable<Float, AnimationVector1D> animatable) {
        this.amplitudeAnimatable = animatable;
    }

    protected final Job getAmplitudeAnimationJob() {
        return this.amplitudeAnimationJob;
    }

    protected final void setAmplitudeAnimationJob(Job job) {
        this.amplitudeAnimationJob = job;
    }

    protected final LinearProgressDrawingCache getProgressDrawingCache() {
        return this.progressDrawingCache;
    }

    protected final void updateOffsetAnimation() {
        Job job = this.offsetAnimationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.offsetAnimationJob = null;
        if (getIsAttached()) {
            float f = 0;
            if (Dp.m9686compareTo0680j_4(this.waveSpeed, Dp.m9687constructorimpl(f)) > 0 && Dp.m9686compareTo0680j_4(this.wavelength, Dp.m9687constructorimpl(f)) > 0) {
                this.offsetAnimationJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new C07321(RangesKt.coerceAtLeast(Math.round((this.wavelength / this.waveSpeed) * 1000), 50), null), 3, null);
            } else {
                this.waveOffset.setFloatValue(0.0f);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.internal.BaseLinearWavyProgressNode$updateOffsetAnimation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LinearWavyProgressModifiers.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.internal.BaseLinearWavyProgressNode$updateOffsetAnimation$1", f = "LinearWavyProgressModifiers.kt", i = {}, l = {313}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C07321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $durationMillis;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07321(int i, Continuation<? super C07321> continuation) {
            super(2, continuation);
            this.$durationMillis = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BaseLinearWavyProgressNode.this.new C07321(this.$durationMillis, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07321) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                float floatValue = BaseLinearWavyProgressNode.this.getWaveOffset().getFloatValue();
                Animatable animatableAnimatable$default = AnimatableKt.Animatable$default(floatValue, 0.0f, 2, null);
                float f = 1.0f + floatValue;
                animatableAnimatable$default.updateBounds(Boxing.boxFloat(floatValue), Boxing.boxFloat(f));
                Float fBoxFloat = Boxing.boxFloat(f);
                InfiniteRepeatableSpec infiniteRepeatableSpecM475infiniteRepeatable9IiC70o$default = AnimationSpecKt.m475infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(this.$durationMillis, 0, EasingKt.getLinearEasing(), 2, null), RepeatMode.Restart, 0L, 4, null);
                final BaseLinearWavyProgressNode baseLinearWavyProgressNode = BaseLinearWavyProgressNode.this;
                this.label = 1;
                if (Animatable.animateTo$default(animatableAnimatable$default, fBoxFloat, infiniteRepeatableSpecM475infiniteRepeatable9IiC70o$default, null, new Function1() { // from class: androidx.compose.material3.internal.BaseLinearWavyProgressNode$updateOffsetAnimation$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return BaseLinearWavyProgressNode.C07321.invokeSuspend$lambda$0(baseLinearWavyProgressNode, (Animatable) obj2);
                    }
                }, this, 4, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(BaseLinearWavyProgressNode baseLinearWavyProgressNode, Animatable animatable) {
            baseLinearWavyProgressNode.getWaveOffset().setFloatValue(((Number) animatable.getValue()).floatValue() % 1.0f);
            return Unit.INSTANCE;
        }
    }

    protected final void updateAmplitudeAnimation(float targetAmplitudePx) {
        Animatable<Float, AnimationVector1D> animatableAnimatable$default = this.amplitudeAnimatable;
        if (animatableAnimatable$default == null) {
            animatableAnimatable$default = AnimatableKt.Animatable$default(targetAmplitudePx, 0.0f, 2, null);
            this.amplitudeAnimatable = animatableAnimatable$default;
        }
        if (!getIsAttached() || animatableAnimatable$default.getTargetValue().floatValue() == targetAmplitudePx) {
            return;
        }
        Job job = this.amplitudeAnimationJob;
        if (job == null || (job != null && job.isCompleted())) {
            this.amplitudeAnimationJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AnonymousClass1(animatableAnimatable$default, targetAmplitudePx, null), 3, null);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.internal.BaseLinearWavyProgressNode$updateAmplitudeAnimation$1, reason: invalid class name */
    /* JADX INFO: compiled from: LinearWavyProgressModifiers.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.internal.BaseLinearWavyProgressNode$updateAmplitudeAnimation$1", f = "LinearWavyProgressModifiers.kt", i = {}, l = {347}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Animatable<Float, AnimationVector1D> $currentAmplitudeAnimatable;
        final /* synthetic */ float $targetAmplitudePx;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Animatable<Float, AnimationVector1D> animatable, float f, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$currentAmplitudeAnimatable = animatable;
            this.$targetAmplitudePx = f;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$currentAmplitudeAnimatable, this.$targetAmplitudePx, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AnimationSpec<Float> decreasingAmplitudeAnimationSpec;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Animatable<Float, AnimationVector1D> animatable = this.$currentAmplitudeAnimatable;
                Float fBoxFloat = Boxing.boxFloat(this.$targetAmplitudePx);
                if (this.$currentAmplitudeAnimatable.getValue().floatValue() < this.$targetAmplitudePx) {
                    decreasingAmplitudeAnimationSpec = WavyProgressIndicatorKt.getIncreasingAmplitudeAnimationSpec();
                } else {
                    decreasingAmplitudeAnimationSpec = WavyProgressIndicatorKt.getDecreasingAmplitudeAnimationSpec();
                }
                this.label = 1;
                if (Animatable.animateTo$default(animatable, fBoxFloat, decreasingAmplitudeAnimationSpec, null, null, this, 12, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }
}
