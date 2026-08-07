package com.margelo.nitro.boxcontext.providers;

import com.margelo.nitro.boxcontext.LoggingSeverity;
import kotlin.Metadata;

/* JADX INFO: compiled from: LoggingProvider.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/margelo/nitro/boxcontext/providers/LoggingProvider;", "", "log", "", "severity", "Lcom/margelo/nitro/boxcontext/LoggingSeverity;", "message", "", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface LoggingProvider {
    void log(LoggingSeverity severity, String message);
}
