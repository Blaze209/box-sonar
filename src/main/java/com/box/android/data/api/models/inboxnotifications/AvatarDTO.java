package com.box.android.data.api.models.inboxnotifications;

import com.amplitude.api.AmplitudeClient;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.auth.OAuthActivity;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationPayloadDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/box/android/data/api/models/inboxnotifications/AvatarDTO;", "", OAuthActivity.USER_ID, "", "initials", "displayName", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "getInitials", "getDisplayName", "getType", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AvatarDTO {
    private final String displayName;
    private final String initials;
    private final String type;
    private final String userId;

    public static /* synthetic */ AvatarDTO copy$default(AvatarDTO avatarDTO, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = avatarDTO.userId;
        }
        if ((i & 2) != 0) {
            str2 = avatarDTO.initials;
        }
        if ((i & 4) != 0) {
            str3 = avatarDTO.displayName;
        }
        if ((i & 8) != 0) {
            str4 = avatarDTO.type;
        }
        return avatarDTO.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getInitials() {
        return this.initials;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final AvatarDTO copy(@Json(name = AmplitudeClient.USER_ID_KEY) String userId, @Json(name = "initials") String initials, @Json(name = "display_name") String displayName, @Json(name = "type") String type) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(initials, "initials");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(type, "type");
        return new AvatarDTO(userId, initials, displayName, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AvatarDTO)) {
            return false;
        }
        AvatarDTO avatarDTO = (AvatarDTO) other;
        return Intrinsics.areEqual(this.userId, avatarDTO.userId) && Intrinsics.areEqual(this.initials, avatarDTO.initials) && Intrinsics.areEqual(this.displayName, avatarDTO.displayName) && Intrinsics.areEqual(this.type, avatarDTO.type);
    }

    public int hashCode() {
        return (((((this.userId.hashCode() * 31) + this.initials.hashCode()) * 31) + this.displayName.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "AvatarDTO(userId=" + this.userId + ", initials=" + this.initials + ", displayName=" + this.displayName + ", type=" + this.type + ")";
    }

    public AvatarDTO(@Json(name = AmplitudeClient.USER_ID_KEY) String userId, @Json(name = "initials") String initials, @Json(name = "display_name") String displayName, @Json(name = "type") String type) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(initials, "initials");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(type, "type");
        this.userId = userId;
        this.initials = initials;
        this.displayName = displayName;
        this.type = type;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getInitials() {
        return this.initials;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getType() {
        return this.type;
    }
}
