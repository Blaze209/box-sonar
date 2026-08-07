package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import external.sdk.pendo.io.mozilla.javascript.Token;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: TransformableState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aS\u0010\u0000\u001a\u00020\u00012K\u0010\u0002\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0003\u001aZ\u0010\f\u001a\u00020\u00012K\u0010\u0002\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0003H\u0007¢\u0006\u0002\u0010\r\u001a*\u0010\u000e\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00042\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0086@¢\u0006\u0002\u0010\u0012\u001a*\u0010\u0013\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0086@¢\u0006\u0002\u0010\u0012\u001a,\u0010\u0015\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\b2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0086@¢\u0006\u0004\b\u0017\u0010\u0018\u001a\\\u0010\u0019\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00042\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0086@¢\u0006\u0004\b\u001f\u0010 \u001a\u001a\u0010#\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010$\u001a\u001a\u0010%\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010$\u001a\u001c\u0010&\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\bH\u0086@¢\u0006\u0004\b'\u0010(\u001a\u001c\u0010)\u001a\u00020\u000b*\u00020\u00012\b\b\u0002\u0010*\u001a\u00020+H\u0086@¢\u0006\u0002\u0010,\"\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"TransformableState", "Landroidx/compose/foundation/gestures/TransformableState;", "onTransformation", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "zoomChange", "Landroidx/compose/ui/geometry/Offset;", "panChange", "rotationChange", "", "rememberTransformableState", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/TransformableState;", "animateZoomBy", "zoomFactor", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/foundation/gestures/TransformableState;FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateRotateBy", "degrees", "animatePanBy", "offset", "animatePanBy-ubNVwUQ", "(Landroidx/compose/foundation/gestures/TransformableState;JLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateBy", "panOffset", "rotationDegrees", "zoomAnimationSpec", "panAnimationSpec", "rotationAnimationSpec", "animateBy-Su4bsnU", "(Landroidx/compose/foundation/gestures/TransformableState;FJFLandroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ZeroAnimationVelocity", "Landroidx/compose/foundation/gestures/AnimationData;", "zoomBy", "(Landroidx/compose/foundation/gestures/TransformableState;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rotateBy", "panBy", "panBy-d-4ec7I", "(Landroidx/compose/foundation/gestures/TransformableState;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopTransformation", "terminationPriority", "Landroidx/compose/foundation/MutatePriority;", "(Landroidx/compose/foundation/gestures/TransformableState;Landroidx/compose/foundation/MutatePriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TransformableStateKt {
    private static final AnimationData ZeroAnimationVelocity = new AnimationData(0.0f, Offset.INSTANCE.m6585getZeroF1C5BW0(), 0.0f, null);

    public static final TransformableState TransformableState(Function3<? super Float, ? super Offset, ? super Float, Unit> function3) {
        return new DefaultTransformableState(function3);
    }

    public static final TransformableState rememberTransformableState(Function3<? super Float, ? super Offset, ? super Float, Unit> function3, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1681419281, "C(rememberTransformableState)N(onTransformation)123@5674L38,124@5724L80:TransformableState.kt#8bwon0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1681419281, i, -1, "androidx.compose.foundation.gestures.rememberTransformableState (TransformableState.kt:122)");
        }
        final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function3, composer, i & 14);
        ComposerKt.sourceInformationMarkerStart(composer, 936232865, "CC(remember):TransformableState.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = TransformableState(new Function3() { // from class: androidx.compose.foundation.gestures.TransformableStateKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TransformableStateKt.rememberTransformableState$lambda$0$0(stateRememberUpdatedState, ((Float) obj).floatValue(), (Offset) obj2, ((Float) obj3).floatValue());
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        TransformableState transformableState = (TransformableState) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return transformableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rememberTransformableState$lambda$0$0(State state, float f, Offset offset, float f2) {
        ((Function3) state.getValue()).invoke(Float.valueOf(f), offset, Float.valueOf(f2));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateZoomBy$default(TransformableState transformableState, float f, AnimationSpec animationSpec, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, null, 5, null);
        }
        return animateZoomBy(transformableState, f, animationSpec, continuation);
    }

    public static final Object animateZoomBy(TransformableState transformableState, float f, AnimationSpec<Float> animationSpec, Continuation<? super Unit> continuation) {
        if (!(f > 0.0f)) {
            InlineClassHelperKt.throwIllegalArgumentException("zoom value should be greater than 0");
        }
        Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.element = 1.0f;
        Object objTransform$default = TransformableState.transform$default(transformableState, null, new AnonymousClass3(floatRef, f, animationSpec, null), continuation, 1, null);
        return objTransform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objTransform$default : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$animateZoomBy$3, reason: invalid class name */
    /* JADX INFO: compiled from: TransformableState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/TransformScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableStateKt$animateZoomBy$3", f = "TransformableState.kt", i = {}, l = {Token.LOCAL_BLOCK}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ Ref.FloatRef $previous;
        final /* synthetic */ float $zoomFactor;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Ref.FloatRef floatRef, float f, AnimationSpec<Float> animationSpec, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$previous = floatRef;
            this.$zoomFactor = f;
            this.$animationSpec = animationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$previous, this.$zoomFactor, this.$animationSpec, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(TransformScope transformScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(transformScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final TransformScope transformScope = (TransformScope) this.L$0;
                AnimationState animationStateAnimationState$default = AnimationStateKt.AnimationState$default(this.$previous.element, 0.0f, 0L, 0L, false, 30, null);
                Float fBoxFloat = Boxing.boxFloat(this.$zoomFactor);
                AnimationSpec<Float> animationSpec = this.$animationSpec;
                final Ref.FloatRef floatRef = this.$previous;
                this.label = 1;
                if (SuspendAnimationKt.animateTo$default(animationStateAnimationState$default, fBoxFloat, animationSpec, false, new Function1() { // from class: androidx.compose.foundation.gestures.TransformableStateKt$animateZoomBy$3$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TransformableStateKt.AnonymousClass3.invokeSuspend$lambda$0(floatRef, transformScope, (AnimationScope) obj2);
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
        public static final Unit invokeSuspend$lambda$0(Ref.FloatRef floatRef, TransformScope transformScope, AnimationScope animationScope) {
            TransformScope.m985transformByd4ec7I$default(transformScope, floatRef.element == 0.0f ? 1.0f : ((Number) animationScope.getValue()).floatValue() / floatRef.element, 0L, 0.0f, 6, null);
            floatRef.element = ((Number) animationScope.getValue()).floatValue();
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ Object animateRotateBy$default(TransformableState transformableState, float f, AnimationSpec animationSpec, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, null, 5, null);
        }
        return animateRotateBy(transformableState, f, animationSpec, continuation);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$animateRotateBy$2, reason: invalid class name */
    /* JADX INFO: compiled from: TransformableState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/TransformScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableStateKt$animateRotateBy$2", f = "TransformableState.kt", i = {}, l = {Token.COMMENT}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ float $degrees;
        final /* synthetic */ Ref.FloatRef $previous;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Ref.FloatRef floatRef, float f, AnimationSpec<Float> animationSpec, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$previous = floatRef;
            this.$degrees = f;
            this.$animationSpec = animationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$previous, this.$degrees, this.$animationSpec, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(TransformScope transformScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(transformScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final TransformScope transformScope = (TransformScope) this.L$0;
                AnimationState animationStateAnimationState$default = AnimationStateKt.AnimationState$default(this.$previous.element, 0.0f, 0L, 0L, false, 30, null);
                Float fBoxFloat = Boxing.boxFloat(this.$degrees);
                AnimationSpec<Float> animationSpec = this.$animationSpec;
                final Ref.FloatRef floatRef = this.$previous;
                this.label = 1;
                if (SuspendAnimationKt.animateTo$default(animationStateAnimationState$default, fBoxFloat, animationSpec, false, new Function1() { // from class: androidx.compose.foundation.gestures.TransformableStateKt$animateRotateBy$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TransformableStateKt.AnonymousClass2.invokeSuspend$lambda$0(floatRef, transformScope, (AnimationScope) obj2);
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
        public static final Unit invokeSuspend$lambda$0(Ref.FloatRef floatRef, TransformScope transformScope, AnimationScope animationScope) {
            TransformScope.m985transformByd4ec7I$default(transformScope, 0.0f, 0L, ((Number) animationScope.getValue()).floatValue() - floatRef.element, 3, null);
            floatRef.element = ((Number) animationScope.getValue()).floatValue();
            return Unit.INSTANCE;
        }
    }

    public static final Object animateRotateBy(TransformableState transformableState, float f, AnimationSpec<Float> animationSpec, Continuation<? super Unit> continuation) {
        Object objTransform$default = TransformableState.transform$default(transformableState, null, new AnonymousClass2(new Ref.FloatRef(), f, animationSpec, null), continuation, 1, null);
        return objTransform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objTransform$default : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: animatePanBy-ubNVwUQ$default, reason: not valid java name */
    public static /* synthetic */ Object m992animatePanByubNVwUQ$default(TransformableState transformableState, long j, AnimationSpec animationSpec, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, null, 5, null);
        }
        return m991animatePanByubNVwUQ(transformableState, j, animationSpec, continuation);
    }

    /* JADX INFO: renamed from: animatePanBy-ubNVwUQ, reason: not valid java name */
    public static final Object m991animatePanByubNVwUQ(TransformableState transformableState, long j, AnimationSpec<Offset> animationSpec, Continuation<? super Unit> continuation) {
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = Offset.INSTANCE.m6585getZeroF1C5BW0();
        Object objTransform$default = TransformableState.transform$default(transformableState, null, new TransformableStateKt$animatePanBy$2(longRef, j, animationSpec, null), continuation, 1, null);
        return objTransform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objTransform$default : Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, androidx.compose.foundation.gestures.AnimationData] */
    /* JADX INFO: renamed from: animateBy-Su4bsnU, reason: not valid java name */
    public static final Object m989animateBySu4bsnU(TransformableState transformableState, float f, long j, float f2, AnimationSpec<Float> animationSpec, AnimationSpec<Offset> animationSpec2, AnimationSpec<Float> animationSpec3, Continuation<? super Unit> continuation) {
        if (!(f > 0.0f)) {
            InlineClassHelperKt.throwIllegalArgumentException("zoom value should be greater than 0");
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new AnimationData(1.0f, Offset.INSTANCE.m6585getZeroF1C5BW0(), 0.0f, null);
        Object objTransform$default = TransformableState.transform$default(transformableState, null, new TransformableStateKt$animateBy$3(objectRef, new AnimationData(f, j, f2, null), new DelegatingAnimationSpec(animationSpec, animationSpec2, animationSpec3), null), continuation, 1, null);
        return objTransform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objTransform$default : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$zoomBy$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TransformableState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/TransformScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableStateKt$zoomBy$2", f = "TransformableState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C06382 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $zoomFactor;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06382(float f, Continuation<? super C06382> continuation) {
            super(2, continuation);
            this.$zoomFactor = f;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06382 c06382 = new C06382(this.$zoomFactor, continuation);
            c06382.L$0 = obj;
            return c06382;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(TransformScope transformScope, Continuation<? super Unit> continuation) {
            return ((C06382) create(transformScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ((TransformScope) this.L$0).mo806transformByd4ec7I(this.$zoomFactor, Offset.INSTANCE.m6585getZeroF1C5BW0(), 0.0f);
            return Unit.INSTANCE;
        }
    }

    public static final Object zoomBy(TransformableState transformableState, float f, Continuation<? super Unit> continuation) {
        Object objTransform$default = TransformableState.transform$default(transformableState, null, new C06382(f, null), continuation, 1, null);
        return objTransform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objTransform$default : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$rotateBy$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TransformableState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/TransformScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableStateKt$rotateBy$2", f = "TransformableState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C06362 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $degrees;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06362(float f, Continuation<? super C06362> continuation) {
            super(2, continuation);
            this.$degrees = f;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06362 c06362 = new C06362(this.$degrees, continuation);
            c06362.L$0 = obj;
            return c06362;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(TransformScope transformScope, Continuation<? super Unit> continuation) {
            return ((C06362) create(transformScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ((TransformScope) this.L$0).mo806transformByd4ec7I(1.0f, Offset.INSTANCE.m6585getZeroF1C5BW0(), this.$degrees);
            return Unit.INSTANCE;
        }
    }

    public static final Object rotateBy(TransformableState transformableState, float f, Continuation<? super Unit> continuation) {
        Object objTransform$default = TransformableState.transform$default(transformableState, null, new C06362(f, null), continuation, 1, null);
        return objTransform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objTransform$default : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: panBy-d-4ec7I, reason: not valid java name */
    public static final Object m993panByd4ec7I(TransformableState transformableState, long j, Continuation<? super Unit> continuation) {
        Object objTransform$default = TransformableState.transform$default(transformableState, null, new TransformableStateKt$panBy$2(j, null), continuation, 1, null);
        return objTransform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objTransform$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object stopTransformation$default(TransformableState transformableState, MutatePriority mutatePriority, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return stopTransformation(transformableState, mutatePriority, continuation);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$stopTransformation$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TransformableState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/TransformScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableStateKt$stopTransformation$2", f = "TransformableState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C06372 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
        int label;

        C06372(Continuation<? super C06372> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06372(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(TransformScope transformScope, Continuation<? super Unit> continuation) {
            return ((C06372) create(transformScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    public static final Object stopTransformation(TransformableState transformableState, MutatePriority mutatePriority, Continuation<? super Unit> continuation) {
        Object objTransform = transformableState.transform(mutatePriority, new C06372(null), continuation);
        return objTransform == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objTransform : Unit.INSTANCE;
    }
}
