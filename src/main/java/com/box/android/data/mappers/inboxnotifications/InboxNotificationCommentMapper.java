package com.box.android.data.mappers.inboxnotifications;

import com.box.android.data.api.models.inboxnotifications.InboxNotificationCommentDTO;
import com.box.android.domain.models.inboxnotifications.InboxNotificationCommentModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationUserMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lcom/box/android/data/mappers/inboxnotifications/InboxNotificationCommentMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationCommentModel;", "dto", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationCommentDTO;", "fromDomain", "model", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxNotificationCommentMapper {
    public static final InboxNotificationCommentMapper INSTANCE = new InboxNotificationCommentMapper();

    private InboxNotificationCommentMapper() {
    }

    public final InboxNotificationCommentModel toDomain(InboxNotificationCommentDTO dto) {
        Intrinsics.checkNotNullParameter(dto, "dto");
        return new InboxNotificationCommentModel(dto.getId(), dto.getType(), dto.getMessage(), dto.isReplyComment());
    }

    public final InboxNotificationCommentDTO fromDomain(InboxNotificationCommentModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return new InboxNotificationCommentDTO(model.getId(), model.getType(), model.getMessage(), model.isReplyComment());
    }
}
