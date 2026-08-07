package io.opentelemetry.sdk.trace.data;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.sdk.common.InstrumentationLibraryInfo;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.internal.InstrumentationScopeUtil;
import io.opentelemetry.sdk.resources.Resource;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface SpanData {
    Attributes getAttributes();

    long getEndEpochNanos();

    List<EventData> getEvents();

    @Deprecated
    InstrumentationLibraryInfo getInstrumentationLibraryInfo();

    SpanKind getKind();

    List<LinkData> getLinks();

    String getName();

    SpanContext getParentSpanContext();

    Resource getResource();

    SpanContext getSpanContext();

    long getStartEpochNanos();

    StatusData getStatus();

    int getTotalAttributeCount();

    int getTotalRecordedEvents();

    int getTotalRecordedLinks();

    boolean hasEnded();

    default String getTraceId() {
        return getSpanContext().getTraceId();
    }

    default String getSpanId() {
        return getSpanContext().getSpanId();
    }

    default String getParentSpanId() {
        return getParentSpanContext().getSpanId();
    }

    default InstrumentationScopeInfo getInstrumentationScopeInfo() {
        return InstrumentationScopeUtil.toInstrumentationScopeInfo(getInstrumentationLibraryInfo());
    }
}
