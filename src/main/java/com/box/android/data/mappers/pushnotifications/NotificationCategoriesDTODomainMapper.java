package com.box.android.data.mappers.pushnotifications;

import com.box.android.data.api.models.pushnotifications.NotificationCategoriesDTO;
import com.box.android.data.api.models.pushnotifications.NotificationCategoryDTO;
import com.box.android.data.mappers.DomainMapper;
import com.box.android.domain.models.pushnotifications.NotificationCategoriesModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationCategoriesDTODomainMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"Lcom/box/android/data/mappers/pushnotifications/NotificationCategoriesDTODomainMapper;", "Lcom/box/android/data/mappers/DomainMapper;", "Lcom/box/android/domain/models/pushnotifications/NotificationCategoriesModel;", "Lcom/box/android/data/api/models/pushnotifications/NotificationCategoriesDTO;", "<init>", "()V", "fromDomain", "domainModel", "toDomain", "dataModel", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NotificationCategoriesDTODomainMapper implements DomainMapper<NotificationCategoriesModel, NotificationCategoriesDTO> {
    public static final NotificationCategoriesDTODomainMapper INSTANCE = new NotificationCategoriesDTODomainMapper();

    private NotificationCategoriesDTODomainMapper() {
    }

    @Override // com.box.android.data.mappers.DomainMapper
    public NotificationCategoriesDTO fromDomain(NotificationCategoriesModel domainModel) {
        Intrinsics.checkNotNullParameter(domainModel, "domainModel");
        return new NotificationCategoriesDTO(new NotificationCategoryDTO(domainModel.getSharing()), new NotificationCategoryDTO(domainModel.getMentions()), new NotificationCategoryDTO(domainModel.getTasks()), new NotificationCategoryDTO(domainModel.getRelevantUpdates()), new NotificationCategoryDTO(domainModel.getComment()), new NotificationCategoryDTO(domainModel.getCollaborationInvite()), new NotificationCategoryDTO(domainModel.getEdit()), new NotificationCategoryDTO(domainModel.getUpload()));
    }

    @Override // com.box.android.data.mappers.DomainMapper
    public NotificationCategoriesModel toDomain(NotificationCategoriesDTO dataModel) {
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        return new NotificationCategoriesModel(dataModel.getSharing().isNotificaitonEnabled(), dataModel.getMentions().isNotificaitonEnabled(), dataModel.getTasks().isNotificaitonEnabled(), dataModel.getRelevantUpdates().isNotificaitonEnabled(), dataModel.getCommentCreated().isNotificaitonEnabled(), dataModel.getCollaborationInvite().isNotificaitonEnabled(), dataModel.getEdit().isNotificaitonEnabled(), dataModel.getUpload().isNotificaitonEnabled());
    }
}
