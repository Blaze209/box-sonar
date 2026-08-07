package com.box.android.base.presentation.components.topbar.component.inbox;

import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.model.BoxTaskBadge;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: InboxBadgeRepository.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/box/androidsdk/content/requests/BoxResponse;", "Lcom/box/boxandroidlibv2private/model/BoxTaskBadge;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.base.presentation.components.topbar.component.inbox.InboxBadgeRepository$updateBothBadgeCounts$1$taskDeferred$1", f = "InboxBadgeRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class InboxBadgeRepository$updateBothBadgeCounts$1$taskDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BoxResponse<BoxTaskBadge>>, Object> {
    int label;
    final /* synthetic */ InboxBadgeRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InboxBadgeRepository$updateBothBadgeCounts$1$taskDeferred$1(InboxBadgeRepository inboxBadgeRepository, Continuation<? super InboxBadgeRepository$updateBothBadgeCounts$1$taskDeferred$1> continuation) {
        super(2, continuation);
        this.this$0 = inboxBadgeRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InboxBadgeRepository$updateBothBadgeCounts$1$taskDeferred$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BoxResponse<BoxTaskBadge>> continuation) {
        return ((InboxBadgeRepository$updateBothBadgeCounts$1$taskDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return this.this$0.fetchTaskBadgeCount();
    }
}
