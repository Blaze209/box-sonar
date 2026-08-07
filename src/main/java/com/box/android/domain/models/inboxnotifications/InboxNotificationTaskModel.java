package com.box.android.domain.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import io.split.android.client.service.ServiceConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationTaskModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0003JM\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006!"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/InboxNotificationTaskModel;", "Lcom/box/android/domain/models/DomainModel;", "id", "", "type", ServiceConstants.TASK_INFO_FIELD_TYPE, "taskCollaborators", "", "Lcom/box/android/domain/models/inboxnotifications/TaskCollaboratorMiniModel;", "taskLinks", "Lcom/box/android/domain/models/inboxnotifications/TaskLinkModel;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getType", "getTaskType", "getTaskCollaborators", "()Ljava/util/List;", "getTaskLinks", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class InboxNotificationTaskModel implements DomainModel {
    private final String id;
    private final List<TaskCollaboratorMiniModel> taskCollaborators;
    private final List<TaskLinkModel> taskLinks;
    private final String taskType;
    private final String type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InboxNotificationTaskModel copy$default(InboxNotificationTaskModel inboxNotificationTaskModel, String str, String str2, String str3, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inboxNotificationTaskModel.id;
        }
        if ((i & 2) != 0) {
            str2 = inboxNotificationTaskModel.type;
        }
        if ((i & 4) != 0) {
            str3 = inboxNotificationTaskModel.taskType;
        }
        if ((i & 8) != 0) {
            list = inboxNotificationTaskModel.taskCollaborators;
        }
        if ((i & 16) != 0) {
            list2 = inboxNotificationTaskModel.taskLinks;
        }
        List list3 = list2;
        String str4 = str3;
        return inboxNotificationTaskModel.copy(str, str2, str4, list, list3);
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
    public final String getTaskType() {
        return this.taskType;
    }

    public final List<TaskCollaboratorMiniModel> component4() {
        return this.taskCollaborators;
    }

    public final List<TaskLinkModel> component5() {
        return this.taskLinks;
    }

    public final InboxNotificationTaskModel copy(String id, String type, String taskType, List<TaskCollaboratorMiniModel> taskCollaborators, List<TaskLinkModel> taskLinks) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        return new InboxNotificationTaskModel(id, type, taskType, taskCollaborators, taskLinks);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboxNotificationTaskModel)) {
            return false;
        }
        InboxNotificationTaskModel inboxNotificationTaskModel = (InboxNotificationTaskModel) other;
        return Intrinsics.areEqual(this.id, inboxNotificationTaskModel.id) && Intrinsics.areEqual(this.type, inboxNotificationTaskModel.type) && Intrinsics.areEqual(this.taskType, inboxNotificationTaskModel.taskType) && Intrinsics.areEqual(this.taskCollaborators, inboxNotificationTaskModel.taskCollaborators) && Intrinsics.areEqual(this.taskLinks, inboxNotificationTaskModel.taskLinks);
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
        String str = this.taskType;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<TaskCollaboratorMiniModel> list = this.taskCollaborators;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        List<TaskLinkModel> list2 = this.taskLinks;
        return iHashCode3 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "InboxNotificationTaskModel(id=" + this.id + ", type=" + this.type + ", taskType=" + this.taskType + ", taskCollaborators=" + this.taskCollaborators + ", taskLinks=" + this.taskLinks + ")";
    }

    public InboxNotificationTaskModel(String id, String type, String str, List<TaskCollaboratorMiniModel> list, List<TaskLinkModel> list2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.type = type;
        this.taskType = str;
        this.taskCollaborators = list;
        this.taskLinks = list2;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final String getTaskType() {
        return this.taskType;
    }

    public final List<TaskCollaboratorMiniModel> getTaskCollaborators() {
        return this.taskCollaborators;
    }

    public final List<TaskLinkModel> getTaskLinks() {
        return this.taskLinks;
    }
}
