package io.opencensus.trace.propagation;

/* JADX INFO: loaded from: classes4.dex */
public final class SpanContextParseException extends Exception {
    private static final long serialVersionUID = 0;

    public SpanContextParseException(String str) {
        super(str);
    }

    public SpanContextParseException(String str, Throwable th) {
        super(str, th);
    }
}
