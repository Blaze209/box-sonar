package com.box.android.data.observability;

import com.box.android.domain.models.observability.ApdexScore;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.opentelemetry.sdk.trace.ReadableSpan;
import io.opentelemetry.sdk.trace.data.EventData;
import io.opentelemetry.sdk.trace.data.StatusData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OpenTelemetryInstrumentation.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"toApdexMetric", "Lcom/box/android/data/observability/ApdexMetric;", "Lio/opentelemetry/sdk/trace/ReadableSpan;", FirebaseAnalytics.Param.SCORE, "Lcom/box/android/domain/models/observability/ApdexScore;", "toMillis", "", "data_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class OpenTelemetryInstrumentationKt {
    public static final ApdexMetric toApdexMetric(ReadableSpan readableSpan, ApdexScore apdexScore) {
        Intrinsics.checkNotNullParameter(readableSpan, "<this>");
        List<EventData> events = readableSpan.toSpanData().getEvents();
        Intrinsics.checkNotNullExpressionValue(events, "getEvents(...)");
        List<EventData> list = events;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (EventData eventData : list) {
            String name = eventData.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            arrayList.add(new ApdexMetricMilestone(name, toMillis(eventData.getEpochNanos())));
        }
        ArrayList arrayList2 = arrayList;
        String name2 = readableSpan.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        return new ApdexMetric(name2, toMillis(readableSpan.toSpanData().getStartEpochNanos()), toMillis(readableSpan.toSpanData().getEndEpochNanos()), arrayList2, apdexScore, Intrinsics.areEqual(readableSpan.toSpanData().getStatus(), StatusData.error()) ? readableSpan.toSpanData().getStatus().getDescription() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long toMillis(long j) {
        return j / ((long) 1000000);
    }
}
