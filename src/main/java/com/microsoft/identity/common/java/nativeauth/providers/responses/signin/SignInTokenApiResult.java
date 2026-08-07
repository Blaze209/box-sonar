package com.microsoft.identity.common.java.nativeauth.providers.responses.signin;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyReplyChannel;
import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult;
import com.microsoft.identity.common.java.nativeauth.util.ILoggable;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsTokenResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignInTokenApiResult.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u00012\u00020\u0002:\t\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\u0082\u0001\t\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/util/ILoggable;", "CodeIncorrect", "InvalidAuthenticationType", "InvalidCredentials", "JITRequired", "MFARequired", "Redirect", "Success", PasskeyReplyChannel.DOM_EXCEPTION_UNKNOWN_ERROR, "UserNotFound", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$CodeIncorrect;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$InvalidAuthenticationType;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$InvalidCredentials;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$JITRequired;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$MFARequired;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$Redirect;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$Success;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$UnknownError;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$UserNotFound;", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SignInTokenApiResult extends ApiResult, ILoggable {

    /* JADX INFO: compiled from: SignInTokenApiResult.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean containsPii(SignInTokenApiResult signInTokenApiResult) {
            return ApiResult.DefaultImpls.containsPii(signInTokenApiResult);
        }
    }

    /* JADX INFO: compiled from: SignInTokenApiResult.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$Redirect;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult;", "correlationId", "", "redirectReason", "(Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getRedirectReason", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Redirect implements SignInTokenApiResult {
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

    /* JADX INFO: compiled from: SignInTokenApiResult.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$Success;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult;", "correlationId", "", "tokenResponse", "Lcom/microsoft/identity/common/java/providers/microsoft/microsoftsts/MicrosoftStsTokenResponse;", "(Ljava/lang/String;Lcom/microsoft/identity/common/java/providers/microsoft/microsoftsts/MicrosoftStsTokenResponse;)V", "getCorrelationId", "()Ljava/lang/String;", "getTokenResponse", "()Lcom/microsoft/identity/common/java/providers/microsoft/microsoftsts/MicrosoftStsTokenResponse;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Success implements SignInTokenApiResult {
        private final String correlationId;
        private final MicrosoftStsTokenResponse tokenResponse;

        public static /* synthetic */ Success copy$default(Success success, String str, MicrosoftStsTokenResponse microsoftStsTokenResponse, int i, Object obj) {
            if ((i & 1) != 0) {
                str = success.getCorrelationId();
            }
            if ((i & 2) != 0) {
                microsoftStsTokenResponse = success.tokenResponse;
            }
            return success.copy(str, microsoftStsTokenResponse);
        }

        public final String component1() {
            return getCorrelationId();
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final MicrosoftStsTokenResponse getTokenResponse() {
            return this.tokenResponse;
        }

        public final Success copy(String correlationId, MicrosoftStsTokenResponse tokenResponse) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(tokenResponse, "tokenResponse");
            return new Success(correlationId, tokenResponse);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return Intrinsics.areEqual(getCorrelationId(), success.getCorrelationId()) && Intrinsics.areEqual(this.tokenResponse, success.tokenResponse);
        }

        public int hashCode() {
            return (getCorrelationId().hashCode() * 31) + this.tokenResponse.hashCode();
        }

        public Success(String correlationId, MicrosoftStsTokenResponse tokenResponse) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(tokenResponse, "tokenResponse");
            this.correlationId = correlationId;
            this.tokenResponse = tokenResponse;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public boolean containsPii() {
            return DefaultImpls.containsPii(this);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult
        public String getCorrelationId() {
            return this.correlationId;
        }

        public final MicrosoftStsTokenResponse getTokenResponse() {
            return this.tokenResponse;
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

    /* JADX INFO: compiled from: SignInTokenApiResult.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JK\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u000bHÖ\u0001J\b\u0010!\u001a\u00020\u0004H\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e¨\u0006#"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$MFARequired;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult;", "correlationId", "", "continuationToken", "error", "subError", "errorDescription", "errorCodes", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getContinuationToken", "()Ljava/lang/String;", "getCorrelationId", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "getSubError", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class MFARequired extends ApiErrorResult implements SignInTokenApiResult {
        private final String continuationToken;
        private final String correlationId;
        private final String error;
        private final List<Integer> errorCodes;
        private final String errorDescription;
        private final String subError;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MFARequired copy$default(MFARequired mFARequired, String str, String str2, String str3, String str4, String str5, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = mFARequired.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = mFARequired.continuationToken;
            }
            if ((i & 4) != 0) {
                str3 = mFARequired.getError();
            }
            if ((i & 8) != 0) {
                str4 = mFARequired.getSubError();
            }
            if ((i & 16) != 0) {
                str5 = mFARequired.getErrorDescription();
            }
            if ((i & 32) != 0) {
                list = mFARequired.getErrorCodes();
            }
            String str6 = str5;
            List list2 = list;
            return mFARequired.copy(str, str2, str3, str4, str6, list2);
        }

        public final String component1() {
            return getCorrelationId();
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getContinuationToken() {
            return this.continuationToken;
        }

        public final String component3() {
            return getError();
        }

        public final String component4() {
            return getSubError();
        }

        public final String component5() {
            return getErrorDescription();
        }

        public final List<Integer> component6() {
            return getErrorCodes();
        }

        public final MFARequired copy(String correlationId, String continuationToken, String error, String subError, String errorDescription, List<Integer> errorCodes) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(subError, "subError");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(errorCodes, "errorCodes");
            return new MFARequired(correlationId, continuationToken, error, subError, errorDescription, errorCodes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MFARequired)) {
                return false;
            }
            MFARequired mFARequired = (MFARequired) other;
            return Intrinsics.areEqual(getCorrelationId(), mFARequired.getCorrelationId()) && Intrinsics.areEqual(this.continuationToken, mFARequired.continuationToken) && Intrinsics.areEqual(getError(), mFARequired.getError()) && Intrinsics.areEqual(getSubError(), mFARequired.getSubError()) && Intrinsics.areEqual(getErrorDescription(), mFARequired.getErrorDescription()) && Intrinsics.areEqual(getErrorCodes(), mFARequired.getErrorCodes());
        }

        public int hashCode() {
            return (((((((((getCorrelationId().hashCode() * 31) + this.continuationToken.hashCode()) * 31) + getError().hashCode()) * 31) + getSubError().hashCode()) * 31) + getErrorDescription().hashCode()) * 31) + getErrorCodes().hashCode();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult, com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult
        public String getCorrelationId() {
            return this.correlationId;
        }

        public final String getContinuationToken() {
            return this.continuationToken;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        public String getError() {
            return this.error;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        public String getSubError() {
            return this.subError;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        public String getErrorDescription() {
            return this.errorDescription;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        public List<Integer> getErrorCodes() {
            return this.errorCodes;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MFARequired(String correlationId, String continuationToken, String error, String subError, String errorDescription, List<Integer> errorCodes) {
            super(error, subError, errorDescription, errorCodes, correlationId);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(subError, "subError");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(errorCodes, "errorCodes");
            this.correlationId = correlationId;
            this.continuationToken = continuationToken;
            this.error = error;
            this.subError = subError;
            this.errorDescription = errorDescription;
            this.errorCodes = errorCodes;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "MFARequired(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + ", subError=" + getSubError() + ", errorCodes=" + getErrorCodes() + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "MFARequired(correlationId=" + getCorrelationId() + ')';
        }
    }

    /* JADX INFO: compiled from: SignInTokenApiResult.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JK\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u000bHÖ\u0001J\b\u0010!\u001a\u00020\u0004H\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e¨\u0006#"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$JITRequired;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult;", "correlationId", "", "continuationToken", "error", "subError", "errorDescription", "errorCodes", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getContinuationToken", "()Ljava/lang/String;", "getCorrelationId", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "getSubError", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class JITRequired extends ApiErrorResult implements SignInTokenApiResult {
        private final String continuationToken;
        private final String correlationId;
        private final String error;
        private final List<Integer> errorCodes;
        private final String errorDescription;
        private final String subError;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ JITRequired copy$default(JITRequired jITRequired, String str, String str2, String str3, String str4, String str5, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = jITRequired.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = jITRequired.continuationToken;
            }
            if ((i & 4) != 0) {
                str3 = jITRequired.getError();
            }
            if ((i & 8) != 0) {
                str4 = jITRequired.getSubError();
            }
            if ((i & 16) != 0) {
                str5 = jITRequired.getErrorDescription();
            }
            if ((i & 32) != 0) {
                list = jITRequired.getErrorCodes();
            }
            String str6 = str5;
            List list2 = list;
            return jITRequired.copy(str, str2, str3, str4, str6, list2);
        }

        public final String component1() {
            return getCorrelationId();
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getContinuationToken() {
            return this.continuationToken;
        }

        public final String component3() {
            return getError();
        }

        public final String component4() {
            return getSubError();
        }

        public final String component5() {
            return getErrorDescription();
        }

        public final List<Integer> component6() {
            return getErrorCodes();
        }

        public final JITRequired copy(String correlationId, String continuationToken, String error, String subError, String errorDescription, List<Integer> errorCodes) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(subError, "subError");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(errorCodes, "errorCodes");
            return new JITRequired(correlationId, continuationToken, error, subError, errorDescription, errorCodes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof JITRequired)) {
                return false;
            }
            JITRequired jITRequired = (JITRequired) other;
            return Intrinsics.areEqual(getCorrelationId(), jITRequired.getCorrelationId()) && Intrinsics.areEqual(this.continuationToken, jITRequired.continuationToken) && Intrinsics.areEqual(getError(), jITRequired.getError()) && Intrinsics.areEqual(getSubError(), jITRequired.getSubError()) && Intrinsics.areEqual(getErrorDescription(), jITRequired.getErrorDescription()) && Intrinsics.areEqual(getErrorCodes(), jITRequired.getErrorCodes());
        }

        public int hashCode() {
            return (((((((((getCorrelationId().hashCode() * 31) + this.continuationToken.hashCode()) * 31) + getError().hashCode()) * 31) + getSubError().hashCode()) * 31) + getErrorDescription().hashCode()) * 31) + getErrorCodes().hashCode();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult, com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult
        public String getCorrelationId() {
            return this.correlationId;
        }

        public final String getContinuationToken() {
            return this.continuationToken;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        public String getError() {
            return this.error;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        public String getSubError() {
            return this.subError;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        public String getErrorDescription() {
            return this.errorDescription;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        public List<Integer> getErrorCodes() {
            return this.errorCodes;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public JITRequired(String correlationId, String continuationToken, String error, String subError, String errorDescription, List<Integer> errorCodes) {
            super(error, subError, errorDescription, errorCodes, correlationId);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(subError, "subError");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(errorCodes, "errorCodes");
            this.correlationId = correlationId;
            this.continuationToken = continuationToken;
            this.error = error;
            this.subError = subError;
            this.errorDescription = errorDescription;
            this.errorCodes = errorCodes;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "JITRequired(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + ", subError=" + getSubError() + ", errorCodes=" + getErrorCodes() + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "JITRequired(correlationId=" + getCorrelationId() + ')';
        }
    }

    /* JADX INFO: compiled from: SignInTokenApiResult.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$UserNotFound;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult;", "correlationId", "", "error", "errorDescription", "errorCodes", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class UserNotFound extends ApiErrorResult implements SignInTokenApiResult {
        private final String correlationId;
        private final String error;
        private final List<Integer> errorCodes;
        private final String errorDescription;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UserNotFound copy$default(UserNotFound userNotFound, String str, String str2, String str3, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = userNotFound.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = userNotFound.getError();
            }
            if ((i & 4) != 0) {
                str3 = userNotFound.getErrorDescription();
            }
            if ((i & 8) != 0) {
                list = userNotFound.getErrorCodes();
            }
            return userNotFound.copy(str, str2, str3, list);
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

        public final List<Integer> component4() {
            return getErrorCodes();
        }

        public final UserNotFound copy(String correlationId, String error, String errorDescription, List<Integer> errorCodes) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(errorCodes, "errorCodes");
            return new UserNotFound(correlationId, error, errorDescription, errorCodes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UserNotFound)) {
                return false;
            }
            UserNotFound userNotFound = (UserNotFound) other;
            return Intrinsics.areEqual(getCorrelationId(), userNotFound.getCorrelationId()) && Intrinsics.areEqual(getError(), userNotFound.getError()) && Intrinsics.areEqual(getErrorDescription(), userNotFound.getErrorDescription()) && Intrinsics.areEqual(getErrorCodes(), userNotFound.getErrorCodes());
        }

        public int hashCode() {
            return (((((getCorrelationId().hashCode() * 31) + getError().hashCode()) * 31) + getErrorDescription().hashCode()) * 31) + getErrorCodes().hashCode();
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
        public List<Integer> getErrorCodes() {
            return this.errorCodes;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserNotFound(String correlationId, String error, String errorDescription, List<Integer> errorCodes) {
            super(error, null, errorDescription, errorCodes, correlationId, 2, null);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(errorCodes, "errorCodes");
            this.correlationId = correlationId;
            this.error = error;
            this.errorDescription = errorDescription;
            this.errorCodes = errorCodes;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "UserNotFound(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + ", errorCodes=" + getErrorCodes() + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "UserNotFound(correlationId=" + getCorrelationId() + ')';
        }
    }

    /* JADX INFO: compiled from: SignInTokenApiResult.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$InvalidCredentials;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult;", "correlationId", "", "error", "errorDescription", "errorCodes", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class InvalidCredentials extends ApiErrorResult implements SignInTokenApiResult {
        private final String correlationId;
        private final String error;
        private final List<Integer> errorCodes;
        private final String errorDescription;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InvalidCredentials copy$default(InvalidCredentials invalidCredentials, String str, String str2, String str3, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = invalidCredentials.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = invalidCredentials.getError();
            }
            if ((i & 4) != 0) {
                str3 = invalidCredentials.getErrorDescription();
            }
            if ((i & 8) != 0) {
                list = invalidCredentials.getErrorCodes();
            }
            return invalidCredentials.copy(str, str2, str3, list);
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

        public final List<Integer> component4() {
            return getErrorCodes();
        }

        public final InvalidCredentials copy(String correlationId, String error, String errorDescription, List<Integer> errorCodes) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(errorCodes, "errorCodes");
            return new InvalidCredentials(correlationId, error, errorDescription, errorCodes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvalidCredentials)) {
                return false;
            }
            InvalidCredentials invalidCredentials = (InvalidCredentials) other;
            return Intrinsics.areEqual(getCorrelationId(), invalidCredentials.getCorrelationId()) && Intrinsics.areEqual(getError(), invalidCredentials.getError()) && Intrinsics.areEqual(getErrorDescription(), invalidCredentials.getErrorDescription()) && Intrinsics.areEqual(getErrorCodes(), invalidCredentials.getErrorCodes());
        }

        public int hashCode() {
            return (((((getCorrelationId().hashCode() * 31) + getError().hashCode()) * 31) + getErrorDescription().hashCode()) * 31) + getErrorCodes().hashCode();
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
        public List<Integer> getErrorCodes() {
            return this.errorCodes;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidCredentials(String correlationId, String error, String errorDescription, List<Integer> errorCodes) {
            super(error, null, errorDescription, errorCodes, correlationId, 2, null);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(errorCodes, "errorCodes");
            this.correlationId = correlationId;
            this.error = error;
            this.errorDescription = errorDescription;
            this.errorCodes = errorCodes;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "InvalidCredentials(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + ", errorCodes=" + getErrorCodes() + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "InvalidCredentials(correlationId=" + getCorrelationId() + ')';
        }
    }

    /* JADX INFO: compiled from: SignInTokenApiResult.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003JA\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\tHÖ\u0001J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\n\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006 "}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$CodeIncorrect;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult;", "correlationId", "", "error", "errorDescription", "errorCodes", "", "", "subError", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "getSubError", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class CodeIncorrect extends ApiErrorResult implements SignInTokenApiResult {
        private final String correlationId;
        private final String error;
        private final List<Integer> errorCodes;
        private final String errorDescription;
        private final String subError;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CodeIncorrect copy$default(CodeIncorrect codeIncorrect, String str, String str2, String str3, List list, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = codeIncorrect.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = codeIncorrect.getError();
            }
            if ((i & 4) != 0) {
                str3 = codeIncorrect.getErrorDescription();
            }
            if ((i & 8) != 0) {
                list = codeIncorrect.getErrorCodes();
            }
            if ((i & 16) != 0) {
                str4 = codeIncorrect.getSubError();
            }
            String str5 = str4;
            String str6 = str3;
            return codeIncorrect.copy(str, str2, str6, list, str5);
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

        public final List<Integer> component4() {
            return getErrorCodes();
        }

        public final String component5() {
            return getSubError();
        }

        public final CodeIncorrect copy(String correlationId, String error, String errorDescription, List<Integer> errorCodes, String subError) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(errorCodes, "errorCodes");
            Intrinsics.checkNotNullParameter(subError, "subError");
            return new CodeIncorrect(correlationId, error, errorDescription, errorCodes, subError);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CodeIncorrect)) {
                return false;
            }
            CodeIncorrect codeIncorrect = (CodeIncorrect) other;
            return Intrinsics.areEqual(getCorrelationId(), codeIncorrect.getCorrelationId()) && Intrinsics.areEqual(getError(), codeIncorrect.getError()) && Intrinsics.areEqual(getErrorDescription(), codeIncorrect.getErrorDescription()) && Intrinsics.areEqual(getErrorCodes(), codeIncorrect.getErrorCodes()) && Intrinsics.areEqual(getSubError(), codeIncorrect.getSubError());
        }

        public int hashCode() {
            return (((((((getCorrelationId().hashCode() * 31) + getError().hashCode()) * 31) + getErrorDescription().hashCode()) * 31) + getErrorCodes().hashCode()) * 31) + getSubError().hashCode();
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
        public List<Integer> getErrorCodes() {
            return this.errorCodes;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult
        public String getSubError() {
            return this.subError;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CodeIncorrect(String correlationId, String error, String errorDescription, List<Integer> errorCodes, String subError) {
            super(error, null, errorDescription, errorCodes, correlationId, 2, null);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(errorCodes, "errorCodes");
            Intrinsics.checkNotNullParameter(subError, "subError");
            this.correlationId = correlationId;
            this.error = error;
            this.errorDescription = errorDescription;
            this.errorCodes = errorCodes;
            this.subError = subError;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "CodeIncorrect(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + ", errorCodes=" + getErrorCodes() + ", subError=" + getSubError() + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "CodeIncorrect(correlationId=" + getCorrelationId() + ')';
        }
    }

    /* JADX INFO: compiled from: SignInTokenApiResult.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$InvalidAuthenticationType;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult;", "correlationId", "", "error", "errorDescription", "errorCodes", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class InvalidAuthenticationType extends ApiErrorResult implements SignInTokenApiResult {
        private final String correlationId;
        private final String error;
        private final List<Integer> errorCodes;
        private final String errorDescription;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InvalidAuthenticationType copy$default(InvalidAuthenticationType invalidAuthenticationType, String str, String str2, String str3, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = invalidAuthenticationType.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = invalidAuthenticationType.getError();
            }
            if ((i & 4) != 0) {
                str3 = invalidAuthenticationType.getErrorDescription();
            }
            if ((i & 8) != 0) {
                list = invalidAuthenticationType.getErrorCodes();
            }
            return invalidAuthenticationType.copy(str, str2, str3, list);
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

        public final List<Integer> component4() {
            return getErrorCodes();
        }

        public final InvalidAuthenticationType copy(String correlationId, String error, String errorDescription, List<Integer> errorCodes) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(errorCodes, "errorCodes");
            return new InvalidAuthenticationType(correlationId, error, errorDescription, errorCodes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvalidAuthenticationType)) {
                return false;
            }
            InvalidAuthenticationType invalidAuthenticationType = (InvalidAuthenticationType) other;
            return Intrinsics.areEqual(getCorrelationId(), invalidAuthenticationType.getCorrelationId()) && Intrinsics.areEqual(getError(), invalidAuthenticationType.getError()) && Intrinsics.areEqual(getErrorDescription(), invalidAuthenticationType.getErrorDescription()) && Intrinsics.areEqual(getErrorCodes(), invalidAuthenticationType.getErrorCodes());
        }

        public int hashCode() {
            return (((((getCorrelationId().hashCode() * 31) + getError().hashCode()) * 31) + getErrorDescription().hashCode()) * 31) + getErrorCodes().hashCode();
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
        public List<Integer> getErrorCodes() {
            return this.errorCodes;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidAuthenticationType(String correlationId, String error, String errorDescription, List<Integer> errorCodes) {
            super(error, null, errorDescription, errorCodes, correlationId, 2, null);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(errorCodes, "errorCodes");
            this.correlationId = correlationId;
            this.error = error;
            this.errorDescription = errorDescription;
            this.errorCodes = errorCodes;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "InvalidAuthenticationType(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + ", errorCodes=" + getErrorCodes() + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "InvalidAuthenticationType(correlationId=" + getCorrelationId() + ')';
        }
    }

    /* JADX INFO: compiled from: SignInTokenApiResult.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$UnknownError;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult;", "correlationId", "", "error", "errorDescription", "errorCodes", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class UnknownError extends ApiErrorResult implements SignInTokenApiResult {
        private final String correlationId;
        private final String error;
        private final List<Integer> errorCodes;
        private final String errorDescription;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UnknownError copy$default(UnknownError unknownError, String str, String str2, String str3, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unknownError.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = unknownError.getError();
            }
            if ((i & 4) != 0) {
                str3 = unknownError.getErrorDescription();
            }
            if ((i & 8) != 0) {
                list = unknownError.getErrorCodes();
            }
            return unknownError.copy(str, str2, str3, list);
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

        public final List<Integer> component4() {
            return getErrorCodes();
        }

        public final UnknownError copy(String correlationId, String error, String errorDescription, List<Integer> errorCodes) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(errorCodes, "errorCodes");
            return new UnknownError(correlationId, error, errorDescription, errorCodes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UnknownError)) {
                return false;
            }
            UnknownError unknownError = (UnknownError) other;
            return Intrinsics.areEqual(getCorrelationId(), unknownError.getCorrelationId()) && Intrinsics.areEqual(getError(), unknownError.getError()) && Intrinsics.areEqual(getErrorDescription(), unknownError.getErrorDescription()) && Intrinsics.areEqual(getErrorCodes(), unknownError.getErrorCodes());
        }

        public int hashCode() {
            return (((((getCorrelationId().hashCode() * 31) + getError().hashCode()) * 31) + getErrorDescription().hashCode()) * 31) + getErrorCodes().hashCode();
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
        public List<Integer> getErrorCodes() {
            return this.errorCodes;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnknownError(String correlationId, String error, String errorDescription, List<Integer> errorCodes) {
            super(error, null, errorDescription, errorCodes, correlationId, 2, null);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(errorCodes, "errorCodes");
            this.correlationId = correlationId;
            this.error = error;
            this.errorDescription = errorDescription;
            this.errorCodes = errorCodes;
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
}
