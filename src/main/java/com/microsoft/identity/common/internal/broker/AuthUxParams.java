package com.microsoft.identity.common.internal.broker;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthUxJsonPayload.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/microsoft/identity/common/internal/broker/AuthUxParams;", "", SerializedNames.OPERATION, "", "sessionId", "codeMatch", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCodeMatch", "()Ljava/lang/String;", "getOperation", "getSessionId", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AuthUxParams {

    @SerializedName(SerializedNames.CODE_MATCH)
    private final String codeMatch;

    @SerializedName(SerializedNames.OPERATION)
    private final String operation;

    @SerializedName(SerializedNames.SESSION_ID)
    private final String sessionId;

    public static /* synthetic */ AuthUxParams copy$default(AuthUxParams authUxParams, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authUxParams.operation;
        }
        if ((i & 2) != 0) {
            str2 = authUxParams.sessionId;
        }
        if ((i & 4) != 0) {
            str3 = authUxParams.codeMatch;
        }
        return authUxParams.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOperation() {
        return this.operation;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCodeMatch() {
        return this.codeMatch;
    }

    public final AuthUxParams copy(String operation, String sessionId, String codeMatch) {
        return new AuthUxParams(operation, sessionId, codeMatch);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthUxParams)) {
            return false;
        }
        AuthUxParams authUxParams = (AuthUxParams) other;
        return Intrinsics.areEqual(this.operation, authUxParams.operation) && Intrinsics.areEqual(this.sessionId, authUxParams.sessionId) && Intrinsics.areEqual(this.codeMatch, authUxParams.codeMatch);
    }

    public int hashCode() {
        String str = this.operation;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.sessionId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.codeMatch;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "AuthUxParams(operation=" + this.operation + ", sessionId=" + this.sessionId + ", codeMatch=" + this.codeMatch + ')';
    }

    public AuthUxParams(String str, String str2, String str3) {
        this.operation = str;
        this.sessionId = str2;
        this.codeMatch = str3;
    }

    public final String getOperation() {
        return this.operation;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getCodeMatch() {
        return this.codeMatch;
    }
}
