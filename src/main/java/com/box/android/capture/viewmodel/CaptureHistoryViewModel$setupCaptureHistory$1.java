package com.box.android.capture.viewmodel;

import androidx.lifecycle.LiveDataScope;
import com.box.android.domain.models.CaptureHistoryModel;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.usecases.capture.CaptureHistoryUseCase;
import com.box.android.domain.utils.result.Result;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: CaptureHistoryViewModel.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001* \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/Pair;", "", "Lcom/box/android/domain/models/CaptureHistoryModel;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.capture.viewmodel.CaptureHistoryViewModel$setupCaptureHistory$1", f = "CaptureHistoryViewModel.kt", i = {0}, l = {31}, m = "invokeSuspend", n = {"$this$liveData"}, s = {"L$0"}, v = 1)
final class CaptureHistoryViewModel$setupCaptureHistory$1 extends SuspendLambda implements Function2<LiveDataScope<Pair<? extends List<? extends CaptureHistoryModel>, ? extends List<? extends CaptureHistoryModel>>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CaptureHistoryViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CaptureHistoryViewModel$setupCaptureHistory$1(CaptureHistoryViewModel captureHistoryViewModel, Continuation<? super CaptureHistoryViewModel$setupCaptureHistory$1> continuation) {
        super(2, continuation);
        this.this$0 = captureHistoryViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CaptureHistoryViewModel$setupCaptureHistory$1 captureHistoryViewModel$setupCaptureHistory$1 = new CaptureHistoryViewModel$setupCaptureHistory$1(this.this$0, continuation);
        captureHistoryViewModel$setupCaptureHistory$1.L$0 = obj;
        return captureHistoryViewModel$setupCaptureHistory$1;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(LiveDataScope<Pair<List<CaptureHistoryModel>, List<CaptureHistoryModel>>> liveDataScope, Continuation<? super Unit> continuation) {
        return ((CaptureHistoryViewModel$setupCaptureHistory$1) create(liveDataScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            Flow historicalCaptures$default = CaptureHistoryUseCase.getHistoricalCaptures$default(this.this$0.captureHistoryInteractor, false, 1, null);
            final CaptureHistoryViewModel captureHistoryViewModel = this.this$0;
            this.L$0 = SpillingKt.nullOutSpilledVariable(liveDataScope);
            this.label = 1;
            if (historicalCaptures$default.collect(new FlowCollector() { // from class: com.box.android.capture.viewmodel.CaptureHistoryViewModel$setupCaptureHistory$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((Result<? extends Pair<? extends List<CaptureHistoryModel>, ? extends List<CaptureHistoryModel>>, ? extends DomainError>) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(Result<? extends Pair<? extends List<CaptureHistoryModel>, ? extends List<CaptureHistoryModel>>, ? extends DomainError> result, Continuation<? super Unit> continuation) {
                    if (result instanceof Result.Success) {
                        Object objEmit = liveDataScope.emit((Pair<List<CaptureHistoryModel>, List<CaptureHistoryModel>>) ((Result.Success) result).getValue(), continuation);
                        return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
                    }
                    if (!(result instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    captureHistoryViewModel.setError((DomainError) ((Result.Error) result).getValue());
                    return Unit.INSTANCE;
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
}
