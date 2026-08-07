package com.microsoft.identity.common.java.opentelemetry;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.microsoft.identity.common.java.logging.Logger;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import sdk.pendo.io.models.SessionDataKt;

/* JADX INFO: compiled from: DefaultBenchmarkSpanPrinter.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ,2\u00020\u0001:\u0002,-B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0007H\u0002J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0002J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J$\u0010\u001e\u001a\u00020\u00032\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010 \u001a\u00020\bH\u0002J\u001e\u0010!\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00072\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u000eH\u0016J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0003H\u0002J\u0006\u0010'\u001a\u00020\u001aJ\u001e\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0002J\u0016\u0010+\u001a\u00020\u001a2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0002R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/microsoft/identity/common/java/opentelemetry/DefaultBenchmarkSpanPrinter;", "Lcom/microsoft/identity/common/java/opentelemetry/IBenchmarkSpanPrinter;", "outputDirectoryAbsolutePath", "", "batchSize", "", "metricsToDisplay", "", "Lcom/microsoft/identity/common/java/opentelemetry/MetricType;", "(Ljava/lang/String;ILjava/util/List;)V", "batchCounterByName", "", "batchedSpansByName", "", "Lcom/microsoft/identity/common/java/opentelemetry/IBenchmarkSpan;", "singleThreadExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "calculateMetrics", "", "", "values", "calculateStatistics", "Lcom/microsoft/identity/common/java/opentelemetry/DefaultBenchmarkSpanPrinter$StatisticalStatusData;", "spans", "flushRemainingSpans", "", "getFile", "Ljava/io/File;", "spanName", "getMetricValue", "metricsMap", "metricType", "percentile", "", "printAsync", "span", "sanitizeFileName", "name", "shutdown", "writeSlowestExceptions", "writer", "Ljava/io/FileWriter;", "writeSpansToFile", "Companion", "StatisticalStatusData", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultBenchmarkSpanPrinter implements IBenchmarkSpanPrinter {
    private final Map<String, Integer> batchCounterByName;
    private final int batchSize;
    private final Map<String, List<IBenchmarkSpan>> batchedSpansByName;
    private final List<MetricType> metricsToDisplay;
    private final String outputDirectoryAbsolutePath;
    private final ExecutorService singleThreadExecutor;
    private static final String TAG = "DefaultBenchmarkSpanPrinter";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);

    /* JADX INFO: compiled from: DefaultBenchmarkSpanPrinter.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MetricType.values().length];
            try {
                iArr[MetricType.AVERAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MetricType.P50.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MetricType.P75.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MetricType.P90.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MetricType.P95.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MetricType.P99.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void shutdown$lambda$23() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultBenchmarkSpanPrinter(String outputDirectoryAbsolutePath, int i, List<? extends MetricType> metricsToDisplay) {
        Intrinsics.checkNotNullParameter(outputDirectoryAbsolutePath, "outputDirectoryAbsolutePath");
        Intrinsics.checkNotNullParameter(metricsToDisplay, "metricsToDisplay");
        this.outputDirectoryAbsolutePath = outputDirectoryAbsolutePath;
        this.batchSize = i;
        this.metricsToDisplay = metricsToDisplay;
        this.singleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.microsoft.identity.common.java.opentelemetry.DefaultBenchmarkSpanPrinter$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return DefaultBenchmarkSpanPrinter.singleThreadExecutor$lambda$1(runnable);
            }
        });
        this.batchedSpansByName = new LinkedHashMap();
        this.batchCounterByName = new LinkedHashMap();
    }

    public /* synthetic */ DefaultBenchmarkSpanPrinter(String str, int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 1 : i, (i2 & 4) != 0 ? CollectionsKt.listOf((Object[]) new MetricType[]{MetricType.AVERAGE, MetricType.P50, MetricType.P75, MetricType.P90}) : list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread singleThreadExecutor$lambda$1(Runnable runnable) {
        Thread thread = new Thread(runnable, "BenchmarkSpanPrinter");
        thread.setDaemon(true);
        return thread;
    }

    @Override // com.microsoft.identity.common.java.opentelemetry.IBenchmarkSpanPrinter
    public void printAsync(final IBenchmarkSpan span) {
        Intrinsics.checkNotNullParameter(span, "span");
        this.singleThreadExecutor.submit(new Runnable() { // from class: com.microsoft.identity.common.java.opentelemetry.DefaultBenchmarkSpanPrinter$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                DefaultBenchmarkSpanPrinter.printAsync$lambda$3(span, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void printAsync$lambda$3(IBenchmarkSpan span, DefaultBenchmarkSpanPrinter this$0) {
        Intrinsics.checkNotNullParameter(span, "$span");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            String spanName = span.getSpanName();
            Map<String, List<IBenchmarkSpan>> map = this$0.batchedSpansByName;
            ArrayList arrayList = map.get(spanName);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(spanName, arrayList);
            }
            List<IBenchmarkSpan> list = arrayList;
            list.add(span);
            int iIntValue = this$0.batchCounterByName.getOrDefault(spanName, 0).intValue() + 1;
            this$0.batchCounterByName.put(spanName, Integer.valueOf(iIntValue));
            if (iIntValue >= this$0.batchSize) {
                this$0.writeSpansToFile(CollectionsKt.toList(list));
                list.clear();
                this$0.batchCounterByName.put(spanName, 0);
            }
        } catch (Exception e) {
            Logger.error(TAG, "Failed to write span status to file", e);
        }
    }

    private final void writeSpansToFile(List<? extends IBenchmarkSpan> spans) {
        Throwable th;
        String str;
        FileWriter fileWriter;
        String str2 = "|--------------------------------------------------|--------|---------------------|------------------|";
        if (spans.isEmpty()) {
            return;
        }
        try {
            FileWriter fileWriter2 = new FileWriter(getFile(((IBenchmarkSpan) CollectionsKt.first((List) spans)).getSpanName()), true);
            try {
                FileWriter fileWriter3 = fileWriter2;
                List<StatisticalStatusData> listCalculateStatistics = calculateStatistics(spans);
                if (listCalculateStatistics.isEmpty()) {
                    Appendable appendableAppend = fileWriter3.append((CharSequence) ("| " + DATE_FORMAT.format(new Date()) + " | N/A | No status entries recorded (batch size: " + spans.size() + ')'));
                    Intrinsics.checkNotNullExpressionValue(appendableAppend, "append(value)");
                    Intrinsics.checkNotNullExpressionValue(appendableAppend.append('\n'), "append('\\n')");
                    fileWriter = fileWriter2;
                } else {
                    String str3 = DATE_FORMAT.format(new Date(System.currentTimeMillis()));
                    ArrayList arrayList = new ArrayList();
                    for (IBenchmarkSpan iBenchmarkSpan : spans) {
                        long startTimeInNanoSeconds = iBenchmarkSpan.getStartTimeInNanoSeconds();
                        long endTimeInNanoSeconds = iBenchmarkSpan.getEndTimeInNanoSeconds();
                        Long lValueOf = endTimeInNanoSeconds > 0 ? Long.valueOf(TimeUnit.NANOSECONDS.toMillis(endTimeInNanoSeconds - startTimeInNanoSeconds)) : null;
                        if (lValueOf != null) {
                            arrayList.add(lValueOf);
                        }
                        listCalculateStatistics = listCalculateStatistics;
                    }
                    List<StatisticalStatusData> list = listCalculateStatistics;
                    ArrayList arrayList2 = arrayList;
                    if (!arrayList2.isEmpty()) {
                        str = ((long) CollectionsKt.averageOfLong(arrayList2)) + "ms";
                    } else {
                        str = "N/A";
                    }
                    List<? extends IBenchmarkSpan> list2 = spans;
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList3.add(Integer.valueOf(((IBenchmarkSpan) it.next()).getConcurrentSize()));
                    }
                    double dAverageOfInt = CollectionsKt.averageOfInt(arrayList3);
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String str4 = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(dAverageOfInt)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str4, "format(locale, format, *args)");
                    Appendable appendableAppend2 = fileWriter3.append((CharSequence) "");
                    Intrinsics.checkNotNullExpressionValue(appendableAppend2, "append(value)");
                    Intrinsics.checkNotNullExpressionValue(appendableAppend2.append('\n'), "append('\\n')");
                    Appendable appendableAppend3 = fileWriter3.append((CharSequence) ("=== Statistical Benchmark Session: " + str3 + " | Avg Total Duration: " + str + " | Avg Concurrent Size: " + str4 + " | Batch Size: " + spans.size() + " ==="));
                    Intrinsics.checkNotNullExpressionValue(appendableAppend3, "append(value)");
                    Intrinsics.checkNotNullExpressionValue(appendableAppend3.append('\n'), "append('\\n')");
                    Appendable appendableAppend4 = fileWriter3.append((CharSequence) "");
                    Intrinsics.checkNotNullExpressionValue(appendableAppend4, "append(value)");
                    Intrinsics.checkNotNullExpressionValue(appendableAppend4.append('\n'), "append('\\n')");
                    Appendable appendableAppend5 = fileWriter3.append((CharSequence) "| Status Entry                                     | Metric | Time Since Previous | Time Since Start |");
                    Intrinsics.checkNotNullExpressionValue(appendableAppend5, "append(value)");
                    Intrinsics.checkNotNullExpressionValue(appendableAppend5.append('\n'), "append('\\n')");
                    Appendable appendableAppend6 = fileWriter3.append((CharSequence) "|--------------------------------------------------|--------|---------------------|------------------|");
                    Intrinsics.checkNotNullExpressionValue(appendableAppend6, "append(value)");
                    Intrinsics.checkNotNullExpressionValue(appendableAppend6.append('\n'), "append('\\n')");
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        try {
                            StatisticalStatusData statisticalStatusData = (StatisticalStatusData) it2.next();
                            String str5 = str2;
                            String strPadEnd$default = StringsKt.padEnd$default(StringsKt.take(statisticalStatusData.getStatusName(), 48), 48, (char) 0, 2, (Object) null);
                            Iterator it3 = this.metricsToDisplay.iterator();
                            while (it3.hasNext()) {
                                MetricType metricType = (MetricType) it3.next();
                                Iterator it4 = it3;
                                Iterator it5 = it2;
                                StatisticalStatusData statisticalStatusData2 = statisticalStatusData;
                                String str6 = strPadEnd$default;
                                fileWriter = fileWriter2;
                                try {
                                    Appendable appendableAppend7 = fileWriter3.append((CharSequence) ("| " + (metricType == CollectionsKt.first((List) this.metricsToDisplay) ? str6 : StringsKt.padEnd$default("", 48, (char) 0, 2, (Object) null)) + " | " + StringsKt.padEnd$default(metricType.getDisplayName(), 6, (char) 0, 2, (Object) null) + " | " + StringsKt.padEnd$default(getMetricValue(statisticalStatusData2.getTimeSincePreviousStats(), metricType), 19, (char) 0, 2, (Object) null) + " | " + StringsKt.padEnd$default(getMetricValue(statisticalStatusData2.getTimeSinceStartStats(), metricType), 16, (char) 0, 2, (Object) null) + " |"));
                                    Intrinsics.checkNotNullExpressionValue(appendableAppend7, "append(value)");
                                    Intrinsics.checkNotNullExpressionValue(appendableAppend7.append('\n'), "append('\\n')");
                                    statisticalStatusData = statisticalStatusData2;
                                    it3 = it4;
                                    it2 = it5;
                                    strPadEnd$default = str6;
                                    fileWriter2 = fileWriter;
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileWriter2 = fileWriter;
                                    try {
                                        throw th;
                                    } catch (Throwable th3) {
                                        CloseableKt.closeFinally(fileWriter2, th);
                                        throw th3;
                                    }
                                }
                            }
                            FileWriter fileWriter4 = fileWriter2;
                            Iterator it6 = it2;
                            Appendable appendableAppend8 = fileWriter3.append((CharSequence) str5);
                            Intrinsics.checkNotNullExpressionValue(appendableAppend8, "append(value)");
                            Intrinsics.checkNotNullExpressionValue(appendableAppend8.append('\n'), "append('\\n')");
                            str2 = str5;
                            it2 = it6;
                            fileWriter2 = fileWriter4;
                        } catch (Throwable th4) {
                            th = th4;
                            th = th;
                            throw th;
                        }
                    }
                    fileWriter = fileWriter2;
                    try {
                        Appendable appendableAppend9 = fileWriter3.append((CharSequence) "");
                        Intrinsics.checkNotNullExpressionValue(appendableAppend9, "append(value)");
                        Intrinsics.checkNotNullExpressionValue(appendableAppend9.append('\n'), "append('\\n')");
                        List<StatisticalStatusData> list3 = list;
                        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                            Iterator<T> it7 = list3.iterator();
                            while (it7.hasNext()) {
                                if (Intrinsics.areEqual(((StatisticalStatusData) it7.next()).getStatusName(), "recordException")) {
                                    writeSlowestExceptions(fileWriter3, spans);
                                    break;
                                }
                            }
                        }
                        fileWriter3.flush();
                    } catch (Throwable th5) {
                        th = th5;
                        fileWriter2 = fileWriter;
                        th = th;
                        throw th;
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileWriter, null);
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e) {
            Logger.error(TAG, "IOException while writing averaged batch to file: " + this.outputDirectoryAbsolutePath, e);
        }
    }

    private final File getFile(String spanName) {
        File file = new File(this.outputDirectoryAbsolutePath);
        file.mkdirs();
        return new File(file, sanitizeFileName(spanName) + "_benchmark.log");
    }

    private final String sanitizeFileName(String name) {
        String strTrim = StringsKt.trim(new Regex("_+").replace(new Regex("[^a-zA-Z0-9_-]").replace(name, "_"), "_"), SessionDataKt.UNDERSCORE);
        if (strTrim.length() <= 0) {
            strTrim = null;
        }
        return strTrim == null ? "span" : strTrim;
    }

    /* JADX INFO: compiled from: DefaultBenchmarkSpanPrinter.kt */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0003\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J,\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"com/microsoft/identity/common/java/opentelemetry/DefaultBenchmarkSpanPrinter$writeSlowestExceptions$ExceptionTiming", "", "spanIndex", "", "timeSinceStartMs", "", "exception", "", "(IJLjava/lang/Throwable;)V", "getException", "()Ljava/lang/Throwable;", "getSpanIndex", "()I", "getTimeSinceStartMs", "()J", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(IJLjava/lang/Throwable;)Lcom/microsoft/identity/common/java/opentelemetry/DefaultBenchmarkSpanPrinter$writeSlowestExceptions$ExceptionTiming;", "equals", "", "other", "hashCode", "toString", "", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class ExceptionTiming {
        private final Throwable exception;
        private final int spanIndex;
        private final long timeSinceStartMs;

        public static /* synthetic */ ExceptionTiming copy$default(ExceptionTiming exceptionTiming, int i, long j, Throwable th, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = exceptionTiming.spanIndex;
            }
            if ((i2 & 2) != 0) {
                j = exceptionTiming.timeSinceStartMs;
            }
            if ((i2 & 4) != 0) {
                th = exceptionTiming.exception;
            }
            return exceptionTiming.copy(i, j, th);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getSpanIndex() {
            return this.spanIndex;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getTimeSinceStartMs() {
            return this.timeSinceStartMs;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Throwable getException() {
            return this.exception;
        }

        public final ExceptionTiming copy(int spanIndex, long timeSinceStartMs, Throwable exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            return new ExceptionTiming(spanIndex, timeSinceStartMs, exception);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ExceptionTiming)) {
                return false;
            }
            ExceptionTiming exceptionTiming = (ExceptionTiming) other;
            return this.spanIndex == exceptionTiming.spanIndex && this.timeSinceStartMs == exceptionTiming.timeSinceStartMs && Intrinsics.areEqual(this.exception, exceptionTiming.exception);
        }

        public int hashCode() {
            return (((Integer.hashCode(this.spanIndex) * 31) + Long.hashCode(this.timeSinceStartMs)) * 31) + this.exception.hashCode();
        }

        public String toString() {
            return "ExceptionTiming(spanIndex=" + this.spanIndex + ", timeSinceStartMs=" + this.timeSinceStartMs + ", exception=" + this.exception + ')';
        }

        public ExceptionTiming(int i, long j, Throwable exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            this.spanIndex = i;
            this.timeSinceStartMs = j;
            this.exception = exception;
        }

        public final Throwable getException() {
            return this.exception;
        }

        public final int getSpanIndex() {
            return this.spanIndex;
        }

        public final long getTimeSinceStartMs() {
            return this.timeSinceStartMs;
        }
    }

    private final void writeSlowestExceptions(FileWriter writer, List<? extends IBenchmarkSpan> spans) throws IOException {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = spans.iterator();
        int i = 0;
        while (true) {
            Object obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            IBenchmarkSpan iBenchmarkSpan = (IBenchmarkSpan) next;
            Throwable exception = iBenchmarkSpan.getException();
            if (exception != null) {
                List<Pair<String, Long>> statuses = iBenchmarkSpan.getStatuses();
                long startTimeInNanoSeconds = iBenchmarkSpan.getStartTimeInNanoSeconds();
                for (Object obj2 : statuses) {
                    if (Intrinsics.areEqual(((Pair) obj2).getFirst(), "recordException")) {
                        obj = obj2;
                        break;
                    }
                }
                Pair pair = (Pair) obj;
                if (pair != null) {
                    arrayList.add(new ExceptionTiming(i2, TimeUnit.NANOSECONDS.toMillis(((Number) pair.getSecond()).longValue() - startTimeInNanoSeconds), exception));
                }
            }
            i = i2;
        }
        if (arrayList.isEmpty()) {
            return;
        }
        List listTake = CollectionsKt.take(CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.microsoft.identity.common.java.opentelemetry.DefaultBenchmarkSpanPrinter$writeSlowestExceptions$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(((DefaultBenchmarkSpanPrinter.ExceptionTiming) t2).getTimeSinceStartMs()), Long.valueOf(((DefaultBenchmarkSpanPrinter.ExceptionTiming) t).getTimeSinceStartMs()));
            }
        }), 5);
        FileWriter fileWriter = writer;
        Appendable appendableAppend = fileWriter.append((CharSequence) "=== 5 Slowest Exceptions (Time Since Start) ===");
        Intrinsics.checkNotNullExpressionValue(appendableAppend, "append(value)");
        Intrinsics.checkNotNullExpressionValue(appendableAppend.append('\n'), "append('\\n')");
        Appendable appendableAppend2 = fileWriter.append((CharSequence) "");
        Intrinsics.checkNotNullExpressionValue(appendableAppend2, "append(value)");
        Intrinsics.checkNotNullExpressionValue(appendableAppend2.append('\n'), "append('\\n')");
        Appendable appendableAppend3 = fileWriter.append((CharSequence) "| Rank | Span # | Time Since Start | Exception Type                           | Message                                  ");
        Intrinsics.checkNotNullExpressionValue(appendableAppend3, "append(value)");
        Intrinsics.checkNotNullExpressionValue(appendableAppend3.append('\n'), "append('\\n')");
        Appendable appendableAppend4 = fileWriter.append((CharSequence) "|------|--------|------------------|------------------------------------------|------------------------------------------");
        Intrinsics.checkNotNullExpressionValue(appendableAppend4, "append(value)");
        Intrinsics.checkNotNullExpressionValue(appendableAppend4.append('\n'), "append('\\n')");
        int i3 = 0;
        for (Object obj3 : listTake) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ExceptionTiming exceptionTiming = (ExceptionTiming) obj3;
            String strPadEnd$default = StringsKt.padEnd$default(String.valueOf(i4), 4, (char) 0, 2, (Object) null);
            String strPadEnd$default2 = StringsKt.padEnd$default(String.valueOf(exceptionTiming.getSpanIndex()), 6, (char) 0, 2, (Object) null);
            String strPadEnd$default3 = StringsKt.padEnd$default(exceptionTiming.getTimeSinceStartMs() + "ms", 16, (char) 0, 2, (Object) null);
            String simpleName = exceptionTiming.getException().getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "exceptionData.exception.javaClass.simpleName");
            String strPadEnd$default4 = StringsKt.padEnd$default(StringsKt.take(simpleName, 40), 40, (char) 0, 2, (Object) null);
            String message = exceptionTiming.getException().getMessage();
            if (message == null) {
                message = "N/A";
            }
            Appendable appendableAppend5 = fileWriter.append((CharSequence) ("| " + strPadEnd$default + " | " + strPadEnd$default2 + " | " + strPadEnd$default3 + " | " + strPadEnd$default4 + " | " + message + ' '));
            Intrinsics.checkNotNullExpressionValue(appendableAppend5, "append(value)");
            Intrinsics.checkNotNullExpressionValue(appendableAppend5.append('\n'), "append('\\n')");
            i3 = i4;
        }
        Appendable appendableAppend6 = fileWriter.append((CharSequence) "");
        Intrinsics.checkNotNullExpressionValue(appendableAppend6, "append(value)");
        Intrinsics.checkNotNullExpressionValue(appendableAppend6.append('\n'), "append('\\n')");
    }

    private final List<StatisticalStatusData> calculateStatistics(List<? extends IBenchmarkSpan> spans) {
        if (spans.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
        Iterator<? extends IBenchmarkSpan> it = spans.iterator();
        while (it.hasNext()) {
            Iterator<Pair<String, Long>> it2 = it.next().getStatuses().iterator();
            while (it2.hasNext()) {
                linkedHashSet.add(it2.next().component1());
            }
        }
        ArrayList arrayList = new ArrayList();
        for (String str : linkedHashSet) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (IBenchmarkSpan iBenchmarkSpan : spans) {
                List<Pair<String, Long>> statuses = iBenchmarkSpan.getStatuses();
                long startTimeInNanoSeconds = iBenchmarkSpan.getStartTimeInNanoSeconds();
                Iterator<Pair<String, Long>> it3 = statuses.iterator();
                int i = 0;
                while (true) {
                    if (!it3.hasNext()) {
                        i = -1;
                        break;
                    }
                    if (Intrinsics.areEqual(it3.next().getFirst(), str)) {
                        break;
                    }
                    i++;
                }
                if (i >= 0) {
                    Pair<String, Long> pair = statuses.get(i);
                    long millis = TimeUnit.NANOSECONDS.toMillis(pair.getSecond().longValue() - startTimeInNanoSeconds);
                    if (i > 0) {
                        startTimeInNanoSeconds = statuses.get(i - 1).getSecond().longValue();
                    }
                    arrayList2.add(Long.valueOf(TimeUnit.NANOSECONDS.toMillis(pair.getSecond().longValue() - startTimeInNanoSeconds)));
                    arrayList3.add(Long.valueOf(millis));
                }
            }
            if (!arrayList2.isEmpty()) {
                arrayList.add(new StatisticalStatusData(str, calculateMetrics(arrayList3), calculateMetrics(arrayList2)));
            }
        }
        if (!this.metricsToDisplay.isEmpty()) {
            return CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.microsoft.identity.common.java.opentelemetry.DefaultBenchmarkSpanPrinter$calculateStatistics$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Long l = ((DefaultBenchmarkSpanPrinter.StatisticalStatusData) t).getTimeSinceStartStats().get(CollectionsKt.first(this.this$0.metricsToDisplay));
                    Long lValueOf = Long.valueOf(l != null ? l.longValue() : 0L);
                    Long l2 = ((DefaultBenchmarkSpanPrinter.StatisticalStatusData) t2).getTimeSinceStartStats().get(CollectionsKt.first(this.this$0.metricsToDisplay));
                    return ComparisonsKt.compareValues(lValueOf, Long.valueOf(l2 != null ? l2.longValue() : 0L));
                }
            });
        }
        return CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.microsoft.identity.common.java.opentelemetry.DefaultBenchmarkSpanPrinter$calculateStatistics$$inlined$sortedBy$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((DefaultBenchmarkSpanPrinter.StatisticalStatusData) t).getStatusName(), ((DefaultBenchmarkSpanPrinter.StatisticalStatusData) t2).getStatusName());
            }
        });
    }

    private final Map<MetricType, Long> calculateMetrics(List<Long> values) {
        long jAverageOfLong;
        if (values.isEmpty()) {
            return MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (MetricType metricType : this.metricsToDisplay) {
            switch (WhenMappings.$EnumSwitchMapping$0[metricType.ordinal()]) {
                case 1:
                    jAverageOfLong = (long) CollectionsKt.averageOfLong(values);
                    break;
                case 2:
                    jAverageOfLong = percentile(values, 50.0d);
                    break;
                case 3:
                    jAverageOfLong = percentile(values, 75.0d);
                    break;
                case 4:
                    jAverageOfLong = percentile(values, 90.0d);
                    break;
                case 5:
                    jAverageOfLong = percentile(values, 95.0d);
                    break;
                case 6:
                    jAverageOfLong = percentile(values, 99.0d);
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            linkedHashMap.put(metricType, Long.valueOf(jAverageOfLong));
        }
        return linkedHashMap;
    }

    private final long percentile(List<Long> values, double percentile) {
        if (values.isEmpty()) {
            return 0L;
        }
        if (values.size() == 1) {
            return values.get(0).longValue();
        }
        List listSorted = CollectionsKt.sorted(values);
        double size = (percentile / 100.0d) * ((double) (listSorted.size() - 1));
        int iFloor = (int) Math.floor(size);
        int iCeil = (int) Math.ceil(size);
        if (iFloor == iCeil) {
            return ((Number) listSorted.get(iFloor)).longValue();
        }
        double d = size - ((double) iFloor);
        return (long) ((((Number) listSorted.get(iFloor)).doubleValue() * (((double) 1) - d)) + (((Number) listSorted.get(iCeil)).doubleValue() * d));
    }

    private final String getMetricValue(Map<MetricType, Long> metricsMap, MetricType metricType) {
        Long l = metricsMap.get(metricType);
        return (l != null ? l.longValue() : 0L) + "ms";
    }

    /* JADX INFO: compiled from: DefaultBenchmarkSpanPrinter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003J\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003J?\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/microsoft/identity/common/java/opentelemetry/DefaultBenchmarkSpanPrinter$StatisticalStatusData;", "", "statusName", "", "timeSinceStartStats", "", "Lcom/microsoft/identity/common/java/opentelemetry/MetricType;", "", "timeSincePreviousStats", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getStatusName", "()Ljava/lang/String;", "getTimeSincePreviousStats", "()Ljava/util/Map;", "getTimeSinceStartStats", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class StatisticalStatusData {
        private final String statusName;
        private final Map<MetricType, Long> timeSincePreviousStats;
        private final Map<MetricType, Long> timeSinceStartStats;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StatisticalStatusData copy$default(StatisticalStatusData statisticalStatusData, String str, Map map, Map map2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = statisticalStatusData.statusName;
            }
            if ((i & 2) != 0) {
                map = statisticalStatusData.timeSinceStartStats;
            }
            if ((i & 4) != 0) {
                map2 = statisticalStatusData.timeSincePreviousStats;
            }
            return statisticalStatusData.copy(str, map, map2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getStatusName() {
            return this.statusName;
        }

        public final Map<MetricType, Long> component2() {
            return this.timeSinceStartStats;
        }

        public final Map<MetricType, Long> component3() {
            return this.timeSincePreviousStats;
        }

        public final StatisticalStatusData copy(String statusName, Map<MetricType, Long> timeSinceStartStats, Map<MetricType, Long> timeSincePreviousStats) {
            Intrinsics.checkNotNullParameter(statusName, "statusName");
            Intrinsics.checkNotNullParameter(timeSinceStartStats, "timeSinceStartStats");
            Intrinsics.checkNotNullParameter(timeSincePreviousStats, "timeSincePreviousStats");
            return new StatisticalStatusData(statusName, timeSinceStartStats, timeSincePreviousStats);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StatisticalStatusData)) {
                return false;
            }
            StatisticalStatusData statisticalStatusData = (StatisticalStatusData) other;
            return Intrinsics.areEqual(this.statusName, statisticalStatusData.statusName) && Intrinsics.areEqual(this.timeSinceStartStats, statisticalStatusData.timeSinceStartStats) && Intrinsics.areEqual(this.timeSincePreviousStats, statisticalStatusData.timeSincePreviousStats);
        }

        public int hashCode() {
            return (((this.statusName.hashCode() * 31) + this.timeSinceStartStats.hashCode()) * 31) + this.timeSincePreviousStats.hashCode();
        }

        public String toString() {
            return "StatisticalStatusData(statusName=" + this.statusName + ", timeSinceStartStats=" + this.timeSinceStartStats + ", timeSincePreviousStats=" + this.timeSincePreviousStats + ')';
        }

        public StatisticalStatusData(String statusName, Map<MetricType, Long> timeSinceStartStats, Map<MetricType, Long> timeSincePreviousStats) {
            Intrinsics.checkNotNullParameter(statusName, "statusName");
            Intrinsics.checkNotNullParameter(timeSinceStartStats, "timeSinceStartStats");
            Intrinsics.checkNotNullParameter(timeSincePreviousStats, "timeSincePreviousStats");
            this.statusName = statusName;
            this.timeSinceStartStats = timeSinceStartStats;
            this.timeSincePreviousStats = timeSincePreviousStats;
        }

        public final String getStatusName() {
            return this.statusName;
        }

        public final Map<MetricType, Long> getTimeSinceStartStats() {
            return this.timeSinceStartStats;
        }

        public final Map<MetricType, Long> getTimeSincePreviousStats() {
            return this.timeSincePreviousStats;
        }
    }

    public final void flushRemainingSpans() {
        this.singleThreadExecutor.submit(new Runnable() { // from class: com.microsoft.identity.common.java.opentelemetry.DefaultBenchmarkSpanPrinter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DefaultBenchmarkSpanPrinter.flushRemainingSpans$lambda$22(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void flushRemainingSpans$lambda$22(DefaultBenchmarkSpanPrinter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        synchronized (this$0.batchedSpansByName) {
            for (Map.Entry<String, List<IBenchmarkSpan>> entry : this$0.batchedSpansByName.entrySet()) {
                String key = entry.getKey();
                List<IBenchmarkSpan> value = entry.getValue();
                if (!value.isEmpty()) {
                    this$0.writeSpansToFile(CollectionsKt.toList(value));
                    value.clear();
                    this$0.batchCounterByName.put(key, 0);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void shutdown() {
        flushRemainingSpans();
        this.singleThreadExecutor.submit(new Runnable() { // from class: com.microsoft.identity.common.java.opentelemetry.DefaultBenchmarkSpanPrinter$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DefaultBenchmarkSpanPrinter.shutdown$lambda$23();
            }
        });
        this.singleThreadExecutor.shutdown();
    }
}
