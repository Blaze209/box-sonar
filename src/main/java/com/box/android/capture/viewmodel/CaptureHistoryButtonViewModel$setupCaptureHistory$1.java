package com.box.android.capture.viewmodel;

import androidx.lifecycle.LiveDataScope;
import com.box.android.domain.models.CaptureHistoryModel;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.utils.result.Result;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: CaptureHistoryButtonViewModel.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001* \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/Pair;", "", "Lcom/box/android/domain/models/CaptureHistoryModel;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.capture.viewmodel.CaptureHistoryButtonViewModel$setupCaptureHistory$1", f = "CaptureHistoryButtonViewModel.kt", i = {0}, l = {40}, m = "invokeSuspend", n = {"$this$liveData"}, s = {"L$0"}, v = 1)
final class CaptureHistoryButtonViewModel$setupCaptureHistory$1 extends SuspendLambda implements Function2<LiveDataScope<Pair<? extends List<? extends CaptureHistoryModel>, ? extends List<? extends CaptureHistoryModel>>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CaptureHistoryButtonViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CaptureHistoryButtonViewModel$setupCaptureHistory$1(CaptureHistoryButtonViewModel captureHistoryButtonViewModel, Continuation<? super CaptureHistoryButtonViewModel$setupCaptureHistory$1> continuation) {
        super(2, continuation);
        this.this$0 = captureHistoryButtonViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CaptureHistoryButtonViewModel$setupCaptureHistory$1 captureHistoryButtonViewModel$setupCaptureHistory$1 = new CaptureHistoryButtonViewModel$setupCaptureHistory$1(this.this$0, continuation);
        captureHistoryButtonViewModel$setupCaptureHistory$1.L$0 = obj;
        return captureHistoryButtonViewModel$setupCaptureHistory$1;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(LiveDataScope<Pair<List<CaptureHistoryModel>, List<CaptureHistoryModel>>> liveDataScope, Continuation<? super Unit> continuation) {
        return ((CaptureHistoryButtonViewModel$setupCaptureHistory$1) create(liveDataScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(LiveDataScope<Pair<? extends List<? extends CaptureHistoryModel>, ? extends List<? extends CaptureHistoryModel>>> liveDataScope, Continuation<? super Unit> continuation) {
        return invoke2((LiveDataScope<Pair<List<CaptureHistoryModel>, List<CaptureHistoryModel>>>) liveDataScope, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        final LiveDataScope liveDataScope = (LiveDataScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final Flow<Result<Pair<List<CaptureHistoryModel>, List<CaptureHistoryModel>>, DomainError>> historicalCaptures = this.this$0.captureHistoryInteractor.getHistoricalCaptures(false);
            this.L$0 = SpillingKt.nullOutSpilledVariable(liveDataScope);
            this.label = 1;
            if (FlowKt.distinctUntilChangedBy(new Flow<Pair<? extends List<? extends CaptureHistoryModel>, ? extends List<? extends CaptureHistoryModel>>>() { // from class: com.box.android.capture.viewmodel.CaptureHistoryButtonViewModel$setupCaptureHistory$1$invokeSuspend$$inlined$mapNotNull$1

                /* JADX INFO: renamed from: com.box.android.capture.viewmodel.CaptureHistoryButtonViewModel$setupCaptureHistory$1$invokeSuspend$$inlined$mapNotNull$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.box.android.capture.viewmodel.CaptureHistoryButtonViewModel$setupCaptureHistory$1$invokeSuspend$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.capture.viewmodel.CaptureHistoryButtonViewModel$setupCaptureHistory$1$invokeSuspend$$inlined$mapNotNull$1$2", f = "CaptureHistoryButtonViewModel.kt", i = {0, 0, 0, 0, 0, 0}, l = {52}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
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
                        Object obj2 = anonymousClass1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = anonymousClass1.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector = this.$this_unsafeFlow;
                            Object orNull = com.box.android.domain.utils.result.ResultKt.getOrNull((Result) obj);
                            if (orNull != null) {
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(orNull);
                                anonymousClass1.I$0 = 0;
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(orNull, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i2 = anonymousClass1.I$0;
                            Object obj3 = anonymousClass1.L$4;
                            Object obj4 = anonymousClass1.L$2;
                            Object obj5 = anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj2);
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super Pair<? extends List<? extends CaptureHistoryModel>, ? extends List<? extends CaptureHistoryModel>>> flowCollector, Continuation continuation) {
                    Object objCollect = historicalCaptures.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            }, new Function1() { // from class: com.box.android.capture.viewmodel.CaptureHistoryButtonViewModel$setupCaptureHistory$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Integer.valueOf(CaptureHistoryButtonViewModel$setupCaptureHistory$1.invokeSuspend$lambda$1((Pair) obj2));
                }
            }).collect(new FlowCollector() { // from class: com.box.android.capture.viewmodel.CaptureHistoryButtonViewModel$setupCaptureHistory$1.3
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((Pair<? extends List<CaptureHistoryModel>, ? extends List<CaptureHistoryModel>>) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(Pair<? extends List<CaptureHistoryModel>, ? extends List<CaptureHistoryModel>> pair, Continuation<? super Unit> continuation) {
                    Object objEmit = liveDataScope.emit(pair, continuation);
                    return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
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
    public static final int invokeSuspend$lambda$1(Pair pair) {
        return ((List) pair.getFirst()).size() + ((List) pair.getSecond()).size();
    }
}
