package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;

/* JADX INFO: loaded from: classes4.dex */
public final class DebugUtils {
    private DebugUtils() {
    }

    public static String duplicateMetricErrorMessage(MetricDescriptor metricDescriptor, MetricDescriptor metricDescriptor2) {
        StringBuilder sb = new StringBuilder("Found duplicate metric definition: ");
        sb.append(metricDescriptor.getName()).append("\n");
        if (!metricDescriptor2.getName().equals(metricDescriptor2.getSourceInstrument().getName())) {
            sb.append("\tVIEW defined\n").append(metricDescriptor2.getViewSourceInfo().multiLineDebugString()).append("\tFROM instrument ").append(metricDescriptor2.getSourceInstrument().getName()).append("\n").append(metricDescriptor2.getSourceInstrument().getSourceInfo().multiLineDebugString());
        } else {
            sb.append(metricDescriptor2.getSourceInstrument().getSourceInfo().multiLineDebugString()).append("\n");
        }
        sb.append("Causes\n");
        if (!metricDescriptor.getName().equals(metricDescriptor2.getName())) {
            sb.append("- Name [").append(metricDescriptor2.getName()).append("] does not match [").append(metricDescriptor.getName()).append("]\n");
        }
        if (!metricDescriptor.getDescription().equals(metricDescriptor2.getDescription())) {
            sb.append("- Description [").append(metricDescriptor2.getDescription()).append("] does not match [").append(metricDescriptor.getDescription()).append("]\n");
        }
        if (!metricDescriptor.getAggregationName().equals(metricDescriptor2.getAggregationName())) {
            sb.append("- Aggregation [").append(metricDescriptor2.getAggregationName()).append("] does not match [").append(metricDescriptor.getAggregationName()).append("]\n");
        }
        if (!metricDescriptor.getSourceInstrument().getName().equals(metricDescriptor2.getSourceInstrument().getName())) {
            sb.append("- InstrumentName [").append(metricDescriptor2.getSourceInstrument().getName()).append("] does not match [").append(metricDescriptor.getSourceInstrument().getName()).append("]\n");
        }
        if (!metricDescriptor.getSourceInstrument().getDescription().equals(metricDescriptor2.getSourceInstrument().getDescription())) {
            sb.append("- InstrumentDescription [").append(metricDescriptor2.getSourceInstrument().getDescription()).append("] does not match [").append(metricDescriptor.getSourceInstrument().getDescription()).append("]\n");
        }
        if (!metricDescriptor.getSourceInstrument().getUnit().equals(metricDescriptor2.getSourceInstrument().getUnit())) {
            sb.append("- InstrumentUnit [").append(metricDescriptor2.getSourceInstrument().getUnit()).append("] does not match [").append(metricDescriptor.getSourceInstrument().getUnit()).append("]\n");
        }
        if (!metricDescriptor.getSourceInstrument().getType().equals(metricDescriptor2.getSourceInstrument().getType())) {
            sb.append("- InstrumentType [").append(metricDescriptor2.getSourceInstrument().getType()).append("] does not match [").append(metricDescriptor.getSourceInstrument().getType()).append("]\n");
        }
        if (!metricDescriptor.getSourceInstrument().getValueType().equals(metricDescriptor2.getSourceInstrument().getValueType())) {
            sb.append("- InstrumentValueType [").append(metricDescriptor2.getSourceInstrument().getValueType()).append("] does not match [").append(metricDescriptor.getSourceInstrument().getValueType()).append("]\n");
        }
        if (metricDescriptor.getName().equals(metricDescriptor.getSourceInstrument().getName())) {
            sb.append("Original instrument registered with same name but is incompatible.\n").append(metricDescriptor.getSourceInstrument().getSourceInfo().multiLineDebugString()).append("\n");
        } else {
            sb.append("Conflicting view registered.\n").append(metricDescriptor.getViewSourceInfo().multiLineDebugString()).append("FROM instrument ").append(metricDescriptor.getSourceInstrument().getName()).append("\n").append(metricDescriptor.getSourceInstrument().getSourceInfo().multiLineDebugString()).append("\n");
        }
        return sb.toString();
    }
}
