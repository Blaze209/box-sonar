package com.microsoft.identity.common.java.nativeauth.providers.responses.signup;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyReplyChannel;
import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.UserAttributeApiResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignUpContinueApiResult.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\n\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\u0082\u0001\n\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiResult;", "AttributesRequired", "CredentialRequired", "ExpiredToken", "InvalidAttributes", "InvalidOOBValue", "InvalidPassword", "Redirect", "Success", PasskeyReplyChannel.DOM_EXCEPTION_UNKNOWN_ERROR, "UsernameAlreadyExists", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$AttributesRequired;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$CredentialRequired;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$ExpiredToken;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$InvalidAttributes;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$InvalidOOBValue;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$InvalidPassword;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$Redirect;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$Success;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$UnknownError;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$UsernameAlreadyExists;", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SignUpContinueApiResult extends ApiResult {

    /* JADX INFO: compiled from: SignUpContinueApiResult.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean containsPii(SignUpContinueApiResult signUpContinueApiResult) {
            return ApiResult.DefaultImpls.containsPii(signUpContinueApiResult);
        }
    }

    /* JADX INFO: compiled from: SignUpContinueApiResult.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$Redirect;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult;", "correlationId", "", "redirectReason", "(Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getRedirectReason", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Redirect implements SignUpContinueApiResult {
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

    /* JADX INFO: compiled from: SignUpContinueApiResult.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ0\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$Success;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult;", "correlationId", "", "continuationToken", "expiresIn", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getContinuationToken", "()Ljava/lang/String;", "getCorrelationId", "getExpiresIn", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$Success;", "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Success implements SignUpContinueApiResult {
        private final String continuationToken;
        private final String correlationId;
        private final Integer expiresIn;

        public static /* synthetic */ Success copy$default(Success success, String str, String str2, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = success.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = success.continuationToken;
            }
            if ((i & 4) != 0) {
                num = success.expiresIn;
            }
            return success.copy(str, str2, num);
        }

        public final String component1() {
            return getCorrelationId();
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getContinuationToken() {
            return this.continuationToken;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getExpiresIn() {
            return this.expiresIn;
        }

        public final Success copy(String correlationId, String continuationToken, Integer expiresIn) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            return new Success(correlationId, continuationToken, expiresIn);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return Intrinsics.areEqual(getCorrelationId(), success.getCorrelationId()) && Intrinsics.areEqual(this.continuationToken, success.continuationToken) && Intrinsics.areEqual(this.expiresIn, success.expiresIn);
        }

        public int hashCode() {
            int iHashCode = getCorrelationId().hashCode() * 31;
            String str = this.continuationToken;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Integer num = this.expiresIn;
            return iHashCode2 + (num != null ? num.hashCode() : 0);
        }

        public Success(String correlationId, String str, Integer num) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            this.correlationId = correlationId;
            this.continuationToken = str;
            this.expiresIn = num;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public boolean containsPii() {
            return DefaultImpls.containsPii(this);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult
        public String getCorrelationId() {
            return this.correlationId;
        }

        public final String getContinuationToken() {
            return this.continuationToken;
        }

        public final Integer getExpiresIn() {
            return this.expiresIn;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "Success(correlationId=" + getCorrelationId() + ", expiresIn=" + this.expiresIn + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return toUnsanitizedString();
        }
    }

    /* JADX INFO: compiled from: SignUpContinueApiResult.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JA\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\b\u0010 \u001a\u00020\u0004H\u0016R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0007\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$AttributesRequired;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult;", "correlationId", "", "continuationToken", "error", "errorDescription", "requiredAttributes", "", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/UserAttributeApiResult;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getContinuationToken", "()Ljava/lang/String;", "getCorrelationId", "getError", "getErrorDescription", "getRequiredAttributes", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class AttributesRequired extends ApiErrorResult implements SignUpContinueApiResult {
        private final String continuationToken;
        private final String correlationId;
        private final String error;
        private final String errorDescription;
        private final List<UserAttributeApiResult> requiredAttributes;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AttributesRequired copy$default(AttributesRequired attributesRequired, String str, String str2, String str3, String str4, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = attributesRequired.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = attributesRequired.continuationToken;
            }
            if ((i & 4) != 0) {
                str3 = attributesRequired.getError();
            }
            if ((i & 8) != 0) {
                str4 = attributesRequired.getErrorDescription();
            }
            if ((i & 16) != 0) {
                list = attributesRequired.requiredAttributes;
            }
            List list2 = list;
            String str5 = str3;
            return attributesRequired.copy(str, str2, str5, str4, list2);
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
            return getErrorDescription();
        }

        public final List<UserAttributeApiResult> component5() {
            return this.requiredAttributes;
        }

        public final AttributesRequired copy(String correlationId, String continuationToken, String error, String errorDescription, List<UserAttributeApiResult> requiredAttributes) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(requiredAttributes, "requiredAttributes");
            return new AttributesRequired(correlationId, continuationToken, error, errorDescription, requiredAttributes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AttributesRequired)) {
                return false;
            }
            AttributesRequired attributesRequired = (AttributesRequired) other;
            return Intrinsics.areEqual(getCorrelationId(), attributesRequired.getCorrelationId()) && Intrinsics.areEqual(this.continuationToken, attributesRequired.continuationToken) && Intrinsics.areEqual(getError(), attributesRequired.getError()) && Intrinsics.areEqual(getErrorDescription(), attributesRequired.getErrorDescription()) && Intrinsics.areEqual(this.requiredAttributes, attributesRequired.requiredAttributes);
        }

        public int hashCode() {
            return (((((((getCorrelationId().hashCode() * 31) + this.continuationToken.hashCode()) * 31) + getError().hashCode()) * 31) + getErrorDescription().hashCode()) * 31) + this.requiredAttributes.hashCode();
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
        public String getErrorDescription() {
            return this.errorDescription;
        }

        public final List<UserAttributeApiResult> getRequiredAttributes() {
            return this.requiredAttributes;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AttributesRequired(String correlationId, String continuationToken, String error, String errorDescription, List<UserAttributeApiResult> requiredAttributes) {
            super(error, null, errorDescription, null, correlationId, 10, null);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(requiredAttributes, "requiredAttributes");
            this.correlationId = correlationId;
            this.continuationToken = continuationToken;
            this.error = error;
            this.errorDescription = errorDescription;
            this.requiredAttributes = requiredAttributes;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "AttributesRequired(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + ", requiredAttributes=" + this.requiredAttributes + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "AttributesRequired(correlationId=" + getCorrelationId() + ", requiredAttributes=" + this.requiredAttributes + ')';
        }
    }

    /* JADX INFO: compiled from: SignUpContinueApiResult.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\u0007\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$CredentialRequired;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult;", "correlationId", "", "continuationToken", "error", "errorDescription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContinuationToken", "()Ljava/lang/String;", "getCorrelationId", "getError", "getErrorDescription", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class CredentialRequired extends ApiErrorResult implements SignUpContinueApiResult {
        private final String continuationToken;
        private final String correlationId;
        private final String error;
        private final String errorDescription;

        public static /* synthetic */ CredentialRequired copy$default(CredentialRequired credentialRequired, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = credentialRequired.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = credentialRequired.continuationToken;
            }
            if ((i & 4) != 0) {
                str3 = credentialRequired.getError();
            }
            if ((i & 8) != 0) {
                str4 = credentialRequired.getErrorDescription();
            }
            return credentialRequired.copy(str, str2, str3, str4);
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
            return getErrorDescription();
        }

        public final CredentialRequired copy(String correlationId, String continuationToken, String error, String errorDescription) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            return new CredentialRequired(correlationId, continuationToken, error, errorDescription);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CredentialRequired)) {
                return false;
            }
            CredentialRequired credentialRequired = (CredentialRequired) other;
            return Intrinsics.areEqual(getCorrelationId(), credentialRequired.getCorrelationId()) && Intrinsics.areEqual(this.continuationToken, credentialRequired.continuationToken) && Intrinsics.areEqual(getError(), credentialRequired.getError()) && Intrinsics.areEqual(getErrorDescription(), credentialRequired.getErrorDescription());
        }

        public int hashCode() {
            return (((((getCorrelationId().hashCode() * 31) + this.continuationToken.hashCode()) * 31) + getError().hashCode()) * 31) + getErrorDescription().hashCode();
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
        public String getErrorDescription() {
            return this.errorDescription;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CredentialRequired(String correlationId, String continuationToken, String error, String errorDescription) {
            super(error, null, errorDescription, null, correlationId, 10, null);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            this.correlationId = correlationId;
            this.continuationToken = continuationToken;
            this.error = error;
            this.errorDescription = errorDescription;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "CredentialRequired(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "CredentialRequired(correlationId=" + getCorrelationId() + ')';
        }
    }

    /* JADX INFO: compiled from: SignUpContinueApiResult.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$ExpiredToken;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult;", "correlationId", "", "error", "errorDescription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class ExpiredToken extends ApiErrorResult implements SignUpContinueApiResult {
        private final String correlationId;
        private final String error;
        private final String errorDescription;

        public static /* synthetic */ ExpiredToken copy$default(ExpiredToken expiredToken, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = expiredToken.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = expiredToken.getError();
            }
            if ((i & 4) != 0) {
                str3 = expiredToken.getErrorDescription();
            }
            return expiredToken.copy(str, str2, str3);
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

        public final ExpiredToken copy(String correlationId, String error, String errorDescription) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            return new ExpiredToken(correlationId, error, errorDescription);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ExpiredToken)) {
                return false;
            }
            ExpiredToken expiredToken = (ExpiredToken) other;
            return Intrinsics.areEqual(getCorrelationId(), expiredToken.getCorrelationId()) && Intrinsics.areEqual(getError(), expiredToken.getError()) && Intrinsics.areEqual(getErrorDescription(), expiredToken.getErrorDescription());
        }

        public int hashCode() {
            return (((getCorrelationId().hashCode() * 31) + getError().hashCode()) * 31) + getErrorDescription().hashCode();
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ExpiredToken(String correlationId, String error, String errorDescription) {
            super(error, null, errorDescription, null, correlationId, 10, null);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            this.correlationId = correlationId;
            this.error = error;
            this.errorDescription = errorDescription;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "ExpiredToken(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "ExpiredToken(correlationId=" + getCorrelationId() + ')';
        }
    }

    /* JADX INFO: compiled from: SignUpContinueApiResult.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$UsernameAlreadyExists;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult;", "correlationId", "", "error", "errorDescription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class UsernameAlreadyExists extends ApiErrorResult implements SignUpContinueApiResult {
        private final String correlationId;
        private final String error;
        private final String errorDescription;

        public static /* synthetic */ UsernameAlreadyExists copy$default(UsernameAlreadyExists usernameAlreadyExists, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = usernameAlreadyExists.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = usernameAlreadyExists.getError();
            }
            if ((i & 4) != 0) {
                str3 = usernameAlreadyExists.getErrorDescription();
            }
            return usernameAlreadyExists.copy(str, str2, str3);
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

        public final UsernameAlreadyExists copy(String correlationId, String error, String errorDescription) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            return new UsernameAlreadyExists(correlationId, error, errorDescription);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UsernameAlreadyExists)) {
                return false;
            }
            UsernameAlreadyExists usernameAlreadyExists = (UsernameAlreadyExists) other;
            return Intrinsics.areEqual(getCorrelationId(), usernameAlreadyExists.getCorrelationId()) && Intrinsics.areEqual(getError(), usernameAlreadyExists.getError()) && Intrinsics.areEqual(getErrorDescription(), usernameAlreadyExists.getErrorDescription());
        }

        public int hashCode() {
            return (((getCorrelationId().hashCode() * 31) + getError().hashCode()) * 31) + getErrorDescription().hashCode();
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UsernameAlreadyExists(String correlationId, String error, String errorDescription) {
            super(error, null, errorDescription, null, correlationId, 10, null);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            this.correlationId = correlationId;
            this.error = error;
            this.errorDescription = errorDescription;
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

    /* JADX INFO: compiled from: SignUpContinueApiResult.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\u0007\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$InvalidOOBValue;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult;", "correlationId", "", "error", "errorDescription", "subError", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "getSubError", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class InvalidOOBValue extends ApiErrorResult implements SignUpContinueApiResult {
        private final String correlationId;
        private final String error;
        private final String errorDescription;
        private final String subError;

        public static /* synthetic */ InvalidOOBValue copy$default(InvalidOOBValue invalidOOBValue, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = invalidOOBValue.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = invalidOOBValue.getError();
            }
            if ((i & 4) != 0) {
                str3 = invalidOOBValue.getErrorDescription();
            }
            if ((i & 8) != 0) {
                str4 = invalidOOBValue.getSubError();
            }
            return invalidOOBValue.copy(str, str2, str3, str4);
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

        public final InvalidOOBValue copy(String correlationId, String error, String errorDescription, String subError) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(subError, "subError");
            return new InvalidOOBValue(correlationId, error, errorDescription, subError);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvalidOOBValue)) {
                return false;
            }
            InvalidOOBValue invalidOOBValue = (InvalidOOBValue) other;
            return Intrinsics.areEqual(getCorrelationId(), invalidOOBValue.getCorrelationId()) && Intrinsics.areEqual(getError(), invalidOOBValue.getError()) && Intrinsics.areEqual(getErrorDescription(), invalidOOBValue.getErrorDescription()) && Intrinsics.areEqual(getSubError(), invalidOOBValue.getSubError());
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
        public InvalidOOBValue(String correlationId, String error, String errorDescription, String subError) {
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
            return "InvalidOOBValue(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + ", subError=" + getSubError() + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "InvalidOOBValue(correlationId=" + getCorrelationId() + ')';
        }
    }

    /* JADX INFO: compiled from: SignUpContinueApiResult.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003JA\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\t\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006 "}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$InvalidAttributes;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult;", "correlationId", "", "invalidAttributes", "", "error", "errorDescription", "subError", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "getInvalidAttributes", "()Ljava/util/List;", "getSubError", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class InvalidAttributes extends ApiErrorResult implements SignUpContinueApiResult {
        private final String correlationId;
        private final String error;
        private final String errorDescription;
        private final List<String> invalidAttributes;
        private final String subError;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InvalidAttributes copy$default(InvalidAttributes invalidAttributes, String str, List list, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = invalidAttributes.getCorrelationId();
            }
            if ((i & 2) != 0) {
                list = invalidAttributes.invalidAttributes;
            }
            if ((i & 4) != 0) {
                str2 = invalidAttributes.getError();
            }
            if ((i & 8) != 0) {
                str3 = invalidAttributes.getErrorDescription();
            }
            if ((i & 16) != 0) {
                str4 = invalidAttributes.getSubError();
            }
            String str5 = str4;
            String str6 = str2;
            return invalidAttributes.copy(str, list, str6, str3, str5);
        }

        public final String component1() {
            return getCorrelationId();
        }

        public final List<String> component2() {
            return this.invalidAttributes;
        }

        public final String component3() {
            return getError();
        }

        public final String component4() {
            return getErrorDescription();
        }

        public final String component5() {
            return getSubError();
        }

        public final InvalidAttributes copy(String correlationId, List<String> invalidAttributes, String error, String errorDescription, String subError) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(invalidAttributes, "invalidAttributes");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(subError, "subError");
            return new InvalidAttributes(correlationId, invalidAttributes, error, errorDescription, subError);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvalidAttributes)) {
                return false;
            }
            InvalidAttributes invalidAttributes = (InvalidAttributes) other;
            return Intrinsics.areEqual(getCorrelationId(), invalidAttributes.getCorrelationId()) && Intrinsics.areEqual(this.invalidAttributes, invalidAttributes.invalidAttributes) && Intrinsics.areEqual(getError(), invalidAttributes.getError()) && Intrinsics.areEqual(getErrorDescription(), invalidAttributes.getErrorDescription()) && Intrinsics.areEqual(getSubError(), invalidAttributes.getSubError());
        }

        public int hashCode() {
            return (((((((getCorrelationId().hashCode() * 31) + this.invalidAttributes.hashCode()) * 31) + getError().hashCode()) * 31) + getErrorDescription().hashCode()) * 31) + getSubError().hashCode();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult, com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult
        public String getCorrelationId() {
            return this.correlationId;
        }

        public final List<String> getInvalidAttributes() {
            return this.invalidAttributes;
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
        public InvalidAttributes(String correlationId, List<String> invalidAttributes, String error, String errorDescription, String subError) {
            super(error, null, errorDescription, null, correlationId, 10, null);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(invalidAttributes, "invalidAttributes");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(subError, "subError");
            this.correlationId = correlationId;
            this.invalidAttributes = invalidAttributes;
            this.error = error;
            this.errorDescription = errorDescription;
            this.subError = subError;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "InvalidAttributes(correlationId=" + getCorrelationId() + ", invalidAttributes=" + this.invalidAttributes + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + ", subError=" + getSubError() + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "InvalidAttributes(correlationId=" + getCorrelationId() + ')';
        }
    }

    /* JADX INFO: compiled from: SignUpContinueApiResult.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$UnknownError;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult;", "correlationId", "", "error", "errorDescription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class UnknownError extends ApiErrorResult implements SignUpContinueApiResult {
        private final String correlationId;
        private final String error;
        private final String errorDescription;

        public static /* synthetic */ UnknownError copy$default(UnknownError unknownError, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unknownError.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = unknownError.getError();
            }
            if ((i & 4) != 0) {
                str3 = unknownError.getErrorDescription();
            }
            return unknownError.copy(str, str2, str3);
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

        public final UnknownError copy(String correlationId, String error, String errorDescription) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            return new UnknownError(correlationId, error, errorDescription);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UnknownError)) {
                return false;
            }
            UnknownError unknownError = (UnknownError) other;
            return Intrinsics.areEqual(getCorrelationId(), unknownError.getCorrelationId()) && Intrinsics.areEqual(getError(), unknownError.getError()) && Intrinsics.areEqual(getErrorDescription(), unknownError.getErrorDescription());
        }

        public int hashCode() {
            return (((getCorrelationId().hashCode() * 31) + getError().hashCode()) * 31) + getErrorDescription().hashCode();
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnknownError(String correlationId, String error, String errorDescription) {
            super(error, null, errorDescription, null, correlationId, 10, null);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            this.correlationId = correlationId;
            this.error = error;
            this.errorDescription = errorDescription;
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

    /* JADX INFO: compiled from: SignUpContinueApiResult.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\u0007\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult$InvalidPassword;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult;", "correlationId", "", "error", "errorDescription", "subError", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorDescription", "getSubError", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class InvalidPassword extends ApiErrorResult implements SignUpContinueApiResult {
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
            return "InvalidPassword(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + ", errorCodes=" + getErrorCodes() + ", subError=" + getSubError() + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "InvalidPassword(correlationId=" + getCorrelationId() + ')';
        }
    }
}
