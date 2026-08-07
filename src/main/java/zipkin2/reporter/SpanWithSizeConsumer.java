package zipkin2.reporter;

/* JADX INFO: compiled from: ByteBoundedQueue.java */
/* JADX INFO: loaded from: classes6.dex */
interface SpanWithSizeConsumer<S> {
    boolean offer(S s, int i);
}
