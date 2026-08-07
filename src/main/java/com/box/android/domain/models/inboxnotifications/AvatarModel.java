package com.box.android.domain.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import com.box.androidsdk.content.auth.OAuthActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationPayloadModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/AvatarModel;", "Lcom/box/android/domain/models/DomainModel;", OAuthActivity.USER_ID, "", "initials", "displayName", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "getInitials", "getDisplayName", "getType", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AvatarModel implements DomainModel {
    private final String displayName;
    private final String initials;
    private final String type;
    private final String userId;

    public static /* synthetic */ AvatarModel copy$default(AvatarModel avatarModel, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = avatarModel.userId;
        }
        if ((i & 2) != 0) {
            str2 = avatarModel.initials;
        }
        if ((i & 4) != 0) {
            str3 = avatarModel.displayName;
        }
        if ((i & 8) != 0) {
            str4 = avatarModel.type;
        }
        return avatarModel.copy(str, str2, str3, str4);
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

    public final AvatarModel copy(String userId, String initials, String displayName, String type) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(initials, "initials");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(type, "type");
        return new AvatarModel(userId, initials, displayName, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AvatarModel)) {
            return false;
        }
        AvatarModel avatarModel = (AvatarModel) other;
        return Intrinsics.areEqual(this.userId, avatarModel.userId) && Intrinsics.areEqual(this.initials, avatarModel.initials) && Intrinsics.areEqual(this.displayName, avatarModel.displayName) && Intrinsics.areEqual(this.type, avatarModel.type);
    }

    public int hashCode() {
        return (((((this.userId.hashCode() * 31) + this.initials.hashCode()) * 31) + this.displayName.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "AvatarModel(userId=" + this.userId + ", initials=" + this.initials + ", displayName=" + this.displayName + ", type=" + this.type + ")";
    }

    public AvatarModel(String userId, String initials, String displayName, String type) {
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
