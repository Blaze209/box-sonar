package com.box.android.data.service.impl;

import com.box.android.data.fragment.ItemConnectionEdgesOnlyFragment;
import com.box.android.domain.models.ItemId;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RemoteItemService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/box/android/data/fragment/ItemConnectionEdgesOnlyFragment$Edge;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.service.impl.RemoteItemService$fetchFolderItemsFromRemote$2$originalCachedEdges$1", f = "RemoteItemService.kt", i = {}, l = {453}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class RemoteItemService$fetchFolderItemsFromRemote$2$originalCachedEdges$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends ItemConnectionEdgesOnlyFragment.Edge>>, Object> {
    final /* synthetic */ ItemId.Remote $remoteId;
    int label;
    final /* synthetic */ RemoteItemService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RemoteItemService$fetchFolderItemsFromRemote$2$originalCachedEdges$1(RemoteItemService remoteItemService, ItemId.Remote remote, Continuation<? super RemoteItemService$fetchFolderItemsFromRemote$2$originalCachedEdges$1> continuation) {
        super(2, continuation);
        this.this$0 = remoteItemService;
        this.$remoteId = remote;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RemoteItemService$fetchFolderItemsFromRemote$2$originalCachedEdges$1(this.this$0, this.$remoteId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends ItemConnectionEdgesOnlyFragment.Edge>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<ItemConnectionEdgesOnlyFragment.Edge>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<ItemConnectionEdgesOnlyFragment.Edge>> continuation) {
        return ((RemoteItemService$fetchFolderItemsFromRemote$2$originalCachedEdges$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        Object objGqlFetchEdgesOnlyFromCache = this.this$0.gqlCacheHelper.gqlFetchEdgesOnlyFromCache(this.$remoteId.getBoxId(), this);
        return objGqlFetchEdgesOnlyFromCache == coroutine_suspended ? coroutine_suspended : objGqlFetchEdgesOnlyFromCache;
    }
}
