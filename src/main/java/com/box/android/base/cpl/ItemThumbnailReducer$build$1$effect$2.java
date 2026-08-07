package com.box.android.base.cpl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: ItemThumbnailReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/base/cpl/ItemThumbnailReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.base.cpl.ItemThumbnailReducer$build$1$effect$2", f = "ItemThumbnailReducer.kt", i = {0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {66, 68, 71}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$onSuccess$iv", "bitmap", "$i$f$onSuccess", "$i$a$-onSuccess-ItemThumbnailReducer$build$1$effect$2$1", "$this$flow", "$this$onError$iv", "error", "$i$f$onError", "$i$a$-onError-ItemThumbnailReducer$build$1$effect$2$2"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
final class ItemThumbnailReducer$build$1$effect$2 extends SuspendLambda implements Function2<FlowCollector<? super ItemThumbnailReducer.Action>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ItemThumbnailReducer.State $state;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ItemThumbnailReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ItemThumbnailReducer$build$1$effect$2(ItemThumbnailReducer itemThumbnailReducer, ItemThumbnailReducer.State state, Continuation<? super ItemThumbnailReducer$build$1$effect$2> continuation) {
        super(2, continuation);
        this.this$0 = itemThumbnailReducer;
        this.$state = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ItemThumbnailReducer$build$1$effect$2 itemThumbnailReducer$build$1$effect$2 = new ItemThumbnailReducer$build$1$effect$2(this.this$0, this.$state, continuation);
        itemThumbnailReducer$build$1$effect$2.L$0 = obj;
        return itemThumbnailReducer$build$1$effect$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super ItemThumbnailReducer.Action> flowCollector, Continuation<? super Unit> continuation) {
        return ((ItemThumbnailReducer$build$1$effect$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x009d  */
    /* JADX WARN: Code duplicated, block: B:26:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:29:0x00ca  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00c7, code lost:
    
        if (r0.emit(r4, r8) == r1) goto L28;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.base.cpl.ItemThumbnailReducer$build$1$effect$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
