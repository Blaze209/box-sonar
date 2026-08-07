package com.box.android.domain.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.UserModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthenticationInfoModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003J?\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\t\u0010\"\u001a\u00020\u0004HÖ\u0001J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001cR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006("}, d2 = {"Lcom/box/android/domain/models/AuthenticationInfoModel;", "Lcom/box/android/domain/models/DomainModel;", "Landroid/os/Parcelable;", "accessToken", "", "refreshToken", "expiresIn", "", "clientId", "user", "Lcom/box/android/domain/models/item/UserModel;", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Lcom/box/android/domain/models/item/UserModel;)V", "getAccessToken", "()Ljava/lang/String;", "getRefreshToken", "getExpiresIn", "()J", "getClientId", "getUser", "()Lcom/box/android/domain/models/item/UserModel;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AuthenticationInfoModel implements DomainModel, Parcelable {
    public static final Parcelable.Creator<AuthenticationInfoModel> CREATOR = new Creator();
    private final String accessToken;
    private final String clientId;
    private final long expiresIn;
    private final String refreshToken;
    private final UserModel user;

    /* JADX INFO: compiled from: AuthenticationInfoModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AuthenticationInfoModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AuthenticationInfoModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AuthenticationInfoModel(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readInt() == 0 ? null : UserModel.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AuthenticationInfoModel[] newArray(int i) {
            return new AuthenticationInfoModel[i];
        }
    }

    public static /* synthetic */ AuthenticationInfoModel copy$default(AuthenticationInfoModel authenticationInfoModel, String str, String str2, long j, String str3, UserModel userModel, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authenticationInfoModel.accessToken;
        }
        if ((i & 2) != 0) {
            str2 = authenticationInfoModel.refreshToken;
        }
        if ((i & 4) != 0) {
            j = authenticationInfoModel.expiresIn;
        }
        if ((i & 8) != 0) {
            str3 = authenticationInfoModel.clientId;
        }
        if ((i & 16) != 0) {
            userModel = authenticationInfoModel.user;
        }
        long j2 = j;
        return authenticationInfoModel.copy(str, str2, j2, str3, userModel);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getExpiresIn() {
        return this.expiresIn;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final UserModel getUser() {
        return this.user;
    }

    public final AuthenticationInfoModel copy(String accessToken, String refreshToken, long expiresIn, String clientId, UserModel user) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        return new AuthenticationInfoModel(accessToken, refreshToken, expiresIn, clientId, user);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthenticationInfoModel)) {
            return false;
        }
        AuthenticationInfoModel authenticationInfoModel = (AuthenticationInfoModel) other;
        return Intrinsics.areEqual(this.accessToken, authenticationInfoModel.accessToken) && Intrinsics.areEqual(this.refreshToken, authenticationInfoModel.refreshToken) && this.expiresIn == authenticationInfoModel.expiresIn && Intrinsics.areEqual(this.clientId, authenticationInfoModel.clientId) && Intrinsics.areEqual(this.user, authenticationInfoModel.user);
    }

    public int hashCode() {
        int iHashCode = this.accessToken.hashCode() * 31;
        String str = this.refreshToken;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.expiresIn)) * 31) + this.clientId.hashCode()) * 31;
        UserModel userModel = this.user;
        return iHashCode2 + (userModel != null ? userModel.hashCode() : 0);
    }

    public String toString() {
        return "AuthenticationInfoModel(accessToken=" + this.accessToken + ", refreshToken=" + this.refreshToken + ", expiresIn=" + this.expiresIn + ", clientId=" + this.clientId + ", user=" + this.user + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.accessToken);
        dest.writeString(this.refreshToken);
        dest.writeLong(this.expiresIn);
        dest.writeString(this.clientId);
        UserModel userModel = this.user;
        if (userModel == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            userModel.writeToParcel(dest, flags);
        }
    }

    public AuthenticationInfoModel(String accessToken, String str, long j, String clientId, UserModel userModel) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        this.accessToken = accessToken;
        this.refreshToken = str;
        this.expiresIn = j;
        this.clientId = clientId;
        this.user = userModel;
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public final long getExpiresIn() {
        return this.expiresIn;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final UserModel getUser() {
        return this.user;
    }
}
