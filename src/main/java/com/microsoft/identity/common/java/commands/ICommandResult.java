package com.microsoft.identity.common.java.commands;

/* JADX INFO: loaded from: classes14.dex */
public interface ICommandResult<T> {
    String getCorrelationId();

    T getResult();

    ResultStatus getStatus();

    public enum ResultStatus {
        CANCEL,
        COMPLETED,
        ERROR,
        VOID;

        public String getLogStatus() {
            return name();
        }
    }
}
