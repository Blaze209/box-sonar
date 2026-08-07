package io.opentelemetry.sdk.logs.export;

import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.logs.data.LogRecordData;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public interface LogRecordExporter extends Closeable {
    CompletableResultCode export(Collection<LogRecordData> collection);

    CompletableResultCode flush();

    CompletableResultCode shutdown();

    static LogRecordExporter composite(LogRecordExporter... logRecordExporterArr) {
        return composite(Arrays.asList(logRecordExporterArr));
    }

    static LogRecordExporter composite(Iterable<LogRecordExporter> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<LogRecordExporter> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        if (arrayList.isEmpty()) {
            return NoopLogRecordExporter.getInstance();
        }
        if (arrayList.size() == 1) {
            return (LogRecordExporter) arrayList.get(0);
        }
        return MultiLogRecordExporter.create(arrayList);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    default void close() {
        shutdown().join(10L, TimeUnit.SECONDS);
    }
}
