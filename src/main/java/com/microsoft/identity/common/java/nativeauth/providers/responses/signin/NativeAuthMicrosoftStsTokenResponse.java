package com.microsoft.identity.common.java.nativeauth.providers.responses.signin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsTokenResponse;
import kotlin.Metadata;

/* JADX INFO: compiled from: NativeAuthMicrosoftStsTokenResponse.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/NativeAuthMicrosoftStsTokenResponse;", "Lcom/microsoft/identity/common/java/providers/microsoft/microsoftsts/MicrosoftStsTokenResponse;", "()V", "challengeType", "", "getChallengeType", "()Ljava/lang/String;", "setChallengeType", "(Ljava/lang/String;)V", "redirectReason", "getRedirectReason", "setRedirectReason", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NativeAuthMicrosoftStsTokenResponse extends MicrosoftStsTokenResponse {

    @SerializedName("challenge_type")
    @Expose
    private String challengeType;

    @SerializedName("redirect_reason")
    private String redirectReason;

    public final String getRedirectReason() {
        return this.redirectReason;
    }

    public final void setRedirectReason(String str) {
        this.redirectReason = str;
    }

    public final String getChallengeType() {
        return this.challengeType;
    }

    public final void setChallengeType(String str) {
        this.challengeType = str;
    }
}
