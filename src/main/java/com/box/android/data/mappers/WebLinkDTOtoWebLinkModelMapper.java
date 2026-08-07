package com.box.android.data.mappers;

import com.box.android.data.api.models.PathCollectionDTO;
import com.box.android.data.api.models.PermissionsDTO;
import com.box.android.data.api.models.SharedLinkDTO;
import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.data.api.models.collections.CollectionDTO;
import com.box.android.data.api.models.items.WebLinkDTO;
import com.box.android.data.api.models.items.mini.FolderMiniDTO;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.PathCollectionEntry;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.models.item.UserModel;
import com.box.android.domain.models.item.WebLinkModel;
import com.box.androidsdk.content.utils.BoxDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebLinkDTOtoWebLinkModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/data/mappers/WebLinkDTOtoWebLinkModelMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/item/WebLinkModel;", "dataModel", "Lcom/box/android/data/api/models/items/WebLinkDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WebLinkDTOtoWebLinkModelMapper {
    public static final WebLinkDTOtoWebLinkModelMapper INSTANCE = new WebLinkDTOtoWebLinkModelMapper();

    private WebLinkDTOtoWebLinkModelMapper() {
    }

    public final WebLinkModel toDomain(WebLinkDTO dataModel) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        ItemId itemIdCreateItemId = WebLinkModel.INSTANCE.createItemId(dataModel.getId());
        String name = dataModel.getName();
        if (name == null) {
            name = "";
        }
        String str = name;
        Boolean hasCollaborations = dataModel.getHasCollaborations();
        boolean zBooleanValue = hasCollaborations != null ? hasCollaborations.booleanValue() : false;
        Boolean boolIsExternallyOwned = dataModel.isExternallyOwned();
        boolean zBooleanValue2 = boolIsExternallyOwned != null ? boolIsExternallyOwned.booleanValue() : false;
        String url = dataModel.getUrl();
        String createdAt = dataModel.getCreatedAt();
        Date date = createdAt != null ? BoxDateFormat.parse(createdAt) : null;
        String contentCreatedAt = dataModel.getContentCreatedAt();
        Date date2 = contentCreatedAt != null ? BoxDateFormat.parse(contentCreatedAt) : null;
        String modifiedAt = dataModel.getModifiedAt();
        Date date3 = modifiedAt != null ? BoxDateFormat.parse(modifiedAt) : null;
        String contentModifiedAt = dataModel.getContentModifiedAt();
        Date date4 = contentModifiedAt != null ? BoxDateFormat.parse(contentModifiedAt) : null;
        PermissionsDTO permissions = dataModel.getPermissions();
        PermissionsModel domain = permissions != null ? PermissionsDTOtoPermissionsModelMapper.INSTANCE.toDomain(permissions) : null;
        FolderMiniDTO parent = dataModel.getParent();
        FolderModel domain2 = parent != null ? FolderMiniDTOtoFolderModelMapper.INSTANCE.toDomain(parent) : null;
        UserMiniDTO ownedBy = dataModel.getOwnedBy();
        UserModel domain3 = ownedBy != null ? UserMiniDTOtoUserDomainModelMapper.INSTANCE.toDomain(ownedBy) : null;
        UserMiniDTO modifiedBy = dataModel.getModifiedBy();
        UserModel domain4 = modifiedBy != null ? UserMiniDTOtoUserDomainModelMapper.INSTANCE.toDomain(modifiedBy) : null;
        PathCollectionDTO pathCollection = dataModel.getPathCollection();
        boolean isRooted = pathCollection != null ? pathCollection.getIsRooted() : false;
        PathCollectionDTO pathCollection2 = dataModel.getPathCollection();
        List<PathCollectionEntry> domain5 = pathCollection2 != null ? PathCollectionDTOtoPathCollectionEntryMapper.INSTANCE.toDomain(pathCollection2) : null;
        List<CollectionDTO> collections = dataModel.getCollections();
        if (collections != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = collections.iterator();
            while (it.hasNext()) {
                Iterator it2 = it;
                CollectionModel domain6 = CollectionDTOToDomainModelMapper.INSTANCE.toDomain((CollectionDTO) it.next());
                if (domain6 != null) {
                    arrayList2.add(domain6);
                }
                it = it2;
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        String description = dataModel.getDescription();
        SharedLinkDTO sharedLink = dataModel.getSharedLink();
        return new WebLinkModel(itemIdCreateItemId, str, zBooleanValue, zBooleanValue2, domain2, domain3, domain4, date, date2, date3, date4, isRooted, domain, domain5, url, sharedLink != null ? SharedLinkDTOtoSharedLinkModelMapper.INSTANCE.toDomain(sharedLink) : null, arrayList, description);
    }
}
