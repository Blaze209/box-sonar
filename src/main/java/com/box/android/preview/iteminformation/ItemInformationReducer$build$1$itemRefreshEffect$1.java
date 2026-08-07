package com.box.android.preview.iteminformation;

import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: ItemInformationReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.iteminformation.ItemInformationReducer$build$1$itemRefreshEffect$1", f = "ItemInformationReducer.kt", i = {0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4}, l = {134, 136, 139, 140, Token.SETELEM_OP}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$onSuccess$iv", "newItemModel", "$i$f$onSuccess", "$i$a$-onSuccess-ItemInformationReducer$build$1$itemRefreshEffect$1$1", "$this$flow", "$this$onError$iv", "error", "$i$f$onError", "$i$a$-onError-ItemInformationReducer$build$1$itemRefreshEffect$1$2", "$this$flow", "$this$onError$iv", "error", "$i$f$onError", "$i$a$-onError-ItemInformationReducer$build$1$itemRefreshEffect$1$2", "$this$flow", "$this$onError$iv", "error", "$i$f$onError", "$i$a$-onError-ItemInformationReducer$build$1$itemRefreshEffect$1$2"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
final class ItemInformationReducer$build$1$itemRefreshEffect$1 extends SuspendLambda implements Function2<FlowCollector<? super ItemInformationReducer.Action>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ItemInformationReducer.State $state;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ItemInformationReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ItemInformationReducer$build$1$itemRefreshEffect$1(ItemInformationReducer itemInformationReducer, ItemInformationReducer.State state, Continuation<? super ItemInformationReducer$build$1$itemRefreshEffect$1> continuation) {
        super(2, continuation);
        this.this$0 = itemInformationReducer;
        this.$state = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ItemInformationReducer$build$1$itemRefreshEffect$1 itemInformationReducer$build$1$itemRefreshEffect$1 = new ItemInformationReducer$build$1$itemRefreshEffect$1(this.this$0, this.$state, continuation);
        itemInformationReducer$build$1$itemRefreshEffect$1.L$0 = obj;
        return itemInformationReducer$build$1$itemRefreshEffect$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super ItemInformationReducer.Action> flowCollector, Continuation<? super Unit> continuation) {
        return ((ItemInformationReducer$build$1$itemRefreshEffect$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:30:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:33:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:37:0x011d  */
    /* JADX WARN: Code duplicated, block: B:41:0x0144  */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0141, code lost:
    
        if (r0.emit(r12, r11) == r1) goto L40;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            Method dump skipped, instruction units count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.iteminformation.ItemInformationReducer$build$1$itemRefreshEffect$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
