package com.box.android.domain.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationTaskModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/TaskLinkModel;", "Lcom/box/android/domain/models/DomainModel;", "id", "", "type", "target", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationTargetItemModel;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/domain/models/inboxnotifications/InboxNotificationTargetItemModel;)V", "getId", "()Ljava/lang/String;", "getType", "getTarget", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationTargetItemModel;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TaskLinkModel implements DomainModel {
    private final String id;
    private final InboxNotificationTargetItemModel target;
    private final String type;

    public static /* synthetic */ TaskLinkModel copy$default(TaskLinkModel taskLinkModel, String str, String str2, InboxNotificationTargetItemModel inboxNotificationTargetItemModel, int i, Object obj) {
        if ((i & 1) != 0) {
            str = taskLinkModel.id;
        }
        if ((i & 2) != 0) {
            str2 = taskLinkModel.type;
        }
        if ((i & 4) != 0) {
            inboxNotificationTargetItemModel = taskLinkModel.target;
        }
        return taskLinkModel.copy(str, str2, inboxNotificationTargetItemModel);
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
    public final InboxNotificationTargetItemModel getTarget() {
        return this.target;
    }

    public final TaskLinkModel copy(String id, String type, InboxNotificationTargetItemModel target) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        return new TaskLinkModel(id, type, target);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskLinkModel)) {
            return false;
        }
        TaskLinkModel taskLinkModel = (TaskLinkModel) other;
        return Intrinsics.areEqual(this.id, taskLinkModel.id) && Intrinsics.areEqual(this.type, taskLinkModel.type) && Intrinsics.areEqual(this.target, taskLinkModel.target);
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
        InboxNotificationTargetItemModel inboxNotificationTargetItemModel = this.target;
        return iHashCode + (inboxNotificationTargetItemModel == null ? 0 : inboxNotificationTargetItemModel.hashCode());
    }

    public String toString() {
        return "TaskLinkModel(id=" + this.id + ", type=" + this.type + ", target=" + this.target + ")";
    }

    public TaskLinkModel(String id, String type, InboxNotificationTargetItemModel inboxNotificationTargetItemModel) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.type = type;
        this.target = inboxNotificationTargetItemModel;
    }

    public final String getId() {
        return this.id;
    }

    public final InboxNotificationTargetItemModel getTarget() {
        return this.target;
    }

    public final String getType() {
        return this.type;
    }
}
