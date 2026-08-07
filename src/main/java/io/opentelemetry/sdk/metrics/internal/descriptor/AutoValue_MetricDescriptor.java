package io.opentelemetry.sdk.metrics.internal.descriptor;

import io.opentelemetry.sdk.metrics.View;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_MetricDescriptor extends C$AutoValue_MetricDescriptor {
    private volatile transient int hashCode;
    private volatile transient boolean hashCode$Memoized;

    AutoValue_MetricDescriptor(String str, String str2, View view, InstrumentDescriptor instrumentDescriptor) {
        super(str, str2, view, instrumentDescriptor);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.descriptor.C$AutoValue_MetricDescriptor, io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor
    public int hashCode() {
        if (!this.hashCode$Memoized) {
            synchronized (this) {
                if (!this.hashCode$Memoized) {
                    this.hashCode = super.hashCode();
                    this.hashCode$Memoized = true;
                }
            }
        }
        return this.hashCode;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.descriptor.C$AutoValue_MetricDescriptor
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AutoValue_MetricDescriptor) && hashCode() == obj.hashCode() && super.equals(obj);
    }
}
