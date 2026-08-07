package com.microsoft.identity.common.java.nativeauth.controllers.results;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MFACommandResult.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/MFACommandResult;", "", "BlockedAuthMethod", "VerificationRequired", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface MFACommandResult {

    /* JADX INFO: compiled from: MFACommandResult.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\bHÖ\u0001J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/MFACommandResult$VerificationRequired;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/MFAChallengeCommandResult;", "correlationId", "", "continuationToken", "challengeTargetLabel", "challengeChannel", "codeLength", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getChallengeChannel", "()Ljava/lang/String;", "getChallengeTargetLabel", "getCodeLength", "()I", "getContinuationToken", "getCorrelationId", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class VerificationRequired implements MFAChallengeCommandResult {
        private final String challengeChannel;
        private final String challengeTargetLabel;
        private final int codeLength;
        private final String continuationToken;
        private final String correlationId;

        public static /* synthetic */ VerificationRequired copy$default(VerificationRequired verificationRequired, String str, String str2, String str3, String str4, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = verificationRequired.getCorrelationId();
            }
            if ((i2 & 2) != 0) {
                str2 = verificationRequired.continuationToken;
            }
            if ((i2 & 4) != 0) {
                str3 = verificationRequired.challengeTargetLabel;
            }
            if ((i2 & 8) != 0) {
                str4 = verificationRequired.challengeChannel;
            }
            if ((i2 & 16) != 0) {
                i = verificationRequired.codeLength;
            }
            int i3 = i;
            String str5 = str3;
            return verificationRequired.copy(str, str2, str5, str4, i3);
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

        public final VerificationRequired copy(String correlationId, String continuationToken, String challengeTargetLabel, String challengeChannel, int codeLength) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(challengeTargetLabel, "challengeTargetLabel");
            Intrinsics.checkNotNullParameter(challengeChannel, "challengeChannel");
            return new VerificationRequired(correlationId, continuationToken, challengeTargetLabel, challengeChannel, codeLength);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VerificationRequired)) {
                return false;
            }
            VerificationRequired verificationRequired = (VerificationRequired) other;
            return Intrinsics.areEqual(getCorrelationId(), verificationRequired.getCorrelationId()) && Intrinsics.areEqual(this.continuationToken, verificationRequired.continuationToken) && Intrinsics.areEqual(this.challengeTargetLabel, verificationRequired.challengeTargetLabel) && Intrinsics.areEqual(this.challengeChannel, verificationRequired.challengeChannel) && this.codeLength == verificationRequired.codeLength;
        }

        public int hashCode() {
            return (((((((getCorrelationId().hashCode() * 31) + this.continuationToken.hashCode()) * 31) + this.challengeTargetLabel.hashCode()) * 31) + this.challengeChannel.hashCode()) * 31) + Integer.hashCode(this.codeLength);
        }

        public VerificationRequired(String correlationId, String continuationToken, String challengeTargetLabel, String challengeChannel, int i) {
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
            return MFAChallengeCommandResult.DefaultImpls.containsPii(this);
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
            return "VerificationRequired(correlationId=" + getCorrelationId() + ", codeLength=" + this.codeLength + ", challengeTargetLabel=" + this.challengeTargetLabel + ", challengeChannel=" + this.challengeChannel + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "VerificationRequired(correlationId=" + getCorrelationId() + ", codeLength=" + this.codeLength + ", challengeChannel=" + this.challengeChannel + ')';
        }
    }

    /* JADX INFO: compiled from: MFACommandResult.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\bHÖ\u0001J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/MFACommandResult$BlockedAuthMethod;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/MFAChallengeCommandResult;", "correlationId", "", "error", "errorDescription", "errorCodes", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class BlockedAuthMethod implements MFAChallengeCommandResult {
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
                str2 = blockedAuthMethod.error;
            }
            if ((i & 4) != 0) {
                str3 = blockedAuthMethod.errorDescription;
            }
            if ((i & 8) != 0) {
                list = blockedAuthMethod.errorCodes;
            }
            return blockedAuthMethod.copy(str, str2, str3, list);
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
            return Intrinsics.areEqual(getCorrelationId(), blockedAuthMethod.getCorrelationId()) && Intrinsics.areEqual(this.error, blockedAuthMethod.error) && Intrinsics.areEqual(this.errorDescription, blockedAuthMethod.errorDescription) && Intrinsics.areEqual(this.errorCodes, blockedAuthMethod.errorCodes);
        }

        public int hashCode() {
            return (((((getCorrelationId().hashCode() * 31) + this.error.hashCode()) * 31) + this.errorDescription.hashCode()) * 31) + this.errorCodes.hashCode();
        }

        public BlockedAuthMethod(String correlationId, String error, String errorDescription, List<Integer> errorCodes) {
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
            return MFAChallengeCommandResult.DefaultImpls.containsPii(this);
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
            return "BlockedAuthMethod(correlationId=" + getCorrelationId() + ", error=" + this.error + ", errorDescription=" + this.errorDescription + ", errorCodes=" + this.errorCodes + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "BlockedAuthMethod(correlationId=" + getCorrelationId() + ')';
        }
    }
}
