package io.opentelemetry.sdk.metrics.internal.descriptor;

import io.opentelemetry.sdk.metrics.View;

/* JADX INFO: renamed from: io.opentelemetry.sdk.metrics.internal.descriptor.$AutoValue_MetricDescriptor, reason: invalid class name */
/* JADX INFO: loaded from: classes4.dex */
abstract class C$AutoValue_MetricDescriptor extends MetricDescriptor {
    private final String description;
    private final String name;
    private final InstrumentDescriptor sourceInstrument;
    private final View view;

    C$AutoValue_MetricDescriptor(String str, String str2, View view, InstrumentDescriptor instrumentDescriptor) {
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        this.name = str;
        if (str2 == null) {
            throw new NullPointerException("Null description");
        }
        this.description = str2;
        if (view == null) {
            throw new NullPointerException("Null view");
        }
        this.view = view;
        if (instrumentDescriptor == null) {
            throw new NullPointerException("Null sourceInstrument");
        }
        this.sourceInstrument = instrumentDescriptor;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor
    public String getName() {
        return this.name;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor
    public String getDescription() {
        return this.description;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor
    public View getView() {
        return this.view;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor
    public InstrumentDescriptor getSourceInstrument() {
        return this.sourceInstrument;
    }

    public String toString() {
        return "MetricDescriptor{name=" + this.name + ", description=" + this.description + ", view=" + this.view + ", sourceInstrument=" + this.sourceInstrument + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MetricDescriptor) {
            MetricDescriptor metricDescriptor = (MetricDescriptor) obj;
            if (this.name.equals(metricDescriptor.getName()) && this.description.equals(metricDescriptor.getDescription()) && this.view.equals(metricDescriptor.getView()) && this.sourceInstrument.equals(metricDescriptor.getSourceInstrument())) {
                return true;
            }
        }
        return false;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor
    public int hashCode() {
        return this.sourceInstrument.hashCode() ^ ((((((this.name.hashCode() ^ 1000003) * 1000003) ^ this.description.hashCode()) * 1000003) ^ this.view.hashCode()) * 1000003);
    }
}
