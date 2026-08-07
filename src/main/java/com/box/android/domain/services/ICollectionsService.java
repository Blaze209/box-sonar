package com.box.android.domain.services;

import androidx.paging.DataSource;
import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.utils.result.Result;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: ICollectionsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0004\u0012\u00020\u00070\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fH&J2\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\r\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H¦@¢\u0006\u0002\u0010\u0012J\"\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\u0015\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u0016J*\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u001aJ(\u0010\u001b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001c0\u0004\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\u001d\u001a\u00020\u0019H&J\"\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\u001d\u001a\u00020\u0019H¦@¢\u0006\u0002\u0010\u001fJ*\u0010 \u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010\"J*\u0010#\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010\"J\u0018\u0010$\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019H¦@¢\u0006\u0002\u0010\u001f¨\u0006%À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/ICollectionsService;", "", "getCollections", "Lcom/box/android/domain/utils/result/Result;", "Landroidx/paging/DataSource$Factory;", "", "Lcom/box/android/domain/models/CollectionModel;", "Lcom/box/android/domain/models/DomainError;", "types", "", "Lcom/box/android/domain/models/CollectionType;", "comparator", "Ljava/util/Comparator;", "", "remoteId", "Lcom/box/android/domain/models/ItemId$Remote;", "fetchedAfter", "Ljava/util/Date;", "(Lcom/box/android/domain/models/ItemId$Remote;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchCollectionsFromRemote", "", "type", "(Lcom/box/android/domain/models/CollectionType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createCollection", "name", "", "(Ljava/lang/String;Lcom/box/android/domain/models/CollectionType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gqlGetCollectionItems", "Lcom/box/android/domain/models/item/ItemModel;", BoxItemJob.COLLECTION_ID, "fetchCollectionItemsFromRemote", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addCollectionItem", "", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeCollectionItem", "areCollectionItemsFetched", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ICollectionsService {
    Object addCollectionItem(String str, ItemId.Remote remote, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object areCollectionItemsFetched(String str, Continuation<? super Boolean> continuation);

    Object createCollection(String str, CollectionType collectionType, Continuation<? super Result<CollectionModel, ? extends DomainError>> continuation);

    Object fetchCollectionItemsFromRemote(String str, Continuation<? super Result<Boolean, ? extends DomainError>> continuation);

    Object fetchCollectionsFromRemote(CollectionType collectionType, Continuation<? super Result<Boolean, ? extends DomainError>> continuation);

    Result<DataSource.Factory<Integer, CollectionModel>, DomainError> getCollections(List<? extends CollectionType> types, Comparator<CollectionModel> comparator);

    Object getCollections(ItemId.Remote remote, Date date, Continuation<? super Result<? extends Set<CollectionModel>, ? extends DomainError>> continuation);

    Result<DataSource.Factory<String, ItemModel>, DomainError> gqlGetCollectionItems(String collectionId);

    Object removeCollectionItem(String str, ItemId.Remote remote, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    /* JADX INFO: compiled from: ICollectionsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Result getCollections$default(ICollectionsService iCollectionsService, List list, Comparator comparator, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCollections");
        }
        if ((i & 2) != 0) {
            comparator = null;
        }
        return iCollectionsService.getCollections(list, comparator);
    }

    static /* synthetic */ Object getCollections$default(ICollectionsService iCollectionsService, ItemId.Remote remote, Date date, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCollections");
        }
        if ((i & 2) != 0) {
            date = new Date(0L);
        }
        return iCollectionsService.getCollections(remote, date, continuation);
    }
}
