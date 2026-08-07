package io.opentelemetry.sdk.logs;

import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.CompletableResultCode;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public interface LogRecordProcessor extends Closeable {
    void onEmit(Context context, ReadWriteLogRecord readWriteLogRecord);

    static LogRecordProcessor composite(LogRecordProcessor... logRecordProcessorArr) {
        return composite(Arrays.asList(logRecordProcessorArr));
    }

    static LogRecordProcessor composite(Iterable<LogRecordProcessor> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<LogRecordProcessor> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        if (arrayList.isEmpty()) {
            return NoopLogRecordProcessor.getInstance();
        }
        if (arrayList.size() == 1) {
            return (LogRecordProcessor) arrayList.get(0);
        }
        return MultiLogRecordProcessor.create(arrayList);
    }

    default CompletableResultCode shutdown() {
        return forceFlush();
    }

    default CompletableResultCode forceFlush() {
        return CompletableResultCode.ofSuccess();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    default void close() {
        shutdown().join(10L, TimeUnit.SECONDS);
    }
}
