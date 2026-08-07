package com.box.android.data.mappers.inboxnotifications;

import com.box.android.data.api.models.inboxnotifications.InboxNotificationUserDTO;
import com.box.android.data.api.models.inboxnotifications.TaskCollaboratorMiniDTO;
import com.box.android.domain.models.inboxnotifications.InboxNotificationUserModel;
import com.box.android.domain.models.inboxnotifications.TaskCollaboratorMiniModel;
import com.box.android.domain.models.inboxnotifications.TaskCollaboratorRole;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationUserMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lcom/box/android/data/mappers/inboxnotifications/TaskCollaboratorMiniMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/inboxnotifications/TaskCollaboratorMiniModel;", "dto", "Lcom/box/android/data/api/models/inboxnotifications/TaskCollaboratorMiniDTO;", "fromDomain", "model", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TaskCollaboratorMiniMapper {
    public static final TaskCollaboratorMiniMapper INSTANCE = new TaskCollaboratorMiniMapper();

    private TaskCollaboratorMiniMapper() {
    }

    public final TaskCollaboratorMiniModel toDomain(TaskCollaboratorMiniDTO dto) {
        Intrinsics.checkNotNullParameter(dto, "dto");
        String id = dto.getId();
        String type = dto.getType();
        TaskCollaboratorRole taskCollaboratorRoleByName = TaskCollaboratorRole.INSTANCE.byName(dto.getRole().getJsonValue());
        InboxNotificationUserDTO target = dto.getTarget();
        return new TaskCollaboratorMiniModel(id, type, taskCollaboratorRoleByName, target != null ? InboxNotificationUserMapper.INSTANCE.toDomain(target) : null);
    }

    public final TaskCollaboratorMiniDTO fromDomain(TaskCollaboratorMiniModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        String id = model.getId();
        String type = model.getType();
        com.box.android.data.api.models.inboxnotifications.TaskCollaboratorRole taskCollaboratorRoleByName = com.box.android.data.api.models.inboxnotifications.TaskCollaboratorRole.INSTANCE.byName(model.getRole().getJsonValue());
        InboxNotificationUserModel target = model.getTarget();
        return new TaskCollaboratorMiniDTO(id, type, taskCollaboratorRoleByName, target != null ? InboxNotificationUserMapper.INSTANCE.fromDomain(target) : null);
    }
}
