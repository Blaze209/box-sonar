package com.box.android.data.mappers.inboxnotifications;

import com.box.android.data.api.models.inboxnotifications.InboxNotificationCollaborationDTO;
import com.box.android.domain.models.inboxnotifications.InboxNotificationCollaborationModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationCollaborationStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationUserMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lcom/box/android/data/mappers/inboxnotifications/InboxNotificationCollaborationMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationCollaborationModel;", "dto", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationCollaborationDTO;", "fromDomain", "model", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxNotificationCollaborationMapper {
    public static final InboxNotificationCollaborationMapper INSTANCE = new InboxNotificationCollaborationMapper();

    private InboxNotificationCollaborationMapper() {
    }

    public final InboxNotificationCollaborationModel toDomain(InboxNotificationCollaborationDTO dto) {
        Intrinsics.checkNotNullParameter(dto, "dto");
        return new InboxNotificationCollaborationModel(dto.getId(), dto.getType(), dto.getRole(), InboxNotificationCollaborationStatus.INSTANCE.byName(dto.getStatus()), InboxNotificationUserMapper.INSTANCE.toDomain(dto.getCreatedBy()), AcceptanceRequirementsStatusMapper.INSTANCE.toDomain(dto.getAcceptanceRequirementsStatus()));
    }

    public final InboxNotificationCollaborationDTO fromDomain(InboxNotificationCollaborationModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return new InboxNotificationCollaborationDTO(model.getId(), model.getType(), model.getRole(), model.getStatus().getJsonValue(), InboxNotificationUserMapper.INSTANCE.fromDomain(model.getCreatedBy()), AcceptanceRequirementsStatusMapper.INSTANCE.fromDomain(model.getAcceptanceRequirementsStatus()));
    }
}
