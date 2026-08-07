package com.microsoft.identity.nativeauth.statemachine.results;

import com.microsoft.identity.nativeauth.AuthMethod;
import com.microsoft.identity.nativeauth.statemachine.states.AccountState;
import com.microsoft.identity.nativeauth.statemachine.states.AwaitingMFAState;
import com.microsoft.identity.nativeauth.statemachine.states.RegisterStrongAuthState;
import com.microsoft.identity.nativeauth.statemachine.states.SignInCodeRequiredState;
import com.microsoft.identity.nativeauth.statemachine.states.SignInPasswordRequiredState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignInResult.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result;", "CodeRequired", "Complete", "MFARequired", "PasswordRequired", "StrongAuthMethodRegistrationRequired", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SignInResult extends Result {

    /* JADX INFO: compiled from: SignInResult.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isComplete(SignInResult signInResult) {
            return Result.DefaultImpls.isComplete(signInResult);
        }

        public static boolean isError(SignInResult signInResult) {
            return Result.DefaultImpls.isError(signInResult);
        }

        public static boolean isSuccess(SignInResult signInResult) {
            return Result.DefaultImpls.isSuccess(signInResult);
        }
    }

    /* JADX INFO: compiled from: SignInResult.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\r\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResult$Complete;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result$CompleteResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInSubmitCodeResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInSubmitPasswordResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/MFASubmitChallengeResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/RegisterStrongAuthChallengeResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/RegisterStrongAuthSubmitChallengeResult;", "resultValue", "Lcom/microsoft/identity/nativeauth/statemachine/states/AccountState;", "(Lcom/microsoft/identity/nativeauth/statemachine/states/AccountState;)V", "getResultValue", "()Lcom/microsoft/identity/nativeauth/statemachine/states/AccountState;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Complete extends Result.CompleteResult implements SignInResult, SignInSubmitCodeResult, SignInSubmitPasswordResult, MFASubmitChallengeResult, RegisterStrongAuthChallengeResult, RegisterStrongAuthSubmitChallengeResult {
        private final AccountState resultValue;

        @Override // com.microsoft.identity.nativeauth.statemachine.results.Result.CompleteResult
        public AccountState getResultValue() {
            return this.resultValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Complete(AccountState resultValue) {
            super(resultValue);
            Intrinsics.checkNotNullParameter(resultValue, "resultValue");
            this.resultValue = resultValue;
        }
    }

    /* JADX INFO: compiled from: SignInResult.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResult$CodeRequired;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result$SuccessResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInSubmitPasswordResult;", "nextState", "Lcom/microsoft/identity/nativeauth/statemachine/states/SignInCodeRequiredState;", "codeLength", "", "sentTo", "", "channel", "(Lcom/microsoft/identity/nativeauth/statemachine/states/SignInCodeRequiredState;ILjava/lang/String;Ljava/lang/String;)V", "getChannel", "()Ljava/lang/String;", "getCodeLength", "()I", "getNextState", "()Lcom/microsoft/identity/nativeauth/statemachine/states/SignInCodeRequiredState;", "getSentTo", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class CodeRequired extends Result.SuccessResult implements SignInResult, SignInSubmitPasswordResult {
        private final String channel;
        private final int codeLength;
        private final SignInCodeRequiredState nextState;
        private final String sentTo;

        @Override // com.microsoft.identity.nativeauth.statemachine.results.Result.SuccessResult
        public SignInCodeRequiredState getNextState() {
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
        public CodeRequired(SignInCodeRequiredState nextState, int i, String sentTo, String channel) {
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

    /* JADX INFO: compiled from: SignInResult.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResult$PasswordRequired;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result$SuccessResult;", "nextState", "Lcom/microsoft/identity/nativeauth/statemachine/states/SignInPasswordRequiredState;", "(Lcom/microsoft/identity/nativeauth/statemachine/states/SignInPasswordRequiredState;)V", "getNextState", "()Lcom/microsoft/identity/nativeauth/statemachine/states/SignInPasswordRequiredState;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PasswordRequired extends Result.SuccessResult implements SignInResult {
        private final SignInPasswordRequiredState nextState;

        @Override // com.microsoft.identity.nativeauth.statemachine.results.Result.SuccessResult
        public SignInPasswordRequiredState getNextState() {
            return this.nextState;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PasswordRequired(SignInPasswordRequiredState nextState) {
            super(nextState);
            Intrinsics.checkNotNullParameter(nextState, "nextState");
            this.nextState = nextState;
        }
    }

    /* JADX INFO: compiled from: SignInResult.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResult$MFARequired;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result$SuccessResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInSubmitPasswordResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInSubmitCodeResult;", "nextState", "Lcom/microsoft/identity/nativeauth/statemachine/states/AwaitingMFAState;", "authMethods", "", "Lcom/microsoft/identity/nativeauth/AuthMethod;", "(Lcom/microsoft/identity/nativeauth/statemachine/states/AwaitingMFAState;Ljava/util/List;)V", "getAuthMethods", "()Ljava/util/List;", "getNextState", "()Lcom/microsoft/identity/nativeauth/statemachine/states/AwaitingMFAState;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class MFARequired extends Result.SuccessResult implements SignInResult, SignInSubmitPasswordResult, SignInSubmitCodeResult {
        private final List<AuthMethod> authMethods;
        private final AwaitingMFAState nextState;

        @Override // com.microsoft.identity.nativeauth.statemachine.results.Result.SuccessResult
        public AwaitingMFAState getNextState() {
            return this.nextState;
        }

        public final List<AuthMethod> getAuthMethods() {
            return this.authMethods;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MFARequired(AwaitingMFAState nextState, List<AuthMethod> authMethods) {
            super(nextState);
            Intrinsics.checkNotNullParameter(nextState, "nextState");
            Intrinsics.checkNotNullParameter(authMethods, "authMethods");
            this.nextState = nextState;
            this.authMethods = authMethods;
        }
    }

    /* JADX INFO: compiled from: SignInResult.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResult$StrongAuthMethodRegistrationRequired;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result$SuccessResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInSubmitPasswordResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInSubmitCodeResult;", "nextState", "Lcom/microsoft/identity/nativeauth/statemachine/states/RegisterStrongAuthState;", "authMethods", "", "Lcom/microsoft/identity/nativeauth/AuthMethod;", "(Lcom/microsoft/identity/nativeauth/statemachine/states/RegisterStrongAuthState;Ljava/util/List;)V", "getAuthMethods", "()Ljava/util/List;", "getNextState", "()Lcom/microsoft/identity/nativeauth/statemachine/states/RegisterStrongAuthState;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class StrongAuthMethodRegistrationRequired extends Result.SuccessResult implements SignInResult, SignInSubmitPasswordResult, SignInSubmitCodeResult {
        private final List<AuthMethod> authMethods;
        private final RegisterStrongAuthState nextState;

        @Override // com.microsoft.identity.nativeauth.statemachine.results.Result.SuccessResult
        public RegisterStrongAuthState getNextState() {
            return this.nextState;
        }

        public final List<AuthMethod> getAuthMethods() {
            return this.authMethods;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StrongAuthMethodRegistrationRequired(RegisterStrongAuthState nextState, List<AuthMethod> authMethods) {
            super(nextState);
            Intrinsics.checkNotNullParameter(nextState, "nextState");
            Intrinsics.checkNotNullParameter(authMethods, "authMethods");
            this.nextState = nextState;
            this.authMethods = authMethods;
        }
    }
}
