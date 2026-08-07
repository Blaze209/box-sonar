package com.box.android.collections.presentation.viewmodel;

import androidx.lifecycle.LiveDataScope;
import androidx.paging.PagedList;
import com.box.android.domain.models.CollectionModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: MyCollectionsViewModel.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/lifecycle/LiveDataScope;", "Landroidx/paging/PagedList;", "Lcom/box/android/domain/models/CollectionModel;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.collections.presentation.viewmodel.MyCollectionsViewModel$collectionsLiveData$1", f = "MyCollectionsViewModel.kt", i = {0, 1, 1, 1}, l = {34, 34}, m = "invokeSuspend", n = {"$this$liveData", "$this$liveData", "it", "$i$a$-let-MyCollectionsViewModel$collectionsLiveData$1$1"}, s = {"L$0", "L$0", "L$1", "I$0"}, v = 1)
final class MyCollectionsViewModel$collectionsLiveData$1 extends SuspendLambda implements Function2<LiveDataScope<PagedList<CollectionModel>>, Continuation<? super Unit>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MyCollectionsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MyCollectionsViewModel$collectionsLiveData$1(MyCollectionsViewModel myCollectionsViewModel, Continuation<? super MyCollectionsViewModel$collectionsLiveData$1> continuation) {
        super(2, continuation);
        this.this$0 = myCollectionsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MyCollectionsViewModel$collectionsLiveData$1 myCollectionsViewModel$collectionsLiveData$1 = new MyCollectionsViewModel$collectionsLiveData$1(this.this$0, continuation);
        myCollectionsViewModel$collectionsLiveData$1.L$0 = obj;
        return myCollectionsViewModel$collectionsLiveData$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(LiveDataScope<PagedList<CollectionModel>> liveDataScope, Continuation<? super Unit> continuation) {
        return ((MyCollectionsViewModel$collectionsLiveData$1) create(liveDataScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            com.box.android.collections.presentation.viewmodel.MyCollectionsViewModel r6 = r5.this$0
            r2 = r5
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r5.L$0 = r0
            r5.label = r4
            java.lang.Object r6 = com.box.android.collections.presentation.viewmodel.MyCollectionsViewModel.access$getLiveData(r6, r2)
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
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.collections.presentation.viewmodel.MyCollectionsViewModel$collectionsLiveData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
