package com.box.android.capture.adapter;

import com.box.android.domain.models.item.ItemModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PendingCaptureFilesAdapter.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.capture.adapter.PendingCaptureFilesAdapter$onCreateViewHolder$1$1", f = "PendingCaptureFilesAdapter.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class PendingCaptureFilesAdapter$onCreateViewHolder$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ItemModel $item;
    int label;
    final /* synthetic */ PendingCaptureFilesAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PendingCaptureFilesAdapter$onCreateViewHolder$1$1(PendingCaptureFilesAdapter pendingCaptureFilesAdapter, ItemModel itemModel, Continuation<? super PendingCaptureFilesAdapter$onCreateViewHolder$1$1> continuation) {
        super(2, continuation);
        this.this$0 = pendingCaptureFilesAdapter;
        this.$item = itemModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PendingCaptureFilesAdapter$onCreateViewHolder$1$1(this.this$0, this.$item, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PendingCaptureFilesAdapter$onCreateViewHolder$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.offlineService.syncOfflineItems(CollectionsKt.listOf(this.$item), this) == coroutine_suspended) {
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
