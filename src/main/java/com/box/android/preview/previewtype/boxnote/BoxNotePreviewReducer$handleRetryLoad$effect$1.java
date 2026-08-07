package com.box.android.preview.previewtype.boxnote;

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

/* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer$handleRetryLoad$effect$1", f = "BoxNotePreviewReducer.kt", i = {0}, l = {485}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"}, v = 1)
final class BoxNotePreviewReducer$handleRetryLoad$effect$1 extends SuspendLambda implements Function2<FlowCollector<? super BoxNotePreviewReducer.Action>, Continuation<? super Unit>, Object> {
    final /* synthetic */ BoxNotePreviewReducer.State $state;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BoxNotePreviewReducer$handleRetryLoad$effect$1(BoxNotePreviewReducer.State state, Continuation<? super BoxNotePreviewReducer$handleRetryLoad$effect$1> continuation) {
        super(2, continuation);
        this.$state = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BoxNotePreviewReducer$handleRetryLoad$effect$1 boxNotePreviewReducer$handleRetryLoad$effect$1 = new BoxNotePreviewReducer$handleRetryLoad$effect$1(this.$state, continuation);
        boxNotePreviewReducer$handleRetryLoad$effect$1.L$0 = obj;
        return boxNotePreviewReducer$handleRetryLoad$effect$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super BoxNotePreviewReducer.Action> flowCollector, Continuation<? super Unit> continuation) {
        return ((BoxNotePreviewReducer$handleRetryLoad$effect$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            this.label = 1;
            if (flowCollector.emit(new BoxNotePreviewReducer.Action.LoadNote(this.$state.getFileModel(), false, false, 4, null), this) == coroutine_suspended) {
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
