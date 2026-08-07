package com.box.android.data.service.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: CollectionsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.service.impl.CollectionsService", f = "CollectionsService.kt", i = {}, l = {185}, m = "gqlFetchAllCollections$data_generalProdRelease", n = {}, s = {}, v = 1)
final class CollectionsService$gqlFetchAllCollections$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CollectionsService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CollectionsService$gqlFetchAllCollections$1(CollectionsService collectionsService, Continuation<? super CollectionsService$gqlFetchAllCollections$1> continuation) {
        super(continuation);
        this.this$0 = collectionsService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.gqlFetchAllCollections$data_generalProdRelease(this);
    }
}
