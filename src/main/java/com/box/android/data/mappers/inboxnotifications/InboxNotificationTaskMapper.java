package com.box.android.data.mappers.inboxnotifications;

import com.box.android.data.api.models.inboxnotifications.InboxNotificationTaskDTO;
import com.box.android.data.api.models.inboxnotifications.TaskCollaboratorMiniDTO;
import com.box.android.data.api.models.inboxnotifications.TaskLinkDTO;
import com.box.android.domain.models.inboxnotifications.InboxNotificationTaskModel;
import com.box.android.domain.models.inboxnotifications.TaskCollaboratorMiniModel;
import com.box.android.domain.models.inboxnotifications.TaskLinkModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationUserMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lcom/box/android/data/mappers/inboxnotifications/InboxNotificationTaskMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationTaskModel;", "dto", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationTaskDTO;", "fromDomain", "model", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxNotificationTaskMapper {
    public static final InboxNotificationTaskMapper INSTANCE = new InboxNotificationTaskMapper();

    private InboxNotificationTaskMapper() {
    }

    public final InboxNotificationTaskModel toDomain(InboxNotificationTaskDTO dto) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(dto, "dto");
        String id = dto.getId();
        String type = dto.getType();
        String taskType = dto.getTaskType();
        List<TaskCollaboratorMiniDTO> taskCollaborators = dto.getTaskCollaborators();
        ArrayList arrayList2 = null;
        if (taskCollaborators != null) {
            List<TaskCollaboratorMiniDTO> list = taskCollaborators;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList3.add(TaskCollaboratorMiniMapper.INSTANCE.toDomain((TaskCollaboratorMiniDTO) it.next()));
            }
            arrayList = arrayList3;
        } else {
            arrayList = null;
        }
        List<TaskLinkDTO> taskLinks = dto.getTaskLinks();
        if (taskLinks != null) {
            List<TaskLinkDTO> list2 = taskLinks;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList4.add(TaskLinkMapper.INSTANCE.toDomain((TaskLinkDTO) it2.next()));
            }
            arrayList2 = arrayList4;
        }
        return new InboxNotificationTaskModel(id, type, taskType, arrayList, arrayList2);
    }

    public final InboxNotificationTaskDTO fromDomain(InboxNotificationTaskModel model) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(model, "model");
        String id = model.getId();
        String type = model.getType();
        String taskType = model.getTaskType();
        List<TaskCollaboratorMiniModel> taskCollaborators = model.getTaskCollaborators();
        ArrayList arrayList2 = null;
        if (taskCollaborators != null) {
            List<TaskCollaboratorMiniModel> list = taskCollaborators;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList3.add(TaskCollaboratorMiniMapper.INSTANCE.fromDomain((TaskCollaboratorMiniModel) it.next()));
            }
            arrayList = arrayList3;
        } else {
            arrayList = null;
        }
        List<TaskLinkModel> taskLinks = model.getTaskLinks();
        if (taskLinks != null) {
            List<TaskLinkModel> list2 = taskLinks;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList4.add(TaskLinkMapper.INSTANCE.fromDomain((TaskLinkModel) it2.next()));
            }
            arrayList2 = arrayList4;
        }
        return new InboxNotificationTaskDTO(id, type, taskType, arrayList, arrayList2);
    }
}
