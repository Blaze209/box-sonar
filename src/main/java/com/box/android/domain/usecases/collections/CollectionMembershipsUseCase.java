package com.box.android.domain.usecases.collections;

import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.utils.result.Result;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: CollectionMembershipsUseCase.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\tJ0\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH¦@¢\u0006\u0002\u0010\u000fJ0\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH¦@¢\u0006\u0002\u0010\u000f¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/usecases/collections/CollectionMembershipsUseCase;", "", "getCollectionMemberships", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/CollectionModel;", "Lcom/box/android/domain/models/DomainError;", "remoteId", "Lcom/box/android/domain/models/ItemId$Remote;", "(Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addItemToCollections", "", "collectionIds", "", "", "(Lcom/box/android/domain/models/ItemId$Remote;Ljava/lang/Iterable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeItemFromCollections", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface CollectionMembershipsUseCase {
    Object addItemToCollections(ItemId.Remote remote, Iterable<String> iterable, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object getCollectionMemberships(ItemId.Remote remote, Continuation<? super Result<? extends Set<CollectionModel>, ? extends DomainError>> continuation);

    Object removeItemFromCollections(ItemId.Remote remote, Iterable<String> iterable, Continuation<? super Result<Unit, ? extends DomainError>> continuation);
}
