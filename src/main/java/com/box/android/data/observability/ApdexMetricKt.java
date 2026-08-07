package com.box.android.data.observability;

import com.box.android.domain.models.observability.ApdexGen204Metric;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApdexMetric.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"toGen204Metrics", "", "Lcom/box/android/domain/models/observability/ApdexGen204Metric;", "Lcom/box/android/data/observability/ApdexMetric;", "data_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ApdexMetricKt {
    public static final List<ApdexGen204Metric> toGen204Metrics(ApdexMetric apdexMetric) {
        Intrinsics.checkNotNullParameter(apdexMetric, "<this>");
        long startEpochMillis = apdexMetric.getStartEpochMillis();
        long endEpochMillis = apdexMetric.getFailMessage() != null ? Long.MAX_VALUE : apdexMetric.getEndEpochMillis() - apdexMetric.getStartEpochMillis();
        ApdexGen204Metric[] apdexGen204MetricArr = new ApdexGen204Metric[1];
        apdexGen204MetricArr[0] = new ApdexGen204Metric(apdexMetric.getType(), null, endEpochMillis, null, null, null, apdexMetric.getFailMessage() != null, apdexMetric.getScore(), 58, null);
        List<ApdexGen204Metric> listMutableListOf = CollectionsKt.mutableListOf(apdexGen204MetricArr);
        List<ApdexMetricMilestone> milestones = apdexMetric.getMilestones();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(milestones, 10));
        for (ApdexMetricMilestone apdexMetricMilestone : milestones) {
            arrayList.add(new ApdexGen204Metric(apdexMetric.getType(), apdexMetricMilestone.getName(), apdexMetricMilestone.getEpochMillis() - startEpochMillis, null, null, null, apdexMetric.getFailMessage() != null, null, 184, null));
        }
        listMutableListOf.addAll(arrayList);
        return listMutableListOf;
    }
}
