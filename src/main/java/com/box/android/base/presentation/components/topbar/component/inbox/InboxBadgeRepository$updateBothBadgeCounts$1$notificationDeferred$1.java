package com.box.android.base.presentation.components.topbar.component.inbox;

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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.base.presentation.components.topbar.component.inbox.InboxBadgeRepository$updateBothBadgeCounts$1$notificationDeferred$1", f = "InboxBadgeRepository.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class InboxBadgeRepository$updateBothBadgeCounts$1$notificationDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    int label;
    final /* synthetic */ InboxBadgeRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InboxBadgeRepository$updateBothBadgeCounts$1$notificationDeferred$1(InboxBadgeRepository inboxBadgeRepository, Continuation<? super InboxBadgeRepository$updateBothBadgeCounts$1$notificationDeferred$1> continuation) {
        super(2, continuation);
        this.this$0 = inboxBadgeRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InboxBadgeRepository$updateBothBadgeCounts$1$notificationDeferred$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
        return ((InboxBadgeRepository$updateBothBadgeCounts$1$notificationDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        Object objFetchNotificationBadgeCount = this.this$0.fetchNotificationBadgeCount(this);
        return objFetchNotificationBadgeCount == coroutine_suspended ? coroutine_suspended : objFetchNotificationBadgeCount;
    }
}
