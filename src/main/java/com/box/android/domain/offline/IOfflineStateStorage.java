package com.box.android.domain.offline;

import com.box.android.domain.models.item.ItemType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: IOfflineStateStorage.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0016J \u0010\u0017\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H¦@¢\u0006\u0002\u0010\u0019J&\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\u001eJ\u001e\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0016J\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\"H¦@¢\u0006\u0002\u0010#J\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\"H¦@¢\u0006\u0002\u0010#J\u000e\u0010%\u001a\u00020\rH¦@¢\u0006\u0002\u0010#¨\u0006&À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/offline/IOfflineStateStorage;", "", "isUserSaved", "", "itemId", "", "itemType", "Lcom/box/android/domain/models/item/ItemType;", "(Ljava/lang/String;Lcom/box/android/domain/models/item/ItemType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isUserRemoved", "getCompletedDate", "", "removeOfflinedItem", "", "observeState", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/offline/OfflineStateModel;", "getFileSha1", "fileId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setFileOfflineUserSaved", "userSaved", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setFileOfflineSavedCompleted", "sha1", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setFolderOfflineSavedStarted", "folderId", "savedForOffline", "startedDate", "(Ljava/lang/String;ZJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setFolderOfflineSavedCompleted", "savedOffline", "fetchUserOfflinedFileIds", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchUserOfflinedFolderIds", "clearOfflineInformation", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IOfflineStateStorage {
    Object clearOfflineInformation(Continuation<? super Unit> continuation);

    Object fetchUserOfflinedFileIds(Continuation<? super List<String>> continuation);

    Object fetchUserOfflinedFolderIds(Continuation<? super List<String>> continuation);

    Object getCompletedDate(String str, ItemType itemType, Continuation<? super Long> continuation);

    Object getFileSha1(String str, Continuation<? super String> continuation);

    Object isUserRemoved(String str, ItemType itemType, Continuation<? super Boolean> continuation);

    Object isUserSaved(String str, ItemType itemType, Continuation<? super Boolean> continuation);

    Flow<OfflineStateModel> observeState(String itemId, ItemType itemType);

    Object removeOfflinedItem(String str, ItemType itemType, Continuation<? super Unit> continuation);

    Object setFileOfflineSavedCompleted(String str, String str2, Continuation<? super Unit> continuation);

    Object setFileOfflineUserSaved(String str, boolean z, Continuation<? super Unit> continuation);

    Object setFolderOfflineSavedCompleted(String str, boolean z, Continuation<? super Boolean> continuation);

    Object setFolderOfflineSavedStarted(String str, boolean z, long j, Continuation<? super Unit> continuation);
}
