package com.apollographql.apollo3.internal;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: flows.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aS\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000323\b\u0004\u0010\u0004\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005H\u0082H¢\u0006\u0002\u0010\f\u001am\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u00020\u00032B\u0010\u000f\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u0011\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0010¢\u0006\u0002\b\u0012H\u0000¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"collectWhile", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", IdentificationData.PREDICATE, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transformWhile", "R", ViewProps.TRANSFORM, "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "apollo-runtime"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class FlowsKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: com.apollographql.apollo3.internal.FlowsKt$transformWhile$1, reason: invalid class name */
    /* JADX INFO: compiled from: flows.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.internal.FlowsKt$transformWhile$1", f = "flows.kt", i = {0}, l = {61}, m = "invokeSuspend", n = {"collector$iv"}, s = {"L$0"})
    static final class AnonymousClass1<R> extends SuspendLambda implements Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Flow<T> $this_transformWhile;
        final /* synthetic */ Function3<FlowCollector<? super R>, T, Continuation<? super Boolean>, Object> $transform;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Flow<? extends T> flow, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Boolean>, ? extends Object> function3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_transformWhile = flow;
            this.$transform = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_transformWhile, this.$transform, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowsKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 flowsKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Flow<T> flow = this.$this_transformWhile;
                final FlowsKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 flowsKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$2 = new FlowsKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1(this.$transform, flowCollector);
                try {
                    FlowCollector flowCollector2 = new FlowCollector() { // from class: com.apollographql.apollo3.internal.FlowsKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$2
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(T t, Continuation<? super Unit> continuation) {
                            Object objEmit = flowsKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$2.emit(t, continuation);
                            return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
                        }
                    };
                    this.L$0 = flowsKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$2;
                    this.label = 1;
                    if (flow.collect((FlowCollector<? super T>) flowCollector2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (AbortFlowException e) {
                    e = e;
                    flowsKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 = flowsKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$2;
                    e.checkOwnership(flowsKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1);
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                flowsKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 = (FlowsKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (AbortFlowException e2) {
                    e = e2;
                    e.checkOwnership(flowsKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1);
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final <T, R> Flow<R> transformWhile(Flow<? extends T> flow, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Boolean>, ? extends Object> transform) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return FlowKt.flow(new AnonymousClass1(flow, transform, null));
    }

    private static final <T> Object collectWhile(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        final FlowsKt$collectWhile$collector$1 flowsKt$collectWhile$collector$1 = new FlowsKt$collectWhile$collector$1(function2);
        try {
            flow.collect(new FlowCollector() { // from class: com.apollographql.apollo3.internal.FlowsKt.collectWhile.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(T t, Continuation<? super Unit> continuation2) {
                    Object objEmit = flowsKt$collectWhile$collector$1.emit(t, continuation2);
                    return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
                }
            }, continuation);
        } catch (AbortFlowException e) {
            e.checkOwnership(flowsKt$collectWhile$collector$1);
        }
        return Unit.INSTANCE;
    }
}
