package com.box.android.data.mappers.inboxnotifications;

import com.box.android.data.api.models.inboxnotifications.ActionDTO;
import com.box.android.data.api.models.inboxnotifications.CommonPayloadDTOInbox;
import com.box.android.data.api.models.inboxnotifications.InboxNotificationActionResponseDTO;
import com.box.android.domain.models.inboxnotifications.ActionModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationActionResponseModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationActionResponseDTODomainMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/data/mappers/inboxnotifications/InboxNotificationActionResponseDTODomainMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationActionResponseModel;", "dto", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationActionResponseDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxNotificationActionResponseDTODomainMapper {
    public static final InboxNotificationActionResponseDTODomainMapper INSTANCE = new InboxNotificationActionResponseDTODomainMapper();

    private InboxNotificationActionResponseDTODomainMapper() {
    }

    public final InboxNotificationActionResponseModel toDomain(InboxNotificationActionResponseDTO dto) {
        Intrinsics.checkNotNullParameter(dto, "dto");
        String status = dto.getStatus();
        ActionDTO immediateAction = dto.getImmediateAction();
        ActionModel domain = immediateAction != null ? ActionMapper.INSTANCE.toDomain(immediateAction) : null;
        CommonPayloadDTOInbox payload = dto.getPayload();
        return new InboxNotificationActionResponseModel(status, domain, payload != null ? InboxNotificationPayloadMapper.INSTANCE.toDomain(payload) : null);
    }
}
