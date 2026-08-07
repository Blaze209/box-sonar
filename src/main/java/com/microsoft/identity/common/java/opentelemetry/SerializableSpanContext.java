package com.microsoft.identity.common.java.opentelemetry;

import com.google.gson.annotations.SerializedName;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.TraceFlags;
import io.opentelemetry.api.trace.TraceState;
import java.io.Serializable;

/* JADX INFO: loaded from: classes14.dex */
public class SerializableSpanContext implements SpanContext, Serializable {
    public static final String SERIALIZABLE_SPAN_CONTEXT = "serializable_span_context";

    @SerializedName("span_id")
    private final String mSpanId;

    @SerializedName("trace_flags")
    private final byte mTraceFlags;

    @SerializedName("trace_id")
    private final String mTraceId;

    public static class SerializedNames {
        public static final String PARENT_SPAN_NAME = "parent_span_name";
        public static final String SPAN_ID = "span_id";
        public static final String TRACE_FLAGS = "trace_flags";
        public static final String TRACE_ID = "trace_id";
    }

    @Override // io.opentelemetry.api.trace.SpanContext
    public boolean isRemote() {
        return false;
    }

    public static class SerializableSpanContextBuilder {
        private String spanId;
        private byte traceFlags;
        private String traceId;

        SerializableSpanContextBuilder() {
        }

        public SerializableSpanContext build() {
            return new SerializableSpanContext(this.traceId, this.spanId, this.traceFlags);
        }

        public SerializableSpanContextBuilder spanId(String str) {
            if (str == null) {
                throw new NullPointerException("spanId is marked non-null but is null");
            }
            this.spanId = str;
            return this;
        }

        public String toString() {
            return "SerializableSpanContext.SerializableSpanContextBuilder(traceId=" + this.traceId + ", spanId=" + this.spanId + ", traceFlags=" + ((int) this.traceFlags) + ")";
        }

        public SerializableSpanContextBuilder traceFlags(byte b) {
            this.traceFlags = b;
            return this;
        }

        public SerializableSpanContextBuilder traceId(String str) {
            if (str == null) {
                throw new NullPointerException("traceId is marked non-null but is null");
            }
            this.traceId = str;
            return this;
        }
    }

    SerializableSpanContext(String str, String str2, byte b) {
        if (str == null) {
            throw new NullPointerException("traceId is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("spanId is marked non-null but is null");
        }
        this.mTraceId = str;
        this.mSpanId = str2;
        this.mTraceFlags = b;
    }

    public static SerializableSpanContextBuilder builder() {
        return new SerializableSpanContextBuilder();
    }

    @Override // io.opentelemetry.api.trace.SpanContext
    public String getTraceId() {
        return this.mTraceId;
    }

    @Override // io.opentelemetry.api.trace.SpanContext
    public String getSpanId() {
        return this.mSpanId;
    }

    @Override // io.opentelemetry.api.trace.SpanContext
    public TraceFlags getTraceFlags() {
        return TraceFlags.fromByte(this.mTraceFlags);
    }

    @Override // io.opentelemetry.api.trace.SpanContext
    public TraceState getTraceState() {
        return TraceState.getDefault();
    }
}
