package com.box.android.data.api.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationPayloadDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/box/android/data/api/models/inboxnotifications/StatusDTO;", "", "type", "", HubsObservability.HUB_ASSET_ICON, "Lcom/box/android/data/api/models/inboxnotifications/IconDTO;", "text", "Lcom/box/android/data/api/models/inboxnotifications/TextDTO;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/api/models/inboxnotifications/IconDTO;Lcom/box/android/data/api/models/inboxnotifications/TextDTO;)V", "getType", "()Ljava/lang/String;", "getIcon", "()Lcom/box/android/data/api/models/inboxnotifications/IconDTO;", "getText", "()Lcom/box/android/data/api/models/inboxnotifications/TextDTO;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class StatusDTO {
    private final IconDTO icon;
    private final TextDTO text;
    private final String type;

    public static /* synthetic */ StatusDTO copy$default(StatusDTO statusDTO, String str, IconDTO iconDTO, TextDTO textDTO, int i, Object obj) {
        if ((i & 1) != 0) {
            str = statusDTO.type;
        }
        if ((i & 2) != 0) {
            iconDTO = statusDTO.icon;
        }
        if ((i & 4) != 0) {
            textDTO = statusDTO.text;
        }
        return statusDTO.copy(str, iconDTO, textDTO);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final IconDTO getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final TextDTO getText() {
        return this.text;
    }

    public final StatusDTO copy(@Json(name = "type") String type, @Json(name = HubsObservability.HUB_ASSET_ICON) IconDTO icon, @Json(name = "text") TextDTO text) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new StatusDTO(type, icon, text);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StatusDTO)) {
            return false;
        }
        StatusDTO statusDTO = (StatusDTO) other;
        return Intrinsics.areEqual(this.type, statusDTO.type) && Intrinsics.areEqual(this.icon, statusDTO.icon) && Intrinsics.areEqual(this.text, statusDTO.text);
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        IconDTO iconDTO = this.icon;
        int iHashCode2 = (iHashCode + (iconDTO == null ? 0 : iconDTO.hashCode())) * 31;
        TextDTO textDTO = this.text;
        return iHashCode2 + (textDTO != null ? textDTO.hashCode() : 0);
    }

    public String toString() {
        return "StatusDTO(type=" + this.type + ", icon=" + this.icon + ", text=" + this.text + ")";
    }

    public StatusDTO(@Json(name = "type") String type, @Json(name = HubsObservability.HUB_ASSET_ICON) IconDTO iconDTO, @Json(name = "text") TextDTO textDTO) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.icon = iconDTO;
        this.text = textDTO;
    }

    public final String getType() {
        return this.type;
    }

    public final IconDTO getIcon() {
        return this.icon;
    }

    public final TextDTO getText() {
        return this.text;
    }
}
