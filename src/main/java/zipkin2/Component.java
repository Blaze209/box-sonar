package zipkin2;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public abstract class Component implements Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    public CheckResult check() {
        return CheckResult.OK;
    }
}
