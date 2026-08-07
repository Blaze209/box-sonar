package com.microsoft.identity.nativeauth.statemachine.results;

import com.microsoft.identity.nativeauth.statemachine.states.MFARequiredState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MFAResult.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/MFARequiredResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result;", "VerificationRequired", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface MFARequiredResult extends Result {

    /* JADX INFO: compiled from: MFAResult.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isComplete(MFARequiredResult mFARequiredResult) {
            return Result.DefaultImpls.isComplete(mFARequiredResult);
        }

        public static boolean isError(MFARequiredResult mFARequiredResult) {
            return Result.DefaultImpls.isError(mFARequiredResult);
        }

        public static boolean isSuccess(MFARequiredResult mFARequiredResult) {
            return Result.DefaultImpls.isSuccess(mFARequiredResult);
        }
    }

    /* JADX INFO: compiled from: MFAResult.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/MFARequiredResult$VerificationRequired;", "Lcom/microsoft/identity/nativeauth/statemachine/results/MFARequiredResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result$SuccessResult;", "nextState", "Lcom/microsoft/identity/nativeauth/statemachine/states/MFARequiredState;", "codeLength", "", "sentTo", "", "channel", "(Lcom/microsoft/identity/nativeauth/statemachine/states/MFARequiredState;ILjava/lang/String;Ljava/lang/String;)V", "getChannel", "()Ljava/lang/String;", "getCodeLength", "()I", "getNextState", "()Lcom/microsoft/identity/nativeauth/statemachine/states/MFARequiredState;", "getSentTo", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class VerificationRequired extends Result.SuccessResult implements MFARequiredResult {
        private final String channel;
        private final int codeLength;
        private final MFARequiredState nextState;
        private final String sentTo;

        @Override // com.microsoft.identity.nativeauth.statemachine.results.Result.SuccessResult
        public MFARequiredState getNextState() {
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
        public VerificationRequired(MFARequiredState nextState, int i, String sentTo, String channel) {
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
