package com.box.android.data.mappers;

import com.box.android.data.api.ItemCollaborationsDTO;
import com.box.android.data.api.models.CollaborationDTO;
import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.domain.models.item.ItemCollaborationModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemCollaborationsDTOToDomainMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003¨\u0006\u0004"}, d2 = {"toDomain", "", "Lcom/box/android/domain/models/item/ItemCollaborationModel;", "Lcom/box/android/data/api/ItemCollaborationsDTO;", "data_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ItemCollaborationsDTOToDomainMapperKt {
    public static final List<ItemCollaborationModel> toDomain(ItemCollaborationsDTO itemCollaborationsDTO) {
        Intrinsics.checkNotNullParameter(itemCollaborationsDTO, "<this>");
        List<CollaborationDTO> entries = itemCollaborationsDTO.getEntries();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries, 10));
        for (CollaborationDTO collaborationDTO : entries) {
            String id = collaborationDTO.getId();
            String type = collaborationDTO.getType();
            String inviteEmail = collaborationDTO.getInviteEmail();
            UserMiniDTO accessibleBy = collaborationDTO.getAccessibleBy();
            arrayList.add(new ItemCollaborationModel(id, type, inviteEmail, accessibleBy != null ? UserMiniDTOtoUserDomainModelMapper.INSTANCE.toDomain(accessibleBy) : null));
        }
        return arrayList;
    }
}
