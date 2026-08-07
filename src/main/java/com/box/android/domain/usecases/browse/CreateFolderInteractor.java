package com.box.android.domain.usecases.browse;

import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.utils.result.Result;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: CreateFolderInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J*\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/box/android/domain/usecases/browse/CreateFolderInteractor;", "Lcom/box/android/domain/usecases/browse/CreateFolderUseCase;", "itemService", "Lcom/box/android/domain/services/IRemoteItemService;", "<init>", "(Lcom/box/android/domain/services/IRemoteItemService;)V", "createFolder", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/FolderModel;", "Lcom/box/android/domain/models/DomainError;", BoxCommonConstants.EXTRA_FOLDER_NAME, "", IdentificationData.FIELD_PARENT_ID, "Lcom/box/android/domain/models/ItemId$Remote;", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateFolderInteractor implements CreateFolderUseCase {
    private final IRemoteItemService itemService;

    @Inject
    public CreateFolderInteractor(IRemoteItemService itemService) {
        Intrinsics.checkNotNullParameter(itemService, "itemService");
        this.itemService = itemService;
    }

    @Override // com.box.android.domain.usecases.browse.CreateFolderUseCase
    public Object createFolder(String str, ItemId.Remote remote, Continuation<? super Result<FolderModel, ? extends DomainError>> continuation) {
        return this.itemService.createFolder(str, remote, continuation);
    }
}
