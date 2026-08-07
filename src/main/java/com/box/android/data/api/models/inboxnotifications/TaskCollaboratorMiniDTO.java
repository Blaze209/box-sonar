package com.box.android.data.api.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationTaskDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/box/android/data/api/models/inboxnotifications/TaskCollaboratorMiniDTO;", "", "id", "", "type", "role", "Lcom/box/android/data/api/models/inboxnotifications/TaskCollaboratorRole;", "target", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationUserDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/inboxnotifications/TaskCollaboratorRole;Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationUserDTO;)V", "getId", "()Ljava/lang/String;", "getType", "getRole", "()Lcom/box/android/data/api/models/inboxnotifications/TaskCollaboratorRole;", "getTarget", "()Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationUserDTO;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TaskCollaboratorMiniDTO {
    private final String id;
    private final TaskCollaboratorRole role;
    private final InboxNotificationUserDTO target;
    private final String type;

    public static /* synthetic */ TaskCollaboratorMiniDTO copy$default(TaskCollaboratorMiniDTO taskCollaboratorMiniDTO, String str, String str2, TaskCollaboratorRole taskCollaboratorRole, InboxNotificationUserDTO inboxNotificationUserDTO, int i, Object obj) {
        if ((i & 1) != 0) {
            str = taskCollaboratorMiniDTO.id;
        }
        if ((i & 2) != 0) {
            str2 = taskCollaboratorMiniDTO.type;
        }
        if ((i & 4) != 0) {
            taskCollaboratorRole = taskCollaboratorMiniDTO.role;
        }
        if ((i & 8) != 0) {
            inboxNotificationUserDTO = taskCollaboratorMiniDTO.target;
        }
        return taskCollaboratorMiniDTO.copy(str, str2, taskCollaboratorRole, inboxNotificationUserDTO);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final TaskCollaboratorRole getRole() {
        return this.role;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final InboxNotificationUserDTO getTarget() {
        return this.target;
    }

    public final TaskCollaboratorMiniDTO copy(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "role") TaskCollaboratorRole role, @Json(name = "target") InboxNotificationUserDTO target) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(role, "role");
        return new TaskCollaboratorMiniDTO(id, type, role, target);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskCollaboratorMiniDTO)) {
            return false;
        }
        TaskCollaboratorMiniDTO taskCollaboratorMiniDTO = (TaskCollaboratorMiniDTO) other;
        return Intrinsics.areEqual(this.id, taskCollaboratorMiniDTO.id) && Intrinsics.areEqual(this.type, taskCollaboratorMiniDTO.type) && this.role == taskCollaboratorMiniDTO.role && Intrinsics.areEqual(this.target, taskCollaboratorMiniDTO.target);
    }

    public int hashCode() {
        int iHashCode = ((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.role.hashCode()) * 31;
        InboxNotificationUserDTO inboxNotificationUserDTO = this.target;
        return iHashCode + (inboxNotificationUserDTO == null ? 0 : inboxNotificationUserDTO.hashCode());
    }

    public String toString() {
        return "TaskCollaboratorMiniDTO(id=" + this.id + ", type=" + this.type + ", role=" + this.role + ", target=" + this.target + ")";
    }

    public TaskCollaboratorMiniDTO(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "role") TaskCollaboratorRole role, @Json(name = "target") InboxNotificationUserDTO inboxNotificationUserDTO) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(role, "role");
        this.id = id;
        this.type = type;
        this.role = role;
        this.target = inboxNotificationUserDTO;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final TaskCollaboratorRole getRole() {
        return this.role;
    }

    public final InboxNotificationUserDTO getTarget() {
        return this.target;
    }
}
