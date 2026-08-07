package com.splunk.rum;

import android.util.Log;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: classes3.dex */
class MemoryBufferingExporter implements SpanExporter {
    private static final int MAX_BACKLOG_SIZE = 100;
    private final Queue<SpanData> backlog = new ArrayDeque(100);
    private final ConnectionUtil connectionUtil;
    private final SpanExporter delegate;

    MemoryBufferingExporter(ConnectionUtil connectionUtil, SpanExporter spanExporter) {
        this.connectionUtil = connectionUtil;
        this.delegate = spanExporter;
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode export(Collection<SpanData> collection) {
        this.backlog.addAll(collection);
        if (!this.connectionUtil.refreshNetworkStatus().isOnline()) {
            Log.i("SplunkRum", "Network offline, buffering " + collection.size() + " spans for eventual export.");
            return CompletableResultCode.ofSuccess();
        }
        final List<SpanData> listFillFromBacklog = fillFromBacklog();
        Log.d("SplunkRum", "Sending " + listFillFromBacklog.size() + " spans for export");
        final CompletableResultCode completableResultCodeExport = this.delegate.export(listFillFromBacklog);
        completableResultCodeExport.whenComplete(new Runnable() { // from class: com.splunk.rum.MemoryBufferingExporter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m14335lambda$export$0$comsplunkrumMemoryBufferingExporter(completableResultCodeExport, listFillFromBacklog);
            }
        });
        return completableResultCodeExport;
    }

    /* JADX INFO: renamed from: lambda$export$0$com-splunk-rum-MemoryBufferingExporter, reason: not valid java name */
    /* synthetic */ void m14335lambda$export$0$comsplunkrumMemoryBufferingExporter(CompletableResultCode completableResultCode, List list) {
        if (completableResultCode.isSuccess()) {
            return;
        }
        Log.i("SplunkRum", "Export failed. adding " + list.size() + " spans to the backlog");
        addFailedSpansToBacklog(list);
    }

    private void addFailedSpansToBacklog(List<SpanData> list) {
        for (SpanData spanData : list) {
            if (this.backlog.size() < 100) {
                this.backlog.add(spanData);
            }
        }
    }

    private List<SpanData> fillFromBacklog() {
        ArrayList arrayList = new ArrayList(this.backlog);
        this.backlog.clear();
        return arrayList;
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode flush() {
        if (!this.backlog.isEmpty()) {
            return export(fillFromBacklog());
        }
        return this.delegate.flush();
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode shutdown() {
        this.backlog.clear();
        return this.delegate.shutdown();
    }
}
