package com.microsoft.identity.common.java.opentelemetry;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: compiled from: BenchmarkSpan.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0005H&J\u001a\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\r0\fH&¨\u0006\u000e"}, d2 = {"Lcom/microsoft/identity/common/java/opentelemetry/IBenchmarkSpan;", "", "getConcurrentSilentRequestSize", "", "getEndTimeInNanoSeconds", "", "getException", "", "getSpanName", "", "getStartTimeInNanoSeconds", "getStatuses", "", "Lkotlin/Pair;", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IBenchmarkSpan {
    int getConcurrentSilentRequestSize();

    long getEndTimeInNanoSeconds();

    Throwable getException();

    String getSpanName();

    long getStartTimeInNanoSeconds();

    List<Pair<String, Long>> getStatuses();
}
