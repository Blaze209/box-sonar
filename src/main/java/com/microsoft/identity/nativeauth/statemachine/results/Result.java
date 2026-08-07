package com.microsoft.identity.nativeauth.statemachine.results;

import com.microsoft.identity.nativeauth.statemachine.errors.Error;
import com.microsoft.identity.nativeauth.statemachine.states.State;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseResults.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0004\u0006\u0007\b\tJ\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/Result;", "", "isComplete", "", "isError", "isSuccess", "CompleteResult", "CompleteWithNextStateResult", "ErrorResult", "SuccessResult", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Result {
    boolean isComplete();

    boolean isError();

    boolean isSuccess();

    /* JADX INFO: compiled from: BaseResults.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/Result$SuccessResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result;", "nextState", "Lcom/microsoft/identity/nativeauth/statemachine/states/State;", "(Lcom/microsoft/identity/nativeauth/statemachine/states/State;)V", "getNextState", "()Lcom/microsoft/identity/nativeauth/statemachine/states/State;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class SuccessResult implements Result {
        private final State nextState;

        public SuccessResult(State nextState) {
            Intrinsics.checkNotNullParameter(nextState, "nextState");
            this.nextState = nextState;
        }

        public State getNextState() {
            return this.nextState;
        }

        @Override // com.microsoft.identity.nativeauth.statemachine.results.Result
        public boolean isComplete() {
            return DefaultImpls.isComplete(this);
        }

        @Override // com.microsoft.identity.nativeauth.statemachine.results.Result
        public boolean isError() {
            return DefaultImpls.isError(this);
        }

        @Override // com.microsoft.identity.nativeauth.statemachine.results.Result
        public boolean isSuccess() {
            return DefaultImpls.isSuccess(this);
        }
    }

    /* JADX INFO: compiled from: BaseResults.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/Result$ErrorResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result;", "error", "Lcom/microsoft/identity/nativeauth/statemachine/errors/Error;", "(Lcom/microsoft/identity/nativeauth/statemachine/errors/Error;)V", "getError", "()Lcom/microsoft/identity/nativeauth/statemachine/errors/Error;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class ErrorResult implements Result {
        private final Error error;

        public ErrorResult(Error error) {
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        public Error getError() {
            return this.error;
        }

        @Override // com.microsoft.identity.nativeauth.statemachine.results.Result
        public boolean isComplete() {
            return DefaultImpls.isComplete(this);
        }

        @Override // com.microsoft.identity.nativeauth.statemachine.results.Result
        public boolean isError() {
            return DefaultImpls.isError(this);
        }

        @Override // com.microsoft.identity.nativeauth.statemachine.results.Result
        public boolean isSuccess() {
            return DefaultImpls.isSuccess(this);
        }
    }

    /* JADX INFO: compiled from: BaseResults.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/Result$CompleteResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result;", "resultValue", "", "(Ljava/lang/Object;)V", "getResultValue", "()Ljava/lang/Object;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class CompleteResult implements Result {
        private final Object resultValue;

        /* JADX WARN: Illegal instructions before constructor call */
        public CompleteResult() {
            DefaultConstructorMarker defaultConstructorMarker = null;
            this(defaultConstructorMarker, 1, defaultConstructorMarker);
        }

        public CompleteResult(Object obj) {
            this.resultValue = obj;
        }

        public /* synthetic */ CompleteResult(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : obj);
        }

        public Object getResultValue() {
            return this.resultValue;
        }

        @Override // com.microsoft.identity.nativeauth.statemachine.results.Result
        public boolean isComplete() {
            return DefaultImpls.isComplete(this);
        }

        @Override // com.microsoft.identity.nativeauth.statemachine.results.Result
        public boolean isError() {
            return DefaultImpls.isError(this);
        }

        @Override // com.microsoft.identity.nativeauth.statemachine.results.Result
        public boolean isSuccess() {
            return DefaultImpls.isSuccess(this);
        }
    }

    /* JADX INFO: compiled from: BaseResults.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/results/Result$CompleteWithNextStateResult;", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result$CompleteResult;", "resultValue", "", "nextState", "Lcom/microsoft/identity/nativeauth/statemachine/states/State;", "(Ljava/lang/Object;Lcom/microsoft/identity/nativeauth/statemachine/states/State;)V", "getNextState", "()Lcom/microsoft/identity/nativeauth/statemachine/states/State;", "getResultValue", "()Ljava/lang/Object;", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class CompleteWithNextStateResult extends CompleteResult {
        private final State nextState;
        private final Object resultValue;

        public CompleteWithNextStateResult(Object obj, State state) {
            super(obj);
            this.resultValue = obj;
            this.nextState = state;
        }

        public /* synthetic */ CompleteWithNextStateResult(Object obj, State state, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : obj, state);
        }

        public State getNextState() {
            return this.nextState;
        }

        @Override // com.microsoft.identity.nativeauth.statemachine.results.Result.CompleteResult
        public Object getResultValue() {
            return this.resultValue;
        }
    }

    /* JADX INFO: compiled from: BaseResults.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isSuccess(Result result) {
            return result instanceof SuccessResult;
        }

        public static boolean isError(Result result) {
            return result instanceof ErrorResult;
        }

        public static boolean isComplete(Result result) {
            return result instanceof CompleteResult;
        }
    }
}
