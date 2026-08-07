package com.box.android.domain.usecases.collections;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.utils.result.Result;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: ListCollectionItemsUseCase.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a \u0012\u001c\u0012\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0004\u0012\u00020\b0\u00040\u00032\u0006\u0010\t\u001a\u00020\nH¦\u0002J8\u0010\u000b\u001a \u0012\u001c\u0012\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0004\u0012\u00020\b0\u00040\u00032\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\rH&¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/usecases/collections/ListCollectionItemsUseCase;", "", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;", BoxItemJob.COLLECTION_ID, "", "listCollectionItems", "pageSize", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ListCollectionItemsUseCase {
    Flow<Result<LiveData<PagedList<ItemModel>>, DomainError>> invoke(String collectionId);

    Flow<Result<LiveData<PagedList<ItemModel>>, DomainError>> listCollectionItems(String collectionId, int pageSize);

    /* JADX INFO: compiled from: ListCollectionItemsUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Flow listCollectionItems$default(ListCollectionItemsUseCase listCollectionItemsUseCase, String str, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listCollectionItems");
        }
        if ((i2 & 2) != 0) {
            i = 10;
        }
        return listCollectionItemsUseCase.listCollectionItems(str, i);
    }
}
