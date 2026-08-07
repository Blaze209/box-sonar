package com.box.android.data.mappers.inboxnotifications;

import com.box.android.data.api.models.inboxnotifications.InboxNotificationDTO;
import com.box.android.data.api.models.inboxnotifications.InboxNotificationPayloadDTO;
import com.box.android.data.api.models.inboxnotifications.InboxNotificationUserDTO;
import com.box.android.domain.models.inboxnotifications.InboxNotificationModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationUserModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationDTODomainMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lcom/box/android/data/mappers/inboxnotifications/InboxNotificationDTODomainMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;", "dto", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationDTO;", "fromDomain", "model", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxNotificationDTODomainMapper {
    public static final InboxNotificationDTODomainMapper INSTANCE = new InboxNotificationDTODomainMapper();

    private InboxNotificationDTODomainMapper() {
    }

    public final InboxNotificationModel toDomain(InboxNotificationDTO dto) {
        Intrinsics.checkNotNullParameter(dto, "dto");
        String id = dto.getId();
        String type = dto.getType();
        String createdAt = dto.getCreatedAt();
        boolean zIsSeen = dto.isSeen();
        boolean zIsRead = dto.isRead();
        InboxNotificationPayloadModel domain = InboxNotificationPayloadMapper.INSTANCE.toDomain(dto.getPayload());
        InboxNotificationUserDTO recipient = dto.getRecipient();
        InboxNotificationUserModel domain2 = recipient != null ? InboxNotificationUserMapper.INSTANCE.toDomain(recipient) : null;
        InboxNotificationUserDTO ownedBy = dto.getOwnedBy();
        return new InboxNotificationModel(id, type, createdAt, zIsSeen, zIsRead, domain, domain2, ownedBy != null ? InboxNotificationUserMapper.INSTANCE.toDomain(ownedBy) : null);
    }

    public final InboxNotificationDTO fromDomain(InboxNotificationModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        String id = model.getId();
        String type = model.getType();
        String createdAt = model.getCreatedAt();
        boolean zIsSeen = model.isSeen();
        boolean zIsRead = model.isRead();
        InboxNotificationPayloadDTO inboxNotificationPayloadDTOFromDomain = InboxNotificationPayloadMapper.INSTANCE.fromDomain(model.getPayload());
        InboxNotificationUserModel recipient = model.getRecipient();
        InboxNotificationUserDTO inboxNotificationUserDTOFromDomain = recipient != null ? InboxNotificationUserMapper.INSTANCE.fromDomain(recipient) : null;
        InboxNotificationUserModel ownedBy = model.getOwnedBy();
        return new InboxNotificationDTO(id, type, createdAt, zIsSeen, zIsRead, inboxNotificationPayloadDTOFromDomain, inboxNotificationUserDTOFromDomain, ownedBy != null ? InboxNotificationUserMapper.INSTANCE.fromDomain(ownedBy) : null);
    }
}
