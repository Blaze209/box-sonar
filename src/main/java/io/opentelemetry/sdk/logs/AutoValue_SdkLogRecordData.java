package io.opentelemetry.sdk.logs;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.logs.Severity;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.logs.data.Body;
import io.opentelemetry.sdk.resources.Resource;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_SdkLogRecordData extends SdkLogRecordData {
    private final Attributes attributes;
    private final Body body;
    private final long epochNanos;
    private final InstrumentationScopeInfo instrumentationScopeInfo;
    private final Resource resource;
    private final Severity severity;
    private final String severityText;
    private final SpanContext spanContext;
    private final int totalAttributeCount;

    AutoValue_SdkLogRecordData(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, long j, SpanContext spanContext, Severity severity, @Nullable String str, Body body, Attributes attributes, int i) {
        if (resource == null) {
            throw new NullPointerException("Null resource");
        }
        this.resource = resource;
        if (instrumentationScopeInfo == null) {
            throw new NullPointerException("Null instrumentationScopeInfo");
        }
        this.instrumentationScopeInfo = instrumentationScopeInfo;
        this.epochNanos = j;
        if (spanContext == null) {
            throw new NullPointerException("Null spanContext");
        }
        this.spanContext = spanContext;
        if (severity == null) {
            throw new NullPointerException("Null severity");
        }
        this.severity = severity;
        this.severityText = str;
        if (body == null) {
            throw new NullPointerException("Null body");
        }
        this.body = body;
        if (attributes == null) {
            throw new NullPointerException("Null attributes");
        }
        this.attributes = attributes;
        this.totalAttributeCount = i;
    }

    @Override // io.opentelemetry.sdk.logs.data.LogRecordData
    public Resource getResource() {
        return this.resource;
    }

    @Override // io.opentelemetry.sdk.logs.data.LogRecordData
    public InstrumentationScopeInfo getInstrumentationScopeInfo() {
        return this.instrumentationScopeInfo;
    }

    @Override // io.opentelemetry.sdk.logs.data.LogRecordData
    public long getEpochNanos() {
        return this.epochNanos;
    }

    @Override // io.opentelemetry.sdk.logs.data.LogRecordData
    public SpanContext getSpanContext() {
        return this.spanContext;
    }

    @Override // io.opentelemetry.sdk.logs.data.LogRecordData
    public Severity getSeverity() {
        return this.severity;
    }

    @Override // io.opentelemetry.sdk.logs.data.LogRecordData
    @Nullable
    public String getSeverityText() {
        return this.severityText;
    }

    @Override // io.opentelemetry.sdk.logs.data.LogRecordData
    public Body getBody() {
        return this.body;
    }

    @Override // io.opentelemetry.sdk.logs.data.LogRecordData
    public Attributes getAttributes() {
        return this.attributes;
    }

    @Override // io.opentelemetry.sdk.logs.data.LogRecordData
    public int getTotalAttributeCount() {
        return this.totalAttributeCount;
    }

    public String toString() {
        return "SdkLogRecordData{resource=" + this.resource + ", instrumentationScopeInfo=" + this.instrumentationScopeInfo + ", epochNanos=" + this.epochNanos + ", spanContext=" + this.spanContext + ", severity=" + this.severity + ", severityText=" + this.severityText + ", body=" + this.body + ", attributes=" + this.attributes + ", totalAttributeCount=" + this.totalAttributeCount + "}";
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof SdkLogRecordData) {
            SdkLogRecordData sdkLogRecordData = (SdkLogRecordData) obj;
            if (this.resource.equals(sdkLogRecordData.getResource()) && this.instrumentationScopeInfo.equals(sdkLogRecordData.getInstrumentationScopeInfo()) && this.epochNanos == sdkLogRecordData.getEpochNanos() && this.spanContext.equals(sdkLogRecordData.getSpanContext()) && this.severity.equals(sdkLogRecordData.getSeverity()) && ((str = this.severityText) != null ? str.equals(sdkLogRecordData.getSeverityText()) : sdkLogRecordData.getSeverityText() == null) && this.body.equals(sdkLogRecordData.getBody()) && this.attributes.equals(sdkLogRecordData.getAttributes()) && this.totalAttributeCount == sdkLogRecordData.getTotalAttributeCount()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((this.resource.hashCode() ^ 1000003) * 1000003) ^ this.instrumentationScopeInfo.hashCode()) * 1000003;
        long j = this.epochNanos;
        int iHashCode2 = (((((iHashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.spanContext.hashCode()) * 1000003) ^ this.severity.hashCode()) * 1000003;
        String str = this.severityText;
        return this.totalAttributeCount ^ ((((((iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.body.hashCode()) * 1000003) ^ this.attributes.hashCode()) * 1000003);
    }
}
