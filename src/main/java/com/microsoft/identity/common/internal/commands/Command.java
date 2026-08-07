package com.microsoft.identity.common.internal.commands;

import com.microsoft.identity.common.java.controllers.BaseController;

/* JADX INFO: loaded from: classes14.dex */
public interface Command<T> {
    T execute() throws Exception;

    BaseController getDefaultController();

    boolean isEligibleForCaching();

    boolean isEligibleForEstsTelemetry();
}
