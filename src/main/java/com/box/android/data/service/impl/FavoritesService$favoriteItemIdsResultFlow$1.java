package com.box.android.data.service.impl;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.utils.result.Result;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: FavoritesService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u00012\u0018\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/ItemId$Remote;", "Lcom/box/android/domain/models/DomainError;", "favoriteIdsResult", "pendingStates", "", "Lcom/box/android/data/service/impl/FavoritesService$PendingFavoriteState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.service.impl.FavoritesService$favoriteItemIdsResultFlow$1", f = "FavoritesService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class FavoritesService$favoriteItemIdsResultFlow$1 extends SuspendLambda implements Function3<Result<? extends Set<? extends ItemId.Remote>, ? extends DomainError>, Map<ItemId.Remote, ? extends FavoritesService.PendingFavoriteState>, Continuation<? super Result<? extends Set<? extends ItemId.Remote>, ? extends DomainError>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    FavoritesService$favoriteItemIdsResultFlow$1(Continuation<? super FavoritesService$favoriteItemIdsResultFlow$1> continuation) {
        super(3, continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Result<? extends Set<ItemId.Remote>, ? extends DomainError> result, Map<ItemId.Remote, FavoritesService.PendingFavoriteState> map, Continuation<? super Result<? extends Set<ItemId.Remote>, ? extends DomainError>> continuation) {
        FavoritesService$favoriteItemIdsResultFlow$1 favoritesService$favoriteItemIdsResultFlow$1 = new FavoritesService$favoriteItemIdsResultFlow$1(continuation);
        favoritesService$favoriteItemIdsResultFlow$1.L$0 = result;
        favoritesService$favoriteItemIdsResultFlow$1.L$1 = map;
        return favoritesService$favoriteItemIdsResultFlow$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Result<? extends Set<? extends ItemId.Remote>, ? extends DomainError> result, Map<ItemId.Remote, ? extends FavoritesService.PendingFavoriteState> map, Continuation<? super Result<? extends Set<? extends ItemId.Remote>, ? extends DomainError>> continuation) {
        return invoke2((Result<? extends Set<ItemId.Remote>, ? extends DomainError>) result, (Map<ItemId.Remote, FavoritesService.PendingFavoriteState>) map, (Continuation<? super Result<? extends Set<ItemId.Remote>, ? extends DomainError>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Result result = (Result) this.L$0;
        Map map = (Map) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (result instanceof Result.Success) {
            Set set = (Set) ((Result.Success) result).getValue();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (((FavoritesService.PendingFavoriteState) entry.getValue()).isFavorite()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap2 = linkedHashMap;
            ArrayList arrayList = new ArrayList(linkedHashMap2.size());
            Iterator it = linkedHashMap2.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add((ItemId.Remote) ((Map.Entry) it.next()).getKey());
            }
            Set setPlus = SetsKt.plus(set, (Iterable) CollectionsKt.toSet(arrayList));
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry entry2 : map.entrySet()) {
                if (!((FavoritesService.PendingFavoriteState) entry2.getValue()).isFavorite()) {
                    linkedHashMap3.put(entry2.getKey(), entry2.getValue());
                }
            }
            LinkedHashMap linkedHashMap4 = linkedHashMap3;
            ArrayList arrayList2 = new ArrayList(linkedHashMap4.size());
            Iterator it2 = linkedHashMap4.entrySet().iterator();
            while (it2.hasNext()) {
                arrayList2.add((ItemId.Remote) ((Map.Entry) it2.next()).getKey());
            }
            return new Result.Success(SetsKt.minus(setPlus, (Iterable) CollectionsKt.toSet(arrayList2)));
        }
        if (result instanceof Result.Error) {
            return result;
        }
        throw new NoWhenBranchMatchedException();
    }
}
