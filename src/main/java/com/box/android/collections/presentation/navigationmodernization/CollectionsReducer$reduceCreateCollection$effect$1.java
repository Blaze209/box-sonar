package com.box.android.collections.presentation.navigationmodernization;

import com.box.androidsdk.content.models.BoxCollection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: CollectionsReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.collections.presentation.navigationmodernization.CollectionsReducer$reduceCreateCollection$effect$1", f = "CollectionsReducer.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {109, 112}, m = "invokeSuspend", n = {"$this$flow", "$this$onSuccess$iv", BoxCollection.TYPE, "$i$f$onSuccess", "$i$a$-onSuccess-CollectionsReducer$reduceCreateCollection$effect$1$1", "$this$flow", "$this$onError$iv", "error", "$i$f$onError", "$i$a$-onError-CollectionsReducer$reduceCreateCollection$effect$1$2"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
final class CollectionsReducer$reduceCreateCollection$effect$1 extends SuspendLambda implements Function2<FlowCollector<? super CollectionsReducer.Action>, Continuation<? super Unit>, Object> {
    final /* synthetic */ CollectionsReducer.Action.CreateCollection $action;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ CollectionsReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CollectionsReducer$reduceCreateCollection$effect$1(CollectionsReducer collectionsReducer, CollectionsReducer.Action.CreateCollection createCollection, Continuation<? super CollectionsReducer$reduceCreateCollection$effect$1> continuation) {
        super(2, continuation);
        this.this$0 = collectionsReducer;
        this.$action = createCollection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CollectionsReducer$reduceCreateCollection$effect$1 collectionsReducer$reduceCreateCollection$effect$1 = new CollectionsReducer$reduceCreateCollection$effect$1(this.this$0, this.$action, continuation);
        collectionsReducer$reduceCreateCollection$effect$1.L$0 = obj;
        return collectionsReducer$reduceCreateCollection$effect$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super CollectionsReducer.Action> flowCollector, Continuation<? super Unit> continuation) {
        return ((CollectionsReducer$reduceCreateCollection$effect$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ae, code lost:
    
        if (r0.emit(r6, r7) == r1) goto L23;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.L$0
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r7.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L34
            if (r2 == r4) goto L28
            if (r2 != r3) goto L20
            java.lang.Object r0 = r7.L$2
            com.box.android.domain.models.DomainError r0 = (com.box.android.domain.models.DomainError) r0
            java.lang.Object r7 = r7.L$1
            com.box.android.domain.utils.result.Result r7 = (com.box.android.domain.utils.result.Result) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto Lb7
        L20:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L28:
            java.lang.Object r2 = r7.L$2
            com.box.android.domain.models.CollectionModel r2 = (com.box.android.domain.models.CollectionModel) r2
            java.lang.Object r2 = r7.L$1
            com.box.android.domain.utils.result.Result r2 = (com.box.android.domain.utils.result.Result) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L7a
        L34:
            kotlin.ResultKt.throwOnFailure(r8)
            com.box.android.collections.presentation.navigationmodernization.CollectionsReducer r8 = r7.this$0
            com.box.android.collections.presentation.navigationmodernization.CollectionsEnvironment r8 = com.box.android.collections.presentation.navigationmodernization.CollectionsReducer.access$getEnvironment$p(r8)
            com.box.android.domain.usecases.collections.CreateCollectionInteractor r8 = r8.getCreateCollectionUseCase()
            com.box.android.collections.presentation.navigationmodernization.CollectionsReducer$Action$CreateCollection r2 = r7.$action
            java.lang.String r2 = r2.getName()
            com.box.android.domain.models.CollectionType r6 = com.box.android.domain.models.CollectionType.PERSONAL
            com.box.android.domain.utils.result.Result r2 = r8.createCollection(r2, r6)
            boolean r8 = r2 instanceof com.box.android.domain.utils.result.Result.Success
            if (r8 == 0) goto L76
            r8 = r2
            com.box.android.domain.utils.result.Result$Success r8 = (com.box.android.domain.utils.result.Result.Success) r8
            java.lang.Object r8 = r8.getValue()
            com.box.android.domain.models.CollectionModel r8 = (com.box.android.domain.models.CollectionModel) r8
            com.box.android.collections.presentation.navigationmodernization.CollectionsReducer$Action$CollectionCreated r6 = new com.box.android.collections.presentation.navigationmodernization.CollectionsReducer$Action$CollectionCreated
            r6.<init>(r8)
            r7.L$0 = r0
            r7.L$1 = r2
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r7.L$2 = r8
            r7.I$0 = r5
            r7.I$1 = r5
            r7.label = r4
            java.lang.Object r8 = r0.emit(r6, r7)
            if (r8 != r1) goto L7a
            goto Lb0
        L76:
            boolean r8 = r2 instanceof com.box.android.domain.utils.result.Result.Error
            if (r8 == 0) goto Lba
        L7a:
            com.box.android.collections.presentation.navigationmodernization.CollectionsReducer$Action$CreateCollection r8 = r7.$action
            boolean r4 = r2 instanceof com.box.android.domain.utils.result.Result.Success
            if (r4 != 0) goto Lb7
            boolean r4 = r2 instanceof com.box.android.domain.utils.result.Result.Error
            if (r4 == 0) goto Lb1
            r4 = r2
            com.box.android.domain.utils.result.Result$Error r4 = (com.box.android.domain.utils.result.Result.Error) r4
            java.lang.Object r4 = r4.getValue()
            com.box.android.domain.models.DomainError r4 = (com.box.android.domain.models.DomainError) r4
            com.box.android.collections.presentation.navigationmodernization.CollectionsReducer$Action$CollectionCreationFailed r6 = new com.box.android.collections.presentation.navigationmodernization.CollectionsReducer$Action$CollectionCreationFailed
            java.lang.String r8 = r8.getName()
            r6.<init>(r4, r8)
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r7.L$0 = r8
            r7.L$1 = r2
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r7.L$2 = r8
            r7.I$0 = r5
            r7.I$1 = r5
            r7.label = r3
            java.lang.Object r7 = r0.emit(r6, r7)
            if (r7 != r1) goto Lb7
        Lb0:
            return r1
        Lb1:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        Lb7:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        Lba:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.collections.presentation.navigationmodernization.CollectionsReducer$reduceCreateCollection$effect$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
