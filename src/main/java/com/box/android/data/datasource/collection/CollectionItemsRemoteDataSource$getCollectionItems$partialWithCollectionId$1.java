package com.box.android.data.datasource.collection;

import com.box.android.data.api.models.collections.CollectionItemsDTO;
import com.box.android.data.api.requests.CollectionItemsRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: CollectionItemsRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class CollectionItemsRemoteDataSource$getCollectionItems$partialWithCollectionId$1 extends FunctionReferenceImpl implements Function5<String, String, Integer, String, Continuation<? super CollectionItemsDTO>, Object>, SuspendFunction {
    CollectionItemsRemoteDataSource$getCollectionItems$partialWithCollectionId$1(Object obj) {
        super(5, obj, CollectionItemsRequest.class, "getCollectionItems", "getCollectionItems(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function5
    public final Object invoke(String str, String str2, Integer num, String str3, Continuation<? super CollectionItemsDTO> continuation) {
        return ((CollectionItemsRequest) this.receiver).getCollectionItems(str, str2, num, str3, continuation);
    }
}
