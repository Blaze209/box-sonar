package com.box.android.boxai.multidoc;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: BoxAiMultidocAvailabilityReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/boxai/multidoc/BoxAiMultidocAvailabilityReducer$Action$SetItemStatus;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.boxai.multidoc.BoxAiMultidocAvailabilityReducer$build$1$1", f = "BoxAiMultidocAvailabilityReducer.kt", i = {0, 1, 1}, l = {101, 102}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "itemStatus"}, s = {"L$0", "L$0", "L$1"}, v = 1)
final class BoxAiMultidocAvailabilityReducer$build$1$1 extends SuspendLambda implements Function2<FlowCollector<? super BoxAiMultidocAvailabilityReducer.Action.SetItemStatus>, Continuation<? super Unit>, Object> {
    final /* synthetic */ BoxAiMultidocAvailabilityReducer.Action $action;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ BoxAiMultidocAvailabilityReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BoxAiMultidocAvailabilityReducer$build$1$1(BoxAiMultidocAvailabilityReducer boxAiMultidocAvailabilityReducer, BoxAiMultidocAvailabilityReducer.Action action, Continuation<? super BoxAiMultidocAvailabilityReducer$build$1$1> continuation) {
        super(2, continuation);
        this.this$0 = boxAiMultidocAvailabilityReducer;
        this.$action = action;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BoxAiMultidocAvailabilityReducer$build$1$1 boxAiMultidocAvailabilityReducer$build$1$1 = new BoxAiMultidocAvailabilityReducer$build$1$1(this.this$0, this.$action, continuation);
        boxAiMultidocAvailabilityReducer$build$1$1.L$0 = obj;
        return boxAiMultidocAvailabilityReducer$build$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super BoxAiMultidocAvailabilityReducer.Action.SetItemStatus> flowCollector, Continuation<? super Unit> continuation) {
        return ((BoxAiMultidocAvailabilityReducer$build$1$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x006d, code lost:
    
        if (r0.emit(new com.box.android.boxai.multidoc.BoxAiMultidocAvailabilityReducer.Action.SetItemStatus(((com.box.android.boxai.multidoc.BoxAiMultidocAvailabilityReducer.Action.EvaluateItem) r6.$action).getItem(), r7), r6) == r1) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.L$0
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r6.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L26
            if (r2 == r4) goto L22
            if (r2 != r3) goto L1a
            java.lang.Object r6 = r6.L$1
            com.box.android.domain.models.boxai.AiItemAvailabilityStatus r6 = (com.box.android.domain.models.boxai.AiItemAvailabilityStatus) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L70
        L1a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L22:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L49
        L26:
            kotlin.ResultKt.throwOnFailure(r7)
            com.box.android.boxai.multidoc.BoxAiMultidocAvailabilityReducer r7 = r6.this$0
            com.box.android.boxai.BoxAiEnvironment r7 = r7.getEnvironment()
            com.box.android.domain.usecases.boxai.GetBoxAiAvailabilityUseCase r7 = r7.getGetBoxAiAvailabilityUseCase()
            com.box.android.boxai.multidoc.BoxAiMultidocAvailabilityReducer$Action r2 = r6.$action
            com.box.android.boxai.multidoc.BoxAiMultidocAvailabilityReducer$Action$EvaluateItem r2 = (com.box.android.boxai.multidoc.BoxAiMultidocAvailabilityReducer.Action.EvaluateItem) r2
            com.box.android.domain.models.item.ItemModel r2 = r2.getItem()
            r5 = r6
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6.L$0 = r0
            r6.label = r4
            java.lang.Object r7 = r7.getAiAvailabilityForItem(r2, r4, r5)
            if (r7 != r1) goto L49
            goto L6f
        L49:
            com.box.android.domain.models.boxai.AiItemAvailabilityStatus r7 = (com.box.android.domain.models.boxai.AiItemAvailabilityStatus) r7
            com.box.android.boxai.multidoc.BoxAiMultidocAvailabilityReducer$Action$SetItemStatus r2 = new com.box.android.boxai.multidoc.BoxAiMultidocAvailabilityReducer$Action$SetItemStatus
            com.box.android.boxai.multidoc.BoxAiMultidocAvailabilityReducer$Action r4 = r6.$action
            com.box.android.boxai.multidoc.BoxAiMultidocAvailabilityReducer$Action$EvaluateItem r4 = (com.box.android.boxai.multidoc.BoxAiMultidocAvailabilityReducer.Action.EvaluateItem) r4
            com.box.android.domain.models.item.ItemModel r4 = r4.getItem()
            r2.<init>(r4, r7)
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r6.L$0 = r5
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r6.L$1 = r7
            r6.label = r3
            java.lang.Object r6 = r0.emit(r2, r4)
            if (r6 != r1) goto L70
        L6f:
            return r1
        L70:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.boxai.multidoc.BoxAiMultidocAvailabilityReducer$build$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
