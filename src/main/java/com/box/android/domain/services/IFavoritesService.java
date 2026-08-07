package com.box.android.domain.services;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.utils.result.Result;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: IFavoritesService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\f\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\rJ\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\f\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\rJ\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u0004H¦@¢\u0006\u0002\u0010\u0010R*\u0010\u0002\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IFavoritesService;", "", "favoriteItemIdsResultFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/ItemId$Remote;", "Lcom/box/android/domain/models/DomainError;", "getFavoriteItemIdsResultFlow", "()Lkotlinx/coroutines/flow/Flow;", "addToFavorites", "", "itemId", "(Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeFromFavorites", "refreshFromRemote", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IFavoritesService {
    Object addToFavorites(ItemId.Remote remote, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Flow<Result<Set<ItemId.Remote>, DomainError>> getFavoriteItemIdsResultFlow();

    Object refreshFromRemote(Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object removeFromFavorites(ItemId.Remote remote, Continuation<? super Result<Unit, ? extends DomainError>> continuation);
}
