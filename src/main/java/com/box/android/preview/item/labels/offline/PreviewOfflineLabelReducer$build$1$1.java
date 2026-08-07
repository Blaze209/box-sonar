package com.box.android.preview.item.labels.offline;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PreviewOfflineLabelReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.item.labels.offline.PreviewOfflineLabelReducer$build$1$1", f = "PreviewOfflineLabelReducer.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class PreviewOfflineLabelReducer$build$1$1 extends SuspendLambda implements Function1<Continuation<? super PreviewOfflineLabelReducer.Action>, Object> {
    final /* synthetic */ PreviewOfflineLabelReducer.Action $action;
    int label;
    final /* synthetic */ PreviewOfflineLabelReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PreviewOfflineLabelReducer$build$1$1(PreviewOfflineLabelReducer previewOfflineLabelReducer, PreviewOfflineLabelReducer.Action action, Continuation<? super PreviewOfflineLabelReducer$build$1$1> continuation) {
        super(1, continuation);
        this.this$0 = previewOfflineLabelReducer;
        this.$action = action;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new PreviewOfflineLabelReducer$build$1$1(this.this$0, this.$action, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super PreviewOfflineLabelReducer.Action> continuation) {
        return ((PreviewOfflineLabelReducer$build$1$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.isFileOfflined(((PreviewOfflineLabelReducer.Action.UpdateLabel) this.$action).getFileModel(), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (((Boolean) obj).booleanValue()) {
            return PreviewOfflineLabelReducer.Action.SetLabel.INSTANCE;
        }
        return PreviewOfflineLabelReducer.Action.RemoveLabel.INSTANCE;
    }
}
