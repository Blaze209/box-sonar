package com.microsoft.identity.nativeauth.statemachine.results;

import com.microsoft.identity.nativeauth.statemachine.states.ResetPasswordCodeRequiredState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResetPasswordResult.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordResendCodeResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result;", "Success", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ResetPasswordResendCodeResult extends Result {

    /* JADX INFO: compiled from: ResetPasswordResult.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isComplete(ResetPasswordResendCodeResult resetPasswordResendCodeResult) {
            return Result.DefaultImpls.isComplete(resetPasswordResendCodeResult);
        }

        public static boolean isError(ResetPasswordResendCodeResult resetPasswordResendCodeResult) {
            return Result.DefaultImpls.isError(resetPasswordResendCodeResult);
        }

        public static boolean isSuccess(ResetPasswordResendCodeResult resetPasswordResendCodeResult) {
            return Result.DefaultImpls.isSuccess(resetPasswordResendCodeResult);
        }
    }

    /* JADX INFO: compiled from: ResetPasswordResult.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordResendCodeResult$Success;", "Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordResendCodeResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result$SuccessResult;", "nextState", "Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordCodeRequiredState;", "codeLength", "", "sentTo", "", "channel", "(Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordCodeRequiredState;ILjava/lang/String;Ljava/lang/String;)V", "getChannel", "()Ljava/lang/String;", "getCodeLength", "()I", "getNextState", "()Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordCodeRequiredState;", "getSentTo", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Success extends Result.SuccessResult implements ResetPasswordResendCodeResult {
        private final String channel;
        private final int codeLength;
        private final ResetPasswordCodeRequiredState nextState;
        private final String sentTo;

        @Override // com.microsoft.identity.nativeauth.statemachine.results.Result.SuccessResult
        public ResetPasswordCodeRequiredState getNextState() {
            return this.nextState;
        }

        public final int getCodeLength() {
            return this.codeLength;
        }

        public final String getSentTo() {
            return this.sentTo;
        }

        public final String getChannel() {
            return this.channel;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(ResetPasswordCodeRequiredState nextState, int i, String sentTo, String channel) {
            super(nextState);
            Intrinsics.checkNotNullParameter(nextState, "nextState");
            Intrinsics.checkNotNullParameter(sentTo, "sentTo");
            Intrinsics.checkNotNullParameter(channel, "channel");
            this.nextState = nextState;
            this.codeLength = i;
            this.sentTo = sentTo;
            this.channel = channel;
        }
    }
}
