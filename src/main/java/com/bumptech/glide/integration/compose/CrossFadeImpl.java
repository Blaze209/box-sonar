package com.bumptech.glide.integration.compose;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.NonCancellable;

/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\u0016\u001a\u00020\u000fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u000f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001aH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001bR\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000RF\u0010\t\u001a1\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u000f0\nj\u0002`\u0010¢\u0006\u0002\b\u0011X\u0096\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013RF\u0010\u0014\u001a1\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u000f0\nj\u0002`\u0010¢\u0006\u0002\b\u0011X\u0096\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lcom/bumptech/glide/integration/compose/CrossFadeImpl;", "Lcom/bumptech/glide/integration/compose/Transition;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "(Landroidx/compose/animation/core/AnimationSpec;)V", "animatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "drawCurrent", "Lkotlin/Function5;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/ui/geometry/Size;", "Landroidx/compose/ui/graphics/ColorFilter;", "", "Lcom/bumptech/glide/integration/compose/DrawPainter;", "Lkotlin/ExtensionFunctionType;", "getDrawCurrent", "()Lkotlin/jvm/functions/Function5;", "drawPlaceholder", "getDrawPlaceholder", "stop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transition", "invalidate", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CrossFadeImpl implements Transition {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final float OPAQUE_ALPHA = 1.0f;
    private final Animatable<Float, AnimationVector1D> animatable;
    private final AnimationSpec<Float> animationSpec;
    private final Function5<DrawScope, Painter, Size, Float, ColorFilter, Unit> drawCurrent;
    private final Function5<DrawScope, Painter, Size, Float, ColorFilter, Unit> drawPlaceholder;

    /* JADX INFO: renamed from: com.bumptech.glide.integration.compose.CrossFadeImpl$transition$1, reason: invalid class name */
    /* JADX INFO: compiled from: Transition.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.bumptech.glide.integration.compose.CrossFadeImpl", f = "Transition.kt", i = {0, 0, 1, 2}, l = {Token.SET_REF_OP, Token.XML, Token.XML}, m = "transition", n = {"this", "invalidate", "invalidate", "invalidate"}, s = {"L$0", "L$1", "L$0", "L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CrossFadeImpl.this.transition(null, this);
        }
    }

    public CrossFadeImpl(AnimationSpec<Float> animationSpec) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        this.animationSpec = animationSpec;
        this.animatable = new Animatable<>(Float.valueOf(0.0f), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Float.valueOf(1.0f), null, 8, null);
        this.drawPlaceholder = new Function5<DrawScope, Painter, Size, Float, ColorFilter, Unit>() { // from class: com.bumptech.glide.integration.compose.CrossFadeImpl$drawPlaceholder$1
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Painter painter, Size size, Float f, ColorFilter colorFilter) {
                m13146invokeQfoU1oo(drawScope, painter, size.m6643unboximpl(), f.floatValue(), colorFilter);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke-QfoU1oo, reason: not valid java name */
            public final void m13146invokeQfoU1oo(DrawScope drawScope, Painter painter, long j, float f, ColorFilter colorFilter) {
                Intrinsics.checkNotNullParameter(drawScope, "$this$null");
                Intrinsics.checkNotNullParameter(painter, "painter");
                painter.m7521drawx_KDEd0(drawScope, j, (1.0f - ((Number) this.this$0.animatable.getValue()).floatValue()) * f, colorFilter);
            }
        };
        this.drawCurrent = new Function5<DrawScope, Painter, Size, Float, ColorFilter, Unit>() { // from class: com.bumptech.glide.integration.compose.CrossFadeImpl$drawCurrent$1
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, Painter painter, Size size, Float f, ColorFilter colorFilter) {
                m13145invokeQfoU1oo(drawScope, painter, size.m6643unboximpl(), f.floatValue(), colorFilter);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke-QfoU1oo, reason: not valid java name */
            public final void m13145invokeQfoU1oo(DrawScope drawScope, Painter painter, long j, float f, ColorFilter colorFilter) {
                Intrinsics.checkNotNullParameter(drawScope, "$this$null");
                Intrinsics.checkNotNullParameter(painter, "painter");
                painter.m7521drawx_KDEd0(drawScope, j, f * ((Number) this.this$0.animatable.getValue()).floatValue(), colorFilter);
            }
        };
    }

    /* JADX INFO: compiled from: Transition.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bumptech/glide/integration/compose/CrossFadeImpl$Companion;", "", "()V", "OPAQUE_ALPHA", "", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x009a  */
    /* JADX WARN: Code duplicated, block: B:41:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @Override // com.bumptech.glide.integration.compose.Transition
    public Object transition(Function0<Unit> function0, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        CrossFadeImpl crossFadeImpl;
        Function0<Unit> function1;
        Throwable th;
        NonCancellable nonCancellable;
        AnonymousClass2 anonymousClass2;
        Function0<Unit> function2;
        NonCancellable nonCancellable2;
        AnonymousClass2 anonymousClass3;
        Function0<Unit> function3;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass4 = anonymousClass1;
        Object obj = anonymousClass4.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass4.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                Animatable<Float, AnimationVector1D> animatable = this.animatable;
                Float fBoxFloat = Boxing.boxFloat(1.0f);
                AnimationSpec<Float> animationSpec = this.animationSpec;
                anonymousClass4.L$0 = this;
                anonymousClass4.L$1 = function0;
                anonymousClass4.label = 1;
                if (Animatable.animateTo$default(animatable, fBoxFloat, animationSpec, null, null, anonymousClass4, 12, null) != coroutine_suspended) {
                    function1 = function0;
                    function1.invoke();
                    nonCancellable2 = NonCancellable.INSTANCE;
                    anonymousClass3 = this.new AnonymousClass2(null);
                    anonymousClass4.L$0 = function1;
                    anonymousClass4.L$1 = null;
                    anonymousClass4.label = 2;
                    if (BuildersKt.withContext(nonCancellable2, anonymousClass3, anonymousClass4) != coroutine_suspended) {
                        function3 = function1;
                        function3.invoke();
                        return Unit.INSTANCE;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                crossFadeImpl = this;
                function1 = function0;
                th = th;
                nonCancellable = NonCancellable.INSTANCE;
                anonymousClass2 = crossFadeImpl.new AnonymousClass2(null);
                anonymousClass4.L$0 = function1;
                anonymousClass4.L$1 = th;
                anonymousClass4.label = 3;
                if (BuildersKt.withContext(nonCancellable, anonymousClass2, anonymousClass4) != coroutine_suspended) {
                    function2 = function1;
                    function2.invoke();
                    throw th;
                }
                return coroutine_suspended;
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            Function0<Unit> function4 = (Function0) anonymousClass4.L$1;
            crossFadeImpl = (CrossFadeImpl) anonymousClass4.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                function1 = function4;
                this = crossFadeImpl;
                try {
                    function1.invoke();
                    nonCancellable2 = NonCancellable.INSTANCE;
                    anonymousClass3 = this.new AnonymousClass2(null);
                    anonymousClass4.L$0 = function1;
                    anonymousClass4.L$1 = null;
                    anonymousClass4.label = 2;
                    if (BuildersKt.withContext(nonCancellable2, anonymousClass3, anonymousClass4) != coroutine_suspended) {
                        function3 = function1;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    crossFadeImpl = this;
                    th = th;
                    nonCancellable = NonCancellable.INSTANCE;
                    anonymousClass2 = crossFadeImpl.new AnonymousClass2(null);
                    anonymousClass4.L$0 = function1;
                    anonymousClass4.L$1 = th;
                    anonymousClass4.label = 3;
                    if (BuildersKt.withContext(nonCancellable, anonymousClass2, anonymousClass4) != coroutine_suspended) {
                        function2 = function1;
                        function2.invoke();
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                function1 = function4;
                th = th;
                nonCancellable = NonCancellable.INSTANCE;
                anonymousClass2 = crossFadeImpl.new AnonymousClass2(null);
                anonymousClass4.L$0 = function1;
                anonymousClass4.L$1 = th;
                anonymousClass4.label = 3;
                if (BuildersKt.withContext(nonCancellable, anonymousClass2, anonymousClass4) != coroutine_suspended) {
                    function2 = function1;
                    function2.invoke();
                    throw th;
                }
                return coroutine_suspended;
            }
            return coroutine_suspended;
        }
        if (i != 2) {
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            th = (Throwable) anonymousClass4.L$1;
            function2 = (Function0) anonymousClass4.L$0;
            ResultKt.throwOnFailure(obj);
            function2.invoke();
            throw th;
        }
        function3 = (Function0) anonymousClass4.L$0;
        ResultKt.throwOnFailure(obj);
        function3.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.bumptech.glide.integration.compose.CrossFadeImpl$transition$2, reason: invalid class name */
    /* JADX INFO: compiled from: Transition.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.bumptech.glide.integration.compose.CrossFadeImpl$transition$2", f = "Transition.kt", i = {}, l = {Token.DOTQUERY}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CrossFadeImpl.this.new AnonymousClass2(continuation);
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
                this.label = 1;
                if (CrossFadeImpl.this.animatable.snapTo(Boxing.boxFloat(1.0f), this) == coroutine_suspended) {
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

    @Override // com.bumptech.glide.integration.compose.Transition
    public Object stop(Continuation<? super Unit> continuation) {
        Object objStop = this.animatable.stop(continuation);
        return objStop == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objStop : Unit.INSTANCE;
    }

    @Override // com.bumptech.glide.integration.compose.Transition
    public Function5<DrawScope, Painter, Size, Float, ColorFilter, Unit> getDrawPlaceholder() {
        return this.drawPlaceholder;
    }

    @Override // com.bumptech.glide.integration.compose.Transition
    public Function5<DrawScope, Painter, Size, Float, ColorFilter, Unit> getDrawCurrent() {
        return this.drawCurrent;
    }
}
