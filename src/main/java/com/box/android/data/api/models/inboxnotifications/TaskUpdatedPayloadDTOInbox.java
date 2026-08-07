package com.box.android.data.api.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationPayloadDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/box/android/data/api/models/inboxnotifications/TaskUpdatedPayloadDTOInbox;", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationPayloadDTO;", "type", "", "task", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationTaskDTO;", "status", "<init>", "(Ljava/lang/String;Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationTaskDTO;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getTask", "()Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationTaskDTO;", "getStatus", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TaskUpdatedPayloadDTOInbox extends InboxNotificationPayloadDTO {
    private final String status;
    private final InboxNotificationTaskDTO task;
    private final String type;

    public static /* synthetic */ TaskUpdatedPayloadDTOInbox copy$default(TaskUpdatedPayloadDTOInbox taskUpdatedPayloadDTOInbox, String str, InboxNotificationTaskDTO inboxNotificationTaskDTO, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = taskUpdatedPayloadDTOInbox.type;
        }
        if ((i & 2) != 0) {
            inboxNotificationTaskDTO = taskUpdatedPayloadDTOInbox.task;
        }
        if ((i & 4) != 0) {
            str2 = taskUpdatedPayloadDTOInbox.status;
        }
        return taskUpdatedPayloadDTOInbox.copy(str, inboxNotificationTaskDTO, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final InboxNotificationTaskDTO getTask() {
        return this.task;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final TaskUpdatedPayloadDTOInbox copy(@Json(name = "type") String type, @Json(name = "task") InboxNotificationTaskDTO task, @Json(name = "status") String status) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(status, "status");
        return new TaskUpdatedPayloadDTOInbox(type, task, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskUpdatedPayloadDTOInbox)) {
            return false;
        }
        TaskUpdatedPayloadDTOInbox taskUpdatedPayloadDTOInbox = (TaskUpdatedPayloadDTOInbox) other;
        return Intrinsics.areEqual(this.type, taskUpdatedPayloadDTOInbox.type) && Intrinsics.areEqual(this.task, taskUpdatedPayloadDTOInbox.task) && Intrinsics.areEqual(this.status, taskUpdatedPayloadDTOInbox.status);
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.task.hashCode()) * 31) + this.status.hashCode();
    }

    public String toString() {
        return "TaskUpdatedPayloadDTOInbox(type=" + this.type + ", task=" + this.task + ", status=" + this.status + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskUpdatedPayloadDTOInbox(@Json(name = "type") String type, @Json(name = "task") InboxNotificationTaskDTO task, @Json(name = "status") String status) {
        super(null);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(status, "status");
        this.type = type;
        this.task = task;
        this.status = status;
    }

    @Override // com.box.android.data.api.models.inboxnotifications.InboxNotificationPayloadDTO
    public String getType() {
        return this.type;
    }

    public final InboxNotificationTaskDTO getTask() {
        return this.task;
    }

    public final String getStatus() {
        return this.status;
    }
}
