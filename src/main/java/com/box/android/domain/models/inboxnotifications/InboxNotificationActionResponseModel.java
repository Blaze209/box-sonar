package com.box.android.domain.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationPayloadModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/InboxNotificationActionResponseModel;", "Lcom/box/android/domain/models/DomainModel;", "status", "", "immediateAction", "Lcom/box/android/domain/models/inboxnotifications/ActionModel;", "payload", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/inboxnotifications/ActionModel;Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel;)V", "getStatus", "()Ljava/lang/String;", "getImmediateAction", "()Lcom/box/android/domain/models/inboxnotifications/ActionModel;", "getPayload", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class InboxNotificationActionResponseModel implements DomainModel {
    private final ActionModel immediateAction;
    private final InboxNotificationPayloadModel payload;
    private final String status;

    public static /* synthetic */ InboxNotificationActionResponseModel copy$default(InboxNotificationActionResponseModel inboxNotificationActionResponseModel, String str, ActionModel actionModel, InboxNotificationPayloadModel inboxNotificationPayloadModel, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inboxNotificationActionResponseModel.status;
        }
        if ((i & 2) != 0) {
            actionModel = inboxNotificationActionResponseModel.immediateAction;
        }
        if ((i & 4) != 0) {
            inboxNotificationPayloadModel = inboxNotificationActionResponseModel.payload;
        }
        return inboxNotificationActionResponseModel.copy(str, actionModel, inboxNotificationPayloadModel);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ActionModel getImmediateAction() {
        return this.immediateAction;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final InboxNotificationPayloadModel getPayload() {
        return this.payload;
    }

    public final InboxNotificationActionResponseModel copy(String status, ActionModel immediateAction, InboxNotificationPayloadModel payload) {
        Intrinsics.checkNotNullParameter(status, "status");
        return new InboxNotificationActionResponseModel(status, immediateAction, payload);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboxNotificationActionResponseModel)) {
            return false;
        }
        InboxNotificationActionResponseModel inboxNotificationActionResponseModel = (InboxNotificationActionResponseModel) other;
        return Intrinsics.areEqual(this.status, inboxNotificationActionResponseModel.status) && Intrinsics.areEqual(this.immediateAction, inboxNotificationActionResponseModel.immediateAction) && Intrinsics.areEqual(this.payload, inboxNotificationActionResponseModel.payload);
    }

    public int hashCode() {
        int iHashCode = this.status.hashCode() * 31;
        ActionModel actionModel = this.immediateAction;
        int iHashCode2 = (iHashCode + (actionModel == null ? 0 : actionModel.hashCode())) * 31;
        InboxNotificationPayloadModel inboxNotificationPayloadModel = this.payload;
        return iHashCode2 + (inboxNotificationPayloadModel != null ? inboxNotificationPayloadModel.hashCode() : 0);
    }

    public String toString() {
        return "InboxNotificationActionResponseModel(status=" + this.status + ", immediateAction=" + this.immediateAction + ", payload=" + this.payload + ")";
    }

    public InboxNotificationActionResponseModel(String status, ActionModel actionModel, InboxNotificationPayloadModel inboxNotificationPayloadModel) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.status = status;
        this.immediateAction = actionModel;
        this.payload = inboxNotificationPayloadModel;
    }

    public final String getStatus() {
        return this.status;
    }

    public final ActionModel getImmediateAction() {
        return this.immediateAction;
    }

    public final InboxNotificationPayloadModel getPayload() {
        return this.payload;
    }
}
