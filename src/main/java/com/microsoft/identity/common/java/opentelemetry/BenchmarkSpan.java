package com.microsoft.identity.common.java.opentelemetry;

import androidx.exifinterface.media.ExifInterface;
import com.microsoft.identity.common.java.controllers.CommandDispatcher;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.StatusCode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BenchmarkSpan.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J*\u0010\u001a\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020\nH\u0016J\b\u0010$\u001a\u00020\fH\u0016J\n\u0010%\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u0007H\u0016J\b\u0010)\u001a\u00020\fH\u0016J\u001a\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u00160*H\u0016J\b\u0010+\u001a\u00020,H\u0016J\u001a\u0010-\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u001dH\u0016J+\u0010/\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u001002\f\u00101\u001a\b\u0012\u0004\u0012\u0002H0022\u0006\u00103\u001a\u0002H0H\u0016¢\u0006\u0002\u00104J\u001a\u00105\u001a\u0004\u0018\u00010\u00012\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0007H\u0016J\u0006\u00109\u001a\u00020\"J\u0012\u0010:\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001b\u001a\u00020\u0007H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R9\u0010\u0014\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u00160\u0015j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u0016`\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006;"}, d2 = {"Lcom/microsoft/identity/common/java/opentelemetry/BenchmarkSpan;", "Lio/opentelemetry/api/trace/Span;", "Lcom/microsoft/identity/common/java/opentelemetry/IBenchmarkSpan;", "originalSpan", "printer", "Lcom/microsoft/identity/common/java/opentelemetry/IBenchmarkSpanPrinter;", "spanName", "", "(Lio/opentelemetry/api/trace/Span;Lcom/microsoft/identity/common/java/opentelemetry/IBenchmarkSpanPrinter;Ljava/lang/String;)V", "concurrentSize", "", "endTimeInNanoSeconds", "", "exception", "", "getOriginalSpan", "()Lio/opentelemetry/api/trace/Span;", "getPrinter", "()Lcom/microsoft/identity/common/java/opentelemetry/IBenchmarkSpanPrinter;", "startTimeInNanoSeconds", "statuses", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", "getStatuses", "()Ljava/util/ArrayList;", "addEvent", "name", NativeAuthConstants.GrantType.ATTRIBUTES, "Lio/opentelemetry/api/common/Attributes;", "timestamp", "unit", "Ljava/util/concurrent/TimeUnit;", "end", "", "getConcurrentSilentRequestSize", "getEndTimeInNanoSeconds", "getException", "getSpanContext", "Lio/opentelemetry/api/trace/SpanContext;", "getSpanName", "getStartTimeInNanoSeconds", "", "isRecording", "", "recordException", "additionalAttributes", "setAttribute", ExifInterface.GPS_DIRECTION_TRUE, "key", "Lio/opentelemetry/api/common/AttributeKey;", "value", "(Lio/opentelemetry/api/common/AttributeKey;Ljava/lang/Object;)Lio/opentelemetry/api/trace/Span;", "setStatus", "statusCode", "Lio/opentelemetry/api/trace/StatusCode;", "description", "start", "updateName", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BenchmarkSpan implements Span, IBenchmarkSpan {
    private int concurrentSize;
    private long endTimeInNanoSeconds;
    private Throwable exception;
    private final Span originalSpan;
    private final IBenchmarkSpanPrinter printer;
    private final String spanName;
    private long startTimeInNanoSeconds;
    private final ArrayList<Pair<String, Long>> statuses;

    public BenchmarkSpan(Span originalSpan, IBenchmarkSpanPrinter printer, String spanName) {
        Intrinsics.checkNotNullParameter(originalSpan, "originalSpan");
        Intrinsics.checkNotNullParameter(printer, "printer");
        Intrinsics.checkNotNullParameter(spanName, "spanName");
        this.originalSpan = originalSpan;
        this.printer = printer;
        this.spanName = spanName;
        this.statuses = new ArrayList<>();
        this.startTimeInNanoSeconds = System.nanoTime();
        this.concurrentSize = 1;
    }

    public final Span getOriginalSpan() {
        return this.originalSpan;
    }

    public final IBenchmarkSpanPrinter getPrinter() {
        return this.printer;
    }

    @Override // com.microsoft.identity.common.java.opentelemetry.IBenchmarkSpan
    public final ArrayList<Pair<String, Long>> getStatuses() {
        return this.statuses;
    }

    @Override // com.microsoft.identity.common.java.opentelemetry.IBenchmarkSpan
    public List<Pair<String, Long>> getStatuses() {
        return this.statuses;
    }

    @Override // com.microsoft.identity.common.java.opentelemetry.IBenchmarkSpan
    public String getSpanName() {
        return this.spanName;
    }

    @Override // com.microsoft.identity.common.java.opentelemetry.IBenchmarkSpan
    public long getStartTimeInNanoSeconds() {
        return this.startTimeInNanoSeconds;
    }

    @Override // com.microsoft.identity.common.java.opentelemetry.IBenchmarkSpan
    public long getEndTimeInNanoSeconds() {
        return this.endTimeInNanoSeconds;
    }

    @Override // com.microsoft.identity.common.java.opentelemetry.IBenchmarkSpan
    /* JADX INFO: renamed from: getConcurrentSilentRequestSize, reason: from getter */
    public int getConcurrentSize() {
        return this.concurrentSize;
    }

    @Override // com.microsoft.identity.common.java.opentelemetry.IBenchmarkSpan
    public Throwable getException() {
        return this.exception;
    }

    public final void start() {
        this.startTimeInNanoSeconds = System.nanoTime();
        this.concurrentSize = CommandDispatcher.getSilentRequestActiveCount();
    }

    @Override // io.opentelemetry.api.trace.Span
    public void end() {
        this.endTimeInNanoSeconds = System.nanoTime();
        this.printer.printAsync(this);
        this.originalSpan.end();
    }

    @Override // io.opentelemetry.api.trace.Span
    public void end(long timestamp, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.endTimeInNanoSeconds = System.nanoTime();
        this.printer.printAsync(this);
        this.originalSpan.end(timestamp, unit);
    }

    @Override // io.opentelemetry.api.trace.Span
    public <T> Span setAttribute(AttributeKey<T> key, T value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.statuses.add(new Pair<>(key.toString(), Long.valueOf(System.nanoTime())));
        return this.originalSpan.setAttribute(key, value);
    }

    @Override // io.opentelemetry.api.trace.Span
    public Span addEvent(String name, Attributes attributes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.statuses.add(new Pair<>(name, Long.valueOf(System.nanoTime())));
        return this.originalSpan.addEvent(name, attributes);
    }

    @Override // io.opentelemetry.api.trace.Span
    public Span addEvent(String name, Attributes attributes, long timestamp, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.statuses.add(new Pair<>(name, Long.valueOf(System.nanoTime())));
        return this.originalSpan.addEvent(name, attributes, timestamp, unit);
    }

    @Override // io.opentelemetry.api.trace.Span
    public Span setStatus(StatusCode statusCode, String description) {
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        Intrinsics.checkNotNullParameter(description, "description");
        this.statuses.add(new Pair<>("SetStatus:" + statusCode, Long.valueOf(System.nanoTime())));
        return this.originalSpan.setStatus(statusCode, description);
    }

    @Override // io.opentelemetry.api.trace.Span
    public Span recordException(Throwable exception, Attributes additionalAttributes) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(additionalAttributes, "additionalAttributes");
        this.statuses.add(new Pair<>("recordException", Long.valueOf(System.nanoTime())));
        this.exception = exception;
        return this.originalSpan.recordException(exception, additionalAttributes);
    }

    @Override // io.opentelemetry.api.trace.Span
    public Span updateName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.originalSpan.updateName(name);
    }

    @Override // io.opentelemetry.api.trace.Span
    public SpanContext getSpanContext() {
        return this.originalSpan.getSpanContext();
    }

    @Override // io.opentelemetry.api.trace.Span
    public boolean isRecording() {
        return this.originalSpan.isRecording();
    }
}
