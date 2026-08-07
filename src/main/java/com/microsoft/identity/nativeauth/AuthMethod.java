package com.microsoft.identity.nativeauth;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.boxandroidlibv2private.model.BoxTaskCollaborator;
import com.microsoft.identity.common.java.nativeauth.util.ILoggable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthMethod.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B'\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0017HÖ\u0001J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0017H\u0016R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006#"}, d2 = {"Lcom/microsoft/identity/nativeauth/AuthMethod;", "Lcom/microsoft/identity/common/java/nativeauth/util/ILoggable;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "challengeType", "loginHint", "challengeChannel", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChallengeChannel", "()Ljava/lang/String;", "getChallengeType", "getId", "getLoginHint", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "writeToParcel", "", "flags", BoxTaskCollaborator.ROLE_CREATOR, "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AuthMethod implements ILoggable, Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String challengeChannel;
    private final String challengeType;
    private final String id;
    private final String loginHint;

    public static /* synthetic */ AuthMethod copy$default(AuthMethod authMethod, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authMethod.id;
        }
        if ((i & 2) != 0) {
            str2 = authMethod.challengeType;
        }
        if ((i & 4) != 0) {
            str3 = authMethod.loginHint;
        }
        if ((i & 8) != 0) {
            str4 = authMethod.challengeChannel;
        }
        return authMethod.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getChallengeType() {
        return this.challengeType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLoginHint() {
        return this.loginHint;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getChallengeChannel() {
        return this.challengeChannel;
    }

    public final AuthMethod copy(String id, String challengeType, String loginHint, String challengeChannel) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(challengeType, "challengeType");
        Intrinsics.checkNotNullParameter(challengeChannel, "challengeChannel");
        return new AuthMethod(id, challengeType, loginHint, challengeChannel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthMethod)) {
            return false;
        }
        AuthMethod authMethod = (AuthMethod) other;
        return Intrinsics.areEqual(this.id, authMethod.id) && Intrinsics.areEqual(this.challengeType, authMethod.challengeType) && Intrinsics.areEqual(this.loginHint, authMethod.loginHint) && Intrinsics.areEqual(this.challengeChannel, authMethod.challengeChannel);
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.challengeType.hashCode()) * 31;
        String str = this.loginHint;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.challengeChannel.hashCode();
    }

    public AuthMethod(String id, String challengeType, String str, String challengeChannel) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(challengeType, "challengeType");
        Intrinsics.checkNotNullParameter(challengeChannel, "challengeChannel");
        this.id = id;
        this.challengeType = challengeType;
        this.loginHint = str;
        this.challengeChannel = challengeChannel;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public boolean containsPii() {
        return ILoggable.DefaultImpls.containsPii(this);
    }

    public final String getId() {
        return this.id;
    }

    public final String getChallengeType() {
        return this.challengeType;
    }

    public final String getLoginHint() {
        return this.loginHint;
    }

    public final String getChallengeChannel() {
        return this.challengeChannel;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toUnsanitizedString() {
        return "AuthMethod(id=" + this.id + ", challengeType=" + this.challengeType + ", loginHint=" + this.loginHint + ", challengeChannel=" + this.challengeChannel + ')';
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return "AuthMethod(id=" + this.id + ", challengeType=" + this.challengeType + ", challengeChannel=" + this.challengeChannel + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AuthMethod(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String string = parcel.readString();
        string = string == null ? "" : string;
        String string2 = parcel.readString();
        string2 = string2 == null ? "" : string2;
        String string3 = parcel.readString();
        string3 = string3 == null ? "" : string3;
        String string4 = parcel.readString();
        this(string, string2, string3, string4 != null ? string4 : "");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.challengeType);
        parcel.writeString(this.loginHint);
        parcel.writeString(this.challengeChannel);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.AuthMethod$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: AuthMethod.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/microsoft/identity/nativeauth/AuthMethod$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/microsoft/identity/nativeauth/AuthMethod;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/microsoft/identity/nativeauth/AuthMethod;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion implements Parcelable.Creator<AuthMethod> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AuthMethod createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AuthMethod(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AuthMethod[] newArray(int size) {
            return new AuthMethod[size];
        }
    }
}
