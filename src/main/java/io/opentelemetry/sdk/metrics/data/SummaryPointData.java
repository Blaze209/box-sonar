package io.opentelemetry.sdk.metrics.data;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface SummaryPointData extends PointData {
    long getCount();

    double getSum();

    List<ValueAtQuantile> getValues();
}
