package external.sdk.pendo.io.glide.request;

import android.graphics.drawable.Drawable;
import external.sdk.pendo.io.glide.load.engine.n;
import external.sdk.pendo.io.glide.request.target.Target;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import sdk.pendo.io.v.c;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
public class RequestFutureTarget<R> implements FutureTarget<R>, sdk.pendo.io.u.b<R> {
    private static final a DEFAULT_WAITER = new a();
    private final boolean assertBackgroundThread;
    private n exception;
    private final int height;
    private boolean isCancelled;
    private boolean loadFailed;
    private sdk.pendo.io.u.a request;
    private R resource;
    private boolean resultReceived;
    private final a waiter;
    private final int width;

    static class a {
        a() {
        }

        void a(Object obj) {
            obj.notifyAll();
        }

        void a(Object obj, long j) throws InterruptedException {
            obj.wait(j);
        }
    }

    public RequestFutureTarget(int i, int i2) {
        this(i, i2, true, DEFAULT_WAITER);
    }

    private synchronized R doGet(Long l) {
        if (this.assertBackgroundThread && !isDone()) {
            l.a();
        }
        if (this.isCancelled) {
            throw new CancellationException();
        }
        if (this.loadFailed) {
            throw new ExecutionException(this.exception);
        }
        if (this.resultReceived) {
            return this.resource;
        }
        if (l == null) {
            this.waiter.a(this, 0L);
        } else if (l.longValue() > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jLongValue = l.longValue() + jCurrentTimeMillis;
            while (!isDone() && jCurrentTimeMillis < jLongValue) {
                this.waiter.a(this, jLongValue - jCurrentTimeMillis);
                jCurrentTimeMillis = System.currentTimeMillis();
            }
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (this.loadFailed) {
            throw new ExecutionException(this.exception);
        }
        if (this.isCancelled) {
            throw new CancellationException();
        }
        if (!this.resultReceived) {
            throw new TimeoutException();
        }
        return this.resource;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        synchronized (this) {
            if (isDone()) {
                return false;
            }
            this.isCancelled = true;
            this.waiter.a(this);
            sdk.pendo.io.u.a aVar = null;
            if (z) {
                sdk.pendo.io.u.a aVar2 = this.request;
                this.request = null;
                aVar = aVar2;
            }
            if (aVar != null) {
                aVar.clear();
            }
            return true;
        }
    }

    @Override // java.util.concurrent.Future
    public R get() {
        try {
            return doGet(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public synchronized sdk.pendo.io.u.a getRequest() {
        return this.request;
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public void getSize(c cVar) {
        cVar.onSizeReady(this.width, this.height);
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.isCancelled;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        return this.isCancelled || this.resultReceived || this.loadFailed;
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target, sdk.pendo.io.r.b
    public void onDestroy() {
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public synchronized void onLoadFailed(Drawable drawable) {
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public void onLoadStarted(Drawable drawable) {
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public synchronized void onResourceReady(R r, external.sdk.pendo.io.glide.request.transition.a<? super R> aVar) {
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target, sdk.pendo.io.r.b
    public void onStart() {
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target, sdk.pendo.io.r.b
    public void onStop() {
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public void removeCallback(c cVar) {
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public synchronized void setRequest(sdk.pendo.io.u.a aVar) {
        this.request = aVar;
    }

    public String toString() {
        String str;
        sdk.pendo.io.u.a aVar;
        StringBuilder sb;
        StringBuilder sbAppend;
        String str2;
        String str3 = super.toString() + "[status=";
        synchronized (this) {
            if (this.isCancelled) {
                str = "CANCELLED";
            } else if (this.loadFailed) {
                str = "FAILURE";
            } else if (this.resultReceived) {
                str = "SUCCESS";
            } else {
                str = "PENDING";
                aVar = this.request;
            }
            aVar = null;
        }
        if (aVar != null) {
            sb = new StringBuilder();
            sbAppend = sb.append(str3).append(str).append(", request=[").append(aVar);
            str2 = "]]";
        } else {
            sb = new StringBuilder();
            sbAppend = sb.append(str3).append(str);
            str2 = "]";
        }
        return sbAppend.append(str2).toString();
    }

    RequestFutureTarget(int i, int i2, boolean z, a aVar) {
        this.width = i;
        this.height = i2;
        this.assertBackgroundThread = z;
        this.waiter = aVar;
    }

    @Override // java.util.concurrent.Future
    public R get(long j, TimeUnit timeUnit) {
        return doGet(Long.valueOf(timeUnit.toMillis(j)));
    }

    @Override // sdk.pendo.io.u.b
    public synchronized boolean onLoadFailed(n nVar, Object obj, Target<R> target, boolean z) {
        this.loadFailed = true;
        this.exception = nVar;
        this.waiter.a(this);
        return false;
    }

    @Override // sdk.pendo.io.u.b
    public synchronized boolean onResourceReady(R r, Object obj, Target<R> target, sdk.pendo.io.e.a aVar, boolean z) {
        this.resultReceived = true;
        this.resource = r;
        this.waiter.a(this);
        return false;
    }
}
