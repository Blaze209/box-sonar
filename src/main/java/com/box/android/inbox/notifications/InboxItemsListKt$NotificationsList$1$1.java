package com.box.android.inbox.notifications;

import androidx.compose.runtime.State;
import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: InboxItemsList.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.inbox.notifications.InboxItemsListKt$NotificationsList$1$1", f = "InboxItemsList.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class InboxItemsListKt$NotificationsList$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Boolean> $shouldLoadMore$delegate;
    final /* synthetic */ Store<InboxItemsListReducer.State, InboxItemsListReducer.Action> $store;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InboxItemsListKt$NotificationsList$1$1(Store<InboxItemsListReducer.State, InboxItemsListReducer.Action> store, State<Boolean> state, Continuation<? super InboxItemsListKt$NotificationsList$1$1> continuation) {
        super(2, continuation);
        this.$store = store;
        this.$shouldLoadMore$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InboxItemsListKt$NotificationsList$1$1(this.$store, this.$shouldLoadMore$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InboxItemsListKt$NotificationsList$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (InboxItemsListKt.NotificationsList$lambda$2(this.$shouldLoadMore$delegate)) {
                this.$store.send(InboxItemsListReducer.Action.LoadMoreNotifications.INSTANCE);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
