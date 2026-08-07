package com.box.android.data.service.impl;

import com.apollographql.apollo3.api.ApolloResponse;
import com.box.android.data.GetItemQuery;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: RemoteItemService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService$observeItem$1$1$3$1", f = "RemoteItemService.kt", i = {0, 0, 0, 1}, l = {201, 208}, m = "emit", n = {"response", "getItemQueryData", "$i$a$-let-RemoteItemService$observeItem$1$1$3$1$1", "response"}, s = {"L$0", "L$1", "I$0", "L$0"}, v = 1)
final class RemoteItemService$observeItem$1$1$3$1$emit$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RemoteItemService$observeItem$1$1$3$1<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    RemoteItemService$observeItem$1$1$3$1$emit$1(RemoteItemService$observeItem$1$1$3$1<? super T> remoteItemService$observeItem$1$1$3$1, Continuation<? super RemoteItemService$observeItem$1$1$3$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = remoteItemService$observeItem$1$1$3$1;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((ApolloResponse<GetItemQuery.Data>) null, (Continuation<? super Unit>) this);
    }
}
