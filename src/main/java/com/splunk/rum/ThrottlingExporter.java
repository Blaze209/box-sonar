package com.splunk.rum;

import android.util.Log;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import java.time.Duration;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
class ThrottlingExporter implements SpanExporter {
    private final Function<SpanData, String> categoryFunction;
    private final Map<String, Window> categoryToWindow;
    private final SpanExporter delegate;
    private final int maxSpansInWindow;
    private final long windowSizeInNanos;

    private ThrottlingExporter(Builder builder) {
        this.categoryToWindow = new HashMap();
        this.delegate = builder.delegate;
        this.categoryFunction = builder.categoryFunction;
        this.windowSizeInNanos = builder.windowSize.toNanos();
        this.maxSpansInWindow = builder.maxSpansInWindow;
    }

    static Builder newBuilder(SpanExporter spanExporter) {
        return new Builder(spanExporter);
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode export(Collection<SpanData> collection) {
        ArrayList arrayList = new ArrayList();
        for (SpanData spanData : collection) {
            if (!this.categoryToWindow.computeIfAbsent(this.categoryFunction.apply(spanData), new Function() { // from class: com.splunk.rum.ThrottlingExporter$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f$0.m14346lambda$export$0$comsplunkrumThrottlingExporter((String) obj);
                }
            }).aboveLimit(spanData)) {
                arrayList.add(spanData);
            }
        }
        int size = collection.size() - arrayList.size();
        if (size > 0) {
            Log.d("SplunkRum", "Dropped " + size + " spans because of throttling");
        }
        return this.delegate.export(arrayList);
    }

    /* JADX INFO: renamed from: lambda$export$0$com-splunk-rum-ThrottlingExporter, reason: not valid java name */
    /* synthetic */ Window m14346lambda$export$0$comsplunkrumThrottlingExporter(String str) {
        return new Window();
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode flush() {
        return this.delegate.flush();
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode shutdown() {
        return this.delegate.shutdown();
    }

    class Window {
        private final Deque<Long> timestamps = new ArrayDeque();

        Window() {
        }

        boolean aboveLimit(SpanData spanData) {
            long endEpochNanos = spanData.getEndEpochNanos();
            this.timestamps.addLast(Long.valueOf(endEpochNanos));
            while (true) {
                Long lPeekFirst = this.timestamps.peekFirst();
                if (lPeekFirst == null || endEpochNanos - lPeekFirst.longValue() < ThrottlingExporter.this.windowSizeInNanos) {
                    break;
                }
                this.timestamps.removeFirst();
            }
            boolean z = this.timestamps.size() > ThrottlingExporter.this.maxSpansInWindow;
            if (z) {
                this.timestamps.removeLast();
            }
            return z;
        }
    }

    static class Builder {
        Function<SpanData, String> categoryFunction;
        final SpanExporter delegate;
        int maxSpansInWindow;
        Duration windowSize;

        static /* synthetic */ String lambda$new$0(SpanData spanData) {
            return "default";
        }

        private Builder(SpanExporter spanExporter) {
            this.categoryFunction = new Function() { // from class: com.splunk.rum.ThrottlingExporter$Builder$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ThrottlingExporter.Builder.lambda$new$0((SpanData) obj);
                }
            };
            this.windowSize = Duration.ofSeconds(30L);
            this.maxSpansInWindow = 100;
            this.delegate = spanExporter;
        }

        static /* synthetic */ String lambda$categorizeByAttribute$1(AttributeKey attributeKey, SpanData spanData) {
            return (String) spanData.getAttributes().get(attributeKey);
        }

        Builder categorizeByAttribute(final AttributeKey<String> attributeKey) {
            this.categoryFunction = new Function() { // from class: com.splunk.rum.ThrottlingExporter$Builder$$ExternalSyntheticLambda1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ThrottlingExporter.Builder.lambda$categorizeByAttribute$1(attributeKey, (SpanData) obj);
                }
            };
            return this;
        }

        Builder windowSize(Duration duration) {
            this.windowSize = duration;
            return this;
        }

        Builder maxSpansInWindow(int i) {
            this.maxSpansInWindow = i;
            return this;
        }

        ThrottlingExporter build() {
            return new ThrottlingExporter(this);
        }
    }
}
