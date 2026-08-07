package com.microsoft.identity.nativeauth.statemachine.errors;

import com.microsoft.identity.nativeauth.statemachine.results.ResetPasswordResendCodeResult;
import com.microsoft.identity.nativeauth.statemachine.results.SignInResendCodeResult;
import com.microsoft.identity.nativeauth.statemachine.results.SignUpResendCodeResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Error.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005BS\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010¢\u0006\u0002\u0010\u0011R\u0014\u0010\n\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001c\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\"\u0010\u000e\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/errors/ResendCodeError;", "Lcom/microsoft/identity/nativeauth/statemachine/errors/BrowserRequiredError;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResendCodeResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpResendCodeResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordResendCodeResult;", "Lcom/microsoft/identity/nativeauth/statemachine/errors/Error;", "errorType", "", "error", "errorMessage", "correlationId", "errorCodes", "", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Exception;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorMessage", "getErrorType$msal_distRelease", "getException", "()Ljava/lang/Exception;", "setException", "(Ljava/lang/Exception;)V", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ResendCodeError extends Error implements BrowserRequiredError, SignInResendCodeResult, SignUpResendCodeResult, ResetPasswordResendCodeResult {
    private final String correlationId;
    private final String error;
    private final List<Integer> errorCodes;
    private final String errorMessage;
    private final String errorType;
    private Exception exception;

    public /* synthetic */ ResendCodeError(String str, String str2, String str3, String str4, List list, Exception exc, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, str3, str4, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : exc);
    }

    @Override // com.microsoft.identity.nativeauth.statemachine.errors.BrowserRequiredError
    public boolean isBrowserRequired() {
        return BrowserRequiredError.DefaultImpls.isBrowserRequired(this);
    }

    @Override // com.microsoft.identity.nativeauth.statemachine.results.Result
    public boolean isComplete() {
        return SignInResendCodeResult.DefaultImpls.isComplete(this);
    }

    @Override // com.microsoft.identity.nativeauth.statemachine.results.Result
    public boolean isError() {
        return SignInResendCodeResult.DefaultImpls.isError(this);
    }

    @Override // com.microsoft.identity.nativeauth.statemachine.results.Result
    public boolean isSuccess() {
        return SignInResendCodeResult.DefaultImpls.isSuccess(this);
    }

    @Override // com.microsoft.identity.nativeauth.statemachine.errors.Error
    /* JADX INFO: renamed from: getErrorType$msal_distRelease, reason: from getter */
    public String getErrorType() {
        return this.errorType;
    }

    @Override // com.microsoft.identity.nativeauth.statemachine.errors.Error
    public String getError() {
        return this.error;
    }

    @Override // com.microsoft.identity.nativeauth.statemachine.errors.Error
    public String getErrorMessage() {
        return this.errorMessage;
    }

    @Override // com.microsoft.identity.nativeauth.statemachine.errors.Error
    public String getCorrelationId() {
        return this.correlationId;
    }

    @Override // com.microsoft.identity.nativeauth.statemachine.errors.Error
    public List<Integer> getErrorCodes() {
        return this.errorCodes;
    }

    @Override // com.microsoft.identity.nativeauth.statemachine.errors.Error
    public Exception getException() {
        return this.exception;
    }

    @Override // com.microsoft.identity.nativeauth.statemachine.errors.Error
    public void setException(Exception exc) {
        this.exception = exc;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResendCodeError(String str, String str2, String str3, String correlationId, List<Integer> list, Exception exc) {
        super(str, str2, str3, correlationId, exc, list);
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        this.errorType = str;
        this.error = str2;
        this.errorMessage = str3;
        this.correlationId = correlationId;
        this.errorCodes = list;
        this.exception = exc;
    }
}
