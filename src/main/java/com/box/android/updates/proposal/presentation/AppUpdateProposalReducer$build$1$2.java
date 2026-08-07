package com.box.android.updates.proposal.presentation;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: AppUpdateProposalReducer.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/updates/proposal/presentation/AppUpdateProposalReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.updates.proposal.presentation.AppUpdateProposalReducer$build$1$2", f = "AppUpdateProposalReducer.kt", i = {0}, l = {51}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"}, v = 1)
final class AppUpdateProposalReducer$build$1$2 extends SuspendLambda implements Function2<FlowCollector<? super AppUpdateProposalReducer.Action>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AppUpdateProposalReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppUpdateProposalReducer$build$1$2(AppUpdateProposalReducer appUpdateProposalReducer, Continuation<? super AppUpdateProposalReducer$build$1$2> continuation) {
        super(2, continuation);
        this.this$0 = appUpdateProposalReducer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AppUpdateProposalReducer$build$1$2 appUpdateProposalReducer$build$1$2 = new AppUpdateProposalReducer$build$1$2(this.this$0, continuation);
        appUpdateProposalReducer$build$1$2.L$0 = obj;
        return appUpdateProposalReducer$build$1$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super AppUpdateProposalReducer.Action> flowCollector, Continuation<? super Unit> continuation) {
        return ((AppUpdateProposalReducer$build$1$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        final FlowCollector flowCollector = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            this.label = 1;
            if (this.this$0.environment.getAppUpdateProposalManager().getUpdateDownloadedStateFlow().collect(new FlowCollector() { // from class: com.box.android.updates.proposal.presentation.AppUpdateProposalReducer$build$1$2.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit(((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) continuation);
                }

                public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                    if (z) {
                        Object objEmit = flowCollector.emit(AppUpdateProposalReducer.Action.UpdateDownloaded.INSTANCE, continuation);
                        return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
                    }
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
        throw new KotlinNothingValueException();
    }
}
