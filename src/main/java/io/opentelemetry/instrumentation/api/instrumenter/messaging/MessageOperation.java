package io.opentelemetry.instrumentation.api.instrumenter.messaging;

import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public enum MessageOperation {
    SEND,
    RECEIVE,
    PROCESS;

    String operationName() {
        return name().toLowerCase(Locale.ROOT);
    }
}
