package com.microsoft.identity.common.java.nativeauth.providers.responses.signup;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyReplyChannel;
import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignUpStartApiResult.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\t\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u0082\u0001\t\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiResult;", "AuthNotSupported", "InvalidAttributes", "InvalidPassword", "InvalidUsername", "Redirect", "Success", PasskeyReplyChannel.DOM_EXCEPTION_UNKNOWN_ERROR, "UnsupportedChallengeType", "UsernameAlreadyExists", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$AuthNotSupported;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$InvalidAttributes;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$InvalidPassword;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$InvalidUsername;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$Redirect;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$Success;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$UnknownError;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$UnsupportedChallengeType;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$UsernameAlreadyExists;", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SignUpStartApiResult extends ApiResult {

    /* JADX INFO: compiled from: SignUpStartApiResult.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean containsPii(SignUpStartApiResult signUpStartApiResult) {
            return ApiResult.DefaultImpls.containsPii(signUpStartApiResult);
        }
    }

    /* JADX INFO: compiled from: SignUpStartApiResult.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$Redirect;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult;", "correlationId", "", "redirectReason", "(Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getRedirectReason", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Redirect implements SignUpStartApiResult {
        private final String correlationId;
        private final String redirectReason;

        public static /* synthetic */ Redirect copy$default(Redirect redirect, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = redirect.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = redirect.redirectReason;
            }
            return redirect.copy(str, str2);
        }

        public final String component1() {
            return getCorrelationId();
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getRedirectReason() {
            return this.redirectReason;
        }

        public final Redirect copy(String correlationId, String redirectReason) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(redirectReason, "redirectReason");
            return new Redirect(correlationId, redirectReason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Redirect)) {
                return false;
            }
            Redirect redirect = (Redirect) other;
            return Intrinsics.areEqual(getCorrelationId(), redirect.getCorrelationId()) && Intrinsics.areEqual(this.redirectReason, redirect.redirectReason);
        }

        public int hashCode() {
            return (getCorrelationId().hashCode() * 31) + this.redirectReason.hashCode();
        }

        public Redirect(String correlationId, String redirectReason) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(redirectReason, "redirectReason");
            this.correlationId = correlationId;
            this.redirectReason = redirectReason;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public boolean containsPii() {
            return DefaultImpls.containsPii(this);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult
        public String getCorrelationId() {
            return this.correlationId;
        }

        public final String getRedirectReason() {
            return this.redirectReason;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "Redirect(correlationId=" + getCorrelationId() + ", redirectReason=" + this.redirectReason + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return toUnsanitizedString();
        }
    }

    /* JADX INFO: compiled from: SignUpStartApiResult.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$Success;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult;", "continuationToken", "", "correlationId", "(Ljava/lang/String;Ljava/lang/String;)V", "getContinuationToken", "()Ljava/lang/String;", "getCorrelationId", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Success implements SignUpStartApiResult {
        private final String continuationToken;
        private final String correlationId;

        public static /* synthetic */ Success copy$default(Success success, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = success.continuationToken;
            }
            if ((i & 2) != 0) {
                str2 = success.getCorrelationId();
            }
            return success.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getContinuationToken() {
            return this.continuationToken;
        }

        public final String component2() {
            return getCorrelationId();
        }

        public final Success copy(String continuationToken, String correlationId) {
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            return new Success(continuationToken, correlationId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return Intrinsics.areEqual(this.continuationToken, success.continuationToken) && Intrinsics.areEqual(getCorrelationId(), success.getCorrelationId());
        }

        public int hashCode() {
            return (this.continuationToken.hashCode() * 31) + getCorrelationId().hashCode();
        }

        public Success(String continuationToken, String correlationId) {
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            this.continuationToken = continuationToken;
            this.correlationId = correlationId;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public boolean containsPii() {
            return DefaultImpls.containsPii(this);
        }

        public final String getContinuationToken() {
            return this.continuationToken;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult
        public String getCorrelationId() {
            return this.correlationId;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "Success(correlationId=" + getCorrelationId() + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return toUnsanitizedString();
        }
    }

    /* JADX INFO: compiled from: SignUpStartApiResult.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\u0007\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$InvalidPassword;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult;", "correlationId", "", "error", "errorDescription", "subError", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "getSubError", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class InvalidPassword extends ApiErrorResult implements SignUpStartApiResult {
        private final String correlationId;
        private final String error;
        private final String errorDescription;
        private final String subError;

        public static /* synthetic */ InvalidPassword copy$default(InvalidPassword invalidPassword, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = invalidPassword.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = invalidPassword.getError();
            }
            if ((i & 4) != 0) {
                str3 = invalidPassword.getErrorDescription();
            }
            if ((i & 8) != 0) {
                str4 = invalidPassword.getSubError();
            }
            return invalidPassword.copy(str, str2, str3, str4);
        }

        public final String component1() {
            return getCorrelationId();
        }

        public final String component2() {
            return getError();
        }

        public final String component3() {
            return getErrorDescription();
        }

        public final String component4() {
            return getSubError();
        }

        public final InvalidPassword copy(String correlationId, String error, String errorDescription, String subError) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(subError, "subError");
            return new InvalidPassword(correlationId, error, errorDescription, subError);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvalidPassword)) {
                return false;
            }
            InvalidPassword invalidPassword = (InvalidPassword) other;
            return Intrinsics.areEqual(getCorrelationId(), invalidPassword.getCorrelationId()) && Intrinsics.areEqual(getError(), invalidPassword.getError()) && Intrinsics.areEqual(getErrorDescription(), invalidPassword.getErrorDescription()) && Intrinsics.areEqual(getSubError(), invalidPassword.getSubError());
        }

        public int hashCode() {
            return (((((getCorrelationId().hashCode() * 31) + getError().hashCode()) * 31) + getErrorDescription().hashCode()) * 31) + getSubError().hashCode();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult, com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult
        public String getCorrelationId() {
            return this.correlationId;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        public String getError() {
            return this.error;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        public String getErrorDescription() {
            return this.errorDescription;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        public String getSubError() {
            return this.subError;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidPassword(String correlationId, String error, String errorDescription, String subError) {
            super(error, null, errorDescription, null, correlationId, 10, null);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(subError, "subError");
            this.correlationId = correlationId;
            this.error = error;
            this.errorDescription = errorDescription;
            this.subError = subError;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "InvalidPassword(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + ", errorCodes=" + getErrorCodes() + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "InvalidPassword(correlationId=" + getCorrelationId() + ')';
        }
    }

    /* JADX INFO: compiled from: SignUpStartApiResult.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\bHÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003JA\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\b\b\u0002\u0010\t\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\t\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006 "}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$InvalidAttributes;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult;", "correlationId", "", "error", "errorDescription", "invalidAttributes", "", "subError", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "getInvalidAttributes", "()Ljava/util/List;", "getSubError", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class InvalidAttributes extends ApiErrorResult implements SignUpStartApiResult {
        private final String correlationId;
        private final String error;
        private final String errorDescription;
        private final List<String> invalidAttributes;
        private final String subError;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InvalidAttributes copy$default(InvalidAttributes invalidAttributes, String str, String str2, String str3, List list, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = invalidAttributes.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = invalidAttributes.getError();
            }
            if ((i & 4) != 0) {
                str3 = invalidAttributes.getErrorDescription();
            }
            if ((i & 8) != 0) {
                list = invalidAttributes.invalidAttributes;
            }
            if ((i & 16) != 0) {
                str4 = invalidAttributes.getSubError();
            }
            String str5 = str4;
            String str6 = str3;
            return invalidAttributes.copy(str, str2, str6, list, str5);
        }

        public final String component1() {
            return getCorrelationId();
        }

        public final String component2() {
            return getError();
        }

        public final String component3() {
            return getErrorDescription();
        }

        public final List<String> component4() {
            return this.invalidAttributes;
        }

        public final String component5() {
            return getSubError();
        }

        public final InvalidAttributes copy(String correlationId, String error, String errorDescription, List<String> invalidAttributes, String subError) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(invalidAttributes, "invalidAttributes");
            Intrinsics.checkNotNullParameter(subError, "subError");
            return new InvalidAttributes(correlationId, error, errorDescription, invalidAttributes, subError);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvalidAttributes)) {
                return false;
            }
            InvalidAttributes invalidAttributes = (InvalidAttributes) other;
            return Intrinsics.areEqual(getCorrelationId(), invalidAttributes.getCorrelationId()) && Intrinsics.areEqual(getError(), invalidAttributes.getError()) && Intrinsics.areEqual(getErrorDescription(), invalidAttributes.getErrorDescription()) && Intrinsics.areEqual(this.invalidAttributes, invalidAttributes.invalidAttributes) && Intrinsics.areEqual(getSubError(), invalidAttributes.getSubError());
        }

        public int hashCode() {
            return (((((((getCorrelationId().hashCode() * 31) + getError().hashCode()) * 31) + getErrorDescription().hashCode()) * 31) + this.invalidAttributes.hashCode()) * 31) + getSubError().hashCode();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult, com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult
        public String getCorrelationId() {
            return this.correlationId;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        public String getError() {
            return this.error;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        public String getErrorDescription() {
            return this.errorDescription;
        }

        public final List<String> getInvalidAttributes() {
            return this.invalidAttributes;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        public String getSubError() {
            return this.subError;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidAttributes(String correlationId, String error, String errorDescription, List<String> invalidAttributes, String subError) {
            super(error, null, errorDescription, null, correlationId, 10, null);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(invalidAttributes, "invalidAttributes");
            Intrinsics.checkNotNullParameter(subError, "subError");
            this.correlationId = correlationId;
            this.error = error;
            this.errorDescription = errorDescription;
            this.invalidAttributes = invalidAttributes;
            this.subError = subError;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "InvalidAttributes(correlationId=" + getCorrelationId() + ", invalidAttributes=" + this.invalidAttributes + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + ", errorCodes=" + getErrorCodes() + ", subError=" + getSubError() + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "InvalidPassword(correlationId=" + getCorrelationId() + ')';
        }
    }

    /* JADX INFO: compiled from: SignUpStartApiResult.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$UnknownError;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult;", "error", "", "errorDescription", "correlationId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class UnknownError extends ApiErrorResult implements SignUpStartApiResult {
        private final String correlationId;
        private final String error;
        private final String errorDescription;

        public static /* synthetic */ UnknownError copy$default(UnknownError unknownError, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unknownError.getError();
            }
            if ((i & 2) != 0) {
                str2 = unknownError.getErrorDescription();
            }
            if ((i & 4) != 0) {
                str3 = unknownError.getCorrelationId();
            }
            return unknownError.copy(str, str2, str3);
        }

        public final String component1() {
            return getError();
        }

        public final String component2() {
            return getErrorDescription();
        }

        public final String component3() {
            return getCorrelationId();
        }

        public final UnknownError copy(String error, String errorDescription, String correlationId) {
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            return new UnknownError(error, errorDescription, correlationId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UnknownError)) {
                return false;
            }
            UnknownError unknownError = (UnknownError) other;
            return Intrinsics.areEqual(getError(), unknownError.getError()) && Intrinsics.areEqual(getErrorDescription(), unknownError.getErrorDescription()) && Intrinsics.areEqual(getCorrelationId(), unknownError.getCorrelationId());
        }

        public int hashCode() {
            return (((getError().hashCode() * 31) + getErrorDescription().hashCode()) * 31) + getCorrelationId().hashCode();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        public String getError() {
            return this.error;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        public String getErrorDescription() {
            return this.errorDescription;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult, com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult
        public String getCorrelationId() {
            return this.correlationId;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnknownError(String error, String errorDescription, String correlationId) {
            super(error, null, errorDescription, null, correlationId, 10, null);
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            this.error = error;
            this.errorDescription = errorDescription;
            this.correlationId = correlationId;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "UnknownError(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + ", errorCodes=" + getErrorCodes() + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "UnknownError(correlationId=" + getCorrelationId() + ')';
        }
    }

    /* JADX INFO: compiled from: SignUpStartApiResult.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$UnsupportedChallengeType;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult;", "error", "", "errorDescription", "correlationId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class UnsupportedChallengeType extends ApiErrorResult implements SignUpStartApiResult {
        private final String correlationId;
        private final String error;
        private final String errorDescription;

        public static /* synthetic */ UnsupportedChallengeType copy$default(UnsupportedChallengeType unsupportedChallengeType, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unsupportedChallengeType.getError();
            }
            if ((i & 2) != 0) {
                str2 = unsupportedChallengeType.getErrorDescription();
            }
            if ((i & 4) != 0) {
                str3 = unsupportedChallengeType.getCorrelationId();
            }
            return unsupportedChallengeType.copy(str, str2, str3);
        }

        public final String component1() {
            return getError();
        }

        public final String component2() {
            return getErrorDescription();
        }

        public final String component3() {
            return getCorrelationId();
        }

        public final UnsupportedChallengeType copy(String error, String errorDescription, String correlationId) {
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            return new UnsupportedChallengeType(error, errorDescription, correlationId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UnsupportedChallengeType)) {
                return false;
            }
            UnsupportedChallengeType unsupportedChallengeType = (UnsupportedChallengeType) other;
            return Intrinsics.areEqual(getError(), unsupportedChallengeType.getError()) && Intrinsics.areEqual(getErrorDescription(), unsupportedChallengeType.getErrorDescription()) && Intrinsics.areEqual(getCorrelationId(), unsupportedChallengeType.getCorrelationId());
        }

        public int hashCode() {
            return (((getError().hashCode() * 31) + getErrorDescription().hashCode()) * 31) + getCorrelationId().hashCode();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        public String getError() {
            return this.error;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        public String getErrorDescription() {
            return this.errorDescription;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult, com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult
        public String getCorrelationId() {
            return this.correlationId;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnsupportedChallengeType(String error, String errorDescription, String correlationId) {
            super(error, null, errorDescription, null, correlationId, 10, null);
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            this.error = error;
            this.errorDescription = errorDescription;
            this.correlationId = correlationId;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "UnsupportedChallengeType(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + ", errorCodes=" + getErrorCodes() + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "UnsupportedChallengeType(correlationId=" + getCorrelationId() + ')';
        }
    }

    /* JADX INFO: compiled from: SignUpStartApiResult.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$UsernameAlreadyExists;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult;", "error", "", "errorDescription", "correlationId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class UsernameAlreadyExists extends ApiErrorResult implements SignUpStartApiResult {
        private final String correlationId;
        private final String error;
        private final String errorDescription;

        public static /* synthetic */ UsernameAlreadyExists copy$default(UsernameAlreadyExists usernameAlreadyExists, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = usernameAlreadyExists.getError();
            }
            if ((i & 2) != 0) {
                str2 = usernameAlreadyExists.getErrorDescription();
            }
            if ((i & 4) != 0) {
                str3 = usernameAlreadyExists.getCorrelationId();
            }
            return usernameAlreadyExists.copy(str, str2, str3);
        }

        public final String component1() {
            return getError();
        }

        public final String component2() {
            return getErrorDescription();
        }

        public final String component3() {
            return getCorrelationId();
        }

        public final UsernameAlreadyExists copy(String error, String errorDescription, String correlationId) {
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            return new UsernameAlreadyExists(error, errorDescription, correlationId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UsernameAlreadyExists)) {
                return false;
            }
            UsernameAlreadyExists usernameAlreadyExists = (UsernameAlreadyExists) other;
            return Intrinsics.areEqual(getError(), usernameAlreadyExists.getError()) && Intrinsics.areEqual(getErrorDescription(), usernameAlreadyExists.getErrorDescription()) && Intrinsics.areEqual(getCorrelationId(), usernameAlreadyExists.getCorrelationId());
        }

        public int hashCode() {
            return (((getError().hashCode() * 31) + getErrorDescription().hashCode()) * 31) + getCorrelationId().hashCode();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        public String getError() {
            return this.error;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        public String getErrorDescription() {
            return this.errorDescription;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult, com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult
        public String getCorrelationId() {
            return this.correlationId;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UsernameAlreadyExists(String error, String errorDescription, String correlationId) {
            super(error, null, errorDescription, null, correlationId, 10, null);
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            this.error = error;
            this.errorDescription = errorDescription;
            this.correlationId = correlationId;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "UsernameAlreadyExists(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "UsernameAlreadyExists(correlationId=" + getCorrelationId() + ')';
        }
    }

    /* JADX INFO: compiled from: SignUpStartApiResult.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$InvalidUsername;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult;", "error", "", "errorDescription", "correlationId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class InvalidUsername extends ApiErrorResult implements SignUpStartApiResult {
        private final String correlationId;
        private final String error;
        private final String errorDescription;

        public static /* synthetic */ InvalidUsername copy$default(InvalidUsername invalidUsername, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = invalidUsername.getError();
            }
            if ((i & 2) != 0) {
                str2 = invalidUsername.getErrorDescription();
            }
            if ((i & 4) != 0) {
                str3 = invalidUsername.getCorrelationId();
            }
            return invalidUsername.copy(str, str2, str3);
        }

        public final String component1() {
            return getError();
        }

        public final String component2() {
            return getErrorDescription();
        }

        public final String component3() {
            return getCorrelationId();
        }

        public final InvalidUsername copy(String error, String errorDescription, String correlationId) {
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            return new InvalidUsername(error, errorDescription, correlationId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvalidUsername)) {
                return false;
            }
            InvalidUsername invalidUsername = (InvalidUsername) other;
            return Intrinsics.areEqual(getError(), invalidUsername.getError()) && Intrinsics.areEqual(getErrorDescription(), invalidUsername.getErrorDescription()) && Intrinsics.areEqual(getCorrelationId(), invalidUsername.getCorrelationId());
        }

        public int hashCode() {
            return (((getError().hashCode() * 31) + getErrorDescription().hashCode()) * 31) + getCorrelationId().hashCode();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        public String getError() {
            return this.error;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        public String getErrorDescription() {
            return this.errorDescription;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult, com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult
        public String getCorrelationId() {
            return this.correlationId;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidUsername(String error, String errorDescription, String correlationId) {
            super(error, null, errorDescription, null, correlationId, 10, null);
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            this.error = error;
            this.errorDescription = errorDescription;
            this.correlationId = correlationId;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "InvalidUsername(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "InvalidUsername(correlationId=" + getCorrelationId() + ')';
        }
    }

    /* JADX INFO: compiled from: SignUpStartApiResult.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult$AuthNotSupported;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult;", "error", "", "errorDescription", "correlationId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class AuthNotSupported extends ApiErrorResult implements SignUpStartApiResult {
        private final String correlationId;
        private final String error;
        private final String errorDescription;

        public static /* synthetic */ AuthNotSupported copy$default(AuthNotSupported authNotSupported, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = authNotSupported.getError();
            }
            if ((i & 2) != 0) {
                str2 = authNotSupported.getErrorDescription();
            }
            if ((i & 4) != 0) {
                str3 = authNotSupported.getCorrelationId();
            }
            return authNotSupported.copy(str, str2, str3);
        }

        public final String component1() {
            return getError();
        }

        public final String component2() {
            return getErrorDescription();
        }

        public final String component3() {
            return getCorrelationId();
        }

        public final AuthNotSupported copy(String error, String errorDescription, String correlationId) {
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            return new AuthNotSupported(error, errorDescription, correlationId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AuthNotSupported)) {
                return false;
            }
            AuthNotSupported authNotSupported = (AuthNotSupported) other;
            return Intrinsics.areEqual(getError(), authNotSupported.getError()) && Intrinsics.areEqual(getErrorDescription(), authNotSupported.getErrorDescription()) && Intrinsics.areEqual(getCorrelationId(), authNotSupported.getCorrelationId());
        }

        public int hashCode() {
            return (((getError().hashCode() * 31) + getErrorDescription().hashCode()) * 31) + getCorrelationId().hashCode();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        public String getError() {
            return this.error;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        public String getErrorDescription() {
            return this.errorDescription;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult, com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult
        public String getCorrelationId() {
            return this.correlationId;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AuthNotSupported(String error, String errorDescription, String correlationId) {
            super(error, null, errorDescription, null, correlationId, 10, null);
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            this.error = error;
            this.errorDescription = errorDescription;
            this.correlationId = correlationId;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "AuthNotSupported(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "AuthNotSupported(correlationId=" + getCorrelationId() + ')';
        }
    }
}
