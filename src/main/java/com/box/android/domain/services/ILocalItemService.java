package com.box.android.domain.services;

import android.net.Uri;
import com.box.android.domain.jobs.JobConstants;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.usecases.jobs.JobTags;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.auth.OAuthActivity;
import com.facebook.react.modules.dialog.AlertFragment;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: ILocalItemService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ*\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\rJ*\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\rJB\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014H¦@¢\u0006\u0002\u0010\u0015J\\\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0007H¦@¢\u0006\u0002\u0010\u001bJ\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00050\u0003H¦@¢\u0006\u0002\u0010\u001eJ4\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u0012H¦@¢\u0006\u0002\u0010 J2\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H¦@¢\u0006\u0002\u0010 J8\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020'H¦@¢\u0006\u0002\u0010(J:\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$2\b\b\u0002\u0010*\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'H¦@¢\u0006\u0002\u0010+J*\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010.J$\u0010/\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ\"\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ*\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010.J\"\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ\u001e\u00103\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u000bH¦@¢\u0006\u0002\u00105J:\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014H¦@¢\u0006\u0002\u00108J:\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014H¦@¢\u0006\u0002\u00108¨\u0006:À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/ILocalItemService;", "Lcom/box/android/domain/services/IItemService;", "getItemByLocalId", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;", "itemId", "Lcom/box/android/domain/models/ItemId;", "(Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getItem", "name", "", IdentificationData.FIELD_PARENT_ID, "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createFolder", "Lcom/box/android/domain/models/item/FolderModel;", "uploadFolder", "contentUrl", "Landroid/net/Uri;", "tags", "", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId;Landroid/net/Uri;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadFile", "Lcom/box/android/domain/models/item/FileModel;", JobConstants.SHOW_NOTIFICATION, "", "fileId", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId;Landroid/net/Uri;Ljava/util/Set;ZLcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initiateAutoUpload", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createLocalFile", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createLocalFolder", "enqueueDownloadJobForItems", AlertFragment.ARG_ITEMS, "", "targetFolderUrl", "jobSource", "Lcom/box/android/domain/usecases/jobs/JobTags$JobSource;", "(Ljava/util/List;Ljava/lang/String;Lcom/box/android/domain/usecases/jobs/JobTags$JobSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enqueueMarkOfflineJobForItems", "downloadOriginal", "(Ljava/util/List;ZLcom/box/android/domain/usecases/jobs/JobTags$JobSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setServerId", "serverId", "(Lcom/box/android/domain/models/ItemId;Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getContentUrl", "cleanup", "setParentFolderId", "deleteFile", "deleteCollaboration", OAuthActivity.USER_ID, "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "moveItem", "destinationFolderId", "(Lcom/box/android/domain/models/ItemId;Lcom/box/android/domain/models/ItemId;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyItem", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ILocalItemService extends IItemService {
    Object cleanup(ItemId itemId, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object copyItem(ItemId itemId, ItemId itemId2, Set<String> set, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object createFolder(String str, ItemId itemId, Continuation<? super Result<FolderModel, ? extends DomainError>> continuation);

    Object createLocalFile(String str, ItemId itemId, Uri uri, Continuation<? super Result<FileModel, ? extends DomainError>> continuation);

    Object createLocalFolder(String str, ItemId itemId, Uri uri, Continuation<? super Result<FolderModel, ? extends DomainError>> continuation);

    Object deleteCollaboration(ItemId itemId, String str, Continuation<? super Unit> continuation);

    Object deleteFile(ItemId itemId, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object enqueueDownloadJobForItems(List<? extends ItemModel> list, String str, JobTags.JobSource jobSource, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object enqueueMarkOfflineJobForItems(List<? extends ItemModel> list, boolean z, JobTags.JobSource jobSource, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object getContentUrl(ItemId itemId, Continuation<? super Result<String, ? extends DomainError>> continuation);

    Object getItem(String str, ItemId itemId, Continuation<? super Result<? extends ItemModel, ? extends DomainError>> continuation);

    Object getItemByLocalId(ItemId itemId, Continuation<? super Result<? extends ItemModel, ? extends DomainError>> continuation);

    Object initiateAutoUpload(Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object moveItem(ItemId itemId, ItemId itemId2, Set<String> set, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object setParentFolderId(ItemId itemId, ItemId itemId2, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object setServerId(ItemId itemId, ItemId itemId2, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object uploadFile(String str, ItemId itemId, Uri uri, Set<String> set, boolean z, ItemId itemId2, Continuation<? super Result<FileModel, ? extends DomainError>> continuation);

    Object uploadFolder(String str, ItemId itemId, Uri uri, Set<String> set, Continuation<? super Result<FolderModel, ? extends DomainError>> continuation);

    /* JADX INFO: compiled from: ILocalItemService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object uploadFolder$default(ILocalItemService iLocalItemService, String str, ItemId itemId, Uri uri, Set set, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadFolder");
        }
        if ((i & 8) != 0) {
            set = SetsKt.emptySet();
        }
        return iLocalItemService.uploadFolder(str, itemId, uri, set, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object uploadFile$default(ILocalItemService iLocalItemService, String str, ItemId itemId, Uri uri, Set set, boolean z, ItemId itemId2, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadFile");
        }
        if ((i & 2) != 0) {
            itemId = null;
        }
        if ((i & 8) != 0) {
            set = SetsKt.emptySet();
        }
        if ((i & 16) != 0) {
            z = true;
        }
        if ((i & 32) != 0) {
            itemId2 = null;
        }
        return iLocalItemService.uploadFile(str, itemId, uri, set, z, itemId2, continuation);
    }

    static /* synthetic */ Object enqueueMarkOfflineJobForItems$default(ILocalItemService iLocalItemService, List list, boolean z, JobTags.JobSource jobSource, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enqueueMarkOfflineJobForItems");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return iLocalItemService.enqueueMarkOfflineJobForItems(list, z, jobSource, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object moveItem$default(ILocalItemService iLocalItemService, ItemId itemId, ItemId itemId2, Set set, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: moveItem");
        }
        if ((i & 4) != 0) {
            set = SetsKt.emptySet();
        }
        return iLocalItemService.moveItem(itemId, itemId2, set, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object copyItem$default(ILocalItemService iLocalItemService, ItemId itemId, ItemId itemId2, Set set, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyItem");
        }
        if ((i & 4) != 0) {
            set = SetsKt.emptySet();
        }
        return iLocalItemService.copyItem(itemId, itemId2, set, continuation);
    }
}
