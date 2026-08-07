package com.box.android.data.api.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationTaskDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/box/android/data/api/models/inboxnotifications/TaskLinkDTO;", "", "id", "", "type", "target", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationTargetItemDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationTargetItemDTO;)V", "getId", "()Ljava/lang/String;", "getType", "getTarget", "()Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationTargetItemDTO;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TaskLinkDTO {
    private final String id;
    private final InboxNotificationTargetItemDTO target;
    private final String type;

    public static /* synthetic */ TaskLinkDTO copy$default(TaskLinkDTO taskLinkDTO, String str, String str2, InboxNotificationTargetItemDTO inboxNotificationTargetItemDTO, int i, Object obj) {
        if ((i & 1) != 0) {
            str = taskLinkDTO.id;
        }
        if ((i & 2) != 0) {
            str2 = taskLinkDTO.type;
        }
        if ((i & 4) != 0) {
            inboxNotificationTargetItemDTO = taskLinkDTO.target;
        }
        return taskLinkDTO.copy(str, str2, inboxNotificationTargetItemDTO);
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
    public final InboxNotificationTargetItemDTO getTarget() {
        return this.target;
    }

    public final TaskLinkDTO copy(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "target") InboxNotificationTargetItemDTO target) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        return new TaskLinkDTO(id, type, target);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskLinkDTO)) {
            return false;
        }
        TaskLinkDTO taskLinkDTO = (TaskLinkDTO) other;
        return Intrinsics.areEqual(this.id, taskLinkDTO.id) && Intrinsics.areEqual(this.type, taskLinkDTO.type) && Intrinsics.areEqual(this.target, taskLinkDTO.target);
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
        InboxNotificationTargetItemDTO inboxNotificationTargetItemDTO = this.target;
        return iHashCode + (inboxNotificationTargetItemDTO == null ? 0 : inboxNotificationTargetItemDTO.hashCode());
    }

    public String toString() {
        return "TaskLinkDTO(id=" + this.id + ", type=" + this.type + ", target=" + this.target + ")";
    }

    public TaskLinkDTO(@Json(name = "id") String id, @Json(name = "type") String type, @Json(name = "target") InboxNotificationTargetItemDTO inboxNotificationTargetItemDTO) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.type = type;
        this.target = inboxNotificationTargetItemDTO;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final InboxNotificationTargetItemDTO getTarget() {
        return this.target;
    }
}
