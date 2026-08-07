package com.box.android.domain.models.pushnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;

/* JADX INFO: compiled from: NotificationCategoriesModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JY\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006&"}, d2 = {"Lcom/box/android/domain/models/pushnotifications/NotificationCategoriesModel;", "Lcom/box/android/domain/models/DomainModel;", "sharing", "", "mentions", "tasks", "relevantUpdates", "comment", "collaborationInvite", SemanticAttributes.FaasDocumentOperationValues.EDIT, BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_UPLOAD_JOB, "<init>", "(ZZZZZZZZ)V", "getSharing", "()Z", "getMentions", "getTasks", "getRelevantUpdates", "getComment", "getCollaborationInvite", "getEdit", "getUpload", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class NotificationCategoriesModel implements DomainModel {
    private final boolean collaborationInvite;
    private final boolean comment;
    private final boolean edit;
    private final boolean mentions;
    private final boolean relevantUpdates;
    private final boolean sharing;
    private final boolean tasks;
    private final boolean upload;

    public static /* synthetic */ NotificationCategoriesModel copy$default(NotificationCategoriesModel notificationCategoriesModel, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, int i, Object obj) {
        if ((i & 1) != 0) {
            z = notificationCategoriesModel.sharing;
        }
        if ((i & 2) != 0) {
            z2 = notificationCategoriesModel.mentions;
        }
        if ((i & 4) != 0) {
            z3 = notificationCategoriesModel.tasks;
        }
        if ((i & 8) != 0) {
            z4 = notificationCategoriesModel.relevantUpdates;
        }
        if ((i & 16) != 0) {
            z5 = notificationCategoriesModel.comment;
        }
        if ((i & 32) != 0) {
            z6 = notificationCategoriesModel.collaborationInvite;
        }
        if ((i & 64) != 0) {
            z7 = notificationCategoriesModel.edit;
        }
        if ((i & 128) != 0) {
            z8 = notificationCategoriesModel.upload;
        }
        boolean z9 = z7;
        boolean z10 = z8;
        boolean z11 = z5;
        boolean z12 = z6;
        return notificationCategoriesModel.copy(z, z2, z3, z4, z11, z12, z9, z10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getSharing() {
        return this.sharing;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getMentions() {
        return this.mentions;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getTasks() {
        return this.tasks;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getRelevantUpdates() {
        return this.relevantUpdates;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getComment() {
        return this.comment;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getCollaborationInvite() {
        return this.collaborationInvite;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getEdit() {
        return this.edit;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getUpload() {
        return this.upload;
    }

    public final NotificationCategoriesModel copy(boolean sharing, boolean mentions, boolean tasks, boolean relevantUpdates, boolean comment, boolean collaborationInvite, boolean edit, boolean upload) {
        return new NotificationCategoriesModel(sharing, mentions, tasks, relevantUpdates, comment, collaborationInvite, edit, upload);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotificationCategoriesModel)) {
            return false;
        }
        NotificationCategoriesModel notificationCategoriesModel = (NotificationCategoriesModel) other;
        return this.sharing == notificationCategoriesModel.sharing && this.mentions == notificationCategoriesModel.mentions && this.tasks == notificationCategoriesModel.tasks && this.relevantUpdates == notificationCategoriesModel.relevantUpdates && this.comment == notificationCategoriesModel.comment && this.collaborationInvite == notificationCategoriesModel.collaborationInvite && this.edit == notificationCategoriesModel.edit && this.upload == notificationCategoriesModel.upload;
    }

    public int hashCode() {
        return (((((((((((((Boolean.hashCode(this.sharing) * 31) + Boolean.hashCode(this.mentions)) * 31) + Boolean.hashCode(this.tasks)) * 31) + Boolean.hashCode(this.relevantUpdates)) * 31) + Boolean.hashCode(this.comment)) * 31) + Boolean.hashCode(this.collaborationInvite)) * 31) + Boolean.hashCode(this.edit)) * 31) + Boolean.hashCode(this.upload);
    }

    public String toString() {
        return "NotificationCategoriesModel(sharing=" + this.sharing + ", mentions=" + this.mentions + ", tasks=" + this.tasks + ", relevantUpdates=" + this.relevantUpdates + ", comment=" + this.comment + ", collaborationInvite=" + this.collaborationInvite + ", edit=" + this.edit + ", upload=" + this.upload + ")";
    }

    public NotificationCategoriesModel(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        this.sharing = z;
        this.mentions = z2;
        this.tasks = z3;
        this.relevantUpdates = z4;
        this.comment = z5;
        this.collaborationInvite = z6;
        this.edit = z7;
        this.upload = z8;
    }

    public final boolean getSharing() {
        return this.sharing;
    }

    public final boolean getMentions() {
        return this.mentions;
    }

    public final boolean getTasks() {
        return this.tasks;
    }

    public final boolean getRelevantUpdates() {
        return this.relevantUpdates;
    }

    public final boolean getComment() {
        return this.comment;
    }

    public final boolean getCollaborationInvite() {
        return this.collaborationInvite;
    }

    public final boolean getEdit() {
        return this.edit;
    }

    public final boolean getUpload() {
        return this.upload;
    }
}
