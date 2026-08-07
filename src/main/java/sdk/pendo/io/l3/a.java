package sdk.pendo.io.l3;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;
import sdk.pendo.io.o3.b;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a implements b {
    private final AtomicBoolean a = new AtomicBoolean();

    /* JADX INFO: renamed from: sdk.pendo.io.l3.a$a, reason: collision with other inner class name */
    class RunnableC0410a implements Runnable {
        RunnableC0410a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a();
        }
    }

    public static void b() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Expected to be called on the main thread but was " + Thread.currentThread().getName());
        }
    }

    protected abstract void a();

    @Override // sdk.pendo.io.o3.b
    public final void dispose() {
        if (this.a.compareAndSet(false, true)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                a();
            } else {
                sdk.pendo.io.n3.a.a().a(new RunnableC0410a());
            }
        }
    }

    @Override // sdk.pendo.io.o3.b
    public final boolean isDisposed() {
        return this.a.get();
    }
}
