package com.microsoft.identity.common.java.opentelemetry;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.StatusCode;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes14.dex */
public class NoopSpan implements Span {
    private final SpanContext spanContext;

    @Override // io.opentelemetry.api.trace.Span
    public Span addEvent(String str) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public Span addEvent(String str, long j, TimeUnit timeUnit) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public Span addEvent(String str, Attributes attributes) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public Span addEvent(String str, Attributes attributes, long j, TimeUnit timeUnit) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public void end() {
    }

    @Override // io.opentelemetry.api.trace.Span
    public void end(long j, TimeUnit timeUnit) {
    }

    @Override // io.opentelemetry.api.trace.Span
    public boolean isRecording() {
        return false;
    }

    @Override // io.opentelemetry.api.trace.Span
    public Span recordException(Throwable th) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public Span recordException(Throwable th, Attributes attributes) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public Span setAllAttributes(Attributes attributes) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public <T> Span setAttribute(AttributeKey<T> attributeKey, T t) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public Span setAttribute(String str, double d) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public Span setAttribute(String str, long j) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public Span setAttribute(String str, String str2) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public Span setAttribute(String str, boolean z) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public Span setStatus(StatusCode statusCode) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public Span setStatus(StatusCode statusCode, String str) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.Span
    public Span updateName(String str) {
        return this;
    }

    public NoopSpan(SpanContext spanContext) {
        this.spanContext = spanContext;
    }

    @Override // io.opentelemetry.api.trace.Span
    public SpanContext getSpanContext() {
        return this.spanContext;
    }

    public String toString() {
        return "NoopSpan{" + this.spanContext + AbstractJsonLexerKt.END_OBJ;
    }
}
