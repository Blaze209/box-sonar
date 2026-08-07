package com.microsoft.identity.common.java.nativeauth.providers.responses.signin;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyReplyChannel;
import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignInChallengeApiResult.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0005\u0007\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInChallengeApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiResult;", "BlockedAuthMethod", "OOBRequired", "PasswordRequired", "Redirect", PasskeyReplyChannel.DOM_EXCEPTION_UNKNOWN_ERROR, "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInChallengeApiResult$BlockedAuthMethod;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInChallengeApiResult$OOBRequired;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInChallengeApiResult$PasswordRequired;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInChallengeApiResult$Redirect;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInChallengeApiResult$UnknownError;", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SignInChallengeApiResult extends ApiResult {

    /* JADX INFO: compiled from: SignInChallengeApiResult.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean containsPii(SignInChallengeApiResult signInChallengeApiResult) {
            return ApiResult.DefaultImpls.containsPii(signInChallengeApiResult);
        }
    }

    /* JADX INFO: compiled from: SignInChallengeApiResult.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInChallengeApiResult$Redirect;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInChallengeApiResult;", "correlationId", "", "redirectReason", "(Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getRedirectReason", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Redirect implements SignInChallengeApiResult {
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

    /* JADX INFO: compiled from: SignInChallengeApiResult.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\bHÖ\u0001J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInChallengeApiResult$OOBRequired;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInChallengeApiResult;", "correlationId", "", "continuationToken", "challengeTargetLabel", "challengeChannel", "codeLength", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getChallengeChannel", "()Ljava/lang/String;", "getChallengeTargetLabel", "getCodeLength", "()I", "getContinuationToken", "getCorrelationId", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class OOBRequired implements SignInChallengeApiResult {
        private final String challengeChannel;
        private final String challengeTargetLabel;
        private final int codeLength;
        private final String continuationToken;
        private final String correlationId;

        public static /* synthetic */ OOBRequired copy$default(OOBRequired oOBRequired, String str, String str2, String str3, String str4, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = oOBRequired.getCorrelationId();
            }
            if ((i2 & 2) != 0) {
                str2 = oOBRequired.continuationToken;
            }
            if ((i2 & 4) != 0) {
                str3 = oOBRequired.challengeTargetLabel;
            }
            if ((i2 & 8) != 0) {
                str4 = oOBRequired.challengeChannel;
            }
            if ((i2 & 16) != 0) {
                i = oOBRequired.codeLength;
            }
            int i3 = i;
            String str5 = str3;
            return oOBRequired.copy(str, str2, str5, str4, i3);
        }

        public final String component1() {
            return getCorrelationId();
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getContinuationToken() {
            return this.continuationToken;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getChallengeTargetLabel() {
            return this.challengeTargetLabel;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getChallengeChannel() {
            return this.challengeChannel;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getCodeLength() {
            return this.codeLength;
        }

        public final OOBRequired copy(String correlationId, String continuationToken, String challengeTargetLabel, String challengeChannel, int codeLength) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(challengeTargetLabel, "challengeTargetLabel");
            Intrinsics.checkNotNullParameter(challengeChannel, "challengeChannel");
            return new OOBRequired(correlationId, continuationToken, challengeTargetLabel, challengeChannel, codeLength);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OOBRequired)) {
                return false;
            }
            OOBRequired oOBRequired = (OOBRequired) other;
            return Intrinsics.areEqual(getCorrelationId(), oOBRequired.getCorrelationId()) && Intrinsics.areEqual(this.continuationToken, oOBRequired.continuationToken) && Intrinsics.areEqual(this.challengeTargetLabel, oOBRequired.challengeTargetLabel) && Intrinsics.areEqual(this.challengeChannel, oOBRequired.challengeChannel) && this.codeLength == oOBRequired.codeLength;
        }

        public int hashCode() {
            return (((((((getCorrelationId().hashCode() * 31) + this.continuationToken.hashCode()) * 31) + this.challengeTargetLabel.hashCode()) * 31) + this.challengeChannel.hashCode()) * 31) + Integer.hashCode(this.codeLength);
        }

        public OOBRequired(String correlationId, String continuationToken, String challengeTargetLabel, String challengeChannel, int i) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(challengeTargetLabel, "challengeTargetLabel");
            Intrinsics.checkNotNullParameter(challengeChannel, "challengeChannel");
            this.correlationId = correlationId;
            this.continuationToken = continuationToken;
            this.challengeTargetLabel = challengeTargetLabel;
            this.challengeChannel = challengeChannel;
            this.codeLength = i;
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

        public final String getChallengeTargetLabel() {
            return this.challengeTargetLabel;
        }

        public final String getChallengeChannel() {
            return this.challengeChannel;
        }

        public final int getCodeLength() {
            return this.codeLength;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "OOBRequired(correlationId=" + getCorrelationId() + ", challengeTargetLabel=" + this.challengeTargetLabel + ", challengeChannel=" + this.challengeChannel + ", codeLength=" + this.codeLength + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "OOBRequired(correlationId=" + getCorrelationId() + ", challengeChannel=" + this.challengeChannel + ", codeLength=" + this.codeLength + ')';
        }
    }

    /* JADX INFO: compiled from: SignInChallengeApiResult.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInChallengeApiResult$BlockedAuthMethod;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInChallengeApiResult;", "correlationId", "", "error", "errorDescription", "errorCodes", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class BlockedAuthMethod extends ApiErrorResult implements SignInChallengeApiResult {
        private final String correlationId;
        private final String error;
        private final List<Integer> errorCodes;
        private final String errorDescription;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BlockedAuthMethod copy$default(BlockedAuthMethod blockedAuthMethod, String str, String str2, String str3, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = blockedAuthMethod.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = blockedAuthMethod.getError();
            }
            if ((i & 4) != 0) {
                str3 = blockedAuthMethod.getErrorDescription();
            }
            if ((i & 8) != 0) {
                list = blockedAuthMethod.getErrorCodes();
            }
            return blockedAuthMethod.copy(str, str2, str3, list);
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

        public final BlockedAuthMethod copy(String correlationId, String error, String errorDescription, List<Integer> errorCodes) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(errorCodes, "errorCodes");
            return new BlockedAuthMethod(correlationId, error, errorDescription, errorCodes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BlockedAuthMethod)) {
                return false;
            }
            BlockedAuthMethod blockedAuthMethod = (BlockedAuthMethod) other;
            return Intrinsics.areEqual(getCorrelationId(), blockedAuthMethod.getCorrelationId()) && Intrinsics.areEqual(getError(), blockedAuthMethod.getError()) && Intrinsics.areEqual(getErrorDescription(), blockedAuthMethod.getErrorDescription()) && Intrinsics.areEqual(getErrorCodes(), blockedAuthMethod.getErrorCodes());
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
        public BlockedAuthMethod(String correlationId, String error, String errorDescription, List<Integer> errorCodes) {
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
            return "BlockedAuthMethod(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + ", subError=" + getSubError() + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "BlockedAuthMethod(correlationId=" + getCorrelationId() + ')';
        }
    }

    /* JADX INFO: compiled from: SignInChallengeApiResult.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInChallengeApiResult$PasswordRequired;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInChallengeApiResult;", "correlationId", "", "continuationToken", "(Ljava/lang/String;Ljava/lang/String;)V", "getContinuationToken", "()Ljava/lang/String;", "getCorrelationId", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class PasswordRequired implements SignInChallengeApiResult {
        private final String continuationToken;
        private final String correlationId;

        public static /* synthetic */ PasswordRequired copy$default(PasswordRequired passwordRequired, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = passwordRequired.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = passwordRequired.continuationToken;
            }
            return passwordRequired.copy(str, str2);
        }

        public final String component1() {
            return getCorrelationId();
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getContinuationToken() {
            return this.continuationToken;
        }

        public final PasswordRequired copy(String correlationId, String continuationToken) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            return new PasswordRequired(correlationId, continuationToken);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PasswordRequired)) {
                return false;
            }
            PasswordRequired passwordRequired = (PasswordRequired) other;
            return Intrinsics.areEqual(getCorrelationId(), passwordRequired.getCorrelationId()) && Intrinsics.areEqual(this.continuationToken, passwordRequired.continuationToken);
        }

        public int hashCode() {
            return (getCorrelationId().hashCode() * 31) + this.continuationToken.hashCode();
        }

        public PasswordRequired(String correlationId, String continuationToken) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            this.correlationId = correlationId;
            this.continuationToken = continuationToken;
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

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "PasswordRequired(correlationId=" + getCorrelationId() + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return toUnsanitizedString();
        }
    }

    /* JADX INFO: compiled from: SignInChallengeApiResult.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JA\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\nHÖ\u0001J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006 "}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInChallengeApiResult$UnknownError;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiErrorResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInChallengeApiResult;", "correlationId", "", "error", "subError", "errorDescription", "errorCodes", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "getSubError", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class UnknownError extends ApiErrorResult implements SignInChallengeApiResult {
        private final String correlationId;
        private final String error;
        private final List<Integer> errorCodes;
        private final String errorDescription;
        private final String subError;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UnknownError copy$default(UnknownError unknownError, String str, String str2, String str3, String str4, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unknownError.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = unknownError.getError();
            }
            if ((i & 4) != 0) {
                str3 = unknownError.getSubError();
            }
            if ((i & 8) != 0) {
                str4 = unknownError.getErrorDescription();
            }
            if ((i & 16) != 0) {
                list = unknownError.getErrorCodes();
            }
            List list2 = list;
            String str5 = str3;
            return unknownError.copy(str, str2, str5, str4, list2);
        }

        public final String component1() {
            return getCorrelationId();
        }

        public final String component2() {
            return getError();
        }

        public final String component3() {
            return getSubError();
        }

        public final String component4() {
            return getErrorDescription();
        }

        public final List<Integer> component5() {
            return getErrorCodes();
        }

        public final UnknownError copy(String correlationId, String error, String subError, String errorDescription, List<Integer> errorCodes) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(subError, "subError");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(errorCodes, "errorCodes");
            return new UnknownError(correlationId, error, subError, errorDescription, errorCodes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UnknownError)) {
                return false;
            }
            UnknownError unknownError = (UnknownError) other;
            return Intrinsics.areEqual(getCorrelationId(), unknownError.getCorrelationId()) && Intrinsics.areEqual(getError(), unknownError.getError()) && Intrinsics.areEqual(getSubError(), unknownError.getSubError()) && Intrinsics.areEqual(getErrorDescription(), unknownError.getErrorDescription()) && Intrinsics.areEqual(getErrorCodes(), unknownError.getErrorCodes());
        }

        public int hashCode() {
            return (((((((getCorrelationId().hashCode() * 31) + getError().hashCode()) * 31) + getSubError().hashCode()) * 31) + getErrorDescription().hashCode()) * 31) + getErrorCodes().hashCode();
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
        public UnknownError(String correlationId, String error, String subError, String errorDescription, List<Integer> errorCodes) {
            super(error, subError, errorDescription, errorCodes, correlationId);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(subError, "subError");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(errorCodes, "errorCodes");
            this.correlationId = correlationId;
            this.error = error;
            this.subError = subError;
            this.errorDescription = errorDescription;
            this.errorCodes = errorCodes;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "UnknownError(correlationId=" + getCorrelationId() + ", error=" + getError() + ", subError=" + getSubError() + ", errorDescription=" + getErrorDescription() + ", errorCodes=" + getErrorCodes() + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "UnknownError(correlationId=" + getCorrelationId() + ')';
        }
    }
}
