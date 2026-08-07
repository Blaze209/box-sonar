package io.opentelemetry.sdk.logs.export;

import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.logs.data.LogRecordData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes4.dex */
public final class InMemoryLogRecordExporter implements LogRecordExporter {
    private final Queue<LogRecordData> finishedLogItems = new ConcurrentLinkedQueue();
    private boolean isStopped = false;

    private InMemoryLogRecordExporter() {
    }

    public static InMemoryLogRecordExporter create() {
        return new InMemoryLogRecordExporter();
    }

    public List<LogRecordData> getFinishedLogItems() {
        return Collections.unmodifiableList(new ArrayList(this.finishedLogItems));
    }

    public void reset() {
        this.finishedLogItems.clear();
    }

    @Override // io.opentelemetry.sdk.logs.export.LogRecordExporter
    public CompletableResultCode export(Collection<LogRecordData> collection) {
        if (this.isStopped) {
            return CompletableResultCode.ofFailure();
        }
        this.finishedLogItems.addAll(collection);
        return CompletableResultCode.ofSuccess();
    }

    @Override // io.opentelemetry.sdk.logs.export.LogRecordExporter
    public CompletableResultCode flush() {
        return CompletableResultCode.ofSuccess();
    }

    @Override // io.opentelemetry.sdk.logs.export.LogRecordExporter
    public CompletableResultCode shutdown() {
        this.isStopped = true;
        this.finishedLogItems.clear();
        return CompletableResultCode.ofSuccess();
    }
}
