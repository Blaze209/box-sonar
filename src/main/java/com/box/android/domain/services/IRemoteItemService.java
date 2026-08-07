package com.box.android.domain.services;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.configuration.DataPolicy;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.utils.result.Result;
import com.facebook.react.modules.dialog.AlertFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: IRemoteItemService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ(\u0010\u000b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\r\u0012\u0004\u0012\u00020\u00050\u00030\f2\u0006\u0010\u000e\u001a\u00020\u0007H&J\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\u0011J2\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H¦@¢\u0006\u0002\u0010\u0016J(\u0010\u0017\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\r\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0018\u001a\u00020\u0019H¦@¢\u0006\u0002\u0010\u001aJ*\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\u001eJ2\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0019H¦@¢\u0006\u0002\u0010\"J2\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0019H¦@¢\u0006\u0002\u0010\"J\"\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010%\u001a\u00020&H¦@¢\u0006\u0002\u0010'J*\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010%\u001a\u00020&2\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010)¨\u0006*À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IRemoteItemService;", "Lcom/box/android/domain/services/IItemService;", "item", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;", "remoteId", "Lcom/box/android/domain/models/ItemId$Remote;", "dataPolicy", "Lcom/box/android/domain/configuration/DataPolicy;", "(Lcom/box/android/domain/models/ItemId$Remote;Lcom/box/android/domain/configuration/DataPolicy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", AlertFragment.ARG_ITEMS, "Lkotlinx/coroutines/flow/Flow;", "", "folderRemoteId", "fetchFolderItemsFromRemote", "", "(Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "folderMini", "Lcom/box/android/domain/models/item/FolderModel;", "includeParent", "", "(Lcom/box/android/domain/models/ItemId$Remote;Lcom/box/android/domain/configuration/DataPolicy;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchItemsFromLegacyCache", "folderId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createFolder", "name", "parentRemoteId", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_MOVE_JOB, "destinationRemoteId", "itemName", "(Lcom/box/android/domain/models/ItemId$Remote;Lcom/box/android/domain/models/ItemId$Remote;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "updateCacheItemFromRemote", "itemId", "Lcom/box/android/domain/models/ItemId;", "(Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "itemWithWatermarkData", "(Lcom/box/android/domain/models/ItemId;Lcom/box/android/domain/configuration/DataPolicy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IRemoteItemService extends IItemService {
    Object copy(ItemId.Remote remote, ItemId.Remote remote2, String str, Continuation<? super Result<? extends ItemModel, ? extends DomainError>> continuation);

    Object createFolder(String str, ItemId.Remote remote, Continuation<? super Result<FolderModel, ? extends DomainError>> continuation);

    Object fetchFolderItemsFromRemote(ItemId.Remote remote, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object fetchItemsFromLegacyCache(String str, Continuation<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>> continuation);

    Object folderMini(ItemId.Remote remote, DataPolicy dataPolicy, boolean z, Continuation<? super Result<FolderModel, ? extends DomainError>> continuation);

    Object item(ItemId.Remote remote, DataPolicy dataPolicy, Continuation<? super Result<? extends ItemModel, ? extends DomainError>> continuation);

    Object itemWithWatermarkData(ItemId itemId, DataPolicy dataPolicy, Continuation<? super Result<? extends ItemModel, ? extends DomainError>> continuation);

    Flow<Result<List<ItemModel>, DomainError>> items(ItemId.Remote folderRemoteId);

    Object move(ItemId.Remote remote, ItemId.Remote remote2, String str, Continuation<? super Result<? extends ItemModel, ? extends DomainError>> continuation);

    Object updateCacheItemFromRemote(ItemId itemId, Continuation<? super Result<Unit, ? extends DomainError>> continuation);
}
