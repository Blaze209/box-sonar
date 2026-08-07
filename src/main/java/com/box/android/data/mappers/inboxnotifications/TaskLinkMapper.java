package com.box.android.data.mappers.inboxnotifications;

import com.box.android.data.api.models.inboxnotifications.InboxNotificationTargetItemDTO;
import com.box.android.data.api.models.inboxnotifications.TaskLinkDTO;
import com.box.android.domain.models.inboxnotifications.InboxNotificationTargetItemModel;
import com.box.android.domain.models.inboxnotifications.TaskLinkModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationUserMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lcom/box/android/data/mappers/inboxnotifications/TaskLinkMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/inboxnotifications/TaskLinkModel;", "dto", "Lcom/box/android/data/api/models/inboxnotifications/TaskLinkDTO;", "fromDomain", "model", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TaskLinkMapper {
    public static final TaskLinkMapper INSTANCE = new TaskLinkMapper();

    private TaskLinkMapper() {
    }

    public final TaskLinkModel toDomain(TaskLinkDTO dto) {
        Intrinsics.checkNotNullParameter(dto, "dto");
        String id = dto.getId();
        String type = dto.getType();
        InboxNotificationTargetItemDTO target = dto.getTarget();
        return new TaskLinkModel(id, type, target != null ? InboxNotificationTargetItemMapper.INSTANCE.toDomain(target) : null);
    }

    public final TaskLinkDTO fromDomain(TaskLinkModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        String id = model.getId();
        String type = model.getType();
        InboxNotificationTargetItemModel target = model.getTarget();
        return new TaskLinkDTO(id, type, target != null ? InboxNotificationTargetItemMapper.INSTANCE.fromDomain(target) : null);
    }
}
