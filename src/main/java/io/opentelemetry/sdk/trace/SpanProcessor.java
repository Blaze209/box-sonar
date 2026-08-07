package io.opentelemetry.sdk.trace;

import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.CompletableResultCode;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public interface SpanProcessor extends Closeable {
    boolean isEndRequired();

    boolean isStartRequired();

    void onEnd(ReadableSpan readableSpan);

    void onStart(Context context, ReadWriteSpan readWriteSpan);

    static SpanProcessor composite(SpanProcessor... spanProcessorArr) {
        return composite(Arrays.asList(spanProcessorArr));
    }

    static SpanProcessor composite(Iterable<SpanProcessor> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<SpanProcessor> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        if (arrayList.isEmpty()) {
            return NoopSpanProcessor.getInstance();
        }
        if (arrayList.size() == 1) {
            return (SpanProcessor) arrayList.get(0);
        }
        return MultiSpanProcessor.create(arrayList);
    }

    default CompletableResultCode shutdown() {
        return forceFlush();
    }

    default CompletableResultCode forceFlush() {
        return CompletableResultCode.ofSuccess();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    default void close() {
        shutdown().join(10L, TimeUnit.SECONDS);
    }
}
