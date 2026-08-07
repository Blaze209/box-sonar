package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.ui.platform.InfiniteAnimationPolicy;
import androidx.graphics.shapes.Morph;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: LoadingIndicator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.LoadingIndicatorKt$LoadingIndicatorImpl$6$1", f = "LoadingIndicator.kt", i = {}, l = {437}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class LoadingIndicatorKt$LoadingIndicatorImpl$6$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableIntState $currentMorphIndex$delegate;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $globalRotation;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $morphProgress;
    final /* synthetic */ MutableFloatState $morphRotationTargetAngle$delegate;
    final /* synthetic */ List<Morph> $morphSequence;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LoadingIndicatorKt$LoadingIndicatorImpl$6$1(Animatable<Float, AnimationVector1D> animatable, List<Morph> list, MutableIntState mutableIntState, MutableFloatState mutableFloatState, Animatable<Float, AnimationVector1D> animatable2, Continuation<? super LoadingIndicatorKt$LoadingIndicatorImpl$6$1> continuation) {
        super(2, continuation);
        this.$morphProgress = animatable;
        this.$morphSequence = list;
        this.$currentMorphIndex$delegate = mutableIntState;
        this.$morphRotationTargetAngle$delegate = mutableFloatState;
        this.$globalRotation = animatable2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LoadingIndicatorKt$LoadingIndicatorImpl$6$1 loadingIndicatorKt$LoadingIndicatorImpl$6$1 = new LoadingIndicatorKt$LoadingIndicatorImpl$6$1(this.$morphProgress, this.$morphSequence, this.$currentMorphIndex$delegate, this.$morphRotationTargetAngle$delegate, this.$globalRotation, continuation);
        loadingIndicatorKt$LoadingIndicatorImpl$6$1.L$0 = obj;
        return loadingIndicatorKt$LoadingIndicatorImpl$6$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LoadingIndicatorKt$LoadingIndicatorImpl$6$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            final Animatable<Float, AnimationVector1D> animatable = this.$morphProgress;
            final List<Morph> list = this.$morphSequence;
            final MutableIntState mutableIntState = this.$currentMorphIndex$delegate;
            final MutableFloatState mutableFloatState = this.$morphRotationTargetAngle$delegate;
            Function0 function0 = new Function0() { // from class: androidx.compose.material3.LoadingIndicatorKt$LoadingIndicatorImpl$6$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LoadingIndicatorKt$LoadingIndicatorImpl$6$1.invokeSuspend$lambda$0(coroutineScope, animatable, list, mutableIntState, mutableFloatState);
                }
            };
            final Animatable<Float, AnimationVector1D> animatable2 = this.$globalRotation;
            Function0 function1 = new Function0() { // from class: androidx.compose.material3.LoadingIndicatorKt$LoadingIndicatorImpl$6$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LoadingIndicatorKt$LoadingIndicatorImpl$6$1.invokeSuspend$lambda$1(coroutineScope, animatable2);
                }
            };
            InfiniteAnimationPolicy infiniteAnimationPolicy = (InfiniteAnimationPolicy) coroutineScope.getCoroutineContext().get(InfiniteAnimationPolicy.INSTANCE);
            if (infiniteAnimationPolicy == null) {
                function0.invoke();
                function1.invoke();
            } else {
                this.label = 1;
                if (infiniteAnimationPolicy.onInfiniteOperation(new AnonymousClass1(function0, function1, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
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
    public static final Job invokeSuspend$lambda$0(CoroutineScope coroutineScope, Animatable animatable, List list, MutableIntState mutableIntState, MutableFloatState mutableFloatState) {
        return BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new LoadingIndicatorKt$LoadingIndicatorImpl$6$1$morphAnimationBlock$1$1(animatable, list, mutableIntState, mutableFloatState, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Job invokeSuspend$lambda$1(CoroutineScope coroutineScope, Animatable animatable) {
        return BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new LoadingIndicatorKt$LoadingIndicatorImpl$6$1$rotationAnimationBlock$1$1(animatable, null), 3, null);
    }

    /* JADX INFO: renamed from: androidx.compose.material3.LoadingIndicatorKt$LoadingIndicatorImpl$6$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: LoadingIndicator.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.LoadingIndicatorKt$LoadingIndicatorImpl$6$1$1", f = "LoadingIndicator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Job> $morphAnimationBlock;
        final /* synthetic */ Function0<Job> $rotationAnimationBlock;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function0<? extends Job> function0, Function0<? extends Job> function1, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$morphAnimationBlock = function0;
            this.$rotationAnimationBlock = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$morphAnimationBlock, this.$rotationAnimationBlock, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$morphAnimationBlock.invoke();
            this.$rotationAnimationBlock.invoke();
            return Unit.INSTANCE;
        }
    }
}
