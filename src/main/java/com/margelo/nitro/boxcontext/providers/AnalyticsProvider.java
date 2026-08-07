package com.margelo.nitro.boxcontext.providers;

import com.margelo.nitro.boxcontext.LogEventProperties;
import com.margelo.nitro.core.AnyMap;
import kotlin.Metadata;

/* JADX INFO: compiled from: AnalyticsProvider.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/margelo/nitro/boxcontext/providers/AnalyticsProvider;", "", "trackEvent", "", "name", "", "properties", "Lcom/margelo/nitro/core/AnyMap;", "logEvent", "Lcom/margelo/nitro/boxcontext/LogEventProperties;", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AnalyticsProvider {
    void logEvent(String name, LogEventProperties properties);

    void trackEvent(String name, AnyMap properties);
}
