package com.microsoft.identity.common.java.nativeauth.controllers.results;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.AuthenticationMethodApiResult;
import com.microsoft.identity.common.java.nativeauth.util.ListUtilsKt;
import com.microsoft.identity.common.java.result.ILocalAuthenticationResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignInCommandResult.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\bf\u0018\u00002\u00020\u0001:\b\u0002\u0003\u0004\u0005\u0006\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInCommandResult;", "", "CodeRequired", "Complete", "IncorrectCode", "InvalidCredentials", "MFARequired", "PasswordRequired", "StrongAuthMethodRegistrationRequired", "UserNotFound", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SignInCommandResult {

    /* JADX INFO: compiled from: SignInCommandResult.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u0015\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0011\u001a\u00020\tHÆ\u0003J\t\u0010\u0012\u001a\u00020\u000bHÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\b\u0010\u001a\u001a\u00020\tH\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInCommandResult$Complete;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInWithContinuationTokenCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInSubmitCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInSubmitPasswordCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/MFASubmitChallengeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/JITChallengeAuthMethodCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/JITSubmitChallengeCommandResult;", "correlationId", "", "authenticationResult", "Lcom/microsoft/identity/common/java/result/ILocalAuthenticationResult;", "(Ljava/lang/String;Lcom/microsoft/identity/common/java/result/ILocalAuthenticationResult;)V", "getAuthenticationResult", "()Lcom/microsoft/identity/common/java/result/ILocalAuthenticationResult;", "getCorrelationId", "()Ljava/lang/String;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Complete implements SignInStartCommandResult, SignInWithContinuationTokenCommandResult, SignInSubmitCodeCommandResult, SignInSubmitPasswordCommandResult, MFASubmitChallengeCommandResult, JITChallengeAuthMethodCommandResult, JITSubmitChallengeCommandResult {
        private final ILocalAuthenticationResult authenticationResult;
        private final String correlationId;

        public static /* synthetic */ Complete copy$default(Complete complete, String str, ILocalAuthenticationResult iLocalAuthenticationResult, int i, Object obj) {
            if ((i & 1) != 0) {
                str = complete.getCorrelationId();
            }
            if ((i & 2) != 0) {
                iLocalAuthenticationResult = complete.authenticationResult;
            }
            return complete.copy(str, iLocalAuthenticationResult);
        }

        public final String component1() {
            return getCorrelationId();
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ILocalAuthenticationResult getAuthenticationResult() {
            return this.authenticationResult;
        }

        public final Complete copy(String correlationId, ILocalAuthenticationResult authenticationResult) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(authenticationResult, "authenticationResult");
            return new Complete(correlationId, authenticationResult);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Complete)) {
                return false;
            }
            Complete complete = (Complete) other;
            return Intrinsics.areEqual(getCorrelationId(), complete.getCorrelationId()) && Intrinsics.areEqual(this.authenticationResult, complete.authenticationResult);
        }

        public int hashCode() {
            return (getCorrelationId().hashCode() * 31) + this.authenticationResult.hashCode();
        }

        public Complete(String correlationId, ILocalAuthenticationResult authenticationResult) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(authenticationResult, "authenticationResult");
            this.correlationId = correlationId;
            this.authenticationResult = authenticationResult;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public boolean containsPii() {
            return SignInStartCommandResult.DefaultImpls.containsPii(this);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult
        public String getCorrelationId() {
            return this.correlationId;
        }

        public final ILocalAuthenticationResult getAuthenticationResult() {
            return this.authenticationResult;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "Complete(correlationId=" + getCorrelationId() + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return toUnsanitizedString();
        }
    }

    /* JADX INFO: compiled from: SignInCommandResult.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInCommandResult$PasswordRequired;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInStartCommandResult;", "correlationId", "", "continuationToken", "(Ljava/lang/String;Ljava/lang/String;)V", "getContinuationToken", "()Ljava/lang/String;", "getCorrelationId", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class PasswordRequired implements SignInStartCommandResult {
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
            return SignInStartCommandResult.DefaultImpls.containsPii(this);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult
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

    /* JADX INFO: compiled from: SignInCommandResult.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\tHÖ\u0001J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInCommandResult$CodeRequired;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInResendCodeCommandResult;", "correlationId", "", "continuationToken", "challengeTargetLabel", "challengeChannel", "codeLength", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getChallengeChannel", "()Ljava/lang/String;", "getChallengeTargetLabel", "getCodeLength", "()I", "getContinuationToken", "getCorrelationId", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class CodeRequired implements SignInStartCommandResult, SignInResendCodeCommandResult {
        private final String challengeChannel;
        private final String challengeTargetLabel;
        private final int codeLength;
        private final String continuationToken;
        private final String correlationId;

        public static /* synthetic */ CodeRequired copy$default(CodeRequired codeRequired, String str, String str2, String str3, String str4, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = codeRequired.getCorrelationId();
            }
            if ((i2 & 2) != 0) {
                str2 = codeRequired.continuationToken;
            }
            if ((i2 & 4) != 0) {
                str3 = codeRequired.challengeTargetLabel;
            }
            if ((i2 & 8) != 0) {
                str4 = codeRequired.challengeChannel;
            }
            if ((i2 & 16) != 0) {
                i = codeRequired.codeLength;
            }
            int i3 = i;
            String str5 = str3;
            return codeRequired.copy(str, str2, str5, str4, i3);
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

        public final CodeRequired copy(String correlationId, String continuationToken, String challengeTargetLabel, String challengeChannel, int codeLength) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(challengeTargetLabel, "challengeTargetLabel");
            Intrinsics.checkNotNullParameter(challengeChannel, "challengeChannel");
            return new CodeRequired(correlationId, continuationToken, challengeTargetLabel, challengeChannel, codeLength);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CodeRequired)) {
                return false;
            }
            CodeRequired codeRequired = (CodeRequired) other;
            return Intrinsics.areEqual(getCorrelationId(), codeRequired.getCorrelationId()) && Intrinsics.areEqual(this.continuationToken, codeRequired.continuationToken) && Intrinsics.areEqual(this.challengeTargetLabel, codeRequired.challengeTargetLabel) && Intrinsics.areEqual(this.challengeChannel, codeRequired.challengeChannel) && this.codeLength == codeRequired.codeLength;
        }

        public int hashCode() {
            return (((((((getCorrelationId().hashCode() * 31) + this.continuationToken.hashCode()) * 31) + this.challengeTargetLabel.hashCode()) * 31) + this.challengeChannel.hashCode()) * 31) + Integer.hashCode(this.codeLength);
        }

        public CodeRequired(String correlationId, String continuationToken, String challengeTargetLabel, String challengeChannel, int i) {
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
            return SignInStartCommandResult.DefaultImpls.containsPii(this);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult
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
            return "CodeRequired(correlationId=" + getCorrelationId() + ", codeLength=" + this.codeLength + ", challengeTargetLabel=" + this.challengeTargetLabel + ", challengeChannel=" + this.challengeChannel + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "CodeRequired(correlationId=" + getCorrelationId() + ", codeLength=" + this.codeLength + ", challengeChannel=" + this.challengeChannel + ')';
        }
    }

    /* JADX INFO: compiled from: SignInCommandResult.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B#\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInCommandResult$StrongAuthMethodRegistrationRequired;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInSubmitPasswordCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInSubmitCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInWithContinuationTokenCommandResult;", "correlationId", "", "continuationToken", "authMethods", "", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/AuthenticationMethodApiResult;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAuthMethods", "()Ljava/util/List;", "getContinuationToken", "()Ljava/lang/String;", "getCorrelationId", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class StrongAuthMethodRegistrationRequired implements SignInStartCommandResult, SignInSubmitPasswordCommandResult, SignInSubmitCodeCommandResult, SignInWithContinuationTokenCommandResult {
        private final List<AuthenticationMethodApiResult> authMethods;
        private final String continuationToken;
        private final String correlationId;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StrongAuthMethodRegistrationRequired copy$default(StrongAuthMethodRegistrationRequired strongAuthMethodRegistrationRequired, String str, String str2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = strongAuthMethodRegistrationRequired.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = strongAuthMethodRegistrationRequired.continuationToken;
            }
            if ((i & 4) != 0) {
                list = strongAuthMethodRegistrationRequired.authMethods;
            }
            return strongAuthMethodRegistrationRequired.copy(str, str2, list);
        }

        public final String component1() {
            return getCorrelationId();
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getContinuationToken() {
            return this.continuationToken;
        }

        public final List<AuthenticationMethodApiResult> component3() {
            return this.authMethods;
        }

        public final StrongAuthMethodRegistrationRequired copy(String correlationId, String continuationToken, List<AuthenticationMethodApiResult> authMethods) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(authMethods, "authMethods");
            return new StrongAuthMethodRegistrationRequired(correlationId, continuationToken, authMethods);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StrongAuthMethodRegistrationRequired)) {
                return false;
            }
            StrongAuthMethodRegistrationRequired strongAuthMethodRegistrationRequired = (StrongAuthMethodRegistrationRequired) other;
            return Intrinsics.areEqual(getCorrelationId(), strongAuthMethodRegistrationRequired.getCorrelationId()) && Intrinsics.areEqual(this.continuationToken, strongAuthMethodRegistrationRequired.continuationToken) && Intrinsics.areEqual(this.authMethods, strongAuthMethodRegistrationRequired.authMethods);
        }

        public int hashCode() {
            return (((getCorrelationId().hashCode() * 31) + this.continuationToken.hashCode()) * 31) + this.authMethods.hashCode();
        }

        public StrongAuthMethodRegistrationRequired(String correlationId, String continuationToken, List<AuthenticationMethodApiResult> authMethods) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(authMethods, "authMethods");
            this.correlationId = correlationId;
            this.continuationToken = continuationToken;
            this.authMethods = authMethods;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public boolean containsPii() {
            return SignInStartCommandResult.DefaultImpls.containsPii(this);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult
        public String getCorrelationId() {
            return this.correlationId;
        }

        public final String getContinuationToken() {
            return this.continuationToken;
        }

        public final List<AuthenticationMethodApiResult> getAuthMethods() {
            return this.authMethods;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "StrongAuthMethodRegistrationRequired(correlationId=" + getCorrelationId() + ", authMethods=" + ListUtilsKt.toUnsanitizedString(this.authMethods) + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "StrongAuthMethodRegistrationRequired(correlationId=" + getCorrelationId() + ", authMethods=" + this.authMethods + ')';
        }
    }

    /* JADX INFO: compiled from: SignInCommandResult.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\bHÖ\u0001J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInCommandResult$UserNotFound;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInStartCommandResult;", "correlationId", "", "error", "errorDescription", "errorCodes", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class UserNotFound implements SignInStartCommandResult {
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
                str2 = userNotFound.error;
            }
            if ((i & 4) != 0) {
                str3 = userNotFound.errorDescription;
            }
            if ((i & 8) != 0) {
                list = userNotFound.errorCodes;
            }
            return userNotFound.copy(str, str2, str3, list);
        }

        public final String component1() {
            return getCorrelationId();
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getError() {
            return this.error;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getErrorDescription() {
            return this.errorDescription;
        }

        public final List<Integer> component4() {
            return this.errorCodes;
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
            return Intrinsics.areEqual(getCorrelationId(), userNotFound.getCorrelationId()) && Intrinsics.areEqual(this.error, userNotFound.error) && Intrinsics.areEqual(this.errorDescription, userNotFound.errorDescription) && Intrinsics.areEqual(this.errorCodes, userNotFound.errorCodes);
        }

        public int hashCode() {
            return (((((getCorrelationId().hashCode() * 31) + this.error.hashCode()) * 31) + this.errorDescription.hashCode()) * 31) + this.errorCodes.hashCode();
        }

        public UserNotFound(String correlationId, String error, String errorDescription, List<Integer> errorCodes) {
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
        public boolean containsPii() {
            return SignInStartCommandResult.DefaultImpls.containsPii(this);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult
        public String getCorrelationId() {
            return this.correlationId;
        }

        public final String getError() {
            return this.error;
        }

        public final String getErrorDescription() {
            return this.errorDescription;
        }

        public final List<Integer> getErrorCodes() {
            return this.errorCodes;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "UserNotFound(correlationId=" + getCorrelationId() + ", error=" + this.error + ", errorDescription=" + this.errorDescription + ", errorCodes=" + this.errorCodes + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "UserNotFound(correlationId=" + getCorrelationId() + ')';
        }
    }

    /* JADX INFO: compiled from: SignInCommandResult.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInCommandResult$InvalidCredentials;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInSubmitPasswordCommandResult;", "correlationId", "", "error", "errorDescription", "errorCodes", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class InvalidCredentials implements SignInStartCommandResult, SignInSubmitPasswordCommandResult {
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
                str2 = invalidCredentials.error;
            }
            if ((i & 4) != 0) {
                str3 = invalidCredentials.errorDescription;
            }
            if ((i & 8) != 0) {
                list = invalidCredentials.errorCodes;
            }
            return invalidCredentials.copy(str, str2, str3, list);
        }

        public final String component1() {
            return getCorrelationId();
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getError() {
            return this.error;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getErrorDescription() {
            return this.errorDescription;
        }

        public final List<Integer> component4() {
            return this.errorCodes;
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
            return Intrinsics.areEqual(getCorrelationId(), invalidCredentials.getCorrelationId()) && Intrinsics.areEqual(this.error, invalidCredentials.error) && Intrinsics.areEqual(this.errorDescription, invalidCredentials.errorDescription) && Intrinsics.areEqual(this.errorCodes, invalidCredentials.errorCodes);
        }

        public int hashCode() {
            return (((((getCorrelationId().hashCode() * 31) + this.error.hashCode()) * 31) + this.errorDescription.hashCode()) * 31) + this.errorCodes.hashCode();
        }

        public InvalidCredentials(String correlationId, String error, String errorDescription, List<Integer> errorCodes) {
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
        public boolean containsPii() {
            return SignInStartCommandResult.DefaultImpls.containsPii(this);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult
        public String getCorrelationId() {
            return this.correlationId;
        }

        public final String getError() {
            return this.error;
        }

        public final String getErrorDescription() {
            return this.errorDescription;
        }

        public final List<Integer> getErrorCodes() {
            return this.errorCodes;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "InvalidCredentials(correlationId=" + getCorrelationId() + ", error=" + this.error + ", errorDescription=" + this.errorDescription + ", errorCodes=" + this.errorCodes + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "InvalidCredentials(correlationId=" + getCorrelationId() + ')';
        }
    }

    /* JADX INFO: compiled from: SignInCommandResult.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003JA\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\tHÖ\u0001J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006 "}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInCommandResult$IncorrectCode;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInSubmitCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/MFASubmitChallengeCommandResult;", "correlationId", "", "error", "errorDescription", "errorCodes", "", "", "subError", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "getSubError", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class IncorrectCode implements SignInSubmitCodeCommandResult, MFASubmitChallengeCommandResult {
        private final String correlationId;
        private final String error;
        private final List<Integer> errorCodes;
        private final String errorDescription;
        private final String subError;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ IncorrectCode copy$default(IncorrectCode incorrectCode, String str, String str2, String str3, List list, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = incorrectCode.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = incorrectCode.error;
            }
            if ((i & 4) != 0) {
                str3 = incorrectCode.errorDescription;
            }
            if ((i & 8) != 0) {
                list = incorrectCode.errorCodes;
            }
            if ((i & 16) != 0) {
                str4 = incorrectCode.subError;
            }
            String str5 = str4;
            String str6 = str3;
            return incorrectCode.copy(str, str2, str6, list, str5);
        }

        public final String component1() {
            return getCorrelationId();
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getError() {
            return this.error;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getErrorDescription() {
            return this.errorDescription;
        }

        public final List<Integer> component4() {
            return this.errorCodes;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getSubError() {
            return this.subError;
        }

        public final IncorrectCode copy(String correlationId, String error, String errorDescription, List<Integer> errorCodes, String subError) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            Intrinsics.checkNotNullParameter(errorCodes, "errorCodes");
            Intrinsics.checkNotNullParameter(subError, "subError");
            return new IncorrectCode(correlationId, error, errorDescription, errorCodes, subError);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IncorrectCode)) {
                return false;
            }
            IncorrectCode incorrectCode = (IncorrectCode) other;
            return Intrinsics.areEqual(getCorrelationId(), incorrectCode.getCorrelationId()) && Intrinsics.areEqual(this.error, incorrectCode.error) && Intrinsics.areEqual(this.errorDescription, incorrectCode.errorDescription) && Intrinsics.areEqual(this.errorCodes, incorrectCode.errorCodes) && Intrinsics.areEqual(this.subError, incorrectCode.subError);
        }

        public int hashCode() {
            return (((((((getCorrelationId().hashCode() * 31) + this.error.hashCode()) * 31) + this.errorDescription.hashCode()) * 31) + this.errorCodes.hashCode()) * 31) + this.subError.hashCode();
        }

        public IncorrectCode(String correlationId, String error, String errorDescription, List<Integer> errorCodes, String subError) {
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
        public boolean containsPii() {
            return SignInSubmitCodeCommandResult.DefaultImpls.containsPii(this);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult
        public String getCorrelationId() {
            return this.correlationId;
        }

        public final String getError() {
            return this.error;
        }

        public final String getErrorDescription() {
            return this.errorDescription;
        }

        public final List<Integer> getErrorCodes() {
            return this.errorCodes;
        }

        public final String getSubError() {
            return this.subError;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "IncorrectCode(correlationId=" + getCorrelationId() + ", error=" + this.error + ", errorDescription=" + this.errorDescription + ", errorCodes=" + this.errorCodes + ", subError=" + this.subError + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "IncorrectCode(correlationId=" + getCorrelationId() + ')';
        }
    }

    /* JADX INFO: compiled from: SignInCommandResult.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B#\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInCommandResult$MFARequired;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInSubmitPasswordCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInSubmitCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInWithContinuationTokenCommandResult;", "correlationId", "", "continuationToken", "authMethods", "", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/AuthenticationMethodApiResult;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAuthMethods", "()Ljava/util/List;", "getContinuationToken", "()Ljava/lang/String;", "getCorrelationId", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class MFARequired implements SignInStartCommandResult, SignInSubmitPasswordCommandResult, SignInSubmitCodeCommandResult, SignInWithContinuationTokenCommandResult {
        private final List<AuthenticationMethodApiResult> authMethods;
        private final String continuationToken;
        private final String correlationId;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MFARequired copy$default(MFARequired mFARequired, String str, String str2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = mFARequired.getCorrelationId();
            }
            if ((i & 2) != 0) {
                str2 = mFARequired.continuationToken;
            }
            if ((i & 4) != 0) {
                list = mFARequired.authMethods;
            }
            return mFARequired.copy(str, str2, list);
        }

        public final String component1() {
            return getCorrelationId();
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getContinuationToken() {
            return this.continuationToken;
        }

        public final List<AuthenticationMethodApiResult> component3() {
            return this.authMethods;
        }

        public final MFARequired copy(String correlationId, String continuationToken, List<AuthenticationMethodApiResult> authMethods) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(authMethods, "authMethods");
            return new MFARequired(correlationId, continuationToken, authMethods);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MFARequired)) {
                return false;
            }
            MFARequired mFARequired = (MFARequired) other;
            return Intrinsics.areEqual(getCorrelationId(), mFARequired.getCorrelationId()) && Intrinsics.areEqual(this.continuationToken, mFARequired.continuationToken) && Intrinsics.areEqual(this.authMethods, mFARequired.authMethods);
        }

        public int hashCode() {
            return (((getCorrelationId().hashCode() * 31) + this.continuationToken.hashCode()) * 31) + this.authMethods.hashCode();
        }

        public MFARequired(String correlationId, String continuationToken, List<AuthenticationMethodApiResult> authMethods) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(authMethods, "authMethods");
            this.correlationId = correlationId;
            this.continuationToken = continuationToken;
            this.authMethods = authMethods;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public boolean containsPii() {
            return SignInStartCommandResult.DefaultImpls.containsPii(this);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult
        public String getCorrelationId() {
            return this.correlationId;
        }

        public final String getContinuationToken() {
            return this.continuationToken;
        }

        public final List<AuthenticationMethodApiResult> getAuthMethods() {
            return this.authMethods;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "MFARequired(correlationId=" + getCorrelationId() + ", authMethods=" + ListUtilsKt.toUnsanitizedString(this.authMethods) + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "MFARequired(correlationId=" + getCorrelationId() + ", authMethods=" + this.authMethods + ')';
        }
    }
}
