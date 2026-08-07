package com.box.android.data.api.models.pushnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationCategoriesDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\u0003\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JY\u0010\u001e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u00032\b\b\u0003\u0010\t\u001a\u00020\u00032\b\b\u0003\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006&"}, d2 = {"Lcom/box/android/data/api/models/pushnotifications/NotificationCategoriesDTO;", "", "sharing", "Lcom/box/android/data/api/models/pushnotifications/NotificationCategoryDTO;", "mentions", "tasks", "relevantUpdates", "commentCreated", "collaborationInvite", SemanticAttributes.FaasDocumentOperationValues.EDIT, BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_UPLOAD_JOB, "<init>", "(Lcom/box/android/data/api/models/pushnotifications/NotificationCategoryDTO;Lcom/box/android/data/api/models/pushnotifications/NotificationCategoryDTO;Lcom/box/android/data/api/models/pushnotifications/NotificationCategoryDTO;Lcom/box/android/data/api/models/pushnotifications/NotificationCategoryDTO;Lcom/box/android/data/api/models/pushnotifications/NotificationCategoryDTO;Lcom/box/android/data/api/models/pushnotifications/NotificationCategoryDTO;Lcom/box/android/data/api/models/pushnotifications/NotificationCategoryDTO;Lcom/box/android/data/api/models/pushnotifications/NotificationCategoryDTO;)V", "getSharing", "()Lcom/box/android/data/api/models/pushnotifications/NotificationCategoryDTO;", "getMentions", "getTasks", "getRelevantUpdates", "getCommentCreated", "getCollaborationInvite", "getEdit", "getUpload", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class NotificationCategoriesDTO {
    private final NotificationCategoryDTO collaborationInvite;
    private final NotificationCategoryDTO commentCreated;
    private final NotificationCategoryDTO edit;
    private final NotificationCategoryDTO mentions;
    private final NotificationCategoryDTO relevantUpdates;
    private final NotificationCategoryDTO sharing;
    private final NotificationCategoryDTO tasks;
    private final NotificationCategoryDTO upload;

    public static /* synthetic */ NotificationCategoriesDTO copy$default(NotificationCategoriesDTO notificationCategoriesDTO, NotificationCategoryDTO notificationCategoryDTO, NotificationCategoryDTO notificationCategoryDTO2, NotificationCategoryDTO notificationCategoryDTO3, NotificationCategoryDTO notificationCategoryDTO4, NotificationCategoryDTO notificationCategoryDTO5, NotificationCategoryDTO notificationCategoryDTO6, NotificationCategoryDTO notificationCategoryDTO7, NotificationCategoryDTO notificationCategoryDTO8, int i, Object obj) {
        if ((i & 1) != 0) {
            notificationCategoryDTO = notificationCategoriesDTO.sharing;
        }
        if ((i & 2) != 0) {
            notificationCategoryDTO2 = notificationCategoriesDTO.mentions;
        }
        if ((i & 4) != 0) {
            notificationCategoryDTO3 = notificationCategoriesDTO.tasks;
        }
        if ((i & 8) != 0) {
            notificationCategoryDTO4 = notificationCategoriesDTO.relevantUpdates;
        }
        if ((i & 16) != 0) {
            notificationCategoryDTO5 = notificationCategoriesDTO.commentCreated;
        }
        if ((i & 32) != 0) {
            notificationCategoryDTO6 = notificationCategoriesDTO.collaborationInvite;
        }
        if ((i & 64) != 0) {
            notificationCategoryDTO7 = notificationCategoriesDTO.edit;
        }
        if ((i & 128) != 0) {
            notificationCategoryDTO8 = notificationCategoriesDTO.upload;
        }
        NotificationCategoryDTO notificationCategoryDTO9 = notificationCategoryDTO7;
        NotificationCategoryDTO notificationCategoryDTO10 = notificationCategoryDTO8;
        NotificationCategoryDTO notificationCategoryDTO11 = notificationCategoryDTO5;
        NotificationCategoryDTO notificationCategoryDTO12 = notificationCategoryDTO6;
        return notificationCategoriesDTO.copy(notificationCategoryDTO, notificationCategoryDTO2, notificationCategoryDTO3, notificationCategoryDTO4, notificationCategoryDTO11, notificationCategoryDTO12, notificationCategoryDTO9, notificationCategoryDTO10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final NotificationCategoryDTO getSharing() {
        return this.sharing;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final NotificationCategoryDTO getMentions() {
        return this.mentions;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final NotificationCategoryDTO getTasks() {
        return this.tasks;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final NotificationCategoryDTO getRelevantUpdates() {
        return this.relevantUpdates;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final NotificationCategoryDTO getCommentCreated() {
        return this.commentCreated;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final NotificationCategoryDTO getCollaborationInvite() {
        return this.collaborationInvite;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final NotificationCategoryDTO getEdit() {
        return this.edit;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final NotificationCategoryDTO getUpload() {
        return this.upload;
    }

    public final NotificationCategoriesDTO copy(@Json(name = "SHARING") NotificationCategoryDTO sharing, @Json(name = "MENTIONS") NotificationCategoryDTO mentions, @Json(name = "TASKS") NotificationCategoryDTO tasks, @Json(name = "RELEVANT_UPDATES") NotificationCategoryDTO relevantUpdates, @Json(name = "EVENT_COMMENT_CREATE") NotificationCategoryDTO commentCreated, @Json(name = "EVENT_COLLAB_INVITE_COLLABORATOR") NotificationCategoryDTO collaborationInvite, @Json(name = "EVENT_ITEM_MODIFY") NotificationCategoryDTO edit, @Json(name = "EVENT_ITEM_UPLOAD") NotificationCategoryDTO upload) {
        Intrinsics.checkNotNullParameter(sharing, "sharing");
        Intrinsics.checkNotNullParameter(mentions, "mentions");
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        Intrinsics.checkNotNullParameter(relevantUpdates, "relevantUpdates");
        Intrinsics.checkNotNullParameter(commentCreated, "commentCreated");
        Intrinsics.checkNotNullParameter(collaborationInvite, "collaborationInvite");
        Intrinsics.checkNotNullParameter(edit, "edit");
        Intrinsics.checkNotNullParameter(upload, "upload");
        return new NotificationCategoriesDTO(sharing, mentions, tasks, relevantUpdates, commentCreated, collaborationInvite, edit, upload);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotificationCategoriesDTO)) {
            return false;
        }
        NotificationCategoriesDTO notificationCategoriesDTO = (NotificationCategoriesDTO) other;
        return Intrinsics.areEqual(this.sharing, notificationCategoriesDTO.sharing) && Intrinsics.areEqual(this.mentions, notificationCategoriesDTO.mentions) && Intrinsics.areEqual(this.tasks, notificationCategoriesDTO.tasks) && Intrinsics.areEqual(this.relevantUpdates, notificationCategoriesDTO.relevantUpdates) && Intrinsics.areEqual(this.commentCreated, notificationCategoriesDTO.commentCreated) && Intrinsics.areEqual(this.collaborationInvite, notificationCategoriesDTO.collaborationInvite) && Intrinsics.areEqual(this.edit, notificationCategoriesDTO.edit) && Intrinsics.areEqual(this.upload, notificationCategoriesDTO.upload);
    }

    public int hashCode() {
        return (((((((((((((this.sharing.hashCode() * 31) + this.mentions.hashCode()) * 31) + this.tasks.hashCode()) * 31) + this.relevantUpdates.hashCode()) * 31) + this.commentCreated.hashCode()) * 31) + this.collaborationInvite.hashCode()) * 31) + this.edit.hashCode()) * 31) + this.upload.hashCode();
    }

    public String toString() {
        return "NotificationCategoriesDTO(sharing=" + this.sharing + ", mentions=" + this.mentions + ", tasks=" + this.tasks + ", relevantUpdates=" + this.relevantUpdates + ", commentCreated=" + this.commentCreated + ", collaborationInvite=" + this.collaborationInvite + ", edit=" + this.edit + ", upload=" + this.upload + ")";
    }

    public NotificationCategoriesDTO(@Json(name = "SHARING") NotificationCategoryDTO sharing, @Json(name = "MENTIONS") NotificationCategoryDTO mentions, @Json(name = "TASKS") NotificationCategoryDTO tasks, @Json(name = "RELEVANT_UPDATES") NotificationCategoryDTO relevantUpdates, @Json(name = "EVENT_COMMENT_CREATE") NotificationCategoryDTO commentCreated, @Json(name = "EVENT_COLLAB_INVITE_COLLABORATOR") NotificationCategoryDTO collaborationInvite, @Json(name = "EVENT_ITEM_MODIFY") NotificationCategoryDTO edit, @Json(name = "EVENT_ITEM_UPLOAD") NotificationCategoryDTO upload) {
        Intrinsics.checkNotNullParameter(sharing, "sharing");
        Intrinsics.checkNotNullParameter(mentions, "mentions");
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        Intrinsics.checkNotNullParameter(relevantUpdates, "relevantUpdates");
        Intrinsics.checkNotNullParameter(commentCreated, "commentCreated");
        Intrinsics.checkNotNullParameter(collaborationInvite, "collaborationInvite");
        Intrinsics.checkNotNullParameter(edit, "edit");
        Intrinsics.checkNotNullParameter(upload, "upload");
        this.sharing = sharing;
        this.mentions = mentions;
        this.tasks = tasks;
        this.relevantUpdates = relevantUpdates;
        this.commentCreated = commentCreated;
        this.collaborationInvite = collaborationInvite;
        this.edit = edit;
        this.upload = upload;
    }

    public final NotificationCategoryDTO getSharing() {
        return this.sharing;
    }

    public final NotificationCategoryDTO getMentions() {
        return this.mentions;
    }

    public final NotificationCategoryDTO getTasks() {
        return this.tasks;
    }

    public final NotificationCategoryDTO getRelevantUpdates() {
        return this.relevantUpdates;
    }

    public final NotificationCategoryDTO getCommentCreated() {
        return this.commentCreated;
    }

    public final NotificationCategoryDTO getCollaborationInvite() {
        return this.collaborationInvite;
    }

    public final NotificationCategoryDTO getEdit() {
        return this.edit;
    }

    public final NotificationCategoryDTO getUpload() {
        return this.upload;
    }
}
