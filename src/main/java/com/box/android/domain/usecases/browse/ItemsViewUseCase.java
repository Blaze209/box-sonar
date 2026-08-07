package com.box.android.domain.usecases.browse;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.utils.result.Result;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: FolderViewUseCase.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u00040\u00032\u0006\u0010\b\u001a\u00020\tH&J\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\fJ(\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\f¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/usecases/browse/ItemsViewUseCase;", "", "fetchItems", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;", "folderId", "Lcom/box/android/domain/models/ItemId$Remote;", "refreshFromRemote", "", "(Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchItemsFromLegacyCache", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ItemsViewUseCase {
    Flow<Result<List<ItemModel>, DomainError>> fetchItems(ItemId.Remote folderId);

    Object fetchItemsFromLegacyCache(ItemId.Remote remote, Continuation<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>> continuation);

    Object refreshFromRemote(ItemId.Remote remote, Continuation<? super Result<Unit, ? extends DomainError>> continuation);
}
