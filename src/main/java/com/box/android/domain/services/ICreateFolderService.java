package com.box.android.domain.services;

import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.utils.result.Result;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: ICreateFolderService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/ICreateFolderService;", "", "createFolder", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/FolderModel;", "Lcom/box/android/domain/models/DomainError;", BoxCommonConstants.EXTRA_FOLDER_NAME, "", "parentFolderId", "Lcom/box/android/domain/models/ItemId;", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ICreateFolderService {
    Object createFolder(String str, ItemId itemId, Continuation<? super Result<FolderModel, ? extends DomainError>> continuation);
}
