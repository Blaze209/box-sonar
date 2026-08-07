package com.microsoft.identity.common.java.nativeauth.providers;

import com.microsoft.identity.common.java.nativeauth.util.ILoggable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: INativeAuthApiResponse.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b&\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0016\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0016\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/INativeAuthApiResponse;", "Lcom/microsoft/identity/common/java/nativeauth/util/ILoggable;", "statusCode", "", "correlationId", "", "continuationToken", "challengeType", "redirectReason", "error", "errorDescription", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChallengeType", "()Ljava/lang/String;", "getContinuationToken", "<set-?>", "getCorrelationId", "setCorrelationId$common4j", "(Ljava/lang/String;)V", "getError", "getErrorDescription", "getRedirectReason", "getStatusCode", "()I", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class INativeAuthApiResponse implements ILoggable {
    private final transient String challengeType;
    private final transient String continuationToken;
    private String correlationId;
    private final transient String error;
    private final transient String errorDescription;
    private final transient String redirectReason;
    private final transient int statusCode;

    public INativeAuthApiResponse(int i, String correlationId, String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        this.statusCode = i;
        this.continuationToken = str;
        this.challengeType = str2;
        this.redirectReason = str3;
        this.error = str4;
        this.errorDescription = str5;
        this.correlationId = correlationId;
    }

    public /* synthetic */ INativeAuthApiResponse(int i, String str, String str2, String str3, String str4, String str5, String str6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? null : str5, (i2 & 64) != 0 ? null : str6);
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    public boolean containsPii() {
        return ILoggable.DefaultImpls.containsPii(this);
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getContinuationToken() {
        return this.continuationToken;
    }

    public String getChallengeType() {
        return this.challengeType;
    }

    public String getRedirectReason() {
        return this.redirectReason;
    }

    public String getError() {
        return this.error;
    }

    public String getErrorDescription() {
        return this.errorDescription;
    }

    public final String getCorrelationId() {
        return this.correlationId;
    }

    public final void setCorrelationId$common4j(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.correlationId = str;
    }
}
