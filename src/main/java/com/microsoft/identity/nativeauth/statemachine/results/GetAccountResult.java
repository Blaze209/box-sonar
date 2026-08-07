package com.microsoft.identity.nativeauth.statemachine.results;

import com.microsoft.identity.nativeauth.statemachine.states.AccountState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetAccountResult.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/GetAccountResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result;", "AccountFound", "NoAccountFound", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface GetAccountResult extends Result {

    /* JADX INFO: compiled from: GetAccountResult.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isComplete(GetAccountResult getAccountResult) {
            return Result.DefaultImpls.isComplete(getAccountResult);
        }

        public static boolean isError(GetAccountResult getAccountResult) {
            return Result.DefaultImpls.isError(getAccountResult);
        }

        public static boolean isSuccess(GetAccountResult getAccountResult) {
            return Result.DefaultImpls.isSuccess(getAccountResult);
        }
    }

    /* JADX INFO: compiled from: GetAccountResult.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/GetAccountResult$AccountFound;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result$CompleteResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/GetAccountResult;", "resultValue", "Lcom/microsoft/identity/nativeauth/statemachine/states/AccountState;", "(Lcom/microsoft/identity/nativeauth/statemachine/states/AccountState;)V", "getResultValue", "()Lcom/microsoft/identity/nativeauth/statemachine/states/AccountState;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AccountFound extends Result.CompleteResult implements GetAccountResult {
        private final AccountState resultValue;

        @Override // com.microsoft.identity.nativeauth.statemachine.results.Result.CompleteResult
        public AccountState getResultValue() {
            return this.resultValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AccountFound(AccountState resultValue) {
            super(resultValue);
            Intrinsics.checkNotNullParameter(resultValue, "resultValue");
            this.resultValue = resultValue;
        }
    }

    /* JADX INFO: compiled from: GetAccountResult.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/GetAccountResult$NoAccountFound;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result$CompleteResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/GetAccountResult;", "()V", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class NoAccountFound extends Result.CompleteResult implements GetAccountResult {
        public static final NoAccountFound INSTANCE = new NoAccountFound();

        private NoAccountFound() {
            super(null, 1, null);
        }
    }
}
