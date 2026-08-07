package sdk.pendo.io.n3;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.TimeUnit;
import sdk.pendo.io.k3.p;
import sdk.pendo.io.o3.c;

/* JADX INFO: loaded from: classes4.dex */
final class b extends p {
    private final Handler c;
    private final boolean d;

    private static final class a extends p.c {
        private final Handler a;
        private final boolean b;
        private volatile boolean c;

        a(Handler handler, boolean z) {
            this.a = handler;
            this.b = z;
        }

        @Override // sdk.pendo.io.k3.p.c
        public sdk.pendo.io.o3.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            if (this.c) {
                return c.a();
            }
            RunnableC0429b runnableC0429b = new RunnableC0429b(this.a, sdk.pendo.io.g4.a.a(runnable));
            Message messageObtain = Message.obtain(this.a, runnableC0429b);
            messageObtain.obj = this;
            if (this.b) {
                messageObtain.setAsynchronous(true);
            }
            this.a.sendMessageDelayed(messageObtain, timeUnit.toMillis(j));
            if (!this.c) {
                return runnableC0429b;
            }
            this.a.removeCallbacks(runnableC0429b);
            return c.a();
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            this.c = true;
            this.a.removeCallbacksAndMessages(this);
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return this.c;
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.n3.b$b, reason: collision with other inner class name */
    private static final class RunnableC0429b implements Runnable, sdk.pendo.io.o3.b {
        private final Handler a;
        private final Runnable b;
        private volatile boolean c;

        RunnableC0429b(Handler handler, Runnable runnable) {
            this.a = handler;
            this.b = runnable;
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            this.a.removeCallbacks(this);
            this.c = true;
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return this.c;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.run();
            } catch (Throwable th) {
                sdk.pendo.io.g4.a.b(th);
            }
        }
    }

    b(Handler handler, boolean z) {
        this.c = handler;
        this.d = z;
    }

    @Override // sdk.pendo.io.k3.p
    public p.c a() {
        return new a(this.c, this.d);
    }

    @Override // sdk.pendo.io.k3.p
    public sdk.pendo.io.o3.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        RunnableC0429b runnableC0429b = new RunnableC0429b(this.c, sdk.pendo.io.g4.a.a(runnable));
        Message messageObtain = Message.obtain(this.c, runnableC0429b);
        if (this.d) {
            messageObtain.setAsynchronous(true);
        }
        this.c.sendMessageDelayed(messageObtain, timeUnit.toMillis(j));
        return runnableC0429b;
    }
}
