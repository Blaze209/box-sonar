package com.box.android.preview.iteminformation;

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
@DebugMetadata(c = "com.box.android.preview.iteminformation.ItemInformationReducer$build$1$3", f = "ItemInformationReducer.kt", i = {0, 1, 1, 1, 2, 2}, l = {226, 229, 231}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "templates", "templatesMap", "$this$flow", "templates"}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1"}, v = 1)
final class ItemInformationReducer$build$1$3 extends SuspendLambda implements Function2<FlowCollector<? super ItemInformationReducer.Action>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ItemInformationReducer.State $state;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ItemInformationReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ItemInformationReducer$build$1$3(ItemInformationReducer itemInformationReducer, ItemInformationReducer.State state, Continuation<? super ItemInformationReducer$build$1$3> continuation) {
        super(2, continuation);
        this.this$0 = itemInformationReducer;
        this.$state = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ItemInformationReducer$build$1$3 itemInformationReducer$build$1$3 = new ItemInformationReducer$build$1$3(this.this$0, this.$state, continuation);
        itemInformationReducer$build$1$3.L$0 = obj;
        return itemInformationReducer$build$1$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super ItemInformationReducer.Action> flowCollector, Continuation<? super Unit> continuation) {
        return ((ItemInformationReducer$build$1$3) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00bd A[PHI: r2
      0x00bd: PHI (r2v5 java.util.List) = (r2v4 java.util.List), (r2v4 java.util.List), (r2v11 java.util.List) binds: [B:16:0x005d, B:22:0x00ba, B:10:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00e4, code lost:
    
        if (r0.emit(new com.box.android.preview.iteminformation.ItemInformationReducer.Action.FetchMetadata(r9.$state.getItemModel().getItemId()), r9) == r1) goto L26;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.iteminformation.ItemInformationReducer$build$1$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
