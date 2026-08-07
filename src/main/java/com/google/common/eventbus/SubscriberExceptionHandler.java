package com.google.common.eventbus;

/* JADX INFO: loaded from: classes14.dex */
@ElementTypesAreNonnullByDefault
public interface SubscriberExceptionHandler {
    void handleException(Throwable exception, SubscriberExceptionContext context);
}
