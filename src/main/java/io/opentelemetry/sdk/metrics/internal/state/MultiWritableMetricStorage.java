package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.api.common.Attributes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class MultiWritableMetricStorage implements WriteableMetricStorage {
    private final List<? extends WriteableMetricStorage> underlyingMetrics;

    MultiWritableMetricStorage(List<? extends WriteableMetricStorage> list) {
        this.underlyingMetrics = list;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage
    public BoundStorageHandle bind(Attributes attributes) {
        ArrayList arrayList = new ArrayList(this.underlyingMetrics.size());
        Iterator<? extends WriteableMetricStorage> it = this.underlyingMetrics.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().bind(attributes));
        }
        return new MultiBoundStorageHandle(arrayList);
    }
}
