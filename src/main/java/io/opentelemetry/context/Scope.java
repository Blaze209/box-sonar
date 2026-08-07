package io.opentelemetry.context;

/* JADX INFO: loaded from: classes4.dex */
public interface Scope extends AutoCloseable {
    @Override // java.lang.AutoCloseable
    void close();

    static Scope noop() {
        return ThreadLocalContextStorage.NoopScope.INSTANCE;
    }
}
