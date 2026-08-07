package com.box.android.domain.usecases.capture;

import android.net.Uri;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.utils.result.Result;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: CaptureLocalItemsUseCase.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\fJ2\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u000fJ*\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\u0012J\"\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0014\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\u0015J*\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\u0012¨\u0006\u0017À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/usecases/capture/CaptureLocalItemsUseCase;", "", "createFile", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/FileModel;", "Lcom/box/android/domain/models/DomainError;", "name", "", IdentificationData.FIELD_PARENT_ID, "Lcom/box/android/domain/models/ItemId;", "contentFile", "Ljava/io/File;", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "contentUrl", "Landroid/net/Uri;", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createFolder", "Lcom/box/android/domain/models/item/FolderModel;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFolderById", "folderId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFolderByName", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface CaptureLocalItemsUseCase {
    Object createFile(String str, ItemId itemId, Uri uri, Continuation<? super Result<FileModel, ? extends DomainError>> continuation);

    Object createFile(String str, ItemId itemId, File file, Continuation<? super Result<FileModel, ? extends DomainError>> continuation);

    Object createFolder(String str, String str2, Continuation<? super Result<FolderModel, ? extends DomainError>> continuation);

    Object getFolderById(String str, Continuation<? super Result<FolderModel, ? extends DomainError>> continuation);

    Object getFolderByName(String str, String str2, Continuation<? super Result<FolderModel, ? extends DomainError>> continuation);
}
