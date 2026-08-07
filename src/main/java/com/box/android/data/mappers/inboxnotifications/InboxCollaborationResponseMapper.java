package com.box.android.data.mappers.inboxnotifications;

import com.box.android.data.api.models.InboxCollaborationResponseDTO;
import com.box.android.data.api.models.items.mini.ItemIdDTO;
import com.box.android.data.mappers.UserMiniDTOtoUserDomainModelMapper;
import com.box.android.domain.models.InboxCollaborationResponseModel;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.inboxnotifications.InboxNotificationCollaborationStatus;
import com.box.android.domain.models.item.UserModel;
import com.box.androidsdk.content.utils.BoxDateFormat;
import java.text.ParseException;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxCollaborationResponseMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/data/mappers/inboxnotifications/InboxCollaborationResponseMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/InboxCollaborationResponseModel;", "dto", "Lcom/box/android/data/api/models/InboxCollaborationResponseDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxCollaborationResponseMapper {
    public static final InboxCollaborationResponseMapper INSTANCE = new InboxCollaborationResponseMapper();

    private InboxCollaborationResponseMapper() {
    }

    public final InboxCollaborationResponseModel toDomain(InboxCollaborationResponseDTO dto) throws ParseException {
        Intrinsics.checkNotNullParameter(dto, "dto");
        String type = dto.getType();
        String id = dto.getId();
        UserModel domain = UserMiniDTOtoUserDomainModelMapper.INSTANCE.toDomain(dto.getCreatedBy());
        Date date = BoxDateFormat.parse(dto.getCreatedAt());
        Intrinsics.checkNotNullExpressionValue(date, "let(...)");
        Date date2 = BoxDateFormat.parse(dto.getModifiedAt());
        Intrinsics.checkNotNullExpressionValue(date2, "let(...)");
        String expiresAt = dto.getExpiresAt();
        Date date3 = expiresAt != null ? BoxDateFormat.parse(expiresAt) : null;
        InboxNotificationCollaborationStatus inboxNotificationCollaborationStatusByName = InboxNotificationCollaborationStatus.INSTANCE.byName(dto.getStatus());
        UserModel domain2 = UserMiniDTOtoUserDomainModelMapper.INSTANCE.toDomain(dto.getAccessibleBy());
        String inviteEmail = dto.getInviteEmail();
        String role = dto.getRole();
        String acknowledgedAt = dto.getAcknowledgedAt();
        Date date4 = acknowledgedAt != null ? BoxDateFormat.parse(acknowledgedAt) : null;
        ItemIdDTO item = dto.getItem();
        return new InboxCollaborationResponseModel(type, id, domain, date, date2, date3, inboxNotificationCollaborationStatusByName, domain2, inviteEmail, role, date4, item != null ? new ItemId.Remote(item.getId(), item.getType()) : null, dto.isAccessOnly());
    }
}
