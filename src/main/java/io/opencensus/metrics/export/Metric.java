package io.opencensus.metrics.export;

import io.opencensus.internal.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Metric {
    public abstract MetricDescriptor getMetricDescriptor();

    public abstract List<TimeSeries> getTimeSeriesList();

    Metric() {
    }

    public static Metric create(MetricDescriptor metricDescriptor, List<TimeSeries> list) {
        Utils.checkListElementNotNull((List) Utils.checkNotNull(list, "timeSeriesList"), "timeSeries");
        return createInternal(metricDescriptor, Collections.unmodifiableList(new ArrayList(list)));
    }

    public static Metric createWithOneTimeSeries(MetricDescriptor metricDescriptor, TimeSeries timeSeries) {
        return createInternal(metricDescriptor, Collections.singletonList(Utils.checkNotNull(timeSeries, "timeSeries")));
    }

    private static Metric createInternal(MetricDescriptor metricDescriptor, List<TimeSeries> list) {
        Utils.checkNotNull(metricDescriptor, "metricDescriptor");
        checkTypeMatch(metricDescriptor.getType(), list);
        return new AutoValue_Metric(metricDescriptor, list);
    }

    private static void checkTypeMatch(MetricDescriptor.Type type, List<TimeSeries> list) {
        String simpleName;
        Iterator<TimeSeries> it = list.iterator();
        while (it.hasNext()) {
            Iterator<Point> it2 = it.next().getPoints().iterator();
            while (it2.hasNext()) {
                Value value = it2.next().getValue();
                if (value.getClass().getSuperclass() == null) {
                    simpleName = "";
                } else {
                    simpleName = value.getClass().getSuperclass().getSimpleName();
                }
                switch (AnonymousClass1.$SwitchMap$io$opencensus$metrics$export$MetricDescriptor$Type[type.ordinal()]) {
                    case 1:
                    case 2:
                        Utils.checkArgument(value instanceof Value.ValueLong, "Type mismatch: %s, %s.", type, simpleName);
                        break;
                    case 3:
                    case 4:
                        Utils.checkArgument(value instanceof Value.ValueDouble, "Type mismatch: %s, %s.", type, simpleName);
                        break;
                    case 5:
                    case 6:
                        Utils.checkArgument(value instanceof Value.ValueDistribution, "Type mismatch: %s, %s.", type, simpleName);
                        break;
                    case 7:
                        Utils.checkArgument(value instanceof Value.ValueSummary, "Type mismatch: %s, %s.", type, simpleName);
                        break;
                }
            }
        }
    }

    /* JADX INFO: renamed from: io.opencensus.metrics.export.Metric$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$opencensus$metrics$export$MetricDescriptor$Type;

        static {
            int[] iArr = new int[MetricDescriptor.Type.values().length];
            $SwitchMap$io$opencensus$metrics$export$MetricDescriptor$Type = iArr;
            try {
                iArr[MetricDescriptor.Type.GAUGE_INT64.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$opencensus$metrics$export$MetricDescriptor$Type[MetricDescriptor.Type.CUMULATIVE_INT64.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$opencensus$metrics$export$MetricDescriptor$Type[MetricDescriptor.Type.CUMULATIVE_DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$opencensus$metrics$export$MetricDescriptor$Type[MetricDescriptor.Type.GAUGE_DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$opencensus$metrics$export$MetricDescriptor$Type[MetricDescriptor.Type.GAUGE_DISTRIBUTION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$opencensus$metrics$export$MetricDescriptor$Type[MetricDescriptor.Type.CUMULATIVE_DISTRIBUTION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$opencensus$metrics$export$MetricDescriptor$Type[MetricDescriptor.Type.SUMMARY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }
}
