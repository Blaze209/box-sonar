package com.microsoft.identity.nativeauth.statemachine.results;

import com.microsoft.identity.client.IAuthenticationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetAccessTokenResult.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/GetAccessTokenResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result;", "Complete", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface GetAccessTokenResult extends Result {

    /* JADX INFO: compiled from: GetAccessTokenResult.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isComplete(GetAccessTokenResult getAccessTokenResult) {
            return Result.DefaultImpls.isComplete(getAccessTokenResult);
        }

        public static boolean isError(GetAccessTokenResult getAccessTokenResult) {
            return Result.DefaultImpls.isError(getAccessTokenResult);
        }

        public static boolean isSuccess(GetAccessTokenResult getAccessTokenResult) {
            return Result.DefaultImpls.isSuccess(getAccessTokenResult);
        }
    }

    /* JADX INFO: compiled from: GetAccessTokenResult.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/GetAccessTokenResult$Complete;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result$CompleteResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/GetAccessTokenResult;", "resultValue", "Lcom/microsoft/identity/client/IAuthenticationResult;", "(Lcom/microsoft/identity/client/IAuthenticationResult;)V", "getResultValue", "()Lcom/microsoft/identity/client/IAuthenticationResult;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Complete extends Result.CompleteResult implements GetAccessTokenResult {
        private final IAuthenticationResult resultValue;

        @Override // com.microsoft.identity.nativeauth.statemachine.results.Result.CompleteResult
        public IAuthenticationResult getResultValue() {
            return this.resultValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Complete(IAuthenticationResult resultValue) {
            super(resultValue);
            Intrinsics.checkNotNullParameter(resultValue, "resultValue");
            this.resultValue = resultValue;
        }
    }
}
