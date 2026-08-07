package com.microsoft.identity.nativeauth.statemachine.results;

import com.microsoft.identity.nativeauth.statemachine.states.SignInContinuationState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResetPasswordResult.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result;", "Complete", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ResetPasswordResult extends Result {

    /* JADX INFO: compiled from: ResetPasswordResult.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isComplete(ResetPasswordResult resetPasswordResult) {
            return Result.DefaultImpls.isComplete(resetPasswordResult);
        }

        public static boolean isError(ResetPasswordResult resetPasswordResult) {
            return Result.DefaultImpls.isError(resetPasswordResult);
        }

        public static boolean isSuccess(ResetPasswordResult resetPasswordResult) {
            return Result.DefaultImpls.isSuccess(resetPasswordResult);
        }
    }

    /* JADX INFO: compiled from: ResetPasswordResult.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordResult$Complete;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result$CompleteWithNextStateResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordSubmitPasswordResult;", "nextState", "Lcom/microsoft/identity/nativeauth/statemachine/states/SignInContinuationState;", "(Lcom/microsoft/identity/nativeauth/statemachine/states/SignInContinuationState;)V", "getNextState", "()Lcom/microsoft/identity/nativeauth/statemachine/states/SignInContinuationState;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Complete extends Result.CompleteWithNextStateResult implements ResetPasswordResult, ResetPasswordSubmitPasswordResult {
        private final SignInContinuationState nextState;

        @Override // com.microsoft.identity.nativeauth.statemachine.results.Result.CompleteWithNextStateResult
        public SignInContinuationState getNextState() {
            return this.nextState;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Complete(SignInContinuationState nextState) {
            super(null, nextState);
            Intrinsics.checkNotNullParameter(nextState, "nextState");
            this.nextState = nextState;
        }
    }
}
