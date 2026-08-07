package com.box.android.domain.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationTaskModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/TaskCollaboratorMiniModel;", "Lcom/box/android/domain/models/DomainModel;", "id", "", "type", "role", "Lcom/box/android/domain/models/inboxnotifications/TaskCollaboratorRole;", "target", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/domain/models/inboxnotifications/TaskCollaboratorRole;Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;)V", "getId", "()Ljava/lang/String;", "getType", "getRole", "()Lcom/box/android/domain/models/inboxnotifications/TaskCollaboratorRole;", "getTarget", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUserModel;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TaskCollaboratorMiniModel implements DomainModel {
    private final String id;
    private final TaskCollaboratorRole role;
    private final InboxNotificationUserModel target;
    private final String type;

    public static /* synthetic */ TaskCollaboratorMiniModel copy$default(TaskCollaboratorMiniModel taskCollaboratorMiniModel, String str, String str2, TaskCollaboratorRole taskCollaboratorRole, InboxNotificationUserModel inboxNotificationUserModel, int i, Object obj) {
        if ((i & 1) != 0) {
            str = taskCollaboratorMiniModel.id;
        }
        if ((i & 2) != 0) {
            str2 = taskCollaboratorMiniModel.type;
        }
        if ((i & 4) != 0) {
            taskCollaboratorRole = taskCollaboratorMiniModel.role;
        }
        if ((i & 8) != 0) {
            inboxNotificationUserModel = taskCollaboratorMiniModel.target;
        }
        return taskCollaboratorMiniModel.copy(str, str2, taskCollaboratorRole, inboxNotificationUserModel);
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
    public final InboxNotificationUserModel getTarget() {
        return this.target;
    }

    public final TaskCollaboratorMiniModel copy(String id, String type, TaskCollaboratorRole role, InboxNotificationUserModel target) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(role, "role");
        return new TaskCollaboratorMiniModel(id, type, role, target);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskCollaboratorMiniModel)) {
            return false;
        }
        TaskCollaboratorMiniModel taskCollaboratorMiniModel = (TaskCollaboratorMiniModel) other;
        return Intrinsics.areEqual(this.id, taskCollaboratorMiniModel.id) && Intrinsics.areEqual(this.type, taskCollaboratorMiniModel.type) && this.role == taskCollaboratorMiniModel.role && Intrinsics.areEqual(this.target, taskCollaboratorMiniModel.target);
    }

    public int hashCode() {
        int iHashCode = ((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.role.hashCode()) * 31;
        InboxNotificationUserModel inboxNotificationUserModel = this.target;
        return iHashCode + (inboxNotificationUserModel == null ? 0 : inboxNotificationUserModel.hashCode());
    }

    public String toString() {
        return "TaskCollaboratorMiniModel(id=" + this.id + ", type=" + this.type + ", role=" + this.role + ", target=" + this.target + ")";
    }

    public TaskCollaboratorMiniModel(String id, String type, TaskCollaboratorRole role, InboxNotificationUserModel inboxNotificationUserModel) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(role, "role");
        this.id = id;
        this.type = type;
        this.role = role;
        this.target = inboxNotificationUserModel;
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

    public final InboxNotificationUserModel getTarget() {
        return this.target;
    }
}
