package com.box.android.collections.presentation.viewmodel;

import androidx.lifecycle.LiveDataScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: CollectionItemsViewModel.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/lifecycle/LiveDataScope;", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.collections.presentation.viewmodel.CollectionItemsViewModel$collectionNameLiveData$1", f = "CollectionItemsViewModel.kt", i = {0, 1, 1, 1}, l = {59, 59}, m = "invokeSuspend", n = {"$this$liveData", "$this$liveData", "it", "$i$a$-let-CollectionItemsViewModel$collectionNameLiveData$1$1"}, s = {"L$0", "L$0", "L$1", "I$0"}, v = 1)
final class CollectionItemsViewModel$collectionNameLiveData$1 extends SuspendLambda implements Function2<LiveDataScope<String>, Continuation<? super Unit>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ CollectionItemsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CollectionItemsViewModel$collectionNameLiveData$1(CollectionItemsViewModel collectionItemsViewModel, Continuation<? super CollectionItemsViewModel$collectionNameLiveData$1> continuation) {
        super(2, continuation);
        this.this$0 = collectionItemsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CollectionItemsViewModel$collectionNameLiveData$1 collectionItemsViewModel$collectionNameLiveData$1 = new CollectionItemsViewModel$collectionNameLiveData$1(this.this$0, continuation);
        collectionItemsViewModel$collectionNameLiveData$1.L$0 = obj;
        return collectionItemsViewModel$collectionNameLiveData$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(LiveDataScope<String> liveDataScope, Continuation<? super Unit> continuation) {
        return ((CollectionItemsViewModel$collectionNameLiveData$1) create(liveDataScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0052, code lost:
    
        if (r0.emitSource(r6, r5) == r1) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.L$0
            androidx.lifecycle.LiveDataScope r0 = (androidx.lifecycle.LiveDataScope) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r5.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L26
            if (r2 == r4) goto L22
            if (r2 != r3) goto L1a
            java.lang.Object r5 = r5.L$1
            androidx.lifecycle.LiveData r5 = (androidx.lifecycle.LiveData) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L55
        L1a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L22:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L39
        L26:
            kotlin.ResultKt.throwOnFailure(r6)
            com.box.android.collections.presentation.viewmodel.CollectionItemsViewModel r6 = r5.this$0
            r2 = r5
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r5.L$0 = r0
            r5.label = r4
            java.lang.Object r6 = com.box.android.collections.presentation.viewmodel.CollectionItemsViewModel.access$getCollectionNameLiveData(r6, r2)
            if (r6 != r1) goto L39
            goto L54
        L39:
            androidx.lifecycle.LiveData r6 = (androidx.lifecycle.LiveData) r6
            if (r6 == 0) goto L55
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r5.L$0 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r5.L$1 = r2
            r2 = 0
            r5.I$0 = r2
            r5.label = r3
            java.lang.Object r5 = r0.emitSource(r6, r5)
            if (r5 != r1) goto L55
        L54:
            return r1
        L55:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.collections.presentation.viewmodel.CollectionItemsViewModel$collectionNameLiveData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
