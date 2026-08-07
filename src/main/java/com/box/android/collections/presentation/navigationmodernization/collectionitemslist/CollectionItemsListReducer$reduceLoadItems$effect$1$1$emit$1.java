package com.box.android.collections.presentation.navigationmodernization.collectionitemslist;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.utils.result.Result;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: CollectionItemsListReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListReducer$reduceLoadItems$effect$1$1", f = "CollectionItemsListReducer.kt", i = {0, 0, 0, 0, 0}, l = {204}, m = "emit", n = {ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$onError$iv", "error", "$i$f$onError", "$i$a$-onError-CollectionItemsListReducer$reduceLoadItems$effect$1$1$2"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
final class CollectionItemsListReducer$reduceLoadItems$effect$1$1$emit$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CollectionItemsListReducer$reduceLoadItems$effect$1.AnonymousClass1<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CollectionItemsListReducer$reduceLoadItems$effect$1$1$emit$1(CollectionItemsListReducer$reduceLoadItems$effect$1.AnonymousClass1<? super T> anonymousClass1, Continuation<? super CollectionItemsListReducer$reduceLoadItems$effect$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass1;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((Result<? extends LiveData<PagedList<ItemModel>>, DomainError.CachedDomainError<LiveData<PagedList<ItemModel>>>>) null, (Continuation<? super Unit>) this);
    }
}
