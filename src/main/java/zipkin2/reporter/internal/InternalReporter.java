package zipkin2.reporter.internal;

import zipkin2.reporter.AsyncReporter;

/* JADX INFO: loaded from: classes6.dex */
public abstract class InternalReporter {
    public static InternalReporter instance;

    public abstract AsyncReporter.Builder toBuilder(AsyncReporter<?> asyncReporter);
}
