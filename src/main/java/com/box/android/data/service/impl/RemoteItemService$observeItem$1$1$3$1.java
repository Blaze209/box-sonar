package com.box.android.data.service.impl;

import com.apollographql.apollo3.api.ApolloResponse;
import com.box.android.data.GetItemQuery;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.utils.result.Result;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: RemoteItemService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final class RemoteItemService$observeItem$1$1$3$1<T> implements FlowCollector {
    final /* synthetic */ FlowCollector<Result<? extends ItemModel, ? extends DomainError>> $$this$flow;
    final /* synthetic */ ItemId.Remote $remoteId;

    /* JADX WARN: Multi-variable type inference failed */
    RemoteItemService$observeItem$1$1$3$1(FlowCollector<? super Result<? extends ItemModel, ? extends DomainError>> flowCollector, ItemId.Remote remote) {
        this.$$this$flow = flowCollector;
        this.$remoteId = remote;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0076, code lost:
    
        if (r8.emit(r5, r0) == r1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b1, code lost:
    
        if (r10.emit(r3, r0) == r1) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object emit(com.apollographql.apollo3.api.ApolloResponse<com.box.android.data.GetItemQuery.Data> r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.box.android.data.service.impl.RemoteItemService$observeItem$1$1$3$1$emit$1
            if (r0 == 0) goto L14
            r0 = r10
            com.box.android.data.service.impl.RemoteItemService$observeItem$1$1$3$1$emit$1 r0 = (com.box.android.data.service.impl.RemoteItemService$observeItem$1$1$3$1$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.box.android.data.service.impl.RemoteItemService$observeItem$1$1$3$1$emit$1 r0 = new com.box.android.data.service.impl.RemoteItemService$observeItem$1$1$3$1$emit$1
            r0.<init>(r8, r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L48
            if (r2 == r3) goto L3a
            if (r2 != r4) goto L32
            java.lang.Object r8 = r0.L$0
            com.apollographql.apollo3.api.ApolloResponse r8 = (com.apollographql.apollo3.api.ApolloResponse) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto Lb4
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3a:
            int r8 = r0.I$0
            java.lang.Object r8 = r0.L$1
            com.box.android.data.GetItemQuery$Data r8 = (com.box.android.data.GetItemQuery.Data) r8
            java.lang.Object r8 = r0.L$0
            com.apollographql.apollo3.api.ApolloResponse r8 = (com.apollographql.apollo3.api.ApolloResponse) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L79
        L48:
            kotlin.ResultKt.throwOnFailure(r10)
            D extends com.apollographql.apollo3.api.Operation$Data r10 = r9.data
            com.box.android.data.GetItemQuery$Data r10 = (com.box.android.data.GetItemQuery.Data) r10
            r2 = 0
            if (r10 == 0) goto L7c
            kotlinx.coroutines.flow.FlowCollector<com.box.android.domain.utils.result.Result<? extends com.box.android.domain.models.item.ItemModel, ? extends com.box.android.domain.models.DomainError>> r8 = r8.$$this$flow
            com.box.android.domain.utils.result.Result$Success r5 = new com.box.android.domain.utils.result.Result$Success
            com.box.android.data.mappers.GQLGetItemQueryDataToItemModelMapper r6 = com.box.android.data.mappers.GQLGetItemQueryDataToItemModelMapper.INSTANCE
            com.box.android.data.mappers.GraphQLMapper r6 = (com.box.android.data.mappers.GraphQLMapper) r6
            java.lang.Object r2 = com.box.android.data.mappers.GraphQLMapper.fromGraphQL$default(r6, r10, r2, r4, r2)
            r5.<init>(r2)
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$0 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r0.L$1 = r9
            r9 = 0
            r0.I$0 = r9
            r0.label = r3
            java.lang.Object r8 = r8.emit(r5, r0)
            if (r8 != r1) goto L79
            goto Lb3
        L79:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L7c:
            kotlinx.coroutines.flow.FlowCollector<com.box.android.domain.utils.result.Result<? extends com.box.android.domain.models.item.ItemModel, ? extends com.box.android.domain.models.DomainError>> r10 = r8.$$this$flow
            com.box.android.domain.utils.result.Result$Error r3 = new com.box.android.domain.utils.result.Result$Error
            com.box.android.domain.models.DomainError$UnknownError r5 = new com.box.android.domain.models.DomainError$UnknownError
            com.box.android.domain.models.ItemId$Remote r8 = r8.$remoteId
            java.lang.String r8 = r8.getBoxId()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "GraphQL response for item with id "
            r6.<init>(r7)
            java.lang.StringBuilder r8 = r6.append(r8)
            java.lang.String r6 = " is null"
            java.lang.StringBuilder r8 = r8.append(r6)
            java.lang.String r8 = r8.toString()
            r5.<init>(r8)
            r3.<init>(r5)
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$0 = r8
            r0.L$1 = r2
            r0.label = r4
            java.lang.Object r8 = r10.emit(r3, r0)
            if (r8 != r1) goto Lb4
        Lb3:
            return r1
        Lb4:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.RemoteItemService$observeItem$1$1$3$1.emit(com.apollographql.apollo3.api.ApolloResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return emit((ApolloResponse<GetItemQuery.Data>) obj, (Continuation<? super Unit>) continuation);
    }
}
