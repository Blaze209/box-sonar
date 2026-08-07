package io.opentelemetry.sdk.trace;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.sdk.common.InstrumentationLibraryInfo;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.internal.InstrumentationScopeUtil;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.data.EventData;
import io.opentelemetry.sdk.trace.data.LinkData;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.data.StatusData;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
abstract class SpanWrapper implements SpanData {
    abstract Attributes attributes();

    abstract SdkSpan delegate();

    abstract long endEpochNanos();

    abstract boolean internalHasEnded();

    abstract String name();

    abstract List<EventData> resolvedEvents();

    abstract List<LinkData> resolvedLinks();

    abstract StatusData status();

    abstract int totalAttributeCount();

    abstract int totalRecordedEvents();

    SpanWrapper() {
    }

    static SpanWrapper create(SdkSpan sdkSpan, List<LinkData> list, List<EventData> list2, Attributes attributes, int i, int i2, StatusData statusData, String str, long j, boolean z) {
        return new AutoValue_SpanWrapper(sdkSpan, list, list2, attributes, i, i2, statusData, str, j, z);
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public SpanContext getSpanContext() {
        return delegate().getSpanContext();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public SpanContext getParentSpanContext() {
        return delegate().getParentSpanContext();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public Resource getResource() {
        return delegate().getResource();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    @Deprecated
    public InstrumentationLibraryInfo getInstrumentationLibraryInfo() {
        return InstrumentationScopeUtil.toInstrumentationLibraryInfo(delegate().getInstrumentationScopeInfo());
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public InstrumentationScopeInfo getInstrumentationScopeInfo() {
        return delegate().getInstrumentationScopeInfo();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public String getName() {
        return name();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public SpanKind getKind() {
        return delegate().getKind();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public long getStartEpochNanos() {
        return delegate().getStartEpochNanos();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public Attributes getAttributes() {
        return attributes();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public List<EventData> getEvents() {
        return resolvedEvents();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public List<LinkData> getLinks() {
        return resolvedLinks();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public StatusData getStatus() {
        return status();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public long getEndEpochNanos() {
        return endEpochNanos();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public boolean hasEnded() {
        return internalHasEnded();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public int getTotalRecordedEvents() {
        return totalRecordedEvents();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public int getTotalRecordedLinks() {
        return delegate().getTotalRecordedLinks();
    }

    @Override // io.opentelemetry.sdk.trace.data.SpanData
    public int getTotalAttributeCount() {
        return totalAttributeCount();
    }

    public final String toString() {
        return "SpanData{spanContext=" + getSpanContext() + ", parentSpanContext=" + getParentSpanContext() + ", resource=" + getResource() + ", instrumentationScopeInfo=" + getInstrumentationScopeInfo() + ", name=" + getName() + ", kind=" + getKind() + ", startEpochNanos=" + getStartEpochNanos() + ", endEpochNanos=" + getEndEpochNanos() + ", attributes=" + getAttributes() + ", totalAttributeCount=" + getTotalAttributeCount() + ", events=" + getEvents() + ", totalRecordedEvents=" + getTotalRecordedEvents() + ", links=" + getLinks() + ", totalRecordedLinks=" + getTotalRecordedLinks() + ", status=" + getStatus() + ", hasEnded=" + hasEnded() + "}";
    }
}
