package zipkin2.storage;

import java.io.IOException;
import zipkin2.CheckResult;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ForwardingStorageComponent extends StorageComponent {
    protected abstract StorageComponent delegate();

    protected ForwardingStorageComponent() {
    }

    @Override // zipkin2.storage.StorageComponent
    public SpanConsumer spanConsumer() {
        return delegate().spanConsumer();
    }

    @Override // zipkin2.storage.StorageComponent
    public Traces traces() {
        return delegate().traces();
    }

    @Override // zipkin2.storage.StorageComponent
    public SpanStore spanStore() {
        return delegate().spanStore();
    }

    @Override // zipkin2.storage.StorageComponent
    public AutocompleteTags autocompleteTags() {
        return delegate().autocompleteTags();
    }

    @Override // zipkin2.storage.StorageComponent
    public ServiceAndSpanNames serviceAndSpanNames() {
        return delegate().serviceAndSpanNames();
    }

    @Override // zipkin2.Component
    public CheckResult check() {
        return delegate().check();
    }

    @Override // zipkin2.storage.StorageComponent
    public boolean isOverCapacity(Throwable th) {
        return delegate().isOverCapacity(th);
    }

    @Override // zipkin2.Component, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        delegate().close();
    }

    public String toString() {
        return delegate().toString();
    }
}
