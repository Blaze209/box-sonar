package io.opentelemetry.sdk.logs;

import io.opentelemetry.context.Context;

/* JADX INFO: loaded from: classes4.dex */
final class NoopLogRecordProcessor implements LogRecordProcessor {
    private static final NoopLogRecordProcessor INSTANCE = new NoopLogRecordProcessor();

    @Override // io.opentelemetry.sdk.logs.LogRecordProcessor
    public void onEmit(Context context, ReadWriteLogRecord readWriteLogRecord) {
    }

    static LogRecordProcessor getInstance() {
        return INSTANCE;
    }

    private NoopLogRecordProcessor() {
    }
}
