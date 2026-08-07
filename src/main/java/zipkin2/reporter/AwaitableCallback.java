package zipkin2.reporter;

import java.util.concurrent.CountDownLatch;
import zipkin2.Callback;

/* JADX INFO: loaded from: classes6.dex */
public final class AwaitableCallback implements Callback<Void> {
    final CountDownLatch countDown = new CountDownLatch(1);
    Throwable throwable;

    public void await() {
        try {
            this.countDown.await();
            Throwable th = this.throwable;
            if (th == null) {
                return;
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            if (!(th instanceof RuntimeException)) {
                throw new RuntimeException(th);
            }
            throw ((RuntimeException) th);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // zipkin2.Callback
    public void onSuccess(Void r1) {
        this.countDown.countDown();
    }

    @Override // zipkin2.Callback
    public void onError(Throwable th) {
        this.throwable = th;
        this.countDown.countDown();
    }
}
