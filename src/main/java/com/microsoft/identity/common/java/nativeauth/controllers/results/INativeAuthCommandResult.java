package com.microsoft.identity.common.java.nativeauth.controllers.results;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.microsoft.identity.common.java.logging.DiagnosticContext;
import com.microsoft.identity.common.java.nativeauth.util.ILoggable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: INativeAuthCommandResult.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0004\u0006\u0007\b\tR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/util/ILoggable;", "correlationId", "", "getCorrelationId", "()Ljava/lang/String;", "APIError", "Error", "InvalidUsername", "Redirect", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface INativeAuthCommandResult extends ILoggable {
    String getCorrelationId();

    /* JADX INFO: compiled from: INativeAuthCommandResult.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean containsPii(INativeAuthCommandResult iNativeAuthCommandResult) {
            return ILoggable.DefaultImpls.containsPii(iNativeAuthCommandResult);
        }
    }

    /* JADX INFO: compiled from: INativeAuthCommandResult.kt */
    @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 '2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000f2\u00020\u00102\u00020\u00112\u00020\u00122\u00020\u00132\u00020\u0014:\u0001'B\u0015\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0002\u0010\u0018J\t\u0010\u001c\u001a\u00020\u0016HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0016HÆ\u0003J\u001d\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0016HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\b\u0010%\u001a\u00020\u0016H\u0016J\b\u0010&\u001a\u00020\u0016H\u0016R\u0014\u0010\u0015\u001a\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0017\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001a¨\u0006("}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult$Redirect;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult$Error;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInWithContinuationTokenCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInSubmitCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInResendCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInSubmitPasswordCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpResendCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitPasswordCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitUserAttributesCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordSubmitCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordResendCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordSubmitNewPasswordCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/MFAChallengeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/MFASubmitChallengeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/GetAuthMethodsCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/JITChallengeAuthMethodCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/JITSubmitChallengeCommandResult;", "correlationId", "", "redirectReason", "(Ljava/lang/String;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "getRedirectReason", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "Companion", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Redirect extends Error implements SignInStartCommandResult, SignInWithContinuationTokenCommandResult, SignInSubmitCodeCommandResult, SignInResendCodeCommandResult, SignInSubmitPasswordCommandResult, SignUpStartCommandResult, SignUpSubmitCodeCommandResult, SignUpResendCodeCommandResult, SignUpSubmitPasswordCommandResult, SignUpSubmitUserAttributesCommandResult, ResetPasswordStartCommandResult, ResetPasswordSubmitCodeCommandResult, ResetPasswordResendCodeCommandResult, ResetPasswordSubmitNewPasswordCommandResult, MFAChallengeCommandResult, MFASubmitChallengeCommandResult, GetAuthMethodsCommandResult, JITChallengeAuthMethodCommandResult, JITSubmitChallengeCommandResult {
        private static final String BROWSER_REQUIRED_ERROR = "browser_required";
        private static final String BROWSER_REQUIRED_ERROR_DESCRIPTION = "The client's authentication capabilities are insufficient. Please redirect to the browser to complete authentication";
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

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult.Error, com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult
        public String getCorrelationId() {
            return this.correlationId;
        }

        public final String getRedirectReason() {
            return this.redirectReason;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public Redirect(String correlationId, String redirectReason) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(redirectReason, "redirectReason");
            String str = redirectReason;
            super("browser_required", str.length() == 0 ? BROWSER_REQUIRED_ERROR_DESCRIPTION : str, null, correlationId, null, 20, null);
            this.correlationId = correlationId;
            this.redirectReason = redirectReason;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "Redirect(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "Redirect(correlationId=" + getCorrelationId() + ')';
        }
    }

    /* JADX INFO: compiled from: INativeAuthCommandResult.kt */
    @Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000f2\u00020\u00102\u00020\u00112\u00020\u00122\u00020\u00132\u00020\u00142\u00020\u0015Bc\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u001c\b\u0002\u0010\u0019\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u001b\u0018\u00010\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001a\u0012\u0010\b\u0002\u0010\u001f\u001a\n\u0018\u00010 j\u0004\u0018\u0001`!¢\u0006\u0002\u0010\"J\u000b\u0010,\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u001d\u0010.\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u001b\u0018\u00010\u001aHÆ\u0003J\t\u0010/\u001a\u00020\u0017HÆ\u0003J\u0011\u00100\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001aHÆ\u0003J\u0011\u00101\u001a\n\u0018\u00010 j\u0004\u0018\u0001`!HÆ\u0003Jm\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u001c\b\u0002\u0010\u0019\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u001b\u0018\u00010\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u00172\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001a2\u0010\b\u0002\u0010\u001f\u001a\n\u0018\u00010 j\u0004\u0018\u0001`!HÆ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u00020\u001eHÖ\u0001J\b\u00108\u001a\u00020\u0017H\u0016J\b\u00109\u001a\u00020\u0017H\u0016R\u0014\u0010\u001c\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R(\u0010\u0019\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u001b\u0018\u00010\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010$R\u001c\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0019\u0010\u001f\u001a\n\u0018\u00010 j\u0004\u0018\u0001`!¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006:"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult$APIError;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult$Error;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInWithContinuationTokenCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInSubmitCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInResendCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInSubmitPasswordCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitUserAttributesCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpResendCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitPasswordCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordSubmitCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordResendCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordSubmitNewPasswordCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/GetAuthMethodsCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/MFAChallengeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/MFASubmitChallengeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/JITChallengeAuthMethodCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/JITSubmitChallengeCommandResult;", "error", "", "errorDescription", "details", "", "", "correlationId", "errorCodes", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/Exception;)V", "getCorrelationId", "()Ljava/lang/String;", "getDetails", "()Ljava/util/List;", "getError", "getErrorCodes", "getErrorDescription", "getException", "()Ljava/lang/Exception;", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class APIError extends Error implements INativeAuthCommandResult, SignInStartCommandResult, SignInWithContinuationTokenCommandResult, SignInSubmitCodeCommandResult, SignInResendCodeCommandResult, SignInSubmitPasswordCommandResult, SignUpStartCommandResult, SignUpSubmitUserAttributesCommandResult, SignUpSubmitCodeCommandResult, SignUpResendCodeCommandResult, SignUpSubmitPasswordCommandResult, ResetPasswordStartCommandResult, ResetPasswordSubmitCodeCommandResult, ResetPasswordResendCodeCommandResult, ResetPasswordSubmitNewPasswordCommandResult, GetAuthMethodsCommandResult, MFAChallengeCommandResult, MFASubmitChallengeCommandResult, JITChallengeAuthMethodCommandResult, JITSubmitChallengeCommandResult {
        private final String correlationId;
        private final List<Map<String, String>> details;
        private final String error;
        private final List<Integer> errorCodes;
        private final String errorDescription;
        private final Exception exception;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ APIError copy$default(APIError aPIError, String str, String str2, List list, String str3, List list2, Exception exc, int i, Object obj) {
            if ((i & 1) != 0) {
                str = aPIError.getError();
            }
            if ((i & 2) != 0) {
                str2 = aPIError.getErrorDescription();
            }
            if ((i & 4) != 0) {
                list = aPIError.getDetails();
            }
            if ((i & 8) != 0) {
                str3 = aPIError.getCorrelationId();
            }
            if ((i & 16) != 0) {
                list2 = aPIError.getErrorCodes();
            }
            if ((i & 32) != 0) {
                exc = aPIError.exception;
            }
            List list3 = list2;
            Exception exc2 = exc;
            return aPIError.copy(str, str2, list, str3, list3, exc2);
        }

        public final String component1() {
            return getError();
        }

        public final String component2() {
            return getErrorDescription();
        }

        public final List<Map<String, String>> component3() {
            return getDetails();
        }

        public final String component4() {
            return getCorrelationId();
        }

        public final List<Integer> component5() {
            return getErrorCodes();
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Exception getException() {
            return this.exception;
        }

        public final APIError copy(String error, String errorDescription, List<? extends Map<String, String>> details, String correlationId, List<Integer> errorCodes, Exception exception) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            return new APIError(error, errorDescription, details, correlationId, errorCodes, exception);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof APIError)) {
                return false;
            }
            APIError aPIError = (APIError) other;
            return Intrinsics.areEqual(getError(), aPIError.getError()) && Intrinsics.areEqual(getErrorDescription(), aPIError.getErrorDescription()) && Intrinsics.areEqual(getDetails(), aPIError.getDetails()) && Intrinsics.areEqual(getCorrelationId(), aPIError.getCorrelationId()) && Intrinsics.areEqual(getErrorCodes(), aPIError.getErrorCodes()) && Intrinsics.areEqual(this.exception, aPIError.exception);
        }

        public int hashCode() {
            int iHashCode = (((((((((getError() == null ? 0 : getError().hashCode()) * 31) + (getErrorDescription() == null ? 0 : getErrorDescription().hashCode())) * 31) + (getDetails() == null ? 0 : getDetails().hashCode())) * 31) + getCorrelationId().hashCode()) * 31) + (getErrorCodes() == null ? 0 : getErrorCodes().hashCode())) * 31;
            Exception exc = this.exception;
            return iHashCode + (exc != null ? exc.hashCode() : 0);
        }

        public /* synthetic */ APIError(String str, String str2, List list, String str3, List list2, Exception exc, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? null : list, str3, (i & 16) != 0 ? null : list2, (i & 32) != 0 ? null : exc);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult.Error
        public String getError() {
            return this.error;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult.Error
        public String getErrorDescription() {
            return this.errorDescription;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult.Error
        public List<Map<String, String>> getDetails() {
            return this.details;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult.Error, com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult
        public String getCorrelationId() {
            return this.correlationId;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult.Error
        public List<Integer> getErrorCodes() {
            return this.errorCodes;
        }

        public final Exception getException() {
            return this.exception;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public APIError(String str, String str2, List<? extends Map<String, String>> list, String correlationId, List<Integer> list2, Exception exc) {
            super(str, str2, list, correlationId, list2);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            this.error = str;
            this.errorDescription = str2;
            this.details = list;
            this.correlationId = correlationId;
            this.errorCodes = list2;
            this.exception = exc;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "UnknownError(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + "), details=" + getDetails() + ", errorCodes=" + getErrorCodes() + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "UnknownError(correlationId=" + getCorrelationId() + ')';
        }
    }

    /* JADX INFO: compiled from: INativeAuthCommandResult.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b&\u0018\u00002\u00020\u0001BQ\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006¢\u0006\u0002\u0010\u000bR\u0014\u0010\b\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR(\u0010\u0005\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001c\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult$Error;", "Lcom/microsoft/identity/common/java/nativeauth/util/ILoggable;", "error", "", "errorDescription", "details", "", "", "correlationId", "errorCodes", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getCorrelationId", "()Ljava/lang/String;", "getDetails", "()Ljava/util/List;", "getError", "getErrorCodes", "getErrorDescription", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class Error implements ILoggable {
        private final String correlationId;
        private final List<Map<String, String>> details;
        private final String error;
        private final List<Integer> errorCodes;
        private final String errorDescription;

        /* JADX WARN: Multi-variable type inference failed */
        public Error(String str, String str2, List<? extends Map<String, String>> list, String correlationId, List<Integer> list2) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            this.error = str;
            this.errorDescription = str2;
            this.details = list;
            this.correlationId = correlationId;
            this.errorCodes = list2;
        }

        public /* synthetic */ Error(String str, String str2, List list, String str3, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? null : list, str3, (i & 16) != 0 ? null : list2);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public boolean containsPii() {
            return ILoggable.DefaultImpls.containsPii(this);
        }

        public String getError() {
            return this.error;
        }

        public String getErrorDescription() {
            return this.errorDescription;
        }

        public List<Map<String, String>> getDetails() {
            return this.details;
        }

        public String getCorrelationId() {
            return this.correlationId;
        }

        public List<Integer> getErrorCodes() {
            return this.errorCodes;
        }
    }

    /* JADX INFO: compiled from: INativeAuthCommandResult.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006Be\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\f\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003J\u001d\u0010\u001f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\f\u0018\u00010\u000bHÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bHÆ\u0003J\u0011\u0010\"\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012HÆ\u0003Jm\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\f\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0010\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u000fHÖ\u0001J\b\u0010)\u001a\u00020\bH\u0016J\b\u0010*\u001a\u00020\bH\u0016R\u0014\u0010\r\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R(\u0010\n\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\f\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u001c\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\t\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0019\u0010\u0010\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006+"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult$InvalidUsername;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult$Error;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/INativeAuthCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpStartCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitPasswordCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordStartCommandResult;", "error", "", "errorDescription", "details", "", "", "correlationId", "errorCodes", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/Exception;)V", "getCorrelationId", "()Ljava/lang/String;", "getDetails", "()Ljava/util/List;", "getError", "getErrorCodes", "getErrorDescription", "getException", "()Ljava/lang/Exception;", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class InvalidUsername extends Error implements INativeAuthCommandResult, SignInStartCommandResult, SignUpStartCommandResult, SignUpSubmitPasswordCommandResult, ResetPasswordStartCommandResult {
        private final String correlationId;
        private final List<Map<String, String>> details;
        private final String error;
        private final List<Integer> errorCodes;
        private final String errorDescription;
        private final Exception exception;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InvalidUsername copy$default(InvalidUsername invalidUsername, String str, String str2, List list, String str3, List list2, Exception exc, int i, Object obj) {
            if ((i & 1) != 0) {
                str = invalidUsername.getError();
            }
            if ((i & 2) != 0) {
                str2 = invalidUsername.getErrorDescription();
            }
            if ((i & 4) != 0) {
                list = invalidUsername.getDetails();
            }
            if ((i & 8) != 0) {
                str3 = invalidUsername.getCorrelationId();
            }
            if ((i & 16) != 0) {
                list2 = invalidUsername.getErrorCodes();
            }
            if ((i & 32) != 0) {
                exc = invalidUsername.exception;
            }
            List list3 = list2;
            Exception exc2 = exc;
            return invalidUsername.copy(str, str2, list, str3, list3, exc2);
        }

        public final String component1() {
            return getError();
        }

        public final String component2() {
            return getErrorDescription();
        }

        public final List<Map<String, String>> component3() {
            return getDetails();
        }

        public final String component4() {
            return getCorrelationId();
        }

        public final List<Integer> component5() {
            return getErrorCodes();
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Exception getException() {
            return this.exception;
        }

        public final InvalidUsername copy(String error, String errorDescription, List<? extends Map<String, String>> details, String correlationId, List<Integer> errorCodes, Exception exception) {
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            return new InvalidUsername(error, errorDescription, details, correlationId, errorCodes, exception);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InvalidUsername)) {
                return false;
            }
            InvalidUsername invalidUsername = (InvalidUsername) other;
            return Intrinsics.areEqual(getError(), invalidUsername.getError()) && Intrinsics.areEqual(getErrorDescription(), invalidUsername.getErrorDescription()) && Intrinsics.areEqual(getDetails(), invalidUsername.getDetails()) && Intrinsics.areEqual(getCorrelationId(), invalidUsername.getCorrelationId()) && Intrinsics.areEqual(getErrorCodes(), invalidUsername.getErrorCodes()) && Intrinsics.areEqual(this.exception, invalidUsername.exception);
        }

        public int hashCode() {
            int iHashCode = (((((((((getError() == null ? 0 : getError().hashCode()) * 31) + (getErrorDescription() == null ? 0 : getErrorDescription().hashCode())) * 31) + (getDetails() == null ? 0 : getDetails().hashCode())) * 31) + getCorrelationId().hashCode()) * 31) + (getErrorCodes() == null ? 0 : getErrorCodes().hashCode())) * 31;
            Exception exc = this.exception;
            return iHashCode + (exc != null ? exc.hashCode() : 0);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult.Error
        public String getError() {
            return this.error;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult.Error
        public String getErrorDescription() {
            return this.errorDescription;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult.Error
        public List<Map<String, String>> getDetails() {
            return this.details;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ InvalidUsername(String str, String str2, List list, String str3, List list2, Exception exc, int i, DefaultConstructorMarker defaultConstructorMarker) {
            list = (i & 4) != 0 ? null : list;
            if ((i & 8) != 0) {
                str3 = DiagnosticContext.INSTANCE.getThreadCorrelationId();
                Intrinsics.checkNotNullExpressionValue(str3, "INSTANCE.threadCorrelationId");
            }
            this(str, str2, list, str3, (i & 16) != 0 ? null : list2, (i & 32) != 0 ? null : exc);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult.Error, com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult
        public String getCorrelationId() {
            return this.correlationId;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult.Error
        public List<Integer> getErrorCodes() {
            return this.errorCodes;
        }

        public final Exception getException() {
            return this.exception;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public InvalidUsername(String str, String str2, List<? extends Map<String, String>> list, String correlationId, List<Integer> list2, Exception exc) {
            super(str, str2, list, correlationId, list2);
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            this.error = str;
            this.errorDescription = str2;
            this.details = list;
            this.correlationId = correlationId;
            this.errorCodes = list2;
            this.exception = exc;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toUnsanitizedString() {
            return "InvalidUsername(correlationId=" + getCorrelationId() + ", error=" + getError() + ", errorDescription=" + getErrorDescription() + "), details=" + getDetails() + ", errorCodes=" + getErrorCodes() + ')';
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        public String toString() {
            return "InvalidUsername(correlationId=" + getCorrelationId() + ')';
        }
    }
}
