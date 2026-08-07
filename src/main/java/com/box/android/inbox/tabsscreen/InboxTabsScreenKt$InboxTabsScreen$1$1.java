package com.box.android.inbox.tabsscreen;

import com.box.android.vm.InboxBadgeVM;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: InboxTabsScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.inbox.tabsscreen.InboxTabsScreenKt$InboxTabsScreen$1$1", f = "InboxTabsScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class InboxTabsScreenKt$InboxTabsScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ InboxBadgeVM $inboxBadgeVm;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InboxTabsScreenKt$InboxTabsScreen$1$1(InboxBadgeVM inboxBadgeVM, Continuation<? super InboxTabsScreenKt$InboxTabsScreen$1$1> continuation) {
        super(2, continuation);
        this.$inboxBadgeVm = inboxBadgeVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InboxTabsScreenKt$InboxTabsScreen$1$1(this.$inboxBadgeVm, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InboxTabsScreenKt$InboxTabsScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$inboxBadgeVm.fetchBadgeData();
        return Unit.INSTANCE;
    }
}
