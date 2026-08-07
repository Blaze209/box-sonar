package io.opentelemetry.sdk.trace.internal.data;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.trace.SpanLimits;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_ImmutableExceptionEventData extends C$AutoValue_ImmutableExceptionEventData {
    private volatile transient Attributes getAttributes;

    AutoValue_ImmutableExceptionEventData(final long j, final Throwable th, final Attributes attributes, final SpanLimits spanLimits) {
        new ImmutableExceptionEventData(j, th, attributes, spanLimits) { // from class: io.opentelemetry.sdk.trace.internal.data.$AutoValue_ImmutableExceptionEventData
            private final Attributes additionalAttributes;
            private final long epochNanos;
            private final Throwable exception;
            private final SpanLimits spanLimits;

            {
                this.epochNanos = j;
                if (th == null) {
                    throw new NullPointerException("Null exception");
                }
                this.exception = th;
                if (attributes == null) {
                    throw new NullPointerException("Null additionalAttributes");
                }
                this.additionalAttributes = attributes;
                if (spanLimits == null) {
                    throw new NullPointerException("Null spanLimits");
                }
                this.spanLimits = spanLimits;
            }

            @Override // io.opentelemetry.sdk.trace.data.EventData
            public long getEpochNanos() {
                return this.epochNanos;
            }

            @Override // io.opentelemetry.sdk.trace.internal.data.ExceptionEventData
            public Throwable getException() {
                return this.exception;
            }

            @Override // io.opentelemetry.sdk.trace.internal.data.ExceptionEventData
            public Attributes getAdditionalAttributes() {
                return this.additionalAttributes;
            }

            @Override // io.opentelemetry.sdk.trace.internal.data.ImmutableExceptionEventData
            protected SpanLimits getSpanLimits() {
                return this.spanLimits;
            }

            public String toString() {
                return "ImmutableExceptionEventData{epochNanos=" + this.epochNanos + ", exception=" + this.exception + ", additionalAttributes=" + this.additionalAttributes + ", spanLimits=" + this.spanLimits + "}";
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof ImmutableExceptionEventData) {
                    ImmutableExceptionEventData immutableExceptionEventData = (ImmutableExceptionEventData) obj;
                    if (this.epochNanos == immutableExceptionEventData.getEpochNanos() && this.exception.equals(immutableExceptionEventData.getException()) && this.additionalAttributes.equals(immutableExceptionEventData.getAdditionalAttributes()) && this.spanLimits.equals(immutableExceptionEventData.getSpanLimits())) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                long j2 = this.epochNanos;
                return this.spanLimits.hashCode() ^ ((((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ this.exception.hashCode()) * 1000003) ^ this.additionalAttributes.hashCode()) * 1000003);
            }
        };
    }

    @Override // io.opentelemetry.sdk.trace.internal.data.ImmutableExceptionEventData, io.opentelemetry.sdk.trace.data.EventData
    public Attributes getAttributes() {
        if (this.getAttributes == null) {
            synchronized (this) {
                if (this.getAttributes == null) {
                    this.getAttributes = super.getAttributes();
                    if (this.getAttributes == null) {
                        throw new NullPointerException("getAttributes() cannot return null");
                    }
                }
            }
        }
        return this.getAttributes;
    }
}
