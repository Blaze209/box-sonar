package io.opentelemetry.sdk.trace;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.Clock;
import io.opentelemetry.sdk.common.InstrumentationLibraryInfo;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.internal.AttributeUtil;
import io.opentelemetry.sdk.internal.AttributesMap;
import io.opentelemetry.sdk.internal.InstrumentationScopeUtil;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.data.EventData;
import io.opentelemetry.sdk.trace.data.LinkData;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.data.StatusData;
import io.opentelemetry.sdk.trace.internal.data.ExceptionEventData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class SdkSpan implements ReadWriteSpan {
    private static final Logger logger = Logger.getLogger(SdkSpan.class.getName());

    @Nullable
    private AttributesMap attributes;
    private final AnchoredClock clock;
    private final SpanContext context;
    private long endEpochNanos;
    private final InstrumentationScopeInfo instrumentationScopeInfo;
    private final SpanKind kind;
    private final List<LinkData> links;
    private String name;
    private final SpanContext parentSpanContext;
    private final Resource resource;
    private final SpanLimits spanLimits;
    private final SpanProcessor spanProcessor;
    private final long startEpochNanos;
    private final int totalRecordedLinks;
    private final Object lock = new Object();
    private int totalRecordedEvents = 0;
    private StatusData status = StatusData.unset();
    private boolean hasEnded = false;
    private final List<EventData> events = new ArrayList();

    @Override // io.opentelemetry.api.trace.Span
    public /* bridge */ /* synthetic */ Span setAttribute(AttributeKey attributeKey, Object obj) {
        return setAttribute((AttributeKey<Object>) attributeKey, obj);
    }

    private SdkSpan(SpanContext spanContext, String str, InstrumentationScopeInfo instrumentationScopeInfo, SpanKind spanKind, SpanContext spanContext2, SpanLimits spanLimits, SpanProcessor spanProcessor, AnchoredClock anchoredClock, Resource resource, @Nullable AttributesMap attributesMap, List<LinkData> list, int i, long j) {
        this.context = spanContext;
        this.instrumentationScopeInfo = instrumentationScopeInfo;
        this.parentSpanContext = spanContext2;
        this.links = list;
        this.totalRecordedLinks = i;
        this.name = str;
        this.kind = spanKind;
        this.spanProcessor = spanProcessor;
        this.resource = resource;
        this.clock = anchoredClock;
        this.startEpochNanos = j;
        this.attributes = attributesMap;
        this.spanLimits = spanLimits;
    }

    static SdkSpan startSpan(SpanContext spanContext, String str, InstrumentationScopeInfo instrumentationScopeInfo, SpanKind spanKind, Span span, Context context, SpanLimits spanLimits, SpanProcessor spanProcessor, Clock clock, Resource resource, @Nullable AttributesMap attributesMap, List<LinkData> list, int i, long j) {
        AnchoredClock anchoredClockCreate;
        boolean z;
        long jNow;
        long j2;
        if (span instanceof SdkSpan) {
            anchoredClockCreate = ((SdkSpan) span).clock;
            z = false;
        } else {
            anchoredClockCreate = AnchoredClock.create(clock);
            z = true;
        }
        AnchoredClock anchoredClock = anchoredClockCreate;
        if (j != 0) {
            j2 = j;
        } else {
            if (z) {
                jNow = anchoredClock.startTime();
            } else {
                jNow = anchoredClock.now();
            }
            j2 = jNow;
        }
        SdkSpan sdkSpan = new SdkSpan(spanContext, str, instrumentationScopeInfo, spanKind, span.getSpanContext(), spanLimits, spanProcessor, anchoredClock, resource, attributesMap, list, i, j2);
        spanProcessor.onStart(context, sdkSpan);
        return sdkSpan;
    }

    @Override // io.opentelemetry.sdk.trace.ReadableSpan
    public SpanData toSpanData() {
        SpanWrapper spanWrapperCreate;
        synchronized (this.lock) {
            List<LinkData> list = this.links;
            List<EventData> immutableTimedEvents = getImmutableTimedEvents();
            Attributes immutableAttributes = getImmutableAttributes();
            AttributesMap attributesMap = this.attributes;
            spanWrapperCreate = SpanWrapper.create(this, list, immutableTimedEvents, immutableAttributes, attributesMap == null ? 0 : attributesMap.getTotalAddedValues(), this.totalRecordedEvents, this.status, this.name, this.endEpochNanos, this.hasEnded);
        }
        return spanWrapperCreate;
    }

    @Override // io.opentelemetry.sdk.trace.ReadableSpan
    @Nullable
    public <T> T getAttribute(AttributeKey<T> attributeKey) {
        T t;
        synchronized (this.lock) {
            AttributesMap attributesMap = this.attributes;
            t = attributesMap == null ? null : (T) attributesMap.get((AttributeKey) attributeKey);
        }
        return t;
    }

    @Override // io.opentelemetry.sdk.trace.ReadableSpan
    public boolean hasEnded() {
        boolean z;
        synchronized (this.lock) {
            z = this.hasEnded;
        }
        return z;
    }

    @Override // io.opentelemetry.api.trace.Span
    public SpanContext getSpanContext() {
        return this.context;
    }

    @Override // io.opentelemetry.sdk.trace.ReadableSpan
    public SpanContext getParentSpanContext() {
        return this.parentSpanContext;
    }

    @Override // io.opentelemetry.sdk.trace.ReadableSpan
    public String getName() {
        String str;
        synchronized (this.lock) {
            str = this.name;
        }
        return str;
    }

    @Override // io.opentelemetry.sdk.trace.ReadableSpan
    @Deprecated
    public InstrumentationLibraryInfo getInstrumentationLibraryInfo() {
        return InstrumentationScopeUtil.toInstrumentationLibraryInfo(getInstrumentationScopeInfo());
    }

    @Override // io.opentelemetry.sdk.trace.ReadableSpan
    public InstrumentationScopeInfo getInstrumentationScopeInfo() {
        return this.instrumentationScopeInfo;
    }

    @Override // io.opentelemetry.sdk.trace.ReadableSpan
    public long getLatencyNanos() {
        long jNow;
        synchronized (this.lock) {
            jNow = (this.hasEnded ? this.endEpochNanos : this.clock.now()) - this.startEpochNanos;
        }
        return jNow;
    }

    AnchoredClock getClock() {
        return this.clock;
    }

    @Override // io.opentelemetry.api.trace.Span
    public <T> ReadWriteSpan setAttribute(AttributeKey<T> attributeKey, T t) {
        if (attributeKey == null || attributeKey.getKey().isEmpty() || t == null) {
            return this;
        }
        synchronized (this.lock) {
            if (this.hasEnded) {
                logger.log(Level.FINE, "Calling setAttribute() on an ended Span.");
                return this;
            }
            if (this.attributes == null) {
                this.attributes = AttributesMap.create(this.spanLimits.getMaxNumberOfAttributes(), this.spanLimits.getMaxAttributeValueLength());
            }
            this.attributes.put((AttributeKey) attributeKey, (Object) t);
            return this;
        }
    }

    @Override // io.opentelemetry.api.trace.Span
    public ReadWriteSpan addEvent(String str) {
        if (str == null) {
            return this;
        }
        addTimedEvent(EventData.create(this.clock.now(), str, Attributes.empty(), 0));
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public ReadWriteSpan addEvent(String str, long j, TimeUnit timeUnit) {
        if (str != null && timeUnit != null) {
            addTimedEvent(EventData.create(timeUnit.toNanos(j), str, Attributes.empty(), 0));
        }
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public ReadWriteSpan addEvent(String str, Attributes attributes) {
        if (str == null) {
            return this;
        }
        if (attributes == null) {
            attributes = Attributes.empty();
        }
        addTimedEvent(EventData.create(this.clock.now(), str, AttributeUtil.applyAttributesLimit(attributes, this.spanLimits.getMaxNumberOfAttributesPerEvent(), this.spanLimits.getMaxAttributeValueLength()), attributes.size()));
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public ReadWriteSpan addEvent(String str, Attributes attributes, long j, TimeUnit timeUnit) {
        if (str != null && timeUnit != null) {
            if (attributes == null) {
                attributes = Attributes.empty();
            }
            addTimedEvent(EventData.create(timeUnit.toNanos(j), str, AttributeUtil.applyAttributesLimit(attributes, this.spanLimits.getMaxNumberOfAttributesPerEvent(), this.spanLimits.getMaxAttributeValueLength()), attributes.size()));
        }
        return this;
    }

    private void addTimedEvent(EventData eventData) {
        synchronized (this.lock) {
            if (this.hasEnded) {
                logger.log(Level.FINE, "Calling addEvent() on an ended Span.");
                return;
            }
            if (this.events.size() < this.spanLimits.getMaxNumberOfEvents()) {
                this.events.add(eventData);
            }
            this.totalRecordedEvents++;
        }
    }

    @Override // io.opentelemetry.api.trace.Span
    public ReadWriteSpan setStatus(StatusCode statusCode, @Nullable String str) {
        if (statusCode == null) {
            return this;
        }
        synchronized (this.lock) {
            if (this.hasEnded) {
                logger.log(Level.FINE, "Calling setStatus() on an ended Span.");
                return this;
            }
            this.status = StatusData.create(statusCode, str);
            return this;
        }
    }

    @Override // io.opentelemetry.api.trace.Span
    public ReadWriteSpan recordException(Throwable th) {
        recordException(th, Attributes.empty());
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public ReadWriteSpan recordException(Throwable th, Attributes attributes) {
        if (th == null) {
            return this;
        }
        if (attributes == null) {
            attributes = Attributes.empty();
        }
        addTimedEvent(ExceptionEventData.create(this.spanLimits, this.clock.now(), th, attributes));
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public ReadWriteSpan updateName(String str) {
        if (str == null) {
            return this;
        }
        synchronized (this.lock) {
            if (this.hasEnded) {
                logger.log(Level.FINE, "Calling updateName() on an ended Span.");
                return this;
            }
            this.name = str;
            return this;
        }
    }

    @Override // io.opentelemetry.api.trace.Span
    public void end() {
        endInternal(this.clock.now());
    }

    @Override // io.opentelemetry.api.trace.Span
    public void end(long j, TimeUnit timeUnit) {
        if (timeUnit == null) {
            timeUnit = TimeUnit.NANOSECONDS;
        }
        endInternal(j == 0 ? this.clock.now() : timeUnit.toNanos(j));
    }

    private void endInternal(long j) {
        synchronized (this.lock) {
            if (this.hasEnded) {
                logger.log(Level.FINE, "Calling end() on an ended Span.");
                return;
            }
            this.endEpochNanos = j;
            this.hasEnded = true;
            this.spanProcessor.onEnd(this);
        }
    }

    @Override // io.opentelemetry.api.trace.Span
    public boolean isRecording() {
        boolean z;
        synchronized (this.lock) {
            z = !this.hasEnded;
        }
        return z;
    }

    Resource getResource() {
        return this.resource;
    }

    @Override // io.opentelemetry.sdk.trace.ReadableSpan
    public SpanKind getKind() {
        return this.kind;
    }

    long getStartEpochNanos() {
        return this.startEpochNanos;
    }

    int getTotalRecordedLinks() {
        return this.totalRecordedLinks;
    }

    private List<EventData> getImmutableTimedEvents() {
        if (this.events.isEmpty()) {
            return Collections.emptyList();
        }
        if (this.hasEnded) {
            return Collections.unmodifiableList(this.events);
        }
        return Collections.unmodifiableList(new ArrayList(this.events));
    }

    private Attributes getImmutableAttributes() {
        AttributesMap attributesMap = this.attributes;
        if (attributesMap == null || attributesMap.isEmpty()) {
            return Attributes.empty();
        }
        if (this.hasEnded) {
            return this.attributes;
        }
        return this.attributes.immutableCopy();
    }

    public String toString() {
        String str;
        String strValueOf;
        String strValueOf2;
        long j;
        long j2;
        synchronized (this.lock) {
            str = this.name;
            strValueOf = String.valueOf(this.attributes);
            strValueOf2 = String.valueOf(this.status);
            j = this.totalRecordedEvents;
            j2 = this.endEpochNanos;
        }
        return "SdkSpan{traceId=" + this.context.getTraceId() + ", spanId=" + this.context.getSpanId() + ", parentSpanContext=" + this.parentSpanContext + ", name=" + str + ", kind=" + this.kind + ", attributes=" + strValueOf + ", status=" + strValueOf2 + ", totalRecordedEvents=" + j + ", totalRecordedLinks=" + this.totalRecordedLinks + ", startEpochNanos=" + this.startEpochNanos + ", endEpochNanos=" + j2 + "}";
    }
}
