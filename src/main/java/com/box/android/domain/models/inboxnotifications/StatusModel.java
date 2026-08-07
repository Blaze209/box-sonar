package com.box.android.domain.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.box.android.domain.models.DomainModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationPayloadModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/StatusModel;", "Lcom/box/android/domain/models/DomainModel;", "type", "", HubsObservability.HUB_ASSET_ICON, "Lcom/box/android/domain/models/inboxnotifications/IconModel;", "text", "Lcom/box/android/domain/models/inboxnotifications/TextModel;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/inboxnotifications/IconModel;Lcom/box/android/domain/models/inboxnotifications/TextModel;)V", "getType", "()Ljava/lang/String;", "getIcon", "()Lcom/box/android/domain/models/inboxnotifications/IconModel;", "getText", "()Lcom/box/android/domain/models/inboxnotifications/TextModel;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class StatusModel implements DomainModel {
    private final IconModel icon;
    private final TextModel text;
    private final String type;

    public static /* synthetic */ StatusModel copy$default(StatusModel statusModel, String str, IconModel iconModel, TextModel textModel, int i, Object obj) {
        if ((i & 1) != 0) {
            str = statusModel.type;
        }
        if ((i & 2) != 0) {
            iconModel = statusModel.icon;
        }
        if ((i & 4) != 0) {
            textModel = statusModel.text;
        }
        return statusModel.copy(str, iconModel, textModel);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final IconModel getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final TextModel getText() {
        return this.text;
    }

    public final StatusModel copy(String type, IconModel icon, TextModel text) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new StatusModel(type, icon, text);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StatusModel)) {
            return false;
        }
        StatusModel statusModel = (StatusModel) other;
        return Intrinsics.areEqual(this.type, statusModel.type) && Intrinsics.areEqual(this.icon, statusModel.icon) && Intrinsics.areEqual(this.text, statusModel.text);
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        IconModel iconModel = this.icon;
        int iHashCode2 = (iHashCode + (iconModel == null ? 0 : iconModel.hashCode())) * 31;
        TextModel textModel = this.text;
        return iHashCode2 + (textModel != null ? textModel.hashCode() : 0);
    }

    public String toString() {
        return "StatusModel(type=" + this.type + ", icon=" + this.icon + ", text=" + this.text + ")";
    }

    public StatusModel(String type, IconModel iconModel, TextModel textModel) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.icon = iconModel;
        this.text = textModel;
    }

    public final IconModel getIcon() {
        return this.icon;
    }

    public final TextModel getText() {
        return this.text;
    }

    public final String getType() {
        return this.type;
    }
}
