package com.box.android.data.datasource.collection;

import com.apollographql.apollo3.api.ApolloResponse;
import com.box.android.data.GetCollectionItemsQuery;
import com.facebook.react.modules.dialog.AlertFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: GQLCollectionItemsDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.datasource.collection.GQLCollectionItemsDataSource$watchQuery$1$2", f = "GQLCollectionItemsDataSource.kt", i = {0, 0, 0, 0, 0, 1, 1, 1}, l = {69, 73}, m = "emit", n = {"response", "cacheOrNetwork", "it", AlertFragment.ARG_ITEMS, "$i$a$-let-GQLCollectionItemsDataSource$watchQuery$1$2$1", "response", "cacheOrNetwork", "$i$a$-run-GQLCollectionItemsDataSource$watchQuery$1$2$2"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "I$0"}, v = 1)
final class GQLCollectionItemsDataSource$watchQuery$1$2$emit$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GQLCollectionItemsDataSource.C11291.AnonymousClass2<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    GQLCollectionItemsDataSource$watchQuery$1$2$emit$1(GQLCollectionItemsDataSource.C11291.AnonymousClass2<? super T> anonymousClass2, Continuation<? super GQLCollectionItemsDataSource$watchQuery$1$2$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass2;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((ApolloResponse<GetCollectionItemsQuery.Data>) null, (Continuation<? super Unit>) this);
    }
}
