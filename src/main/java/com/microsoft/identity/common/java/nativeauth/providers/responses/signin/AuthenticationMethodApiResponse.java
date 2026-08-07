package com.microsoft.identity.common.java.nativeauth.providers.responses.signin;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.nativeauth.util.ILoggable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthenticationMethodApiResponse.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/AuthenticationMethodApiResponse;", "Lcom/microsoft/identity/common/java/nativeauth/util/ILoggable;", "id", "", "challengeType", "loginHint", "challengeChannel", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChallengeChannel", "()Ljava/lang/String;", "getChallengeType", "getId", "getLoginHint", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AuthenticationMethodApiResponse implements ILoggable {

    @SerializedName("challenge_channel")
    @Expose
    private final String challengeChannel;

    @SerializedName("challenge_type")
    @Expose
    private final String challengeType;

    @SerializedName("id")
    @Expose
    private final String id;

    @SerializedName("login_hint")
    private final String loginHint;

    public static /* synthetic */ AuthenticationMethodApiResponse copy$default(AuthenticationMethodApiResponse authenticationMethodApiResponse, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authenticationMethodApiResponse.id;
        }
        if ((i & 2) != 0) {
            str2 = authenticationMethodApiResponse.challengeType;
        }
        if ((i & 4) != 0) {
            str3 = authenticationMethodApiResponse.loginHint;
        }
        if ((i & 8) != 0) {
            str4 = authenticationMethodApiResponse.challengeChannel;
        }
        return authenticationMethodApiResponse.copy(str, str2, str3, str4);
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

    public final AuthenticationMethodApiResponse copy(String id, String challengeType, String loginHint, String challengeChannel) {
        return new AuthenticationMethodApiResponse(id, challengeType, loginHint, challengeChannel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthenticationMethodApiResponse)) {
            return false;
        }
        AuthenticationMethodApiResponse authenticationMethodApiResponse = (AuthenticationMethodApiResponse) other;
        return Intrinsics.areEqual(this.id, authenticationMethodApiResponse.id) && Intrinsics.areEqual(this.challengeType, authenticationMethodApiResponse.challengeType) && Intrinsics.areEqual(this.loginHint, authenticationMethodApiResponse.loginHint) && Intrinsics.areEqual(this.challengeChannel, authenticationMethodApiResponse.challengeChannel);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.challengeType;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.loginHint;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.challengeChannel;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public AuthenticationMethodApiResponse(String str, String str2, String str3, String str4) {
        this.id = str;
        this.challengeType = str2;
        this.loginHint = str3;
        this.challengeChannel = str4;
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
        return "AuthenticationMethod(id=" + this.id + ", challenge_type=" + this.challengeType + ", login_hint=" + this.loginHint + ", challenge_channel=" + this.challengeChannel + ')';
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public String toString() {
        return "AuthenticationMethod(id=" + this.id + ')';
    }
}
