package com.box.android.data.service.impl;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.utils.result.Result;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: FavoritesService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/ItemId$Remote;", "Lcom/box/android/domain/models/DomainError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.service.impl.FavoritesService$favoriteItemIdsResultFlowFromService$1", f = "FavoritesService.kt", i = {0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {49, 55, 64}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$onSuccess$iv", "allFavoriteItemsFlow", "$i$f$onSuccess", "$i$a$-onSuccess-FavoritesService$favoriteItemIdsResultFlowFromService$1$3", "$this$flow", "$this$onError$iv", "it", "$i$f$onError", "$i$a$-onError-FavoritesService$favoriteItemIdsResultFlowFromService$1$4"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
final class FavoritesService$favoriteItemIdsResultFlowFromService$1 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends Set<? extends ItemId.Remote>, ? extends DomainError>>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ FavoritesService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FavoritesService$favoriteItemIdsResultFlowFromService$1(FavoritesService favoritesService, Continuation<? super FavoritesService$favoriteItemIdsResultFlowFromService$1> continuation) {
        super(2, continuation);
        this.this$0 = favoritesService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FavoritesService$favoriteItemIdsResultFlowFromService$1 favoritesService$favoriteItemIdsResultFlowFromService$1 = new FavoritesService$favoriteItemIdsResultFlowFromService$1(this.this$0, continuation);
        favoritesService$favoriteItemIdsResultFlowFromService$1.L$0 = obj;
        return favoritesService$favoriteItemIdsResultFlowFromService$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends Set<? extends ItemId.Remote>, ? extends DomainError>> flowCollector, Continuation<? super Unit> continuation) {
        return invoke2((FlowCollector<? super Result<? extends Set<ItemId.Remote>, ? extends DomainError>>) flowCollector, continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super Result<? extends Set<ItemId.Remote>, ? extends DomainError>> flowCollector, Continuation<? super Unit> continuation) {
        return ((FavoritesService$favoriteItemIdsResultFlowFromService$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:37:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:40:0x00fa  */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00f7, code lost:
    
        if (r0.emit(r4, r8) == r1) goto L39;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            Method dump skipped, instruction units count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.FavoritesService$favoriteItemIdsResultFlowFromService$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
