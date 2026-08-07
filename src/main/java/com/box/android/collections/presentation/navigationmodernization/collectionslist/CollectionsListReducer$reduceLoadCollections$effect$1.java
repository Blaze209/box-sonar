package com.box.android.collections.presentation.navigationmodernization.collectionslist;

import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: CollectionsListReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListReducer$reduceLoadCollections$effect$1", f = "CollectionsListReducer.kt", i = {0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3}, l = {100, 102, 119, Token.LOOP}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$onSuccess$iv", "collectionsLiveData", "$i$f$onSuccess", "$i$a$-onSuccess-CollectionsListReducer$reduceLoadCollections$effect$1$1", "$this$flow", "$this$onError$iv", "error", "unwrappedError", "error", "collectionsCacheLiveData", "$i$f$onError", "$i$a$-onError-CollectionsListReducer$reduceLoadCollections$effect$1$2", "$i$a$-let-CollectionsListReducer$reduceLoadCollections$effect$1$2$1", "$this$flow", "$this$onError$iv", "error", "unwrappedError", "error", "$i$f$onError", "$i$a$-onError-CollectionsListReducer$reduceLoadCollections$effect$1$2"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, v = 1)
final class CollectionsListReducer$reduceLoadCollections$effect$1 extends SuspendLambda implements Function2<FlowCollector<? super CollectionsListReducer.Action>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ CollectionsListReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CollectionsListReducer$reduceLoadCollections$effect$1(CollectionsListReducer collectionsListReducer, Continuation<? super CollectionsListReducer$reduceLoadCollections$effect$1> continuation) {
        super(2, continuation);
        this.this$0 = collectionsListReducer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CollectionsListReducer$reduceLoadCollections$effect$1 collectionsListReducer$reduceLoadCollections$effect$1 = new CollectionsListReducer$reduceLoadCollections$effect$1(this.this$0, continuation);
        collectionsListReducer$reduceLoadCollections$effect$1.L$0 = obj;
        return collectionsListReducer$reduceLoadCollections$effect$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super CollectionsListReducer.Action> flowCollector, Continuation<? super Unit> continuation) {
        return ((CollectionsListReducer$reduceLoadCollections$effect$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:29:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:31:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:32:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:34:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:37:0x00df  */
    /* JADX WARN: Code duplicated, block: B:40:0x0119  */
    /* JADX WARN: Code duplicated, block: B:43:0x0147  */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0116, code lost:
    
        if (kotlinx.coroutines.flow.FlowKt.emitAll(r1, r4, r16) == r2) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0144, code lost:
    
        if (r1.emit(r5, r16) == r2) goto L42;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            Method dump skipped, instruction units count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListReducer$reduceLoadCollections$effect$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
