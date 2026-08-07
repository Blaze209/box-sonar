package com.microsoft.identity.common.java.commands;

/* JADX INFO: loaded from: classes14.dex */
public interface ICommand<T> {
    T execute() throws Exception;

    String getCorrelationId();

    boolean isEligibleForCaching();

    boolean isEligibleForEstsTelemetry();

    boolean willReachTokenEndpoint();
}
