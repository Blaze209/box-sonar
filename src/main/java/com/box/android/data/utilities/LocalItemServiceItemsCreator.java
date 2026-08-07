package com.box.android.data.utilities;

import com.box.android.common.extensions.FileExtensionsKt;
import com.box.android.data.persistence.localItems.LocalItemEntity;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.mappers.UserModelMapper;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FileVersionMiniModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.models.item.WebLinkModel;
import com.box.androidsdk.content.models.BoxUser;
import java.io.File;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocalItemServiceItemsCreator.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007J \u0010\u0011\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u0007J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/utilities/LocalItemServiceItemsCreator;", "", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "<init>", "(Lcom/box/android/domain/identity/IUserContextManager;)V", "createPermissionModel", "Lcom/box/android/domain/models/item/PermissionsModel;", "createLocalFileModel", "Lcom/box/android/domain/models/item/FileModel;", "localItemEntity", "Lcom/box/android/data/persistence/localItems/LocalItemEntity;", "parentFolderModel", "Lcom/box/android/domain/models/item/FolderModel;", "file", "Ljava/io/File;", "permissionsModel", "createLocalFolderModel", "createLocalWebLinkModel", "Lcom/box/android/domain/models/item/WebLinkModel;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LocalItemServiceItemsCreator {
    private final IUserContextManager userContextManager;

    @Inject
    public LocalItemServiceItemsCreator(IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        this.userContextManager = userContextManager;
    }

    public final PermissionsModel createPermissionModel() {
        return new PermissionsModel(true, true, true, true, true, true, false, false, false, false, false, false, 2048, null);
    }

    public final FileModel createLocalFileModel(LocalItemEntity localItemEntity, FolderModel parentFolderModel, File file, PermissionsModel permissionsModel) {
        Intrinsics.checkNotNullParameter(localItemEntity, "localItemEntity");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(permissionsModel, "permissionsModel");
        String localFileSha1 = localItemEntity.getLocalFileSha1();
        if (localFileSha1 == null) {
            localFileSha1 = FileExtensionsKt.computeFileSha1(file);
        }
        ItemId.Local itemId = localItemEntity.getItemId();
        String name = localItemEntity.getName();
        UserModelMapper userModelMapper = UserModelMapper.INSTANCE;
        BoxUser userInfo = this.userContextManager.getUserInfo();
        Intrinsics.checkNotNullExpressionValue(userInfo, "getUserInfo(...)");
        return new FileModel(itemId, name, false, false, parentFolderModel, userModelMapper.toUserModel(userInfo), null, localItemEntity.getCreatedAt(), localItemEntity.getCreatedAt(), null, localItemEntity.getContentModifiedAt(), false, file.length(), permissionsModel, null, null, null, null, null, localFileSha1, new FileVersionMiniModel(localItemEntity.getItemId().toString(), localFileSha1), null, 0L, 0L, null, null, null, 83886080, null);
    }

    public final FolderModel createLocalFolderModel(LocalItemEntity localItemEntity, FolderModel parentFolderModel, PermissionsModel permissionsModel) {
        Intrinsics.checkNotNullParameter(localItemEntity, "localItemEntity");
        Intrinsics.checkNotNullParameter(permissionsModel, "permissionsModel");
        ItemId.Local itemId = localItemEntity.getItemId();
        String name = localItemEntity.getName();
        UserModelMapper userModelMapper = UserModelMapper.INSTANCE;
        BoxUser userInfo = this.userContextManager.getUserInfo();
        Intrinsics.checkNotNullExpressionValue(userInfo, "getUserInfo(...)");
        return new FolderModel(itemId, name, false, false, parentFolderModel, userModelMapper.toUserModel(userInfo), null, localItemEntity.getCreatedAt(), localItemEntity.getCreatedAt(), localItemEntity.getContentModifiedAt(), localItemEntity.getContentModifiedAt(), false, 0L, permissionsModel, null, null, null, null, null, 393216, null);
    }

    public final WebLinkModel createLocalWebLinkModel(LocalItemEntity localItemEntity, FolderModel parentFolderModel, PermissionsModel permissionsModel) {
        Intrinsics.checkNotNullParameter(localItemEntity, "localItemEntity");
        Intrinsics.checkNotNullParameter(permissionsModel, "permissionsModel");
        ItemId.Local itemId = localItemEntity.getItemId();
        String name = localItemEntity.getName();
        UserModelMapper userModelMapper = UserModelMapper.INSTANCE;
        BoxUser userInfo = this.userContextManager.getUserInfo();
        Intrinsics.checkNotNullExpressionValue(userInfo, "getUserInfo(...)");
        return new WebLinkModel(itemId, name, false, false, parentFolderModel, userModelMapper.toUserModel(userInfo), null, localItemEntity.getCreatedAt(), localItemEntity.getCreatedAt(), null, localItemEntity.getContentModifiedAt(), false, permissionsModel, null, localItemEntity.getContentUrl(), null, null, null, 131072, null);
    }
}
