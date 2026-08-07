package com.microsoft.identity.nativeauth.statemachine.results;

import com.microsoft.identity.nativeauth.statemachine.states.ResetPasswordPasswordRequiredState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResetPasswordResult.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordSubmitCodeResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result;", "PasswordRequired", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ResetPasswordSubmitCodeResult extends Result {

    /* JADX INFO: compiled from: ResetPasswordResult.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isComplete(ResetPasswordSubmitCodeResult resetPasswordSubmitCodeResult) {
            return Result.DefaultImpls.isComplete(resetPasswordSubmitCodeResult);
        }

        public static boolean isError(ResetPasswordSubmitCodeResult resetPasswordSubmitCodeResult) {
            return Result.DefaultImpls.isError(resetPasswordSubmitCodeResult);
        }

        public static boolean isSuccess(ResetPasswordSubmitCodeResult resetPasswordSubmitCodeResult) {
            return Result.DefaultImpls.isSuccess(resetPasswordSubmitCodeResult);
        }
    }

    /* JADX INFO: compiled from: ResetPasswordResult.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordSubmitCodeResult$PasswordRequired;", "Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordSubmitCodeResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result$SuccessResult;", "nextState", "Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordPasswordRequiredState;", "(Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordPasswordRequiredState;)V", "getNextState", "()Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordPasswordRequiredState;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PasswordRequired extends Result.SuccessResult implements ResetPasswordSubmitCodeResult {
        private final ResetPasswordPasswordRequiredState nextState;

        @Override // com.microsoft.identity.nativeauth.statemachine.results.Result.SuccessResult
        public ResetPasswordPasswordRequiredState getNextState() {
            return this.nextState;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PasswordRequired(ResetPasswordPasswordRequiredState nextState) {
            super(nextState);
            Intrinsics.checkNotNullParameter(nextState, "nextState");
            this.nextState = nextState;
        }
    }
}
