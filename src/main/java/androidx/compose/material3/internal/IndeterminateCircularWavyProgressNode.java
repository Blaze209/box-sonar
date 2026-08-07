package androidx.compose.material3.internal;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.ui.draw.CacheDrawModifierNode;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.DrawModifierNodeKt;
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
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: CircularWavyProgressModifiers.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u001eH\u0014J\b\u0010!\u001a\u00020\u001eH\u0014J\b\u0010\"\u001a\u00020#H\u0014J\b\u0010$\u001a\u00020\u001eH\u0002R\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Landroidx/compose/material3/internal/IndeterminateCircularWavyProgressNode;", "Landroidx/compose/material3/internal/BaseCircularWavyProgressNode;", "colorParameter", "Landroidx/compose/ui/graphics/Color;", "trackColorParameter", "strokeParameter", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "trackStrokeParameter", "gapSizeParameter", "Landroidx/compose/ui/unit/Dp;", "amplitudeParameter", "", "wavelengthParameter", "waveSpeedParameter", "<init>", "(JJLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "globalRotationAnimatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "additionalRotationAnimatable", "progressSweepAnimatable", "indeterminateAnimationsJob", "Lkotlinx/coroutines/Job;", "value", "amplitude", "getAmplitude", "()F", "setAmplitude", "(F)V", "onAttach", "", "onDetach", "invalidateDraw", "invalidateDrawCache", "isDrawingWave", "", "startIndeterminateAnimations", "cacheDrawNode", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class IndeterminateCircularWavyProgressNode extends BaseCircularWavyProgressNode {
    private Animatable<Float, AnimationVector1D> additionalRotationAnimatable;
    private float amplitude;
    private final CacheDrawModifierNode cacheDrawNode;
    private Animatable<Float, AnimationVector1D> globalRotationAnimatable;
    private Job indeterminateAnimationsJob;
    private Animatable<Float, AnimationVector1D> progressSweepAnimatable;

    public /* synthetic */ IndeterminateCircularWavyProgressNode(long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, stroke, stroke2, f, f2, f3, f4);
    }

    private IndeterminateCircularWavyProgressNode(long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, float f3, float f4) {
        super(j, j2, stroke, stroke2, f, f3, f4, null);
        this.amplitude = RangesKt.coerceIn(f2, 0.0f, 1.0f);
        this.cacheDrawNode = (CacheDrawModifierNode) delegate(DrawModifierKt.CacheDrawModifierNode(new Function1() { // from class: androidx.compose.material3.internal.IndeterminateCircularWavyProgressNode$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IndeterminateCircularWavyProgressNode.cacheDrawNode$lambda$0(this.f$0, (CacheDrawScope) obj);
            }
        }));
    }

    public final float getAmplitude() {
        return this.amplitude;
    }

    public final void setAmplitude(float f) {
        float fCoerceIn = RangesKt.coerceIn(f, 0.0f, 1.0f);
        float f2 = this.amplitude;
        if (f2 == fCoerceIn) {
            return;
        }
        this.amplitude = fCoerceIn;
        if (fCoerceIn > 0.0f && f2 == 0.0f) {
            startOffsetAnimation();
        } else if (fCoerceIn == 0.0f) {
            stopOffsetAnimation();
        }
        this.cacheDrawNode.invalidateDrawCache();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        startIndeterminateAnimations();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.globalRotationAnimatable = null;
        this.additionalRotationAnimatable = null;
        this.progressSweepAnimatable = null;
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
        return this.amplitude > 0.0f;
    }

    private final void startIndeterminateAnimations() {
        Job job = this.indeterminateAnimationsJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if (getIsAttached() && CoroutineScopeKt.isActive(getCoroutineScope())) {
            Animatable<Float, AnimationVector1D> animatableAnimatable$default = this.globalRotationAnimatable;
            if (animatableAnimatable$default == null) {
                animatableAnimatable$default = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
            }
            this.globalRotationAnimatable = animatableAnimatable$default;
            Animatable<Float, AnimationVector1D> animatableAnimatable$default2 = this.additionalRotationAnimatable;
            if (animatableAnimatable$default2 == null) {
                animatableAnimatable$default2 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
            }
            this.additionalRotationAnimatable = animatableAnimatable$default2;
            Animatable<Float, AnimationVector1D> animatableAnimatable$default3 = this.progressSweepAnimatable;
            if (animatableAnimatable$default3 == null) {
                animatableAnimatable$default3 = AnimatableKt.Animatable$default(0.1f, 0.0f, 2, null);
            }
            this.progressSweepAnimatable = animatableAnimatable$default3;
            this.indeterminateAnimationsJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AnonymousClass1(null), 3, null);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.internal.IndeterminateCircularWavyProgressNode$startIndeterminateAnimations$1, reason: invalid class name */
    /* JADX INFO: compiled from: CircularWavyProgressModifiers.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.internal.IndeterminateCircularWavyProgressNode$startIndeterminateAnimations$1", f = "CircularWavyProgressModifiers.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = IndeterminateCircularWavyProgressNode.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C00711(IndeterminateCircularWavyProgressNode.this, null), 3, null);
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass2(IndeterminateCircularWavyProgressNode.this, null), 3, null);
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass3(IndeterminateCircularWavyProgressNode.this, null), 3, null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: renamed from: androidx.compose.material3.internal.IndeterminateCircularWavyProgressNode$startIndeterminateAnimations$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: CircularWavyProgressModifiers.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.material3.internal.IndeterminateCircularWavyProgressNode$startIndeterminateAnimations$1$1", f = "CircularWavyProgressModifiers.kt", i = {}, l = {756}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C00711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ IndeterminateCircularWavyProgressNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00711(IndeterminateCircularWavyProgressNode indeterminateCircularWavyProgressNode, Continuation<? super C00711> continuation) {
                super(2, continuation);
                this.this$0 = indeterminateCircularWavyProgressNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00711(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00711) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable = this.this$0.globalRotationAnimatable;
                    if (animatable == null) {
                        return Unit.INSTANCE;
                    }
                    Float fBoxFloat = Boxing.boxFloat(((Number) animatable.getValue()).floatValue() + 1080.0f);
                    InfiniteRepeatableSpec<Float> circularIndeterminateGlobalRotationAnimationSpec = ProgressIndicatorKt.getCircularIndeterminateGlobalRotationAnimationSpec();
                    final IndeterminateCircularWavyProgressNode indeterminateCircularWavyProgressNode = this.this$0;
                    this.label = 1;
                    if (Animatable.animateTo$default(animatable, fBoxFloat, circularIndeterminateGlobalRotationAnimationSpec, null, new Function1() { // from class: androidx.compose.material3.internal.IndeterminateCircularWavyProgressNode$startIndeterminateAnimations$1$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return IndeterminateCircularWavyProgressNode.AnonymousClass1.C00711.invokeSuspend$lambda$0(indeterminateCircularWavyProgressNode, (Animatable) obj2);
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
            public static final Unit invokeSuspend$lambda$0(IndeterminateCircularWavyProgressNode indeterminateCircularWavyProgressNode, Animatable animatable) {
                DrawModifierNodeKt.invalidateDraw(indeterminateCircularWavyProgressNode.cacheDrawNode);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: androidx.compose.material3.internal.IndeterminateCircularWavyProgressNode$startIndeterminateAnimations$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: CircularWavyProgressModifiers.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.material3.internal.IndeterminateCircularWavyProgressNode$startIndeterminateAnimations$1$2", f = "CircularWavyProgressModifiers.kt", i = {}, l = {767}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ IndeterminateCircularWavyProgressNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(IndeterminateCircularWavyProgressNode indeterminateCircularWavyProgressNode, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = indeterminateCircularWavyProgressNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable = this.this$0.additionalRotationAnimatable;
                    if (animatable == null) {
                        return Unit.INSTANCE;
                    }
                    Float fBoxFloat = Boxing.boxFloat(((Number) animatable.getValue()).floatValue() + 360.0f);
                    InfiniteRepeatableSpec<Float> circularIndeterminateRotationAnimationSpec = ProgressIndicatorKt.getCircularIndeterminateRotationAnimationSpec();
                    final IndeterminateCircularWavyProgressNode indeterminateCircularWavyProgressNode = this.this$0;
                    this.label = 1;
                    if (Animatable.animateTo$default(animatable, fBoxFloat, circularIndeterminateRotationAnimationSpec, null, new Function1() { // from class: androidx.compose.material3.internal.IndeterminateCircularWavyProgressNode$startIndeterminateAnimations$1$2$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return IndeterminateCircularWavyProgressNode.AnonymousClass1.AnonymousClass2.invokeSuspend$lambda$0(indeterminateCircularWavyProgressNode, (Animatable) obj2);
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
            public static final Unit invokeSuspend$lambda$0(IndeterminateCircularWavyProgressNode indeterminateCircularWavyProgressNode, Animatable animatable) {
                DrawModifierNodeKt.invalidateDraw(indeterminateCircularWavyProgressNode.cacheDrawNode);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: androidx.compose.material3.internal.IndeterminateCircularWavyProgressNode$startIndeterminateAnimations$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: CircularWavyProgressModifiers.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.material3.internal.IndeterminateCircularWavyProgressNode$startIndeterminateAnimations$1$3", f = "CircularWavyProgressModifiers.kt", i = {}, l = {777}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ IndeterminateCircularWavyProgressNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(IndeterminateCircularWavyProgressNode indeterminateCircularWavyProgressNode, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.this$0 = indeterminateCircularWavyProgressNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable = this.this$0.progressSweepAnimatable;
                    if (animatable == null) {
                        return Unit.INSTANCE;
                    }
                    Float fBoxFloat = Boxing.boxFloat(((Number) animatable.getValue()).floatValue() < 0.485f ? 0.87f : 0.1f);
                    InfiniteRepeatableSpec<Float> circularIndeterminateProgressAnimationSpec = ProgressIndicatorKt.getCircularIndeterminateProgressAnimationSpec();
                    final IndeterminateCircularWavyProgressNode indeterminateCircularWavyProgressNode = this.this$0;
                    this.label = 1;
                    if (Animatable.animateTo$default(animatable, fBoxFloat, circularIndeterminateProgressAnimationSpec, null, new Function1() { // from class: androidx.compose.material3.internal.IndeterminateCircularWavyProgressNode$startIndeterminateAnimations$1$3$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return IndeterminateCircularWavyProgressNode.AnonymousClass1.AnonymousClass3.invokeSuspend$lambda$0(indeterminateCircularWavyProgressNode, (Animatable) obj2);
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
            public static final Unit invokeSuspend$lambda$0(IndeterminateCircularWavyProgressNode indeterminateCircularWavyProgressNode, Animatable animatable) {
                DrawModifierNodeKt.invalidateDraw(indeterminateCircularWavyProgressNode.cacheDrawNode);
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult cacheDrawNode$lambda$0(final IndeterminateCircularWavyProgressNode indeterminateCircularWavyProgressNode, CacheDrawScope cacheDrawScope) {
        boolean z;
        float f;
        Job offsetAnimationJob;
        final float f2 = cacheDrawScope.mo754toPx0680j_4(indeterminateCircularWavyProgressNode.getWavelength());
        final float f3 = cacheDrawScope.mo754toPx0680j_4(indeterminateCircularWavyProgressNode.getGapSize());
        final boolean z2 = Dp.m9686compareTo0680j_4(indeterminateCircularWavyProgressNode.getWaveSpeed(), Dp.m9687constructorimpl((float) 0)) > 0 && indeterminateCircularWavyProgressNode.amplitude > 0.0f;
        CircularShapes circularShapes = indeterminateCircularWavyProgressNode.getCircularShapes();
        long jM6349getSizeNHjbRc = cacheDrawScope.m6349getSizeNHjbRc();
        float width = indeterminateCircularWavyProgressNode.getStroke().getWidth();
        float f4 = indeterminateCircularWavyProgressNode.amplitude;
        if (f4 <= 0.0f || f4 >= 1.0f) {
            z = false;
            f = width;
        } else {
            f = width;
            z = true;
        }
        circularShapes.m4959updateCqks5Fs(jM6349getSizeNHjbRc, f2, f, z);
        if (indeterminateCircularWavyProgressNode.getVertexCountForCurrentAnimation() != indeterminateCircularWavyProgressNode.getCircularShapes().getCurrentVertexCount().getIntValue()) {
            indeterminateCircularWavyProgressNode.setVertexCountForCurrentAnimation(RangesKt.coerceAtLeast(indeterminateCircularWavyProgressNode.getCircularShapes().getCurrentVertexCount().getIntValue(), 5));
        }
        if (indeterminateCircularWavyProgressNode.amplitude > 0.0f && (indeterminateCircularWavyProgressNode.getOffsetAnimationJob() == null || ((offsetAnimationJob = indeterminateCircularWavyProgressNode.getOffsetAnimationJob()) != null && offsetAnimationJob.isCompleted()))) {
            indeterminateCircularWavyProgressNode.startOffsetAnimation();
        }
        return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.material3.internal.IndeterminateCircularWavyProgressNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IndeterminateCircularWavyProgressNode.cacheDrawNode$lambda$0$0(this.f$0, z2, f2, f3, (ContentDrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cacheDrawNode$lambda$0$0(IndeterminateCircularWavyProgressNode indeterminateCircularWavyProgressNode, boolean z, float f, float f2, ContentDrawScope contentDrawScope) {
        Animatable<Float, AnimationVector1D> animatable = indeterminateCircularWavyProgressNode.globalRotationAnimatable;
        float fFloatValue = animatable != null ? animatable.getValue().floatValue() : 0.0f;
        Animatable<Float, AnimationVector1D> animatable2 = indeterminateCircularWavyProgressNode.additionalRotationAnimatable;
        float fFloatValue2 = animatable2 != null ? animatable2.getValue().floatValue() : 0.0f;
        Animatable<Float, AnimationVector1D> animatable3 = indeterminateCircularWavyProgressNode.progressSweepAnimatable;
        indeterminateCircularWavyProgressNode.getProgressDrawingCache().m4958updatePathsbLEYqPY(contentDrawScope.mo7395getSizeNHjbRc(), new IndeterminateCircularWavyProgressNode$cacheDrawNode$1$1$1(indeterminateCircularWavyProgressNode), new IndeterminateCircularWavyProgressNode$cacheDrawNode$1$1$2(indeterminateCircularWavyProgressNode), z, 0.0f, animatable3 != null ? animatable3.getValue().floatValue() : 0.1f, indeterminateCircularWavyProgressNode.amplitude, z ? indeterminateCircularWavyProgressNode.getWaveOffsetState().getFloatValue() : 0.0f, f, f2, indeterminateCircularWavyProgressNode.getStroke(), indeterminateCircularWavyProgressNode.getTrackStroke());
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        DrawContext drawContext = contentDrawScope2.getDrawContext();
        long jMo7316getSizeNHjbRc = drawContext.mo7316getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            DrawTransform.m7453rotateUv8p0NA$default(drawContext.getTransform(), fFloatValue + fFloatValue2 + 90.0f, 0L, 2, null);
            CircularWavyProgressModifiersKt.m4963drawCircularIndicatorRIQooxk(contentDrawScope2, indeterminateCircularWavyProgressNode.getColor(), indeterminateCircularWavyProgressNode.getTrackColor(), indeterminateCircularWavyProgressNode.getStroke(), indeterminateCircularWavyProgressNode.getTrackStroke(), indeterminateCircularWavyProgressNode.getProgressDrawingCache());
            return Unit.INSTANCE;
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo7317setSizeuvyYCjk(jMo7316getSizeNHjbRc);
        }
    }
}
